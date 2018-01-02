#!/bin/bash
# a script to test my internet speed and record it in a file
# hopefully in the future, one can analyze this information with another program

# initializations
SPDREC_REPFILE="num.txt"
SPDREC_LOGFILE="speeds.log"

# keep track of repetitions
reps=$((`cat $SPDREC_REPFILE`+1))
echo $reps > $SPDREC_REPFILE

# log the number of the test and the time it's done
echo -n "Speed test #$reps: `date "+%a %m %b, %H:%M:%S"`, " >> $SPDREC_LOGFILE

# log the connection: wired or wireless
if tail -n+3 /proc/net/wireless | grep -q .; then
	echo "Wireless" >> $SPDREC_LOGFILE
else
	echo "Wired" >> $SPDREC_LOGFILE
fi

# now we can do our speed test
speedtest >> $SPDREC_LOGFILE

# tell the log this repetition is done
echo "Done." >> $SPDREC_LOGFILE

exit 0