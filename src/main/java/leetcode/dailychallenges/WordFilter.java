import java.util.HashMap;
import java.util.Map;

public class WordFilter {

    public Map<String, Integer> map;

    public static void main(String[] args) {
        //String[] words = {"apple", "banana", "mango"};
        String[] words = {"cabaabaaaa", "ccbcababac", "bacaabccba", "bcbbcbacaa", "abcaccbcaa",
                "accabaccaa", "cabcbbbcca", "ababccabcb", "caccbbcbab", "bccbacbcba"};
        WordFilter wf = new WordFilter(words);
        System.out.println(wf.f("a", "aa"));
        System.out.println(wf.f("ap", "e"));
        System.out.println(wf.f("app", "e"));
        System.out.println(wf.f("ba", "a"));
        System.out.println(wf.f("m", "e"));
    }

    public WordFilter(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
    }

    public int f(String prefix, String suffix) {
        int index = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            if (word.startsWith(prefix) && word.endsWith(suffix)) {
                index = Math.max(index, entry.getValue());
            }
        }
        return index;
    }
}