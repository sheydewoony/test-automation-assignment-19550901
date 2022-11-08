package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenShot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "utility/screenshots/Actitime"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot captured");
		} catch (Exception e) {
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date currentDate = new Date();
		return format.format(currentDate);
	}	

}
