import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {



    /*
    벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
    가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
    로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
    올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
     */
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr= new int[2*n];

        st = new StringTokenizer(br.readLine().trim());
        
        for(int i=0;i< 2*n;i++){
            String s = st.nextToken();
            arr[i] = Integer.parseInt(s);
        }
        
        LinkedList<beltStatus> belt = new LinkedList<>();
        
        for(int i=0; i<2*n; i++){
            belt.add(new beltStatus(arr[i], false));
        }
        
        int cnt=0;
        int answer=0;
        
        while(cnt<k){

            belt.addFirst(belt.removeLast());
            belt.get(n - 1).robotExist = false;

            for(int i=n-2; i>=0; i--){ //가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다
                if(belt.get(i).robotExist && !belt.get(i+1).robotExist && belt.get(i+1).cur > 0){
                    belt.get(i).robotExist = false;
                    belt.get(i+1).robotExist = true;
                    belt.get(i+1).cur--;

                    if(belt.get(i+1).cur ==0) cnt++;
                }
            }

            belt.get(n - 1).robotExist = false;

            if(belt.get(0).cur >0) {
                belt.get(0).robotExist = true;
                belt.get(0).cur--;
                if(belt.get(0).cur ==0) cnt++;
            }
            answer++;
        }
        System.out.println(answer);
    }
}

class beltStatus {
    int cur;
    boolean robotExist;

    public beltStatus(int cur, boolean robotExist){
        this.cur = cur;
        this.robotExist = robotExist;
    }
}
