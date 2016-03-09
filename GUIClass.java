import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(content);
		content.setLayout(new BorderLayout(0, 0));

		JTextPane introduction = new JTextPane();
		introduction.setEditable(false);
		introduction.setText("Welcome to Scrabble!");
		introduction.setBackground(Color.red);
		content.add(introduction, BorderLayout.NORTH);

		bh = new ButtonHandler();
		
		//Nests a JPanel inside BorderLayout Center
		JPanel panel = new JPanel();
		content.add(panel, BorderLayout.CENTER);
		//Creates GridLayout Inside Panel
		panel.setLayout(new GridLayout(15, 15));
		
		scores = new JTextPane();
		content.add(scores, BorderLayout.WEST);
		scores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scores.setEditable(false);
		scores.setText("Score: 0-0");
		scores.setBackground(Color.lightGray);
		squares = new JButton[15][15];
		setSize(1000,800);
		//Makes buttons
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				squares[i][j] = new JButton();
				squares[i][j].setText("*");
				panel.add(squares[i][j]);
				squares[i][j].addActionListener(bh);
				squares[i][j].setBackground(Color.yellow);
			}

		}
		hands = new JTextField("HANDS GO HERE");
		hands.setBackground(Color.CYAN);
		content.add(hands, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void setHands(String hand){
		scores.setText(hand);
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
						wakeUp();
						return;
					}
				}
			}
		}
	}
}
