import java.io.*;
import java.util.*;
public class Main {
    public static int m,n;
    public static Integer[] board;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        sb=new StringBuilder();
        board=new Integer[n];
        for (int i=0;i<n;i++) {
            board[i]=Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack=new Stack<>();
        int current=1;
        for (int num: board) {
            while (current<=num) {
                stack.push(current);
                current++;
                sb.append("+\n");
            }
            if (!stack.isEmpty() && stack.peek()==num) {
                stack.pop();
                sb.append("-\n");
            } else {
                bw.write("NO\n");
                bw.flush();
                br.close();
                bw.close();
                return;
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
