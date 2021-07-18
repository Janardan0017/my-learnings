import java.util.Scanner;
import java.util.Stack;

public class Feb20 {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println(isValid(str));
		
	}
	
	public static boolean isValid(String str) {
		if(str == null || str.isEmpty())
			return true;
		char[] chars = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		for(char c: chars) {
			if(c == ')' || c == '(') {
				if(stack.empty() || stack.peek() == c) {
					stack.push(c);
				} else {
					stack.pop();
				}
			}
		 }
	   return stack.empty();	
	}
}