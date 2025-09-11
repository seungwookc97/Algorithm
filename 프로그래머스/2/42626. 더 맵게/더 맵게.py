import heapq as hq
def solution(scoville, K):
    answer = 0
    
    hq.heapify(scoville)
    cnt=0

    while scoville:
        first=hq.heappop(scoville)
        
        if first>=K:
            return cnt
        
        if not scoville:
            return -1
        
        second=hq.heappop(scoville)
        new = first + (second*2)
        
        if not scoville and new<K:
            return -1
        
        hq.heappush(scoville,new)
        cnt+=1
    
    
    return -1