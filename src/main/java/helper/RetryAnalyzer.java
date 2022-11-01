package helper;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int counter = 1;
    int retryLimit = 3;

    public boolean retry(ITestResult result) {
        System.out.println(result);
        if(!result.isSuccess()){
            if(counter < retryLimit)
            {
                counter++;
                result.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                result.setStatus(ITestResult.FAILURE);
            }
        }
        else{
            result.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}