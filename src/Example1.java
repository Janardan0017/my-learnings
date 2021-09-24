import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example1 {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("Janardan");
//        list.add("Sanardan");
//        list.add("kSanardan");
//        list.add("sdfdardan");
//        list.add("SSSSanardan");
//
//        List<String> result = list.stream().filter(x -> String.valueOf(x.charAt(0)).equalsIgnoreCase("s")).collect(Collectors.toList());
//        System.out.println(result);

        System.out.println(isPalindrome("afasfsd"));
        System.out.println(isPalindrome("aaaaa"));
        System.out.println(isPalindrome("asdfdsa"));
        System.out.println(isPalindrome("aaabbbaaa"));
    }

    public static boolean isPalindrome(String s) {
        char[] ar = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(ar[i] != ar[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
