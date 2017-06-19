package loja;

import java.util.ArrayList;
import java.util.List;

public class Cidade {
	
	private int id;
	private String nome;
	private String sigla;
	private Estado estado;
	private List<Endereco> listaEndereco;
	private List<Cliente> listaCliente;
	
	public static int cod = 0;
	
	public Cidade(String nome, String sigla, Estado estado) {
		this.id = cod;
		this.nome = nome;
		this.sigla = sigla;
		this.estado = estado;
		this.listaEndereco = new ArrayList<>();
		this.listaCliente = new ArrayList<>();
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

	public Estado getEstado() {
		return estado;
	}

	public List<Endereco> getListaEndereco() {
		return listaEndereco;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public static int getCod() {
		return cod;
	}

	



	
	
	
	
	
	

}
