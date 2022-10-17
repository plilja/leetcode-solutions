class Solution {
    public String findDifferentBinaryString(String[] numsArr) {
        int n = numsArr[0].length();
        Set<String> nums = new HashSet<>();
        for (String num : numsArr) {
            nums.add(num);
        }
        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            zeros.append('0');
        }
        int num = 0;
        while (true) {
            StringBuilder numBuilder = new StringBuilder(zeros);
            numBuilder.append(Integer.toBinaryString(num));
            String binaryString = numBuilder.substring(numBuilder.length() - n, numBuilder.length());
            if (!nums.contains(binaryString)) {
                return binaryString;
            }
            num++;
        }
    }
}