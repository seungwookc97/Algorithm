def solution(n):
    
    if n % 2 == 1:
        return 0
    
    dp = [0] * (n + 1)
    dp[0] = 1
    

    dp[2] = 3
    
    sum_special = 1
    
    for i in range(4, n + 1, 2):
        dp[i] = (dp[i-2] * 3 + sum_special * 2) % 1000000007
        sum_special = (sum_special + dp[i-2]) % 1000000007
    
    return dp[n]