package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import CommonUtils.ExcelUtils;
import CommonUtils.FileUtils;


public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		
		FileUtils futils = new FileUtils();
		ExcelUtils eutils=new ExcelUtils();
		
		
		
		
		WebDriver driver=null;
		
		/*Read data from Property file - common data*/
		String BROWSER = futils.getDataFromPropertyFile("browser");
		String URL = futils.getDataFromPropertyFile("url");
		String USERNAME = futils.getDataFromPropertyFile("username");
		String PASSWORD = futils.getDataFromPropertyFile("password");
		
		/*Read data from excel sheet - test data*/
		String ORGNAME = eutils.getDataFromExcelFile("Sheet1", 1, 0);
		String GROUP = eutils.getDataFromExcelFile("Sheet1", 1, 1);
		
	
		//Launch the browser-driver is acting based on runtime(runtime polymorphisum)
				if(BROWSER.equalsIgnoreCase("Chrome")) {
					
					driver= new ChromeDriver();
					
				}else if(BROWSER.equalsIgnoreCase("Firefox")) {
					
					driver = new FirefoxDriver();
					
				}else {
					driver = new EdgeDriver();
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//Step2:Load the url
				driver.get(URL);
				
				//Step3:Login to the Application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Step4:Click on Organizations Link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step5:Click on Create organization look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step6:Create Organization
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			
			//Step7:Click on Group ratio button
			driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
			
			WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
			Select s = new Select(dropdown);
			s.selectByVisibleText(GROUP);
			
			
			
		
		
		
		
		
	}

}
