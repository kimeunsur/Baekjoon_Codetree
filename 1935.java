import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] num;
    static double[] values;
    static String word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        word=br.readLine();
        values=new double[n];
        for (int i=0;i<n;i++) values[i]=Double.parseDouble(br.readLine());
        Stack<Double> stack=new Stack<>();
        for (int i=0;i<word.length();i++) {
            char ch=word.charAt(i);
            if (Character.isUpperCase(ch)) {
                stack.push(values[ch-'A']);
            } else {
                double b=stack.pop();
                double a=stack.pop();
                switch (ch) {
                    case '+': stack.push(a+b); break;
                    case '-': stack.push(a-b); break;
                    case '*': stack.push(a*b); break;
                    case '/': stack.push(a/b); break;
                }
            }
        }
        bw.write(String.format("%.2f\n", stack.pop()));
        bw.close();
        br.close();

    }

}
