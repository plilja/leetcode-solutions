from collections import deque
from math import gcd


class Solution:
    def fractionAddition(self, expression: str) -> str:
        res_num, res_den = 0, 1
        rem = deque(expression)
        while rem:
            print(rem)
            num, den = self.parse_one_fraction(rem)
            res_num = res_num * den + num * res_den
            print(num, den)
            res_den *= den
            g = gcd(res_num, res_den)
            res_num //= g
            res_den //= g
        return f'{res_num}/{res_den}'

    def parse_one_fraction(self, rem: deque):
        c = rem[0]
        if c == '-':
            rem.popleft()
            num, den = self.parse_one_fraction(rem)
            return -num, den
        elif c == '+':
            rem.popleft()
            return self.parse_one_fraction(rem)
        num = self.parse_num(rem)
        if rem and rem[0] == '/':
            rem.popleft()
            den = self.parse_num(rem)
        else:
            den = 1
        return num, den

    def parse_num(self, rem: deque):
        num = ''
        while rem and '0' <= rem[0] <= '9':
            c = rem.popleft()
            num += c
        return int(num)
