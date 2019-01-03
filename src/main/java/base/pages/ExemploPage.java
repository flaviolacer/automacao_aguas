package base.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ipp.aci.scriptbase.ScriptBase;

public class ExemploPage extends BasePage{
	public ExemploPage(WebDriver driver, ScriptBase teste) {
		super(driver, teste);
	}
	
	 /** Método que preenche os filtros utilizados na tela de consulta de comissão.
	 **@author Flavio
	 * @param teste
	 * @throws Exception
	 */
	public void preencherCampoSearch(String txt) throws Exception{
		teste.sfSetText("teste", txt);
	}

	@Override
	protected ExpectedCondition<?> getPageLoadCondition() throws Exception {
		return ExpectedConditions.visibilityOf(teste.sfGetElement("logo"));
	}

}
