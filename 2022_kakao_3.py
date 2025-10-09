import math


def sumTime(records):
    totalTimeDict = dict()
    inTimeDict = dict()
    for r in records:
        timeStr, no, inout = r.split()
        hour, minute = map(int, timeStr.split(':'))
        time = hour * 60 + minute
        if inout == 'IN':
            inTimeDict[no] = time
        elif inout == 'OUT':
            usageTime = time - inTimeDict.pop(no)
            if no in totalTimeDict:
                totalTimeDict[no] += usageTime
            else:
                totalTimeDict[no] = usageTime
    # 남은 차 빼기
    for no, time in inTimeDict.items():
        usageTime = 23 * 60 + 59 - time
        if no in totalTimeDict:
            totalTimeDict[no] += usageTime
        else:
            totalTimeDict[no] = usageTime

    return totalTimeDict


def calcFee(fees, time):
    if time < fees[0]:
        return fees[1]
    return fees[1] + math.ceil((time - fees[0]) / fees[2]) * fees[3]


def solution(fees, records):
    answer = []

    totalTimeDict = sumTime(records)
    # print(totalTimeDict)
    answer = [calcFee(fees, time) for no, time in sorted(totalTimeDict.items())]

    return answer