package mini2;

import java.util.*;

public class TicTacToe {
	
	public static char[][] box = new char[3][3];
	
	public static void printBox() {
		
		for (int i=0; i<3; i++) {
			//System.out.print("  |");
			for (int j=0; j<3; j++) {
				System.out.printf(" %c ", box[i][j]);
				if (j<2)
					System.out.print("|");
			}
			if (i<2)
				System.out.print("\n---|---|---\n");
		}
		System.out.print("\n\n");
	}
	
	public static void fillBox(char p, int x, int y) {
		box[x][y] = p;
		printBox();
	}
	
	// if checkStatus returns true, game over
	public static boolean checkStatus() {
		for (int i=0; i<3; i++) {
			// check rows
			if (box[i][0]==box[i][1] && box[i][1] == box[i][2] && box[i][2] != ' ' )
				return true;
			// check columns
			if (box[0][i]==box[1][i] && box[1][i] == box[2][i] && box[2][i] != ' ' )
				return true;
		}
		// check diagonal 1
		if (box[0][0]==box[1][1] && box[1][1] == box[2][2] && box[2][2] != ' ' )
			return true;
		// check diagonal 2
		if (box[2][0]==box[1][1] && box[1][1] == box[0][2] && box[0][2] != ' ' )
			return true;
		
		return checkDraw();
	}
	
	// true means game resulted in a draw
	public static boolean checkDraw() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (box[i][j] == ' ')
					return false;
			}
		}
		return true;
	}
	
	
	public static String findWinner() {
		
		for (int i=0; i<3; i++) {
			// check rows
			if (box[i][0]==box[i][1] && box[i][1] == box[i][2] && box[i][2] != ' ' )
				return "winner: " + box[i][0];
			// check columns
			if (box[0][i]==box[1][i] && box[1][i] == box[2][i] && box[2][i] != ' ' )
				return "winner: " + box[0][i];
		}
		// check diagonal 1
		if (box[0][0]==box[1][1] && box[1][1] == box[2][2] && box[2][2] != ' ' )
			return "winner: " + box[0][0];
		// check diagonal 2
		if (box[2][0]==box[1][1] && box[1][1] == box[0][2] && box[0][2] != ' ' )
			return "winner: " + box[2][0];
		
		return "draw";
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				box[i][j] = ' ';
			}
		}
		
		System.out.print("Tic-Tac-Toe\nEnter your input in the format: a r c\nwhere a = o or x, r = row, c = column\n\n");
		printBox();
		
		Scanner sc = new Scanner(System.in);
		
		while (!checkStatus()) {
			System.out.println("your move: ");
			fillBox(sc.next().charAt(0), sc.nextInt(), sc.nextInt());
		}
		
		sc.close();
		
		System.out.println(findWinner());

	}

}
