package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriver wait;
	public static Logger logger;
	
	
	public TestBase() {
		
	     try {
	            prop = new Properties();
	            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
	            prop.load(fileInputStream);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

		
	
	
	 @SuppressWarnings("deprecation")
	public static void initialization() {
	        String browserName = prop.getProperty("browser");

	        if (browserName.equalsIgnoreCase("chrome")) {
	        	
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();

}
	        
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
	        driver.get(prop.getProperty("url"));
	        logger = Logger.getLogger("info.weblogs");
	        PropertyConfigurator.configure("log4j.properties");
	 }}
	 
