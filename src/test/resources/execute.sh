#!/bin/bash

DURATION=$1 
WRITER_CP=".:stream-tweet-writer-0.0.1-SNAPSHOT-jar-with-dependencies.jar"

java -DLOG_NAME="write-tweet-stream" -cp $WRITER_CP main.WriteTweetStream $DURATION
