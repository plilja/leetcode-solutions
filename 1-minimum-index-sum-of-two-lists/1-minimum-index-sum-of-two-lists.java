class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int minIndexSum = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list1.length; ++i) {
            String s = list1[i];
            for (int j = 0; j < list2.length; ++j) {
                String t = list2[j];
                if (s.equals(t)) {
                    if (i + j == minIndexSum) {
                        result.add(s);
                    } else if (i + j < minIndexSum) {
                        minIndexSum = i + j;
                        result.clear();
                        result.add(s);
                    }
                }
            }
        }
        return result.toArray(new String[]{});
    }
}
