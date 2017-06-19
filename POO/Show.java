package POO;

import java.util.Date;

public class Show {

	private int 	codigo;
	private Date 	data;
	private Artista artista;
	
	
	public Show(int codigo, Date data, Artista artista){
		this.codigo 	= 	codigo;
		this.data 		= 	data;
		this.artista 	= 	artista;		
	}



	public int getCodigo() {
		return codigo;
	}

	public Date getData() {
		return data;
	}

	public Artista getArtista() {
		return artista;
	}




}
