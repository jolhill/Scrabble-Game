import javax.swing.JOptionPane;

//This class constructs and holds instance variables
//for a single tile

 

public class Tile{
	
	//INSTANCE VARIABLES
	private char cLetter;
	private int iPtValue;
	private boolean isBlankTile;
	
	//FOR BLANK TILES
	public Tile(){
		isBlankTile = true;
		setPtValue(0);
	}
	public Tile(char cLetter,int iPtValue){
		setLetter(cLetter);
		setPtValue(iPtValue);
		isBlankTile = false;
	}
//************GETTERS***AND**SETTERS****************
	public char getLetter() {
		return cLetter;
	}
	//SPECIAL SETTER FOR BLANK TILES
	public void setLetterJOption() {
		Object [] aOptions = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
				'o','p','q','r','s','t','u','v','w','x','y','z'};
		this.cLetter =
				(char)JOptionPane.showInputDialog(null, "Select which letter you want the tile to be:",
				"Letter Selection", JOptionPane.PLAIN_MESSAGE, null, aOptions, aOptions[0]);
		isBlankTile = false;
	}
	public void setLetter(char cLetter) {
		this.cLetter = cLetter;
	}
	public int getPtValue() {
		return iPtValue;
	}
	public void setPtValue(int iPtValue) {
		this.iPtValue = iPtValue;
	}
	public boolean isBlankTile() {
		return isBlankTile;
	}
	public void setBlankTile(boolean isBlankTile) {
		this.isBlankTile = isBlankTile;
	}
	public String toString() {
		return "Letter: " + cLetter  + " Points: " + iPtValue +"\n";
	}
	
}
