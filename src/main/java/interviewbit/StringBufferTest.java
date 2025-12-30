package interviewbit;

public class StringBufferTest {

    public static void main(String[] args) {
        String s = "asdfgh";
        StringBuffer sb = new StringBuffer(s);
        StringBuffer sb1 = new StringBuffer(s.subSequence(2, 5));
        sb.replace(2, 5, sb1.reverse().toString());
        System.out.println(sb);
    }
}
