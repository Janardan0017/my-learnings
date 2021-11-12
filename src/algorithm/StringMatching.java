package algorithm;

public class StringMatching {

    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        String match = "klmn";

        System.out.println(getMatchingIndex(str, match));
    }

    public static int getMatchingIndex(String str, String match) {
        int i = 0;
        int j = 0;
        while (i < str.length()) {
            if (str.charAt(i) == match.charAt(j)) {
                j++;
                if (j == match.length())
                    return i;
            } else {
                j = 0;
            }
            i++;
        }
        return -1;
    }
}