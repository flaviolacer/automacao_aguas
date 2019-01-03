package base.util;

public enum RotasDaAplicacao {

	HOME("/");

	private String caminho;

	RotasDaAplicacao(String caminho) {
		this.caminho = caminho;
	}

	public String getCaminho() {
		return caminho;
	}

}
