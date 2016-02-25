package application;

import javafx.scene.image.Image;


//import java.util.regex.Pattern;

public class Tile {

	private Pattern tileType1;
	private Pattern tileType2;
	private String owner =null;

	public Image image1 = new Image("applications/"+tileType1.toString() + ".png"); //will hold the image for the button.nbvb
    public Image image2 = new Image("applications/"+tileType2.toString() + ".png");
	public Tile(Pattern tileType1, Pattern tileType2, String owner) {
		super();
		this.tileType1 = tileType1;
		this.tileType2 = tileType2;
		this.owner=owner;
		
	}

	public  Tile() {

	}

	public Pattern getTileType1() {
		return tileType1;
	}

	public void setTileType1(Pattern tileType1) {
		this.tileType1 = tileType1;
	}

	public Pattern getTileType2() {
		return tileType2;
	}

	public void setTileType2(Pattern tileType2) {
		this.tileType2 = tileType2;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());

		result = prime * result + ((tileType1 == null) ? 0 : tileType1.hashCode());
		result = prime * result + ((tileType2 == null) ? 0 : tileType2.hashCode());
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
		Tile other = (Tile) obj;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;

		if (tileType1 != other.tileType1)
			return false;
		if (tileType2 != other.tileType2)
			return false;
		if (tileType1 != other.tileType2 && tileType2 != other.tileType1)
			return false;
		return true;
	}
    @Override
    public String toString(){
    	return tileType1.toString() + '/' +tileType2.toString();
    }

}
