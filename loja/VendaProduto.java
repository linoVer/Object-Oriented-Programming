package loja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VendaProduto {
	
	private Venda venda;
	private Produto produto;
	private double preco;
	private int quantidade;
	
	public static String save = "c:\\Salvando VendaProduto\\";
	
	
	public VendaProduto(Produto produto, double preco, int quantidade) {
		this.venda = venda;
		this.produto = produto;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public Cliente getCliente(){
		return this.venda.getCliente();
	}
	
	public Funcionario getFuncionario(){
		return this.venda.getFuncionario();
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void salvarVendaProduto() throws IOException{
		File arq = new File(save);		
		if(!arq.exists()){
			arq.mkdir();
		}
		BufferedWriter bw = null;
		try{
			File file = new File(save+"Venda_"+this.getProduto().getNome()+"_"+this.getVenda().getCodigo()+"_"+this.getProduto().getId()+".txt");
			
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			String str = this.getVenda().getCodigo()+"; "+this.getProduto().getId()+"; "+this.getPreco()+";\n";
			bw.write(str);
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			bw.close();
		}
	}

	
	
	public Venda getVenda() {
		return venda;
	}

	public double getPreco() {
		return preco;
	}


	public int getQuantidade() {
		return quantidade;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	

}
