
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Collections;

class Pos{
    int num;
    String cmd;

    Pos(int num, String cmd){
        this.num = num;
        this.cmd = cmd;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] numList =  br.readLine().split(" ");

            int cur = Integer.parseInt(numList[0]);
            int target =  Integer.parseInt(numList[1]);

            Deque<Pos> q = new LinkedList<>();
            Set<Integer> set = new HashSet<>();

            q.add(new Pos(cur, ""));
            set.add(cur);

            while(!q.isEmpty()){

                Pos p = q.pollFirst();

                if(p.num==target){
                    System.out.println(p.cmd);
                    break;
                }

                if(!set.contains((p.num*2)%10000)){
                    set.add((p.num*2)%10000);
                    q.add(new Pos((p.num*2)%10000, p.cmd+"D"));
                }
                if(!set.contains((p.num+9999)%10000)){
                    set.add((p.num+9999)%10000);
                    q.add(new Pos((p.num+9999)%10000, p.cmd+"S"));
                }
                int leftNum = rotateLeft(p.num);
                if(!set.contains(leftNum)){
                    set.add(leftNum);
                    q.add(new Pos(leftNum, p.cmd+"L"));
                }

                int rightNum = rotateRight(p.num);
                if(!set.contains(rightNum)){
                    set.add(rightNum);
                    q.add(new Pos(rightNum, p.cmd+"R"));
                }

            }
        }
    }

    //1234
    private static int rotateLeft(int num) {
        return (num % 1000) * 10 + num / 1000;
    }

    private static int rotateRight(int num) {
        return (num % 10) * 1000 + num / 10;
    }


}