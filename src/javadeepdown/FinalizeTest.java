package javadeepdown;

public class FinalizeTest {

    public static void main(String[] args) {
        String str = new String("jd");
        str = null;
        System.gc();
        System.out.println(str);
    }

    @Override
    public void finalize() {
        System.out.println("Finalize called.");
    }
}

