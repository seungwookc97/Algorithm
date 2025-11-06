from itertools import permutations

def solution(numbers):
    
    def isPrime(val):
        if val in s:
            return True
        
        if val==0 or val==1:
            return False
        
        for i in range(2, int(val**(1/2))+1):
            if val%i==0:
                return False
        
        return True

    s=set()
    
    for i in range(1,len(numbers)+1):
        for c in permutations(list(numbers),i):
            val= int(''.join(c))
            if isPrime(val):
                s.add(val)
    
    return len(s)