import java.util.*;
import java.io.*;
public class Main {
    static int n,result;
    static int[][] board;
    static Loc start;
    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        board=new int[n][n];
        start=null;
        for (int i=0;i<n;i++) {
            String[] input=br.readLine().split(" ");
            for (int j=0;j<n;j++) {
                board[i][j]=Integer.parseInt(input[j]);
                if (board[i][j]==9) {
                    start=new Loc (i,j,0,2,0);
                    board[i][j]=0;
                }
            }
        }   
        simulate();
        bw.write(result+"\n");
        br.close();
        bw.close();
    }
    private static void simulate() {
        while (true) {
            Loc target=findClosestFish(start);
            if (target==null) break;
            start.x=target.x;
            start.y=target.y;
            board[start.x][start.y]=0;
            start.eaten++;
            if (start.eaten==start.size) {
                start.size++;
                start.eaten=0;
            }
            result+=target.dist;
            start.dist=0;
        }
    }
    private static Loc findClosestFish(Loc loc) {
        Queue<info> queue=new LinkedList<>();
        boolean[][] visited=new boolean[n][n];
        List<info> candidates=new ArrayList<>();
        int[] dx=new int[] {-1,1,0,0};
        int[] dy=new int[] {0,0,-1,1};
        queue.offer(new info (loc.x,loc.y,0));
        visited[loc.x][loc.y]=true;
        while (!queue.isEmpty()) {
            info cur=queue.poll();
            for (int i=0;i<4;i++) {
                int x=cur.x+dx[i];
                int y=cur.y+dy[i];
                int dist=cur.dist+1;
                if (x<0||y<0||x>=n||y>=n||visited[x][y]) continue;
                if (board[x][y]!=0&&board[x][y]>loc.size) continue;
                visited[x][y]=true;
                queue.offer(new info (x,y,dist));
                if (board[x][y]!=0&&board[x][y]<loc.size) {
                    //후보
                    candidates.add(new info (x,y,dist));
                }
            }
        }
        if (candidates.isEmpty()) return null;
        Collections.sort(candidates,(a,b) -> {
            if (a.dist!=b.dist) return a.dist-b.dist;
            if (a.x!=b.x) return a.x-b.x;
            return a.y-b.y;
        });
        info candidate=candidates.get(0);
        return new Loc ( candidate.x,candidate.y,loc.eaten,loc.size,candidate.dist);
    }
    public static class info {
        int x,y,dist;
        info (int x,int y,int dist) {
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    public static class Loc {
        int x,y,eaten,size,dist;
        Loc (int x,int y,int eaten,int size,int dist) {
            this.x=x;
            this.y=y;
            this.eaten=eaten;
            this.size=size;
            this.dist=dist;
        }
    }
}
