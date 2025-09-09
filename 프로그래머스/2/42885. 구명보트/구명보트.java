import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int start=0;
        int end= people.length-1;
        
        Arrays.sort(people);
        
        while(start<=end){
            
            if(people[start]+people[end]<=limit){
                start++;
                end--;
                
            } else{
                end--;
            }
                
            answer++;

        }

        return answer;
    }
}

// 50 50 70 80