package ex5;

public class PessoaFisica extends Pessoa{

	private int cpf;
	
	
	public PessoaFisica(String nome, int idade, int telefone, int cpf) {
		super(nome, idade, telefone);
		this.setCpf(cpf);
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	
}
