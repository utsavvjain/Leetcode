class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        def feas(days) : 
            bq=0
            flower=0
            for i in bloomDay : 
                if i> days : 
                    flower=0
                else : 
                    flower+=1
                if flower>=k : 
                    bq+=1
                    flower=0
            return m<=bq
        
        if(m*k>len(bloomDay)) : 
            return -1
        left=1
        right=max(bloomDay)
        while left<right : 
            mid=left+(right-left)//2
            if feas(mid) : 
                right=mid
            else : 
                left=mid+1
        return left
        