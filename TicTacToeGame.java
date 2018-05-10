import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class TicTacToeGame {

private static int[][] ToWin = new int[][] { {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}			 
};
	
private static JButton buttons[] = new JButton[9]; 

public static void main (String[] args) {
		PlayGame(); 
	}

	private static void PlayGame(){
		
		JFrame box = new JFrame ("TicTacToe");
		box.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		JPanel grid = new JPanel(); 
		grid.setLayout (new GridLayout (3, 3));
		grid.setBorder (BorderFactory.createLineBorder (Color.WHITE, 3));
		grid.setBackground (Color.BLACK);
		
		for(int i=0; i<=8; i++) { 
			buttons[i] = new newButton();
			grid.add(buttons[i]);			
		}
		box.getContentPane().add (grid);
		box.pack();
		box.setVisible(true);
		box.setSize(600, 600);
		
	}

	public static int count = 0; 

	private static class newButton extends JButton 
	implements ActionListener {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;		
		int restart = 0;
		boolean win = false; 
		String XorO;
		public newButton() {	
			super();
			XorO=" ";
			setFont(new Font("Dialog", 1, 60));
			setText(XorO);
			addActionListener(this);
		}
		public void actionPerformed(ActionEvent x) { 
			if((count % 2)==0 && getText().equals(" ") && win==false){
				XorO = "X";
				count = count + 1;
			} else if((count % 2)==1 && getText().equals(" ") && win==false) {
				XorO = "O";
				count = count+ 1;
			} 
			setText(XorO); 
			for(int i=0; i<=7; i++) { 
				if( buttons[ToWin[i][0]].getText().equals(buttons[ToWin[i][1]].getText()) && 
					buttons[ToWin[i][1]].getText().equals(buttons[ToWin[i][2]].getText()) && 
					buttons[ToWin[i][0]].getText() != " ") {
					win = true;
				}
			}
			
			if(win == true){ 
				restart = JOptionPane.showConfirmDialog(null, XorO + " wins the game!  Do you want to play again?", XorO + "Won!", JOptionPane.YES_NO_OPTION);
				
			} else if(count == 9 && win == false) {
				restart = JOptionPane.showConfirmDialog(null, "The game was tie!  Do you want to play again?","Tie game!",JOptionPane.YES_NO_OPTION);
				win=true;
			}	
			
			if(restart == JOptionPane.YES_OPTION && win==true){ 
					Restart();			
					win = false;
			}
			else if(restart == JOptionPane.NO_OPTION){
				System.exit(0); 
			}

		}

	}
	
	public static void Restart() {
		
		for(int i = 0; i <= 8; i++) { 
			buttons[i].setText(" ");						
		}
		count = 0; 
		
	}
}
