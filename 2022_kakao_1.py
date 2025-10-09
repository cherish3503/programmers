# 한 사람이 한 사람을 여러번 신고가능 -> 하나로 처리

# 신고된 사람: 신고 한 사람 리스트
def reporting(report):
    reportPerson = dict()
    for r in report:
        from_, to = r.split()
        if to in reportPerson:
            # 중복 신고 체크
            if not from_ in reportPerson[to]: 
                reportPerson[to].append(from_)
        else: 
            reportPerson[to] = [from_]
    return reportPerson
            
def count(id_list, k, reportPerson):
    reportCount = {id:0 for id in id_list}
    for to, from_ in reportPerson.items():
        if len(from_) >= k:
        # 신고횟수 이상
            for f in from_:
                reportCount[f] += 1
    return reportCount

def solution(id_list, report, k):
    # id_enmerate = list(enumerate(id_list))
    answer = []
    
    reportPerson = reporting(report)
            
    reportCount = count(id_list, k, reportPerson)
            
    # print(reportPerson)
    # print(reportCount)
    answer = list(reportCount.values())
    
    return answer











