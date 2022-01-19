# 2020 KAKAO INTERN - Maximize Formula

from collections import deque

operator = ['+','-','*']
priorityList = [[0,1,2],[0,2,1],[1,0,2],[1,2,0],[2,0,1],[2,1,0]]

def calc(arr, priority):
    # 우선순위대로 수식계산
    arr_tmp = arr.copy()
    for i in range(len(priority)):
      result = deque()
      while arr_tmp:
        tmp = arr_tmp.popleft()
        if tmp != operator[priority[i]]:
          result.append(tmp)
        else:
          if operator[priority[i]] == '+':
            result.append(result.pop() + arr_tmp.popleft())
          elif operator[priority[i]] == '-':
            result.append(result.pop() - arr_tmp.popleft())
          elif operator[priority[i]] == '*':
            result.append(result.pop() * arr_tmp.popleft())
      arr_tmp = result
                
    return result[0]
    

def solution(expression):
    initList = deque()
    tmp = ''
    result = list()
    for i in expression:
        if i not in operator:
        # 정수인 경우 앞의 정수와 합치기
          tmp += i
        else: 
        # 기호인 경우 앞의 정수와 기호를 배열에 삽입 
          initList.append(int(tmp))
          initList.append(i)
          tmp = ''
    initList.append(int(tmp))
    # 마지막 정수를 배열에 삽입

    for i in priorityList:
      result.append(abs(calc(initList, i)))
    
    answer = max(result)
    return answer
