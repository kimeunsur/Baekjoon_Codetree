import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        int[] dp=new int[11];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for (int i=4;i<=10;i++) {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        for (int i=0;i<t;i++) {
            int c=Integer.parseInt(br.readLine());
            sb.append(dp[c]+"\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}
