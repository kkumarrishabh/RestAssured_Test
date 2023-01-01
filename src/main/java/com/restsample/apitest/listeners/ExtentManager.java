package com.restsample.apitest.listeners;
import java.time.LocalDateTime;
import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	 
    public synchronized static ExtentReports getReporter() {
    	LocalDateTime myObj = LocalDateTime.now();
        String str = myObj.toString().replace(":","").replace(".","").replace("-","");
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                extent = new ExtentReports(workingDir + "\\ExtentReports\\Output"+ str +".html", true);
                extent.loadConfig(new File(workingDir + "\\extent-config.xml"));
            }
            else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                extent = new ExtentReports(workingDir + "/ExtentReports/Output"+ str +".html", true);
                extent.loadConfig(new File(workingDir + "/extent-config.xml"));
            }
        }
        return extent;
    }
}
