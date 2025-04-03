import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LivrosService {

	// LISTA DE LIVROS
	private static ArrayList<Livros> livros = new ArrayList<>();
	private static final String NOME_ARQUIVO = "livros.txt";

	// CARREGA OS LIVROS OS INICIAR
	public static void carregarLivros() {
		try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha;
			while ((linha = reader.readLine()) != null) {

				String[] dados = linha.split(",");
				if (dados.length == 3) {
					String titulo = dados[0];
					String autor = dados[1];
					String categoria = dados[2];
					Livros livro = new Livros(titulo, autor, categoria);
					livros.add(livro);
				}
			}
		} catch (IOException e) {
			System.err.println("Erro ao carregar livros: " + e.getMessage());
		}
	}

	static {
		carregarLivros();
	}

	// MOSTRAR O BIBLIOTECA
	public static void colecao() {

		if (livros.isEmpty()) {
			System.out.println("Sua biblioteca está vazia!\n");
		} else {
			System.out.println("Livros: \n");
			for (Livros livro : livros) {
				System.out.println("Título: " + livro.getTitulo());
				System.out.println("Autor: " + livro.getAutor());
				System.out.println("Categoria: " + livro.getCategoria());
				System.out.println("------------------------------------------");
			}
		}
	}

	// ADICIONA LIVRO
	public static void add() {

		System.out.println("Informe o título do livro:");
		String titulo = UiConsole.getString();
		System.out.println("Informe o autor do livro:");
		String autor = UiConsole.getString();
		System.out.println("Informe a categoria do livro :");
		String categoria = UiConsole.getString();

		Livros livro = new Livros(titulo, autor, categoria);
		livros.add(livro);
		salvarEmArquivo();

		System.out.println("--------------------------------");
		System.out.println("Livro adicionado e salvo!");
		System.out.println("--------------------------------");
	}

	// SALVA NO ARQUIVO
	private static void salvarEmArquivo() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for (Livros livro : livros) {
				writer.write(livro.getTitulo() + "," + livro.getAutor() + "," + livro.getCategoria());
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.println("Erro ao salvar os livros: " + e.getMessage());
		}
	}

	// DELETA LIVRO
	public static void delete(){

		Livros livro = getLivros();

		if (livro == null) {
			System.out.println("Operação cancelada!");
	        return;
		}
		
		livros.remove(livro);
	    salvarEmArquivo();
	    System.out.println("Livro removido e alterações salvas!");
	}

	// ALTERA LIVRO
	public static void update() {

		Livros livro = getLivros();

		if (livros == null)
			if (livro != null) {
				System.out.println("Informe o título do livro (atual: " + livro.getTitulo() + "):");
				String titulo = UiConsole.getString();
				if (!titulo.isEmpty())
					livro.setTitulo(titulo);

				System.out.println("Informe o autor do livro (atual: " + livro.getAutor() + "):");
				String autor = UiConsole.getString();
				if (!autor.isEmpty())
					livro.setAutor(autor);

				System.out.println("Informe a categoria do livro (atual: " + livro.getCategoria() + "):");
				String categoria = UiConsole.getString();
				if (!categoria.isEmpty())
					livro.setCategoria(categoria);

				salvarEmArquivo();
				System.out.println("Livro atualizado e alterações salvas!");
			}
	}

	// INFORMANDO O INDICE
	private static Livros getLivros() {

		int indice = 0;
		Livros livro = null;

		while (livro == null) {
			System.out.println("Informe o índice do livro para alterar ou 0 para cancelar:");
			indice = UiConsole.getInt();

			if (indice == 0)
				return null;

			try {
				livro = livros.get(indice - 1);
				System.out.println("Índice: " + (indice) + ", Livro: " + livro.toString());
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Índice inválido!");
				System.out.println("==============================================================================");
			}
		}

		return livro;
	}
}
