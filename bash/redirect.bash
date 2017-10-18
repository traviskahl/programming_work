#!/bin/bash

COMMAND=ls

function print_options {
	echo -e "Valid options are:"
	echo -e "\t-n\t\tSend output to /dev/null"
	echo -e "\t-s\t\tSend output to standard output"
	echo -e "\t-f\t\tSend output to a specified file"

	exit 1
}

if [[ -z "$1" ]]; then
	echo "You need at least one argument."
	print_options
fi

case $1 in
	-n) # redirect to /dev/null
		$COMMAND > /dev/null
		;;
	-s) # redirect to standard output
		$COMMAND
		;;
	-f) # redirect to arbitrary file
		$COMMAND > $2
		;;
	*)	echo "I don't understand that argument."
		print_options
		;;
esac