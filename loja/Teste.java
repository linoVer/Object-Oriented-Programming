package loja;

import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class Teste {

	static ArrayList<Departamento> listaDepartamento = new ArrayList<>();

	public static void main(String[] args) {

		boolean teste = true;

		while (teste) {

			String menu = JOptionPane.showInputDialog(null,
					"" + "1 - Cadastrar Departamento \n" 
					   + "2 - Contratar Funcion�rio\n" + "", "MENU PRINCIPAL",
					JOptionPane.PLAIN_MESSAGE);
			
			try{
				int opcao = Integer.parseInt(menu);
				switch (opcao) {

				case 1: // Cadastrar Departamento
					int id = Integer.parseInt(
							JOptionPane.showInputDialog(null, "Informe o n�mero identificador do departamento",
									"" + "N�mero Identificador", JOptionPane.INFORMATION_MESSAGE));
					String nome = JOptionPane.showInputDialog(null, "Informe o nome do departamento", "Departamento",
							JOptionPane.INFORMATION_MESSAGE);
					String sigla = JOptionPane.showInputDialog(null, "Informe a sigla do departamento", "Sigla",
							JOptionPane.INFORMATION_MESSAGE);
					//Departamento dep = new Departamento(id, nome, sigla);
					//listaDepartamento.add(dep);
					break;

				case 2: // Contratar funcionario
				case 3:
				case 10:
					teste = false;
					break;
				}}catch(InputMismatchException erro){
					JOptionPane.showMessageDialog(null, "Op��o Inv�lida", "Cancelamento", JOptionPane.CANCEL_OPTION);
					
				}
			catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "A��o Cancelada", "Cancelamento", JOptionPane.CANCEL_OPTION);
				}
			}

//			if (menu == null) {
//				JOptionPane.showMessageDialog(null, "A��o Cancelada", "Cancelamento", JOptionPane.CANCEL_OPTION);
//				break;
//			}else if(menu == " "){
//				JOptionPane.showMessageDialog(null,"�oa");
//			}
//			else {
//				int opcao = Integer.parseInt(menu);

//				switch (opcao) {
//
//				case 1: // Cadastrar Departamento
//					int id = Integer.parseInt(
//							JOptionPane.showInputDialog(null, "Informe o n�mero identificador do departamento",
//									"" + "N�mero Identificador", JOptionPane.INFORMATION_MESSAGE));
//					String nome = JOptionPane.showInputDialog(null, "Informe o nome do departamento", "Departamento",
//							JOptionPane.INFORMATION_MESSAGE);
//					String sigla = JOptionPane.showInputDialog(null, "Informe a sigla do departamento", "Sigla",
//							JOptionPane.INFORMATION_MESSAGE);
//					Departamento dep = new Departamento(id, nome, sigla);
//					listaDepartamento.add(dep);
//					break;
//
//				case 2: // Contratar funcionario
//				case 3:
//				case 10:
//					teste = false;
//					break;
//				}

			}
}
	

