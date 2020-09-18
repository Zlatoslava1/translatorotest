# translatorotest
<b>translatorotest</b> is Java Maven project that tests the next functions of google translator with Google Chrome browser using Selenium Webdriver framework:
<ul type="disc"> 
  <li>automatic language recognition for two languages</li>
  <li>manual language picker</li>
  <li>Language exchange option</li>
  <li>delete text option</li>
</ul>

Not included test of :
TBD: 
<ul type="disc"> 
<li>document translation functionality</li>
</ul> 

Current application can test only English interface of google translator.

<b>To run the application you should do the next: </b>
<ol>
  <li> Download(if needed) and open  Google Chrome browser.  </li>
  <li> Go to Settings > Advanced. Expand Language bar. </li>
  <li> Add (if needed) English and infront of it choose "Offer to translate pages in this language". </li>
  <li> On the left menu choose "About Chrome" and note the version of the application that you have. It is needed for an appropriate version of chromedriver. </li>
  <li> Download (if needed) Git Bash.</li>
  <li> Download java 8 JDK (if needed) https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html</li>
  <li> Set up JAVA HOME variable with the path to JDK. </li>
  <li> Open git bash, switch to some folder and download current repository be entering to the Git Bash terminal the command: </li>
    <br> <b>git clone https://zlatoslava1@bitbucket.org/zlatoslava1/translatorotest.git </b>
  <li> Download Intellij Idea https://www.jetbrains.com/idea/download/ if needed. Eclipse also can be used</li>
  <li> Open Intellij Idea. Choose import/open project and choose the folder with the project that you had dowloaded. </li>
  <li> Because it is a Maven project it should dowloaded libraries that are used in the project. Make sure you see a Maven tab in the right side of the Intellij Idea window.</li>
  <li> In the project go to translatorotest\src\test\java\webUiTests folder and click on it with the right mouse button and choose "Run 'Tests in 'webUiTests''".</li>
</ol>

Let me know if you have any problem.
