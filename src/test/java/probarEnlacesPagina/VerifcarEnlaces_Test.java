package probarEnlacesPagina;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.project.pom.Base;

import TestUfps.pruebaLink_Page;

public class VerifcarEnlaces_Test {

	WebDriver driver;
	verificarEnlaces_Page runPage;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		runPage = new verificarEnlaces_Page(driver);
		driver.get("https://www.dian.gov.co");
	}

	@Test
	public void verificarEnlaces() {
		assertTrue( "los enlaces estan caidos", runPage.verificarEnlace());
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}
}
