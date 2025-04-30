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
        int[] notDelete = new int[n];
        int[] delete = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        notDelete[0] = a[0];
        delete[0] = -1000;
        for (int i=1; i<n; i++) {
            notDelete[i] = Math.max(a[i], notDelete[i-1] + a[i]);
            delete[i] = Math.max(notDelete[i-1], delete[i-1] + a[i]);
        }

        int result = notDelete[0];
        for (int i=0; i<n; i++) {
            result = Math.max(result, Math.max(notDelete[i], delete[i]));
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
