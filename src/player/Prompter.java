package player;

import java.util.Scanner;

import exception.CustomException;
import game.Game;

public class Prompter {
	private Game game;

	public Prompter(Game game) {
		this.game = game;
	}

	/**
	 * 
	 * Needs to be reworked if I am gonna use swing
	 */

	public void play() {
		while (game.getRemainingTries() > 0 && !game.isSolved()) {
			displayProgress();
			promptForGuess();
		}
		if(game.isSolved()){
			System.out.println("You Won with " + game.getRemainingTries() + " left");
		}else{
			System.out.println("You lost, the answer was " + game.getAnswer());
		}
	}

	public boolean promptForGuess() {
		Scanner sc = new Scanner(System.in);
		boolean isHit = false;
		boolean isValid = false;
		while (!isValid) {
			System.out.print("Enter a letter: ");
			String guessAsString = sc.nextLine();
			char guess = ' ';
			if (guessAsString.length() > 0) {
				guess = guessAsString.charAt(0);
			}

			try {
				isHit = game.applyGuess(guess);
				isValid = true;
			} catch (CustomException e) {
				System.out.println("Please try Again " + e.getMessage());
			}
		}
		return isHit;
	}

	public void displayProgress() {
		System.out.println("Word is: " + game.getProgress());
		System.out.println("Remaining tries: " + game.getRemainingTries());
	}

}
