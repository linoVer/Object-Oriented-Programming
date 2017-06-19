package POO;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AviaoTeste {

	public static void main(String[] args) {

		ArrayList<Aviao> listaAviao = new ArrayList<Aviao>();
		boolean teste = true;
		Aviao aviao = new Aviao();

		// Aviao aviao = new Aviao();
		// String a = scan.inj
		// aviao.setFabricante(a);
		//
		// System.out.println("Digite o prefixo");
		// String p = scan.inj
		// aviao.setPrefixo(p);
		//
		// System.out.println("Digite qtde voos");
		// int qtde = scan.inj
		//
		// aviao.setQuantidadeVoos(qtde);
		// listaAviao.add(aviao);
		//

		// if ( listaAviao.contains(aviao)){
		// int index = listaAviao.indexOf(aviao);
		// Aviao av2 = listaAviao.get(index);
		//
		// av2.
		// }

		while (teste) {
			int opcao = Integer.parseInt(JOptionPane
					.showInputDialog("1 Cadastrar Avião \n"
										+ "2 Cadastrar Voo \n"
										+ "3 Efetuar Reserva \n"
										+ "4 Cancelar Reserva \n" + 
										"5 Listar Voos \n"
										+ "6 Sair"));
			switch (opcao) {

			case 1:
				
				aviao.setPrefixo(JOptionPane.showInputDialog(null,
						"Informe o prefixo do avião", "Cadastro " + "de Avião",
						JOptionPane.PLAIN_MESSAGE));
				
				aviao.setModelo(JOptionPane.showInputDialog(null,
						"Informe modelo", "Cadastro " + "de Avião",
						JOptionPane.PLAIN_MESSAGE));
				
				aviao.setFabricante(JOptionPane.showInputDialog(null,
						"Informe o fabricante", "Cadastro " + "de Avião",
						JOptionPane.PLAIN_MESSAGE));	
				
				listaAviao.add(aviao);
				
				int confirm = JOptionPane.showConfirmDialog(null, "Deseja Continuar "
						+ "Cadastrando?", "Confirmar Depósito Inicial", JOptionPane.YES_NO_OPTION);
				
			
				
				
				listaAviao.contains(aviao);
				
				
				
				
				
				
				
				
				
//				while(confirm == JOptionPane.YES_OPTION){
//					aviao.setPrefixo(JOptionPane.showInputDialog(null,
//							"Informe o prefixo do avião", "Cadastro " + "de Avião",
//							JOptionPane.PLAIN_MESSAGE));
//					
//					aviao.setModelo(JOptionPane.showInputDialog(null,
//							"Informe modelo", "Cadastro " + "de Avião",
//							JOptionPane.PLAIN_MESSAGE));
//					
//					aviao.setFabricante(JOptionPane.showInputDialog(null,
//							"Informe o fabricante", "Cadastro " + "de Avião",
//							JOptionPane.PLAIN_MESSAGE));	
				
//					listaAviao.add(aviao);
//					
//					confirm = JOptionPane.showConfirmDialog(null, "Deseja Continuar "
//							+ "Cadastrando?", "Confirmar Depósito Inicial", JOptionPane.YES_NO_OPTION);
//				}
				break;
				
				
				
				
				

			case 2:
				break;

			case 3:
				break;

			case 4:
				break;

			case 5:
				break;

			case 6:
				teste = false;
				break;
			}
		}
	}

}
