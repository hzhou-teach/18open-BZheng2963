/*
Bill Zheng
Time: 1 hour
USACO Test Cases: **********
1-10 Difficulty: 5
Reflection: I learned about iterating through Characters and I tried to implement methods finally into my code because I wasn't
	doing that in the past. Finding the correct and full solution by pairing all of the individual characters A-Z was hard, and I
	took a good amount of time debugging my code.
 */

import java.io.*;
import java.util.*;

public class tttt_18Open_bronze {

	static char[][] grid = new char[3][3]; //global grid variable
	
	static int soloWin(char C) {
		//diagonals
		if (C == grid[0][0] && C == grid[1][1] && C == grid[2][2]) return 1;
		if (C == grid[0][2] && C == grid[1][1] && C == grid[2][0]) return 1;
		//rows and columns
		for (int i = 0; i < 3; i++) {
			if (C == grid[0][i] && C == grid[1][i] && C == grid[2][i]) return 1;
			if (C == grid[i][0] && C == grid[i][1] && C == grid[i][2]) return 1;
		}
		return 0;
	}
	static int teamWin(char A, char B) {
		//basically checking if all the spots have ONE of the TWO letters in it, then checking if all three spots have AT LEAST 1 of EACH letter
		//diagonals
		if ((grid[0][0]==A||grid[0][0]==B)&&(grid[1][1]==A||grid[1][1]==B)&&(grid[2][2]==A||grid[2][2]==B)) {
			if ((grid[0][0]==A||grid[1][1]==A||grid[2][2]==A)&&(grid[0][0]==B||grid[1][1]==B||grid[2][2]==B)) return 1;
		}
		if ((grid[0][2]==A||grid[0][2]==B)&&(grid[1][1]==A||grid[1][1]==B)&&(grid[2][0]==A||grid[2][0]==B)) {
			if ((grid[0][2]==A||grid[1][1]==A||grid[2][0]==A)&&(grid[0][2]==B||grid[1][1]==B||grid[2][0]==B)) return 1;
		}
		//rows and columns
		for (int i = 0; i < 3; i++) {
			if ((grid[0][i]==A||grid[0][i]==B)&&(grid[1][i]==A||grid[1][i]==B)&&(grid[2][i]==A||grid[2][i]==B)) {
				if ((grid[0][i]==A||grid[1][i]==A||grid[2][i]==A)&&(grid[0][i]==B||grid[1][i]==B||grid[2][i]==B)) return 1;
			}
			if ((grid[i][0]==A||grid[i][0]==B)&&(grid[i][1]==A||grid[i][1]==B)&&(grid[i][2]==A||grid[i][2]==B)) {
				if ((grid[i][0]==A||grid[i][1]==A||grid[i][2]==A)&&(grid[i][0]==B||grid[i][1]==B||grid[i][2]==B)) return 1;
			}
		}
		return 0;
	}
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("tttt.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
//--------------------------------------------------------------------------------------------------------------------------
		String s = "";
		s = scan.next();
		for (int i = 0; i < 3; i++) {
			grid[0][i] = s.charAt(i);
		}
		s = scan.next();
		for (int i = 0; i < 3; i++) {
			grid[1][i] = s.charAt(i);
		}
		s = scan.next();
		for (int i = 0; i < 3; i++) {
			grid[2][i] = s.charAt(i);
		} //I probably could have condensed the input stuff above
//--------------------------------------------------------------------------------------------------------------------------
		int solo = 0;
		int team = 0;
		
		for (char i = 'A'; i <= 'Z'; i++) {
			solo += soloWin(i); //if this single character wins, the solo count ++
		}
		
		for (char i = 'A'; i <= 'Y'; i++) {
			for (char j = (char)(i+1); j <= 'Z'; j++) {
				team += teamWin(i,j); //pairs of characters are only looked at once, if the pair can win, team ++
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		out.println(solo);
		out.println(team);

		out.close();
		scan.close();
	}
}
