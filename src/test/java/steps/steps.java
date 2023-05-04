package steps;

import java.io.IOException;

import org.openqa.selenium.By;

import Metodos.Metodos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import runner.executar;

public class steps {

	executar executar = new executar();
	Metodos metodo = new Metodos();

	By BuscaCep = By.xpath("//input[@placeholder='Digite um CEP ou um endereço']");
	By CookieBTN = By.xpath("//*[@id=\"btnCookie\"]");
	By ResultadoCep = By.xpath("//*[text()=//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]]");
	By CepNaoEncotrado = By.xpath("//*[@id=\"mensagem-resultado\"]");
	By btnPesquisar = By.xpath("//*[@id=\"content\"]/div[3]/div/div[2]/div[2]/form/div[2]/button");

	@Given("que esteja na tela inicial")
	public void queEstejaNaTelaInicial() {
		executar.abrirNavegador(false);

	}

	@When("preencho cep valido")
	public void preenchoCepValido() throws InterruptedException, IOException {
		metodo.wait(2000);
		metodo.Cookies(CookieBTN, 3);
		metodo.escrever(BuscaCep, "01001000");
		metodo.evidencia("CT 1 - Preenchendo CEP");
		metodo.clickNewTab(BuscaCep, 1);

	}

	@Then("endereço correspondente ao pesquisado")
	public void endereçoCorrespondenteAoPesquisado() throws InterruptedException, IOException {
		metodo.validarTexto(ResultadoCep, "Praça da Sé - lado ímpar");
		metodo.wait(2000);
		metodo.evidencia("CT  1 - Validando CEP");
		executar.fecharNavegador();

	}

	@Given("não preencho CEP")
	public void nãoPreenchoCEP() throws InterruptedException, IOException {
		metodo.wait(2000);
		metodo.Cookies(CookieBTN, 3);
		metodo.escrever(BuscaCep, " ");
		metodo.evidencia("CT2 - Campo CEP em Branco");
		
	

	}

	@When("clicar em buscar")
	public void clicarEmBuscar() throws InterruptedException {
		metodo.clickNewTab(BuscaCep, 1);

	}
	
	@Then("visualizo erro")
	public void visualizoErro() throws IOException, InterruptedException {
	    
		metodo.validarTexto(CepNaoEncotrado, "Não há dados a serem exibidos");
		metodo.wait(2000);
		metodo.evidencia("CT2 - Mensagem de Erro");
		executar.fecharNavegador();
		
	}

}