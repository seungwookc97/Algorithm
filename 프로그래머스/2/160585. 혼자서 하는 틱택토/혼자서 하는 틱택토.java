import java.util.*;
class Solution {
    
    public int solution(String[] board) {
        char[][] b= new char[3][3];
        int oct=0, xct=0;
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                b[i][j]= board[i].charAt(j);
                if(b[i][j]=='O') oct+=1;
                if(b[i][j]=='X') xct+=1;
            }
        }
        boolean ocheck=false;
        boolean xcheck=false;
        
        if(b[0][0] == 'O' && b[0][1] =='O' && b[0][2] =='O') ocheck= true;
        if(b[1][0] == 'O' && b[1][1] =='O' && b[1][2] =='O') ocheck= true;
        if(b[2][0] == 'O' && b[2][1] =='O' && b[2][2] =='O') ocheck= true;
        if(b[0][0] == 'O' && b[1][0] =='O' && b[2][0] =='O') ocheck= true;
        if(b[0][1] == 'O' && b[1][1] =='O' && b[2][1] =='O') ocheck= true;
        if(b[0][2] == 'O' && b[1][2] =='O' && b[2][2] =='O') ocheck= true;
        if(b[0][0] == 'O' && b[1][1] =='O' && b[2][2] =='O') ocheck= true;
        if(b[2][0] == 'O' && b[1][1] =='O' && b[0][2] =='O') ocheck= true;
        
        if(b[0][0] == 'X' && b[0][1] =='X' && b[0][2] =='X') xcheck= true;
        if(b[1][0] == 'X' && b[1][1] =='X' && b[1][2] =='X') xcheck= true;
        if(b[2][0] == 'X' && b[2][1] =='X' && b[2][2] =='X') xcheck= true;
        if(b[0][0] == 'X' && b[1][0] =='X' && b[2][0] =='X') xcheck= true;
        if(b[0][1] == 'X' && b[1][1] =='X' && b[2][1] =='X') xcheck= true;
        if(b[0][2] == 'X' && b[1][2] =='X' && b[2][2] =='X') xcheck= true;
        if(b[0][0] == 'X' && b[1][1] =='X' && b[2][2] =='X') xcheck= true;
        if(b[2][0] == 'X' && b[1][1] =='X' && b[0][2] =='X') xcheck= true;
        
        if(ocheck && xcheck) return 0;
        if(!ocheck && !xcheck && (oct==xct+1 || oct==xct)) return 1; // 둘다 완성아닐때는 oct가 하나 많거나 xct와 같아야한다
        if(xcheck && !ocheck && oct==xct) return 1; // x만 완성일때는 xct가 oct랑 같아야함
        if(ocheck && oct==xct+1) return 1;//o만 완성일때는 oct가 하나 더 많아야함
        
        return 0;
    }
    
}