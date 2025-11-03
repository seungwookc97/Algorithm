import java.util.*;

class Solution {
    static int[] dx ={1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++){
            if(check(places,i)){
                answer[i]=1;
            }else{
                answer[i]=0;
            }
        }
        return answer;
    }
    
    private boolean check(String[][] places, int idx){
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(places[idx][i].charAt(j)=='P'){
                    visited = new boolean[5][5];
                    if(!valid(places,idx,i,j, 0)){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    

        
     private boolean valid(String[][] places, int idx, int x, int y, int cnt){
        
        if(cnt > 0 && places[idx][x].charAt(y) == 'P'){
            return false;
        }
        
        if(cnt >= 2){
            return true;
        }
        
        if(places[idx][x].charAt(y) == 'X'){
            return true;
        }
        
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            if(visited[nx][ny]) continue;

            if(!valid(places, idx, nx, ny, cnt + 1)){
                return false;
            }
        }
        
        return true;
    }
}