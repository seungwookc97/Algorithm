import sys
sys.setrecursionlimit(10 ** 6)

def solution(k, room_number):
    answer = []
    canOrder = {}
    
    def find_empty_room(room):
        if room not in canOrder:
            return room
        
        empty = find_empty_room(canOrder[room])
        canOrder[room] = empty
        return empty
    
    for room in room_number:
        assigned_room = find_empty_room(room)
        answer.append(assigned_room)
        
        canOrder[assigned_room] = assigned_room + 1
    
    return answer