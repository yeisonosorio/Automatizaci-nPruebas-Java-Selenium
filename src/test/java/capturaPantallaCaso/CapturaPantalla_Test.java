package capturaPantallaCaso;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturaPantalla_Test {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.get("https://www.google.com");
	}

	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		Date date = new Date(0);
		return dateFormat.format(date);
	}

	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void failed(Throwable throwable, Description description) {
			File pantallazo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(pantallazo, new File("Error" + description.getMethodName() + getDate() + ".png"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		@Overide
		protected void finished(Description description) {
			driver.quit();
		}

	};

	@Test
	public void testBusqueda() {

		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
		searchBox.submit();

		// espera implicita
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

		assertEquals("Esto ocasionara un error", driver.getTitle());

	}

}
