class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        dirc=defaultdict(list)
        for path in paths : 
            lst=path.split(" ")
            n=len(lst)
            if n==0 : continue
            pth=lst[0]
            for i in lst[1:] : 
                i=i.split(".txt")
                dirc[i[1]].append(f"{pth}/{i[0]}.txt")
        ans=[]
        for i in dirc : 
            if len(dirc[i])==1 : continue
            ans.append(dirc[i])
        return ans
        