class Solution {
    public int flipLights(int n, int presses) {
        Set<String> combos = new HashSet<>();
        for (boolean press1ButtonOddTimes : List.of(true, false)) { 
            for (boolean press2ButtonOddTimes : List.of(true, false)) {
                for (boolean press3ButtonOddTimes : List.of(true, false)) {
                    for (boolean press4ButtonOddTimes : List.of(true, false)) {
                        int remPresses = presses;
                        if (press1ButtonOddTimes) {
                            remPresses--;
                        }
                        if (press2ButtonOddTimes) {
                            remPresses--;
                        }
                        if (press3ButtonOddTimes) {
                            remPresses--;
                        }
                        if (press4ButtonOddTimes) {
                            remPresses--;
                        }
                        if (remPresses < 0) {
                            continue;
                        }
                        if (remPresses % 2 == 0) {
                            // Need to distribute remPresses even on button 1 even on button 2 and even on button 3 and even on button 4
                            // This is only possible if remaining presses is even
                            StringBuilder sb = new StringBuilder();
                            for (int i = 1; i <=n; i++) {
                                boolean on = true;
                                if (press1ButtonOddTimes) {
                                    on = !on;
                                }
                                if (press2ButtonOddTimes && i % 2 == 0) {
                                    on = !on;
                                }
                                if (press3ButtonOddTimes && i % 2 == 1) {
                                    on = !on;
                                }
                                if (press4ButtonOddTimes && (i - 1) % 3 == 0) {
                                    on = !on;
                                }
                                sb.append(on ? '1' : '0');
                            }
                            combos.add(sb.toString());
                        }
                    }
                }
            }
        }
        return combos.size();
    }
}
