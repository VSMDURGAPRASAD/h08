Messaging with Kafka

I have designed a Custom Producer and Custom Consumer for sending messages 

I have created a user Interface for entering number and you can find what messages it returns in Producer file.

1. Start your ZooKeeper services using the command: zkServer

2. Start your kafka server using the command: kafka-server-start.bat C:\ProgramData\chocolatey\lib\kafka\tools\kafka_2.11-1.0.0\config\server.properties

Both of these should be running simulatiously and must lasst untill you are done with your messaging.

3. Start the consumer
 
 	 > Open GitBash or cmd from kafkaPuvvada folder
 
 	 > mvn clean compile assembly:single
 
 	 > java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Consumer test group1
  
 2. Start the Producer
 
 	 To start custom producer 
 	 
 	 > Open another GitBash or cmd from kafkaPuvvada folder
 
 	 > java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Producer test

3. Enter the numbers you want to write in Consumer Window and the Producer Window will display the outcome.

4. Have FUN!!