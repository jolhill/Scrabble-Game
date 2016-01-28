# Scrabble
import java.util.ArrayList;
Tile Class Methods
  Tile Class will hold a Face value (character) and point value (number 1-10)
  We will need a method that will connect the face value to each point value.
  setTileValues()
Player Class Methods
  import java.swing.JOptionPane;
  getPlayerTile() //This will use the getRandom() from pile to get a Tile from the Pile ArrayList. 
  getPlayerHand() //Use .peek() to print out their hand. We could use JOptionPane to show their 
                    hand while they have the option to input it.
  checkForTilesForWord() //we need to check to make sure they have the correct letters to make the word.
  play() //This class will play the word on the board. 
  drawNewLetters() //This allows the player to draw new tiles before playing.
  We will use JOptionPane to allow the player to select where they would like to play on the board and what direction.
Play Class
  Use this to pass in the player class and it will run all the methods in the Play class.
Pile Class Methods
  import java.util.Random;
  setPile() //This method will set the pile of letters use an ArrayList Type Tile, we can user a four loop to add each of the piles.
  getPile() //This will return our ArrayList of letters from our pile.
  removeTile() //This class will remove a tile from the ArrayList Pile.
  getRandom() //This pile will get a random number.
Board Class Methods
  setBoard() //Makes 15X15 Scrabble Board
  getBoard() //Prints out the Game Board in the console
  
Setup Class Methods
  //In here we will initalize the game board, possibly the players and their letters...
  We could use setBoard(), setPile(), setTileValues()
Main Class
  setPlayers() //We need to ask the user how many players are going to play (Scrabble allows 2-4 players to play.
