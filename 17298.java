import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        String[] input=br.readLine().split("\\s+");
        int[] board=new int[a];
        int[] result=new int[a];
        for (int i=0;i<a;i++) board[i]=Integer.parseInt(input[i]);
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<a;i++) {
            while (!stack.isEmpty() && board[stack.peek()]<board[i]) {
                board[stack.pop()]=board[i];
            }
            stack.push(i);
        }
        while (stack.size()>0) {
            board[stack.pop()]=-1;
        }
        for (int i=0;i<a;i++) {
            bw.write(board[i]+" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
