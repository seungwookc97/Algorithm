import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] arr = new int[n+1][n+1];
        
        for(int i=1; i<n+1; i++){
            Arrays.fill(arr[i],Integer.MAX_VALUE);
            arr[i][i]=0;   
        }
        
        for(int[] fare: fares){
            int x =fare[0];
            int y = fare[1];
            int f = fare[2];
            
            arr[x][y]= Math.min(arr[x][y],f);
            arr[y][x]= Math.min(arr[y][x],f);
        }
        
        for(int k=1; k<n+1; k++){
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
                    if(arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE){
                        arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                    }
                }
            }
        }
        
        for(int i=1; i<n+1; i++){
            answer= Math.min(answer, arr[s][i]+arr[i][a]+arr[i][b]);
        }
        return answer;
    }
}