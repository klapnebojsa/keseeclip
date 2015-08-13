package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.net.httpserver.Authenticator.Failure;

public class KeseProbaTestRunner {
    public static void main(String[] args) {
        org.junit.runner.Result result = JUnitCore.runClasses(KeseProbaTest.class);
        for (org.junit.runner.notification.Failure failure : result.getFailures()) {
           System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }    
}
