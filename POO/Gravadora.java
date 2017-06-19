package POO;

import java.util.ArrayList;

public class Gravadora {

	private int 				codigo;
	private String 				nome;
	private String 				sede;
	private ArrayList<Artista> 	artistas; //Lista de artistas que foram contratados pela
	//gravadora

	private static int	codigoGravadora = 0;

	public Gravadora(String nome, String sede, int qtdArtistas){
		this.codigo 		= 	codigoGravadora;
		this.nome 			= 	nome;
		this.sede			= 	sede;
		this.artistas 		= 	new ArrayList<>(qtdArtistas);
		codigoGravadora++;
	}

	public boolean contratarArtista(Artista artista) {
		boolean temcodigo = false;
		boolean cadastrou = false;
		if(artistas.size() > 0){
			for (int i = 0; i < this.artistas.size(); i++) {
				if(this.artistas.get(i).getCodigo() == artista.getCodigo()){
					temcodigo = true;
				}
			}
			if(!temcodigo){			
				this.artistas.add(artista);
				cadastrou = true;
			}else cadastrou = false;
		}else{
			this.artistas.add(artista);
			cadastrou = true;
		}
		return cadastrou;
	}

	public boolean demitirArtista(int codigo){
		
		int posicao = this.posicaoPorCodigo(codigo);
		if(posicao > -1){
			this.artistas.remove(posicao);
			return true;
		}else
			return false;
		
	}
	
	public int posicaoPorCodigo(int codigo){
		
		int posicao = -1;
		for (int i = 0; i < artistas.size(); i++) {
			if (codigo == artistas.get(i).getCodigo()) {
				posicao = i;
			}
		}
		return posicao ;
	}
	
	
	

	public double venderShow(int codigoArtista){

		double valor = 0.0;
		int pos = -1;
		for (int i = 0; i < artistas.size(); i++) {
			if(codigoArtista == artistas.get(i).getCodigo()){
				pos = i;
				break;
			}
		}
		if(pos  > -1){
			valor =  artistas.get(pos).getValorShow();			
			int x = artistas.get(pos).getQuantidadeDeShows();
			artistas.get(pos).setQuantidadeDeShows(x+1);
		} else{
			valor = -1;
		}		
		return valor;
	}

	public String artistaShow(){
		String nome = artistas.get(0).getNome();
		int pos = -1;
		int maisShows = artistas.get(0).getQuantidadeDeShows();
		for (int i = 1; i < artistas.size(); i++) {
			if(maisShows < artistas.get(i).getQuantidadeDeShows()){
				pos = i;
			}			
		}
		if(pos > -1){
			nome = artistas.get(pos).getNome();
		}	
		return nome;
	}




	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getSede() {
		return sede;
	}

	public ArrayList<Artista> getArtistas() {
		return artistas;
	}

	public static int getCodigoGravadora() {
		return codigoGravadora;
	}

}
