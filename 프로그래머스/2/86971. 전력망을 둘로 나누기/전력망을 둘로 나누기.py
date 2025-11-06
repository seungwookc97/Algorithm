def solution(n, wires):
    answer = float('inf')
    
    def check(cur):
        
        for nxt in lst[cur]:
            if not visited[nxt]:
                visited[nxt]=True
                check(nxt)
                
    lst=[[] for _ in range(n+1)]
    
    for a,b in wires:
        lst[a].append(b)
        lst[b].append(a)
        
    
    for a,b in wires:
        visited=[False]*(n+1)
        lst[a].remove(b)
        lst[b].remove(a)
        
        visited[1]=True
        check(1)
        cnt=sum(i for i in visited if i)
        answer=min( answer, abs((n-cnt)-cnt))
        
        lst[a].append(b)
        lst[b].append(a)
    return answer