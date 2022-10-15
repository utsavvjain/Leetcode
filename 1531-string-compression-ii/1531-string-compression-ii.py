class Solution:
    def getLengthOfOptimalCompression(self, s: str, k: int) -> int:
        @lru_cache(None)
        def _getLengthOfOptimalCompression(index,lastChar,length,k) : 
            if k<0 : 
                return float('inf')
            if index>=len(s) : 
                return 0
            delete=_getLengthOfOptimalCompression(index+1,lastChar,length,k-1)
            keep=0
            if(s[index]==lastChar) : 
                if(length in [1,9,99]) : 
                    keep=1
                keep+=_getLengthOfOptimalCompression(index+1,lastChar,length+1,k)
            else : 
                keep=1+_getLengthOfOptimalCompression(index+1,s[index],1,k)
            return min(delete,keep)
        return _getLengthOfOptimalCompression(0,'',0,k)

        