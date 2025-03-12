import java.io.*;
import java.util.*;
public class Main {
    static final long MAX_VALUE=1_000_000_000L;
    static int n,k;
    static int[][] grid;
    static int[][] prefixSum, zeroPrefixSum;
    static Integer[] d; 
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        n=Integer.parseInt(br.readLine());
        grid=new int[n][n];
        prefixSum=new int[n+1][n+1];
        zeroPrefixSum=new int[n+1][n+1];
        for (int i=0;i<n;i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) {
                grid[i][j]=Integer.parseInt(st.nextToken());
            } 
        }
        k=Integer.parseInt(br.readLine());
        d=new Integer[k];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i=0;i<k;i++) {
            d[i]=Integer.parseInt(st.nextToken());
        }
        bw.write(maxLandValue()+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
    static void computePrefixSum() {
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                prefixSum[i][j]=grid[i-1][j-1]+prefixSum[i-1][j]+prefixSum[i][j-1]-prefixSum[i-1][j-1];
                zeroPrefixSum[i][j]=(grid[i-1][j-1]==0?1:0)+zeroPrefixSum[i-1][j]+zeroPrefixSum[i][j-1]-zeroPrefixSum[i-1][j-1];
            }
        }
    }
    static int getSquareSum(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2]-prefixSum[x1-1][y2]-prefixSum[x2][y1-1]+prefixSum[x1-1][y1-1];
    }
    static int getZeroSum(int x1, int y1, int x2, int y2) {
        return zeroPrefixSum[x2][y2]-zeroPrefixSum[x1-1][y2]-zeroPrefixSum[x2][y1-1]+zeroPrefixSum[x1-1][y1-1];
    }
    static int maxLandValue() {
        computePrefixSum();
        Arrays.sort(d, Collections.reverseOrder());
        int maxValue=0;
        for (int size=1;size<=n;size++) {
            for (int i=0;i+size-1<n;i++) {
                for (int j=0;j+size-1<n;j++) {
                    int x1=i+1, y1=j+1, x2=i+size, y2=j+size;
                    int totalValue=getSquareSum(x1, y1, x2, y2);
                    int zeroCount=getZeroSum(x1, y1, x2, y2);
                    if (zeroCount>k || zeroCount==0) continue;
                    for (int idx=0;idx<Math.min(zeroCount,k);idx++) totalValue+=d[k-1-idx];
                    maxValue=Math.max(maxValue,totalValue);
                }
            }
        }
        return maxValue;
    }
}

#정답 아님.. 근데 어디서 틀린건지를 모르겠음.. 뉴삥 문제라 벨로그도 없음ㅜ
#지피티와 함께 해결한 뒤에 고치러 다시 오겠뜸...
