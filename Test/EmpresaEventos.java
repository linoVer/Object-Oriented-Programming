package POO;


import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EmpresaEventos {

	private int 			cnpj;      				 // CNPJ identificador de uma promotora
	private String 			nome;				 // Nome da promotora de eventos
	private ArrayList<Show> listaShow;	// Lista de shows promovida pela empresa


	private int quantidadeMaxShow;
	
	
	
	public EmpresaEventos(int CNPJ, String nome, int quantidadeMaxShow){
		this.cnpj 	       	   = CNPJ;
		this.nome 			   = nome;		
		this.quantidadeMaxShow = quantidadeMaxShow;
		this.listaShow 		   = new ArrayList<>(quantidadeMaxShow);
	}
	
		
	
	public boolean contratarShow(Show show){
		
		boolean temcodigo = false;
		boolean cadastrou = false;

		if(this.listaShow.size() < this.quantidadeMaxShow){
			if(listaShow.size() > 0){
				for (int i = 0; i < this.listaShow.size(); i++) {
					if(this.listaShow.get(i).getCodigo() == show.getCodigo()){
						temcodigo = true;
					}
				}
				if(!temcodigo){
					this.listaShow.add(show);
					cadastrou = true;
				}else{
					cadastrou = false;
				}
			}else{
				this.listaShow.add(show);
				cadastrou = true;
			}
		}else{
			cadastrou = false;
		}
		
		return cadastrou;
	}
		
	
	public void listarArtistasShow(){
		
		String str = new String();
		for (int i = 0; i < listaShow.size(); i++) {		
			 			
			 str +=("Nome : "+ listaShow.get(i).getArtista().getNome() +"\n"+
			 "Nacionalidade : "+listaShow.get(i).getArtista().getNacionalidade());
			 str += ("\n\n");
		}
		JOptionPane.showMessageDialog(null, str, "Nome e Nacionalidade",JOptionPane.INFORMATION_MESSAGE);	
	}
	
	
	
	
	
	
	public void listarTitulosArtistaShow(){
		
		String str = new String();
		
		for (int i = 0; i < listaShow.size(); i++) {		
			 			
			 for (int j = 0; j < listaShow.get(i).getArtista().getListaTitulo().size(); j++) {
				 
				 if(listaShow.get(i).getArtista().getListaTitulo().get(j).getDescricao() != str){
					 str +=("Descri��o : "+ listaShow.get(i).getArtista().getListaTitulo().get(j).getDescricao() +"\n");
					 str += ("\n\n");
					 
				 }else{
					 continue;
				 }
				  
			}
			 JOptionPane.showMessageDialog(null, str, "Lista de T�tulos do show",JOptionPane.INFORMATION_MESSAGE);
		}	
		
		
		
	}
	
	
	public int getCnpj() {
		return cnpj;
	}

	public int getQuantidadeMaxShow() {
		return quantidadeMaxShow;
	}
	
	public ArrayList<Show> getListaShow() {
		return listaShow;
	}

}
