package com.org.dapps.tinAuto;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShot {
	
public static String capture(WebDriver Driver) throws IOException {
		
		TakesScreenshot screen = (TakesScreenshot)Driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String screenLocation = ".\\screenShots\\"+src+new SimpleDateFormat("yyMMddhhmmss").format(new Date())+".jpeg";
		File dest = new File(screenLocation);
		FileUtils.copyFile(src, dest);
		return screenLocation;

		}
}
