import java.io.*;
import java.util.*;
public class Main {
    public static StringBuilder sb;
    private long[] seg;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String input=br.readLine();
        sb=new StringBuilder();
        StringBuilder word=new StringBuilder();
        boolean inside=false;
        for (int i=0;i<input.length();i++) {
            char ch=input.charAt(i);
            if (ch=='<') {
                inside=true;
                sb.append(word.reverse().toString());
                word.setLength(0);
                sb.append(ch);
            } else if (ch=='>') {
                sb.append(ch);
                inside=false;
            } else if (inside) {
                sb.append(ch);
            } else {
                if (ch==' ') {
                    sb.append(word.reverse().toString());
                    sb.append(' ');
                    word.setLength(0);
                } else word.append(ch);
            }
        }
        if (word.length()>0) {
            sb.append(word.reverse().toString());
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
