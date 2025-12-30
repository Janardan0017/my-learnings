package algorithm;

/**
 * Created for interview-preparation on 4/12/20
 * <p>
 * PROBLEM:
 * check if a string can be converted to a palindrome by removing only 1 or 2 characters
 */
public class MakingPalindrome {

    public static void main(String[] args) {
        System.out.println(makePalindrome("abjchba"));
        System.out.println(makePalindrome("abcdda"));
        System.out.println(makePalindrome("abcbaaa"));
        System.out.println(makePalindrome("allallaa"));
        System.out.println(makePalindrome("asdfda"));
    }

    //    a b c c d a
    public static String makePalindrome(String str) {
        // check if given string is already a palindrome
        char[] arr = str.toCharArray();
        int count = 0;
        int i = 0;
        int j = arr.length - 1;
        while (i < j && arr[i] == arr[j]) {
            i++;
            j--;
        }
        return "Not Possible";
    }


    public static boolean isPalindrome(char[] arr, int i, int j) {
        while (i < j) {
            if (arr[i] != arr[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

}
