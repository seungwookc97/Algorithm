n, d, k, c = map(int, input().split())
lst = [int(input()) for _ in range(n)]


lst += lst
max_types = 0


for i in range(n):
    sushi_set = set(lst[i:i+k])
    
    if c not in sushi_set:
        current_types = len(sushi_set) + 1
    else:
        current_types = len(sushi_set)
    
    max_types = max(max_types, current_types)

print(max_types)
