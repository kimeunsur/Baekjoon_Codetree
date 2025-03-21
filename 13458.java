import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] classes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        String[] input=br.readLine().split("\\s+");
        classes=new int[n];
        for (int i=0;i<n;i++) classes[i]=Integer.parseInt(input[i]);
        input=br.readLine().split("\\s+");
        int b=Integer.parseInt(input[0]);
        int c=Integer.parseInt(input[1]);
        long answer=0;
        for (int i=0;i<n;i++) {
            answer++;
            int stu=classes[i]-b;
            if (stu>0) {
                answer+=(stu+c-1)/c;
            } 
        }
        bw.write(answer+"\n");
        bw.close();
        br.close();

    }
}
