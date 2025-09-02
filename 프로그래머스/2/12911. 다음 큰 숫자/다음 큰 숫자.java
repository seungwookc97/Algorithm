class Solution {
    
    static int getVal(int n){
        int count=0;
        
        while(n>0){
            if(n%2==1) count++;
            n/=2;
        }
        return count;
    }

    public int solution(int n) {
        int val = getVal(n++);
        
        while(true){
            if(val ==getVal(n)){
                break;
            }
            n++;
        }
        
        return n;
    }
}