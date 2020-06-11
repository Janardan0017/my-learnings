package codeforecs;

import java.util.Scanner;
import java.math.BigInteger;

//https://codeforces.com/problemset/problem/1353/C
public class BoardMoves {

	public static void solve(int n){
		int x = n / 2;
		BigInteger a = BigInteger.valueOf(n).multiply(BigInteger.valueOf(4*x)).multiply(BigInteger.valueOf(x+1));
		a = a.divide(BigInteger.valueOf(3));
		System.out.println(a);
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