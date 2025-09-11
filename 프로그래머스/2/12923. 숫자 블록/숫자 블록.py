def solution(begin, end):
    answer = [0]*(end-begin+1)
    
    for i in range(1, 10000001):
        if i * 2 > end:
            break
            
        start = max(i * 2, begin)
        
        if start > end:
            continue
            
        start = ((start + i - 1) // i) * i
        
        pos = start
        while pos <= end:
            answer[pos - begin] = i
            pos += i
            
    return answer