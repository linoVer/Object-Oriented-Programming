package loja;

public abstract class Pessoa {
	
	
	private String  nome;
	
	
	/**
	 * Contrutor da classe abstrata
	 * @param id
	 * @param nome
	 */
	public Pessoa(String nome) {
		this.nome = nome;
	}// Fim do contrutor da classe abstrata
	


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
