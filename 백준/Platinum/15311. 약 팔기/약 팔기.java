public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(1999).append("\n");
        for (int i = 0; i < 999; i++) {
            sb.append(1).append(" ");
        }
        for (int i = 0; i < 1000; i++) {
            sb.append(1000).append(" ");
        }
        System.out.println(sb);
    }
}