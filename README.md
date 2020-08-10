# mars-air-2020
This repo contains my automation solution for Mars Airs web application and all testing artifacts created for this
project

Application's documentation can be found here: https://marsair.thoughtworks-labs.net/mission.html
 
The instructions on how to set up and run this project is here in this readme file.

## **Instructions:**
This project can run on Windows, Mac and Linux, please follow the steps below to set up according to your OS:

1. Go to the DriverFactory class on: /src/test/java/manager/DriverFactory.java
2. On the method "getDriver", remove the comment ("//") from the line which matches your OS and keep the other OS lines
commented (with "//")
3. Now, you just need to run the class CucumberRunner under /src/test/java/runner/CucumberRunner.java for having all the tests executed

Note: If you have problems with Chromedriver, it might be because your browser version does not match with the driver version.
In this case, please check your browser version and download the equivalent driver at: https://chromedriver.chromium.org/downloads
and replace it in the folder:

**MAC:** src/resources/chromedriver/macos

**WINDOWS:** src/resources/chromedriver/windows

**LINUX:** src/resources/chromedriver/linux

## **Testing Artifacts:**
All testing artifacts can be found at:

- Test Cases document: https://tinyurl.com/y3ocwvjn
- Bug Tracking document: https://tinyurl.com/y49t2tjk
- Testing Approach document: https://tinyurl.com/y3n3d5bm