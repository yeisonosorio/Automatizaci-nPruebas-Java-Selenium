package blazeDemo.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.project.pom.Base;

public class DemoElegirDestino_Page extends Base{
	By ciudadSalida = By.name("fromPort");

	By ciudadDestino =  By.name("toPort");
	
	
	public DemoElegirDestino_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	public String selecionPartida() throws InterruptedException {
		
		Select selectList = new Select(findElement(ciudadSalida));
		Thread.sleep(2000);

		selectList.selectByVisibleText("Portland");
		Thread.sleep(2000);

		return getText(selectList.getFirstSelectedOption());
		
	}
	
	


	public String selecionDestino() throws InterruptedException {
		
		Select selectList = new Select(findElement(ciudadDestino));
		Thread.sleep(2000);

		selectList.selectByVisibleText("Rome");
		Thread.sleep(2000);

		return getText(selectList.getFirstSelectedOption());
		
	}
	
	
	
	
}
