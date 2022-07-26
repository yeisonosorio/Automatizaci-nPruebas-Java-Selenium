package TestUfps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.pom.Base;

public class pruebaLink_Page extends Base {

	By divisist = By.linkText("Divisist");

	By imgDivi = By.cssSelector("https://divisist2.ufps.edu.co/public/documentos/c6bb78caf27d0a1772f3989c8069b7ad.jpg");
	By panelFondo = By.cssSelector("a.cd-panel-close");

	By iniFoto = By.cssSelector("body.login-page:nth-child(2) div.login-box2:nth-child(1) div.login-logo.no-margin:nth-child(1) div.row div.col-md-12 > img.img-responsive.center-block");
	By usuario = By.name("usuario");
	By documento = By.cssSelector("input[name='documento']");
	By password = By.name("password");
	By botonBtn = By.tagName("button");

	public pruebaLink_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void pruebaDivi() throws InterruptedException {
		click(divisist);
		Thread.sleep(2000);
		if (isDisplayed(imgDivi)) {
			System.out.print("la img fue cargada correctamente");
		}
		click(panelFondo);
		/*
		 * type("codUsuario", usuario); type("documento", documento); type("contraseña()",
		 * password); click(botonBtn);
		 */

	}

	public void ini() throws InterruptedException {
		click(iniFoto);
		Thread.sleep(2000);
		if (isDisplayed(iniFoto)) {
			type("codUsuario", usuario);
			type("documento", documento);
			type("contraseña", password);
			click(botonBtn);
		}else {
			System.out.print("no se encuntro el user");

		}
	}

}
