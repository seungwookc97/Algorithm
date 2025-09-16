import java.util.*;

class Solution {
    Set<String> ss1 = new HashSet<>();
    Set<String> ss2 = new HashSet<>();
    Map<String, Integer> sm1= new HashMap<>();
    Map<String, Integer> sm2= new HashMap<>();
    
    
    public int solution(String str1, String str2) {
        int answer = 0;
        
        for(int i=0; i<str1.length()-1; i++){
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            
            if( !Character.isLetter(first) || !Character.isLetter(second))
                continue;
            
            first = Character.toUpperCase(first);
            second = Character.toUpperCase(second);
            
            String tmp = String.valueOf(first)+second;
            ss1.add(tmp);
            sm1.put(tmp, sm1.getOrDefault(tmp,0)+1);
        }
        
        for(int i=0; i<str2.length()-1; i++){
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);
            
            if( !Character.isLetter(first) || !Character.isLetter(second))
                continue;
            
            first = Character.toUpperCase(first);
            second = Character.toUpperCase(second);
            
            String tmp = String.valueOf(first)+second;
            ss2.add(tmp);
            sm2.put(tmp, sm2.getOrDefault(tmp,0)+1);
        }
        
        int intersection = 0;
        int union = 0;

        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(sm1.keySet());
        allKeys.addAll(sm2.keySet());

        for(String key : allKeys){
            int v1 = sm1.getOrDefault(key,0);
            int v2 = sm2.getOrDefault(key,0);

            intersection += Math.min(v1, v2);
            union += Math.max(v1, v2);
        }
        if(intersection==0&&union==0){
            return 65536;
        }
        int res =(int) Math.floor(((double)intersection / union) * 65536);
        return res;
    }
}