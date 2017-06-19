package POO;

import javax.swing.JOptionPane;

public class ContaBancaria {
	
	private String nomeCorrentista;
	private String contaNumero;
	private double saldo;
	private double limite;
	
	
	public void depositar(double valor){
		this.saldo += valor;
	}
	
	public void mostrarSaldo() {
		JOptionPane.showMessageDialog(null, "Seu saldo é: " + this.saldo, "Saldo", JOptionPane.PLAIN_MESSAGE);;
	}
	
	
	public String sacar(double valor){
		if(valor > this.saldo){
			return "Valor indisponível";
		}else if(valor > getLimite()){
			return "Limite diário excedido";
		}else if(valor < 10){
			return "Não é possível sacar este valor. Informe um valor maior";
		}
		else{
			double novoSaldo = this.saldo - valor;
			this.saldo = novoSaldo;
			return "Espere o dinheiro sair no caixa";
		}
	}
	

	public void transferencia(double valor){
		if (valor > this.saldo){
			System.out.println("Saldo insuficiente");
		}else if (valor > getLimite()){
			System.out.println("Limite diário excedido");
		}else{
			this.saldo -= valor;
		}
		
	}	
	
	public double getLimite() {
		return limite;
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}

	public String getNomeCorrentista() {
		return nomeCorrentista;
	}

	public void setNomeCorrentista(String nomeCorrentista) {
		this.nomeCorrentista = nomeCorrentista;
	}

	public String getContaNumero() {
		return contaNumero;
	}

	public void setContaNumero(String contaNumero) {
		this.contaNumero = contaNumero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	


}
