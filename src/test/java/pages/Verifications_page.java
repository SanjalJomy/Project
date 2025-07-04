package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Verifications_page {
	WebDriver driver;
	By logo= By.xpath("//*[@id=\"logo\"]/a/img");
	public Verifications_page(WebDriver driver) {
		this.driver=driver;
	}
	public String titleVerification() {
		return driver.getTitle();
	}
	public String contentVerification() {
		return driver.getPageSource();
	}
	public String secure() {
		return driver.getCurrentUrl();
	}
	public WebElement logo() {
		return driver.findElement(logo);
	}
}
