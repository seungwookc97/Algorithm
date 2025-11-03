import java.util.*;
import java.util.stream.*;

class Solution {
    private static Map<String, Integer> map= new HashMap<>();
        
    public int[] solution(String[] gems) {
        
        int[] answer = {0,0};
        int min = Integer.MAX_VALUE;
        Set<String> set = Arrays.stream(gems).collect(Collectors.toSet());
        List<String> lst = new ArrayList<>(set);

        int start = 0;
        int end = 0;
        
        while(end < gems.length) {

            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            end++;
            
            while(map.size() == lst.size()) {
                if(end - start < min) {
                    min = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }
                
                map.put(gems[start], map.get(gems[start]) - 1);
                if(map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            }
        }
        
        return answer;
    }
}