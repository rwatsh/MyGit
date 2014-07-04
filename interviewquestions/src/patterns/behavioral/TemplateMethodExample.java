package patterns.behavioral;

import java.util.Random;

/**
 * An abstract class that is common to several games in which players play
 * against the others, but only one is playing at a given time.
 */

abstract class Game {

	protected int playersCount;

	abstract void initializeGame();

	abstract void makePlay(int player);

	abstract boolean endOfGame();

	abstract void printWinner();

	/* A template method : */
	public final void playOneGame(int playersCount) {
		this.playersCount = playersCount;
		initializeGame();
		int j = 0;
		while (!endOfGame()) {
			makePlay(j);
			j = (j + 1) % playersCount;
		}
		printWinner();
	}
}

// Now we can extend this class in order
// to implement actual games:

class Monopoly extends Game {
	private int currentPlayer;

	/* Implementation of necessary concrete methods */
	void initializeGame() {
		// Initialize players
		// Initialize money
	}

	void makePlay(int player) {
		// Process one turn of player
		System.out.println("Playing player: " + player);
		this.currentPlayer = player;
	}

	boolean endOfGame() {
		// Return true if game is over
		// according to Monopoly rules
		Random rand = new Random();
		return rand.nextInt(100) < 5 ? true : false;
	}

	void printWinner() {
		// Display who won
		System.out.println("Winner of Monopoly game is player: "
				+ currentPlayer);
	}
	/* Specific declarations for the Monopoly game. */

	// ...
}

class Chess extends Game {
	private int currentPlayer;

	/* Implementation of necessary concrete methods */
	void initializeGame() {
		// Initialize players
		// Put the pieces on the board
	}

	void makePlay(int player) {
		// Process a turn for the player
		System.out.println("Playing player: " + player);
		this.currentPlayer = player;
	}

	boolean endOfGame() {
		// Return true if in Checkmate or
		// Stalemate has been reached
		Random rand = new Random();
		return rand.nextInt(100) < 10 ? true : false;
	}

	void printWinner() {
		System.out.println("Winner of Chess game is player: " + currentPlayer);
	}
	/* Specific declarations for the chess game. */

	// ...
}

public class TemplateMethodExample {
	public static void main(String[] args) {
		Game g1 = new Chess();
		g1.playOneGame(2);
		
		Monopoly m1 = new Monopoly();
		m1.playOneGame(4);
	}
}
