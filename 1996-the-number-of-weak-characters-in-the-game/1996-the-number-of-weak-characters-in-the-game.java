class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] - b[0]);
        int maxDefence = -1;
        int memory = -1;
        int prevAttack = -1;
        int result = 0;
        for (int i = properties.length - 1; i >= 0; --i) {
            int attack = properties[i][0];
            int defence = properties[i][1];
            if (attack != prevAttack) {
                maxDefence = Math.max(maxDefence, memory);
                prevAttack = attack;
                memory = -1;
            }
            if (defence < maxDefence) {
                result++;
            }
            memory = Math.max(memory, defence);
        }
        return result;
        
    }
}