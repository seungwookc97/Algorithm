import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(Character c : s.toCharArray()){
            if(c=='(')
                st.push('(');
            else{
                if(st.isEmpty())
                    return false;
                else
                    st.pop();
            }
        }
        
        if(st.isEmpty()) return true;

        return false;
    }
}