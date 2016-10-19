TO BE ABLE TO RUN THE TEST, YOU'LL NEED:
- Java SE JDK (the latest is preferable, but it was written and tested with 8u101)
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

- Eclipse or other IDE (You can compile and run it manually, but Eclipse is free and easier that way)
I used Mars version of Eclipse: https://www.eclipse.org/downloads/packages/release/Mars/2
But there is a newer, which is called Neon: https://www.eclipse.org/downloads/eclipse-packages/

- Used Selenium standalone server, no need to download, it's in the lib dir.

- Geckodriver: It's already in the lib folder, and I set the path in the test.

- You'll also need a Firefox. I tested my automation test with Firefox v49.0.1, but it should run well with any newer version.

- For the Cucumber version, you'll need:
cucumber-core, cucumber-java, cucumber-junit (these three needs to be the same version),
cucumber-jvm-deps, cucumber-reporting, cobertura, gherkin, mockito, junit
I attached these files to the DoclerQAProject/lib folder, so no need to download any of these.

- Junit is also need in the other version for running as junit. It might be imported by default to the Eclipse, but if it's not you can find it in the DoclerQAProject/lib folder

WHAT YOU NEED TO DO IN ORDER TO RUN THE TEST:
Check the build path by right clicking on the project folder in your IDE (DoclerQAProject or DoclerQATest).
Hover on the Build path, and select Configure Build Path option.
Java Build Path should be highlighted in the left section, and you should select the Libraries tab in the main section of the panel.
Check if every necessary jar is imported to the build path or not:

For cucumber: selenium-server-standalone, ucumber-core, cucumber-java, cucumber-junit,
cucumber-jvm-deps, cucumber-reporting, cobertura, gherkin, mockito, junit

For the basic test: selenium-server-standalone

If something is missing, click on the Add JARs... button, go to the project's lib folder (for example: DoclerQAProject/lib),
select the missing jar, and click OK. If you added every missing jar, click Apply, and OK.

If everything is alright, just click OK.

HOW CAN YOU RUN THE TESTS:

Basic test:
Open DoclerQATest folder in the left panel of your Eclipse. Open src folder.
Open com.pack.common.test package.
Right click on DoclerQATest.java, hover over the Run As option, and select JUnit test.

Cucumber test:
Open DoclerQAProject folder in the left panel of your Eclipse. Open src folder.
Open com.pack.common.test package.
Right click on TestRunner.java, hover over the Run As option, and select JUnit test.

A Firefox browser should pop up, and it should run the test steps.
After the test ran, you can see the JUnit report about how many tests were succesful, and failed.

If you have any issue initializing any of the tests, please send me an e-mail about the issue,
what does the console says (bottom of the IDE), what JUnit errors show, and I'll try to help you.

E-mail address: daniel.erdos87@gmail.com

INTERESTING PARTS OF THE TESTS:

DoclerQAProject: This one is the POM-Cucumber-java test. It has a feature folder, with a feature file in it, which
controls the test cases similar style like Gherkin.
The StepDefinition.java file contains all the java code which applied during the test.
The TestRunner.java connects the feature file and the StepDefiniton file, so it gives the test the logic.
The different PageObject files contain all the page objects used in the test, and also most of the functions, methods.

DoclerQATest: This is the POM-java test. Similarly it has it's own PageObject files.
The SetupTest.java contains the environment and driver setup for the test, and also the teardown of the driver, deleting the cookies and closing the browser logic.
The DoclerQATest.java contains all the java code with the functions, and basically the tests.
It uses JUnit's @Test tag method to differentiate between the testcases.


ADDITIONAL COMMENTS:
- The tests could use a bit more polishing. Implicit wait time should be used more often, but it caused some WebDriver problems, which could take more time to figure out,
so I used those where I could, and other places just used Classic sleep (which works well, just using a bit more time for the test).
- PageFactory method could also be used, but I'm not entirely familiar with it, and didn't want to waist a couple of days of figuring-out-refactoring-debugging.
- The tests ran successfully almost every time for me. There were a couple of times, when failed during the Error page part with an issue that the page element is stale.
It's most likely a timing issue (tries to find an element after moving to another page), gave it a bit more sleep, after that it didn't fail once, but it can happen.

Happy testing!