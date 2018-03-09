# Customized Kafka-Enabled App

Set Up Environment:
Clone h08 repo 
Run PowerShell as Admin and exicute following command
1)choco install apache-zookeeper -y
2)choco install kafka -y
3)choco install maven -y

Configure environment variables

[Environment]::SetEnvironmentVariable("ZOOKEEPER_HOME", "C:\Tools\zookeeper-3.4.9", "Machine")
[Environment]::SetEnvironmentVariable("KAFKA_HOME", "C:\ProgramData\chocolatey\lib\kafka\tools\kafka_2.11-1.0.0", "Machine")

Edit System Path
%ZOOKEEPER_HOME%\bin;
%KAFKA_HOME%\bin;
%KAFKA_HOME%\bin\windows;

Starting Zookeeper:
Configure Zookeeper
Create the required zoo.cfg. In C:\Tools\zookeeper-3.4.9\conf, copy zoo_sample.cfg to zoo.cfg

Start Zookeeper:
Run following command in powershell by opening as administrator
zkServer

Start Kafka :
Run the command in command windows
Remove-Item –path C:\tmp\kafka-logs –recurse
kafka-server-start C:\ProgramData\chocolatey\lib\kafka\tools\kafka_2.11-1.0.0\config\server.properties

Create the KafkaAPIClient Executable Jar
Executable command
mvn clean compile assembly:single

Start the Default Consumer
open gitBash command and exicute following command

java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Consumer test group1

Start the Default Producer
open gitBash command and exicute following command

java -cp target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Producer test

Start The Kafka Meduri CustomProducer
java -cp target/KafkaCase-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.kafka.CustomProducer

