package madeeasy.tree;

/**
 * Created for interview-preparation on 5/12/20
 */
public class RecursionTest {

    public static void main(String[] args) {
        printNumbers(10);
    }

    public static void printNumbers(int n) {
        if (n < 1)
            return;
        printNumbers(n - 1);
        System.out.print(n + " ");
    }
}
