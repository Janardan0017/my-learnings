package hackerrank;

public class ShortPalindrome {

    public static void main(String[] args) {
        System.out.println(solve("assa"));
    }

    public static int solve(String s) {
        char[] ar = s.toCharArray();
        int[] indices = new int[4];
        int count = 0;
        for (int i = 0; i < Math.pow(2, ar.length); i++) {
            int j = 3;
            int x = i;
            int k = ar.length - 1;
            while (x > 0) {
                if (x % 2 != 0) {
                    if (j >= 0) {
                        indices[j] = k;
                    }
                    j--;
                }
                k--;
                x /= 2;
            }
            if (j == 0 && indices[0] == indices[3] && indices[1] == indices[2]) {
                count++;
            }
            count = count % 1000000007;
        }
        return count;
    }
}
