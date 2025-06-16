
package second;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeOptions;

public class User_Test {
	static WebDriver driver;


	public static void main(String[] args) {
		User_Test test = new User_Test();
		test.callBrowser();
		test.usernamepassword();
		test.validation();
		test.select();
		//test.NewUseradd();
		//test.Updateuser();
		test.Deleteuser();
		
	}
		
		public void callBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\com02\\second\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=D:/selenium-profile"); // Use forward slashes or escaped backslashes

        driver = new ChromeDriver(options);
		
		driver.navigate().to("http://localhost/employee/admin/index.php");
		
		driver.manage().window().maximize();
		}
		
		public void usernamepassword() {
		
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		String username = driver.findElement(By.name("username")).getAttribute("value");
		String password = driver.findElement(By.name("password")).getAttribute("value");
		
		if (username.isEmpty()) {
			System.out.println("Username is empty");
		}
		if(password.isEmpty()) {
			System.out.println("Password is empty");
		} 
		
		driver.findElement(By.xpath("//*[@id=\"login-frm\"]/button[1] ")).click();
		driver.findElement(By.linkText("Employee")).click();
		
		}
		
		public void validation() {
		
	    driver.findElement(By.linkText("Users")).click();  
	    String currentURL = driver.getCurrentUrl();
	    String expectedURL = "http://localhost/employee/admin/users.php"; 

	    if (currentURL.equals(expectedURL)) {
	    	System.out.println("URL Validation Success!");
	    	} else {
	    		System.out.println("URL Validation Failed!");
	    		}
		}
		
		public void dropdown() {
		
		Select Dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"table_length\"]/label/select")));
		Dropdown.selectByValue("25");
		}
		
		public void select() {
		
		driver.findElement(By.xpath("//*[@id=\"table_filter\"]/label/input")).sendKeys("emic");
		}
		
		
		/*public void NewUseradd() {
		driver.findElement(By.xpath("//*[@id=\"new_user\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"user-frm\"]/div[1]/div[1]/input")).sendKeys("emic@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"user-frm\"]/div[1]/div[2]/input")).sendKeys("emic@12345");
		driver.findElement(By.xpath("//*[@id=\"user-frm\"]/div[1]/div[3]/input")).sendKeys("Emic");
		driver.findElement(By.xpath("//*[@id=\"user-frm\"]/div[1]/div[4]/input")).sendKeys("Gopal");
		driver.findElement(By.xpath("//*[@id=\"user-frm\"]/div[2]/button")).click();
		
		try { System.out.println(driver.switchTo().alert().getText()); driver.switchTo().alert().accept(); } 
		catch (Exception e) {}
		}*/
		/*public void Updateuser() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[4]/center/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"user-frm\"]/div[1]/div[4]/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"user-frm\"]/div[1]/div[4]/input")).sendKeys("User");
		driver.findElement(By.xpath("//*[@id=\"user-frm\"]/div[1]/div[2]/input")).sendKeys("ram@12345");	
		driver.findElement(By.xpath("//*[@id=\"user-frm\"]/div[2]/button")).click();
		
		try { System.out.println(driver.switchTo().alert().getText()); driver.switchTo().alert().accept(); }
		catch (Exception e) {}
		}*/
		
		public void Deleteuser() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[4]/center/button[2]")).click();
		
		for(int i=0; i<2; i++) {
		try {
			System.out.println(driver.switchTo().alert().getText()); 
			driver.switchTo().alert().accept();
		}
		catch (Exception e) {}
		
		}}
		
		public void logout() {
		//driver.findElement(By.xpath("/html/body/nav/div/div[2]/a")).click();		
}
		}
