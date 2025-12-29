QUALITY ENGINEER (QE) – AUTOMATION DEVELOPMENT CHALLENGE
abbank-test technical automation test

1. Over View:
Project is using for test example
- UI Automation with Selenium
- API Automation with (Rest API)
- BDD with Cucumber
- Test execution with TestNG
- Code by Java program langue

2. Set up intructions :
+src:
- main/java/utils/ApiClient.java        # Reusable API client
- test:
  +java: 
    - apitest                    # Step definitions + runner API
    - uitest                     # Step definitions + runner UI
    - keyworld                  # Common keywords 
  +resources
    - features
       + api                   # Feature files cho API
       + ui                    # Feature files cho UI
3. Requirement:
- Java 17+
- Maven 3+
- IDE (IntelliJ / VS Code / Eclipse)
4. Run Test case :
- Run All TC :  ~> mvn test
- Run UI TC : mvn test "-Dcucumber.filter.tags=@ui"
- Run API TC :  mvn test "-Dcucumber.filter.tags=@api"
Or Can run on IDE file Runner.

Thank for Reading
