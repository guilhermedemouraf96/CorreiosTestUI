package runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Drivers.DriversFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features", 
		glue = "steps", 
		tags = "@buscaCEP", 
		dryRun = false, 
		monochrome = true, 
		plugin = {"pretty", "html:target/report-cucumber.html" }, 
		snippets = SnippetType.CAMELCASE

)

public class executar extends DriversFactory{
	
	public void abrirNavegador(boolean headless) {
		
	try {
		
		String ambiente = "https://www.correios.com.br/";
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		if(!headless){
			options.addArguments("--headless");
		}
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get(ambiente);
		
	} catch (Exception e) {
		System.err.println("Erro ao abrir navegador" + e.getMessage()+ e.getCause());
		
	}
		
	}
	
public void fecharNavegador() {
		driver.quit();
	}

}
	


