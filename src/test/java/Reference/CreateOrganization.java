package Reference;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=null;
		
		/*Read data from Property file - common data*/
		FileInputStream fis = new FileInputStream("src\\test\\resources\\ProjectFile1.properties");
		Properties p = new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String Username = p.getProperty("username");
		String Password = p.getProperty("password");
		
		//Launch the browser-driver is acting based on runtime(runtime polymorphisum)
				if(Browser.equalsIgnoreCase("Chrome")) {
					
					driver= new ChromeDriver();
					
				}else if(Browser.equalsIgnoreCase("Firefox")) {
					
					driver = new FirefoxDriver();
					
				}else {
					System.out.println("Invalid Browser");
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//Step2:Load the url
				driver.get(URL);
				
				//Step3:Login to the Application
				driver.findElement(By.name("user_name")).sendKeys(Username);
				driver.findElement(By.name("user_password")).sendKeys(Password);
				driver.findElement(By.id("submitButton")).click();
				
				//Step4:Click on Organizations Link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step5:Click on Create organization look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step6:Create Organization
				driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		
			
		
	}

}
