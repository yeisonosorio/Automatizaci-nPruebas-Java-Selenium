package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {

	// lo primero que hacemos crear la variable
	private WebDriver driver;
	// identificamos los localizadores de la pagina con By y entre parentesis el
	// identificador

	//Registrar usuario
	By regiserLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");

	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By registerBtnLocator = By.name("submit");

	
	
	//By singInLinkLocator = By.linkText("SIGN-ON");
	
	// Iniciar Sesion despues del registro
	By singInPage = By.xpath("//img[@src='images/banner2.gif']");
	By userLoginLocator = By.name("userName");
	By passwordLoginLocator = By.name("password");
	By registerBtnLoginLocator = By.name("submit");

	@Before
	public void setUp() throws Exception {
		// esto es lo mismo
		// seteamos la propery lo segundo y apunta a la misma ruta de web driver
		// maximmizamos la ventada y driver . get

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void registrarUser() throws InterruptedException {

		driver.findElement(regiserLinkLocator).click();
		Thread.sleep(2000);
		// esperas implicitas y explicitas

		// isdisplay nos devuelve la img si aparece nos arroja verdadero
		if (driver.findElement(registerPageLocator).isDisplayed()) {
			// le envio el usuario con el sendkeys // le paso el usuario para registrarme
			driver.findElement(usernameLocator).sendKeys("admin");
			driver.findElement(passwordLocator).sendKeys("1234");
			driver.findElement(confirmPasswordLocator).sendKeys("1234");
			driver.findElement(registerBtnLocator).click();

		} else {

			System.out.print("el registro no funciono ");
		}

		List<WebElement> fonts = driver.findElements(By.tagName("font"));

		assertEquals("Note: Your user name is admin.", fonts.get(5).getText());

	}

	@Test
	public void singIn() throws InterruptedException {

		if (driver.findElement(userLoginLocator).isDisplayed()) {
			driver.findElement(userLoginLocator).sendKeys("admin");
			driver.findElement(passwordLoginLocator).sendKeys("1234");
			driver.findElement(registerBtnLoginLocator).click();
			Thread.sleep(2000);
			assertTrue(driver.findElement(singInPage).isDisplayed());

		} else {

			System.out.print("el registro no funciono ");
		}



	}

}
