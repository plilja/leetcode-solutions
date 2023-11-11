class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 0
        nums_sorted = list(sorted(nums))
        return max(b - a for a, b in zip(nums_sorted, nums_sorted[1:]))
