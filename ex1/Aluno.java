package ex1;

public class Aluno extends Pessoa {
	
	private String matricula;
	private String serie;
	private String escola;
	
	public Aluno(String nome, int idade,int telefone,int cpf, String matricula, String serie, String escola){
		super(nome, idade, telefone, cpf);
		this.setMatricula(matricula);
		this.setSerie(serie);
		this.setEscola(escola);
		
	}
	

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}
	

}
