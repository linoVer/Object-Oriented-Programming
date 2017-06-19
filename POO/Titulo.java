package POO;

public class Titulo {
	
	private int 	codigo; 		   //identificador do título
	private String 	genero;    	  //Gênero musical do titulo
	private String 	descricao;    //Descrição do título
	private int 	anoLanc;		//Ano que o título foi lançado
	
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
