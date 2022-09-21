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
            if query[1] not in st : 
                nums[query[1]]+=query[0]
                if nums[query[1]]%2==0 : 
                    st.add(query[1])
                    sm+=nums[query[1]]
            else : 
                b=nums[query[1]]
                a=nums[query[1]]+query[0]
                nums[query[1]]=a
                sm-=b
                if a%2==0 : 
                    sm+=a
                else : 
                    st.discard(query[1])
            ans.append(sm)
        return ans
        