log4j {
//
appender.stdout = "org.apache.log4j.ConsoleAppender"    
appender."stdout.layout"="org.apache.log4j.PatternLayout"   
//
appender.scrlog = "org.apache.log4j.DailyRollingFileAppender"  
appender."scrlog.DatePattern"="'.'dd-MM-yyyy"
appender."scrlog.Append"="true" 
//Logdatei
appender."scrlog.File"="C:\Projekte\IKKClassic_Projekt4_SVN-Commit\SVN-Skript\log\SVNCommit.log"
appender."scrlog.layout"="org.apache.log4j.PatternLayout"
appender."scrlog.MaxFileSize"="1MB"
appender."scrlog.MaxBackupIndex"="1"
appender."scrlog.layout.ConversionPattern"="%d %5p %c{1} - %m%n"
// 
// Das Log-Level lässt sich mit dem ersten Parameter in
// rootLogger="info,scrlog,stdout" 
// ändern. Statt 'info' etwas anderes eintragen: 'debug', 'warn', 'error' ...
rootLogger="info,scrlog,stdout"     
}
