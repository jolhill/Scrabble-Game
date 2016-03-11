import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GUIClass extends JFrame {

	private JButton squares[][];
	private JPanel content;
	private ButtonHandler bh;
	private JTextField hands;
	private JTextField scores;
	private int[] iSpotClicked;
	private boolean clicked;
	private Scrabble scrabble;
	
	public boolean clicked(){
		return clicked;
	}
	public void setClicked(boolean b){
		clicked = b;
	}
	public GUIClass(Scrabble scrabble) {
		this.scrabble = scrabble;
		setTitle("Scrabble\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 650, 500);
		content = new JPanel();
		
		setContentPane(content);
		content.setLayout(new BorderLayout(0, 0));

		scores = new JTextField("Player 1 : 0 Player 2: 0");
		scores.setPreferredSize( new Dimension( 200, 50 ) );
		scores.setEditable(false);
		scores.setFont(new Font("Tahoma", Font.BOLD, 20));
		scores.setHorizontalAlignment(JTextField.CENTER);
		scores.setBackground(Color.WHITE);
		content.add(scores, BorderLayout.NORTH);

		bh = new ButtonHandler();
		
		//Nests a JPanel inside BorderLayout Center
		JPanel panel = new JPanel();
		content.add(panel, BorderLayout.CENTER);
		//Creates GridLayout Inside Panel
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(15, 15));
		
		
		//Makes buttons
		squares = new JButton[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				squares[i][j] = new JButton();
				squares[i][j].setText("*");
				panel.add(squares[i][j]);
				squares[i][j].addActionListener(bh);
				squares[i][j].setBackground(new Color(245, 222, 179));
				squares[i][j].setBorder(new LineBorder(new Color(244, 164, 96)));
			}

		}
		hands = new JTextField("HANDS GO HERE (If we put hands here we need to clean up how we print the hands out... but scores could go here too.)");
		hands.setHorizontalAlignment(JTextField.CENTER);
		hands.setBackground(Color.CYAN);
		content.add(hands, BorderLayout.SOUTH);
		hands.setPreferredSize( new Dimension( 100, 60 ) );
		hands.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		setSize(800,800);
		setResizable(false);
		setVisible(true);
	}
	
	public void setHands(String hand){
		hands.setText(hand);
	}
	
	public void setScores(String score){
		scores.setText(score);
	}
	
	public void playChar(char c,int x,int y){
		squares[x][y].setText("" + c);
		squares[x][y].removeActionListener(bh);
	}
	public int[] getSpotClicked() {
		return iSpotClicked;
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					if (ae.getSource() == squares[i][j]) {
						iSpotClicked = new int[2];
						iSpotClicked [0] = j;
						iSpotClicked[1] = i;
						scrabble.playRound();
					}
				}
			}
		}
	}
}
