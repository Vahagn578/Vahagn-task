Task
1. Create an automation suite
2. Implement a logging mechanism before and after each test
3. Implement a retry mechanism to retry failing tests 3 times
4. Implement a smart wait mechanism to wait for an element before doing any action with it
5. Implement Jenkins pipeline, to run it from Jenkins

Solution.
1. For UI tests used selenium, testNG and for api test Karate framework, BDD syntax
2. For logs used log4j2 dependency
3. Implemented RetryAnalyzer class for rerunning failed tests
4. Added ExpectedConditions methods for all UI interactions
5. Added Jenkins file to the project
