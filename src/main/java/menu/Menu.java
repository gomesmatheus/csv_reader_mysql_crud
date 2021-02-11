package menu;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import csv.Reader;
import dataaccessobject.JogadorDAO;
import model.Jogador;

public class Menu {
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		System.out.println("Bem vindo!");
		exibeOpcoes();
	}
	
	public static void exibeOpcoes() {
		System.out.println("Qual opção deseja executar?");
		System.out.println("C - Create (Inserir)");
		System.out.println("R - Read   (Ler)");
		System.out.println("U - Update (Atualizar)");
		System.out.println("D - Delete (Excluir)");
		System.out.println("X - Sair");
		
		delegaOpcao();
	}
	
	private static void delegaOpcao() {
		char opcaoEscolhida = input.next().charAt(0);
		switch(opcaoEscolhida) {
			case 'C': case 'c':
				inserirDados();
				break;
			case 'R': case 'r':
				lerDados();
				break;
			case 'U': case 'u':
				atualizarDados();
				break;
			case 'D': case 'd':
				deletarDados();
				break;
			case 'X': case 'x':
				input.close();
				return;
			default:
				System.out.println("Opção escolhida inválida! Tente novamente!");
				exibeOpcoes();
		}
		exibeOpcoes();
		input.close();
	}

	private static void inserirDados() {
		List<Jogador> listaJogador = Reader.lerArquivo(Reader.CAMINHO_CSV);
		
		JogadorDAO jogadorDAO = new JogadorDAO();
		jogadorDAO.insereRegistros(listaJogador);
		
		System.out.println(listaJogador.size() + " dados inseridos!");
	}
	
	private static void lerDados() {
		JogadorDAO jogadorDAO = new JogadorDAO();
		List<Jogador> listaJogador = jogadorDAO.retornaRegistros();
		
		System.out.println("Dados presentes no banco:");
		exibirDados(listaJogador);
	}
	
	private static void atualizarDados() {
		JogadorDAO jogadorDAO = new JogadorDAO();
		
		List<Jogador> listaJogador = jogadorDAO.retornaRegistros();
		exibirDados(listaJogador);
		
		Jogador entradaJogador = recebeEntradaJogador();
		jogadorDAO.alteraRegistro(entradaJogador);
		
		System.out.println("Registro alterado!");
	}

	private static void deletarDados() {
		JogadorDAO jogadorDAO = new JogadorDAO();
		
		List<Jogador> listaJogador = jogadorDAO.retornaRegistros();
		exibirDados(listaJogador);
		
		int id = recebeEntradaID();
		jogadorDAO.deletaRegistro(id);
	
		System.out.println("Registro deletado!");
	}
	
	private static void exibirDados(List<Jogador> listaJogador) {
		for (Jogador jogador : listaJogador) {
			System.out.println(jogador);
		}
	}
	
	private static Jogador recebeEntradaJogador() {
		Jogador jogador = new Jogador();
		
		System.out.println("Digite o ID do elemento que deseja alterar:");
		jogador.setId(input.nextInt());
		System.out.println("Digite o novo Nickname:");
		jogador.setNickname(input.next());
		System.out.println("Digite a nova Idade:");
		jogador.setIdade(input.nextInt());
		System.out.println("Digite o novo Main:");
		jogador.setMain(input.next());
		System.out.println("Digite o novo Elo:");
		jogador.setElo(input.next());
		
		return jogador;
	}
	
	private static int recebeEntradaID() {
		System.out.println("Digite o ID do elemento que deseja deletar:");
		int id = input.nextInt();
		
		return id;
	}
}