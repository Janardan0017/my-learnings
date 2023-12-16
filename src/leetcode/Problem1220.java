package leetcode;

public class Problem1220 {

    public static void main(String[] args) {
        System.out.println(countVowelPermutation(1));
        System.out.println(countVowelPermutation(2));
        System.out.println(countVowelPermutation(3));
        System.out.println(countVowelPermutation(4));
        System.out.println(countVowelPermutation(5));
        System.out.println(countVowelPermutation(6));
        System.out.println(countVowelPermutation(7));
        System.out.println(countVowelPermutation(8));
        System.out.println(countVowelPermutation(9));
        System.out.println(countVowelPermutation(10));
        System.out.println(countVowelPermutation(11));
        System.out.println(countVowelPermutation(12));
        System.out.println(countVowelPermutation(13));
    }

    public static int countVowelPermutation2(int n) {
        long pow4 = (long) n * n * n * n;
        long pow3 = (long) n * n * n;
        long pow2 = (long) n * n;
        long result = (-pow3 + pow2 - 5 * (long) n - 5) / (pow4 - pow3 + 2 * pow2 + (long) n - 1);
        return (int) (result % 1000000007);
    }

    public static int countVowelPermutation(int n) {
        long[] arr = {1, 1, 1, 1, 1};
        int modulo = (int) (1e9+7);
        while (n > 1) {
            long[] temp = new long[5];
            temp[0] = arr[1] % modulo;
            temp[1] = (arr[0] + arr[2]) % modulo;
            temp[2] = (arr[0] + arr[1] + arr[3] + arr[4]) % modulo;
            temp[3] = (arr[2] + arr[4]) % modulo;
            temp[4] = arr[0] % modulo;
            arr = temp;
            n--;
        }
        long result = 0;
        for (long val : arr) {
            result = (result + val) % modulo;
        }
        return (int) result % modulo;
    }
}

//    Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
//    Each vowel 'a' may only be followed by an 'e'.
//    Each vowel 'e' may only be followed by an 'a' or an 'i'.
//    Each vowel 'i' may not be followed by another 'i'.
//    Each vowel 'o' may only be followed by an 'i' or a 'u'.
//    Each vowel 'u' may only be followed by an 'a'.