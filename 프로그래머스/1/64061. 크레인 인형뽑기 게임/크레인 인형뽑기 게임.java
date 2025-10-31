import java.util.*;

class Solution {
    private int n,m ;
    private List<Deque<Integer>> lst = new ArrayList<>();
    private int answer=0;
    private Stack<Integer> st = new Stack<>();
    
    public int solution(int[][] board, int[] moves) {
        
        m= board.length;
        n= board[0].length;
        
        for(int i=0; i<m; i++){
            Deque<Integer> tmp = new ArrayDeque<>();
            for(int j=n-1; j>=0; j--){
                if(board[j][i]!=0)
                    tmp.add(board[j][i]);
            }
            lst.add(tmp);
        }
        
        for(int move : moves){
            if(!lst.get(move-1).isEmpty()){
                check(lst.get(move-1).pollLast());
            }
        }
        return answer;
    }
    
    private void check(int val){
        if(!st.isEmpty() && st.peek()==val){
            st.pop();
            answer+=2;
        }else{
            st.push(val);
        }
    }
}