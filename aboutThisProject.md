Essentially I'm working with a space & plasma physics researcher Dr. David Ruffolo at Mahidol University. The main task I've been assigned is to analyze data from NASA's Parker Solar Probe(the closest probe to the sun) for an upcoming paper he's trying to publish. The type of data I'm analyzing is the magnetic field magnitude recorded by the various instruments on the probe. I believe the probe is currently in its 5th encounter or orbit around the sun. For the time being, I'm working with mainly the first and second encounters. We're especially interested in identifying areas of constant magnetic field magnitude with respect to time. It's more so exploratory data analysis, which means we're trying to make sense out of the data rather than testing a hypothesis.

The professor came up with a criteria to define these areas near-constant magnetic field magnitudes(which we call domains). The criteria is as follow:
1. Within any domain, the maximum and minimum magnitudes must fall within 20% of each other.(max-min<0.2*min)
2. To account for fluctuations, within any 600 consecutive data points, the maximum and minimum must fall within 10% of each other.
3. Finally, to be considered a domain, there must be at least 60 data points.

Note: Each data point refers to data taken 1-second intervals.

After explaining the criteria to me, my job was to program an algorithm that could filter out the data that fit the criteria and identify the domains.
Typically, in their lab, they use python to code. However, I had no python background whatsoever and so it was a challenge I faced at first. But then, I wondered if I could code this in Java.

I've written most of the code from scratch, though I did get some inspiration from online forums and sources. Currently, the code is a lot more complex than it used to be as its functionality has evolved. For instance, instead of simply identifying domains, it can also give summary statistics for using different thresholds or percentages in the criteria. Moreover, it can also give a summary of average durations of domains which was something my professor requested.

The java code produced data in table format, however, tables themselves don't tell much about the data. Therefore, to visualize the filteredData, I used R, a common programming language use for statistical analysis and data visualization. I've learned R using HarvardX's Data Science course on edX.org.

As of October 2020, we are working on preparing a paper using the trends and correlations the professor has found using the graphs and other data.
