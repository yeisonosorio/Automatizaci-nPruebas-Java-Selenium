package com.webElements.packg;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.project.pom.Base;

public class DropdownList_Page extends Base {

	// lista desplegable
	// Links mencionados:
	// lista clasica mercury tours http://newtours.demoaut.com/mercurywe.php
	// lista con boostrap y react https://react-bootstrap.github.io/com...
	// identificador se encuentra en el inspeccionar
	By listDesple_Pasajeros = By.name("passCount");
	By listaDesple_Partida = By.name("fromPort");

	// inicio session
	By singInPage = By.xpath("//img[@src='images/banner2.gif']");
	By userLoginLocator = By.name("userName");
	By passwordLoginLocator = By.name("password");
	By registerBtnLoginLocator = By.name("submit");
	
	
	By regiserLinkLocator = By.linkText("Flights");
	// me voy al enlace para ir a la pagina

	
	//jemplo con Reat
	By selectListBtn = By.cssSelector("button[id='dropdown-basic']");
	By opcion2 = By.cssSelector("div[x-placement='bottom-start']>a[href='#/action-2']");
	
	
	
	public DropdownList_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// codigos html y los localizadores y en la clase test la pruebas

	public void signIn() throws InterruptedException {

		if (isDisplayed(userLoginLocator)) {
			type("admin", userLoginLocator);
			type("1234", passwordLoginLocator);
			click(registerBtnLoginLocator);
		} else {
			// si no esta el user nos retorna falso
			System.out.print("no se encuntro el user");
		}

	}

	public String selectLista() throws InterruptedException {
		

		click(regiserLinkLocator);// linck del registro del menu
		Thread.sleep(2000);
		
		//primera forma se puede hacer asi
		WebElement lista = findElement(listDesple_Pasajeros);
		List<WebElement> options = lista.findElements(By.tagName("option"));
		for (int i = 0; i < options.size(); i++) {
			if (getText(options.get(i)).equals("4")); {
				click(options.get(i));
			}
		}
		
		String seleccionOpcion = "";
		for (int i = 0; i < options.size(); i++) {
			if(options.get(i).isSelected());
			seleccionOpcion =getText(options.get(i));
		}
		
		return seleccionOpcion;

	}
	
	//segunda forma se puede hacer asi
	public String selecionPartida() {
		Select selectList = new Select(findElement(listaDesple_Partida));
		selectList.selectByVisibleText("Paris");
		return getText(selectList.getFirstSelectedOption());
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void selectReat() throws InterruptedException {
		click(selectListBtn);
		Thread.sleep(3000);
		if(equals("Another action")) {
		click(opcion2);
		}
	}
	
	

}
