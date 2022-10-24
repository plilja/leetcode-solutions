class Solution {
    public int rotatedDigits(int n) {
        int result = 0;
        for (int i = 1; i <= n; ++i) {
            if (isGood(i)) {
                result++;
            }
        }
        return result;
    }
    
    private boolean isGood(int m) {
        StringBuilder sb = new StringBuilder();
        int b = m;
        while (b != 0) {
            int d = b % 10;
            switch (d) {
                case 0:
                case 1:
                case 8:
                    sb.append(d);
                    break;
                case 2:
                    sb.append(5);
                    break;
                case 5:
                    sb.append(2);
                    break;
                case 6:
                    sb.append(9);
                    break;
                case 9:
                    sb.append(6);
                    break;
                case 3:
                case 4:
                case 7:
                    return false;
            }
            b /= 10;
        }
        sb.reverse();
        return Integer.parseInt(sb.toString()) != m;
    }
}