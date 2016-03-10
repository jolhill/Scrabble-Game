import javax.swing.JOptionPane;

public class Scrabble{
	
	private Board scrabble;
	private Pile pile;
	private Player [] aPlayers;
	private GUIClass gui;
	
	public Scrabble(){
		
		scrabble = new Board();
		pile = new Pile();
	    	    
		Player player1 = new Player(1,"Josh");
		Player player2 = new Player(2,"Sam");
		aPlayers = new Player [2];
		aPlayers[0] = player1;
		aPlayers[1] = player2;
		
		pile = player1.fillPile(pile);
		pile = player2.fillPile(pile);
		
		gui = new GUIClass(this);
		gui.setHands(aPlayers[0].getHand());
		
	}
	
	private void determineWinner() {
		if(aPlayers[0].getPlayerScore() > aPlayers[1].getPlayerScore()){
			System.out.println(aPlayers[0].getPlayerName() + " wins!");
		}
		else if(aPlayers[0].getPlayerScore() < aPlayers[1].getPlayerScore()){
			System.out.println(aPlayers[1].getPlayerName() + " wins!");
		}
		else{
			System.out.println("Tie!");
		}
	}
	
	public void playRound() {
		
		int playerTurn = 0;
		
		while(pile.getSize() > 7){
			Player CurrentPlayer = aPlayers[playerTurn];
			pile = CurrentPlayer.fillPile(pile);
			
			gui.setHands(CurrentPlayer.getHand());
			gui.setScores("Scores: " + aPlayers[0].getPlayerName() + ": " + aPlayers[0].getPlayerScore() + " " 
					+ aPlayers[1].getPlayerName() + ": " + aPlayers[1].getPlayerScore());
			
			String sWord = JOptionPane.showInputDialog(null,
					"Please enter a word you would like to play:");
			
			int iPriorScore = CurrentPlayer.getPlayerScore();
			scrabble = CurrentPlayer.playWord(sWord, scrabble,gui);
			
			int iAfterScore = CurrentPlayer.getPlayerScore();
			gui.setScores(CurrentPlayer + " " + iAfterScore);
			int iDiff = iAfterScore - iPriorScore;
			
			JOptionPane.showConfirmDialog(null, "You scored " + iDiff + " points",
					"Points Scored", JOptionPane.OK_CANCEL_OPTION);
			if(playerTurn == 1){
				playerTurn = 0;
			}
			else{
				playerTurn = 1;
			}
			CurrentPlayer = aPlayers[playerTurn];
			gui.setHands(CurrentPlayer.getHand());
		}
		determineWinner();
	}

}
