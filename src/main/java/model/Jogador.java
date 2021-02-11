package model;

public class Jogador {
	
	private String nickname;
	private int idade;
	private String main;
	private String elo;
	private int id;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getElo() {
		return elo;
	}
	public void setElo(String elo) {
		this.elo = elo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Jogador [ID = " + id + ", Nickname = " + nickname + ", Main = " + main + ", Elo = " + elo + ", Idade = " + idade
				+ "]";
	}
}