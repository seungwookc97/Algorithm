import sys
input= sys.stdin.readline

R,C,m=map(int,input().split())
board=[[0]*C for _ in range(R)]
for _ in range(m):
    r,c,s,d,z=map(int,input().split())
    board[r-1][c-1]=(s,d,z)



def fishing(j):
    for i in range(R):
        if board[i][j]:
            x=board[i][j][2]
            board[i][j]=0
            return x
    return 0

def move():
    global board
    nboard=[[0]*C for _ in range(R)]

    for i in range(R):
        for j in range(C):
            if board[i][j]:
                ni,nj,nd=next_loc(i,j,board[i][j][0],board[i][j][1])
                if nboard[ni][nj]:
                    nboard[ni][nj]=max(nboard[ni][nj],(board[i][j][0],nd,board[i][j][2]),key=lambda x:x[2],)
                else:
                    nboard[ni][nj]=(board[i][j][0],nd,board[i][j][2])

    board=nboard

def next_loc(i,j,speed,dir):
    if dir==1 or dir==2:
        cycle=2*R-2
        if dir==1:
            speed+= 2*(R-1)-i
        else:
            speed+=i

        speed%=cycle
        if speed>=R:
            return (2*R-2-speed,j,1)
        else:
            return (speed,j,2)
    else:
        cycle=2*C-2
        if dir==3:
            speed+=j
        else:
            speed+=2*(C-1)-j
        speed%=cycle
        if speed>=C:
            return (i,2*C-2-speed,4)
        else:
            return (i,speed,3)


ans=0
for j in range(C):
    ans+=fishing(j)
    move()

print(ans)