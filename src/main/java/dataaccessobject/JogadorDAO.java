package dataaccessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Jogador;

public class JogadorDAO {

	public void insereRegistros(List<Jogador> listaJogador) {
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectionFactory.retornaConexao();
			String sql = "INSERT INTO jogador (nickname, idade, main, elo) VALUES (?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);

			for (Jogador jogador : listaJogador) {
				stmt.setString(1, jogador.getNickname());
				stmt.setInt(2, jogador.getIdade());
				stmt.setString(3, jogador.getMain());
				stmt.setString(4, jogador.getElo());

				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Jogador> retornaRegistros() {
		PreparedStatement stmt = null;
		List<Jogador> listaJogador = new ArrayList<Jogador>();
		try {
			Connection con = ConnectionFactory.retornaConexao();
			String sql = "SELECT id, nickname, idade, main, elo FROM jogador";
			stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Jogador jogador = new Jogador();
				jogador.setId(rs.getInt("id"));
				jogador.setNickname(rs.getString("nickname"));
				jogador.setIdade(rs.getInt("idade"));
				jogador.setMain(rs.getString("main"));
				jogador.setElo(rs.getString("elo"));
				
				listaJogador.add(jogador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaJogador;
	}

	public void alteraRegistro(Jogador novoJogador) {
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectionFactory.retornaConexao();
			String sql = "UPDATE jogador SET nickname = ?, idade = ?, main = ?, elo = ? WHERE id = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, novoJogador.getNickname());
			stmt.setInt(2, novoJogador.getIdade());
			stmt.setString(3, novoJogador.getMain());
			stmt.setString(4, novoJogador.getElo());
			stmt.setInt(5, novoJogador.getId());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletaRegistro(int idDeletado) {
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectionFactory.retornaConexao();
			String sql = "DELETE FROM jogador WHERE id = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, idDeletado);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}