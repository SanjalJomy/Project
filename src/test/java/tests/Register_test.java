package tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Register_page;

public class Register_test {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void url() {
		driver.get("https://www.cakehut.in/");
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		Register_page rp = new Register_page(driver);
		rp.profilelink();
		rp.regpersonal("Ambi", "Swami", "Ambi@12gamil.com", "8114512178");
		rp.regaddress("Zion Industry", "highway road", "paleto junction", "zion city", "4548785");

		WebElement country = rp.regcountryselect();
		Select c = new Select(country);
		c.selectByValue("99");

		WebElement state = rp.regstateselect();
		Select s = new Select(state);
		s.selectByValue("1490");

		rp.regpass("Ambi@12Swami", "Ambi@12Swami");
		rp.regconfirm();

		String successMsg = null;
		String alreadyMsg = null;

		try {
			successMsg = rp.actsucmsg();
		} catch (Exception e) {
			// Element not found
		}

		try {
			alreadyMsg = rp.actalredymsg();
		} catch (Exception e) {
			// Element not found
		}

		if (successMsg != null && !successMsg.isEmpty()) {
			System.out.println("Registration Successful: " + successMsg);

			File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(ss, new File("./screenshot/success_" + ".png"));
			rp.continuebttn();

		} else if (alreadyMsg != null && !alreadyMsg.isEmpty()) {
			System.out.println("Registration Failed (Already Exists): " + alreadyMsg);

			File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(ss, new File("./screenshot/exists_" + ".png"));

		} else {
			System.out.println("No confirmation or error message found.");
		}
	}
}
