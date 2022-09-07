class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n=len(nums)
        nums=sorted(list(set(nums)))
        l=0
        ans=float('inf')
        for r in range(len(nums)) : 
            while l<len(nums) and nums[l]-nums[r]<=n-1 : l+=1
            ans=min(ans,n+r-l)
        return ans
            
            