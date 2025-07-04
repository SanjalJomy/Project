package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Homepage_page;

public class Homepage_test {
	WebDriver driver;

	@BeforeTest
	public void set() {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void url() {
		driver.get("https://www.cakehut.in/");
	}

	@Test
	public void test() throws InterruptedException {
		Homepage_page hp = new Homepage_page(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		hp.viewcake();

		WebElement a = hp.selectcake();
		Actions act = new Actions(driver);
		act.moveToElement(a).perform();
		hp.addtocart();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		js.executeScript("arguments[0].scrollIntoView();", hp.selectkg());
		WebElement selectkg = hp.selectkg();
		Select c = new Select(selectkg);
		c.selectByValue("7119");
		
		hp.selectdate();
		while (true) {
			WebElement month = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/table/thead/tr[1]/th[2]"));
			String months = month.getText();
			if (months.equalsIgnoreCase("June 2025")) {
				System.out.println(months);
				break;
			} else {
				driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/table/thead/tr[1]/th[3]")).click();
			}

		}

		List<WebElement> alldates = driver.findElements(By.xpath("/html/body/div[6]/div/div[1]/table/tbody/tr[6]/td[2]"));
		for (WebElement choosedate : alldates) {
			String date = choosedate.getText();
			//System.out.println(date);
			if (date.equals("30")) {
				System.out.println(date);
				choosedate.click();
				System.out.println("Date selected");
				break;
			}
		}

		WebElement selecttime = hp.selecttime();
		Select d = new Select(selecttime);
		d.selectByValue("7115");

		hp.cartbutton();
		
		Thread.sleep(15000);
		hp.carticon();
		
		/*
		 * WebElement cart = driver.findElement(By.xpath("//*[@id=\"cart-items\"]"));
		 * String cartText = cart.getText();
		 */

		if (driver.getPageSource().contains("Product Name")) {
	        System.out.println("Item successfully added to cart!.....");
	        Thread.sleep(10000);
	        
	        driver.findElement(By.xpath("//*[@id=\"content\"]/div/form/div/table/tbody/tr/td[4]/div/span/button[2]")).click();
	       String text= driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
	       System.out.println(text +".....Cart count: ");
	       
	        
	    } else {
	        System.out.println("Item not added to cart.");
	    }
		
		

	}
}
