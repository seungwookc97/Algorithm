import java.util.*;

class Pos{
    int x,y;
    
    Pos(int x, int y){
        this.x =x;
        this.y =y;
    }
}
class Solution {
    
    static int N,M;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static boolean[][] visited;
    static int bfs(int[][] picture, int a, int b){
        Queue<Pos> q = new ArrayDeque<>();
        int color=picture[a][b];
        int cnt=1;
        
        visited[a][b]=true;
        q.add(new Pos(a,b));
        
        while(!q.isEmpty()){
            Pos p = q.poll();
            
            for(int i=0; i<4; i++){
                int nx= p.x+dx[i];
                int ny= p.y+dy[i];
                
                if(0>nx ||nx>=N || 0>ny || ny>=M) continue;
                
                if(visited[nx][ny] || picture[nx][ny]!=color) continue;
                
                visited[nx][ny]=true;
                q.add(new Pos(nx,ny));
                cnt++;
            }
        }
        
        return cnt;
    }

    public int[] solution(int n, int m, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        N=n;
        M=m;
        visited = new boolean[n][m];
            
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,bfs(picture,i,j));
                    numberOfArea++;
                }
            }
        }

        return new int[]{numberOfArea,maxSizeOfOneArea};
    }
}