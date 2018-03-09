# Kafka CustomProducer

1. Start_zookeeper.bat
 in powerShell as adminstrator 
zkserver


2. Start_kafka.bat
.\bin\windows\kafka-server-start.bat .\config\server.properties in powerShell as adminstrator

3. In h08 flder using Git Bash Here do maven clean using 
mvn clean compile assembly:single

4. Run Producer and consumer in KafkaAPIClient using
For Consumer:
java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Consumer test group1
For Producer:
java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Producer test

5. Run Producer of KafkaKamani using
java -cp target/KafkaCase-1.0-SNAPSHOT-jar-with-dependencies.jar kamani.CustomProducer

