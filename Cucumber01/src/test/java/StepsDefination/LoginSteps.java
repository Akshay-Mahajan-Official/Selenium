package StepsDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginSteps {

	WebDriver driver = null;
	
	@Given("User launch the chrome browser")
	public void user_launch_the_chrome_browser() {
	   System.out.println("Steps: User launch the chrome browser");	
	   System.setProperty("webdriver.chrome.driver", "C:/Users/aksha/Downloads/TVS (5)/Cucumber01/Drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("User open the URL {string}")
	public void user_open_the_url(String string) {
		System.out.println("Steps: User open the URL");
		driver.get("https://admin-demo.nopcommerce.com/login");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) throws InterruptedException {
		System.out.println("Steps: User enters Email as {admin@yourstore.com} and Password as {admin}");
		WebElement Username = driver.findElement(By.name("Email"));
		Username.clear();
	    Username.sendKeys("admin@yourstore.com");
		Thread.sleep(2000);
		WebElement Password = driver.findElement(By.name("Password"));
		Password.clear();
		Password.sendKeys("admin");
	}

	@When("Click on login")
	public void click_on_login() throws InterruptedException {
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();	
		Thread.sleep(2000);
	}
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String string) {
		System.out.println("Steps: Page Title Should be {Dashboard / nopCommerce administration}");
		String actualTitle= driver.getCurrentUrl();
		String exepectedTitle= "Dashboard / nopCommerce administration";
		if(actualTitle.equalsIgnoreCase(exepectedTitle)) {
			System.out.println("Title Matched");
		}
		else {
			System.out.println("Title Didn't Matched");
		}
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		System.out.println("Steps: User click on log out link");
		driver.findElement(By.xpath("//a[@href=\"/logout\"]")).click();
		Thread.sleep(3000);
	}

	@Then("Close Browser")
	public void close_browser() {
		System.out.println("Steps: Close Browser");
		
		driver.close();
		driver.quit();
	}
	
}
