package javadeepdown;

public class InterfaceTest2 implements InterfaceTest {

    public InterfaceTest2() {
        InterfaceTest.super.sum();
        InterfaceTest.multiply();
    }

    @Override
    public int sum() {
        return InterfaceTest.num1 + InterfaceTest.num2 + 10;
    }

    public static void main(String[] args) {
        InterfaceTest interfaceTest = new InterfaceTest2();
        System.out.println(interfaceTest.sum());
        System.out.println(InterfaceTest.multiply());
        System.out.println(interfaceTest.sum());
    }
}
