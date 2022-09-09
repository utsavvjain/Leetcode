class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        properties.sort(key=lambda x : (-x[0], x[1]))
        ans=0
        maxi=0
        for _,defense in properties : 
            if defense < maxi :
                ans+=1
            else : 
                maxi=defense                
        return ans
        