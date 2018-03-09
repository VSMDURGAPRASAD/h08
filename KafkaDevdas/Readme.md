## Complete Java Kafka Exercise

Read the article here: https://www.javaworld.com/article/3060078/big-data/big-data-messaging-with-kafka-part-1.html

Create a new CustomProducer to auto-generate and send at least 10 messages to the topic. You can create a movie review generator.


## Set Up Tools

Run PowerShell as Admin and use Chocolatey to install zookeeper, kafka, and maven (verify by checking C:\ProgramData\chocolatey\lib and C:\tools).

```PowerShell
choco install apache-zookeeper -y
choco install kafka -y
choco install maven -y
```

Configure environment variables for easy access. Create the following - use your path. 
-ZOOKEEPER_HOME = C:\Tools\zookeeper-3.4.9
- KAFKA_HOME = C:\ProgramData\chocolatey\lib\kafka\tools\kafka_2.11-1.0.0

## Execute Java Sample

```PowerShell 
mvn clean compile assembly:single
```


```PowerShell
java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Consumer test group1
```



```PowerShell
java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Producer test
```

