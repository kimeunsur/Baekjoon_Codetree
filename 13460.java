import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input=br.readLine().split("\\s+");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        char[][] board=new char[n][m];
        int rx=0, ry=0, bx=0, by=0;
        for (int i=0;i<n;i++) {
            String word=br.readLine();
            for (int j=0;j<m;j++) {
                char ch=word.charAt(j);
                board[i][j]=ch;
                if (ch=='R') {rx=i;ry=j;}
                else if (ch=='B') {bx=i;by=j;}
            }
        }
        boolean[][][][] isVisited= new boolean[n][m][n][m];
        Queue<State> queue= new LinkedList<>();
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        isVisited[rx][ry][bx][by]=true;
        queue.offer(new State(rx,ry,bx,by,0));
        while (!queue.isEmpty()) {
            State cur=queue.poll();
            if (cur.depth>=10) continue;
            for (int i=0;i<4;i++) {
                boolean redInHole=false; boolean blueInHole=false;
                int nrx=cur.rx;
                int nry=cur.ry;
                int nbx=cur.bx;
                int nby=cur.by;
                int rMove=0, bMove=0;
                while (true) {
                    int nextX=nrx+dx[i]; int nextY=nry+dy[i];
                    if (!inRange(nextX, nextY)) break;
                    if (board[nextX][nextY]=='#') break;
                    nrx=nextX; nry=nextY;
                    if (board[nrx][nry]=='O') {redInHole=true; break;}
                    rMove++;
                }
                while (true) {
                    int nextX=nbx+dx[i]; int nextY=nby+dy[i];
                    if (!inRange(nextX, nextY)) break;
                    if (board[nextX][nextY]=='#') break;
                    nbx=nextX; nby=nextY;
                    if (board[nbx][nby]=='O') {blueInHole=true; break;}
                    bMove++;
                }
                if (nrx==nbx && nry==nby) {
                    if (rMove>bMove) {
                        nrx-=dx[i];
                        nry-=dy[i];
                    } else {
                        nbx-=dx[i];
                        nby-=dy[i];
                    }
                }
                int nextDepth=cur.depth+1;
                if (blueInHole) {
                    continue;
                }
                if (redInHole) {
                    bw.write(nextDepth+"\n");
                    bw.close();
                    return;
                }
                if (!isVisited[nrx][nry][nbx][nby]) {
                    isVisited[nrx][nry][nbx][nby]=true;
                    queue.offer(new State(nrx,nry,nbx,nby,nextDepth));
                }
            }
        }
        bw.write("-1\n");
        bw.close();
        br.close();

    }
    private static boolean inRange(int x, int y) {
        return x>=0 && y>=0 && x<n && y<m;
    }
    private static class State {
        int rx,ry,bx,by,depth;
        State (int rx, int ry, int bx, int by, int depth) {
            this.rx=rx;
            this.ry=ry;
            this.bx=bx;
            this.by=by;
            this.depth=depth;
        }
    }
}
