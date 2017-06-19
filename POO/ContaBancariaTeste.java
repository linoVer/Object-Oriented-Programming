package POO;

import javax.swing.JOptionPane;

public class ContaBancariaTeste {

	public static void main(String[] args) {
		
			ContaBancaria[] conta = new ContaBancaria[10];
			boolean teste = true;
			int quantidadeDeContas = 0;
					
			while (teste)  {
				String inicio = JOptionPane.showInputDialog("1 Criar Conta \n"
																		+"2 Depósito \n"
																		+ "3 Saque \n"
																		+ "4 Transferência \n"
																		+ "5 Saldo \n"
																		+ "6 Sair");
				if(inicio == null){
					JOptionPane.showMessageDialog(null, "Ação Cancelada", "Cancelamento", JOptionPane.CANCEL_OPTION);
					break;
				}else{
				int opcao = Integer.parseInt(JOptionPane.showInputDialog("1 Criar Conta \n"
											+"2 Depósito \n"
											+ "3 Saque \n"
											+ "4 Transferência \n"
											+ "5 Saldo \n"
											+ "6 Sair"));
				switch(opcao){
				
				case 1:
					if(quantidadeDeContas >= 10){
						JOptionPane.showMessageDialog(null, "Não é possível criar mais contas","Mensagem"
								+ " de erro", JOptionPane.ERROR_MESSAGE);
					}else{
						conta[quantidadeDeContas] = new ContaBancaria();
						conta[quantidadeDeContas].setNomeCorrentista(
								JOptionPane.showInputDialog("Informe o nome do correntista: "));
						conta[quantidadeDeContas].setContaNumero(String.valueOf(quantidadeDeContas));
						
						int dep = JOptionPane.showConfirmDialog(null, "Deseja efetuar algum déposito "
								+ "agora?", "Confirmar Depósito Inicial", JOptionPane.YES_NO_OPTION);
						if(dep == JOptionPane.YES_OPTION){
							conta[quantidadeDeContas].depositar(Double.parseDouble(JOptionPane.showInputDialog("Informe "
									+ "o valor")));					
						}else{
							JOptionPane.showMessageDialog(null, "Seu saldo é: " + conta[quantidadeDeContas].getSaldo(), "Saldo "
									+ "Inicial", JOptionPane.PLAIN_MESSAGE);
						}	
						conta[quantidadeDeContas].setLimite(conta[quantidadeDeContas].getSaldo()*0.1);					
						++quantidadeDeContas;
					}
					break;				
					
				case 2:
					if(quantidadeDeContas == 0){
						JOptionPane.showMessageDialog(null, "Não existem contas cadastradas", "Mensagem"
								+ " de erro", JOptionPane.ERROR_MESSAGE);
					}else{
						int numeroDaConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o "
								+ "número da conta para depósito", "Checar conta", JOptionPane.PLAIN_MESSAGE));
						if(numeroDaConta >= 0 && numeroDaConta < 10){
						if(conta[numeroDaConta] != null){
							conta[numeroDaConta].depositar(Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto "
									+ "Deseja Depositar?", "Painel de Depósito", JOptionPane.PLAIN_MESSAGE)));
						}else{
							JOptionPane.showMessageDialog(null, "Número da Conta Não existe", "Mensagem"
									+ " de erro", JOptionPane.ERROR_MESSAGE);
						}	
						}else{
							JOptionPane.showMessageDialog(null, "Número da Conta Não existe", "Mensagem"
									+ " de erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					break;
					
				case 3:
					if(quantidadeDeContas == 0){
						JOptionPane.showMessageDialog(null, "Não existem contas cadastradas", "Mensagem"
								+ " de erro", JOptionPane.ERROR_MESSAGE);
					}else{
						int numeroDaConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o "
								+ "número da conta que deseja efetuar o saque", "Checar Conta", JOptionPane.PLAIN_MESSAGE));
						if(numeroDaConta >= 0 && numeroDaConta < 10){
						if(conta[numeroDaConta] != null){
							conta[numeroDaConta].sacar(Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto "
									+ "Deseja Sacar?", "Painel de Saque", JOptionPane.PLAIN_MESSAGE)));
						}else{
							JOptionPane.showMessageDialog(null, "Número da Conta Não existe", "Mensagem"
									+ " de erro", JOptionPane.ERROR_MESSAGE);
						}
						}else{
							JOptionPane.showMessageDialog(null, "Número da Conta Não existe","Mensagem"
									+ " de erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					break;
					
				case 4:
					
					if(quantidadeDeContas == 0){
						JOptionPane.showMessageDialog(null, "Não existem contas cadastradas", "Mensagem"
								+ " de erro", JOptionPane.ERROR_MESSAGE);
					}else{
						int numeroDaConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o "
								+ "número da conta que deseja efetuar a transferência", "Checar Conta", JOptionPane.PLAIN_MESSAGE));
						if(numeroDaConta >= 0 && numeroDaConta < 10){
						if(conta[numeroDaConta] != null){
							conta[numeroDaConta].transferencia(Double.parseDouble(JOptionPane.showInputDialog(null,"Quanto "
									+ "Deseja transferir?", "Painel de transferência", JOptionPane.PLAIN_MESSAGE)));
						}else{
							JOptionPane.showMessageDialog(null, "Número da Conta Não existe","Mensagem"
									+ " de erro", JOptionPane.ERROR_MESSAGE);
						}
						}else{
							JOptionPane.showMessageDialog(null, "Número da Conta Não existe","Mensagem"
									+ " de erro", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					break;
					
				case 5:
					if(quantidadeDeContas == 0){
						JOptionPane.showMessageDialog(null, "Não existem contas cadastradas","Mensagem"
								+ " de erro", JOptionPane.ERROR_MESSAGE);
					}else{
						int numeroDaConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o "
								+ "número da conta", "Checar Conta", JOptionPane.PLAIN_MESSAGE));
						if(numeroDaConta >= 0 && numeroDaConta < 10){
						if(conta[numeroDaConta] != null){
							conta[numeroDaConta].mostrarSaldo();
							
						}else{
							JOptionPane.showMessageDialog(null, "Número da Conta Não existe","Mensagem"
									+ " de erro", JOptionPane.ERROR_MESSAGE);
						}
						}else{
							JOptionPane.showMessageDialog(null, "Número da Conta Não existe","Mensagem"
									+ " de erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					break;
					
				case 6:
					teste = false;
					break;
				}
				}
			}
			
			
//			conta[0].setNomeCorrentista("Fulano Silva");
//			conta[0].setContaNumero("123");
//			conta[0].setSaldo(100000);
//			conta[0].setLimite(conta[0].getSaldo()*0.1);
//			
//			System.out.println("Informe quanto deseja transferir");
//			double transf = input.nextDouble();
//			conta[0].transferencia(transf);
//			conta[0].mostrarSaldo();
//			
//			System.out.println("Informe quanto deseja sacar");
//			double saque = input.nextDouble();
//			conta[0].sacar(saque);
//			conta[0].mostrarSaldo();
//			
//			System.out.println("Informe quanto deseja depositar");
//			double deposito = input.nextDouble();
//			conta[0].depositar(deposito);		
//			conta[0].mostrarSaldo();		
			
		}
}
