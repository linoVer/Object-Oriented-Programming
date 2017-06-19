package loja;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;


public class Venda {
	
	private int codigo;
	private LocalDateTime date;
	private double precoTotal;
	private Cliente cliente;
	private Funcionario funcionario;
	private List<VendaProduto> listaVendaProduto;
	
	public static int cod = 0;
	public static String save = "c:\\Salvando Vendas\\";
	public boolean finalizar = false;

	public Venda(LocalDateTime date,Cliente cliente, Funcionario funcionario) {
		this.codigo = cod;
		this.date = date;
		this.precoTotal = precoTotal;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.listaVendaProduto = new ArrayList<>();
		cod++;
	}
	
	public int posicaoPorCodigo(int codigo){
		
		int posicao = -1;
		for (int i = 0; i < this.listaVendaProduto.size(); i++) {
			if (codigo == listaVendaProduto.get(i).getProduto().getId()) {
				posicao = i;
			}
		}
		return posicao ;
	}
	
	
	public boolean adicionarProduto(Produto produto){
		if (!this.finalizar) {
			if (produto.getQuantidade() > 0) {
				VendaProduto vProduto = new VendaProduto(produto, produto.getPreco(), 1);
				produto.setQuantidade(produto.getQuantidade() - 1);
				this.listaVendaProduto.add(vProduto);
				return true;
			}
		}
		return finalizar;

	}
	
	public boolean removerProduto(int prodId){
		if (!this.finalizar) {
			int posicao = this.posicaoPorCodigo(prodId);
			if (posicao > -1) {
				this.listaVendaProduto.remove(posicao);
				return true;
			}
		}
		return finalizar;		
	}
	
	public boolean removerProduto(Produto produto){	
		if (!this.finalizar) {
			for (int i = 0; i < this.listaVendaProduto.size(); i++) {
				if (listaVendaProduto.get(i).getProduto().equals(produto)) {
					this.listaVendaProduto.remove(i);
					return true;
				}
			}
		}
		return finalizar;		
	}
	
	public boolean finalizarVenda(){
		finalizar = true;				
		return finalizar;
	}
	
	public List<Produto> obterProdutosSimilares(Produto prod){
		List<Produto> aux = null;
		if(prod.getListaSimilar().size() > 0){
			aux = prod.getListaSimilar();
		}		
		return aux;
	}
	
	public void salvarVenda() throws IOException{
		File arq = new File(save);		
		if(!arq.exists()){
			arq.mkdir();
		}
		BufferedWriter bw = null;
		try{
			File file = new File(save+"Venda_"+this.getCodigo()+".txt");	
			
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			int dia = this.getDate().getDayOfMonth();
			int mes = this.getDate().getMonthValue();
			int ano = this.getDate().getYear();
			String str = this.getCodigo()+"; " +dia+"/"+mes+"/"+ano+"; "+this.getCliente().getCpf_cnpj()+"; "+this.getFuncionario().getMatricula()+";\n";
			bw.write(str);
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			bw.close();
		}
		
	}
	
	public void obterVendas() throws IOException{

		String str = null;
		String str2 = null;
		FileReader f = new FileReader(save+"Venda_"+this.getCodigo()+".txt");
		String linha = null;
		BufferedReader bufferedReader = null;
		try{
			bufferedReader = new BufferedReader(f);
			while((linha = bufferedReader.readLine()) != null){
				if(linha.contains(this.funcionario.getMatricula())){
					for (int i = 0; i < this.listaVendaProduto.size(); i++) {
						str2 = "Produto(s) comprado(s): "+this.getListaVendaProduto().get(i).getProduto().getId()+""
								+ " - "+this.getListaVendaProduto().get(i).getProduto().getNome()+" - "+
								this.getListaVendaProduto().get(i).getProduto().getDescricao()+"\n"
										+"Quantidade: "+this.getListaVendaProduto().get(i).getQuantidade();
					}
					int dia = this.getDate().getDayOfMonth();
					int mes = this.getDate().getMonthValue();
					int ano = this.getDate().getYear();
					str = "Código Venda: "+this.getCodigo()+"\n"
							+ "Data: "+dia+"/"+mes+"/"+ano+"\n"
							+ "Preço total: "+this.getPrecoTotal()+"\n"
							+ "Cliente: "+this.getCliente().getNome()+"\n"
							+ "Identificação do cliente: "+this.getCliente().getCpf_cnpj()+"\n"
	+ "Endereço: "+"Rua "+this.getCliente().getEndereco().getRua()+", nº "+this.getCliente().getEndereco().getNumero()
	+", Bairro "+this.getCliente().getEndereco().getBairro()+", "+this.getCliente().getEndereco().getCidade().getNome()
	+"-"+this.getCliente().getEndereco().getCidade().getEstado().getSigla()+"\n"
			+ "Funcionário: "+this.getFuncionario().getNome()+" - "+this.getFuncionario().getDepartamento().getNome()+"\n"
					+ str2;
					JOptionPane.showMessageDialog(null, str);
				}
			} 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			bufferedReader.close();
		}
	}
	
	public void obterProdutosDestaques(){
		double maior = Double.MIN_VALUE;
        double menor = Double.MAX_VALUE;
        String str = "";

        for(VendaProduto vendaProduto : listaVendaProduto)
        {
            if(vendaProduto.getProduto().getPreco() > maior)
            {
                maior = vendaProduto.getProduto().getPreco();                    
            }
        }

        str = "Produto mais caro\n" ;
        for(VendaProduto vendaProduto : listaVendaProduto)
        {
            if(maior == vendaProduto.getProduto().getPreco())
            {
                str += vendaProduto.getProduto().getNome() + ": R$ " + vendaProduto.getProduto().getPreco() + "\n";
            }
        }

        for(VendaProduto vendaProduto : listaVendaProduto)
        {
            if(vendaProduto.getProduto().getPreco() < menor)
            {
                menor = vendaProduto.getProduto().getPreco();
            }
        }

        str += "\nProduto mais barato\n" ;            
        
        for(VendaProduto vendaProduto : listaVendaProduto)
        {
            if(menor == vendaProduto.getProduto().getPreco())
            {
                str += vendaProduto.getProduto().getNome() + ": R$ " + vendaProduto.getProduto().getPreco() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, str, "Produtos Destaques", JOptionPane.INFORMATION_MESSAGE);
	}



	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public List<VendaProduto> getListaVendaProduto() {
		return listaVendaProduto;
	}

	
	
	

}
