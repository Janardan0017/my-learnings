import java.util.Arrays;

/**
 * Created by emp350 on 3/04/20
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 1, 5, 4};
        Arrays.sort(arr, 0, 3);
        System.out.println(Arrays.toString(arr));
    }

}