package JUnit;

import org.junit.runner.JUnitCore;

public class KeseProbaTestRunner {
    public static void main(String[] args) {
        org.junit.runner.Result result = JUnitCore.runClasses(KeseProbaTest.class);
        for (org.junit.runner.notification.Failure failure : result.getFailures()) {
           System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }    
}
