package base.util;

import ipp.aci.scriptbase.util.ScriptBaseProperties;

/**
 * Enum a ser utilizado para se obter as informações de ambiente em tempo de execução. 
 */
public enum Ambiente {

	URL_APLICACAO("selenium_project_url"),
	USUARIO("selenium_project_user"),
	SENHA("selenium_project_password");

	private String chave;
	private String valor;

	/**
	 * Construtor para criação do Ambiente
	 * @param chave A chave definida nas configuracoes (default_config.properties / pom.xml)
	 */
	private Ambiente(String chave) {
		this.chave = chave;
		this.valor = ScriptBaseProperties.getInstance().getProperty(this.chave);
	}

	public String getChave() {
		return chave;
	}

	public String getValor() {
		return valor;
	}

}