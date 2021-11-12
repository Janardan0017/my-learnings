package javadeepdown;

public class MethodOverloadingTest {

    public static void main(String[] args) {
        MethodOverloading methodOverloading = new MethodOverloading();
        System.out.println(methodOverloading.sum(1, 2));
        System.out.println(methodOverloading.sum(1L, 2L));
        ;
        System.out.println(methodOverloading.sum("Janardan ", "chaudhary"));
        ;
    }
}

class MethodOverloading {

    public int sum(int a, int b) {
        return a + b;
    }

    public long sum(long a, long b) {
        return a + b;
    }

    public String sum(String a, String b) {
        return a + b;
    }
}
