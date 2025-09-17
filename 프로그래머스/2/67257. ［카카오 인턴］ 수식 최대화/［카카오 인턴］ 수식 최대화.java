import java.util.*;

class Solution {
    
    Set<Character> expSet = new HashSet<>();
    List<Character> expLst;
    static int n;
    List<List<Character>> expCandidates = new ArrayList<>();
    List<Character> initExp= new ArrayList<>();
    List<String> numLst;
    
    void getExp(int cnt, LinkedList<Character> tmp, Set<Character> tmpSet){
        
        if(cnt>=n){
            expCandidates.add(new ArrayList<>(tmp));
            return;
        }
        
        for(int i=0; i<n; i++){
            Character c = expLst.get(i);
            if(!tmpSet.contains(c)){
                tmpSet.add(c);
                tmp.add(c);
                getExp(cnt+1,tmp,tmpSet);
                tmpSet.remove(c);
                tmp.removeLast();
            }
        }
    }
    
    public long solution(String expression) {
        long answer = 0;
        for(int i=0; i<expression.length(); i++){
            if(!Character.isDigit(expression.charAt(i))){
                expSet.add(expression.charAt(i));
                initExp.add(expression.charAt(i));
            }
        }
        expLst = new ArrayList<>(expSet);
        n=expLst.size();
        getExp(0, new LinkedList<>(), new HashSet<>());
        
        numLst = Arrays.asList(expression.split("[+*-]"));
        
        for(int i=0; i<expCandidates.size(); i++){
            List<String> numList = new ArrayList<>(numLst);
            List<Character> expList = new ArrayList<>(initExp);
            for(int j=0; j<expLst.size(); j++){    
                char currentExp = expCandidates.get(i).get(j);
                // expList는 원본 연산자 리스트, numList는 원본 숫자 리스트
                for (int k = 0; k < expList.size(); k++) {
                    if (expList.get(k) == currentExp) {
                        long num1 = Long.parseLong(numList.get(k));
                        long num2 = Long.parseLong(numList.get(k + 1));
                        long result = 0;

                        switch (currentExp) {
                            case '+': result = num1 + num2; break;
                            case '-': result = num1 - num2; break;
                            case '*': result = num1 * num2; break;
                        }
                        numList.set(k, String.valueOf(result)); 
                        numList.remove(k + 1);
                        expList.remove(k); // 연산자 제거
                        k--;
                    }
                    
                }
                
            }
            long finalResult = Math.abs(Long.parseLong(numList.get(0)));
            answer = Math.max(answer, finalResult);
        }
        
        return answer;
    }
}

//exp 100개 밑. list로 인덱스 찾아서 계산해준다음 다시 insert