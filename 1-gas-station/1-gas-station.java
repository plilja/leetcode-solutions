class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int acc = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; ++i) {
            tank += gas[i] - cost[i];
            acc += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        if (acc >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}
