import java.util.Scanner;

public class Zgadywanka2 {

	public static void main(String[] args) {
		game();
	}

	static void game() {
		System.out.println("Pomyśl liczbę od 0 do 1000, a ja zgadnę w max 10 próbach. Naciśnij Enter, by kontynuować");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		int max = 1001;
		int min = 0;
		System.out.println("Zgaduję " + guess(min, max));
		int i = 1;
		String answer = "";
		while (!answer.equals("trafiłeś")) {
			while (! (answer.equals("mniej") || answer.equals("więcej") || answer.equals("trafiłeś"))) {
				System.out.println("Udziel odpowiedzi: więcej, mniej lub trafiłeś");
				answer = scan.next();
			}
			if (answer.equals("mniej")) {
				max = guess(min, max);
			} else if (answer.equals("więcej")) {
				min = guess(min, max);
			}
			System.out.println("Zgaduję " + Math.round(guess(min, max)));
			System.out.println("Udziel odpowiedzi: więcej, mniej lub trafiłeś");
			answer = scan.next();
			i++;
			if (i > 10) {
				break;
			}
		}
		if (i > 10) {
			System.out.println("Oszukiwałeś!");
		} else {
			System.out.println("Wygrałem w " + i + " próbach");
		}
	}

	static int guess(int min, int max) {
		int niceTry = ((max - min)/2) + min;
		return niceTry;	
	}

}