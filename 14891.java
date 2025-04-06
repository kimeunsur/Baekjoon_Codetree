import java.util.*;
import java.io.*;
public class Main {
    static int k;
    static List<int[]> list,gears;
    static int[] one,two,three,four;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        gears=new ArrayList<>();
        for (int i=0;i<4;i++) {
            String input=br.readLine();
            int[] gear=new int[8];
            for (int j=0;j<8;j++) {
                gear[j]=input.charAt(j)-'0';
            }
            gears.add(gear);
        }
        k=Integer.parseInt(br.readLine());
        list=new ArrayList<>();
        for (int i=0;i<k;i++) {
            String[] inputt=br.readLine().split(" ");
            list.add(new int[] {Integer.parseInt(inputt[0]),Integer.parseInt(inputt[1])});
        }
        simulate();
        int sum=0;
        for (int i=0;i<4;i++) {
            if (gears.get(i)[0]==1) {
                sum+=Math.pow(2,i);
            }
        }
        bw.write(sum+"\n");
        br.close();
        bw.close();
    }
    private static void simulate() {
        //1:시계 방향 -1:반시계
        for (int i=0;i<k;i++) {
            int[] directions=new int[4];
            int[] order=list.get(i);
            int gear=order[0]-1;
            int dir=order[1];
            directions[gear]=dir;
            for (int j=gear-1;j>=0;j--) {
                if (gears.get(j)[2]!=gears.get(j+1)[6]) {
                directions[j]=-directions[j+1];
                } else {break;}
            }
            for (int j=gear+1;j<4;j++) {
                if (gears.get(j-1)[2]!=gears.get(j)[6]) {
                directions[j]=-directions[j-1];
                } else {break;}
            }
            for (int j=0;j<4;j++) {
                if (directions[j]!=0) {
                    gears.set(j,move(gears.get(j),directions[j]));
                }
            }
        }
    }
    private static int[] move(int[] list, int num) {
        int[] rotated=new int[8];
        if (num==-1) {
            for (int i=0;i<8;i++) {
                rotated[(i+7)%8]=list[i];
            }
        } else if (num==1) {
            for (int i=0;i<8;i++) {
                rotated[(i+1)%8]=list[i];
            }
        }
        return rotated;
    }
}
