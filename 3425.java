import java.io.*;
import java.util.*;
public class Main {
    static final long MAX_VALUE=1_000_000_000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> program=new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        while (true) {
            String line=br.readLine();
            if (line.equals("QUIT")) break;
            if (line.isEmpty()) {
                executeProgram(sb, program);
                program.clear();
            } else {
             program.add(line);   
            }
        }
        executeProgram(sb, program);
        bw.write(sb.toString()+"\n");
        bw.close(); 
        br.close();
    }
    public static void executeProgram(StringBuilder sb, List<String> program) {
        if (program.isEmpty()) return;
        List<String> instructions=new ArrayList<>();
        int index=0;
        while (!program.get(index).equals("END")) {
            instructions.add(program.get(index));
            index++;
        }
        int n=Integer.parseInt(program.get(index+1));
        for (int i=0;i<n;i++) {
            long value=Long.parseLong(program.get(index+2+i));
            List<Long> stack=new ArrayList<>();
            stack.add(value);
            if (!runInstructions(instructions,stack)) {
                sb.append("ERROR\n");
            } else {
                if (stack.size()==1) sb.append(stack.get((0))).append("\n");
                else sb.append("ERROR\n");
            }        
        }
        sb.append("\n");
    }
    public static boolean runInstructions(List<String> instructions, List<Long> stack) {
        for (String inst:instructions) {
            String[] parts=inst.split(" ");
            String cmd=parts[0];
            try {
                switch (cmd) {
                    case "NUM":
                        stack.add(Long.parseLong(parts[1]));
                        break;
                    case "POP":
                        if (stack.isEmpty()) return false;
                        stack.remove(stack.size()-1);
                        break;
                    case "INV":
                        if (stack.isEmpty()) return false;
                        stack.set(stack.size()-1, -stack.get(stack.size()-1));
                        break;
                    case "DUP":
                        if (stack.isEmpty()) return false;
                        stack.add(stack.get(stack.size()-1));
                        break;
                    case "SWP":
                        if (stack.size()<2) return false;
                        int last=stack.size()-1;
                        Collections.swap(stack,last,last-1);
                        break;
                    case "ADD":
                        if (stack.size()<2) return false;
                        long a=stack.remove(stack.size()-1);
                        long b=stack.remove(stack.size()-1);
                        long sum=a+b;
                        if (Math.abs(sum)>MAX_VALUE) return false;
                        stack.add(sum);
                        break;
                    case "SUB":
                        if (stack.size()<2) return false;
                        a=stack.remove(stack.size()-1);
                        b=stack.remove(stack.size()-1);
                        long diff=b-a;
                        if (Math.abs(diff)>MAX_VALUE) return false;
                        stack.add(diff);
                        break;    
                    case "MUL":
                        if (stack.size()<2) return false;
                        a=stack.remove(stack.size()-1);
                        b=stack.remove(stack.size()-1);
                        long product=a*b;
                        if (Math.abs(product)>MAX_VALUE) return false;
                        stack.add(product);
                        break;
                    case "DIV":
                        if (stack.size()<2) return false;
                        a=stack.remove(stack.size()-1);
                        b=stack.remove(stack.size()-1);
                        if (a==0) return false;
                        long div=Math.abs(b)/Math.abs(a);
                        if (b>0 && a<0 || b<0&&a>0) div=-div;
                        stack.add(div);
                        break;
                    case "MOD":
                        if (stack.size()<2) return false;
                        a=stack.remove(stack.size()-1);
                        b=stack.remove(stack.size()-1);
                        if (a==0) return false;
                        long mod=Math.abs(b)%Math.abs(a);
                        if (b<0) mod=-mod;
                        stack.add(mod);
                        break;
                    default:
                        return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
#노가다 문제이지만, 자바의 리스트 메서드 & 스택 개념 정리하기엔 딱인 문제!
