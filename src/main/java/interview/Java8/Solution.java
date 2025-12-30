import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.peopleAwareOfSecret(6, 2, 4));
        // System.out.println(solution.peopleAwareOfSecret(4, 1, 3));
        System.out.println(solution.peopleAwareOfSecret(904, 63, 102));
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int div = 1000000007;
        List<Temp> tempList = new ArrayList<>();
        int start = 0;
        long totalCount = 1;
        tempList.add(new Temp(1));
        for (int i = 1; i < n; i++) {
            long shareCount = 0;
            for (int j = start; j < tempList.size(); j++) {
                Temp t = tempList.get(j);
                t.delay += 1;
                t.forget += 1;
                if (t.delay >= delay && t.forget < forget) {
                    shareCount = (shareCount + t.personCount) % div;
                }
                if (t.forget >= forget && t.personCount > 0) {
                    totalCount = (totalCount - t.personCount + div) % div;
                    t.personCount = 0;
                }
            }
            if (shareCount > 0) {
                tempList.add(new Temp(shareCount));
                totalCount = (totalCount + shareCount) % div;
            }
        }
        return (int) totalCount % div;
    }

    static class Temp {
        int delay;
        int forget;
        long personCount;

        public Temp(long personCount) {
            this.delay = 0;
            this.forget = 0;
            this.personCount = personCount;
        }
    }

}
