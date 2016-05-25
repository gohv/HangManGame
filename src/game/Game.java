package game;

import exception.CustomException;

public class Game {
	private String answer;
	private final int MAX_MISS = 7;
	private String hits;
	private String misses;

	public Game(String answer) {
		this.answer = answer;
		hits = "";
		misses = "";

	}

	/*
	 * return true if char is found return false if char is not found
	 */

	public boolean applyGuess(char letter) throws CustomException {
		letter = validateGuess(letter);
		boolean isHit = answer.indexOf(letter) >= 0;
		if (isHit) {
			hits += letter;
		} else {
			misses += letter;
		}
		return isHit;
	}

	public String getProgress() {
		String progress = "";
		for (char letter : answer.toCharArray()) {
			char display = '-';
			if (hits.indexOf(letter) >= 0) {
				display = letter;
			}
			progress += display;
		}
		return progress;
	}

	public int getRemainingTries() {
		return MAX_MISS - misses.length();
	}

	private char validateGuess(char letter) throws CustomException {
		if (!Character.isLetter(letter)) {
			throw new CustomException("This is not a letter");
		}
		letter = Character.toLowerCase(letter);
		if (misses.indexOf(letter) >= 0 || hits.indexOf(letter) >= 0) {
			throw new CustomException(letter + " has already been already guessed");
		}
		return letter;
	}

	public boolean isSolved() {
		return getProgress().indexOf('-') == -1;
	}

	public String getAnswer() {
		return answer;
	}
}
