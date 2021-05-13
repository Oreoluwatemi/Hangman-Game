
import java.util.Scanner;

public class Hangman_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String array of size 20
		String[] dictionary = { "orange", "pineapple", "strawberry", "circumference", "perimeter", "hairstyle",
				"bathroom", "university", "estate", "bottle", "traffic", "maintenance", "candle", "wednesday",
				"microwave", "aeroplane", "blender", "blanket", "blueberry", "raspberry" };

		// Get a random word from String array
		int randomNumber = (int) (Math.random() * 20);
		String randomWord = dictionary[randomNumber];

		displayGuesses(randomWord);

	}

	// Method displayGuesses
	public static void displayGuesses(String randomWord) {
		// Char array that contains the size of random word length
		char[] x = new char[randomWord.length()];

		// Initialize variables
		int guess = 1;
		char letter = 0;
		Scanner input = new Scanner(System.in);

		displayRandomWordLength(x);

		// While loop until all the characters of the word are revealed
		while (guess > 0) {

			// Prompt user to enter a character
			System.out.print("\nEnter character: ");
			char character = input.next().charAt(0);

			getCharacterInput(randomWord, letter, character, x);

			// Conditional statement if all characters are guessed correctly then the loop
			// ends
			if ((printGuessedCharacter(x, guess)) == true) {
				break;
			}
			guess++;
			System.out.println();
		}
	}

	// Method to display initially display empty char array ("_")
	public static void displayRandomWordLength(char[] x) {
		for (int i = 0; i < x.length; i++) {
			x[i] = '_';
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}

	// Method to assign correctly guessed character to x array
	public static void getCharacterInput(String randomWord, char letter, char character, char[] x) {
		boolean isCharacterInWord = false;

		// Loop to assign correctly guessed character to x array
		for (int i = 0; i < randomWord.length(); i++) {
			letter = randomWord.charAt(i);
			if (letter == character) {
				x[i] = letter;
				isCharacterInWord = true;
			}
		}

		// Conditional statement that informs user if guessed character is false
		if (isCharacterInWord == false) {
			System.out.print("\nCharacter is not in the word, try again!\n");
		}
	}

	// Method to display Char array as characters is guessed
	public static boolean printGuessedCharacter(char[] x, int guess) {
		boolean isGuessComplete = true;

		// Loop to display guessed characters
		for (int i = 0; i < x.length; i++) {
			if (x[i] == '_') {
				isGuessComplete = false;
			}
			System.out.print(x[i] + " ");
		}

		// Conditional statement if all characters are guessed correctly
		if (isGuessComplete) {
			System.out.print("\n\nCongratulations, you guessed the word!");
			System.out.print("\nYou guessed " + guess + " times");
		}
		return isGuessComplete;
	}

}
