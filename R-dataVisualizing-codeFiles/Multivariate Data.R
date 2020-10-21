library(ggplot2)
library(ggforce)
library(dplyr)
setwd("D:/HDD Files/Desktop/Domain Duration/Raw Durations/E2")
n<- c(1,7,8,10,11,12,13,15,17,25,52,53,55,57,58,59,60,64,65,66,67,69,70,71,72,73,74,76,77,79,81)
n<-n-1
m<-seq(1:84)
m<-m [! m %in% n]
m
Day<-vector()
Slope<-vector()
Average<-vector()
StanDev<-vector()
Intercept<-vector()

for(i in m){
    thres2dDur<-read.table(paste("durationsDay",i,".txt",sep = ""),header=TRUE)
    filthres2<-thres2dDur %>% filter(Duration<=2000)
    breaks2<-seq(60,2000,by=200)
    duration2<-cut(filthres2$Duration,breaks2,right=FALSE)
    freqtab2<-table(duration2)
    x2<-seq(60,1800,by=200)
    filTable2<-data.frame(x2,freqtab2)
    filTable2<-filTable2%>%select(x2,Freq)
    filTable2<-filTable2%>%filter(Freq!=0)
    Day<-append(Day,i)
    Average<-append(Average,round(mean(filthres2$Duration),digits = 3))
    StanDev<-append(StanDev,round(sd(filthres2$Duration),digits=3))
    reg=lm(log10(filTable2$Freq)~log10(filTable2$x2))
    Slope<-append(Slope,coef(reg)[2])
    Intercept<-append(Intercept,coef(reg)[1])
}
dayVSslope<-data.frame(Day,Slope,Average,StanDev,Intercept)

zeplot<-ggplot(dayVSslope, aes(x=Day,y=Average))
zeplot
zeplot+geom_point() +geom_line(color="light blue",size=0.1)

zeplot<-ggplot(dayVSslope, aes(x=Day,y=Slope))
