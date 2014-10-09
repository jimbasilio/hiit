HIIT (High Intensity Interval Training) Timer Application.

HIIT Timer will have an angular front-end for saving/loading HIIT programs.  
Programs will be able to have X intervals for Y seconds each with Z groupings of intervals.
The UI will be HTML5 and have offline capabilities to be able to run without connectivity to the network.  When connectivity is reestablished any changes made should be able to be saved to the cloud.  

MUST PASS ARGUMENT TO JVM TO SELECT ACTIVE PROFILE:
user@machine:~/your/projects$ mvn clean package
user@machine:~/your/projects$ java -Dspring.profiles.active=hsqldb -jar target/com.basilio.hiit-0.0.1-SNAPSHOT.jar


Todo:
* MVC integration tests
* protractor tests
    
Done:
* MVC JSON RPC skeleton
* have multiple profiles for 2 different database providers (HSQL and H2)
    * works now.  can set profile at will in application.properties to use h2db or hsqldb independant of dev/prod setting.
* simple angular shell front-end.. works but no frills yet!


NOTES: 
* painful lesson learned.  on ubuntu you can't have 'node' and 'nodejs' installed or bower (and probably other things) won't work.  'sudo apt-get autoremove node' and everything should work.  (https://github.com/bower/bower/issues/475)
* NOTE ABOUT THE NODE NOTE!!  Apparently ubuntu packages don't always link 'node' to 'nodejs'.  You can manually create this link if you are getting a '/usr/bin/env: node: No such file or directory' error.  Run 'sudo ln -s /usr/bin/nodejs /usr/bin/node' and it'll create a link to the nodejs app which will then allow bower to run.  I don't understand the packaging issues .. but I'm moving on from it.
