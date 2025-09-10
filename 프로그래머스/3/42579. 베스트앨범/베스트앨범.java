import java.util.*;
import java.util.stream.*;

class Solution {
    
    static Map<String, List<Integer>> idxMap = new HashMap<>();
    static Map<String, Integer> sumMap = new HashMap<>();
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result= new ArrayList<>();
        
        for(int i=0; i<genres.length; i++){
           idxMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
           sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
        }
               
        //속한 노래 많은 장르 순 정렬
        List<String> sortedGenres = sumMap.keySet().stream()
            .sorted(Comparator.comparing(sumMap::get).reversed())
            .collect(Collectors.toList());
        
        
        for(String genre : sortedGenres){
            List<Integer> selected = idxMap.get(genre).stream()
                    .sorted((a, b) -> {
                        if(plays[a] != plays[b]) { //장르 내 재생 횟수 내림
                            return Integer.compare(plays[b], plays[a]);
                        } // 고유 번호 오름
                        return Integer.compare(a, b);
                    })
                    .limit(2)
                    .collect(Collectors.toList());
            result.addAll(selected);
        }
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
