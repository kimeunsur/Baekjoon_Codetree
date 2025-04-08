import java.util.*;
import java.io.*;
public class Main {
    static int l,r,c;
    static int[][][] building;
    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;
        StringBuilder sb=new StringBuilder();
        while (true) {
            input=br.readLine().split(" ");
            l=Integer.parseInt(input[0]);
            r=Integer.parseInt(input[1]);
            c=Integer.parseInt(input[2]);
            if (l==0&&r==0&&c==0) break;
            building=new int[l][r][c];
            Point start=null;
            for (int i=0;i<l;i++) {
                for (int j=0;j<r;j++) {
                    String inputt=br.readLine();
                    for (int k=0;k<c;k++) {
                        building[i][j][k]=inputt.charAt(k);
                        if (building[i][j][k]=='S') {
                            start= new Point (i,j,k,0);
                        }
                    }
                }
                br.readLine();
            }
            int result=bfs(start);
            sb.append(result==-1?"Trapped\n":String.format("Escaped in %d minute(s)\n",result));
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
    private static int bfs(Point start) {
        int[] dx=new int[] {0,0,0,0,-1,1};
        int[] dy=new int[] {0,0,1,-1,0,0};
        int[] dz=new int[] {1,-1,0,0,0,0}; //위 아래 동 서 남 북
        boolean[][][] visited=new boolean[l][r][c];
        Queue<Point> queue=new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Point cur=queue.poll();
            for (int i=0;i<6;i++) {
                int x=cur.x+dx[i];
                int y=cur.y+dy[i];
                int z=cur.z+dz[i];
                int time=cur.time;
                if (x<0||y<0||z<0||x>=l||y>=r||z>=c||visited[x][y][z]) continue; 
                if (building[x][y][z]=='#') continue;
                if (building[x][y][z]=='E') return time+1;      
                visited[x][y][z]=true;
                queue.offer(new Point (x,y,z,time+1));
            }
        }
        return -1;
    }
    static class Point {
        int x;
        int y;
        int z;
        int time;
        Point (int x,int y,int z,int time) {
            this.x=x;
            this.y=y;
            this.z=z;
            this.time=time;
        }
    }
}
