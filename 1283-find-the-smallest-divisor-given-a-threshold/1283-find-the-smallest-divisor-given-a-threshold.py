class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        def feas(mid) : 
            sm1=0
            for i in nums : 
                sm1+=(i+mid-1)//mid
            return sm1<=threshold
        left=1
        right=max(nums)
        while left<right : 
            mid=left+(right-left)//2
            if feas(mid) : 
                right=mid
            else : 
                left=mid+1
        return left
        