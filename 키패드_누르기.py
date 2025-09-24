def solution(numbers, hand):
    hands=[[-1,7,4,1],[0,8,5,2],[-1,9,6,3]]
    left=(0,0)
    right=(2,0)
    def distance(p,q):
        x,y=p
        r,c=q
        return abs(x-r)+abs(y-c)
    def find_pos(num):
        for i,row in enumerate(hands):
            for j,val in enumerate(row):
                if val==num:
                    return (i,j)
    answer = ''
    for i in range(len(numbers)):
        number=numbers[i]
        if number in hands[0]:
            answer+='L'
            left=find_pos(number)
        elif number in hands[2]:
            answer+='R'
            right=find_pos(number)
        else:
            target=find_pos(number)
            left_dist=distance(left,target)
            right_dist=distance(right,target)
            if left_dist<right_dist or (left_dist==right_dist and hand=='left'):
                left=target
                answer+='L'
            elif left_dist>right_dist or (left_dist==right_dist and hand=='right'):
                right=target
                answer+='R'
    return answer
