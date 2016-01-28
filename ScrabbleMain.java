import javax.swing.JOptionPane;

public class ScrabbleMain{
	
	public static void main(String [] args){
//_______________BEGIN SETUP_________________
		Board scrabble = new Board();
		Pile pile = new Pile();
	    System.out.println();
	    
		Player player1 = new Player(1,"Josh");
		Player player2 = new Player(2,"Sam");
		Player [] aPlayers = {player1,player2};
		
		pile = player1.fillPile(pile);
		pile = player2.fillPile(pile);
//________________END SETUP__________________
		int playerTurn = 0;
		while(pile.getSize() > 7){
			Player CurrentPlayer = aPlayers[playerTurn];
			pile = CurrentPlayer.fillPile(pile);
			scrabble.getBoard();
			JOptionPane.showMessageDialog(null,CurrentPlayer.getHand());
			boolean playWord = YesNoPrompt("Would you like to play a word?");
			if(playWord){
				String sWord = JOptionPane.showInputDialog(null,
						"Please enter a word you would like to play:");
				int iPriorScore = CurrentPlayer.getPlayerScore();
				scrabble = CurrentPlayer.playWord(sWord, scrabble);
				int iAfterScore = CurrentPlayer.getPlayerScore();
				int iDiff = iAfterScore - iPriorScore;
				System.out.println("You scored " + iDiff + " points");	
			}
		
			if(playerTurn == 1){
				playerTurn = 0;
			}
			else{
				playerTurn = 1;
			}
			System.out.println("\n\n\n\n");
		}
		if(player1.getPlayerScore()>player2.getPlayerScore()){
			System.out.println(player1.getPlayerName() + " wins!");
		}
		else if(player1.getPlayerScore()<player2.getPlayerScore()){
			System.out.println(player2.getPlayerName() + " wins!");
		}
		else{
			System.out.println("Tie!");
		}
	}
	public static boolean YesNoPrompt(String sMessage){
		int choice = JOptionPane.showConfirmDialog(
			    null, sMessage,
			    "",
			    JOptionPane.YES_NO_OPTION);
		if (choice == 0){
			return true;
		}

		else{
			return false;
		}
	}
}
