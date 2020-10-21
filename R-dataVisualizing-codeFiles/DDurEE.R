library(dplyr)
library(ggplot2)
library(ggforce)
setwd("D:/HDD Files/Desktop/Domain Duration")
#day 42-45
thres1dDur<-read.table("CompleteE1DomainDurations(1Thres).txt",header=TRUE)
thres2dDur<-read.table("CompleteE1DomainDurations.txt",header=TRUE)
avg1<-mean(thres1dDur$Duration)
std1<-sd(thres1dDur$Duration)
avg2<-mean(thres2dDur$Duration)
std2<-sd(thres2dDur$Duration)
zeplot<-ggplot(thres1dDur,aes(x=Duration)) + geom_histogram(binwidth = 300,fill="light blue",col="black")
zeplot<- zeplot + xlab("Duration(sec)") + labs(title="Distribution of Domain Durations",caption="E1,20%",subtitle=paste("(",avg1,",",std1,")",sep=""))
zeplot2<-ggplot(thres2dDur,aes(x=Duration)) + geom_histogram(binwidth=60,fill="light blue",col="black")
zeplot2<- zeplot2 + xlab("Duration(sec)") + labs(title="Distribution of Domain Durations",caption="E1,20%>10%",subtitle=paste("(",avg2,",",std2,")",sep=""))
zeplot
zeplot2
zeplot2 + coord_cartesian(xlim=c(0,2000))
