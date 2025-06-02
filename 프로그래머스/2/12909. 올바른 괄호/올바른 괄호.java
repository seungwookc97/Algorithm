import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c=='(') st.push(c);
            else{
                if(st.isEmpty() || st.peek()==')') return false;
                st.pop();
            }
        }
        if(st.isEmpty()) return true;

        return false;
    }
}