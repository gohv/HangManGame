package hangman;

import game.Game;
import player.Prompter;

public class Hangman {
	public static void main(String[] args) {

		Game newGame = new Game("grumpy");
		Prompter player = new Prompter(newGame);
		player.play();
	}
}