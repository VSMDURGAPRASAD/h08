# Customized Kafka-Enabled App


1.Use the zkserver command to start the zookeeper in the command prompt or powerShell window.

2.In the kafka folder using the below command start the kafka server using command prompt 
.\bin\windows\kafka-server-start.bat .\config\server.properties

3.After running both the servers, minimize them.

4.Start the Consumer from  kafkaAPIClient folder inside the h08 folder
To create an executable JAR file using maven,run the command "mvn clean compile assembly: single" in git bash.
Next Consumer is started by running the start-c bat command.

5.Then start Producer from kafkaAPIClient folder, by using start-p bat command.
Producer and Consumer should be communicating with each other,check that.

6.Start the Custom producer
open a GitBash window in your kafkaPala folder.
run the command clean compile assembly:single
run runp.bat command to start the custom producer.

7.After all this the tweets should be generated on the twitter user profile given in run.properties file.
Verify if the twitter messages are being generated and communicating in both Consumer and Producer.