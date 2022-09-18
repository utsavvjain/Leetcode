class Solution:
    def trap(self, height: List[int]) -> int:
        sz=len(height)
        prefixSum=[0 for i in range(sz)]
        suffixSum=[0 for i in range(sz)]
        prefixSum[0]=height[0]
        suffixSum[sz-1]=height[sz-1]
        for i in range(1,sz) : 
            prefixSum[i]=max(prefixSum[i-1],height[i])
        for i in range(sz-2,-1,-1) : 
            suffixSum[i]=max(suffixSum[i+1],height[i])
            
        ans=0
        for i in range(sz) : 
            ans+=min(prefixSum[i],suffixSum[i])-height[i]
        return ans