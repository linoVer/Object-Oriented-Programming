package loja;

import java.util.ArrayList;
import java.util.List;

public class Estado {
	
	private int id;
	private String nome;
	private String sigla;
	private List<Cidade> listaCidade;
	
	public static int cod = 0;

	public Estado(String nome, String sigla) {
		this.id = cod;
		this.nome = nome;
		this.sigla = sigla;
		this.listaCidade = new ArrayList<>();
		cod++;
	}
	



	
	
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	public List<Cidade> getListaCidade() {
		return listaCidade;
	}

	public static int getCod() {
		return cod;
	}

	public void setListaCidade(ArrayList<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}
	
	
	
}
	
	
	
	
	


