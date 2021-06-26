import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.sound.sampled.*;

class SudokuGame extends JPanel implements ActionListener{
	private JButton  goMenu;    // variables: button
	public JButton b[][] = new JButton[16][16];  // Creates the buttons
    public static JButton menu1, menu2, menu3, menu4, menu5;
    public JPanel btn, center, title, home; // New panel for the buttons
    public JPanel p[] = new JPanel [16]; // Panel for the seperate sections
    public JLabel label;
    int map [][] = new int [16][16];
    int ans_map[][] = new int [16][16];	
    int hints = 0;  
    int numRows = 0;
	int numColumns = 0;
	int cnt = 0;
 	
	int map1 [][] = {
					{3,4,1,0},
					{0,2,0,0},
					{0,0,2,0},
					{0,1,4,3}};
									
    int map2 [][] = {
					{0,3,4,0},
					{4,0,0,2},
					{1,0,0,3},
					{0,2,1,0}};			
	

    int map3 [][] = {
					{4,1,0,0},
					{2,0,4,0},
					{0,0,2,0},
					{3,0,0,4}};
					
    int map4[][]=	{ 
					{0,8,0,7,0,1,0,3,0},
					{4,0,9,0,0,0,0,0,0},
					{0,5,0,0,6,0,4,1,8},
					{7,0,0,0,0,9,0,0,0},
					{8,0,0,6,1,0,5,0,0},
					{0,3,5,0,0,0,0,2,9},
					{0,6,0,4,0,7,0,9,0},
					{1,0,0,0,0,8,0,0,4},
					{0,2,0,0,5,0,0,7,0}};
						
						
	int map5[][] =  {
					{0,0,6,0,0,0,5,0,7},
					{0,9,0,0,6,8,0,0,0},
					{7,0,8,0,0,5,0,0,4},
					{0,0,1,5,0,4,2,9,0},
					{0,7,0,0,3,0,0,0,0},
					{3,0,9,0,0,0,7,1,0},
					{0,5,0,0,4,0,8,0,9},
					{0,8,2,6,0,0,0,0,0},
					{0,0,0,0,2,7,4,0,6}};
					
	int map6[][] =  {
					{0,0,0,0,8,0,0,0,0},
					{8,0,9,0,7,1,0,2,0},
					{4,0,3,5,0,0,0,0,1},
					{0,0,0,1,0,0,0,0,7},
					{0,0,2,0,3,4,0,8,0},
					{7,3,0,0,0,9,0,0,4},
					{9,0,0,0,0,0,7,0,2},
					{0,0,8,2,0,5,0,9,0},
					{1,0,0,0,4,0,3,0,0}};
					
								
    int map7 [][] = {	
					{0,6,0,0,0,0,0,8,11,0,0,15,14,0,0,16},
					{15,11,0,0,0,16,14,0,0,0,12,0,0,6,0,0},
					{13,0,9,12,0,0,0,0,3,16,14,0,15,11,10,0},
					{2,0,16,0,11,0,15,10,1,0,0,0,0,0,0,0},
					{0,15,11,10,0,0,16,2,13,8,9,12,0,0,0,0},
					{12,13,0,0,4,1,5,6,2,3,0,0,0,0,11,10,5,0},
					{5,0,6,1,12,0,9,0,15,11,10,7,16,0,0,3},
					{0,2,0,0,0,10,0,11,6,0,5,0,0,13,0,9},
					{10,7,15,11,16,0,0,0,12,13,0,0,0,0,0,6},
					{9,0,0,0,0,0,1,0,0,2,0,16,10,0,0,11},
					{1,0,4,6,9,13,0,0,7,0,11,0,3,16,0,0},
					{16,14,0,0,7,0,10,15,4,6,1,0,0,0,13,8},
					{11,10,0,15,0,0,0,16,9,12,13,0,0,1,5,4},
					{0,0,12,0,1,4,6,0,16,0,0,0,11,10,0,0},
					{0,0,5,0,8,12,13,0,10,0,0,11,2,0,0,14},
					{3,16,0,0,10,0,0,7,0,0,6,0,0,0,12,0}};
					
					
	int map8 [][] = {
				{0,15,0,1,0,2,10,14,12,0,0,0,0,0,0,0},
				{0,6,3,16,12,0,8,4,14,15,1,0,2,0,0,0},
				{14,0,9,7,11,3,15,0,0,0,0,0,0,0,0,0},
				{4,13,2,12,0,0,0,0,6,0,0,0,0,15,0,0},
				{0,0,0,0,14,1,11,7,3,5,10,0,0,8,0,12},
				{3,16,0,0,2,4,0,0,0,14,7,13,0,0,5,15},
				{11,0,5,0,0,0,0,0,0,9,4,0,0,6,0,0},
				{0,0,0,0,13,0,16,5,15,0,0,12,0,0,0,0},
				{0,0,0,0,9,0,1,12,0,8,3,10,11,0,15,0},
				{2,12,0,11,0,0,14,3,5,4,0,0,0,0,9,0},
				{6,3,0,4,0,0,13,0,0,11,9,1,0,12,16,2},
				{0,0,10,9,0,0,0,0,0,0,12,0,8,0,6,7},
				{12,8,0,0,16,0,0,10,0,13,0,0,0,5,0,0},
				{5,0,0,0,3,0,4,6,0,1,15,0,0,0,0,0},
				{0,9,1,6,0,14,0,11,0,0,2,0,0,0,10,8},
				{0,14,0,0,0,13,9,0,4,12,11,8,0,0,2,0}};

