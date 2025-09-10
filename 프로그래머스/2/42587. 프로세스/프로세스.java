import java.util.*;

class Pos{
    int pr, idx;
    
    Pos(int pr, int idx){
        this.pr=pr;
        this.idx=idx;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Pos> q = new ArrayDeque<>();
        List<Integer> set = new ArrayList<>();
        
        for(int i=0; i<priorities.length; i++){
            q.add(new Pos(priorities[i],i));
            set.add(priorities[i]);
        }
        
        
        Collections.sort(set, Collections.reverseOrder());
                
        while(!q.isEmpty()){
            
            Pos cur= q.poll();
            
            if(!q.isEmpty() && cur.pr == set.get(answer)){
                answer++;
                if(cur.idx == location){
                    return answer;
                }
            }
            q.add(cur);
    
        }
        return answer;
    }
}