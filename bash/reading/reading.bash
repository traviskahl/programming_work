#!/bin/bash

echo "Enter SSID: "
read SSID
echo "Enter passphrase (leave blank for none)"
read PASS

ERROR_OUTPUT="Passphrase must be 8..63 characters"

if [[ -z $PASS ]]; then
	echo -e "network={\n\tssid=\"$SSID\"\n\tkey_mgmt=NONE\n}\n" | tee -a networks.txt
else
	FILE_OUTPUT=$(wpa_passphrase "$SSID" "$PASS")
	if [[ "$FILE_OUTPUT" == "$ERROR_OUTPUT" ]]; then
		echo "Error: Passphrase must be between 8 and 63 characters."
		exit 1
	else
		echo -e "$FILE_OUTPUT\n" | tee -a networks.txt
	fi
fi

exit 0