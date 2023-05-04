package Metodos;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Drivers.DriversFactory;

public class Metodos extends DriversFactory {
	public void escrever(By elemento, String texto) {
		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			System.err.println("ERRO AO ESCREVER" + e.getMessage() + e.getCause());
		}

	}

	public void clicar(By elemento) {
		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			System.err.println("ERRO AO CLICAR" + e.getMessage() + e.getCause());
		}

	}

	public void validarTexto(By elemento, String textoDesejado) {
		try {
			String textoCapturado = driver.findElement(elemento).getText();
			assertTrue(textoCapturado.contains(textoDesejado));
		} catch (Exception e) {
			System.err.println("ERRO AO VALIDAR O TEXTO" + e.getMessage() + e.getCause());
		}

	}

	public void evidencia(String evidencia) throws IOException {
		try {
			TakesScreenshot srcshoot = ((TakesScreenshot) driver);
			File srcFile = srcshoot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Evidencias/" + evidencia + ".png");
			FileUtils.copyFile(srcFile, destFile);

		} catch (Exception e) {
			System.err.println("ERRO AO PRINTAR" + e.getMessage() + e.getCause());
		}

	}

	public void validarTitle(String titleEsperado) {
		try {
			String titleCapturado = driver.getTitle();
			assertTrue(titleCapturado.contains(titleEsperado));
		} catch (Exception e) {
			System.err.println("ERRO AO VALIDAR TITULO" + e.getMessage() + e.getCause());
		}
	}

	public void Cookies(By elemento, int qtdClicks) {
		WebElement cookie = driver.findElement(elemento);
		do {
			clicar(elemento);
			qtdClicks--;
		} while (cookie.isDisplayed() && qtdClicks > 0);

	}

	public void clickNewTab(By elemento, int tab) {
		WebElement element = driver.findElement(elemento);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).moveToElement(element).sendKeys(Keys.ENTER).perform();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tab));

	}

	public void wait(int millis) throws InterruptedException {
		Thread.sleep(millis);
	}

}

