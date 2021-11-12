import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1079 {

    public static List<String> solve(String s, int i, List<String> result) {
        while (i < s.length() && s.charAt(i) >= 48 && s.charAt(i) <= 57) {
            i++;
        }
        if (i == s.length()) {
            result.add(s);
            return result;
        }
        s = s.substring(0, i) + s.substring(i, i + 1).toUpperCase() + s.substring(i + 1);
        solve(s, i + 1, result);
        s = s.substring(0, i) + s.substring(i, i + 1).toLowerCase() + s.substring(i + 1);
        solve(s, i + 1, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<String> result = solve(s, 0, new ArrayList<>());
        System.out.println(result);
    }
}