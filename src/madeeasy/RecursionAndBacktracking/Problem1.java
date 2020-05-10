import java.util.Scanner;

public class Problem1 {

	static void solve(int n, char fromPeg, char toPeg, char auxPeg){
		if(n == 1){
			System.out.println("Move disk from peg " + fromPeg + " to peg " + toPeg);
			return;
		}
		// move n-1 disks from A to B, using C as auxilary
		solve(n-1, fromPeg, auxPeg, toPeg);
		// move remaining disks from A to C
		System.out.println("Move disk from peg " + fromPeg + " to peg " + toPeg);
		// move n-1 disks from B to C using A as auxilary
		solve(n-1, auxPeg, toPeg, fromPeg);
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		solve(n, 'A', 'B', 'C');
	}
}