import java.util.ArrayList;
import java.util.Random;

public class Pile{
  	private ArrayList<Tile> aTiles = new ArrayList<Tile>();
	public Pile() {
		setTiles();
	}
	//The following methods set the letters and their values into the 
		//ArrayList and also allow you to return all the letters and their values
  	public void setTiles() {
		for(int i = 0; i < 2; i++) {
			aTiles.add(new Tile());	
		}
		for(int i = 0; i < 12; i++) {
		     aTiles.add(new Tile('e',1));
		}
		for(int i = 0; i < 9; i++){
		     aTiles.add(new Tile('a',1));
		     aTiles.add(new Tile('i',1));
		}
		for(int i = 0; i < 8; i++) {
		     aTiles.add(new Tile('o',1));
		}
		for(int i = 0; i < 6; i++) {
		     aTiles.add(new Tile('n',1));
		     aTiles.add(new Tile('r',1));
		     aTiles.add(new Tile('t',1));
		}
		for (int i = 0; i < 4; i++) {
			aTiles.add(new Tile('l',1));
			aTiles.add(new Tile('s',1));
			aTiles.add(new Tile('u',1));
			aTiles.add(new Tile('d',2));
		}
		for (int i = 0; i < 3; i++) {
			aTiles.add(new Tile('g',2));
		}
		for (int i = 0; i < 2; i++) {
			aTiles.add(new Tile('b',3));
			aTiles.add(new Tile('c',3));
			aTiles.add(new Tile('m',3));
			aTiles.add(new Tile('p',3));
			aTiles.add(new Tile('f',4));
			aTiles.add(new Tile('h',4));
			aTiles.add(new Tile('v',4));
			aTiles.add(new Tile('w',4));
			aTiles.add(new Tile('y',4));
		}
		for (int i = 0; i < 1; i++) {
			aTiles.add(new Tile('k',5));
			aTiles.add(new Tile('j',8));
			aTiles.add(new Tile('x',8));
			aTiles.add(new Tile('q',10));
			aTiles.add(new Tile('z',10));
		}
	}
  	
  	public ArrayList<Tile> getTiles(){
  		return aTiles;
  	}
  	
	public void updateTiles(ArrayList<Tile> aTiles) {
		this.aTiles = aTiles;
	}
	public String toString() {
		String sString = "";
		for(Tile sTiles : aTiles) {
			sString += sTiles.toString();
		}
		return sString;
	}
	public int getSize() {
		return aTiles.size();
	}

	
	
	public Tile getRandom() {
		Random rand = new Random();
		int iNum = rand.nextInt(aTiles.size());
		return aTiles.remove(iNum);
	}
	
	/*
	public void removePlayerTile() {
		
	}
	//This method will allow a player to swap a letter or letters.
	//We could use JOptionPane to ask how many letters they would like to swap out and
	//Make a four loop to run through each time they want to swap a letter
	
	
	}
	*/
	
}
