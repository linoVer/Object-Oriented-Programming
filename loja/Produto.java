package loja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Produto {
	
	private int id;
	private String nome;
	private String descricao;
	private double preco;
	private int quantidade;
	private List<Produto> listaSimilar;
	private Produto produtoOriginal;
	private List<VendaProduto> listaVendaProduto;
	//private ArrayList<Produto> listaProduto;
	
	public static int cod = 0;
	public static String save = "c:\\Salvando Produtos\\";
	public static int aux = -1;
	

	public Produto(String nome, String descricao, double preco, int quantidade) {
	
		this.id = cod;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.listaSimilar = new ArrayList<>();
		this.produtoOriginal = produtoOriginal;
		this.listaVendaProduto = new ArrayList<>();
		cod++;
	}
	
	public int getQuantidadeVendas(){
		int aux = 0;
		for (int i = 0; i < listaVendaProduto.size(); i++) {
			aux += listaVendaProduto.get(i).getQuantidade();
		}		
		return aux;
	}
	
	public double getTotalArrecadado(){
		double aux = 0;
		for (int i = 0; i < listaVendaProduto.size(); i++) {
			aux += listaVendaProduto.get(i).getPreco();
		}
		return aux;		
	}	
	
	public List<Cidade> getListaCidadeClientes(int prodIdBusca){
		List<Cidade> aux = null;
 		for (int i = 0; i < listaVendaProduto.size(); i++) {
			if(listaVendaProduto.get(i).getProduto().getId() == prodIdBusca){
				aux = listaVendaProduto.get(i).getCliente().getEndereco().getCidade().getEstado().getListaCidade();
			}				
		}
		return aux; 		
	}
	
	public void cadastrarProdutoSimilar(Produto proSimilar){
		if(!this.listaSimilar.contains(proSimilar)){
		this.listaSimilar.add(proSimilar);
		proSimilar.setProdutoOriginal(this);
		}
	}
	
	public boolean excluirProdutoSimilar(Produto produto){
		if(this.listaSimilar.contains(produto)){
			this.listaSimilar.remove(produto);
			return true;
		}
		return false;
	}
	
	public boolean ehProdutoMarca(){
		if(this.getProdutoOriginal() == null){
			JOptionPane.showMessageDialog(null, "O produto é original", "Verifica Produto", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		JOptionPane.showMessageDialog(null, "O produto é similar", "Verifica Produto", JOptionPane.INFORMATION_MESSAGE);
		return false;
	}
	//método apenas par auxiliar em outro
	public boolean testaUmaCondicao(){
		if(this.getProdutoOriginal() == null){	
			aux = this.getId();
			return true;
		}		
		return false;
	}
	
	public void salvarProduto() throws IOException{
		String str = null;
		File arq = new File(save);		
		if(!arq.exists()){
			arq.mkdir();
		}
		BufferedWriter bw = null;
		try{
			File file = new File(save+this.getNome()+"_"+this.getId()+".txt");
			
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			if(testaUmaCondicao())
				str = this.getId()+"; " + this.getNome()+"; "+this.getDescricao()+"; "+this.getPreco()+"; "+this.getQuantidade()+"; "+this.getId()+";\n";
			else
				str = this.getId()+"; " + this.getNome()+"; "+this.getDescricao()+"; "+this.getPreco()+"; "+this.getQuantidade()+"; "+aux+";\n";
			
			bw.write(str);
		}catch(IOException e){
			e.printStackTrace();
			
		}finally {
			bw.close();
		}
	}



	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public List<Produto> getListaSimilar() {
		return listaSimilar;
	}

	public Produto getProdutoOriginal() {
		return produtoOriginal;
	}

	public List<VendaProduto> getListaVendaProduto() {
		return listaVendaProduto;
	}

	public static int getCod() {
		return cod;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setListaSimilar(List<Produto> listaSimilar) {
		this.listaSimilar = listaSimilar;
	}

	public void setProdutoOriginal(Produto produtoOriginal) {
		this.produtoOriginal = produtoOriginal;
	}

	public void setListaVendaProduto(List<VendaProduto> listaVendaProduto) {
		this.listaVendaProduto = listaVendaProduto;
	}

	public static void setCod(int cod) {
		Produto.cod = cod;
	}

	
	
	

	
	
}
