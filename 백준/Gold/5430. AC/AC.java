
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String num = br.readLine();
            num=num.substring(1, num.length()-1);

            int[] nums;
            if(num.isEmpty()){
                nums = new int[0];
            } else {
                nums = Arrays.stream(num.split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            int flag =0; //안뒤집힌 상태
            int delLeft=0;
            int delRight=0;
            boolean error= false;

            for(char c: cmd.toCharArray()){

                if(c=='R'){
                    flag^=1;
                }
                if( c=='D'){
                    if(delLeft+delRight>=n){
                        error=true;
                        break;
                    }else{
                        if(flag==0){
                            delLeft++;
                        }else{
                            delRight++;
                        }
                    }
                }
            }

            if(error){
                System.out.println("error");
                continue;
            }
            Deque<Integer> q = new LinkedList<>();
            for(int p: nums) q.add(p);

            while(!q.isEmpty() && delLeft>0){
                q.removeFirst();
                delLeft--;
            }

            while(!q.isEmpty() && delRight>0){
                q.removeLast();
                delRight--;
            }

            StringBuilder sb = new StringBuilder();
            sb.append('[');
            if(flag==0){

                while(!q.isEmpty()){
                    sb.append(q.removeFirst());
                    if(!q.isEmpty()) sb.append(',');
                }

            }else{
                while(!q.isEmpty()){
                    sb.append(q.removeLast());
                    if(!q.isEmpty()) sb.append(',');
                }
            }

            sb.append(']');

            System.out.println(sb.toString());
        }
    }
}