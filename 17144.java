import java.util.*;
import java.io.*;
public class Main {
    static int r,c,t,time;
    static int[][] board;
    static int min=Integer.MAX_VALUE;
    static List<int[]> vacuum=new ArrayList<>();
    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input=br.readLine().split(" ");
        r=Integer.parseInt(input[0]);
        c=Integer.parseInt(input[1]);
        t=Integer.parseInt(input[2]);
        board=new int[r][c];
        for (int i=0;i<r;i++) {
            input=br.readLine().split(" ");
            for (int j=0;j<c;j++) {
                board[i][j]=Integer.parseInt(input[j]);
                if (board[i][j]==-1) {
                    vacuum.add(new int[] {i,j});
                }
            }
        }
        simulate();
        int result=0;
        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                if (board[i][j]!=-1) {
                    result+=board[i][j];
                }
            }
        }
        bw.write(result+"\n");
        br.close();
        bw.close();
    }
    private static void simulate() {
        time=0;
        while (true) {
            time++;
            if (time>t) break;
            dust();
            vacuumClean();
        }
    }
    private static void dust() {
        int[] dx=new int[] {-1,1,0,0};
        int[] dy=new int[] {0,0,-1,1};
        int[][] newMap=new int[r][c];
        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                int x=i;
                int y=j;
                int count=0;
                int spread=(int) board[x][y]/5;
                for (int k=0;k<4;k++) {
                    int curX=x; 
                    int curY=y;
                    curX+=dx[k];
                    curY+=dy[k];
                    if (curX>=0&&curY>=0&&curX<r&&curY<c&&board[curX][curY]!=-1) {
                        newMap[curX][curY]+=spread;
                        count++;
                    }
                }
                int main=board[x][y]-spread*count;
                newMap[x][y]+=main;
            }
        }
        for (int[] v:vacuum) {
            newMap[v[0]][v[1]]=-1;
        }
        board=newMap;
    }
    private static void vacuumClean() {
        int top=vacuum.get(0)[0];
        int bottom=vacuum.get(1)[0];
        //위쪽
        for (int i=top-1;i>0;i--) board[i][0]=board[i-1][0];
        for (int i=0;i<c-1;i++) board[0][i]=board[0][i+1];
        for (int i=0;i<top;i++) board[i][c-1]=board[i+1][c-1];
        for (int i=c-1;i>1;i--) board[top][i]=board[top][i-1];
        board[top][1]=0;
        //아래쪽
        for (int i=bottom;i<r-1;i++) board[i][0]=board[i+1][0];
        for (int i=0;i<c-1;i++) board[r-1][i]=board[r-1][i+1];
        for (int i=r-1;i>bottom;i--) board[i][c-1]=board[i-1][c-1];
        for (int i=c-1;i>1;i--) board[bottom][i]=board[bottom][i-1];
        board[bottom][1]=0;
    }
}
