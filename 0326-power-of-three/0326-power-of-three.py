class Solution:
    def isPowerOfThree(self, n: int):
        if n <= 0:
            return False
        v = round(log(n, 3))
        return 3 ** v == n