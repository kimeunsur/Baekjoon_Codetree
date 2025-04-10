import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int[][] board;
    static int min=Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1}; //상하좌우
    static int[][][] directions= {
        {},
        {{0},{1},{2},{3}},
        {{0,1},{2,3}},
        {{0,2},{0,3},{1,2},{1,3}},
        {{0,1,2},{0,1,3},{0,2,3},{1,2,3}},
        {{0,1,2,3}}
    };
    static List<info> cameras=new ArrayList<>();
    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input=br.readLine().split(" ");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        board=new int[n][m];
        visited=new boolean[n][m];
        for (int i=0;i<n;i++) {
            input=br.readLine().split(" ");
            for (int j=0;j<m;j++) {
                board[i][j]=Integer.parseInt(input[j]);
                if (board[i][j]>=1&&board[i][j]<=5) {
                    cameras.add(new info (i,j,board[i][j]));
                    visited[i][j]=true;
                }
                if (board[i][j]==6) visited[i][j]=true;
            }
        }
        dfs(0);
        bw.write(min+"\n");
        br.close();
        bw.close();
    }
    private static void dfs(int depth) {
        if (depth==cameras.size()) {
            int count=0;
            for (int i=0;i<n;i++) {
                for (int j=0;j<m;j++) {
                    if (!visited[i][j]) count++;
                }
            }
            min=Math.min(count,min);
            return;
        }
        info camera=cameras.get(depth);
        int[][] dirSet=directions[camera.num];
        for (int[] dir:dirSet) {
            List<int[]> traced=new ArrayList<>();
            for (int d:dir) {
                int x=camera.x;
                int y=camera.y;
                while (true) {
                    x+=dx[d];
                    y+=dy[d];
                    if (x<0||y<0||x>=n||y>=m) break;
                    if (board[x][y]==6) break;
                    if (!visited[x][y]) {
                        traced.add(new int[] {x,y});
                        visited[x][y]=true;
                }
            }
            }
            dfs(depth+1);

            for (int[] t:traced) visited[t[0]][t[1]]=false;
        }

    }

    private static class info {
        int x,y,num;
        info (int x,int y,int num) {
            this.x=x;
            this.y=y;
            this.num=num;
        }
    }
}
