import java.io.*;
import java.util.*;
public class Main {
    public static int[] bags;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        bw.write(minBags(n)+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
    private static int minBags (int n) {
        bags=new int[n+1];
        final int INF=6000;
        for (int i=0;i<=n;i++) bags[i]=INF;
        if (n>=3) bags[3]=1;
        if (n>=5) bags[5]=1;

        for (int i=6;i<=n;i++) {
            if (bags[i-3]!=INF) bags[i]=bags[i-3]+1;
            if (bags[i-5]!=INF) bags[i]=bags[i-5]+1;
        }
        return bags[n]==INF ? -1:bags[n];
    }
}
//브루트포스 만만하게 봤다가 데여버림,,,
