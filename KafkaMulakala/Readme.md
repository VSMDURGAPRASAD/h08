# Customized Kafka-Enabled App

1. Run zookeeper
   zkserver

2. Start the consumer

    mvn clean compile assembly:single

	java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Consumer test group1
 
3. Start the Producer

	mvn clean compile assembly:single

	Run "runp.bat"

4. Verify the messages are output by the Consumer.

