package ex6;

public class Calculadora {
	
	private float valor1;
	private float valor2;
	float resultado;
	
	public float soma(float valor1, float valor2){
		this.setValor1(valor1);
		this.setValor2(valor2);
		resultado = valor1 + valor2;
		return resultado;
	}
	
	public float subtracao(float valor1, float valor2){
		this.setValor1(valor1);
		this.setValor2(valor2);
		resultado = valor1 - valor2;
		return resultado;		
	}
	
	public float multiplicacao(float valor1, float valor2){
		this.setValor1(valor1);
		this.setValor2(valor2);
		resultado = valor1 * valor2;
		return resultado;		
	}
	
	public float divisao(float valor1, float valor2){
		this.setValor1(valor1);
		this.setValor2(valor2);
		resultado = valor1/valor2;
		return resultado;		
	}
	
	private void limparDados(){
		
	}
	
	

	public float getValor1() {
		return valor1;
	}

	public void setValor1(float valor1) {
		this.valor1 = valor1;
	}

	public float getValor2() {
		return valor2;
	}

	public void setValor2(float valor2) {
		this.valor2 = valor2;
	}
	
	
	
	

}
