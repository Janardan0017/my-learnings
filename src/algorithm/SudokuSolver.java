import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class SudokuSolver {

	public static void main(String[] args){
		int[][] board = new int[9][9];
		fillDigonalBoxes(board);
		// Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		// System.out.println("Enter the input values in the form: x y val, Press 0 to exit");		
		// String input = in.nextLine();
		// while(!input.equals("0")){
		// 	String[] values = input.split(" ");
		// 	int x = Integer.valueOf(values[0]);
		// 	int y = Integer.valueOf(values[1]);
		// 	int val = Integer.valueOf(values[2]);
		// 	board[x][y] = val;
		// 	input = in.nextLine();
		// }

		// for(int[] row: board){
		// 	Arrays.setAll(row, n -> (int)(Math.random()*10));
		// }

		// for(int[] row: board){
		// 	System.out.println(Arrays.toString(row));
		// }

		// Set<Integer> set = new HashSet<>();
		// int xx = 0;
		// for(int i=0; i<n; i++){
		// 	xx = getRandomNumber(set, xx);
		// 	set.add(xx);
		// }
		// System.out.println(set);

		// long start = System.currentTimeMillis();
		// int[][] board = createSudoku();
		// printBoard(board);
		// long end = System.currentTimeMillis();
		// System.out.println("Total time: "+(end-start));

		// System.out.println("\n---------------------------------------------------------");
		// solveSudoku(board);
		
	}

	static int[][] createSudoku(){
		int[][] board = new int[9][9];
		for(int i=0; i<9; i++){
			Set<Integer> row = new HashSet<>();
			int j = 0;
			int digit = 0;
			while(j < 9){
				int count = 0;
				digit = getRandomNumber(digit);
				int[] cordinates = getBoxOriginCoordinate(i, j);
				boolean inTheBox = boxCheck(board, cordinates[0], cordinates[1], digit);
				boolean inTheCol = colCheck(board, j, digit);
				if(!row.contains(digit) && !inTheCol && !inTheBox){
					board[i][j] = digit;
					row.add(digit);
					count = 0;
					j++;
				}else{
					count++;
				}
				if(count == 9){
					row.remove(digit);
					board[i][j] = 0;
					j--;
				}
				printBoard(board);
			}
		}
		return board;
	}

	static int[][] fillDigonalBoxes(int[][] board){
		for(int i=0; i<9; i++){
			Set<Integer> box;
			int k = (i > 5 ? 6: (i > 2) ? 3: 0);
			for(int j=k; j<k+3; j++){
				box = boxCheck(board, k, k);
				int digit = getRandomNumber(box);
				board[i][j] = digit;
			}
		}
		printBoard(board);
		return board;
	}

	static int getRandomNumber(Set<Integer> set){
		int n = (int) (Math.random()*10);
		if(n > 0 && !set.contains(n))
			return n;
		else
			return getRandomNumber(set);
	}

	static int[] getBoxOriginCoordinate(int x, int y){
		int[] ar = new int[2];
		if(y < 3) {
			if(x < 3) {
			} else if(x < 6) {
				ar[0] = 3;
			} else{
				ar[0] = 6;
			}
		} else if(y < 6) {
			ar[1] = 3;
			if(x < 3) {
			} else if(x < 6) {
				ar[0] = 3;
			} else{
				ar[0] = 6;
			}
		} else {
			ar[1] = 6;
			if(x < 3) {
			} else if(x < 6) {
				ar[0] = 3;
			} else{
				ar[0] = 6;
			}
		}
		return ar;
	}

	static int getRandomNumber(int prevNum){
		int n = (int) (Math.random()*10);
		if(n > 0 && n != prevNum)
			return n;
		else
			return getRandomNumber(prevNum);
	}

	static int[][] solveSudoku(int[][] board){
		Set<Integer> box1 = boxCheck(board, 0, 0);
		Set<Integer> row1 = rowCheck(board, 0);
		Set<Integer> col1 = rowCheck(board, 0);
		System.out.println(box1);
		System.out.println(row1);
		System.out.println(col1);
		return board;
	}

	static Set<Integer> boxCheck(int[][] board, int x, int y){
		Set<Integer> set = new HashSet<>();
		for(int i=x; i<x+3; i++){
			for(int j=y; j<y+3; j++){
				set.add(board[i][j]);
			}
		}
		return set;
	}

	static Set<Integer> rowCheck(int[][] board, int x){
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<9; i++){
			set.add(board[x][i]);
		}
		return set;
	}

	static Set<Integer> colCheck(int[][] board, int y){
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<9; i++){
			set.add(board[i][y]);
		}
		return set;
	}

	static void printBoard(int[][] board){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++){
			if(i % 3 == 0 && i != 0)
				sb.append("\n");
			for(int j=0; j<9; j++){
				if(j % 3 == 0 && j != 0)
					sb.append("  ");
				int val = board[i][j];
				sb = (val == 0 ? sb.append(". "): sb.append(val).append(" "));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void printBoard1(int[][] board){
		for(int i=0; i<9; i++){
			if(i % 3 == 0 && i != 0)
				System.out.println();
			for(int j=0; j<9; j++){
				if(j % 3 == 0 && j != 0)
					System.out.print("  ");
				int val = board[i][j];
				System.out.printf("%s", val == 0 ? ". ": (val+" "));
			}
			System.out.println();
		}
		System.out.println();
	}

	static void printBoard2(int[][] board){
		for(int i=0; i<9; i++){
			if(i % 3 == 0 && i != 0)
				System.out.println("-----------------------");
			System.out.print(" ");
			for(int j=0; j<9; j++){
				if(j % 3 == 0 && j != 0)
					System.out.print("| ");
				int val = board[i][j];
				System.out.printf("%s", val == 0 ? ". ": (val+" "));
			}
			System.out.println();
		}
	}

	static boolean boxCheck(int[][] board, int x, int y, int n){
		for(int i=x; i<x+3; i++){
			for(int j=y; j<y+3; j++){
				if(board[i][j] == n)
					return true;
			}
		}
		return false;
	}

	static boolean rowCheck(int[][] board, int x, int n){
		for(int i=0; i<9; i++){
			if(board[x][i] == n)
				return true;
		}
		return false;
	}

	static boolean colCheck(int[][] board, int y, int n){
		for(int i=0; i<9; i++){
			if(board[i][y] == n)
				return true;
		}
		return false;
	}

}