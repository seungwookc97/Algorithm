import java.util.*;

class Solution {
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    public String solution(int n, int t, int m, String[] timetable) {

        
        for(int i=0; i<timetable.length; i++){
            q.add(Integer.parseInt(timetable[i].substring(0,2))*60 + Integer.parseInt(timetable[i].substring(3)));
        }
        
        int cnt=m;
        int time=0;
        
        for(int i=0; i<n; i++){
            time = 540+ i*t;
            
            if(i==n-1) cnt=m-1;
            
            for(int j=0; j<cnt; j++){
                if(!q.isEmpty() && q.peek()<=time) q.poll();
            }
              
        }
        
        if(!q.isEmpty()) time = Math.min(time,q.poll()-1);
        StringBuilder sb = new StringBuilder();
        if(time/60 < 10){
            sb.append(0);
        }
        sb.append(time/60);
        sb.append(':');
        if(time%60 < 10){
            sb.append(0);
        }
        sb.append(time%60);
        
        return sb.toString();
    }
}