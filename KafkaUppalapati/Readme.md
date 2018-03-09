# Customized Kafka-Enabled App

1. Run the ZooKeeper server using zkserver command in the PowerShell window.

2. Start the Kafka server using the below command in Kafka folder using command prompt
.\bin\windows\kafka-server-start.bat .\config\server.properties
After running both these servers, minimize them.

3. In H08, KafkaAPIClient folder
To create an executable JAR file using maven, run the command "mvn clean compile assembly:single" in git bash.
Start the Consumer by running start-c.bat command

4. Start the Producer from KafkaAPIClient folder, by running start-p.bat command.
Check if producer and consumer are communicating.

5. Start the Custom producer 
open another GitBash in the KafkaUppalapati folder.
run mvn clean compile assembly:single
run runp.bat command to start the custom producer.

Verify if the tweets are being generated based on the twitter user profile given in run.properties file.