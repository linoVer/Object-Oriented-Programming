package POO;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Artista {

	private int 				codigo;
	private String 				nome;
	private double 				valorShow;
	private String 				nacionalidade;
	private ArrayList<Titulo> 	listaTitulo;
	
	
	private static int	codigoArt = 0;
	private final int 	TAMANHO = 10;
	private final int 	MAX_POR_ANO = 2;
	private int 		quantidadeDeShows;
	
	
	
	/**
	 * Construtor 
	 * @param Nome do artista
	 * @param Valor por show
	 * @param nacionalidade do artista
	 */
	public Artista(String nome, double valorShow, String nacionalidade){
		
		this.quantidadeDeShows 	= 	0;  //quantidade de shows vendidos pela gravadora
		this.codigo 			= 	codigoArt;
		this.nome 				= 	nome;
		this.valorShow			= 	valorShow;
		this.nacionalidade 		= 	nacionalidade;
		this.listaTitulo 		= 	new ArrayList<>(TAMANHO);
		codigoArt++;

	}

	
	/**
	 * Verifica se a quantidade de t�tulo lan�ados � igual ou inferior a 2 por ano;
	 * @param ano
	 * @return
	 */
	public int verificaTitulo(int ano){		
		
		int contador = 0;
		for (int i = 0; i < listaTitulo.size(); i++) {
			if(ano == listaTitulo.get(i).getAnoLanc()){
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * Cria um novo t�tulo para o artista
	 * @param novoTitulo
	 * @return boolean
	 */
	public boolean lancarTitulo(Titulo novoTitulo){
		
		if(this.listaTitulo.size() < TAMANHO){
			int quantidadeAno = this.verificaTitulo(novoTitulo.getAnoLanc());
			if(quantidadeAno < MAX_POR_ANO){
				this.listaTitulo.add(novoTitulo);
				return true;				
			}
		}
		return false;		
	}
	
	public boolean excluirTitulo(int codigo){
		
		int posicao = this.posicaoPorCodigo(codigo);
		if(posicao > -1){
			this.listaTitulo.remove(posicao);
			return true;
		}else
			return false;
	}
	
	public int posicaoPorCodigo(int codigo){
		
		int posicao = -1;
		for (int i = 0; i < listaTitulo.size(); i++) {
			if (codigo == listaTitulo.get(i).getCodigo()) {
				posicao = i;
			}
		}
		return posicao ;
	}
	
	public Titulo buscarTitulo(int codigo){
		int cod = 0;
		cod = posicaoPorCodigo(codigo);
		if(cod > -1){
			return listaTitulo.get(cod);
		}else
			return null;	
	}
	
	public int quantidadeTituloGenero(String genero){
		int contador = 0;
		for (int i = 0; i < listaTitulo.size(); i++) {
			if(genero.equalsIgnoreCase(listaTitulo.get(i).getGenero())){
				contador++;
			}
		}
		return contador;
		
		
	}
	
	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public ArrayList<Titulo> getListaTitulo() {
		return listaTitulo;
	}


	public int getQuantidadeDeShows() {
		return quantidadeDeShows;
	}


	public void setQuantidadeDeShows(int quantidadeDeShows) {
		this.quantidadeDeShows = quantidadeDeShows;
	}

	public double getValorShow() {
		return valorShow;
	}


	public String getNacionalidade() {
		return nacionalidade;
	}


	public void setListaTitulo(ArrayList<Titulo> listaTitulo) {
		this.listaTitulo = listaTitulo;
	}
	
	
}
