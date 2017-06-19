package POO;

import java.util.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SistemaShow {

	static ArrayList<Artista> listaArtista = new ArrayList<>();
	static ArrayList<EmpresaEventos> listaEmpresa = new ArrayList<>();
	static ArrayList<Gravadora> listaGravadora = new ArrayList<>();
	static ArrayList<Show> listaDeShows = new ArrayList<>();

	public static void main(String[] args) {

		boolean teste = true;
		Artista cadastroArtista = null;
		EmpresaEventos cadastroEmpresa = null;
		Gravadora cadastrarGravadora = null;

		while (teste) {

			String inicio = JOptionPane
					.showInputDialog(
							null,
							"1    Cadastrar Artista\n"
									+ "2    Cadastrar Empresa de Eventos\n"
									+ "3    Cadastrar Show\n"
									+ "4    Cadastrar Gravadora\n"
									+ "5    Contratar Show\n"
									+ "6    Lançar Título\n"
									+ "7    Excluir Título\n"
									+ "8    Buscar Título\n"
									+ "9    Quantidade de Títulos por Ano\n"
									+ "10   Quantidade de Títulos por Gênero\n"
									+ "11   Contratar Artista\n"
									+ "12   Demitir Artista\n"
									+ "13   Vender Show\n"
									+ "14   Artista com Mais Shows\n"
									+ "15   Nome e Nacionalidade de um Artista da Empresa x\n"
									+ "16   Listar Títulos dos Artistas de um Show da Empresa x\n"
									+ "17   Listar Títulos por Gênero\n"
									+ "18   Sair", "Menu Principal",
							JOptionPane.PLAIN_MESSAGE);

			if (inicio == null) {
				JOptionPane.showMessageDialog(null, "Ação Cancelada",
						"Cancelamento", JOptionPane.CANCEL_OPTION);
				break;
			} else {
				int opcao = Integer.parseInt(inicio);

				switch (opcao) {

				case 1: // Cadastrar Artista
					boolean corret = false;
					while (!corret) {
						try {
							cadastroArtista = new Artista(
									JOptionPane.showInputDialog(null,
											"Informe o nome do artista",
											"Nome", JOptionPane.PLAIN_MESSAGE),
									Double.parseDouble(JOptionPane
											.showInputDialog(
													null,
													"Informe o valor do show R$",
													"Valor do Show",
													JOptionPane.PLAIN_MESSAGE)),
									JOptionPane.showInputDialog(null,
											"Informe a nacionalidade",
											"Nacionalidade",
											JOptionPane.PLAIN_MESSAGE));

							listaArtista.add(cadastroArtista);
							corret = true;
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null,
									"Informe apenas numero");
							corret = false;
						}
					}
					break;

				case 2: // Cadastrar Empresa de Eventos

					int CNPJ = Integer.parseInt(JOptionPane.showInputDialog(
							null, "Informe o CNPJ da empresa (xxxxx)", "CNPJ",
							JOptionPane.PLAIN_MESSAGE));

					if (listaEmpresa.size() == 0) {
						String nome = JOptionPane.showInputDialog(null,
								"Informe o nome da empresa", "Nome Fantasia",
								JOptionPane.PLAIN_MESSAGE);

						int quantidadeMaxShow = Integer
								.parseInt(JOptionPane
										.showInputDialog(
												null,
												"Informe a quantidade de shows que a empresa poderá promover",
												"Quantidade de Shows",
												JOptionPane.PLAIN_MESSAGE));

						cadastroEmpresa = new EmpresaEventos(CNPJ, nome,
								quantidadeMaxShow);
						listaEmpresa.add(cadastroEmpresa);

					} else {
						for (int i = 0; i < listaEmpresa.size(); i++) {
							if (listaEmpresa.get(i).getCnpj() == CNPJ) {
								JOptionPane.showMessageDialog(null,
										"Empresa já cadastrada", "Cadastro",
										JOptionPane.ERROR_MESSAGE);
								break;
							} else {
								String nome = JOptionPane.showInputDialog(null,
										"Informe o nome da empresa",
										"Nome Fantasia",
										JOptionPane.PLAIN_MESSAGE);

								int quantidadeMaxShow = Integer
										.parseInt(JOptionPane
												.showInputDialog(
														null,
														"Informe a quantidade de shows que a empresa poderá promover",
														"Quantidade de Shows",
														JOptionPane.PLAIN_MESSAGE));

								cadastroEmpresa = new EmpresaEventos(CNPJ,
										nome, quantidadeMaxShow);
								listaEmpresa.add(cadastroEmpresa);
								break;
							}
						}
					}
					break;

				case 3: // Cadastrar Show

					if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int codigo = Integer.parseInt(JOptionPane
								.showInputDialog(null,
										"Informe o código do show",
										"Código do Show",
										JOptionPane.PLAIN_MESSAGE));

						Date data = new Date(JOptionPane.showInputDialog(null,
								"Infome a data que o show será realizado",
								"Data do Show", JOptionPane.PLAIN_MESSAGE));

						int cod = Integer
								.parseInt(JOptionPane
										.showInputDialog(
												null,
												"Informe o código do artista que realizará o show",
												"Verifica Código",
												JOptionPane.INFORMATION_MESSAGE));
						int temArtista = buscarArtista(cod);

						Artista artista = listaArtista.get(temArtista);
						Show cadastroShow = new Show(codigo, data, artista);
						listaDeShows.add(cadastroShow);
					}
					break;

				case 4: // Cadastrar Gravadora

					cadastrarGravadora = new Gravadora(
							JOptionPane.showInputDialog(null,
									"Informe o nome da gravadora",
									"Nome da Gravadora",
									JOptionPane.PLAIN_MESSAGE),
							JOptionPane.showInputDialog(null,
									"Informe onde fica a sede da gravadora",
									"Locar da Sede", JOptionPane.PLAIN_MESSAGE),
							Integer.parseInt(JOptionPane
									.showInputDialog(
											null,
											"Informe a quantidade inicial de artistas que a gravadora pode contratar",
											"Artistas da Gravadora",
											JOptionPane.PLAIN_MESSAGE)));

					listaGravadora.add(cadastrarGravadora);

					break;

				case 5: // Contratar Show

					if (listaEmpresa.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhuma empresa cadastrada", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else if (listaDeShows.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum show cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int cnpjEmpresa = Integer.parseInt(JOptionPane
								.showInputDialog(null,
										"Informe o CNPJ da empresa (xxxxx)",
										"Verifica CNPJ",
										JOptionPane.INFORMATION_MESSAGE));

						int temEmpresa = buscarEmpresa(cnpjEmpresa);

						if (temEmpresa > -1) {

							int codigoShow = Integer
									.parseInt(JOptionPane
											.showInputDialog(
													null,
													"Informe o código do show que deseja contratar",
													"Verifica Show",
													JOptionPane.INFORMATION_MESSAGE));

							int temShow = buscarShow(codigoShow);

							if (temShow > -1) {
								if (listaEmpresa.get(temEmpresa).contratarShow(
										listaDeShows.get(temShow))) {
									JOptionPane.showMessageDialog(null,
											"Show Contratado", "Contrato",
											JOptionPane.INFORMATION_MESSAGE);
								} else {
									JOptionPane
											.showMessageDialog(
													null,
													"Empresa não pode contratar mais shows",
													"Contrato",
													JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"Show não encontrado", "Busca",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Empresa não encontrada", "Busca",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					break;

				case 6: // Lançar Título

					if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int cod = Integer.parseInt(JOptionPane.showInputDialog(
								null, "Informe o código do artista",
								"Verifica Código",
								JOptionPane.INFORMATION_MESSAGE));
						int temArtista = buscarArtista(cod);
						if (temArtista > -1) {
							Titulo titulo = new Titulo(
									JOptionPane.showInputDialog(null,
											"Informe o gênero musical",
											"Gênero Musical",
											JOptionPane.PLAIN_MESSAGE),
									JOptionPane.showInputDialog(null,
											"Nome do título", "Descrição",
											JOptionPane.PLAIN_MESSAGE),
									Integer.parseInt(JOptionPane
											.showInputDialog(
													null,
													"Informe o ano em que o título foi lançado",
													"Ano de Lançamento",
													JOptionPane.PLAIN_MESSAGE)));
							if (listaArtista.get(temArtista).lancarTitulo(
									titulo)) {
								JOptionPane.showMessageDialog(null,
										"Titulo cadastrado com sucesso",
										"Cadastro",
										JOptionPane.INFORMATION_MESSAGE);
							} else
								JOptionPane.showMessageDialog(null,
										"Não foi possivel cadastrar o titulo",
										"Cadastro",
										JOptionPane.INFORMATION_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null,
									"Artista não encontrado",
									"Código Inválido",
									JOptionPane.ERROR_MESSAGE);
						}

					}

					break;

				case 7: // Excluir Título

					if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {

						int cod = Integer.parseInt(JOptionPane.showInputDialog(
								null, "Informe o código do artista",
								"Verifica Código",
								JOptionPane.INFORMATION_MESSAGE));

						int temArtista = buscarArtista(cod);

						if (temArtista > -1) {
							int codTitulo = Integer.parseInt(JOptionPane
									.showInputDialog(null,
											"Informe o código do título",
											"Título por Código",
											JOptionPane.INFORMATION_MESSAGE));

							if (listaArtista.get(temArtista).excluirTitulo(
									codTitulo)) {
								JOptionPane.showMessageDialog(null,
										"Titulo excluído com sucesso",
										"Cadastro",
										JOptionPane.INFORMATION_MESSAGE);
							} else
								JOptionPane.showMessageDialog(null,
										"Não foi possivel excluir o titulo",
										"Cadastro",
										JOptionPane.INFORMATION_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null,
									"Artista não encontrado",
									"Código Inválido",
									JOptionPane.ERROR_MESSAGE);
						}

					}
					break;

				case 8: // Buscar Título

					if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int cod = Integer.parseInt(JOptionPane.showInputDialog(
								null, "Informe o código do artista",
								"Verifica Código",
								JOptionPane.INFORMATION_MESSAGE));
						int temArtista = buscarArtista(cod);

						if (temArtista > -1) {
							int codTitulo = Integer.parseInt(JOptionPane
									.showInputDialog(null,
											"Informe o código do título",
											"Título por Código",
											JOptionPane.INFORMATION_MESSAGE));
							Titulo t = listaArtista.get(temArtista)
									.buscarTitulo(codTitulo);

							if (t != null) {
								JOptionPane.showMessageDialog(
										null,
										"Gênero: " + t.getGenero() + "\n"
												+ "Descrição : "
												+ t.getDescricao() + "\n"
												+ "Ano: " + t.getAnoLanc(),
										"Informações Sobre o Título",
										JOptionPane.INFORMATION_MESSAGE);
							} else
								JOptionPane.showMessageDialog(null,
										"Não foi possivel buscar o título",
										"Buscar", JOptionPane.ERROR_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null,
									"Artista não encontrado",
									"Código Inválido",
									JOptionPane.ERROR_MESSAGE);
						}

					}
					break;

				case 9: // Quantidade de Títulos por Ano

					if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int cod = Integer.parseInt(JOptionPane.showInputDialog(
								null, "Informe o código do artista",
								"Verifica Código",
								JOptionPane.INFORMATION_MESSAGE));
						int temArtista = buscarArtista(cod);

						if (temArtista > -1) {
							int ano = Integer
									.parseInt(JOptionPane
											.showInputDialog(
													null,
													"Informe o ano que deseja pesquisar",
													"Título Ano",
													JOptionPane.INFORMATION_MESSAGE));
							int t = listaArtista.get(temArtista)
									.verificaTitulo(ano);

							if (t > 0) {
								JOptionPane.showMessageDialog(null, t,
										"Quantidade de Títulos por Ano",
										JOptionPane.INFORMATION_MESSAGE);
							} else
								JOptionPane.showMessageDialog(null,
										"Não houve título lançado", "Buscar",
										JOptionPane.ERROR_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null,
									"Artista não encontrado",
									"Código Inválido",
									JOptionPane.ERROR_MESSAGE);
						}

					}

					break;

				case 10: // Quantidade de Títulos por Gênero

					if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int cod = Integer.parseInt(JOptionPane.showInputDialog(
								null, "Informe o código do artista",
								"Verifica Código",
								JOptionPane.INFORMATION_MESSAGE));
						int temArtista = buscarArtista(cod);

						if (temArtista > -1) {
							String genero = JOptionPane.showInputDialog(null,
									"Informe o gênero musical "
											+ "que deseja pesquisar",
									"Título Gênero",
									JOptionPane.INFORMATION_MESSAGE);
							int qnt = listaArtista.get(temArtista)
									.quantidadeTituloGenero(genero);
							if (qnt > 0) {
								JOptionPane.showMessageDialog(null, qnt,
										"Quantidade de Títulos por Gênero",
										JOptionPane.INFORMATION_MESSAGE);
							} else
								JOptionPane.showMessageDialog(null,
										"Não há títulos deste gênero",
										"Buscar", JOptionPane.ERROR_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null,
									"Artista não encontrado",
									"Código Inválido",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					break;

				case 11: // Contratar Artista

					if (listaGravadora.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhuma gravadora cadastrada", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {

						int codGravadora = Integer
								.parseInt(JOptionPane
										.showInputDialog(
												null,
												"Informe o código da gravadora que irá contratar",
												"Verifica Código",
												JOptionPane.INFORMATION_MESSAGE));
						int temGravadora = buscarGravadora(codGravadora);

						if (temGravadora > -1) {
							int cod = Integer
									.parseInt(JOptionPane
											.showInputDialog(
													null,
													"Informe o "
															+ "código do artista que deseja contratar",
													"Verifica Código",
													JOptionPane.INFORMATION_MESSAGE));
							int temArtista = buscarArtista(cod);

							if (temArtista > -1) {
								if (listaGravadora.get(codGravadora)
										.contratarArtista(
												listaArtista.get(temArtista))) {
									JOptionPane.showMessageDialog(null,
											"Artista contratado com sucesso",
											"Contrato",
											JOptionPane.INFORMATION_MESSAGE);
								} else {
									JOptionPane.showMessageDialog(null,
											"Artista já contratado",
											"Contrato",
											JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"Artista não encontrado",
										"Código Inválido",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Gravadora não encontrada",
									"Código Inválido",
									JOptionPane.ERROR_MESSAGE);
						}
					}
					break;

				case 12: // Demitir Artista

					if (listaGravadora.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhuma gravadora cadastrada", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {

						int codGravadora = Integer.parseInt(JOptionPane
								.showInputDialog(null,
										"Informe o código da gravadora",
										"Verifica Código",
										JOptionPane.INFORMATION_MESSAGE));
						int temGravadora = buscarGravadora(codGravadora);

						if (temGravadora > -1) {
							// String str = new String();
							// for (int i = 0; i < listaArtista.size(); i++) {
							// str +=("Codigo :
							// "+listaArtista.get(i).getCodigo()+"\n"+
							// "Nome : "+listaArtista.get(i).getNome());
							// str += ("\n\n");
							// }
							int cod = Integer.parseInt(JOptionPane
									.showInputDialog(null,
											"Informe o código do artista",
											"Verifica Código",
											JOptionPane.INFORMATION_MESSAGE));
							int temArtista = buscarArtista(cod);

							if (temArtista > -1
									&& listaGravadora.get(codGravadora)
											.demitirArtista(
													listaArtista
															.get(temArtista)
															.getCodigo())) {
								JOptionPane.showMessageDialog(null,
										"Artista Demitido", "Demissão",
										JOptionPane.INFORMATION_MESSAGE);

							} else {
								JOptionPane.showMessageDialog(null,
										"Artista não encontrado",
										"Código Inválido",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Gravadora não encontrada",
									"Código Inválido",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					break;

				case 13: // Vender Show
					boolean contem = false;
					if (listaGravadora.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhuma gravadora cadastrada", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int codGravadora = Integer.parseInt(JOptionPane
								.showInputDialog(null,
										"Informe o código da gravadora",
										"Verifica Código",
										JOptionPane.INFORMATION_MESSAGE));
						int temGravadora = buscarGravadora(codGravadora);

						if (temGravadora > -1) {

							if (listaArtista.size() == 0) {
								JOptionPane.showMessageDialog(null,
										"Nenhum artista cadastrado",
										"Cadastro", JOptionPane.ERROR_MESSAGE);
							} else {
								int cod = Integer
										.parseInt(JOptionPane
												.showInputDialog(
														null,
														"Informe o código do artista",
														"Verifica Código",
														JOptionPane.INFORMATION_MESSAGE));
								int temArtista = buscarArtista(cod);
								if (temArtista > -1) {
									for (int i = 0; i < listaGravadora
											.get(temGravadora).getArtistas()
											.size(); i++) {
										if (listaGravadora.get(temGravadora)
												.getArtistas().get(i)
												.getCodigo() == cod) {

											double valor = listaGravadora.get(
													temGravadora).venderShow(
													temArtista);
											JOptionPane
													.showMessageDialog(
															null,
															valor,
															"Valor do Show R$ ",
															JOptionPane.INFORMATION_MESSAGE);
											contem = true;
											break;
										}
									}
									if (!contem) {
										JOptionPane
												.showMessageDialog(
														null,
														"O artista não pertence a gravadora",
														"Erro",
														JOptionPane.ERROR_MESSAGE);
									}
								} else {
									JOptionPane.showMessageDialog(null,
											"Artista não encontrado",
											"Código Inválido",
											JOptionPane.ERROR_MESSAGE);
								}
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Gravadora não encontrada", "Busca",
									JOptionPane.ERROR_MESSAGE);
						}
					}
					break;

				case 14: // Artista com Mais Shows

					if (listaGravadora.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhuma gravadora cadastrada", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int codGravadora = Integer.parseInt(JOptionPane
								.showInputDialog(null,
										"Informe o código da gravadora",
										"Verifica Código",
										JOptionPane.INFORMATION_MESSAGE));
						int temGravadora = buscarGravadora(codGravadora);

						if (temGravadora > -1) {

							if (listaArtista.size() == 0) {
								JOptionPane.showMessageDialog(null,
										"Nenhum artista cadastrado",
										"Cadastro", JOptionPane.ERROR_MESSAGE);
							} else {
								String artistaComMaisShows = listaGravadora
										.get(temGravadora).artistaShow();
								JOptionPane
										.showMessageDialog(
												null,
												artistaComMaisShows,
												"Artista que Realizou Mais Shows"
														+ listaGravadora.get(
																temGravadora)
																.getNome(),
												JOptionPane.INFORMATION_MESSAGE);

							}

						} else {
							JOptionPane.showMessageDialog(null,
									"Gravadora não encontrada", "Busca",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					break;

				case 15: // nome por show de empresa

					if (listaEmpresa.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhuma empresa cadastrada", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int cnpjEmpresa = Integer.parseInt(JOptionPane
								.showInputDialog(null,
										"Informe o CNPJ da empresa (xxxxx)",
										"Verifica CNPJ",
										JOptionPane.INFORMATION_MESSAGE));

						int temEmpresa = buscarEmpresa(cnpjEmpresa);

						if (temEmpresa > -1) {

							if (listaDeShows.size() == 0) {
								JOptionPane.showMessageDialog(null,
										"Nenhum show cadastrado", "Erro",
										JOptionPane.ERROR_MESSAGE);
							} else if (listaEmpresa.get(temEmpresa)
									.getListaShow().size() == 0) {
								JOptionPane.showMessageDialog(null,
										"A empresa não contratou nenhum show",
										"Erro", JOptionPane.ERROR_MESSAGE);

							} else {
								listaEmpresa.get(temEmpresa)
										.listarArtistasShow();
							}
						}
					}

					break;

				case 16:

					if (listaEmpresa.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhuma empresa cadastrada", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int cnpjEmpresa = Integer.parseInt(JOptionPane
								.showInputDialog(null,
										"Informe o CNPJ da empresa (xxxxx)",
										"Verifica CNPJ",
										JOptionPane.INFORMATION_MESSAGE));

						int temEmpresa = buscarEmpresa(cnpjEmpresa);

						if (temEmpresa > -1) {

							if (listaDeShows.size() == 0) {
								JOptionPane.showMessageDialog(null,
										"Nenhum show cadastrado", "Erro",
										JOptionPane.ERROR_MESSAGE);
							} else if (listaEmpresa.get(temEmpresa)
									.getListaShow().size() == 0) {
								JOptionPane.showMessageDialog(null,
										"A empresa não contratou nenhum show",
										"Erro", JOptionPane.ERROR_MESSAGE);

							} else {
								listaEmpresa.get(temEmpresa)
										.listarTitulosArtistaShow();

							}
						}
					}

					break;

				case 17:

					if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int cod = Integer.parseInt(JOptionPane.showInputDialog(
								null, "Informe o código do artista",
								"Verifica Código",
								JOptionPane.INFORMATION_MESSAGE));
						int temArtista = buscarArtista(cod);

						if (temArtista > -1) {

							String genero = JOptionPane.showInputDialog(null,
									"Informe o gênero que deseja",
									"Titulo por Gênero", JOptionPane.INFORMATION_MESSAGE);
							listaArtista.get(temArtista).listarTitulos(genero);

						} else {
							JOptionPane.showMessageDialog(null,
									"Artista não encontrado",
									"Código Inválido",
									JOptionPane.ERROR_MESSAGE);
						}

					}

					break;

				case 18: // Sair
					teste = false;
					break;

				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida");
					break;
				}
			}
		}
	}

	/**
	 * Os métodos abaixo retornam a posição que se encontra o artista, o show, a
	 * gravadora e a empresa em suas devidas listas
	 * 
	 * @param
	 * @return
	 */

	private static int buscarArtista(int codigoArtista) {
		int codigo = -1;
		for (int i = 0; i < listaArtista.size(); i++) {
			if (codigoArtista == listaArtista.get(i).getCodigo()) {
				codigo = i;
				break;
			}
		}
		return codigo;
	}

	private static int buscarShow(int codigoShow) {
		int codigo = -1;
		for (int i = 0; i < listaDeShows.size(); i++) {
			if (codigoShow == listaDeShows.get(i).getCodigo()) {
				codigo = i;
				break;
			}
		}
		return codigo;
	}

	private static int buscarGravadora(int codigoGravadora) {
		int codigo = -1;
		for (int i = 0; i < listaGravadora.size(); i++) {
			if (codigoGravadora == listaGravadora.get(i).getCodigo()) {
				codigo = i;
				break;
			}
		}
		return codigo;
	}

	private static int buscarEmpresa(int cnpjEmpresa) {
		int cnpj = -1;
		for (int i = 0; i < listaEmpresa.size(); i++) {
			if (cnpjEmpresa == listaEmpresa.get(i).getCnpj()) {
				cnpj = i;
				break;
			}
		}
		return cnpj;
	}
}
