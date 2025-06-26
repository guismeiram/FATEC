package Model;

public class Filme {
	public int id;
	public String nome;
	public String genero;
	public String duracao;
	
	
	
	public Filme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Filme(int id, String nome, String genero, String duracao) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.duracao = duracao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	
}
