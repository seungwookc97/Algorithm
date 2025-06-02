class Solution {
    public String solution(String s) {
        String answer = "";
        boolean prevBlank=true;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' '){
                answer+=" ";
                prevBlank=true;
                continue;
            }
            if(prevBlank){
                if(Character.isDigit(s.charAt(i))) 
                  answer+=s.charAt(i);
                else answer+=Character.toUpperCase(s.charAt(i));
                
                prevBlank=false;
            } 
            else{
                if(Character.isDigit(s.charAt(i))) 
                  answer+=s.charAt(i);
                else answer+=Character.toLowerCase(s.charAt(i));
            }
            
        }
        return answer;
    }
}