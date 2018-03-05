# Customized Kafka-Enabled App

Big data messaging with Kafka

We have designed two custom producer named CustomProducer and Twitter Producer.
Custom Producer : Generates random string of length n
Twitter Producer: Fetch all the post from provided page name

1. Start the consumer

 > cd Custom-Producer-app\KafkaAPIClient

 > mvn clean compile assembly:single

 > java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Consumer test group1
 
2. Start the Producer

 To start custom producer 
 
 > Open command prompt and run "cd KafkaAgrawal"

 > mvn clean compile assembly:single

 > Run "runp.bat"
  
 To start twitter producer 
 
 > Open command prompt and run "cd KafkaAgrawal"
  
 > mvn clean compile assembly:single
  
 > Run "run-twitter-producer.bat"

3. Producer window will show the generated strings.

4. Verify the messages are output by the Consumer.

