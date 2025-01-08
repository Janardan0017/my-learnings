package algorithm;

public class Pattern1 {
    public static void main(String[] args) {
        int n = 12;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(j < i ? "  " : "* ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        System.out.println();
    }
}