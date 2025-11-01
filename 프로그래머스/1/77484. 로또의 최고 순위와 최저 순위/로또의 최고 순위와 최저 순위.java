import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[]{0,0};
        Set<Integer> set = Arrays.stream(win_nums)
                                    .boxed()
                                    .collect(Collectors.toSet());
        
        int cnt=0;
        int zcnt=0;
        for(int lot : lottos){
            if(set.contains(lot)) cnt++;
            if(lot==0) zcnt++;
        }
        
        answer[1]=7-cnt;
        
        if(answer[1] > 6) answer[1]= 6;
        
        answer[0]=answer[1]-zcnt;
        if(answer[0]<1) answer[0]=1;
        
        
        return answer;
    }
}