import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[][] board;
    static Map<Integer,Character> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        int k=Integer.parseInt(br.readLine());
        board=new int[n][n];
        for (int i=0;i<k;i++) {
            String[] input=br.readLine().split(" ");
            int x=Integer.parseInt(input[0])-1;
            int y=Integer.parseInt(input[1])-1;
            board[x][y]=1;
        }
        int l=Integer.parseInt(br.readLine());
        map=new HashMap<>();
        for (int i=0;i<l;i++) {
            String[] input=br.readLine().split(" ");
            int x=Integer.parseInt(input[0]);
            char c=input[1].charAt(0);
            map.put(x,c);
        }
        bw.write(simulate()+"\n");
        br.close();
        bw.close();
    }
    private static int simulate() {
        int time=0;
        Deque<int[]> snake=new LinkedList<>();
        boolean[][] isSnake=new boolean[n][n];
        snake.addFirst(new int[] {0,0});
        int[] dx={0,1,0,-1}; //오른쪽 아래 왼쪽 위
        int[] dy={1,0,-1,0};
        int dir=0;
        while (true) {
            time++;
            int[] head=snake.peekFirst();
            int nx=head[0]+dx[dir];
            int ny=head[1]+dy[dir];
            if (nx<0||ny<0||nx>=n||ny>=n||isSnake[nx][ny]==true) {
                return time;
            }
            snake.addFirst(new int[] {nx,ny});
            isSnake[nx][ny]=true;
            if (board[nx][ny]==1) {
                board[nx][ny]=0;
            } else {
                int[] tail=snake.pollLast();
                isSnake[tail[0]][tail[1]]=false; //꼬리 제거
            }
            if (map.containsKey(time)) {
                char c=map.get(time);
                if (c=='L') {
                    dir=(dir+3)%4;
                } else if (c=='D') {
                    dir=(dir+1)%4;
                }
            }
        }
    }
}
