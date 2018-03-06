# 
# PowerShell Script to generate all our jar files 
# Uses Get-ChildItem cmdlet, and filters using the -Directory switch

Get-ChildItem  -Directory  | ForEach-Object { Write-Host "$_";
  cd $_; mvn clean compile assembly:single; cd ..; 
}
