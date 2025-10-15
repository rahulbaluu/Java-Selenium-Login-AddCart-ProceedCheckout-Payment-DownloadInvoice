import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddCart {
	public static void main(String[] args) {
		String baseUrl = "https://automationexercise.com";
		//declaring the baseUrl
		System.setProperty("webdriver.chrome.driver", "/Users/rahulbalashanmugam/Downloads/chromedriver-mac-arm64/chromedriver");
		//Setting the properties for the chrome driver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//declaring the implicitly wait time to 10 secounds
		driver.get(baseUrl);
		//obtaining the baseURL
		driver.findElement(By.cssSelector("p.fc-button-label")).click();
		//Consent button clicked
		driver.findElement(By.linkText("Signup / Login")).click();
		//Signup/Login button clicked
		driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("178@gmail.com");
		//Login email entered in login test box
		driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("178");
		//Login password entered in password test box
		driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
		//Login button clicked and entered into the login page

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.material-icons.card_travel"))).click();
		//Use the above lines when the test got failed due to the page not loading error

		driver.findElement(By.cssSelector("i.material-icons.card_travel")).click();
		//Click the Product button on the top

		List<WebElement> products = driver.findElements(By.className("product-image-wrapper"));
		//List all the Web elements of the mentioned class name
		System.out.println(products.size());
		//print the total number of products in the web application
		for (int i = 0; i < products.size(); i++) {
			//Using the loop and condition statement
			String productName = products.get(i).getText();
			//In this string getting the value for the productName from the products string
			if (productName.contains("Winter")) {
				System.out.println(productName);
				driver.findElements(By.cssSelector("a.add-to-cart")).get(i).click();
				break;
			}
			//In this conditional statement we are checking whether name of the product the required name we mentioned
		}
		driver.findElement(By.linkText("View Cart")).click();
		//Once the product's add to cart is clicked the pop-up will shown in that this command click the View Cart link text
		driver.findElement(By.linkText("Proceed To Checkout")).click();
		//In the Cart click the Proceed To Checkout
		driver.findElement(By.linkText("Place Order")).click();
		//In the Checkout page click the Place Order button
		driver.findElement(By.className("form-control")).sendKeys("178@gmail.com");
		//In the payment this will enter the Full name of the cardholder
		driver.findElement(By.name("card_number")).sendKeys("178");
		//In the payment this will enter the number of the card number
		driver.findElement(By.name("cvc")).sendKeys("178");
		//In the payment this will enter the CVV of the card
		driver.findElement(By.name("expiry_month")).sendKeys("178");
		//In the payment this will enter the expiry month
		driver.findElement(By.name("expiry_year")).sendKeys("2088");
		//In the payment this will enter the expiry year
		driver.findElement(By.id("submit")).click();
		//In the payment this submit the card detail we entered
		driver.findElement(By.linkText("Download Invoice")).click();
		//Once the payment is successful it will click Download Invoice page and Download the invoice
		driver.findElement(By.linkText("Continue")).click();
		//This will click the Continue button and land into the home page
		driver.findElement(By.linkText("Logout")).click();
		//This will click the logout button and the session will logout
		driver.close();
		//This will close the current window
	}
}
