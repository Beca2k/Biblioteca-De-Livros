import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LivrosService {

	// LISTA DE LIVROS
	private static ArrayList<Livros> livros = new ArrayList<>();

	// MOSTRAR O BIBLIOTECA
	public static void colecao() {

		if (livros.isEmpty()) {
			System.out.println("Sua biblioteca está vazia!! \n");
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
		String salvado = "livros.txt";

		try {
			salvarEmArquivo(livros, salvado);
			System.out.println("----------------------------------");
			System.out.println("Seu livro foi adicionado!");
		} catch (IOException e) {
			System.out.println("----------------------------------");
			System.err.println("Erro ao salvar livros no arquivo: " + e.getMessage());
		}
	}

	public static void salvarEmArquivo(ArrayList<Livros> livros, String salvado) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(salvado))) {
			for (Livros livro : livros) {
				writer.write(livro.toString());
				writer.newLine();
			}
		}
	}

	// DELETA LIVRO
	public static void delete() {

		Livros livro = getLivros();

		if (livro == null)
			return;

		livros.remove(livro);

		System.out.println("Livro removido!");

	}

	// ALTERA LIVRO
	public static void update() {

		Livros livros = getLivros();

		if (livros == null)
			return;

		System.out.println("Informe o título do livro" + livros.getTitulo());

		String titulo = UiConsole.getString();
		if (titulo != null && !titulo.isEmpty())
			livros.setTitulo(titulo);

		System.out.println("Informe o autor do livro " + livros.getAutor());
		String autor = UiConsole.getString();
		if (autor != null && !autor.isEmpty())
			livros.setAutor(autor);

		System.out.println("Informe a categoria do livro " + livros.getCategoria());
		String categoria = UiConsole.getString();
		if (categoria != null && !categoria.isEmpty())
			livros.setCategoria(categoria);

		System.out.println("Livro alterado!");
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
