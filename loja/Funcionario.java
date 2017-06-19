package loja;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa implements IComissao{
	
	private String matricula;
	private String senha;
	private Departamento departamento;
	private List<Venda> listaVenda;
	
	
	public Funcionario(String nome, String matricula, String senha, Departamento departamento) {
		super(nome);
		this.matricula = matricula;
		this.senha = senha;
		this.departamento = departamento;
		this.listaVenda = new ArrayList<>();
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public String getMatricula() {
		return matricula;
	}


	public String getSenha() {
		return senha;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public List<Venda> getListaVenda() {
		return listaVenda;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public void setListaVenda(List<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}


	@Override
	public double GerarComissao(int mes, int ano) {
		double aux = 0;		
		for (int i = 0; i < listaVenda.size(); i++) {
			if(listaVenda.get(i).getDate().getMonthValue() == mes && listaVenda.get(i).getDate().getYear() == ano){
				aux += listaVenda.get(i).getPrecoTotal();
			}
		}
		
		return aux*0.1;
	}
	
	

	
	
	
	

	
	
	

}
