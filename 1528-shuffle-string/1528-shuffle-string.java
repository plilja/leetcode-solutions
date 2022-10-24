class Solution {
    public String restoreString(String s, int[] indices) {
        char[] result = new char[indices.length];
        for (int i = 0; i < indices.length; ++i) {
            int idx = indices[i];
            result[idx] = s.charAt(i);
        }
        return new String(result);
    }
}