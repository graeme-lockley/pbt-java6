#!/bin/bash

if [ "" == "$1" ]
then
	echo Provide a release
	exit -1
else
	git branch release-$1
	git checkout release-$1

	mvn versions:set -DnewVersion=$1 -Prelease
	mvn clean deploy -Prelease
fi

