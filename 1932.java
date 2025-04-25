import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] board=new int[n+1][n+1];
        for (int i=1;i<=n;i++) {
            String[] input=br.readLine().split(" ");
            int s=input.length;
            for (int j=0;j<s;j++) {
                board[i][j]=Integer.parseInt(input[j]);
            }
        }
        int[][] dp=new int[n+1][n+1];
        dp[1][0]=board[1][0];
        for (int i=2;i<=n;i++) {
            dp[i][0]=dp[i-1][0]+board[i][0];
            dp[i][i-1]=dp[i-1][i-2]+board[i][i-1];
            for (int j=1;j<i-1;j++) {
                dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+board[i][j];
            }
        }
        int result=dp[n][0];
        for (int i=1;i<=n;i++) {
            result=Math.max(result,dp[n][i]);
        }
        bw.write(result+"\n");
        br.close();
        bw.close();
    }
}
