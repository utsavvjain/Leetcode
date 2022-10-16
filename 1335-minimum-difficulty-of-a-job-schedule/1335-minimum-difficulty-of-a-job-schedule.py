class Solution:
    def minDifficulty(self, jobDifficulty: List[int], d: int) -> int:
        n=len(jobDifficulty)
        if d> len(jobDifficulty) : 
            return -1
        
        @lru_cache(None)
        def _minDifficulty(idx,d) : 
            if d==1 : 
                return max(jobDifficulty[idx:])
            ans=float('inf')
            maxi=0
            for i in range(idx,n-d+1) : 
                maxi=max(maxi,jobDifficulty[i])
                ans=min(ans,maxi+_minDifficulty(i+1,d-1))
            return ans
        return _minDifficulty(0,d)
        