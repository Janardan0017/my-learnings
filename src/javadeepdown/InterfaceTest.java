package javadeepdown;

public interface InterfaceTest {

    int num1 = 1;
    int num2 = 2;
    String name = "jd";

    default int sum() {
        return num1 + num2;
    }

    static int multiply() {
        return num1 * num2;
    }

    static void main(String[] args) {
        System.out.println(factorial(5));
        InterfaceTest2.main(new String[]{"Hi"});
    }

    static int factorial(int n) {
        if (n <= 1)
            return 1;
        else return n * factorial(n - 1);
    }
}
