class Solution(object):
    def longestOnes(self, nums, k):
        l=0
        zCnt=0
        ans=0
        for r in range(len(nums)) :
            if nums[r]==0 : 
                zCnt+=1
            while zCnt>k : 
                if nums[l]==0 : 
                    zCnt-=1
                l+=1
            ans=max(ans,r-l+1)
        return ans
                
            