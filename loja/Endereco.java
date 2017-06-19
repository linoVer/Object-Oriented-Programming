package loja;

public class Endereco {
	
	private int id;
	private String rua;
	private int numero;
	private String bairro;
	private String cep;
	private Cidade cidade;
	
	public static int cod = 0;
	
	public Endereco(String rua, int numero, String bairro, String cep,
			Cidade cidade) {
		this.id = cod;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		cod++;
	}

	public int getId() {
		return id;
	}

	public String getRua() {
		return rua;
	}

	public int getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public static int getCod() {
		return cod;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public static void setCod(int cod) {
		Endereco.cod = cod;
	}
	
	

}
