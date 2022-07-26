package blazeDemo.com;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.pom.Base;

public class DemoLink_Page extends Base {

	// primero todas las variables por separado
	By posi = By.xpath("//div[contains(text(),'Register')]");
	By nombre = By.id("name");
	By compania = By.name("company");
	By email = By.name("email");
	By password = By.name("password");
	By confipasword = By.name("password_confirmation");
	By btnRegistrar = By.xpath("//button[contains(text(),'Register')]");

	By registrarMensaje = By.cssSelector("'You are logged in!");

	By btnSalir = By.xpath("//body/div[@id='app']/nav[1]/div[1]/div[2]/ul[2]");
	By btnLogout = By.xpath("//a[contains(text(),'Logout')]");
	
	
	By ciudadSalida = By.name("fromPort");

	public DemoLink_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void registrar() throws InterruptedException {
		click(posi);
		Thread.sleep(2000);
		if (isDisplayed(posi)) {
			type("pedro", nombre);
			type("IBM", compania);
			type("123pedro1@gmail.com", email);
			type("123456", password);
			type("123456", confipasword);
			click(btnRegistrar);

		} else {
			System.out.print("el usuario no se ha creado");
		}

	}

	public void salir() throws InterruptedException {
		click(btnSalir);
		Thread.sleep(2000);
		click(btnLogout);
		Thread.sleep(2000);


	}

}
