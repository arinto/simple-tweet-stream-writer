simple-tweet-stream-writer
==========================

A simple tweet stream writer that writes the tweets' statuses from Twitter's [sample stream](https://dev.twitter.com/docs/api/1.1/get/statuses/sample) into a simple and ordinary text file.

To generate uber-jar:
`mvn package`

Once the uber-jar file is generated, put the uber-jar file together with these files in your working directory ($WORKING_DIR):
- `src/test/resources/twitter4j.properties` - note that please complete this file with your Twitter Authentication keys
- `src/test/resources/logback.xml` - default logback configuration, this configuration will write the resulting tweet stream to `$WORKING_DIR/log/write-tweet-stream.txt`
- `src/test/resources/execute.sh` - the script to execute this project
