import java.io.*;
import java.util.*;
public class Main {
    public static int m,n;
    public static Integer[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for (int i=0;i<n;i++) {
            String s=br.readLine();
            if (isVPS(s)) sb.append("YES\n");
            else sb.append("NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    private static boolean isVPS(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if (ch=='(') {
                stack.push(ch);
            } else if (ch==')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
