package loja;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class TesteDoSistemaSript {

	static LocalTime time = LocalTime.now();              //pega a hora, minuto e segundo do sistema
	static DecimalFormat df = new DecimalFormat("0.00");  //define o duas casas decimais
	
	public static void main(String[] args) throws IOException {
		/*
		 * cadastrar departamento
		 */
		Departamento dep1 = new Departamento("Recursos Humanos", "RH");
		Departamento dep2 = new Departamento("Calçados", "CÇ");	
		Departamento dep3 = new Departamento("Almoxarifado", "AX");
		/*
		 * cadastrar funcionario
		 */
		Funcionario funcionario1 = new Funcionario("José", "15e4", "1345", dep1);		
		Funcionario funcionario2 = new Funcionario("Maria", "15e6", "1395",dep2);
		Funcionario funcionario3 = new Funcionario("Pedro", "14e4", "1395", dep3);		
		/*
		 * contratar funcionario
		 */				
		dep1.getListaFuncionario().add(funcionario1);
		dep1.getListaFuncionario().add(funcionario2);
		dep3.getListaFuncionario().add(funcionario3);
		
//		System.out.println(funcionario1.getDepartamento().getNome());
//		System.out.println(funcionario2.getDepartamento().getNome());
//		System.out.println(funcionario3.getDepartamento().getNome());
//		System.out.println(dep1.getListaFuncionario().get(0).getNome());
		/*
		 * cadastrar estado
		 */		
		Estado estado1 = new Estado("Sergipe", "SE");
		Estado estado2 = new Estado("Bahia", "BA");
		Estado estado3 = new Estado("São Paulo", "SP");
		/*
		 * cadastrar cidade
		 */
		Cidade cidade1 = new Cidade("Aracaju", "AJU", estado1);
		Cidade cidade2 = new Cidade("Salvador", "SSA", estado2);
		Cidade cidade3 = new Cidade("Guarulhos", "GRU", estado3);
		/*
		 * adiciona a cidade na listaCidade em Estado
		 */
		estado1.getListaCidade().add(cidade1);
		estado2.getListaCidade().add(cidade2);
		estado3.getListaCidade().add(cidade3);
		
		//System.out.println(estado1.getListaCidade().size());
		//System.out.println(estado1.getListaCidade().get(0).getNome());

		/*
		 * cadastrar endereço
		 */
		Endereco endereco1 = new Endereco("Rua A", 12, "Bairro", "49000-000", cidade1);
		Endereco endereco2 = new Endereco("Rua B", 20, "Teste", "48000-000", cidade2);
		Endereco endereco3 = new Endereco("Rua C", 15, "Algum", "47000-000", cidade3);
		/*
		 * insere o endereço na lista contida em Cidade
		 */
		cidade1.getListaEndereco().add(endereco1);
		cidade2.getListaEndereco().add(endereco2);
		cidade3.getListaEndereco().add(endereco3);
		/*
		 * cadastrar cliente
		 */
		Cliente cliente1  = new Cliente("João", "255.222.222-22", "(79)3333-5544", endereco1);
		Cliente cliente2 = new Cliente("Joana", "444.444.444-44", "(71)5555-5544", endereco2);
		Cliente cliente3 = new Cliente("Carla", "777.777.777-77", "(11)4444-5544", endereco3);
		/*
		 * insere o cliente na lista contida em cidade
		 */
		cidade1.getListaCliente().add(cliente1);
		cidade2.getListaCliente().add(cliente2);
		cidade3.getListaCliente().add(cliente3);			
		/*
		 * cadastrar produto
		 */
		//nome, descricao, preco, quantidade
		Produto produto1 = new Produto("Dalon", "Arroz Branco", 3, 10);
		Produto produto2 = new Produto("Néscau", "Achocolatado", 4, 10);
		Produto produto3 = new Produto("Colgate", "Creme Dental", 2, 10);
		
		/*
		 * adiciona os produtos cadastrados em uma lista
		 */
		List<Produto> listaProdutos = new ArrayList<>();		
		listaProdutos.add(produto1);
		listaProdutos.add(produto2);
		listaProdutos.add(produto3);		
		//System.out.println(listaProdutos.size());
		
		/*
		 * cadastrar venda
		 */		
		// data, cliente, funcionario
		Venda venda1 = new Venda(LocalDateTime.of(2016, 11, 24, time.getHour(), time.getMinute(), time.getSecond()), cliente1, funcionario1);
		Venda venda2 = new Venda(LocalDateTime.of(2016, 10, 15, time.getHour(), time.getMinute(), time.getSecond()), cliente2, funcionario2);
		Venda venda3 = new Venda(LocalDateTime.of(2016, 04, 02, time.getHour(), time.getMinute(), time.getSecond()), cliente3, funcionario3);
			
//		System.out.println(venda1.getDate().getDayOfMonth());
//		System.out.println(venda1.getDate().getMonthValue());		
//		System.out.println(venda1.getDate().getYear());
//		System.out.println(time.getSecond());
		
		/*
		 * adiciona as vendas cadastradas em uma lista
		 */
		List<Venda> listaVendas = new ArrayList<>();		
		listaVendas.add(venda1);
		listaVendas.add(venda2);
		listaVendas.add(venda3);
		//System.out.println(listaVendas.size());
		/*
		 * adiciona uma venda a listaVendas em Funcionário
		 */
		venda1.getFuncionario().getListaVenda().add(venda1);
		venda2.getFuncionario().getListaVenda().add(venda2);
		venda3.getFuncionario().getListaVenda().add(venda3);
		/*
		 * adiciona uma venda a listaCompras em Funcionário
		 */
		venda1.getCliente().getListaCompra().add(venda1);
		venda2.getCliente().getListaCompra().add(venda2);
		venda3.getCliente().getListaCompra().add(venda3);
		
		
		/*
		 *  Vender Produto
		 */
		//venda, produto, preço, quantidade	
		
		VendaProduto vendaProduto1 = new VendaProduto(produto1, 3.5, 6);		
		VendaProduto vendaProduto2= new VendaProduto(produto2, 4.5, 9);		
		VendaProduto vendaProduto3 = new VendaProduto(produto3, 3.0, 4);
		/*
		 * seta uma venda para uma vendaProduto
		 */	
		vendaProduto1.setVenda(venda1);
		vendaProduto2.setVenda(venda2);
		vendaProduto3.setVenda(venda3);
		/*
		 * adiciona uma vendaProduto a listaVendaProduto de uma venda 
		 */		
		venda1.getListaVendaProduto().add(vendaProduto1);
		venda2.getListaVendaProduto().add(vendaProduto2);
		venda3.getListaVendaProduto().add(vendaProduto3);	
		
		//cada vez que um produto é vendido, sua quantidade diminui na classe Produto
		produto1.setQuantidade(produto1.getQuantidade() - vendaProduto1.getQuantidade());
		produto2.setQuantidade(produto2.getQuantidade() - vendaProduto2.getQuantidade());
		produto3.setQuantidade(produto3.getQuantidade() - vendaProduto3.getQuantidade());
		
//		System.out.println(produto1.getQuantidade());
//		System.out.println(produto2.getQuantidade());
//		System.out.println(produto3.getQuantidade());
		
		
		//verifica se a Venda é igual a Venda em questão e add na listaVendaProduto da Classe Venda
		
		if(venda1.equals(vendaProduto1.getVenda())){
			venda1.getListaVendaProduto().add(vendaProduto1);
		}		
		if(venda2.equals(vendaProduto2.getVenda())){
			venda2.getListaVendaProduto().add(vendaProduto2);
		}	
		if(venda3.equals(vendaProduto3.getVenda()))	{
			venda3.getListaVendaProduto().add(vendaProduto3);
		}
		
		//verifica se o produto passada na Classe VendaProduto é igual ao produto cadastrado e add na
		//listaVendaProduto da Classe Produto
		
		if(produto1.equals(vendaProduto1.getProduto())){
			produto1.getListaVendaProduto().add(vendaProduto1);
		}
		if(produto2.equals(vendaProduto2.getProduto())){
			produto2.getListaVendaProduto().add(vendaProduto2);
		}
		if(produto3.equals(vendaProduto3.getProduto())){
			produto3.getListaVendaProduto().add(vendaProduto3);
		}		
		
//		System.out.println(venda3.getListaVendaProduto().size());
//		System.out.println(produto1.getListaVendaProduto().size());
//		System.out.println(produto2.getListaVendaProduto().size());
//		System.out.println(produto3.getListaVendaProduto().size());
		
		/**
		 *  CHAMADA DOS MÉTODOS
		 */
		
		/*
		 *  testa o método remover produto passando a id do produto como parâmetro
		 *  e testa o finalizar venda
		 */
//		System.out.println(venda1.getListaVendaProduto().size());
//		venda1.finalizarVenda();
//		venda1.removerProduto(0);
//		System.out.println(venda1.getListaVendaProduto().size());
		
		/*
		 * testa o método remover produto passando uma instância de produto como parâmetro 
		 * e testa o finalizar venda
		 */

//		System.out.println("Tamanho antes: " +venda1.getListaVendaProduto().size());
//		venda1.finalizarVenda();
//		venda1.removerProduto(produto1);
//		System.out.println("tamanaho dps: " +venda1.getListaVendaProduto().size());

		/*
		 * testa o método add produto e testa o finalizar venda
		 */
		
//		System.out.println("Tamanho antes: " + venda1.getListaVendaProduto().size());
//		System.out.println("Tamanho antes: " + venda2.getListaVendaProduto().size());
//		venda1.finalizarVenda();
//		venda2.finalizarVenda();
//		venda1.adicionarProduto(produto2);
//		venda2.adicionarProduto(produto3);
//		System.out.println("qnt: " + produto2.getQuantidade());
//		System.out.println("tamanaho dps: " + venda1.getListaVendaProduto().size());
//		System.out.println("Tamanho antes: " + venda2.getListaVendaProduto().size());
		
		/*
		 *  imprime os produtos mais caros e mais barato de uma venda
		 */
		
//		venda1.adicionarProduto(produto2);
//		venda1.adicionarProduto(produto3);
//		venda1.obterProdutosDestaques();
		
		/*
		 *  preço total de uma venda
		 */
		double auxP = 0;
//		venda1.adicionarProduto(produto2);
//		venda1.adicionarProduto(produto3);
		for (int i = 0; i < venda1.getListaVendaProduto().size(); i++) {
			auxP += venda1.getListaVendaProduto().get(i).getPreco();
		}
		venda1.setPrecoTotal(auxP);
//		System.out.println(venda1.getPrecoTotal());
//		
//		System.out.println(venda1.getListaVendaProduto().size());
		
		/*
		 * chama o método salvaVenda
		 */
		
//		venda1.salvarVenda();
//		venda2.salvarVenda();
//		venda3.salvarVenda();		
		
		/*
		 * lê o arquivo salvo em vendas
		 * 
		 * Não deu pra enteder muito bem o que era pra fazer nesse método, então li o arquivo e imprimi
		 * as informações inteligadas
		 */
//		venda1.obterVendas();
//		venda2.obterVendas();
//		venda3.obterVendas();
		
		/*
		 * chama o método salvar vendaProduto
		 */
		
//		vendaProduto1.salvarVendaProduto();
//		vendaProduto2.salvarVendaProduto();
//		vendaProduto3.salvarVendaProduto();
		
		/*
		 * quantidade total de vendas por produto
		 */
			
//		System.out.println(produto1.getQuantidadeVendas());
//		System.out.println(produto2.getQuantidadeVendas());
//		System.out.println(produto3.getQuantidadeVendas());
		
		/*
		 * total arrecadado pela venda de um produto
		 * lembrando que o preço do produto cadastrado pode ser diferente do preço da vendaProduto
		 */
//		produto1.getListaVendaProduto().add(vendaProduto3);
//		System.out.println(produto1.getTotalArrecadado());
		
		/*
		 * 
		 */
//		produto1.getListaVendaProduto().add(vendaProduto3);
//		System.out.println(produto1.getListaCidadeClientes(2).get(0).getNome());
		
		/*
		 *  cadastra um produto similar
		 */
		produto1.cadastrarProdutoSimilar(produto2);
//		System.out.println(produto1.getListaSimilar().size());
//		System.out.println(produto3.getProdutoOriginal().getId());
		
		/*
		 * testa o método excluir produto similar
		 */
//		System.out.println(produto1.getListaSimilar().size());
//		produto1.excluirProdutoSimilar(produto2);
//		System.out.println(produto1.getListaSimilar().size());
		
		/*
		 *  Verifica se o produto é original ou similar e imprime o resultado
		 */
		
//		produto1.ehProdutoMarca();
//		produto2.ehProdutoMarca();
		
		/*
		 * retorna uma lista com os produtos similares
		 */
		
//		for (int i = 0; i < produto1.getListaSimilar().size(); i++) {
//			System.out.println(venda1.obterProdutosSimilares(produto1).get(i).getNome());
//		}
		
		/*
		 *  retorna a comissão do funcionário
		 */
		
//		System.out.println(df.format(funcionario1.GerarComissao(11, 2016)));
//		System.out.println(venda1.getDate().getMonthValue());
//		System.out.println(venda1.getPrecoTotal());
		
		/*
		 *  Salvar produto em arquivo
		 */
		
//		produto1.salvarProduto();
//		produto2.salvarProduto();
//		produto3.salvarProduto();
	
		
		
	}
	

}
