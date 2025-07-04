package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register_page {
	WebDriver driver;

	By profile = By.xpath("/html/body/div[4]/header/div[1]/div[2]/div[3]/div[1]/div/ul/li[2]/a");
	By regacct = By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div/a");

	By firstname = By.xpath("//*[@id=\"input-firstname\"]");
	By lastname = By.xpath("//*[@id=\"input-lastname\"]");
	By emailid = By.xpath("//*[@id=\"input-email\"]");
	By phnum = By.xpath("//*[@id=\"input-telephone\"]");

	By company = By.xpath("//*[@id=\"input-company\"]");
	By address1 = By.xpath("//*[@id=\"input-address-1\"]");
	By address2 = By.xpath("//*[@id=\"input-address-2\"]");
	By city = By.xpath("//*[@id=\"input-city\"]");
	By pincode = By.xpath("//*[@id=\"input-postcode\"]");

	By country = By.xpath("//*[@id=\"input-country\"]");
	By state = By.xpath("//*[@id=\"input-zone\"]");

	By password = By.xpath("//*[@id=\"input-password\"]");
	By conpassword = By.xpath("//*[@id=\"input-confirm\"]");

	By checkbox = By.xpath("//*[@id=\"content\"]/form/div[3]/div/input");
	By confirm = By.xpath("//*[@id=\"content\"]/form/div[3]/div/button");

	By successacctmsg=By.xpath("(//p[contains(text(),'Congratulations! Your new account has been success')])[1]");
	By alredyacctmsg=By.xpath("//*[@id=\"account-register\"]/div[1]");
	By coutinubutton=By.xpath("(//a[normalize-space()='Continue'])[1]");

	public Register_page(WebDriver driver) {
		this.driver = driver;
	}

	public void profilelink() {
		driver.findElement(profile).click();
		driver.findElement(regacct).click();
	}

	public void regpersonal(String fname, String lname, String mail, String num) {
		driver.findElement(firstname).sendKeys(fname);
		driver.findElement(lastname).sendKeys(lname);
		driver.findElement(emailid).sendKeys(mail);
		driver.findElement(phnum).sendKeys(num);

	}

	public void regaddress(String comname, String add1, String add2, String cityname, String pinc) {
		driver.findElement(company).sendKeys(comname);
		driver.findElement(address1).sendKeys(add1);
		driver.findElement(address2).sendKeys(add2);
		driver.findElement(city).sendKeys(cityname);
		driver.findElement(pincode).sendKeys(pinc);

	}

	public WebElement regcountryselect() {
		return driver.findElement(country);
	}

	public WebElement regstateselect() {
		return driver.findElement(state);

	}

	public void regpass(String pass, String conpass) throws InterruptedException {
		driver.findElement(password).sendKeys(pass);
		driver.findElement(conpassword).sendKeys(conpass);
		Thread.sleep(20000);
	}

	public void regconfirm() throws InterruptedException {
		Thread.sleep(2500);
		driver.findElement(checkbox).click();
		driver.findElement(confirm).click();
		Thread.sleep(5000);
	}
	public String actsucmsg() {
		return driver.findElement(successacctmsg).getText();
	}
	public String actalredymsg() {
		return driver.findElement(alredyacctmsg).getText();
	}
	public void continuebttn() {
		driver.findElement(coutinubutton).click();
	}
}
