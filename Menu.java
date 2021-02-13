import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.sound.sampled.*;
class Menu extends JPanel implements ActionListener{
		private JButton rules, easy, medium, difficult, quit;   
		private JPanel levels, pic; 
		private String ruleMessage = "The classic Sudoku game involves a grid of 81 squares.\nThe grid is divided into nine blocks, each containing nine squares.\n\nThe rules of the game are simple: each of the nine blocks has to contain all the numbers 1-9 within its squares.\nEach number can only appear once in a row, column or box.\n\nThe difficulty lies in that each vertical nine-square column, or horizontal nine-square line across, \nwithin the larger square, must also contain the numbers 1-9, without repetition or omission. \n\nEVERY PUZZLE HAS JUST ONE CORRECT SOLUTION. \n\n\n In our case we have 3 different sets of difficulties; easy, medium and hard. In the easist difficultiy we have \na 4 by 4 sudoku instead of the classic 9 by 9, but the same rules apply. Also, for the hard mode it is a sixteen by sixteen sudoku.";
		private ImageIcon image1; 
		private JLabel label1;
		int number; 
		
		public Menu(){  // constructor

			   
			   this.setLayout(new BorderLayout(25,25));
			   levels = new JPanel(); 
			   levels.setLayout(new GridLayout(1,5,5,5));
			   
			   pic = new JPanel(); 
			   pic.setLayout(new FlowLayout());
			   
			   
			   image1 = new ImageIcon(getClass().getResource("home.png"));
			   label1 = new JLabel(image1);
			   pic.add(label1);
			   pic.setBackground(Color.WHITE);

				//Initializing the buttons
	           rules = new JButton("Rules");
	           easy = new JButton("Easy");
	           medium = new JButton("Medium");
	           difficult = new JButton("Hard");
	           quit = new JButton("Quit");
	         
	           // add the buttons to the levels panel
			   levels.add(rules); 
	           levels.add(easy); 
	           levels.add(medium);   
	           levels.add(difficult);   
	           levels.add(quit);
			   
			   //Makes the buttons alive
			   rules.addActionListener(this);
			   easy.addActionListener(this);
      		   medium.addActionListener(this);
			   difficult.addActionListener(this);
			   quit.addActionListener(this);
			   
			   rules.setFont(new Font("SansSerif", Font.BOLD, 15));
			   easy.setFont(new Font("SansSerif", Font.BOLD, 15));
			   medium.setFont(new Font("SansSerif", Font.BOLD, 15));
			   difficult.setFont(new Font("SansSerif", Font.BOLD, 15));
			   quit.setFont(new Font("SansSerif", Font.BOLD, 15));
			   
			   this.setBackground(Color.WHITE);
			   this.add(levels, BorderLayout.SOUTH);
			   this.add(pic, BorderLayout.CENTER);
		}
		
	    public void actionPerformed(ActionEvent e) {
			if(e.getSource() == rules) {
				JOptionPane.showMessageDialog(null, ruleMessage, "Rules",JOptionPane.WARNING_MESSAGE ); 

			}
			
			else if(e.getSource() == easy) {
				number = (int)(Math.random()*3)+1;
				SudokuGame sudoku = new SudokuGame(number);
				PlayGame.c.add("GameNickName", sudoku);
				PlayGame.cardsL.next(PlayGame.c);

			}
			else if(e.getSource() == medium) {
				number = (int)(Math.random()*3)+4;
				SudokuGame sudoku = new SudokuGame(number);
				PlayGame.c.add("GameNickName", sudoku);
				PlayGame.cardsL.next(PlayGame.c);
			}
			else if(e.getSource() == difficult) {
				number = (int)(Math.random()*2)+7;
				SudokuGame sudoku = new SudokuGame(number);
				PlayGame.c.add("GameNickName", sudoku);
				PlayGame.cardsL.next(PlayGame.c);
			}
			else if(e.getSource() == quit) {
				JOptionPane.showMessageDialog(null, "You Quit!", "My exit message",JOptionPane.WARNING_MESSAGE ); 
				System.exit(0);
			}
	}
	 

}// end of Menu class
