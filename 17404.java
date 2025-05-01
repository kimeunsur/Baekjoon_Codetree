import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
    static int n;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][3];
        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<3; j++) {
                rgb[i][j] = Integer.parseInt(input[j]);
            }
        }
        int result = DP(rgb);
        bw.write(result+"\n");
        br.close();
        bw.close();
    }
    private static int DP(int[][] rgb) {
        int INF = 1000;
        int result = Integer.MAX_VALUE;
        for (int first=0; first<3; first++) {
            int[][] dp = new int[n][3];
            for (int i=0; i<3; i++) {
                if (i == first) dp[0][i] = rgb[0][i];
                else dp[0][i] = INF;
            }
            for (int i=1; i<n; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
            }
            for (int last=0; last<3; last++) {
                if (last == first) continue;
                else {
                    result = Math.min(result, dp[n-1][last]);
                }
            }
        }
        return result;
    }
}
