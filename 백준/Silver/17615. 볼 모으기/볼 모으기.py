from collections import Counter

n= int(input())
val = list(map(str,input()))

ctr =Counter(val)

lr=0
lb=0
rr=0
rb=0


for i in range(len(val)):
    if val[i]=='B':
        lb+=1
    else:
        break

for i in range(len(val)):
    if val[i]=='R':
        lr+=1
    else:
        break


for i in range(len(val)-1,-1,-1):
    if val[i]=='B':
        rb+=1
    else:
        break


for i in range(len(val)-1,-1,-1):
    if val[i]=='R':
        rr+=1
    else:
        break


ans = min(ctr['R']-rr, ctr['R']-lr, ctr['B']-lb, ctr['B']-rb)
print(ans)