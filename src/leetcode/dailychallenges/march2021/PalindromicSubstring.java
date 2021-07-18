import java.util.Scanner;

public class PalindromicSubstring {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println(getPalindromicSubstringCount(str));
	}
	
	public static int getPalindromicSubstringCount(String str) {
		if(str == null || str.isEmpty())
			return 0;
		char[] ar = str.toCharArray();
		int count = 0;
		for(int i=0; i<ar.length; i++) {
			for(int j=i; j<ar.length; j++) {
				if(isPalindrome(ar, i, j)) {
					System.out.println(str.substring(i, j+1));
					count++;
				}	   
			}
		}
		return count;
	}
	
	public static boolean isPalindrome(char[] ar, int i, int j) {
		while(j > i) {
			if(ar[i] != ar[j])
				return false;
			i++;
			j--;
		}
		return true;
	}
}