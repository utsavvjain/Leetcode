class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        def getZero(mat) : 
            zero=[]
            n=len(mat)
            for i in range(n) : 
                for j in range(n) :
                    if mat[i][j]==1 : 
                        zero.append((i,j)) 
            return zero
        aZero=getZero(img1)
        bZero=getZero(img2)
        points=collections.defaultdict(int)
        ans=0
        for a in aZero : 
            for b in bZero : 
                t=(b[0]-a[0],b[1]-a[1])
                points[t]+=1
                ans=max(points[t],ans)
        return ans
