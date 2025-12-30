
import java.util.HashMap;
import java.util.Map;

public class Problem205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "ftt"));
        System.out.println(isIsomorphic("aaaa", "bbbb"));
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);

            Character sVal = map.get(sChar);
            Character tVal = map.get(tChar);
            // we will create one mapping for sChar -> tChar by making sure that 
            // tChar is already not mapped to any other char except sChar
            if(sVal == null) {
                if(tVal != null) {
                    return false;
                } else {
                    map.put(sChar, tChar);
                }
            } else {
                if(tVal == null) {
                    
                }
            }
        }
        return true;
    }
}
