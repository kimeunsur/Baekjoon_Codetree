import java.io.*;
import java.util.*;
public class Main {
    static final int MAX=1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        String[] input=br.readLine().split("\\s+");
        int[] count=new int[MAX];
        int[] board=new int[a];
        int[] answer=new int[a];
        for (int i=0;i<a;i++) {
            board[i]=Integer.parseInt(input[i]);
            count[board[i]]++;
        }
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<a;i++) {
            while (!stack.isEmpty() && count[stack.peek()]<count[board[i]]) {
                answer[stack.pop()]=board[i];
            }
            stack.push(i);
        }
        while (stack.size()>0) answer[stack.pop()]=-1;
        for (int i=0;i<a;i++) bw.write(answer[i]+" ");
        bw.flush();
        br.close();
        bw.close();
    }
}
//처음에 hashmap을 이용해서 문제를 풀었는데, 구글링 해보니까 int[] count=new int[MAX];를 하면 되네...
