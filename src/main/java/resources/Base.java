package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	String browsername, projdir;
	public Properties prop;

	public WebDriver InitializeBrowser() throws IOException {
		
		projdir = System.getProperty("user.dir");
		
		System.out.println(projdir);
		
		FileInputStream fis = new FileInputStream(projdir +"\\src\\main\\java\\resources\\data.properties");

		prop = new Properties();
		prop.load(fis);
		browsername = prop.getProperty("browsername");

		if (browsername.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browsername.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browsername.equalsIgnoreCase("internet"))
			driver = new InternetExplorerDriver();
		else if (browsername.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		
		return driver;

	}

	public void takeScreenshot(String testname, WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String OutputFilePath=System.getProperty("user.dir")+"\\Screenshot\\"+testname+".png";
		
		System.out.println(OutputFilePath);
		
		FileUtils.copyFile(src, new File(OutputFilePath));
		
	}
}
