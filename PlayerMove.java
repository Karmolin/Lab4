package application;

import java.util.ArrayList;


/*(the color of the player, which tile they picked, 
 * what was the position of the tile, etc).
 *  For example, you can have a ArrayList of PlayerMoves in the GameBoard class, 
 * and you keep adding to the list as players make their move.*/
public class PlayerMove {

	private String playerColor;
	private ArrayList<Integer> moves = new ArrayList<>();
	private ArrayList<String> moveString = new ArrayList<>();
	private ArrayList<Tile> tilesOwned = new ArrayList<>();


	public PlayerMove(String playerColor, ArrayList<Integer> moves) {
		super();
		this.playerColor = playerColor;
		this.moves = moves;
	}

	public PlayerMove() {

	}

	public String getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(String playerColor) {
		this.playerColor = playerColor;
	}

	public ArrayList<Integer> getMoves() {
		return moves;
	}

	public void setMoves(ArrayList<Integer> moves) {
		this.moves = moves;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moves == null) ? 0 : moves.hashCode());
		result = prime * result + ((playerColor == null) ? 0 : playerColor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerMove other = (PlayerMove) obj;
		if (moves == null) {
			if (other.moves != null)
				return false;
		} else if (!moves.equals(other.moves))
			return false;
		if (playerColor == null) {
			if (other.playerColor != null)
				return false;
		} else if (!playerColor.equals(other.playerColor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlayerMove [playerColor=" + playerColor + ", moves=" + moves + "]";
	}

	public ArrayList<String> getMoveString() {
		return moveString;
	}

	public void setMoveString(ArrayList<String> moveString) {
		this.moveString = moveString;
	}

	public String tilesToString(){
		String temp = new String();
		temp = " ";
		for(Tile t: tilesOwned){
			temp.concat('\n' + t.toString() + t.getTileType1().toString()+'/' + t.getTileType2().toString());
		}
		return temp;
		
	}


	public ArrayList<Tile> getTilesOwned() {
		return tilesOwned;
	}

	public void setTilesOwned(ArrayList<Tile> tilesOwned) {
		this.tilesOwned = tilesOwned;
	}


}
