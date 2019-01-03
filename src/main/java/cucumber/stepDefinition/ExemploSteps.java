package cucumber.stepDefinition;

import static org.junit.Assert.assertTrue;

import base.pages.ExemploPage;
import base.util.Ambiente;
import base.util.RotasDaAplicacao;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Quando;
import org.apache.log4j.Logger;

public class ExemploSteps {
    static Logger logger = Logger.getLogger(ExemploSteps.class.getName());
    static ExemploPage exemploPage;

	@Dado("^que eu acesso a tela de busca$")
    public void nova_tela_busca() throws Exception {
        HookSteps.steps
                .getDriver()
                .get(Ambiente.URL_APLICACAO.getValor().concat(RotasDaAplicacao.HOME.getCaminho()));
        exemploPage = new ExemploPage(HookSteps.steps.getDriver(), HookSteps.steps);
    }

    @Quando("^realizar a busca$")
    public void realizar_a_busca() {
    }

    @cucumber.api.java.pt.Dado("^o texto de busca com  (.+) = (.+)$")
    public void o_texto_de_buca(String field, String valor) throws Exception {
	    logger.info("Buscando no campo: "+field);
        exemploPage.preencherCampoSearch(valor);
    }

}
