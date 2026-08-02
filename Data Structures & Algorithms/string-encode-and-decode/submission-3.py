class Solution:

    def encode(self, strs: List[str]) -> str:
        res = []
        for s in strs:
            res.append(str(len(s)))
            res.append("#")
            res.append(s)
        
        return "".join(res)

    def decode(self, s: str) -> List[str]:
        i = 0
        res = []

        while i < len(s):
            j = i
            while s[j] != '#':
                j += 1
            
            length = int(s[i:j])
            # Move i to the start of the actual string content
            i = j + 1
            # Extract the string based on the parsed length
            res.append(s[i : i + length])
            # Move i to the start of the next encoded segment
            i = i + length

        return res
