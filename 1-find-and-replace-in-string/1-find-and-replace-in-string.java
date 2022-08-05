class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        TreeMap<Integer, String> indexToSource = new TreeMap<>();
        TreeMap<Integer, String> indexToTarget = new TreeMap<>();
        for (int i = 0; i < indices.length; ++i) {
            int idx = indices[i];
            String source = sources[i];
            String target = targets[i];
            indexToSource.put(idx, source);
            indexToTarget.put(idx, target);
        }
        StringBuilder result = new StringBuilder();
        int previousEnd = 0;
        for (int idx : indexToSource.keySet()) {
            for (int j = previousEnd; j < idx; ++j) {
                result.append(s.charAt(j));
            }
            String source = indexToSource.get(idx);
            String target = indexToTarget.get(idx);
            boolean matches = true;
            for (int j = 0; j < source.length() && matches; ++j) {
                if (idx + j >= s.length()) {
                    matches = false;
                } else {
                    matches = s.charAt(idx + j) == source.charAt(j);
                }
            }
            if (matches) {
                result.append(target);
            } else {
                for (int j = 0; j < source.length(); ++j) {
                    if (idx + j < s.length()) {
                        result.append(s.charAt(idx + j));
                    } else {
                        break;
                    }
                }
            }
            previousEnd = idx + source.length();
        } 
        
        for (int j = previousEnd; j < s.length(); ++j) {
            result.append(s.charAt(j));
        }
        
        return result.toString();
    }
}
