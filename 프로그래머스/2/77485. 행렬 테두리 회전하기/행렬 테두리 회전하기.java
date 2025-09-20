import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int cnt=0;
        
        int[][] board = new int[rows][columns];
        int v=1;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++)
                board[i][j]=v++;
        }

        for(int[] q : queries){
            int sy = q[0]-1;
            int sx = q[1]-1;
            int ey = q[2]-1; 
            int ex = q[3]-1;

            int temp = board[sy][sx];
            int val= temp;

            for(int y = sy; y < ey; y++){
                board[y][sx] = board[y+1][sx];
                if(board[y][sx] <val) val=board[y][sx];
            }

            for(int x = sx; x < ex; x++){
                board[ey][x] = board[ey][x+1];
                if(board[ey][x] <val) val=board[ey][x];
            }

            for(int y = ey; y > sy; y--){
                board[y][ex] = board[y-1][ex];
                if(board[y][ex] <val) val=board[y][ex];
            }

            for(int x = ex; x > sx; x--){
                board[sy][x] = board[sy][x-1];
                if(board[sy][x] <val) val=board[sy][x];
            }

            board[sy][sx+1] = temp;
            answer[cnt++]=val;
        }

        return answer;
    }
}