package POO;

import java.util.ArrayList;

public class Aviao {
	
	private String prefixo;
	private String modelo;
	private String fabricante;
	private int quantidadeVoos;
	private ArrayList<Voo> voo = new ArrayList<Voo>();


	public boolean cadastrarVoo(){
		

		
		
		return false;
	}
	
	
	
	public Voo buscasVoo(){
		
		Voo voo = null;
		
		return voo;
	}

	@Override
	public   boolean equals(Object obj){
	
		if (obj != null ){
			if ( obj instanceof Aviao ){
				Aviao aviaoParametro = (Aviao)obj;				
				return this.prefixo.equalsIgnoreCase(aviaoParametro.getPrefixo());
			}
		}
		
		return false;
	}
	
	
	
	
	public String getPrefixo() {
		return prefixo;
	}



	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String getFabricante() {
		return fabricante;
	}



	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}



	public int getQuantidadeVoos() {
		return quantidadeVoos;
	}



	public void setQuantidadeVoos(int quantidadeVoos) {
		this.quantidadeVoos = quantidadeVoos;
	}



	public ArrayList<Voo> getVoo() {
		return voo;
	}

	public void setVoo(ArrayList<Voo> voo) {
		this.voo = voo;
	}
	
	
}
