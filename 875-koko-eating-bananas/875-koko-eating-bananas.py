class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def f(mid) : 
            total=0
            for i in piles : 
                total+=ceil(i/mid)
            return total<=h
        right=max(piles)
        left=1
        while left<right : 
            mid=left+(right-left)//2
            if f(mid) : 
                right=mid
            else : 
                left=mid+1
        return left
        