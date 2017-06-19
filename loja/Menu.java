package loja;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Menu {

	static LocalTime time = LocalTime.now();              //pega a hora, minuto e segundo do sistema
	static DecimalFormat df = new DecimalFormat("0.00");  //define o duas casas decimais
	static ArrayList<Departamento> listaDepartamento = new ArrayList<>();
	static ArrayList<Estado> listaEstados= new ArrayList<>();
	static ArrayList<Cliente> listaClienteAux= new ArrayList<>();
	static ArrayList<Funcionario> listaFuncionarioAux= new ArrayList<>();
	static ArrayList<Venda> listaVendaAux= new ArrayList<>();
	static ArrayList<Produto> listaProduto= new ArrayList<>();
	static ArrayList<VendaProduto> listaVendaProdAux= new ArrayList<>();

	public static void main(String[] args) {

		boolean teste = true;

		while (teste) {

			String menu = JOptionPane.showInputDialog(null,
							  "1  - Cadastrar Departamento \n" 
							+ "2  - Contratar Funcionário\n" 
							+ "3  - Cadastrar Estado\n"
							+ "4  - Cadastrar Cidade\n"
							+ "5  - Cadastrar Cliente\n"
							+ "-----------------------------Menu Vendas-------------------------------\n"
							+ "6  - Cadastrar Venda\n"
							+ "7  - Vender Produtos\n"
							+ "8  - Adicionar produto\n"
							+ "9  - Remover Produto\n"
							+ "10 - Finalizar Venda\n"
							+ "11 - Preço Total da Venda"
							+ "12 - Obter Produtos Destaques (mais barato e mais caro)\n"
							+ "13 - Obter Produtos Similares\n"
							+ "-----------------------------Menu Produtos-----------------------------\n"
							+ "14 - Cadastrar Produtos\n"
							+ "15 - Obter Quantidade de Vendas\n"
							+ "16 - Obter Total de Venda Arrecadado\n"
							+ "17 - Obter Lista de Clientes por Cidade\n"
							+ "18 - Cadastrar Produto Similar\n"
							+ "19 - Excluir Produto Similar\n"
							+ "20 - Identificar Produto Original e Similar\n"
							+ "0  - Sair", "MENU PRINCIPAL",
					JOptionPane.PLAIN_MESSAGE);

			if (menu == null){
				JOptionPane.showMessageDialog(null, "Ação Cancelada", "Cancelamento", JOptionPane.CANCEL_OPTION);
				break;
			} else {
				int opcao = Integer.parseInt(menu);

				switch (opcao) {

				case 1: // Cadastrar Departamento
					String nome = JOptionPane.showInputDialog(null, "Informe o nome do departamento", "Departamento",
							JOptionPane.INFORMATION_MESSAGE);
					String sigla = JOptionPane.showInputDialog(null, "Informe a sigla do departamento", "Sigla",
							JOptionPane.INFORMATION_MESSAGE);
					Departamento dep = new Departamento(nome, sigla);
					listaDepartamento.add(dep);
					break;

				case 2: // Contratar funcionário
					if (listaDepartamento.size() == 0) {
						JOptionPane.showMessageDialog(null, "Nenhum departamento cadastrado", "Erro",
								JOptionPane.ERROR_MESSAGE);
					} else {

						int id = Integer.parseInt(
								JOptionPane.showInputDialog(null, "Informe o número identificador do departamento",
										"" + "Número Identificador", JOptionPane.INFORMATION_MESSAGE));
						int temDepartamento = buscarDepartamento(id);
						if (temDepartamento > -1) {
							nome = JOptionPane.showInputDialog(null, "Informe o nome", "Nome do Funcionário",
									JOptionPane.INFORMATION_MESSAGE);
							String matricula = JOptionPane.showInputDialog(null, "Informe a matrícula",
									"Matrícula do Funcionário", JOptionPane.INFORMATION_MESSAGE);
							String senha = JOptionPane.showInputDialog(null, "Informe a senha de acesso",
									"Senha do Funcionário", JOptionPane.INFORMATION_MESSAGE);
							Departamento departamento = listaDepartamento.get(temDepartamento);
							Funcionario funcionario = new Funcionario(nome, matricula, senha, departamento);
							listaFuncionarioAux.add(funcionario);
							if(!listaDepartamento.contains(funcionario)){
								JOptionPane.showMessageDialog(null, "Contradado com sucesso", "Contratação",
										JOptionPane.INFORMATION_MESSAGE);														 
							} else {
								JOptionPane.showMessageDialog(null, "Funcionário já contratado", "Erro",
										JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(null, "Departamento não encontrado", "Erro",
									JOptionPane.ERROR_MESSAGE);
						}
					}
					break;
				case 3: //cadastrar estado
					nome = JOptionPane.showInputDialog(null, "Informe o nome do estado", "Nome do Estado",
								JOptionPane.INFORMATION_MESSAGE);
					sigla = JOptionPane.showInputDialog(null, "Informe a sigla do estado", "Sigla",
								JOptionPane.INFORMATION_MESSAGE);
					Estado estado = new Estado(nome, sigla);	
					listaEstados.add(estado);					
					break;
					
				case 4: //cadastrar cidade
					if (listaEstados.size() == 0) {
						JOptionPane.showMessageDialog(null, "Nenhum estado cadastrado", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}else {
						int id = Integer
								.parseInt(JOptionPane.showInputDialog(null, "Informe o número identificador do estado",
										"" + "Número Identificador", JOptionPane.INFORMATION_MESSAGE));
						int temEstado = buscarEstado(id);
						if(temEstado > -1){
							String nomeCidade = JOptionPane.showInputDialog(null, "Informe o nome da cidade", "Nome da Cidade",
									JOptionPane.INFORMATION_MESSAGE);
							String siglaCidade = JOptionPane.showInputDialog(null, "Informe a sigla da cidade", "Sigla",
									JOptionPane.INFORMATION_MESSAGE);
							estado = listaEstados.get(temEstado);
							Cidade cidade = new Cidade(nomeCidade, siglaCidade, estado);
							estado.getListaCidade().add(cidade);							
						}
					}
					break;
					
				case 5: //cadastrar cliente
					// para executar esse método é necessário cadastrar estado e cidade antes

					String nomeCliente = JOptionPane.showInputDialog(null, "Informe o nome do cliente", "Dados do Cliente", JOptionPane.INFORMATION_MESSAGE);
					String cpf_cnpj = JOptionPane.showInputDialog(null, "Informe o CPF ou CNPJ do cliente", "Dados do Cliente", JOptionPane.INFORMATION_MESSAGE);
					String telefone = JOptionPane.showInputDialog(null, "Informe o telefone do cliente", "Dados do Cliente", JOptionPane.INFORMATION_MESSAGE);
					
					JOptionPane.showMessageDialog(null, "Informe endereço do cliente", "Dados do Cliente", JOptionPane.INFORMATION_MESSAGE);
					
					String rua = JOptionPane.showInputDialog(null, "Nome da rua: ", "Dados do Cliente", JOptionPane.INFORMATION_MESSAGE);
					int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Nº", "Dados do Cliente", JOptionPane.INFORMATION_MESSAGE));
					String bairro = JOptionPane.showInputDialog(null, "Bairro: ", "Dados do Cliente", JOptionPane.INFORMATION_MESSAGE);
					String cep = JOptionPane.showInputDialog(null, "CEP (somente números): ", "Dados do Cliente", JOptionPane.INFORMATION_MESSAGE);
					String nomeCidade = JOptionPane.showInputDialog(null, "Cidade: ", "Dados do Cliente", JOptionPane.INFORMATION_MESSAGE);
					String nomeEstado = JOptionPane.showInputDialog(null, "Estado: ", "Dados do Cliente", JOptionPane.INFORMATION_MESSAGE);
					for (int i = 0; i < listaEstados.size(); i++) {
						if(listaEstados.get(i).getNome().equalsIgnoreCase(nomeEstado)){
							for (int j = 0; j < listaEstados.get(i).getListaCidade().size(); j++) {
								if(listaEstados.get(i).getListaCidade().get(j).equals(nomeCidade)){
									Endereco endereco = new Endereco(rua, numero, bairro, cep, listaEstados.get(i).getListaCidade().get(j));
									Cliente cliente = new Cliente(nomeCliente, cpf_cnpj, telefone, endereco);
									listaEstados.get(i).getListaCidade().get(j).getListaCliente().add(cliente);
									listaClienteAux.add(cliente);
									break;
								}else{
									JOptionPane.showMessageDialog(null, "Cidade não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, "Estado não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}			
				
				case 6: //cadastrar venda					
					if(listaClienteAux.size() == 0){
						JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
					}else if(listaFuncionarioAux.size() == 0){
						JOptionPane.showMessageDialog(null, "Nenhum Funcionário cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
					}else{
						String matricula = JOptionPane.showInputDialog(null, "Informe a matrícula do Funcionário",
								"" + "Identificação do Funcionário", JOptionPane.INFORMATION_MESSAGE);
						int idFuncionario = Integer.parseInt(matricula);
						int temFuncionario = buscarCliente(idFuncionario);
						cpf_cnpj = JOptionPane.showInputDialog(null, "Informe o CPF ou CNPJ do cliente",
										"" + "Identificação do Cliente", JOptionPane.INFORMATION_MESSAGE);						
						int id = Integer.parseInt(cpf_cnpj);
						int temCliente = buscarCliente(id);
						if(temCliente > -1){
							if(temFuncionario > -1){
								JOptionPane.showMessageDialog(null, "Informe a data da venda");
								int dia = Integer.parseInt(JOptionPane.showInputDialog(null,"Dia", "Data", JOptionPane.INFORMATION_MESSAGE));
								int mes = Integer.parseInt(JOptionPane.showInputDialog(null,"Mês", "Data", JOptionPane.INFORMATION_MESSAGE));
								int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Ano", "Data",
										JOptionPane.INFORMATION_MESSAGE));
								int hora = time.getHour();
								int minuto = time.getMinute();
								int segundos = time.getSecond();

								Venda venda = new Venda(LocalDateTime.of(ano, mes, dia, hora, minuto, segundos),
										listaClienteAux.get(temCliente), listaFuncionarioAux.get(temFuncionario));
								venda.getFuncionario().getListaVenda().add(venda);
								venda.getCliente().getListaCompra().add(venda);
								listaVendaAux.add(venda);
							} else {
								JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado", "Erro",
										JOptionPane.ERROR_MESSAGE);
							}					
						}else{
							JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}					
					break;
					
				case 7: //Vender produto
					if(listaVendaAux.size() == 0){
						JOptionPane.showMessageDialog(null, "Nenhuma venda cadastrada", "Erro", JOptionPane.ERROR_MESSAGE);
					}else if(listaProduto.size() == 0){
						JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
					}else{
						int idVenda = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o código da venda", "Id da Venda", JOptionPane.INFORMATION_MESSAGE));
						int temVenda = buscarVenda(idVenda);
						if(temVenda > -1){
							int idProduto = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o código do produto", "Id do Produto", JOptionPane.INFORMATION_MESSAGE));
							int temProduto = buscarProduto(idProduto);
							if(temProduto > -1){
								Produto produto = listaProduto.get(temProduto);
								Venda venda = listaVendaAux.get(temVenda);
								int preco = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o preço", "Quantidade", JOptionPane.INFORMATION_MESSAGE));
								int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a quantidade", "Quantidade", JOptionPane.INFORMATION_MESSAGE));
								if(produto.getQuantidade() < quantidade){
									JOptionPane.showMessageDialog(null, "Quantidade indisponível");
								}else{
									VendaProduto vendaProduto = new VendaProduto(produto, preco, quantidade);
									listaVendaAux.get(temVenda).getListaVendaProduto().add(vendaProduto);
									listaProduto.get(temProduto).getListaVendaProduto().add(vendaProduto);
									listaVendaProdAux.add(vendaProduto);
								}
							}else{
								JOptionPane.showMessageDialog(null, "Código Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(null, "Código Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					break;
					
					
				case 8: //adicionar produto
					break;
				case 9: //remover produto
					break;
				case 10: //finalizar venda
					break;
				case 11: //Valor totar das vendas 
					break;
				case 12: //obter produto destaque
					break;
				case 13: //obter prod. similar
					break;
					
				case 14: //cadastrar produto
					String nomeProduto = JOptionPane.showInputDialog(null, "Informe o nome do produto", "Nome", JOptionPane.INFORMATION_MESSAGE);
					String descricao = JOptionPane.showInputDialog(null, "Descrição do produto", "Descrição", JOptionPane.INFORMATION_MESSAGE);
					int preco = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o preço do produto", "Preço", JOptionPane.INFORMATION_MESSAGE));
					int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade", "Quantidade", JOptionPane.INFORMATION_MESSAGE));
					Produto produto = new Produto(nomeProduto, descricao, preco, quantidade);
					listaProduto.add(produto);
					break;
					
				case 15: //obter quantidade de vendas
					break;
				case 16: //obter total arrecadado
					break;
				case 17: //obter lista de clientes por cidade
					break;
				case 18: //cadastrar prod. similar
					break;
				case 19: //excluir produto similar
					break;
				case 20: //identificar prod. similar ou marca
					break;
					
					
				case 0:				
					teste = false;
					break;
				
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}		
	}
		
		
	private static int buscarDepartamento(int idDepartamento) {
		int codigo = -1;
		for (int i = 0; i < listaDepartamento.size(); i++) {
			if (idDepartamento == listaDepartamento.get(i).getId()) {
				codigo = i;
				break;
			}
		}
		return codigo;
	}
	
	private static int buscarEstado(int idEstado) {
		int codigo = -1;
		for (int i = 0; i < listaEstados.size(); i++) {
			if (idEstado == listaEstados.get(i).getId()) {
				codigo = i;
				break;
			}
		}
		return codigo;
	}
	
	private static int buscarCliente(int idCliente) {
		int codigo = -1;
		String aux = Integer.toString(idCliente);
		for (int i = 0; i < listaClienteAux.size(); i++) {
			if (aux.equals( listaClienteAux.get(i).getCpf_cnpj())) {
				codigo = i;
				break;
			}
		}
		return codigo;
	}
	
	private static int buscarFuncionario(int idFuncionario) {
		int codigo = -1;
		String aux = Integer.toString(idFuncionario);
		for (int i = 0; i < listaFuncionarioAux.size(); i++) {
			if (aux.equals( listaFuncionarioAux.get(i).getMatricula())) {
				codigo = i;
				break;
			}
		}
		return codigo;
	}
	
	private static int buscarVenda(int idVenda) {
		int codigo = -1;		
		for (int i = 0; i < listaVendaAux.size(); i++) {
			if (idVenda == listaVendaAux.get(i).getCodigo()) {
				codigo = i;
				break;
			}
		}
		return codigo;
	}
	
	private static int buscarProduto(int idProduto) {
		int codigo = -1;		
		for (int i = 0; i < listaProduto.size(); i++) {
			if (idProduto == listaProduto.get(i).getId()) {
				codigo = i;
				break;
			}
		}
		return codigo;
	}
}
