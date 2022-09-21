class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        ans=[]
        st=set()
        sm=0
        for i in range(len(nums)) : 
            if nums[i]%2==0 : 
                sm+=nums[i]
                st.add(i)
        for query in queries : 
            [val,idx]=query
            if nums[idx]%2==0 : 
                sm-=nums[idx]
            nums[idx]+=val
            if nums[idx]%2==0 : 
                sm+=nums[idx]
            ans.append(sm)
        return ans
        