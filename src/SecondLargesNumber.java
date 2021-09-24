public class SecondLargesNumber {

    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5};
        System.out.println(getSecondLarges(ar));

    }

    public static int getSecondLarges(int[] ar) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int x: ar) {
            if(x > first) {
                if(first > second) {
                    second = first;
                }
                first = x;
            } else if(x > second) {
                second = x;
            }
        }
        return second;
    }
}
