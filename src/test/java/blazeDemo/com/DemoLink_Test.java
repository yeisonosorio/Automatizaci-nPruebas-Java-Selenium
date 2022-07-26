package blazeDemo.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class DemoLink_Test  {

	private WebDriver driver;
	//pruebaLink_Page runPage;

	DemoElegirDestino_Page runPage;
	
	@Before
	public void setUp() throws Exception {
		runPage = new DemoElegirDestino_Page(driver);
		driver = runPage.chromeDriverConnection();
		driver.manage().window().maximize();
		runPage.visit("https://blazedemo.com/");

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException{

		//runPage.pruebaDivi();
		//runPage.ini();
		runPage.selecionPartida();
		runPage.selecionDestino();
	
	}

}

