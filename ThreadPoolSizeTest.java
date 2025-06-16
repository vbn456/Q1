package thread_pool_size_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThreadPoolSizeTest  {
	
	@Test(invocationCount = 3, threadPoolSize = 3)
    public void testRegistrationForm() {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "D://Uni//3_2//Selenium//chromedriver-win64//chromedriver.exe");

        // Create new browser instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the local registration.html page
        driver.navigate().to("https://www.google.com");

        // Print current thread ID to show parallel execution
        System.out.println("Opened registration.html - Thread ID: " + Thread.currentThread().getId());
	}
}

/* 
	threadPoolSize = 3 ensures all 3 browser instances launch simultaneously.
	(This confirms all 3 executions are running in parallel, each in a separate thread)
*/
