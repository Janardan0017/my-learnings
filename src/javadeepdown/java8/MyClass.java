package javadeepdown.java8;

public class MyClass extends Abstract1 implements Interface1, Interface2{

    public MyClass(int id, String name, String phone) {
        super(id, name, phone);
    }

    @Override
    public int method1() {
        return 1;
    }

    @Override
    public void log(String str) {

    }

    public int sum(int a, int b) {
        return a + b;
    }
}
