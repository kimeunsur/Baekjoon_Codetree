import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input=br.readLine().split("\\s+");
        int a=Integer.parseInt(input[0]);
        int b=Integer.parseInt(input[1]);
        int v=Integer.parseInt(input[2]);
        int day=0;
        int count=0;
        while (count<=v) {
            count+=a;
            day++;
            if (count>=v) {
                break;
            }
            count-=b;
        }
        bw.write(day+"\n");
        bw.close();
        br.close();
    }
}
//백준 2869번. 위와 같이 풀었는데, 시간 초과 뜸.. 규칙을 찾으라는 말이구나..
//코드 지우고 "int day=(int) Math.ceil((double)(v-a)/(a-b))+1;"로 바꾸니까 돌아감!
