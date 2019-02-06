#!/bin/bash

if [ $# -lt 6 ]; then
	echo "Missing Arguments"
	echo "service_deployment.php NAME [REPLICAS=global|N] [PPORT] [CPORT] [NETWORK]"
	exit 0
fi

NAME=$1
REPLICAS=$2
HPORT=$3
CPORT=$4
IMAGE=$5
NETWORK=$6

if [ "$REPLICAS" = "global" ]; then
	MODE="global"
	REPLICA_CMD="--mode=${MODE}"
else
	MODE="replicated"
	REPLICA_CMD="--mode=${MODE} --replicas=${REPLICAS}"
fi

#docker service create --name redis --replicas 2 --publish 6379:6379 redi

echo "docker service create --name $NAME $REPLICA_CMD --publish $HPORT:$CPORT $IMAGE --network $NETWORK --restart-condition=on-failure --restart-max-attempts=3"

