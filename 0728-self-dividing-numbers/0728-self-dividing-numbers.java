class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            String s = String.valueOf(i);
            boolean selfDividing = true;
            for (int j = 0; j < s.length() && selfDividing; ++j) {
                int d = Integer.parseInt(s.charAt(j) + "");
                if (d == 0 || i % d != 0) {
                    selfDividing = false;
                }
            }
            if (selfDividing) {
                result.add(i);
            }
        }
        return result;
    }
}