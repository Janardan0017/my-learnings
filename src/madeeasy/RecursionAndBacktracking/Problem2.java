import java.util.Scanner;

public class Problem2 {

	static boolean solve(int[] A, int i){
		if(A.length == 1 || i == 1){
			return true;
		}
		return (A[i - 1] >= A[i - 2] && solve(A, i - 1));
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter space saperated array values..");
		String s = in.nextLine();
		String[] ar = s.split(" ");
		int[] A = new int[ar.length];
		for(int i=0; i<ar.length; i++){
			A[i] = Integer.parseInt(ar[i]);
		}
		System.out.println(solve(A, A.length));
	}
}