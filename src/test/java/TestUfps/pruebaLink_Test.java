package TestUfps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class pruebaLink_Test {

	private WebDriver driver;
	pruebaLink_Page runPage;

	
	
	@Before
	public void setUp() throws Exception {
		runPage = new pruebaLink_Page(driver);
		driver = runPage.chromeDriverConnection();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException{

		runPage.visit("https://ww2.ufps.edu.co/");
		runPage.pruebaDivi();
		runPage.ini();
	//este es el que estoy trabajando
	
	}

}
