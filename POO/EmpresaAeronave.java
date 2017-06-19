package POO;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EmpresaAeronave {
	
	ArrayList<Aviao> listaAviao = new ArrayList<Aviao>();
	Aviao aviao = new Aviao();
	
	private String cadastro;
	
	
	
	

	public String getCadastro() {
		return cadastro;
	}

	public void setCadastro(String cadastro) {
//		aviao.setPrefixo(JOptionPane.showInputDialog(null,
//				"Informe o prefixo do avião", "Cadastro " + "de Avião",
//				JOptionPane.PLAIN_MESSAGE));
//		
//		aviao.setModelo(JOptionPane.showInputDialog(null,
//				"Informe modelo", "Cadastro " + "de Avião",
//				JOptionPane.PLAIN_MESSAGE));
//		
//		aviao.setFabricante(JOptionPane.showInputDialog(null,
//				"Informe o fabricante", "Cadastro " + "de Avião",
//				JOptionPane.PLAIN_MESSAGE));					
//		
//		int confirm = JOptionPane.showConfirmDialog(null, "Deseja Continuar "
//				+ "Cadastrando?", "Confirmar Depósito Inicial", JOptionPane.YES_NO_OPTION);
//		listaAviao.add(aviao);
		this.cadastro = cadastro;
	}
	
	
	

}
