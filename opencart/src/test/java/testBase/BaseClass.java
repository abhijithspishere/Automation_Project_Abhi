package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public WebDriver driver;

public static Logger logger = LogManager.getLogger(BaseClass.class);

/* public Properties p; */

	@BeforeClass
	@Parameters({"os","browser"})
	public void setup( String os, String br) throws IOException
	{
		
		//loading properties file
		
		/*
		 * FileReader file = new
		 * FileReader(".//src//test//resources//config.properties"); p=new Properties();
		 * p.load(file);
		 */
		 
		/*
		 * try { FileReader file =
		 * newFileReader(".//src//test//resources//config.properties"); p =
		 * newProperties(); p.load(file); } catch (IOException e) { // Handle the
		 * exception here. For example, log a message or set a default value for appURL.
		 * logger.error("Failed to load config.properties file", e); }
		 */
		 
		
		//loading Log4j file
//		logger = LogManager.getLogger(this.getClass());
		
		
		//Launching browser based on condition
		switch(br.toLowerCase())
		{
		case "chrome" : 
			driver = new ChromeDriver();
			break;
		case"edge": 
			driver = new EdgeDriver();
			break;
		default: 
			System.out.println("No Matching Browser");
		return;
		}
		
		//Loading Log4j2 file
//		logger =	LogManager.getLogger(this.getClass());//this variable is applicable on testAccountRegistration Because AccountRegistration is Extended on BaseClas
		
		if(driver!=null)
		{
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  driver.get("https://demo.nopcommerce.com/");
 
//		driver.get(p.getProperty("appURL"));//launching appURl from Config.properties file
/* driver.get(p.getProperty("appURL")); */

		driver.manage().window().maximize();
	}
		else {
			throw new RuntimeException("Driver initialization failed");
			}
		}
	@AfterClass
	public void tearDown()
	{
		driver.quit(); 
	}
	 
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}
}
