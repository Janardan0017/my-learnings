package companies.paytm;

public class RotatedArray {

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5, 6};
        int i = 2000;
        int k;
        while (i-- > 0) {
            k = (int) (Math.random() * 1000);
            System.out.print(ar[k % 6]);
            if (i % k == 0)
                System.out.println();
        }
    }
}
