package ex5;

public class PessoaJuridica extends Pessoa {
	
	private int cnpj;
	
	public PessoaJuridica(String nome, int idade, int telefone, int cnpj) {
		super(nome, idade, telefone);
		this.setCnpj(cnpj);
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	
	
	

}
