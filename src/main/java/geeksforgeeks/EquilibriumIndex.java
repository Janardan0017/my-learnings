package geeksforgeeks;

/**
 * Created for interview-preperation on 24/11/20
 */
public class EquilibriumIndex {

    public static int getEquilibriumIndex(int[] ar) {
        int n = ar.length;
        int i = 0;
        int j = n - 1;
        int leftSum = 0;
        int rightSum = 0;
        while (i < j) {
            if (leftSum > rightSum) {
                rightSum += ar[j];
                j--;
            } else {
                leftSum += ar[i];
                i++;
            }
        }
        return leftSum == rightSum ? i : -1;
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(getEquilibriumIndex(ar));
    }
}
