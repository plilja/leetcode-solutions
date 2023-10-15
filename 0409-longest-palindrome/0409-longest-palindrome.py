from collections import Counter

class Solution:
    def longestPalindrome(self, s: str) -> int:
        c = Counter(s)
        odd_used = False
        result = 0
        for _, count in reversed(c.most_common()):
            if count % 2 == 1:
                if not odd_used:
                    odd_used = True
                    result += count
                else:
                    result += count - 1
            else:
                result += count
        return result

