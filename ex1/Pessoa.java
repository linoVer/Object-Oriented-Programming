package ex1;

public class Pessoa {
	
	private String nome;
	private int idade;
	private int telefone;
	private int cpf;
	
	
	public Pessoa(String nome, int idade,int telefone,int cpf){
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
		this.cpf = cpf;		
	}


	public String getNome() {
		return nome;
	}


	public int getIdade() {
		return idade;
	}


	public int getTelefone() {
		return telefone;
	}


	public int getCpf() {
		return cpf;
	}

	
}
