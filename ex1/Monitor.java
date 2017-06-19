package ex1;

public class Monitor extends Aluno {

	private String materia;
	private float horasSemanais;

	public Monitor(String nome, int idade, int telefone, int cpf,
			String matricula, String serie, String escola, String materia,
			float horasSemanais) {
		
		super(nome, idade, telefone, cpf, matricula, serie, escola);
		this.setMateria(materia);
		this.setHorasSemanais(horasSemanais);

	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public float getHorasSemanais() {
		return horasSemanais;
	}

	public void setHorasSemanais(float horasSemanais) {
		this.horasSemanais = horasSemanais;
	}

}
