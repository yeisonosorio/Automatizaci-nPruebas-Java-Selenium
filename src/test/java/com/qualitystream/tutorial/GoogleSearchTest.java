package com.qualitystream.tutorial;


import static org.junit.Assert.*;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;



public class GoogleSearchTest {

	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver" , "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	
	
	@Test
	public void testGooglePage() {
		
		
		
		WebElement searchbox =  driver.findElement(By.name("q"));
		
		searchbox.clear();
		searchbox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
		searchbox.submit();
		
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		 assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google", driver.getTitle() );
		 
		 
		 /*@Test void localizadores() {
		 
			By locator = By.id("id_del_elemento");
			
			By locator_name = By.name("name_elemnt");
			
			By locator_className = By.className("clase_elemento");
			
			By locator_tagName = By.tagName("tag");
			
			By locator_linktext = By.linkText("texto_link");
			
			By locator_partialLinkText = By.partialLinkText("parte_texto");
			
			By locator_cssSelector = By.cssSelector("input[name='q']");
			
			By locator_Xpath = By.xpath("//input[@name='q']");
			
			// JavaScript
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 WebElement searchBox = (WebElement)js.executeScript("return document.getElementsByName('q')[0]");
			
		}*/
	}
	
	@After
	public void tearDow() {
		driver.quit();
	}
	
}
