class Solution(object):
    def characterReplacement(self, s, k):
        l=0
        freq={}
        ans=0
        for r in range(len(s)) : 
            freq[s[r]]=freq.get(s[r],0)+1
            if r-l+1-max(freq.values())>k :
                freq[s[l]]-=1
                l+=1
            ans=max(ans,r-l+1)
        return ans
                
                