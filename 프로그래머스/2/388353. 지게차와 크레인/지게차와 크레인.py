from collections import deque

def solution(storage, requests):
    n=len(storage)
    m=len(storage[0])
    
    def fork(cmd):
        visited=[[False]*(m+2) for _ in range(n+2)]
        visited[0][0]=True
        
        q=deque()
        reqq=deque()
        q.append((0,0))
        
        while q:
            x,y= q.popleft()
            if lst[x][y]==cmd:
                reqq.append((x,y))
                continue
            for dx,dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                nx=x+dx
                ny=y+dy
                
                if 0<=nx<n+2 and 0<=ny<m+2:
                    if not visited[nx][ny] and lst[nx][ny]=='' or lst[nx][ny]==cmd:
                        visited[nx][ny]=True
                        q.append((nx,ny))
        
        for a,b in reqq:
            lst[a][b]=''
    
    def crane(cmd):
        for i in range(n+2):
            for j in range(m+2):
                if lst[i][j]==cmd[0]:
                    lst[i][j]=''
            
    answer = 0
    
    lst = [['']*(len(storage[0])+2)]
    
    for i in range(len(storage)):
        tmp=['']
        for j in storage[i]:
            tmp.append(j)
        tmp.append('')
        lst.append(tmp)
        
    lst.append(['']*(len(storage[0])+2))
    

    
    for req in requests:
        if len(req)==1:
            fork(req)
        else:
            crane(req)

        
    for i in range(n+2):
        for j in range(m+2):
            if lst[i][j]!='':answer+=1
    return answer