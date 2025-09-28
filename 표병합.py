def solution(commands):
    size=50
    w=51
    
    def cid(r,c):
        return (r-1)*w+(c-1)
    
    parent={}
    group_members={}
    value={}
    
    for r in range(1,size+1):
        for c in range(1, size+1):
            i=cid(r,c)
            parent[i]=i
            group_members[i]=set([i])
            value[i]=None
    def find(x):
        if parent[x]!=x:
            parent[x]=find(parent[x])
        return parent[x]
    
    def union(a,b):
        # b의 루트를 a의 루트로 병합
        ra,rb=find(a), find(b)
        if ra==rb:
            return ra
        parent[rb]=ra
        group_members[ra]|=group_members[rb]
        group_members.pop(rb)
        value.pop(rb)
        return ra
    output=[]
    for cmd in commands:
        parts=cmd.split()
        if parts[0]=="UPDATE":
            if len(parts)==4:
                r,c,v=int(parts[1]),int(parts[2]),parts[3]
                i=cid(r,c)
                ri=find(i)
                value[ri]=v
            else:
                v,c=parts[1],parts[2]
                for rt in list(group_members.keys()):
                    if value.get(rt)==v:
                        value[rt]=c
        elif parts[0]=="MERGE":
            r1,c1,r2,c2=int(parts[1]),int(parts[2]),int(parts[3]),int(parts[4])
            i1,i2=cid(r1,c1),cid(r2,c2)
            ra,rb=find(i1),find(i2)
            if ra==rb:
                continue
            va,vb=value.get(ra),value.get(rb)
            new_root=union(ra,rb)
            if va is not None:
                value[new_root]=va
            elif vb is not None:
                value[new_root]=vb
            else:
                value[new_root]=None
        elif parts[0]=="UNMERGE":
            r,c=int(parts[1]),int(parts[2])
            i=cid(r,c)
            ri=find(i)
            keep_val=value.get(ri)
            members=list(group_members[ri])
            for m in members:
                parent[m]=m
                group_members[m]=set([m])
                value[m]=None
            value[i]=keep_val
        elif parts[0]=="PRINT":
            r,c=int(parts[1]),int(parts[2])
            i=cid(r,c)
            ri=find(i)
            v=value.get(ri)
            output.append(v if v is not None else "EMPTY")
    return output
