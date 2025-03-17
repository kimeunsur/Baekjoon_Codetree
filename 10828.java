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
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<n;i++) {
            String command=br.readLine();
            if (command.startsWith("push")) {
                int x=Integer.parseInt(command.split(" ")[1]);
                stack.push(x);
            } else if (command.equals("pop")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.pop()).append("\n");
                } else sb.append("-1\n");
            } else if (command.equals("size")) {
                sb.append(stack.size()).append("\n");

            } else if (command.equals("empty")) {
                if (stack.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            } 
            else if (command.equals("top")) {
                if (!stack.isEmpty()) sb.append(stack.peek()).append("\n");
                else sb.append("-1\n");
            }

        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}
