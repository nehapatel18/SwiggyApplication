package ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class extentReports {
    public  static  void main(String[]args){
        String pathOfProject=System.getProperty("user. dir");
        ExtentReports extentReportsObj = new ExtentReports(pathOfProject+"/extentReport.html");

        ExtentTest extentTestObj =extentReportsObj.startTest("Test 1");

        extentTestObj.log(LogStatus.INFO," test info");
        extentTestObj.log(LogStatus.PASS," test pass");



        extentReportsObj.endTest(extentTestObj);

        extentReportsObj.flush();

    }
}


