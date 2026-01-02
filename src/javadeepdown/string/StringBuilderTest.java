package javadeepdown.string;

public class StringBuilderTest {

    public static void main(String[] args) {
        String s = "sygfhdsjkfadskfhdsklajfhklasdf";
        System.out.println(s.length());
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.capacity());
    }
}
