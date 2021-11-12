public class March21 {

    public static void main(String[] args) {
        for (int i = 1; i <= 1000000000; i++)
            System.out.println(i + " " + isPowerOf2(i));
    }

    public static boolean isPowerOf2(int n) {
        int x = 1;
        while (x < n) {
            x *= 2;
        }
        return x == n;
    }
}