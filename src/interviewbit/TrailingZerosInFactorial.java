package interviewbit;

public class TrailingZerosInFactorial {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(9247));
    }

    public static int trailingZeroes(int A) {
        int res = 0;
        for(int i=5; i<=A; i+=5) {
            if(i%10 == 0) {
                int x = i;
                while(x%10 == 0) {
                    res++;
                    x /= 10;
                }
            } else {
                res++;
            }
        }
        return res;
    }
}
