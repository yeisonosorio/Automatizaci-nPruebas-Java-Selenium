package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base {
	// Iniciar Sesion despues del registro
	By singInPage = By.xpath("//img[@src='images/banner2.gif']");
	By userLoginLocator = By.name("userName");
	By passwordLoginLocator = By.name("password");
	By registerBtnLoginLocator = By.name("submit");

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void signIn() {

		if (isDisplayed(userLoginLocator)) {
			type("admin", userLoginLocator);
			type("1234", passwordLoginLocator);
			click(registerBtnLoginLocator);
		}else {
			// si no esta el user nos retorna falso
			System.out.print("no se encuntro el user");
		}
	}

	public boolean isHomeDisplayed() {
		return isDisplayed(singInPage);
		// nos retorna si ya nos registramos

	}

}
