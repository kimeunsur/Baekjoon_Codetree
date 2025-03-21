import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int answer=0;
        Stack<Character> stack=new Stack<>();
        String word=br.readLine();
        for (int i=0;i<word.length();i++) {
            char ch=word.charAt(i);
            if (ch=='(') {
                stack.push('(');
            } else {
                stack.pop();
                if (word.charAt(i-1)=='(') {
                    answer+=stack.size();
                } else answer++;
            } 
        }
        bw.write(answer+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
