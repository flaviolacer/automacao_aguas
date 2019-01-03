package base.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import ipp.aci.scriptbase.ScriptBase;

public abstract class BasePage {
	protected final WebDriver driver;
	protected final ScriptBase teste;
	protected final ResourceBundle labels = ResourceBundle.getBundle("locale");

	/**
	 * Construtor que devera ser utilizado por todos os Page Objects
	 */
	public BasePage(WebDriver driver, ScriptBase teste) {

		this.driver = driver;
		this.teste = teste;
	}

	/**
	 * Metodo que devera ser implementado por todos os Page Objects, informando qual
	 * a condicao para saber se a pagina foi realmente carregada
	 * 
	 * @throws Exception
	 */
	protected abstract ExpectedCondition<?> getPageLoadCondition() throws Exception;

}