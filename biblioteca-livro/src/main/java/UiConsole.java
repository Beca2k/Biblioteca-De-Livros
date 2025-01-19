import java.util.Scanner;

public class UiConsole {

	private static final Scanner scanner = new Scanner(System.in);

	public static int getInt() {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Por favor, insira um número inteiro válido.");
			}
		}
	}

	public static String getString() {
		return scanner.nextLine();
	}
}
