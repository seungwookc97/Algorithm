def solution(s):
    
    st=[]
    
    for i in s:
        if i=='(':
            st.append('(')
        else:
            if not st:
                return False
            st.pop()
    
    if not st:
        return True

    return False