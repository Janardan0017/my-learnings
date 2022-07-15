package leetcode;

public class Problem389 {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "dacbe";
        System.out.println(findTheDifference2(s,t));

    }

    public static char findTheDifference2(String s, String t) {
        for(char c: s.toCharArray()) {
            t = t.replace(c, ' ');
        }
        return t.trim().charAt(0);
    }

    public static char findTheDifference(String s, String t) {
        int x = 0;
        int i = 0;
        for(i=0; i<s.length(); i++) {
            x = x ^ s.charAt(i) ^ t.charAt(i);
        }
        x = x ^ t.charAt(i);
        return (char) x;
    }
}
