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
        int[] a = new int[n];
        int[] increase = new int[n];
        int[] decrease = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(input[i]);
            increase[i] = 1;
            decrease[i] = 1;
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (a[i] > a[j]) {
                    increase[i] = Math.max(increase[i], increase[j] + 1);
                }
            }
        }

        for (int i=n-2; i>=0; i--) {
            for (int j=i+1; j<n; j++) {
                if (a[i] > a[j]) {
                    decrease[i] = Math.max(decrease[i], decrease[j] + 1);
                }
            }
        }

        int result = increase[0] + decrease[0];
        for (int i=1; i<n; i++) {
            int temp = increase[i] + decrease[i];
            result = Math.max(result, temp);
        }
        result--;
        bw.write(result+"\n");
        br.close();
        bw.close();
    }
}
