def solution(targets):
    answer = 1
    
    targets.sort(key=lambda x: (x[1],x[0]))
    std=targets[0][1]
    
    for i in range(1, len(targets)):
        if targets[i][0]>=std:
            answer+=1
            std=targets[i][1]
    
    return answer