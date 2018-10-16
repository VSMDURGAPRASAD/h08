# H08 - Java Kafka & Install Spark

## Complete Java Kafka Exercise

Read the article here: https://www.javaworld.com/article/3060078/big-data/big-data-messaging-with-kafka-part-1.html

Goal: Create a new CustomProducer to auto-generate and send at least 10 messages to the topic. You can create a random word generator, cycle through a list sending one message every second, or use Facebook or Twitter APIs to access live content. Experiment - the goal is to be comfortable adding external messaging to any Java app.

## Design and Implement a Custom Producer App

1. Plan and design a routine to create messages without user typing. 
You may use an array of messages, generate them randomly, or access a public API. 
If you want to test the CaseKafka example that accesses Twitter data, 
you'll need to follow the Twitter guides below and create your custom 
src/main/resources/twitter4j.properties file. 

2. Implement your Custom Producer app.

3. Compile and build a new executable jar with maven using the mvn clean compile assembly:single command. 

4. Start your consumer using a custom java -cp command (short for 'classpath').

5. Verify your messages are output by the Consumer.

6. Create a professional README.md file to explain how to setup and run your project.

7. Put your entire code solution in a repo and share a clickable link.

## Prerequisities

* JDK8
* Zookeeper
* Kafka
* Maven

Configure environment variables for easy access. Create the following - use your path. 

```Bash
JAVA_HOME
ZOOKEEPER_HOME
KAFKA_HOME
```

System Path should include

```Bash
%JAVA_HOME%\bin
%KAFKA_HOME%\bin
%KAFKA_HOME%\bin\windows
%ZOOKEEPER_HOME%\bin
```

## Reference

See <https://bitbucket.org/professorcase/h07>.

## Configure Zookeeper

Create the required zoo.cfg. In C:\Tools\zookeeper-3.4.9\conf, copy zoo_sample.cfg to zoo.cfg.

## Start Zookeeper Service

Start the Zookeeper service. Keep the window open.

## Start Kafka Service

Start the Kafka service. Keep the window open.

## Create KafkaAPIClient Executable

1. Clone the Maven project from the article into h08. Explore the Maven pom file and the Java code for the Producer and Consumer.
2. Open a PowerShell window in the *KafkaAPIClient* folder, compile the code using Maven and create an executable jar file. Generated artificacts can be found in the new 'target' folder.

```PowerShell
mvn clean compile assembly:single
```

## Create KafkaCase Executable

1. Open a PowerShell window in the *KafkaCase* folder, compile the code using Maven and create an executable jar file. Generated artificacts can be found in the new 'target' folder.

```PowerShell
mvn clean compile assembly:single
```

## Start the Default Consumer App

Open a PowerShell window in the *KafkaAPIClient* folder, start the original consumer app using topic test and group1 with:

```PowerShell
java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Consumer test group1
```

## Start the Default Producer App

Open another PowerShell window in the *KafkaAPIClient* folder, start the Producer app using topic test:

```PowerShell
java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Producer test
```

## Test Communications

1. Type some messages for the Producer.
1. Verify the messages are output by the Consumer.

## Start The Kafka Case Producer app

Open another PowerShell window in the *KafkaCase* folder, and run:

```PowerShell
java -cp target/KafkaCase-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.isl.professorcase.kafka.CustomProducer
```

OR for convenience, there's a batch file to run this CustomProducer.
Open a PowerShell window here and run:

```PowerShell
.\runp
```

## Start Your Custom Producer app

Using your own custom package, create your custom producer. Compile and build the updated jar. Using the java -cp command, start your producer as well.

Monitor the results in the consumer app.

## Accessing Twitter with Code

See http://www.baeldung.com/twitter4j

For help registering your Twitter API see this Tweepy article: http://www.compjour.org/tutorials/getting-started-with-tweepy/

Register app: 
https://apps.twitter.com

Developer Agreement: 
https://developer.twitter.com/en/developer-terms/agreement-and-policy

Twitter App Attributes Example:

- Name: KafkaCaseCustomProducer
- Description: Sample app to illustrate working with the Twitter API and using Kafka from a Java application
- Website: https://bitbucket.org/professorcase/h08
- Callback URL: (blank)

## Working with Kafka

To list topics, open PowerShell as admin and run:

```PowerShell
kafka-topics.bat --list --zookeeper localhost:2181
```

To delete a topic (e.g. test), open PowerShell as admin and run:

```PowerShell
kafka-topics.bat --zookeeper localhost:2181 --delete --topic test

To describe a topic (e.g. test), open PowerShell as admin and run:

```PowerShell
kafka-topics.bat --describe --zookeeper localhost:2181 --topic test
```

To view the messages on a topic (e.g. test), open PowerShell as admin and run:

```PowerShell
kafka-console-consumer.bat --zookeeper localhost:2181 --topic test --from-beginning
```

To list the groups, open PowerShell as admin and run:

```PowerShell
kafka-consumer-groups.bat --zookeeper localhost:9092 --list
```

## See also

http://cloudurable.com/blog/kafka-tutorial-kafka-producer/index.html