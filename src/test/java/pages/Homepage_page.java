package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage_page {
WebDriver driver;

By cakeview=By.xpath("//*[@id=\"top\"]/div/div[2]/div/div/div/div[1]/div/div/div[1]/div/div[7]/div/div[2]/div[3]/a");
By cakeselect=By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/div/div[1]/a");
By cakecart=By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/div/div[2]/div[5]/div/div[1]/a");

By selectkg= By.xpath("//select[@id='input-option1384']");
By selectdate=By.xpath("//*[@id=\"product\"]/div[5]/div[2]/div/span/button");
By selecttime=By.xpath("//select[@id='input-option1381']");
By cartbutton=By.xpath("//*[@id=\"button-cart\"]");

By carticon=By.xpath("//*[@id=\"cart\"]/a");

public Homepage_page(WebDriver driver) {
	this.driver=driver;
}
public void viewcake() {
	driver.findElement(cakeview).click();
}
public WebElement selectcake() {
	return driver.findElement(cakeselect);
}
public void addtocart() {
	driver.findElement(cakecart).click();
}
public WebElement selectkg() {
	return driver.findElement(selectkg);
}
public void selectdate() {
	driver.findElement(selectdate).click();
}
public WebElement selecttime() {
	return driver.findElement(selecttime);
}
public void cartbutton() {
	driver.findElement(cartbutton).click();
}
public void carticon() {
	driver.findElement(carticon).click();
}
}
