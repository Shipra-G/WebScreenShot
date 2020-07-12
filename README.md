"# WebScreenShot" 

Prerequisite --


chromedriver.exe
1) Create a folder named driver.
2) Add the chromedriver.exe from https://sites.google.com/a/chromium.org/chromedriver/downloads and place the chromedriver.exe under driver folder




Go to project root folder 

set the java home path
set path to chrome driver 
mvn clean install

or 
Just run the setup bat file attached  


mvn-root:run

test rest api 
curl http://localhost:8080/screenshots?url=http://wikipedia.org


