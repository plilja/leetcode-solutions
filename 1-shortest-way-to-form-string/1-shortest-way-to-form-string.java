class Solution {
    public int shortestWay(String source, String target) {
        int targetPointer = 0;
        boolean progress = true;
        int result = 0;
        while (progress && targetPointer < target.length()) {
            progress = false;
            result++;
            for (int i = 0; i < source.length() && targetPointer < target.length(); ++i) {
                char cSource = source.charAt(i);
                char cTarget = target.charAt(targetPointer);
                if (cSource == cTarget) {
                    targetPointer++;
                    progress = true;
                }
            }
        }
        
        if (progress) {
            return result;
        } else {
            return -1;
        }
    }
}
