/**
 * Created by emp350 on 3/04/20
 */
public class Test {
	static double sqrt_5 = Math.sqrt(5);
	static double x = 1 + sqrt_5;
	static double y = 1 - sqrt_5;
    public static void main(String[] args) {
        for(int i=0; i<25; i++){
        	double fib_i = (Math.pow(x, i) - Math.pow(y, i))/(sqrt_5*Math.pow(2,i));
        	System.out.println((int)fib_i);
        }
    }
}