import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++) {
            int n=Integer.parseInt(br.readLine());
            int[][] board=new int[2][n];
            for (int j=0;j<2;j++) {
                String[] input=br.readLine().split(" ");
                for (int k=0;k<n;k++) {
                    board[j][k]=Integer.parseInt(input[k]);
                }
            }
            int result = calMax(board,n);
            sb.append(result+"\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
    private static int calMax(int[][] board,int row) {
        int[][] dp=new int[2][row];
        dp[0][0]=board[0][0]; dp[1][0]=board[1][0];
        if (row>1) {
            dp[0][1]=dp[1][0]+board[0][1];
            dp[1][1]=dp[0][0]+board[1][1];
        }
        for (int i=2;i<row;i++) {
            dp[0][i]=board[0][i]+Math.max(dp[1][i-1],dp[1][i-2]);
            dp[1][i]=board[1][i]+Math.max(dp[0][i-1],dp[0][i-2]);
        }
        return Math.max(dp[0][row-1],dp[1][row-1]);
    }
}
