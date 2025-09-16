import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        int answer = 0;
        Deque<String> cache = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for (String city : cities) {
            city = city.toLowerCase();

            if (set.contains(city)) {
                cache.remove(city);
                cache.addFirst(city);
                answer += 1;
            } else {      
                if (cache.size() == cacheSize) {
                    String removed = cache.removeLast();
                    set.remove(removed);
                }
                cache.addFirst(city);
                set.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}