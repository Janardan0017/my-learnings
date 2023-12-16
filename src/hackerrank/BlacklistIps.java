package hackerrank;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlacklistIps {

    public static void main(String[] args) {
        List<String> blk_ips = Arrays.asList("*111.*", "123.*", "34.*");
        List<String> requests = Arrays.asList("123.1.23.34", "121.1.23.34", "121.1.23.34",
                "34.1.23.34", "121.1.23.34", "12.1.23.34", "121.1.23.34");
        System.out.println(validateRequests(blk_ips, requests));
    }

    public static List<Integer> validateRequests(List<String> blk_ips, List<String> requests) {
        List<Integer> result = new ArrayList<>();
        List<Pattern> patterns = new ArrayList<>();
        for (String bIp : blk_ips) {
            patterns.add(Pattern.compile(bIp.replace("*", ".*")));
        }
        LinkedList<String> last5Requests = new LinkedList<>();
        for (String request : requests) {
            if (last5Requests.size() > 5) {
                last5Requests.removeFirst();
            }
            last5Requests.add(request);
            for (Pattern pattern : patterns) {
                Matcher matcher = pattern.matcher(request);
                if (matcher.matches() || last5Requests.contains(request)) {
                    result.add(0);
                } else {
                    result.add(1);
                }
            }
        }
        return result;
    }

}
