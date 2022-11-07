class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort tall people first
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return p2[0] - p1[0];
            } else {
                return p1[1] - p2[1];
            }
        });
        
        int[][] result = new int[people.length][];
        for (int i = 0; i < people.length; ++i) {
            int[] person = people[i];
            int h = person[0];
            int k = person[1]; // number of people before that are taller
            insert(result, k, person, i - 1);
        }
        return result;
    }
    
    private void insert(int[][] result, int position, int[] person, int lastIndex) {
        if (lastIndex >= 0) {
            for (int j = lastIndex + 1; j > position; --j) {
                result[j] = result[j - 1];
            }
        }
        result[position] = person;
    }
}