# H08 - Java Kafka

# Customized Kafka-Enabled App

# S528763 - Aditya Srimat Tirumala Pallerlamudi

My application is 'KafkaSTPMyProducer'

Steps to run:
1. Run Zookeeper server in C: (anywhere, as it was installed globally)
'zkServer'
2. Run Kafka server in Kafka installed folder (Here, C:\kafka_2.11-1.0.0)
.\bin\windows\kafka-server-start.bat .\config\server.properties
3. Create the KafkaAPIClient Executable Jar (Run this command inside KafkaAPIClient folder)
mvn clean compile assembly:single
4. Start the Default consumer and producer apps in different command windows:
java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Consumer test group1
java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Producer test
5. Type any content in producer and verify it in consumer command window.
6. Run your custom producer linked with run.properties
java -cp target/KafkaSTP-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.stp.kafka.CustomProducer
7. Verify the tweets of the respective user profile in the Consumer console.

For more usage of application, change the 'TWITTER_USER' to any other profile and erify the tweets. Have fun.

Useful links:
1. twitter.com
2. apps.twitter.com

Thank you. Happy Coding :-)