package POO;

public class Titulo {
	
	private int 	codigo; 		   //identificador do t�tulo
	private String 	genero;    	  //G�nero musical do titulo
	private String 	descricao;    //Descri��o do t�tulo
	private int 	anoLanc;		//Ano que o t�tulo foi lan�ado
	
	public static int cod = 0;
	
	public Titulo(String genero, String descricao, int anoLanc) {		
		this.codigo 	= 	cod;
		this.genero		= 	genero;
		this.descricao 	= 	descricao;
		this.anoLanc 	= 	anoLanc;
		cod++;
	}

	

	public int getCodigo() {
		return codigo;
	}

	public String getGenero() {
		return genero;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public int getAnoLanc() {
		return anoLanc;
	}





}
