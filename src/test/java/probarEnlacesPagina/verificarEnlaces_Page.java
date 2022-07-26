package probarEnlacesPagina;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verificarEnlaces_Page {

	private WebDriver driver;

	
	
	
	public verificarEnlaces_Page(WebDriver driver) {
		this.driver = driver;
	}




	public boolean verificarEnlace() {

		List<WebElement> link = driver.findElements(By.tagName("a"));
		String url = "";
		List<String> enlacesMalos = new ArrayList<String>();
		List<String> oklink = new ArrayList<String>();

		HttpURLConnection httpConection = null;
		int responseCode = 200;
		Iterator<WebElement> it = link.iterator();

		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			if(url == null || url.isEmpty()) {
				System.out.println(url + "la urel no esta configurada");
				continue;
			}
			try {
				httpConection = (HttpURLConnection)(new URL(url).openConnection()); //CONECTAMOS Y ABRIMOS LA CONEXION
				httpConection.setRequestMethod("HEAD"); //SOLICITAMOS EL METODO HEAD
				httpConection.connect(); // NOS CONECTAMOS
				responseCode = httpConection.getResponseCode(); // SOLICITAMOS EL CODIGO DE RESPUESTA
				
				
				if(responseCode > 400) {
					System.out.print("Error del broker link " +  url);
					enlacesMalos.add(url);
				}else {
					System.out.println("enlace valido" + url);
					oklink.add(url);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		System.out.println("enlaces validos " + oklink.size());
		System.out.println("enlaces invalidos " + enlacesMalos.size());
		
		if(enlacesMalos.size()>0) {
			System.out.println("+++++ERROR+++++  enlaces rojos");
			for (int i = 0; i < enlacesMalos.size(); i++) {
				System.out.println(enlacesMalos.get(i));
			}
			return false;
		}else {
			return true;
		}


	}

}

	
	
	
	
	
	
	
	
	
	
	
	