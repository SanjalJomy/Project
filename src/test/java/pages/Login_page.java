package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_page {
WebDriver driver;

By lp_profile=By.xpath("/html/body/div[4]/header/div[1]/div[2]/div[3]/div[1]/div/ul/li[2]/a");
By lp_email=By.xpath("//*[@id=\"input-email\"]");
By lp_pass=By.xpath("//*[@id=\"input-password\"]");
By lp_button=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[3]/div/button");

public Login_page(WebDriver driver) {
	this.driver=driver;
}
public void profilelink() {
	driver.findElement(lp_profile).click();
}
public void login(String email,String pass) {
	driver.findElement(lp_email).clear();
	driver.findElement(lp_email).sendKeys(email);
	driver.findElement(lp_pass).clear();
	driver.findElement(lp_pass).sendKeys(pass);
}
public void loginbutton() throws InterruptedException {
	driver.findElement(lp_button).click();
	Thread.sleep(3000);
}
}
