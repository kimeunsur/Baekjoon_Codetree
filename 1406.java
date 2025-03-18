import java.io.*;
import java.util.*;
public class Main {
    public static int m,n;
    public static Integer[] board;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        sb=new StringBuilder();
        String word=br.readLine(); 
        n=Integer.parseInt(br.readLine());        
        Stack<Character> left=new Stack<>();
        Stack<Character> right=new Stack<>();
        for (int i=0;i<word.length();i++) {
            left.add(word.charAt(i));
        }
        for (int i=0;i<n;i++) {
            word=br.readLine();
            char ch=word.charAt(0);
            if (ch=='L') {
                if (!left.isEmpty()) {
                    char move=left.pop();
                    right.push(move);
                }
            } else if (ch=='D') {
                if (!right.isEmpty()) {
                    char move=right.pop();
                    left.push(move);
                }
            } else if (ch=='B') {
                if (!left.isEmpty()) left.pop();
            } else if (ch=='P') {
                char x=word.charAt(2);
                left.push(x);
            }
        }
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
