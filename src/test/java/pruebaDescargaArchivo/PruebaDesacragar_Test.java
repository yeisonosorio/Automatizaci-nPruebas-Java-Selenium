package pruebaDescargaArchivo;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PruebaDesacragar_Test {

	private WebDriver driver;
	private String archivoDescargado = "C:\\Users\\jeiso\\OneDrive\\Escritorio\\pruebas de software";

	@Before
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");

		HashMap<String, Object> prefenciasNave = new HashMap<String, Object>();
		prefenciasNave.put("profile.default_content_setting.popups", 0);
		prefenciasNave.put("download.default_directory", "archivoDescargado");

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefenciasNave);
		driver = new ChromeDriver(options);
	}

	@Test
	public void descargarArchivo() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.cssSelector(
				"body:nth-child(2) div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example > a:nth-child(2)"))
				.click();

		Thread.sleep(2000);

		File folder = new File(archivoDescargado);
		File[] listoArchivo = folder.listFiles();
		assertTrue("el archivono se descargo", listoArchivo.length > 0);
	}


}
