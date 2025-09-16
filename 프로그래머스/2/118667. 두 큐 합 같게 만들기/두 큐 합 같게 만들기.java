import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1= new ArrayDeque<>();
        Queue<Integer> q2= new ArrayDeque<>();
        long sum1=0L, sum2=0L;
        
        for(int i=0; i<queue1.length; i++){
            sum1+=queue1[i];
            q1.add(queue1[i]);
        }
        
        for(int i=0; i<queue2.length; i++){
            sum2+=queue2[i];
            q2.add(queue2[i]);
        }
        
        if((sum1 + sum2) % 2 != 0) return -1;
        long target = (sum1+sum2)/2;
        int maxOperations = queue1.length * 3;
        
        while(answer < maxOperations){
            if(sum1 == sum2){
                return answer;
            }
            
            if(q1.isEmpty() || q2.isEmpty()) break;
                
            if(sum1 > target){
                int p = q1.poll();
                q2.add(p);
                sum1 -= p;
                sum2 += p;
            } else {
                int p = q2.poll();
                q1.add(p);
                sum2 -= p;
                sum1 += p;
            }
            answer++;
        }
        
        return -1;
    }
}