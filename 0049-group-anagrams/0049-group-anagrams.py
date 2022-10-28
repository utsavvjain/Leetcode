class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mapOfWords=collections.defaultdict(list)
        for word in strs : 
            mapOfWords[''.join(sorted(word))].append(word)
        return mapOfWords.values()