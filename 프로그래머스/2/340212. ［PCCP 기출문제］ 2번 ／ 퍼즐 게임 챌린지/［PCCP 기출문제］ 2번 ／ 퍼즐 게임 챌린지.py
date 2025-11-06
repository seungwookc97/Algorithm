def solution(diffs, times, limit):
    answer = 0
    
    start= min(diffs)
    end = max(diffs)
    
    
    while start<=end:
        
        mid= (start+end)//2
        su=0
        time_prev=0
        time=0
        
        for i in range(len(diffs)):
            
            if diffs[i]<=mid:
                time+=times[i]
            else:
                cnt = diffs[i]-mid
                time+= cnt * (times[i] + time_prev) + times[i]
        
            time_prev=times[i]
        
        if time <= limit:
            answer = mid
            end = mid - 1
        else:
            start = mid + 1
        print(start,mid,end)
    return answer