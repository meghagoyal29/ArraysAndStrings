import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Chess {

	static int waysToGiveACheck(char[][] board) {
		// Complete this function
		//P=80 65-90
		//k=107 K=75 97-122
		//# 35
		// iterate in streches of 8 rows find positions of k, p, K and the 4th piece and then strategize
		int[] pawnPos = new int[2];
		int[] bkPos = new int[2];
		int[] wkPos = new int[2];
		int[] forthPos = new int[2];
		char fourth = 'x';
		int answerCount = 0;
		int hashCount = 0;
		for(int board_i = 0; board_i < 8; board_i++){
			for(int board_j = 0; board_j < 8; board_j++){
				switch(board[board_i][board_j]){
				case 35:
					hashCount++;
					break;
				case 80:
					{pawnPos[0] = board_i;
					pawnPos[1] = board_j;
					break;}
				case 107:
					{bkPos[0] = board_i;
					bkPos[1] = board_j;
					break;}
				case 75:
					{wkPos[0] = board_i;
					wkPos[1] = board_j;
					break;}
				default:
					{forthPos[0] = board_i;
					forthPos[1] = board_j;
					fourth = board[board_i][board_j];
					break;}
				}
			}
		}

		int xdistPk = Math.abs(pawnPos[0] - bkPos[0]);
		int ydistPk = Math.abs(pawnPos[1] - bkPos[1]);

		if(xdistPk == ydistPk)
			answerCount = answerCount+2;
		if(xdistPk==0)
			answerCount++;
		if(ydistPk ==0)
			answerCount++;
		if((xdistPk == 2 && ydistPk==1) || (xdistPk == 1 && ydistPk==2) )
			answerCount++;

		return answerCount;

	}



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			char[][] board = new char[8][8];
			for(int board_i = 0; board_i < 8; board_i++){
				for(int board_j = 0; board_j < 8; board_j++){
					if(in.hasNext())
					board[board_i][board_j] = in.next().charAt(0);
				}
			}
			int result = waysToGiveACheck(board);
			System.out.println(result);
		}
		in.close();
	}
}


