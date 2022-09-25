class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        maxi=max(nums)
        count=0
        ans=1
        for i in nums : 
            if i==maxi : 
                count+=1
            else : 
                count=0
            ans=max(ans,count)
        return ans