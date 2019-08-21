package base.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ipp.aci.scriptbase.ScriptBase;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExemploPage extends BasePage{
	public ExemploPage(WebDriver driver, ScriptBase teste) {
		super(driver, teste);
	}
	
	 /** Método que preenche os filtros utilizados na tela de consulta de comissão.
	 **@author Flavio
	 * @throws Exception
	 */
	 public void preencherCampoSearch(String txt) throws Exception{
		 teste.sfSetText("teste", txt);
	 }

	public void doLogin(String login, String password) throws Exception{
		teste.sfSetText("login", login);
		teste.sfSetText("password", password);
		teste.sfClick("btn_entrar");
		teste.sfWaitElement("iframe_principal", 300);
        teste.sfSwitchFrame(teste.sfGetElement("iframe_principal").getAttribute("name"));
        teste.sfWaitForPageLoad();
        teste.sfWaitElement("iframe_pesquisa", 300);
        teste.sfSwitchFrame(teste.sfGetElement("iframe_pesquisa").getAttribute("name"));
        teste.sfWaitForPageLoad();

		teste.sfWaitElement("btn_ok_principal", 300);
		teste.sfClick("btn_ok_principal");
        teste.sfSwitchFrame();
	}

	public void doClickAbaClientes() throws Exception {
        teste.sfSwitchFrame(teste.sfGetElement("iframe_principal").getAttribute("name"));
		teste.sfClick("aba_clientes");
		teste.sfSwitchFrame();
	}

	public void doClickOpcLocalidade() throws Exception {
        teste.sfSwitchFrame(teste.sfGetElement("iframe_principal").getAttribute("name"));
        teste.sfWaitElement("opc_localidade", 300);
		teste.sfClick("opc_localidade");
        teste.sfSwitchFrame();
	}

	public void doClickAbaClientesIncluir() throws Exception {
        teste.sfWaitElement("iframe_principal", 300);
        teste.sfSwitchFrame(teste.sfGetElement("iframe_principal").getAttribute("name"));
        teste.sfWaitForPageLoad();
        teste.sfWaitElement("iframe_incluir_localidade", 300);
        teste.sfSwitchFrame(teste.sfGetElement("iframe_incluir_localidade").getAttribute("name"));
        teste.sfWaitForPageLoad();

        teste.sfWaitElement("btn_incluir_localidade", 300);
		teste.sfClick("btn_incluir_localidade");
	}

	public void doPreencherValoresLocalidade(String nome_localidade,String codigo_localidade, String cidade, String data_implantacao) throws Exception {
        teste.sfWaitElement("txt_nome_localidade", 300);
		teste.sfSetText("txt_nome_localidade", nome_localidade);
		teste.sfSetText("txt_codigo_localidade", codigo_localidade);
		teste.sfSetText("cbx_cidade_localidade", cidade);
        teste.sfJavaScriptExecute("document.getElementById('txtDataRefInicial').value = '"+data_implantacao+"';");
	}

    public void doGravarLocalidade() throws Exception {
		teste.sfClick("btn_gravar_localidade");
	}

	public void doCheckRetorno(String msg) throws Exception {
		teste.sfWaitElement("label_incluir_localidade", 300);
        String msgLabel = teste.sfGetText("label_incluir_localidade");
        while (msgLabel.trim().isEmpty()) {
            msgLabel = teste.sfGetText("label_incluir_localidade");
            teste.sfSleep(500);
        }

		Assert.assertEquals("Erro na mensagem de resposta de inclusão de localidade", msg.trim(), msgLabel.trim());
	}

	@Override
	protected ExpectedCondition<?> getPageLoadCondition() throws Exception {
		return ExpectedConditions.visibilityOf(teste.sfGetElement("logo"));
	}
}
