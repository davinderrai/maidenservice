#!/bin/bash
# script to pull my current public IP address 
# and add a rule to my EC2 security group allowing me SSH access 

if [ $# -lt 2 ]; then
	echo "Missing Arguments";
	echo "update-aws-sgroup.sh PORT CIDR SECURITY_GROUP"
	exit -1;
fi

PORT=$1
SGROUP=$2

curl v4.ifconfig.co > ip.txt
awk '{ print $0 "/32" }' < ip.txt > ipnew.txt
export stuff=$(cat ipnew.txt)
echo "aws ec2 authorize-security-group-ingress --group-id $SGROUP --protocol tcp --port $PORT --cidr $stuff"

exit 0
