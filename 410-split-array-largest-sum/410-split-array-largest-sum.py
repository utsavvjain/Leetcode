class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        def predicate(mid,nums,n) : 
            cnt=1
            total=0
            for i in nums : 
                total+=i
                if total>mid : 
                    cnt+=1
                    total=i
                if cnt>m : return False
            return True
        
        low=max(nums) 
        high=sum(nums)
        while low<high : 
            mid=low+(high-low)//2
            if predicate(mid,nums,m) : 
                high=mid
            else : 
                low=mid+1                
        return low
        