import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word=br.readLine();
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for (int i=0; i<word.length();i++) {
            char ch=word.charAt(i);
            if (Character.isUpperCase(ch)) {
                sb.append(ch);
            } else {
                if (ch=='(') {
                    stack.push(ch);
                } else if (ch==')') {
                    while (!stack.isEmpty() && stack.peek()!='(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && check(stack.peek())>=check(ch)) {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        bw.write(sb.toString()+"\n");
        bw.close();
        br.close();

    }
    private static int check (Character op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
        }
        return 0;
    }
}
