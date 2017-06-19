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
									+ "6    Lan�ar T�tulo\n"
									+ "7    Excluir T�tulo\n"
									+ "8    Buscar T�tulo\n"
									+ "9    Quantidade de T�tulos por Ano\n"
									+ "10   Quantidade de T�tulos por G�nero\n"
									+ "11   Contratar Artista\n"
									+ "12   Demitir Artista\n"
									+ "13   Vender Show\n"
									+ "14   Artista com Mais Shows\n"
									+ "15   Nome e Nacionalidade de um Artista da Empresa x\n"
									+ "16   Listar T�tulos dos Artistas de um Show da Empresa x\n"
									+ "17   Listar T�tulos por G�nero\n"
									+ "18   Sair", "Menu Principal",
							JOptionPane.PLAIN_MESSAGE);

			if (inicio == null) {
				JOptionPane.showMessageDialog(null, "A��o Cancelada",
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
												"Informe a quantidade de shows que a empresa poder� promover",
												"Quantidade de Shows",
												JOptionPane.PLAIN_MESSAGE));

						cadastroEmpresa = new EmpresaEventos(CNPJ, nome,
								quantidadeMaxShow);
						listaEmpresa.add(cadastroEmpresa);

					} else {
						for (int i = 0; i < listaEmpresa.size(); i++) {
							if (listaEmpresa.get(i).getCnpj() == CNPJ) {
								JOptionPane.showMessageDialog(null,
										"Empresa j� cadastrada", "Cadastro",
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
														"Informe a quantidade de shows que a empresa poder� promover",
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
										"Informe o c�digo do show",
										"C�digo do Show",
										JOptionPane.PLAIN_MESSAGE));

						Date data = new Date(JOptionPane.showInputDialog(null,
								"Infome a data que o show ser� realizado",
								"Data do Show", JOptionPane.PLAIN_MESSAGE));

						int cod = Integer
								.parseInt(JOptionPane
										.showInputDialog(
												null,
												"Informe o c�digo do artista que realizar� o show",
												"Verifica C�digo",
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
													"Informe o c�digo do show que deseja contratar",
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
													"Empresa n�o pode contratar mais shows",
													"Contrato",
													JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"Show n�o encontrado", "Busca",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Empresa n�o encontrada", "Busca",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					break;

				case 6: // Lan�ar T�tulo

					if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int cod = Integer.parseInt(JOptionPane.showInputDialog(
								null, "Informe o c�digo do artista",
								"Verifica C�digo",
								JOptionPane.INFORMATION_MESSAGE));
						int temArtista = buscarArtista(cod);
						if (temArtista > -1) {
							Titulo titulo = new Titulo(
									JOptionPane.showInputDialog(null,
											"Informe o g�nero musical",
											"G�nero Musical",
											JOptionPane.PLAIN_MESSAGE),
									JOptionPane.showInputDialog(null,
											"Nome do t�tulo", "Descri��o",
											JOptionPane.PLAIN_MESSAGE),
									Integer.parseInt(JOptionPane
											.showInputDialog(
													null,
													"Informe o ano em que o t�tulo foi lan�ado",
													"Ano de Lan�amento",
													JOptionPane.PLAIN_MESSAGE)));
							if (listaArtista.get(temArtista).lancarTitulo(
									titulo)) {
								JOptionPane.showMessageDialog(null,
										"Titulo cadastrado com sucesso",
										"Cadastro",
										JOptionPane.INFORMATION_MESSAGE);
							} else
								JOptionPane.showMessageDialog(null,
										"N�o foi possivel cadastrar o titulo",
										"Cadastro",
										JOptionPane.INFORMATION_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null,
									"Artista n�o encontrado",
									"C�digo Inv�lido",
									JOptionPane.ERROR_MESSAGE);
						}

					}

					break;

				case 7: // Excluir T�tulo

					if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {

						int cod = Integer.parseInt(JOptionPane.showInputDialog(
								null, "Informe o c�digo do artista",
								"Verifica C�digo",
								JOptionPane.INFORMATION_MESSAGE));

						int temArtista = buscarArtista(cod);

						if (temArtista > -1) {
							int codTitulo = Integer.parseInt(JOptionPane
									.showInputDialog(null,
											"Informe o c�digo do t�tulo",
											"T�tulo por C�digo",
											JOptionPane.INFORMATION_MESSAGE));

							if (listaArtista.get(temArtista).excluirTitulo(
									codTitulo)) {
								JOptionPane.showMessageDialog(null,
										"Titulo exclu�do com sucesso",
										"Cadastro",
										JOptionPane.INFORMATION_MESSAGE);
							} else
								JOptionPane.showMessageDialog(null,
										"N�o foi possivel excluir o titulo",
										"Cadastro",
										JOptionPane.INFORMATION_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null,
									"Artista n�o encontrado",
									"C�digo Inv�lido",
									JOptionPane.ERROR_MESSAGE);
						}

					}
					break;

				case 8: // Buscar T�tulo

					if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int cod = Integer.parseInt(JOptionPane.showInputDialog(
								null, "Informe o c�digo do artista",
								"Verifica C�digo",
								JOptionPane.INFORMATION_MESSAGE));
						int temArtista = buscarArtista(cod);

						if (temArtista > -1) {
							int codTitulo = Integer.parseInt(JOptionPane
									.showInputDialog(null,
											"Informe o c�digo do t�tulo",
											"T�tulo por C�digo",
											JOptionPane.INFORMATION_MESSAGE));
							Titulo t = listaArtista.get(temArtista)
									.buscarTitulo(codTitulo);

							if (t != null) {
								JOptionPane.showMessageDialog(
										null,
										"G�nero: " + t.getGenero() + "\n"
												+ "Descri��o : "
												+ t.getDescricao() + "\n"
												+ "Ano: " + t.getAnoLanc(),
										"Informa��es Sobre o T�tulo",
										JOptionPane.INFORMATION_MESSAGE);
							} else
								JOptionPane.showMessageDialog(null,
										"N�o foi possivel buscar o t�tulo",
										"Buscar", JOptionPane.ERROR_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null,
									"Artista n�o encontrado",
									"C�digo Inv�lido",
									JOptionPane.ERROR_MESSAGE);
						}

					}
					break;

				case 9: // Quantidade de T�tulos por Ano

					if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int cod = Integer.parseInt(JOptionPane.showInputDialog(
								null, "Informe o c�digo do artista",
								"Verifica C�digo",
								JOptionPane.INFORMATION_MESSAGE));
						int temArtista = buscarArtista(cod);

						if (temArtista > -1) {
							int ano = Integer
									.parseInt(JOptionPane
											.showInputDialog(
													null,
													"Informe o ano que deseja pesquisar",
													"T�tulo Ano",
													JOptionPane.INFORMATION_MESSAGE));
							int t = listaArtista.get(temArtista)
									.verificaTitulo(ano);

							if (t > 0) {
								JOptionPane.showMessageDialog(null, t,
										"Quantidade de T�tulos por Ano",
										JOptionPane.INFORMATION_MESSAGE);
							} else
								JOptionPane.showMessageDialog(null,
										"N�o houve t�tulo lan�ado", "Buscar",
										JOptionPane.ERROR_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null,
									"Artista n�o encontrado",
									"C�digo Inv�lido",
									JOptionPane.ERROR_MESSAGE);
						}

					}

					break;

				case 10: // Quantidade de T�tulos por G�nero

					if (listaArtista.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"Nenhum artista cadastrado", "Cadastro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int cod = Integer.parseInt(JOptionPane.showInputDialog(
								null, "Informe o c�digo do artista",
								"Verifica C�digo",
								JOptionPane.INFORMATION_MESSAGE));
						int temArtista = buscarArtista(cod);

						if (temArtista > -1) {
							String genero = JOptionPane.showInputDialog(null,
									"Informe o g�nero musical "
											+ "que deseja pesquisar",
									"T�tulo G�nero",
									JOptionPane.INFORMATION_MESSAGE);
							int qnt = listaArtista.get(temArtista)
									.quantidadeTituloGenero(genero);
							if (qnt > 0) {
								JOptionPane.showMessageDialog(null, qnt,
										"Quantidade de T�tulos por G�nero",
										JOptionPane.INFORMATION_MESSAGE);
							} else
								JOptionPane.showMessageDialog(null,
										"N�o h� t�tulos deste g�nero",
										"Buscar", JOptionPane.ERROR_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null,
									"Artista n�o encontrado",
									"C�digo Inv�lido",
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
												"Informe o c�digo da gravadora que ir� contratar",
												"Verifica C�digo",
												JOptionPane.INFORMATION_MESSAGE));
						int temGravadora = buscarGravadora(codGravadora);

						if (temGravadora > -1) {
							int cod = Integer
									.parseInt(JOptionPane
											.showInputDialog(
													null,
													"Informe o "
															+ "c�digo do artista que deseja contratar",
													"Verifica C�digo",
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
											"Artista j� contratado",
											"Contrato",
											JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"Artista n�o encontrado",
										"C�digo Inv�lido",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Gravadora n�o encontrada",
									"C�digo Inv�lido",
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
										"Informe o c�digo da gravadora",
										"Verifica C�digo",
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
											"Informe o c�digo do artista",
											"Verifica C�digo",
											JOptionPane.INFORMATION_MESSAGE));
							int temArtista = buscarArtista(cod);

							if (temArtista > -1
									&& listaGravadora.get(codGravadora)
											.demitirArtista(
													listaArtista
															.get(temArtista)
															.getCodigo())) {
								JOptionPane.showMessageDialog(null,
										"Artista Demitido", "Demiss�o",
										JOptionPane.INFORMATION_MESSAGE);

							} else {
								JOptionPane.showMessageDialog(null,
										"Artista n�o encontrado",
										"C�digo Inv�lido",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Gravadora n�o encontrada",
									"C�digo Inv�lido",
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
										"Informe o c�digo da gravadora",
										"Verifica C�digo",
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
														"Informe o c�digo do artista",
														"Verifica C�digo",
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
														"O artista n�o pertence a gravadora",
														"Erro",
														JOptionPane.ERROR_MESSAGE);
									}
								} else {
									JOptionPane.showMessageDialog(null,
											"Artista n�o encontrado",
											"C�digo Inv�lido",
											JOptionPane.ERROR_MESSAGE);
								}
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Gravadora n�o encontrada", "Busca",
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
										"Informe o c�digo da gravadora",
										"Verifica C�digo",
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
									"Gravadora n�o encontrada", "Busca",
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
										"A empresa n�o contratou nenhum show",
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
										"A empresa n�o contratou nenhum show",
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
								null, "Informe o c�digo do artista",
								"Verifica C�digo",
								JOptionPane.INFORMATION_MESSAGE));
						int temArtista = buscarArtista(cod);

						if (temArtista > -1) {

							String genero = JOptionPane.showInputDialog(null,
									"Informe o g�nero que deseja",
									"Titulo por G�nero", JOptionPane.INFORMATION_MESSAGE);
							listaArtista.get(temArtista).listarTitulos(genero);

						} else {
							JOptionPane.showMessageDialog(null,
									"Artista n�o encontrado",
									"C�digo Inv�lido",
									JOptionPane.ERROR_MESSAGE);
						}

					}

					break;

				case 18: // Sair
					teste = false;
					break;

				default:
					JOptionPane.showMessageDialog(null, "Op��o Inv�lida");
					break;
				}
			}
		}
	}

	/**
	 * Os m�todos abaixo retornam a posi��o que se encontra o artista, o show, a
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
