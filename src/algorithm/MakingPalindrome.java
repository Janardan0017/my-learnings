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

    public static String makePalindrome(String str) {
        // check if given string is already a palindrome
        if (isPalindrome(str))
            return "Palindrome";
        String longestPalindrome = "";
        for (int i = 0; i < str.length(); i++) {
            String temp = str.replace(str.charAt(i), '\0');
            if(isPalindrome(temp)){

            }
        }
        return "Not Possible";
    }


    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
