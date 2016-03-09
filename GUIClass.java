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
	private JTextPane scores;
	private int[] iSpotClicked;
	private boolean clicked;
//	//Only here for testing purposes
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUIClass frame = new GUIClass();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public boolean clicked(){
		return clicked;
	}
	public void setClicked(boolean b){
		clicked = b;
	}
	public GUIClass() {
		setTitle("Scrabble\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 650, 500);
		content = new JPanel();
		
		setContentPane(content);
		content.setLayout(new BorderLayout(0, 0));

		JTextPane introduction = new JTextPane();
		introduction.setPreferredSize( new Dimension( 200, 50 ) );
		introduction.setEditable(false);
		introduction.setFont(new Font("Tahoma", Font.BOLD, 20));
		introduction.setText("Scores will go here in this format: \"Player 1 : 0 Player 2: 0\"");
		introduction.setBackground(Color.WHITE);
		content.add(introduction, BorderLayout.NORTH);

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
		
		hands.setBackground(Color.CYAN);
		content.add(hands, BorderLayout.SOUTH);
		hands.setPreferredSize( new Dimension( 100, 60 ) );
		hands.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		setSize(800,800);
		setResizable(false);
		setVisible(true);
	}
	
	public void setHands(String hand){
		hands.setText(hand);
	}
	
	public void setScores(String score){
		hands.setText(score);
	}
	
	public void playChar(char c,int x,int y){
		squares[y][x].setText("" + c);
		squares[y][x].removeActionListener(bh);
	}
	public int[] getSpotClicked() {
		return iSpotClicked;
	}
	public void wakeUp(){
		notifyAll();
	}
	
	//REAL LOGIC NEEDS ADDED
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					if (ae.getSource() == squares[i][j]) {
						iSpotClicked = new int[2];
						iSpotClicked [0] = j;
						iSpotClicked[1] = i;
						clicked = true;
						//wakeUp();
						return;
					}
				}
			}
		}
	}
}
