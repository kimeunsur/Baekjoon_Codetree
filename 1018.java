import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input=br.readLine().split("\\s+");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        board=new char[n][m];
        for (int i=0;i<n;i++) {
                board[i]=br.readLine().toCharArray();
        }
        bw.write(findMinimumSquare()+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
    private static int findMinimumSquare() {
        int minValue=Integer.MAX_VALUE;
        for (int i=0;i<=n-8;i++) {
            for (int j=0;j<=m-8;j++) {
                minValue=Math.min(minValue,countMinimumSquare(i,j));
            }
        }
        return minValue;
    }
    private static int countMinimumSquare(int startX, int startY) {
        int case1=0;
        int case2=0;
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                char expected1=((i+j)%2==0? 'B':'W');
                char expected2=((i+j)%2==0? 'W':'B');
                if (board[startX+i][startY+j]!=expected1) case1++;
                if (board[startX+i][startY+j]!=expected2) case2++;
            }
        }
        return Math.min(case1,case2);
    }
}

//처음에 어떻게 풀어야 할 지 모르겠었는데, 유형이 브루트포스니까.. 먼저 8x8 사각형을 잡고, 그 사각형 안에서 몇 개를 수정해야 하는지를 카운트했다.
