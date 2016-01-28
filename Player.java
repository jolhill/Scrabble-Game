import java.util.ArrayList;

public class Player{
	
  	private ArrayList<Tile> aPlayerPile = new ArrayList<Tile>();
  	private int iPlayerID;
  	private String sPlayerName;
  	private int iPlayerScore;
  	
  	public Player(int iPlayerID,String sPlayerName){
  		setPlayerID(iPlayerID);
  		setPlayerName(sPlayerName);
  	}
	
	public Pile fillPile(Pile aPile) {
		while(aPlayerPile.size() < 7 && aPile.getSize() > 7){
				aPlayerPile.add(aPile.getRandom());
		}
		return(aPile);
	}

	public String getPlayerName() {
		return sPlayerName;
	}

	public void setPlayerName(String sPlayerName) {
		this.sPlayerName = sPlayerName;
	}

	public int getPlayerID() {
		return iPlayerID;
	}

	public void setPlayerID(int iPlayerID) {
		this.iPlayerID = iPlayerID;
	}
	
	public void setPlayerScore(int iPlayerScore) {
		this.iPlayerScore = iPlayerScore;
	}
	
	public int getPlayerScore() {
		return iPlayerScore;
	}
	
	public String getHand(){
		String sOutput = getPlayerName() + "'s hand:\n";
		for(Tile tile : aPlayerPile){
			sOutput += tile.toString();
		}
		return sOutput;
	}
	
	//returns -1 if invalid word, else returns word score,does the scoring as well
	//NEEDS AN OPTION TO PLACE IN THE BOARD
	public Board playWord(String sWord, Board board){
		int iScore = 0;
		if(board.setWord(sWord,aPlayerPile)){
			for(int i = 0; i < sWord.length(); i++){
				for(Tile t : aPlayerPile){
					if(t.getLetter() == sWord.charAt(i)){
						iScore += t.getPtValue();
						aPlayerPile.remove(t);
						break;
					}
				}
			}
		}
		else{
			System.out.println("\nYou do not have the tiles for that word!\n");
		}
		setPlayerScore(iScore + getPlayerScore());
		return board;
	}

	public boolean swapLetter(char cLetter,Pile aPile) {
		for (Tile tile : aPlayerPile) {
			if(tile.getLetter() == cLetter){
				aPlayerPile.remove(tile);
				fillPile(aPile);
				return true;
			}
		}
		return false;
	}
	
}