package javadeepdown;

public class TryCatchTest {

    public static void main(String[] args) {
        try {
//            int x = 5 / 0;
            int[] ar = new int[1];
            ar[1] = 1;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Inside exception");
            e.printStackTrace();
        } finally {
            System.exit(1);
            System.out.println("Inside finally");
        }

        try {
            int x = 10 / 0;
        } finally {
            System.out.println("Inside finally 2");
        }
    }
}
