library(ggplot2)
library(ggforce)
library(dplyr)
setwd("D:/HDD Files/Desktop/Domain Duration")

thres1dDur<-read.table("Domain size thres1(28-35).txt",header=TRUE)
thres2dDur<-read.table("CompleteE2DomainDurations.txt",header=TRUE)
filthres1<-thres1dDur %>% filter(Duration<=1500)
filthres2<-thres2dDur %>% filter(Duration<=1500)
breaks1<-seq(60,1500,by=30)
breaks2<-seq(60,1500,by=30)
duration1<-cut(filthres1$Duration,breaks1,right=FALSE)
duration2<-cut(filthres2$Duration,breaks2,right=FALSE)
freqtab1<-table(duration1)
freqtab2<-table(duration2)
x2<-seq(60,1470,by=30)
filTable2<-data.frame(x2,freqtab2)
head(filTable2)
filTable2<-filTable2%>%select(x2,Freq)
filTable2<-filTable2%>%filter(Freq!=0)

avg2<-round(mean(filthres2$Duration),digits = 3)
std2<-round(sd(filthres2$Duration),digits=3)

newfil<-thres2dDur %>% filter(Duration<=400)
newbreaks<-seq(60,400,by=30)
newduration<-cut(newfil$Duration,newbreaks,right=FALSE)
newfreqtable<-table(newduration)
newx2<-seq(60,370,by=30)
newfilTable<-data.frame(newx2,newfreqtable)
newfilTable

reg=lm(log10(newfilTable$Freq)~log10(newfilTable$newx2))
reg
slope2<-coef(reg)[2]
intercept2<-coef(reg)[1]


zeplot<-ggplot(filTable2,aes(x2,Freq)) + geom_point(color="Blue")
zeplot<-zeplot + xlab("log10(Domain Duration(s))") + ylab("log10(Count)") + labs(title="Distribution of Domain Durations",caption="E2,20%>10%",subtitle=paste("(",avg2,",",std2,")"," Slope:",slope2,", Intercept:",intercept2,sep=""))

zeplotlog<-zeplot + geom_abline(slope = slope2, intercept=intercept2,lty=2,color="black") + scale_x_continuous(trans = "log10") + scale_y_continuous(trans = "log10") 
zeplotlog

