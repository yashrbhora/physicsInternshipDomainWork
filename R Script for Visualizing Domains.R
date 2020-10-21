library(dplyr)
library(ggplot2)
library(ggforce)
setwd("D:/HDD Files/Desktop/PSP Data")

data<-read.table("April5Data.csv",header=TRUE,sep = ",")
domain1<-read.table("Domains1.csv",header=TRUE, sep=",")
domain<-read.table("Domains2a.csv",header=TRUE,sep = ",")
domain15<-read.table("Domains2b.csv",header=TRUE,sep = ",")
zeplot<-ggplot(data, aes(x=Time,y=Magnetic.Field)) + geom_line(color="light blue",size=0.1) + geom_point(color="light blue",size=0.1)
zeplot<-zeplot + geom_point(data=domain1, aes(x=Time,y=Magnetic.Field.Magnitude), color="blue", size=0.1)
zeplot<-zeplot + geom_point(data=domain, aes(x=Time,y=Magnetic.Field.Magnitude), color="red", size=0.1)
zeplot<-zeplot + geom_point(data=domain15, aes(x=Time,y=Magnetic.Field.Magnitude), color="yellow", size=0.1)
zeplot<- zeplot + labs(caption="2019, April 57th(20%>10%)")
zeplot+facet_zoom(xlim=c(14000,26500))
zeplot + coord_cartesian(xlim=c(54250,54350))
zeplot

