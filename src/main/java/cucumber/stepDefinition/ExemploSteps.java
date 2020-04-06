package cucumber.stepDefinition;

import static org.junit.Assert.assertTrue;

import base.pages.ExemploPage;
import base.util.Ambiente;
import base.util.RotasDaAplicacao;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.apache.log4j.Logger;

public class ExemploSteps {
    static Logger logger = Logger.getLogger(ExemploSteps.class.getName());
    static ExemploPage exemploPage;

    @Dado("^que eu acesse a tela login$")
    public void queEuAcesseATelaLogin() {
        HookSteps.steps
                .getDriver()
                .get(Ambiente.URL_APLICACAO.getValor().concat(RotasDaAplicacao.HOME.getCaminho()));

        exemploPage = new ExemploPage(HookSteps.steps.getDriver(), HookSteps.steps);
    }

    @E("^realizo o login$")
    public void realizoOLogin() throws Exception {
        exemploPage.doLogin("flavio.lacerda","Agu@s2020!");
    }

    @Dado("^clico na aba de clientes$")
    public void clico_na_aba_de_clientes() throws Exception {
        exemploPage.doClickAbaClientes();
    }

    @Quando("^eu clicar na opcao 'localidade'$")
    public void eu_clicar_na_opcao_localidade() throws Exception {
        exemploPage.doClickOpcLocalidade();
    }

    @Quando("^clicar no botão 'incluir'$")
    public void clicar_no_botão_incluir() throws Exception {
        exemploPage.doClickAbaClientesIncluir();
    }

    @E("^preencher os campos nos valores (.+), (.+), (.+), (.+)$")
    public void preencherOsCamposNosValoresNome_localidadeCidadeData_implantacao(String nome_localidade,String codigo_localidade,String cidade, String data_implantacao) throws Exception {
        exemploPage.doPreencherValoresLocalidade(nome_localidade, codigo_localidade, cidade, data_implantacao);
    }

    @E("^clico no botão 'gravar'$")
    public void clicoNoBotãoGravar() throws Exception {
        exemploPage.doGravarLocalidade();
    }

    @Então("^apresenta a mensagem '(.+)'$")
    public void apresentaAMensagemResultado(String msg) throws Exception {
        exemploPage.doCheckRetorno(msg);
    }
}
