import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LivrosService {

	// LISTA DE LIVROS
	private static List<Livros> livros = new ArrayList<>();

	// MOSTRAR O BIBLIOTECA
	public static void colecao() {

		if (livros.isEmpty()) {
			System.out.println("Sua biblioteca está vazia!!");
		} else {
			System.out.println("Livros: \n");
			for (Iterator iterator = livros.iterator(); iterator.hasNext();) {
				Livros livros2 = (Livros) iterator.next();
				System.out.println( "Titulo: " + livros2.getTitulo());
				System.out.println( "Autor: " + livros2.getAutor());
				System.out.println( "Categoria: " + livros2.getCategoria());
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

		Livros livroNovo = new Livros(titulo, autor, categoria);
		livros.add(livroNovo);
		System.out.println("Seu livro foi adicionado!");
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
