class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = -1;
        int[] closestLeft = new int[houses.length];
        for (int i = 0; i < houses.length; ++i) {
            int house = houses[i];
            while (left + 1 < heaters.length && heaters[left + 1] <= house) {
                left++;
            }
            if (left < 0 || left >= heaters.length) {
                closestLeft[i] = Integer.MAX_VALUE;
            } else {
                closestLeft[i] = house - heaters[left];
            }
        }
        int right = heaters.length;
        int[] closestRight = new int[houses.length];
        for (int i = houses.length - 1; i >= 0; --i) {
            int house = houses[i];
            while (right - 1 >= 0 && heaters[right - 1] >= house) {
                right--;
            }
            if (right < 0 || right >= heaters.length) {
                closestRight[i] = Integer.MAX_VALUE;
            } else {
                closestRight[i] = heaters[right] - house;
            }
        }
        int result = 0;
        for (int i = 0; i < houses.length; ++i) {
            result = Math.max(result, Math.min(closestLeft[i], closestRight[i]));
        }
        return result;
    }
}