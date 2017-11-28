#!/bin/bash

num=$((RANDOM % 6))

if [[ $num == 0 ]]; then
	echo "You died"
else
	echo "You lived"
fi