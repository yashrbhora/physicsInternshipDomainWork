library(ggplot2)
library(ggforce)
library(dplyr)
setwd("D:/HDD Files/Desktop/Domain Duration/Raw Durations/E2")

thres1dDur<-read.table("durationsDay44.txt",header=TRUE)
thres2dDur<-read.table("durationsDay46.txt",header=TRUE)
filthres1<-thres1dDur %>% filter(Duration<=2000)
filthres2<-thres2dDur %>% filter(Duration<=2000)
breaks1<-seq(60,2000,by=200)
breaks2<-seq(60,2000,by=200)
duration1<-cut(filthres1$Duration,breaks1,right=FALSE)
duration2<-cut(filthres2$Duration,breaks2,right=FALSE)
freqtab1<-table(duration1)
freqtab2<-table(duration2)
x2<-seq(60,1800,by=200)
filTable2<-data.frame(x2,freqtab2)
head(filTable2)
filTable2<-filTable2%>%select(x2,Freq)
filTable2<-filTable2%>%filter(Freq!=0)


filTable1<-data.frame(x2,freqtab1)
filTable1<-filTable1%>%select(x2,Freq)
filTable1<-filTable1%>%filter(Freq!=0)

avg1<-round(mean(filthres1$Duration),digits = 3)
std1<-round(sd(filthres1$Duration),digits=3)
avg2<-round(mean(filthres2$Duration),digits = 3)
std2<-round(sd(filthres2$Duration),digits=3)



reg2=lm(log10(filTable2$Freq)~log10(filTable2$x2))
reg2
slope2<-coef(reg2)[2]
intercept2<-coef(reg2)[1]

reg1=lm(log10(filTable1$Freq)~log10(filTable1$x2))
reg1
slope1<-coef(reg1)[2]
intercept1<-coef(reg1)[1]

zeplot<-ggplot(filTable2,aes(x2,Freq)) + geom_point(color="Blue")
zeplot<-zeplot + xlab("log10(Domain Duration(s))") + ylab("log10(Count)") + labs(title="Distribution of Domain Durations",caption="April 5(Red) & 7(Blue),20%>10%")#,subtitle=paste("(",avg2,",",std2,")"," Slope:",slope2,", Intercept:",intercept2,sep=""))
zeplot<- zeplot + geom_point(data=filTable1,aes(x2,Freq),color="Red")
zeplotlog<-zeplot + geom_abline(slope = slope2, intercept=intercept2,lty=2,color="blue") + scale_x_continuous(trans = "log10") + scale_y_continuous(trans = "log10") 
zeplotlog<- zeplotlog + geom_abline(slope=slope1, intercept=intercept1,lty=2,color="red")

zeplotlog

avg1
std1
slope1
intercept1

avg2
std2
slope2
intercept2

newfil<-thres2dDur %>% filter(Duration<=400)
newbreaks<-seq(60,400,by=30)
newduration<-cut(newfil$Duration,newbreaks,right=FALSE)
newfreqtable<-table(newduration)
newx2<-seq(60,370,by=30)
newfilTable<-data.frame(newx2,newfreqtable)
newfilTable