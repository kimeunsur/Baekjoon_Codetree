import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        int[] list=new int[n];
        int[] dp=new int[n];
        List<List<Integer>> stores=new ArrayList<>();

        String[] input=br.readLine().split(" ");
        for (int i=0;i<n;i++) {
            list[i]=Integer.parseInt(input[i]);
            dp[i]=1;

            List<Integer> temp=new ArrayList<>();
            temp.add(list[i]);
            stores.add(temp);
        }
        
        for (int i=0;i<n;i++) {
            for (int j=0;j<i;j++) {
                if (list[j]<list[i] && dp[j]+1>dp[i]) {
                    List<Integer> temp=new ArrayList<>(stores.get((j)));
                    temp.add(list[i]);
                    stores.set(i,temp);
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max=-1;
        List<Integer> maxList=new ArrayList<>();
        for (int i=0;i<n;i++) {
            if (dp[i]>max) {
                max=dp[i];
                maxList=stores.get(i);
            }
        }
        for (int i=0;i<maxList.size();i++) {
            sb.append(maxList.get(i)+" ");
        }
        bw.write(max+"\n");
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
