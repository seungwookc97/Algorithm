def solution(n, q, ans):
    answer = 0
    
    
    def dfs(tmp,cnt):
        nonlocal answer
        if len(tmp)==5:
            
            flag=True
            
            for i,lst in enumerate(q):
                ansCnt=0
                for val in lst:
                    if val in tmp:
                        ansCnt+=1
                
                if ansCnt!=ans[i]:
                    flag=False
                    break
            
            if flag:
                answer+=1
                
            return
                    
        for i in range(cnt,n+1):
            tmp.add(i)
            dfs(tmp,i+1)
            tmp.remove(i)
            
    
    dfs(set(),1)
    return answer