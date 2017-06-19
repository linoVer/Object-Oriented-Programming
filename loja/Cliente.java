package loja;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

	private String cpf_cnpj;
	private Endereco endereco;
	private Cidade cidade;
	private String telefone;
	private List<Venda> listaCompra;
	
	
	public Cliente(String nome, String cpf_cnpj,String telefone, Endereco endereco) {
		super(nome);
		this.cpf_cnpj = cpf_cnpj;
		this.endereco = endereco;
		this.cidade = cidade;
		this.telefone = telefone;
		this.listaCompra = new ArrayList<>();
	}


	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public List<Venda> getListaCompra() {
		return listaCompra;
	}
	


	
	

}
