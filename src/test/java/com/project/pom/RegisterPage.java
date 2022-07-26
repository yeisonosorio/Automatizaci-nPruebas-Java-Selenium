package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base {

	// Registrar usuario
	By regiserLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By registerBtnLocator = By.name("submit");

	By registeredMessage = By.tagName("font");
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void registerUser() throws InterruptedException {
		click(regiserLinkLocator);//linck del registro del menu
		Thread.sleep(2000);
		if(isDisplayed(registerPageLocator)) {
			type("admin", usernameLocator);
			type("1234", passwordLocator);
			type("1234", confirmPasswordLocator);
			
			click(registerBtnLocator);
		}else {
			System.out.print("Registro fallado");
		}

		
		
	}

	public String registeredMessage() {
		List<WebElement> fonts = findElements(registeredMessage);
		return getText(fonts.get(5));
	}

}
