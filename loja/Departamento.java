package loja;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
	
	private int id;
	private String nome;
	private String sigla;
	private List<Funcionario> listaFuncionario;
	
	public static int cod = 0;
	
	public Departamento(String nome, String sigla) {
		this.id = cod;
		this.nome = nome;
		this.sigla = sigla;
		this.listaFuncionario = new ArrayList<>();
		cod++;
	}
	
	/*
	 * talvez um método não necessário
	 */
//	public boolean contratarFuncionario(Funcionario novoFuncionario){
//		
//		if(this.listaFuncionario.size() > 0){
//			for (int i = 0; i < listaFuncionario.size(); i++) {
//				if(!listaFuncionario.get(i).getMatricula().equalsIgnoreCase(novoFuncionario.getMatricula())){
//					novoFuncionario.setDepartamento(this);
//					this.listaFuncionario.add(novoFuncionario);
//					return true;
//				}
//			}
//		}else{
//			novoFuncionario.setDepartamento(this);
//			this.listaFuncionario.add(novoFuncionario);
//			return true;
//		}
//		return false;
//	}

	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}


	public void setListaFuncionario(ArrayList<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}
	



	
	
	
	

}
