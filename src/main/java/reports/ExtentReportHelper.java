package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportHelper {

    public static void main(String[] args) {



        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(new File("test.html"));
        extentReports.attachReporter(extentSparkReporter);
        ExtentTest test = extentReports.createTest("Test 1");
        test.createNode("Login Test", "Validate the login functionality").pass("Passed");




        extentReports.flush();
    }
}
