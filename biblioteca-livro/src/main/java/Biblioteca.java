public class Biblioteca {

	public static void main(String[] args) {

		System.out.println("Olá bem vindo a sua Biblioteca Pessoal");
		System.out.println("--------------------------------------------");

		int opcao = 0;
		
		while (true) {
			System.out.println("Informe a opção que você deseja: ");
			
			while (opcao < 6 || opcao > 0) {
				System.out.println("1- Ver minha biblioteca");
				System.out.println("2- Adicionar um livro novo");
				System.out.println("3-Deletar um livro");
				System.out.println("4- Alterar um livro");
				System.out.println("5- Sair do programa");
				opcao = UiConsole.getInt();
				opcoes(opcao);
			}

		}
	}

	private static void opcoes(int opcao) {

		switch (opcao) {

		case 1:
			System.out.println("Sua biblioteca de livros: ");
			LivrosService.colecao();
			break;

		case 2:
			System.out.println("Adicionando um novo livro: ");
			LivrosService.add();
			break;

		case 3:
			System.out.println("Deletando um livro da sua biblioteca: ");
			LivrosService.delete();
			break;

		case 4:
			System.out.println("Aterando um livro da sua biblioteca: ");
			LivrosService.update();

			break;

		case 5:
			System.out.println("Saindo do programa...");
			System.exit(0);
			break;
		}
	}
}
