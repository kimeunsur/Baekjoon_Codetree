import java.util.*;
import java.io.*;
public class Main {
    static int[][] board;
    static int n,m,r,c,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input=br.readLine().split(" ");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        board=new int[n][m];
        input=br.readLine().split(" ");
        r=Integer.parseInt(input[0]);
        c=Integer.parseInt(input[1]);
        d=Integer.parseInt(input[2]);
        for (int i=0;i<n;i++) {
            input=br.readLine().split("\\s+");
            for (int j=0;j<input.length;j++) {
                board[i][j]=Integer.parseInt(input[j]);
            }
        }
        bw.write(simulate()+"\n");
        br.close();
        bw.close();
    }
    private static int simulate() {
        int nx=r; int ny=c;
        int[] dx={-1,0,1,0}; //북 동 남 서
        int[] dy={0,1,0,-1};
        int dir=d;
        int count=0;
        while (true) {
            if (board[nx][ny]==0) {
                board[nx][ny]=2;
                count++;
            }
            boolean moved=false;
            int tempDir=dir;
            for (int i=0;i<4;i++) {
                tempDir=(tempDir+3)%4;
                int nextX=nx+dx[tempDir];
                int nextY=ny+dy[tempDir];
                if (nextX>=0&&nextY>=0&&nextX<n&&nextY<m&&board[nextX][nextY]==0) {
                    nx=nextX; ny=nextY;
                    dir=tempDir;
                    moved=true;
                    break;
                }
            }
            if (!moved) {
                //주변 4칸 중 청소칸 없음
                int backDir=(dir+2)%4;
                int backX=nx+dx[backDir];
                int backY=ny+dy[backDir];
                if (backX>=0&&backY>=0&&backX<n&&backY<m&&board[backX][backY]==1) {
                    return count;
                } else {
                    nx=backX; ny=backY;
                }
            }
        }
    }
}
