package codeforecs;

import java.util.Scanner;

public class SumOfRoundNumbers {

	public static void solve(int n){
		StringBuilder res = new StringBuilder();
		int placeValue = 1;
		int count = 0;
		while(n > 0){
			int x = n % 10;
			if(x != 0){
				count++;
				res.append(x*placeValue).append(" ");
			}
			placeValue *= 10;
			n /= 10;
		}
		System.out.println(count);
		System.out.println(res.toString().trim());
	}

	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0){
			int n = in.nextInt();
			solve(n);
		}
	}
}