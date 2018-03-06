# 
# PowerShell Script to generate all our jar files 
# Uses Get-ChildItem cmdlet, and filters using the -Directory switch

Get-ChildItem  -Directory  | ForEach-Object { Write-Host "$_";
  cd $_; mvn clean compile assembly:single; cd ..; 
}
java -cp KafkaAPIClient/target/KafkaAPIClient-1.0-SNAPSHOT-jar-with-dependencies.jar com.spnotes.kafka.simple.Consumer test group1