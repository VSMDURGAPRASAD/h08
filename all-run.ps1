# 
# PowerShell Script to start up consumers and producers
# Uses Get-ChildItem cmdlet, and filters using the -Directory switch


Read-Host -Prompt "Start Apache Zookeeper. Press any key to continue or CTRL+C to quit" 

Read-Host -Prompt "Delete Kafka logs. Press any key to continue or CTRL+C to quit" 

Read-Host -Prompt "Start Apache Kafka. Press any key to continue or CTRL+C to quit" 

# start one default consumer
Start-Process -FilePath "powershell" -Verb runAs "java -cp KafkaAPIClient/target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Consumer test group1"

# start up many producers
Get-ChildItem  -Directory  | ForEach-Object { Write-Host "$_";
  cd $_; 
  Start-Process -FilePath "powershell" -Verb runAs ".\runp;" 
  cd ..; 
}