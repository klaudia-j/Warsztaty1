import java.util.Random;
import java.util.Scanner;

public class Zgadywanka {

	public static void main(String[] args) {
		game();
	}

	static void game() {
		int number = randomNumber();
		int quess = 0;
		while (! (quess == number)) {
			quess = input();
			if (quess < number) {
				System.out.println("Za mało!");
			} else if (quess > number) {
				System.out.println("Za dużo!");
			}
		}
		System.out.println("Zgadłeś!");
	}

	static int randomNumber() {
		Random rand = new Random();
		int random = rand.nextInt(100)+1;
		return random;
	}

	static int input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Zgadnij liczbę!");
		while (! scan.hasNextInt()) {
			scan.next();
			System.out.println("To nie jest liczba");
			System.out.println("Zgadnij liczbę!");
		}
		int newTry = scan.nextInt();
		return newTry;
	}

}