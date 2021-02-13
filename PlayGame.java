import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.sound.sampled.*;


public class PlayGame extends JFrame {
	static CardLayout cardsL;
	static Container c;
	
	Menu  menuP;  // object of my customized class Menu
	SudokuGame gameP;   // object of my customized class MyGamePanel
	

	
	public PlayGame(){    //constructor
		c = getContentPane();
		cardsL = new CardLayout();
		c.setLayout(cardsL);
	   
		menuP = new Menu();
	  // gameP = new SudokuGame();
	  
		c.add("MenuNickName", menuP);
  	  // c.add("GameNickName", gameP);
  	  
	}

	public static void main(String[] args) {
		PlayGame a = new PlayGame();
		a.setSize(1000, 800);
		a.setVisible(true);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // make frame closed when x button is pressed
		//a.setResizable(false);

	}
    
} //end of demo class


