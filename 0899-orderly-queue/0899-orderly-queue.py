class Solution:
    def orderlyQueue(self, s: str, k: int) -> str:
        if k>1 : 
            return ''.join(sorted(s))
        else : 
            mini=s
            for i in range(len(s)) : 
                mini=min(mini,s[i:]+s[:i])
            return mini