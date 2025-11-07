def solution(schedules, timelogs, startday):
    answer = 0
    n=len(schedules)
    
    for i in range(n):
        flag=True
        st= str(schedules[i])
        std = int(st[:len(st)-2])*60 + int(st[len(st)-2:])

        for j in range(7):
            if (startday+j)%7 in (6,0):
                continue
            
            ti = str(timelogs[i][j])
            time = int(ti[:len(ti)-2])*60 + int(ti[len(ti)-2:])

            if time>std+10:
                flag=False
                break

        if flag:
            answer+=1
            
            
    return answer