import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		lotto();
	}

	static void lotto() {
		int[] yourNumbers = getNumbers();
		int[] drawnNumbers = getRandoms();
		int counter = 0;
		Arrays.sort(yourNumbers);
		Arrays.sort(drawnNumbers);
		System.out.println("Twoje liczby to: ");
		for (int number : yourNumbers) {
			System.out.print(number + " ");
		}
		System.out.println();
		System.out.println("Wylosowane liczby to: ");
		for (int drawn : drawnNumbers) {
			System.out.print(drawn + " ");
		}
		System.out.println();
		for (int i = 0; i < yourNumbers.length; i ++) {
			for (int j = 0; j < drawnNumbers.length; j ++) {
				if (yourNumbers[i] == drawnNumbers[j]) {
					counter++;
				}
			}
		}
		switch (counter) {
		case 6: System.out.println("Trafiłeś szóstkę!");
		break;
		case 5: System.out.println("Trafiłeś piątkę!");
		break;
		case 4: System.out.println("Trafiłeś czwórkę!");
		break;
		case 3: System.out.println("Trafiłeś trójkę!");
		break;
		default: System.out.println("Nic nie wygrałeś!");
		}
	}

	static int[] getRandoms() {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 49; i++) {
			numbers.add(i + 1);
		}
		Collections.shuffle((numbers));
		int[] numbersTaken = new int[6];
		for (int j = 0; j < 6; j++) {
			numbersTaken[j] = numbers.get(j);
		}
		return numbersTaken;
	}

	static int[] getNumbers() {
		int[] arrOfNumbers = new int[6];
		int liczba = 0;
		for (int i = 0; i < 6; i++) {
			liczba = oneGuess();
			while (properRange(liczba) == false) {
				System.out.println("Podaj liczbę z zakresu od 1 do 49!");
				liczba = oneGuess();
			}
			arrOfNumbers[i] = liczba;
			for (int j = 0; j < i; j++) {
				while (arrOfNumbers[i] == arrOfNumbers[j]) {
					System.out.println("Podałeś już taką liczbę");
					liczba = oneGuess();
					while (properRange(liczba) == false) {
						System.out.println("Podaj liczbę z zakresu od 1 do 49!");
						liczba = oneGuess();
					}
					arrOfNumbers[i] = liczba;
				}
			}
		}
		return arrOfNumbers;
	}

	static int oneGuess() {
		System.out.println("Podaj liczbę");
		Scanner scan = new Scanner(System.in);
		int newTry = 0;
		while (! scan.hasNextInt()) {
			scan.next();
			System.out.println("To nie jest liczba");
			System.out.println("Podaj liczbę!");
		}
		newTry = scan.nextInt();
		return newTry;
	}

	static boolean properRange (int number) {
		return (number >= 1) && (number <= 49);
	}

}