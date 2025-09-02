import java.util.*;

class Inf{
    String name;
    int money;
    String recPerson;
    
    Inf(String name, int money, String recPerson){
        this.name=name;
        this.money=money;
        this.recPerson=recPerson;
    }
}

class Solution {
    

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int n = enroll.length;
        int[] answer = new int[n];    
        Map<Integer, Inf> inf = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            inf.put(i, new Inf(enroll[i],0, referral[i]));
            map.put(enroll[i], i);
        }
        
        
        
        for(int i=0; i<amount.length; i++){
            int idx = map.get(seller[i]);
            
            int curMoney= amount[i] * 100;
            Inf curPerson = inf.get(idx);
            
            while(true){
                int give = curMoney / 10;
                int keep = curMoney - give;
                
                curPerson.money+= keep;

                if(give==0 || curPerson.recPerson.equals("-"))
                    break;
                
                int nxIdx  = map.get(curPerson.recPerson);
                curPerson = inf.get(nxIdx);
                curMoney = give;
            }
        }
        
        for(int i=0; i<n; i++){
            answer[i]= inf.get(i).money;
        }
        return answer;
    }
}