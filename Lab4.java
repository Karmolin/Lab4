package application;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Lab4 {

	static Boolean redMove = false;
	static Scanner read = new Scanner(System.in);
	private static PlayerMove red = new PlayerMove();
	public static Gameboard board = new Gameboard();

	private static PlayerMove black = new PlayerMove();

	public static PlayerMove getRed() {
		return red;
	}

	public void setRed(PlayerMove red) {
		this.red = red;
	}

	public static PlayerMove getBlack() {
		return black;
	}

	public void setBlack(PlayerMove black) {
		this.black = black;
	}

	public static void main(String[] args) {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				board.getTiles()[i][j] = new Tile();
				board.getTiles()[i][j].setOwner(null);
			}
		}

		board.getTiles()[0][0].setOwner("BLACK");
		board.getTiles()[0][1].setOwner("RED");
		board.getTiles()[0][2].setTileType1(Pattern.dragon);
		board.getTiles()[0][2].setTileType2(Pattern.bird);
		board.getTiles()[0][3].setTileType1(Pattern.dragon);
		board.getTiles()[0][3].setTileType2(Pattern.computer);
		board.getTiles()[1][0].setTileType1(Pattern.tiger);
		board.getTiles()[1][0].setTileType2(Pattern.leaf);
		board.getTiles()[1][1].setTileType1(Pattern.cloud);
		board.getTiles()[1][1].setTileType2(Pattern.computer);
		board.getTiles()[1][2].setOwner("RED");
		board.getTiles()[1][3].setOwner("BLACK");
		board.getTiles()[2][0].setTileType1(Pattern.sun);
		board.getTiles()[2][0].setTileType2(Pattern.tiger);
		board.getTiles()[2][1].setTileType1(Pattern.flower);
		board.getTiles()[2][1].setTileType2(Pattern.sun);
		board.getTiles()[2][2].setTileType1(Pattern.flower);
		board.getTiles()[2][2].setTileType2(Pattern.dragon);
		board.getTiles()[2][3].setOwner("BLACK");
		board.getTiles()[3][0].setOwner("RED");
		board.getTiles()[3][1].setTileType1(Pattern.bird);
		board.getTiles()[3][1].setTileType2(Pattern.tiger);
		board.getTiles()[3][2].setTileType1(Pattern.computer);
		board.getTiles()[3][2].setTileType2(Pattern.sun);
		board.getTiles()[3][3].setOwner("BLACK");
		// generateBoard(board);

		int choice;

		System.out.println("1. Play Niya\n2.View Previous Game");
		choice = read.nextInt();

		if (choice == 2) {
		
		} else {

			playGame(board);
		}
	}

//	public static void generateBoard(Gameboard board) {
//		Random rand = new Random();
//
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				Tile temp = new Tile();
//				do {
//					board.getTiles()[i][j].setTileType1(Pattern.values()[rand.nextInt(8)]);
//					do {
//						board.getTiles()[i][j].setTileType2(Pattern.values()[rand.nextInt(8)]);
//
//					} while (board.getTiles()[i][j].getTileType1() == board.getTiles()[i][j].getTileType2());
//					temp.setTileType1(board.getTiles()[i][j].getTileType1());
//					temp.setTileType2(board.getTiles()[i][j].getTileType2());
//					board.getTilesOnBoard().add(temp);
//
//				} while (!board.getTilesOnBoard().contains(temp));
//			}
//		}
//	}



	public static void playGame(Gameboard board) {
		Tile tempTile = new Tile();

		Boolean gameOver = false;

		int movesIndex = 0;
		int choice;
		do {
			redMove = !redMove;

			if (redMove)
				System.out.println("Red's move");
			else if (!redMove)
				System.out.println("Black's move");

			// set up 2 temp tiles where you hold the tile values
			System.out.print("Enter choice:");
			choice = read.nextInt();
			choice = choice - 1;
			tempTile.setTileType1(board.getTiles()[choice % 4][choice / 4].getTileType1());
			tempTile.setTileType2(board.getTiles()[choice % 4][choice / 4].getTileType2());

			if (redMove) {
				board.getTiles()[choice % 4][choice / 4].setOwner("RED");
				red.getMoves().add(choice);
				gameOver = winningCombo(red);
				// System.out.print(red.getMoves().toString());
				board.getPreviousMoves().add("RED-" + (char) choice);
			} else {
				board.getTiles()[choice % 4][choice / 4].setOwner("BLACK");
				black.getMoves().add(choice);
				gameOver = winningCombo(black);
				// System.out.print(black.getMoves().toString());
				board.getPreviousMoves().add("BLACK-" + (char) choice);
			}
			movesIndex++;
			if (movesIndex == 16)
				gameOver = true;
		} while (!gameOver);
		if (redMove)
			System.out.println("Red Wins");
		else
			System.out.println("Black Wins");

		writeGameToFile(board);

	}

	public static boolean winningCombo(PlayerMove moves) {
		// check if player has vertical line
		for (int i = 0; i < 4; i++) {
			if (moves.getMoves().contains(i) && moves.getMoves().contains(i + 4) && moves.getMoves().contains(i + 8)
					&& moves.getMoves().contains(i + 12))
				return true;
		}

		// check if the player has a horizontal row
		for (int i = 0; i < 13; i += 4) {
			if (moves.getMoves().contains(i) && moves.getMoves().contains(i + 1) && moves.getMoves().contains(i + 2)
					&& moves.getMoves().contains(i + 3))
				return true;
		}
		// check if the player owns a square
		for (int i = 0; i < 10; i++) {
			if (moves.getMoves().contains(i) && moves.getMoves().contains(i + 1) && moves.getMoves().contains(i + 4)
					&& moves.getMoves().contains(i + 5))
				return true;
		}
		// check if player owns either diagonal
		if (moves.getMoves().contains(0) && moves.getMoves().contains(5) && moves.getMoves().contains(10)
				&& moves.getMoves().contains(15))
			return true;
		if (moves.getMoves().contains(3) && moves.getMoves().contains(6) && moves.getMoves().contains(9)
				&& moves.getMoves().contains(12))
			return true;

		return false;
	}

	// this is pretty much the exact same thing as from the example from lecture
	// because I don't really understand how to do it.
	public static void writeGameToFile(Gameboard board) {

		String filename = "Games.txt";
		Path path = Paths.get(filename);
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {

			for (String s : board.getPreviousMoves()) {

				writer.write(s);
				writer.newLine();
			}

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}

	}
}
