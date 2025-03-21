import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] sche;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        sche=new int[n+1][n+1];
        for (int i=1;i<=n;i++) {
            String[] line=br.readLine().split("\\s+");
            sche[i][0]=Integer.parseInt(line[0]);
            sche[i][1]=Integer.parseInt(line[1]);
        }
        int[] dp=new int[n+2];
        for (int i=1;i<=n;i++) {
            int t=sche[i][0];
            int p=sche[i][1];
            dp[i]=Math.max(dp[i],dp[i-1]);
            if (i+t-1<=n) dp[i+t]=Math.max(dp[i]+p,dp[i+t]);
        }
        int maxValue=Integer.MIN_VALUE;
        for (int i=1;i<=n+1;i++) {
            maxValue=Math.max(maxValue,dp[i]);
        }
        bw.write(maxValue+"\n");
        bw.close();
        br.close();

    }
}
