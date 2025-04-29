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
        int[] list = new int[n];
        int[] dp = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            list[i] = Integer.parseInt(input[i]);
            dp[i] = list[i];
        }
        
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (list[j] < list[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + list[i]);
                }
            }
        }


        int result = dp[0];
        for (int i=0; i<n; i++) {
            result = Math.max(result, dp[i]);
        }
        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
