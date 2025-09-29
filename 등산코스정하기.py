from collections import defaultdict
import heapq
INF=float('inf')
def solution(n, paths, gates, summits):
    graph=defaultdict(list)
    for path in paths:
        a,b,c=path[0],path[1],path[2]
        graph[a].append((b,c))
        graph[b].append((a,c))
        
    dist=[INF]*(n+1)
    dist[start]=0
    pq=[(0,start)]
    res=-1
    while pq:
        d,u=heapq.heappop(pq)
            if d!=dist[u]:
                continue
            if u in summits:
                continue
            for v,w in graph[u]:
                nd=d if d>=w else w
                if v in gate:
                    continue
                if nd<dist[v]:
                    dist[v]=nd
                    heapq.heappush(pq,(nd,v))
    output=[]
    for gate in gates:
        for summit in summits:
            res=dijkstra(gate,summit)
            output.append([summit,res])
    output.sort(key=lambda x: (x[1],x[0]))
    return output[0]