    int [][] allMaps [] = {map1, map2, map3, map4, map5, map6, map7, map8};
	

	public SudokuGame(int rnd){  // constructor
		label = new JLabel("Sudoku " + rnd);
       
		this.setLayout(new BorderLayout(25,25));
		
		title = new JPanel();
		title.setLayout(new FlowLayout());
		label.setFont(new Font("Courier",1,35));
		title.add(label);
	    center = new JPanel();
		btn = new JPanel();
		btn.setLayout(new GridLayout(1,5, 5, 5));
		map = allMaps[rnd-1];
		
		numRows = map.length;
		numColumns = map[0].length;

		center.setLayout(new GridLayout((int)(Math.sqrt(numRows)),(int)(Math.sqrt(numRows)), 15, 15)); 

	    for ( int j = 0; j < numRows; j++){
			p[j] = new JPanel(); 
			Border blackline = BorderFactory.createLineBorder(Color.black);
			p[j].setLayout(new GridLayout ((int)(Math.sqrt(numRows)),(int)(Math.sqrt(numRows))));
			p[j].setBorder(blackline);
			center.add(p[j]);
			
	    }
	    
		if (numRows == 9) {
			hints = 25;
			addButton(0, 3, 0, 3, 0);
			addButton(0, 3, 3, 6, 1);
			addButton(0, 3, 6, 9, 2);
			addButton(3, 6, 0, 3, 3);
			addButton(3, 6, 3, 6, 4);
			addButton(3, 6, 6, 9, 5);
			addButton(6, 9, 0, 3, 6);
			addButton(6, 9, 3, 6, 7);
			addButton(6, 9, 6, 9, 8);
		}
		else if (numRows == 4) {
			hints = 3;
			addButton(0, 2, 0, 2, 0);
			addButton(0, 2, 2, 4, 1);
			addButton(2, 4, 0, 2, 2);
			addButton(2, 4, 2, 4, 3);			
		}
		else if (numRows == 16) {
			hints = 75;
			addButton(0, 4, 0, 4, 0);
			addButton(0, 4, 4, 8, 1);
			addButton(0, 4, 8, 12, 2);
			addButton(0, 4, 12, 16, 3);
			addButton(4, 8, 0, 4, 4);
			addButton(4, 8, 4, 8, 5);
			addButton(4, 8, 8, 12, 6);
			addButton(4, 8, 12, 16, 7);
			addButton(8, 12, 0, 4, 8);			
			addButton(8, 12, 4, 8, 9);
			addButton(8, 12, 8, 12, 10);
			addButton(8, 12, 12, 16, 11);
			addButton(12, 16, 0, 4, 12);
			addButton(12, 16, 4, 8, 13);
			addButton(12, 16, 8, 12, 14);
			addButton(12, 16, 12, 16, 15);
        }
			
		this.add(center, BorderLayout.CENTER);
		
		menu1 = new JButton ("Check");
		menu2 = new JButton("Hints " + "(" + hints + ")");
		menu3 = new JButton("Quit"); 
		menu4 = new JButton("Answer");
		menu5 = new JButton("Home");
		
		menu1.setFont(new Font("SansSerif", Font.BOLD, 15));
		menu2.setFont(new Font("SansSerif", Font.BOLD, 15));
		menu3.setFont(new Font("SansSerif", Font.BOLD, 15));
		menu4.setFont(new Font("SansSerif", Font.BOLD, 15));
		menu5.setFont(new Font("SansSerif", Font.BOLD, 15));

		btn.add(menu5);
		btn.add(menu1);
		btn.add(menu2);
		btn.add(menu4);
		btn.add(menu3);
		
		menu1.addActionListener(this);
		menu2.addActionListener(this);
		menu3.addActionListener(this);
		menu4.addActionListener(this);
		menu5.addActionListener(this);

		
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				ans_map[row][col] = map[row][col];
			}
		}


        solve();		
		
		this.add(title, BorderLayout.NORTH);
		this.add(btn, BorderLayout.SOUTH);
		
		
		
	
    		
		}

	public void addButton(int x, int y, int a, int c, int z){
	    for (int i = x; i < y; i++) {
			for (int k = a; k < c; k++) {
				b[i][k] = new JButton (""+ map[i][k]);
				p[z].add(b[i][k]);
				if (numRows == 4 || numRows == 9) {
					b[i][k].setFont(new Font("SansSerif", Font.BOLD, 30));
				}
				else if (numRows == 16) {
					b[i][k].setFont(new Font("SansSerif", Font.BOLD, 12));	
				}
				
				/*
				if (z % 2 != 0) {
				    b[i][k].setBackground(Color.WHITE);
				    b[i][k].setForeground(Color.BLACK);										
			    }
				else {
				    b[i][k].setForeground(Color.WHITE);
				    b[i][k].setBackground(Color.BLACK);					
				}	
				*/
						
				if (map[i][k] == 0) {					
	                b[i][k].addActionListener(this);
				}
				else {
				    b[i][k].setForeground(Color.gray);
				}
            }   
		}
    }
    
	private boolean isInRow(int row, int number) { //credit to https://gist.github.com/ssaurel
		for (int i = 0; i < numRows; i++)
			if (ans_map[row][i] == number)
				return true;
		
		return false;
	}
	
	private boolean isInCol(int col, int number) { //credit to https://gist.github.com/ssaurel
		for (int i = 0; i < numColumns; i++)
			if (ans_map[i][col] == number)
				return true;
		
		return false;
	}
	
	private boolean isInBox(int row, int col, int number) { //credit to https://gist.github.com/ssaurel
		int r = row - row % (int)(Math.sqrt(numRows));
		int c = col - col % (int)(Math.sqrt(numRows));
		
		for (int i = r; i < r + (int)(Math.sqrt(numRows)); i++)
			for (int j = c; j < c + (int)(Math.sqrt(numRows)); j++)
				if (ans_map[i][j] == number)
					return true;
		
		return false;
	}
	
	private boolean isOk(int row, int col, int number) { //credit to https://gist.github.com/ssaurel
		return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInBox(row, col, number);
	}
	
    public boolean solve() {	//credit to https://gist.github.com/ssaurel
        for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				if (ans_map[row][col] == 0) {
					for (int number = 1; number <= numRows; number++) {
						if (isOk(row, col, number)) {
							ans_map[row][col] = number;
							if (solve()) { 
								return true;
							} else { 
								ans_map[row][col] = 0;
							}
						}
					}
					return false; 
				}
			}
        }
        return true; // sudoku solved
	}
	
	public void display() {
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				map[i][j] = ans_map[i][j];
				b[i][j].setText(""+ ans_map[i][j]);
				b[i][j].setEnabled(false);
			}
		}
			menu1.setEnabled(false);
			menu2.setEnabled(false);
			menu4.setEnabled(false);
	}
		
    public void actionPerformed(ActionEvent e) {			  
		int ran1, ran2 = 0;
		for ( int j = 0; j < numRows; j++){
			for (int i = 0; i < numColumns; i++) {
				if (map[j][i] >= numRows)
					map[j][i] -= numRows + 1;
                if (map[j][i] == -1) {
                    map[j][i] += numRows + 1;
					if (e.getSource() == b[j][i]) {
						b[j][i].setText(""+ (map[j][i]-numRows));
						map[j][i] += 1;
						break;
					}
				}
			    if (e.getSource() == b[j][i]) {
					map[j][i] += 1;
					b[j][i].setText(""+ (map[j][i]));
					for (int k = 0; k < numRows; k++){
						for (int l = 0; l < numColumns; l++) {
							if (map[k][l] == ans_map[k][l]) {
								cnt += 1;
								System.out.println(cnt);
							}
						}
					}
					System.out.println("final " + cnt);
					System.out.println("FINAL " + numRows*numColumns);
					if (cnt == numRows*numColumns) 	
						menu2.setEnabled(false);
					cnt = 0;
					break;
			    }
			}
        }
		
		if (e.getSource() == menu1) {
			for (int j = 0; j < numRows; j++){
				for (int i = 0; i < numColumns; i++) {
						if (map[j][i] == ans_map[j][i]) {
							cnt += 1;
						}
				}
			}
	
		
			if (cnt == numRows*numColumns) {
				playsound("win.wav");
				JOptionPane.showMessageDialog(null, "Correct!", "Check Message",JOptionPane.WARNING_MESSAGE ); 
				menu1.setEnabled(false);
				menu2.setEnabled(false);
				menu4.setEnabled(false);
					
			}
			else if (e.getSource() == menu1) {
				playsound("Lose.wav");
				JOptionPane.showMessageDialog(null, "Nope! Not there yet. Your score is: " + cnt + "/" + numRows*numColumns + ". You have " + ((numRows*numColumns)-cnt) + " left to complete.", "Check message",JOptionPane.WARNING_MESSAGE ); 
			}
			cnt = 0;
		
		}
		
		if (e.getSource() == menu2) {
			
			hints--;
			menu2.setText("Hints " + "(" + hints + ")");
            ran1 = (int)(Math.random()*numRows);
			ran2 = (int)(Math.random()*numRows);
			while (map[ran1][ran2] == ans_map[ran1][ran2]) {
				ran1 = (int)(Math.random()*numRows);
				ran2 = (int)(Math.random()*numRows);
			}
            
			b[ran1][ran2].setEnabled(false);
			map[ran1][ran2] = ans_map[ran1][ran2];
			b[ran1][ran2].setText(""+ (map[ran1][ran2]));
			
			if (hints == 0)
				menu2.setEnabled(false);

		}
		
		if (e.getSource() == menu4) {
			display();

		}
		if (e.getSource()== menu5){
			PlayGame.cardsL.next(PlayGame.c);
			Menu panel = new Menu();
			PlayGame.c.add("MenuNickName", panel);			
			PlayGame.cardsL.previous(PlayGame.c);
		}
		
		if (e.getSource() == menu3) {
				JOptionPane.showMessageDialog(null, "You Quit!", "My exit message",JOptionPane.WARNING_MESSAGE ); 
				System.exit(0);
	
	}
}

public static void playsound(String path){
	try {
		AudioInputStream stream; 
		AudioFormat format;
		DataLine.Info info;
		Clip clip;
		stream = AudioSystem.getAudioInputStream(new File (path));
		format = stream.getFormat();
		info = new DataLine.Info(Clip.class,format);
		clip = (Clip) AudioSystem.getLine(info);
		clip.open(stream);
		clip.start();
	}
	catch(Exception e){}
}

}// end of SudokuGame class

