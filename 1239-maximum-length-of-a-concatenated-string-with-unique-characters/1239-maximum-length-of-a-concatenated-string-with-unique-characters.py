class Solution:
        
    def maxLength(self, arr: List[str]) -> int:
        
        def _maxLength(arr,chars,idx) :
            if idx==len(arr) : 
                return len(chars)
            pick=0
            noPick=0
            containsUnique=True
            for char in arr[idx] : 
                if char in chars : 
                    containsUnique=False
                    break
            if containsUnique and len(arr[idx])==len(set(arr[idx])) : 
                pick=_maxLength(arr,chars|set(arr[idx]),idx+1)
            noPick=_maxLength(arr,chars,idx+1)
            return max(pick,noPick)
        return _maxLength(arr,set(),0)