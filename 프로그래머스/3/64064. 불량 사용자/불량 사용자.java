import java.util.*;

class Solution {
    private static int answer;
    private static Set<String> set = new HashSet<>();
    private static Set<Set<String>> resSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        dfs(user_id, banned_id, 0);
        return answer;
    }
    
    private static void dfs(String[] user_id, String[] banned_id, int start){
        
        if(start>= banned_id.length){
            
            if(set.size()>= banned_id.length && !resSet.contains(set)){
                System.out.println(set);
                resSet.add(new HashSet<>(set));
                answer++;
            }
            return;
        }
        
        for(int i=0 ; i<user_id.length; i++){
            if(banned_id[start].length() != user_id[i].length()) continue;
            StringBuilder sb = new StringBuilder(user_id[i]);
            
            for(int j=0; j<banned_id[start].length(); j++){
                
                if(banned_id[start].charAt(j)=='*'){
                    sb.setCharAt(j,'*');
                }
            }
            String val = sb.toString();
            
            if(!set.contains(user_id[i]) && val.equals(banned_id[start])){
                set.add(user_id[i]);
                dfs(user_id, banned_id, start+1);
                set.remove(user_id[i]);
            }
        
        }
    }
}