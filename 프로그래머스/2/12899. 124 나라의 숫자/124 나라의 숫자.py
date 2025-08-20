def solution(n):
    answer = ''
    
    while n >0:
        m=n%3
        
        if m==1:
            answer+='1'
        elif m==2:
            answer+='2'
        else:
            answer+='4'
        
        n=(n-1)//3
        
    return answer[::-1]

