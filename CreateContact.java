package Project;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtils.ExcelUtils;
import CommonUtils.JavaUtils;
import CommonUtils.PropertyFileUtils;
import CommonUtils.WebDriverUtils;

public class CreateContact {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		WebDriver driver = null;

		PropertyFileUtils futils = new PropertyFileUtils();
		ExcelUtils eutils=new ExcelUtils();	
		WebDriverUtils wutils = new WebDriverUtils();
		JavaUtils jutils = new JavaUtils();
		
		
		/*Read data from Property file - common data*/
		String BROWSER = futils.getDataFromPropertyFile("browser");
		String URL = futils.getDataFromPropertyFile("url");
		String USERNAME = futils.getDataFromPropertyFile("username");
		String PASSWORD = futils.getDataFromPropertyFile("password");

		
		/*Read data from excel sheet - test data*/
		String ORGNAME = eutils.getDataFromExcelFile("Sheet1", 1, 0);
		String GROUP = eutils.getDataFromExcelFile("Sheet1", 1, 1);
		String FIRSTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 2);
		String LASTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 3);
		String PARENTURL = eutils.getDataFromExcelFile("Sheet1", 1, 4);
		String CHILDURL = eutils.getDataFromExcelFile("Sheet1", 4, 4);
		
		
	
		//Launch the browser-driver is acting based on runtime(runtime polymorphisum)
				if(BROWSER.equalsIgnoreCase("Chrome")) {
					
					driver= new ChromeDriver();
					
				}else if(BROWSER.equalsIgnoreCase("Firefox")) {
					
					driver = new FirefoxDriver();
					
				}else {
					driver = new EdgeDriver();
				}
				
				wutils.maximizeWindow(driver);
				wutils.implicitwait(driver);
				
				//Step2:Load the url
				driver.get(URL);
				
				//Step3:Login to the Application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
			
				//Step4:Click on Organizations Link
				driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
				
				//Step5:Click on Create organization look up image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				//Step6:Enter firstname & lastname
				driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				//Step7:Click on  organization name + image
				driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
				
				wutils.switchWindow(driver, CHILDURL);
				
				
				//Step8:Enter Organization name in search tf
				driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
				
				//Step9:Click on search now
				driver.findElement(By.name("search")).click();
				
				//Step9:Click on text
				driver.findElement(By.xpath("//a[text()='wipro']")).click();
				
				wutils.switchWindow(driver, PARENTURL);
				
				
				//Step7:Click on Group ratio button
				driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
				
				WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
				wutils.handleDropDown(GROUP, dropdown);
				
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				Thread.sleep(4000);
				
			WebElement Adminimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					wutils.mouseHoverAction(driver, Adminimg);
				
					Thread.sleep(4000);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
	}

}
