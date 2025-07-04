package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Login_page;

public class Login_test {
	WebDriver driver;

	@BeforeTest
	public void set() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void url() {
		driver.get("https://www.cakehut.in/");
	}

	@Test
	public void test() throws IOException, InterruptedException {
		Login_page lp = new Login_page(driver);
		lp.profilelink();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		File f = new File("E:\\pojectfile.xlsx");
		FileInputStream fi = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sh = wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());

		for (int i = 1; i <= sh.getLastRowNum(); i++) {

			String email = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Username: " + email);
			String password = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Password: " + password);

			lp.login(email, password);
			lp.loginbutton();

			if (driver.getPageSource().contains("My Orders")) {
				System.out.println("Login successful for: " + email);
				System.out.println("");
			} else {
				System.out.println("Login failed for: " + email);
				System.out.println("");
			}
		}

	}
}