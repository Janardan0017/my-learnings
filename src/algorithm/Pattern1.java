package algorithm;

public class Pattern1 {
    public static void main(String[] args) {
        int n = 6;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb = j < i ? sb.append("  ") : sb.append("* ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        System.out.println();
    }
}