import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
Name: Josh Hill and Samuel Hinkhouse
Date: 1/17/2016
Description: This class is the Board class. It allows us to set the board and get the board.
*/

public class Board {
	String board [][] = new String [15][15];
	char [] cAlpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'};
	int [] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	public Board() {
		setBoard();
	}

	//Makes 15X15 Scrabble Board
	public void setBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = "| |";
			}
		}
	}
	public void setSquare(char c,int iRow,int iCollumn){
		if(iRow < 15 && iCollumn <15){
			board[iRow][iCollumn] ="|" + c + "|";
		}
		
	}
	public char getSquare(int iRow,int iCollumn){
		return(board[iRow][iCollumn].charAt(1));
	}
	public Object [] getInput(){
		Object [] lDirections = {"Horizontal","Vertical"};
		//keep null, Prompt, Title of box, Type of message, icon {ignore this}, object[] containing options, default anwser
		String sOrientation = (String)JOptionPane.showInputDialog(null,
				"Select word orientation", "Orientation",
				JOptionPane.PLAIN_MESSAGE, null, lDirections, "Vertical");
		Object [] lNums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int iRow = (int)JOptionPane.showInputDialog(null,
				"Select row number", "Row",
				JOptionPane.PLAIN_MESSAGE, null, lNums, "1");
		Object [] lChars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O'};
		char cCollumn = (char)JOptionPane.showInputDialog(null,
				"Select collumn", "Collumn",
				JOptionPane.PLAIN_MESSAGE, null, lChars, "A");
		Object [] aInput = {sOrientation,iRow,cCollumn};
		return(aInput);
	}
	
	//POSSIBLE ARRAY OUT OF BOUNDS EXCEPTION IF USER DOESN'T
	//LEAVE ENOUGH ROOM FOR THE WORD
	public boolean setWord(String sWord,ArrayList<Tile> aPlayerPile, GUIClass gui){
		sWord = sWord.toLowerCase();
		int [] iCoords = gui.getSpotClicked();
		int iRow = iCoords[0];
		int iCollumn = iCoords[1];
		//_____________VALIDITY CHECKING__________________
		for (int i = 0; i < sWord.length(); i++) {
			boolean hasLetter = false;
			for(Tile t : aPlayerPile){
				if(t.isBlankTile()){
					t.setLetterJOption();
				}
				//System.out.println(t.getLetter() +" and "+ sWord.charAt(i));
				if(t.getLetter() == sWord.charAt(i)){
					hasLetter = true;
					break;
				}
			}
			if(!hasLetter && !(getSquare(iRow, iCollumn) == sWord.charAt(i))){
				return(false);
			}
		
		}
		//_____________BOARD MANIPULATION_________________
		Object [] options = {"Vertical","Horizontal"};
		String sOrientation = ((String)JOptionPane.showInputDialog(null, "Select Orientation",
				"Orientation", JOptionPane.PLAIN_MESSAGE, null, options, "Vertical"));
		if(sOrientation.equals("Vertical")){
			for(int i = 0; i < sWord.length(); i++){
				board[iRow][iCollumn] = "[" + sWord.charAt(i)+"]";
				gui.playChar(sWord.charAt(i), iRow, iCollumn); //Flipped iRow and iCollumn around so it would print out vertically
				iRow++;
			}
		}
		else{
			for(int i = 0; i < sWord.length(); i++){
				board[iRow][iCollumn] = "[" + sWord.charAt(i)+"]";
				gui.playChar(sWord.charAt(i), iCollumn, iRow);
				iCollumn++;
			}
		}
		return true;
	}
	
	//Prints out the Game Board
	public void getBoard() {
		String sTitle = "*";
		System.out.printf("%-6s",sTitle);
		for (int i  = 0; i < cAlpha.length; i++) {
			char cAlphabet  = cAlpha[i];
			System.out.printf("%-3C", cAlphabet);
		}
		
		System.out.println();
		String sBoard = "";
		for (int i = 0; i < board.length; i++) {
			String sNumbers  = numbers[i] + ": ";
			System.out.printf("%-5s",sNumbers);
			
			for (int j = 0; j < board[i].length; j++) {
				sBoard = board[i][j]; 
				System.out.printf("%-2s",sBoard);
			}
			System.out.println();
		}
		
	}

	
}
