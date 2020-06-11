package algorithm;

import java.util.Scanner;

public class Power {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter value of a and n to get a^n");
		long a = in.nextLong();
		long n = in.nextLong();

		long startTime = System.currentTimeMillis();
		long result = getPower1(a, n);
		long endTime = System.currentTimeMillis();
		System.out.println(result +" and time taken: "+(endTime-startTime));

		startTime = System.currentTimeMillis();
		result = getPower2(a, n);
		endTime = System.currentTimeMillis();
		System.out.println(result +" and time taken: "+(endTime-startTime));

	}

	static long getPower1(long a, long n){
		long result = 1L;
		while(n-- > 0){
			result *= a;
		}
		return result;
	}

	static long getPower2(long a, long n){
		if(n == 0)
			return 1L;
		long x = getPower2(a, n / 2);
		if(n % 2 == 0)
			return x * x;
		else
			return x * x * a;
	}
}