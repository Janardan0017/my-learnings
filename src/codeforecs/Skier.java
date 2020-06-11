package codeforecs;

import java.util.Scanner;

public class Skier {

	public static void solve(String directions) {
		int res = 5;
		char[] ar = directions.toCharArray();
		int j = 0;
		for(int i=1; i<ar.length; i++){
			if(j >= 0 && isOppositeDir(ar[i], ar[j])){
				ar[i] = 'D';
				ar[j] = 'D';
				j--;
				while(j >= 0 && ar[j] == 'D'){
					j--;
				}
				res += 1;
			}else {
				res += 5;
				j = i;
			}
		}
		System.out.println(res);
	}

	static boolean isOppositeDir(char dir1, char dir2){
		return ((dir1 == 'E' && dir2 == 'W') || (dir2 == 'E' && dir1 == 'W')) ||
			   ((dir1 == 'N' && dir2 == 'S') || (dir1 == 'S' && dir2 == 'N'));
	}

	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine().trim());
		while(t-- > 0){
			String directions = in.nextLine().trim();
			solve(directions);
		}
	}
}