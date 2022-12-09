package StepsDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {

	WebDriver driver = null;
	
	@Given("Browser is open")
	public void browser_is_open() {
		System.out.println("Browser is open");
		System.setProperty("webdriver.chrome.driver", "C:/Users/aksha/Downloads/TVS (5)/Cucumber01/Drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("User is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("User is on google search page");
		driver.navigate().to("https://www.google.co.in");
	}

	@When("User enters a text in search box")
	public void user_enters_a_text_in_search_box() throws InterruptedException {
		System.out.println("User enters a text in search box");
		driver.findElement(By.name("q")).sendKeys("Amazon");
		Thread.sleep(3000);
	}

	@When("hits enter")
	public void hits_enter() throws InterruptedException {
	System.out.println("hits enter");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	Thread.sleep(3000);
	}

	@Then("User is navigated to search results")
	public void user_is_navigated_to_search_results() throws InterruptedException {
		System.out.println("User is navigated to search results");
		driver.getPageSource().contains("Amazon Pay");
		driver.close();
		Thread.sleep(3000);
		driver.quit();
	}
}
