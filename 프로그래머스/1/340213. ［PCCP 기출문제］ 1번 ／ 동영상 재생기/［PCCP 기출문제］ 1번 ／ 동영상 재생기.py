def solution(video_len, pos, op_start, op_end, commands):
    
    def std(val):
        return int(val[:2])*60 + int(val[3:])
    
    def check(val):
        if val>=vlen:
            val=vlen
        if val<0:
            val=0
        if opStart<=val<=opEnd:
            val=opEnd
        return val
    
    vlen=std(video_len)
    p=std(pos)
    opStart=std(op_start)
    opEnd=std(op_end)
    p=check(p)
    
    for cmd in commands:
        if cmd =='next':
            p+=10
            
        else:
            p-=10
        p=check(p)
    
    res=''
    hour= p//60
    if hour<10:
        res+='0'
    res+=str(hour)
    res+=':'
    
    minute = p%60
    if minute<10:
        res+='0'
    res+=str(minute)

    return res