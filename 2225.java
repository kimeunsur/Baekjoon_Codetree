import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
    static int n,k;
    static final int MOD=1_000_000_000;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();
        String[] input=br.readLine().split(" ");
        n=Integer.parseInt(input[0]);
        k=Integer.parseInt(input[1]);
        int[][] dp=new int[n+1][k+1];
        for (int i=0;i<=k;i++) {
            dp[0][i]=1;
        }
        for (int i=1;i<=n;i++) {
            dp[i][1]=1;
            for (int j=2;j<=k;j++) {
                for (int x=0;x<=i;x++) {
                    dp[i][j]+=dp[i-x][j-1];
                    dp[i][j]%=MOD;
                }
            }
        }
        bw.write(dp[n][k]+"\n");
        br.close();
        bw.close();
    }
}
