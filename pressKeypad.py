# 2020 KAKAO INTERN - press keypad

def distance(loc_hand,target):
  return abs(loc_hand[0] - target[0]) + abs(loc_hand[1] - target[1])

def solution(numbers, hand):
  key_pad = [[1,4,7,'*'],[2,5,8,0],[3,6,9,"#"]]
  loc_l = [3,0] # '*'
  loc_r = [3,2] # '#'
  handDict = {'left' : 'L', 'right' : 'R'}
  answer = ''
  for i in numbers:
    if i in key_pad[0]:
      result = 'L'
      target = [key_pad[0].index(i),0]
    elif i in key_pad[2]:
      result = 'R'
      target = [key_pad[2].index(i),2]
    else:
      target = [key_pad[1].index(i), 1]
      if distance(loc_l,target) < distance(loc_r,target):
        result = 'L'
      elif distance(loc_l,target) > distance(loc_r,target):
        result = 'R'
      else:
        result = handDict[hand]
    
    answer += result 
    if result == 'L':
      loc_l = target
    else:
      loc_r = target

  return answer

