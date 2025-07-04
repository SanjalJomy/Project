package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Verifications_page;

public class Verifications_test {
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
	public void title() {
		Verifications_page vp_title = new Verifications_page(driver);
		String actual = vp_title.titleVerification();
		String expected = "Cake Hut";
		System.out.println("Actual Title: " + actual);
		System.out.println("Expected Title: " + expected);
		if (actual.equalsIgnoreCase(expected)) {
			System.out.println("Title verification is passed");
		} else {
			System.out.println("Title Verification is not passed");
		}
	}

	@Test
	public void responsecode() throws IOException {
		URL obj = new URL("https://www.cakehut.in/");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.connect();
		if (con.getResponseCode() == 200) {
			System.out.println("Valid Url");
		} else {
			System.out.println("Invalid Url");
		}
	}

	@Test
	public void linkverification() {
		List<WebElement> l = driver.findElements(By.tagName("a"));
		for (WebElement h : l) {
			String links = h.getAttribute("href");
			verify(links);
		}
	}

	private void verify(String links) {
		try {
			URL ob = new URL(links);
			HttpURLConnection co = (HttpURLConnection) ob.openConnection();
			co.connect();
			if (co.getResponseCode() == 200) {
				System.out.println("valid--->" + links);
			} else if (co.getResponseCode() == 404) {
				System.out.println("invalid--->" + links);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void content() {
		Verifications_page vp_content = new Verifications_page(driver);
		String actual = vp_content.contentVerification();
		if (actual.contains("Cakes")) {
			System.out.println("Content Verification Successful");
		} else {
			System.out.println("ContentVerification Unsuccesful");
		}
	}

	@Test
	public void secure() {
		Verifications_page vp_secure = new Verifications_page(driver);
		String actual = vp_secure.secure();
		// System.out.println("Url: "+actual);
		if (actual.contains("https:")) {
			System.out.println("Website is secure");
		} else {
			System.out.println("Website not Secure");
		}
	}

	@Test
	public void logovisible() {
		Verifications_page vp_logo = new Verifications_page(driver);
		WebElement logo = vp_logo.logo();
		boolean lg = logo.isDisplayed();
		if (lg) {
			System.out.println("Logo Is Visible");
		} else {
			System.out.println("Logo Is Not Visible");
		}
	}
}
