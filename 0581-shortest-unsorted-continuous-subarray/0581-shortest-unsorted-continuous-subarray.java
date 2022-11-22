class Solution {
    public int findUnsortedSubarray(int[] nums) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            items.add(new Item(i, nums[i]));
        }
        items.sort((a, b) -> a.value - b.value);
        int startWrong = -1;
        int endWrong = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (items.get(i).index != i) {
                if (startWrong == -1) {
                    startWrong = i;
                }
                endWrong = i + 1;
            }
        }
        return endWrong - startWrong;
    }
    
    private record Item(int index, int value) {
    }
}