package application;

import java.util.ArrayList;


public class Gameboard {
	private Tile[][] tiles = new Tile[4][4];

	private Boolean redMove;
	private ArrayList<String> previousMoves = new ArrayList<String>();
    private ArrayList<Tile> tilesOnBoard = new ArrayList<Tile>();
	
	public Gameboard() {
	}

	public Gameboard(Tile[][] tiles, Boolean redMove, ArrayList<String> previousMoves) {
		super();
		this.tiles = tiles;
		this.redMove = redMove;
		this.previousMoves = previousMoves;
	
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public Boolean getRedMove() {
		return redMove;
	}

	public void setRedMove(Boolean redMove) {
		this.redMove = redMove;
	}

	public ArrayList<String> getPreviousMoves() {
		return previousMoves;
	}

	public void setPreviousMoves(ArrayList<String> previousMoves) {
		this.previousMoves = previousMoves;
	}

	public ArrayList<Tile> getTilesOnBoard() {
		return tilesOnBoard;
	}

	public void setTilesOnBoard(ArrayList<Tile> tilesOnBoard) {
		this.tilesOnBoard = tilesOnBoard;
	}


}