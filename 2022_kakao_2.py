import math


def makeBaseN(n, k):
    result = 0
    now = n
    i = 0
    while now > 0:
        result += (now % k) * 10 ** i
        now = now // k
        i += 1
    return result


def countPrime(n):
    result = 0
    strList = str(n).split('0')
    # numList = []
    # for s in strList:
    #     if s != '':
    #         numList.append(s)
    # numList = list(map(int, str(n).split('0')))
    for s in strList:
        if s == '':
            continue
        if isPrime(int(s)):
            result += 1
    return result


def isPrime(n):
    if n == 0:
        return False
    if n == 1:
        return False

    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True


def solution(n, k):
    answer = -1

    baseN = makeBaseN(n, k)
    # print(baseN)
    answer = countPrime(baseN)

    return answer