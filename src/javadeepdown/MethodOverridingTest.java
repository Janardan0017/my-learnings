package javadeepdown;

public class MethodOverridingTest {


}

class Parent {

    protected int sum(int a, int b) {
        return a + b;
    }

    protected long sum(long a, long b) {
        return a + b;
    }

    protected String sum(String a, String b) {
        return a + b;
    }
}

class Child extends Parent {

    @Override
    protected int sum(int a, int b) {
        return a + b;
    }

    @Override
    public long sum(long a, long b) {
        return a + b;
    }

    @Override
    public String sum(String a, String b) {
        return a + b;
    }

}
