package resources142;

public class NthFib {

	public static void main(String[] args) {
		System.out.println(getNthFib(4));
		System.out.println(getNthFib(6));
		System.out.println(getNthFib(7));
		System.out.println(getNthFib(1));						   
	}
	
	public static int getNthFib(int n) {
		if(n <= 2){
			return n-1;
		}
		int x = 0;
			int y = 1;
			while(n > 2) {
				int temp = y;
				y += x;
				x = temp;
				n--;
			}
		return y;
  	}
}