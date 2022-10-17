/*
ABA

A AB ABA = 1 + 2 + 1
B BA = 1 + 2
A = 1


1*8 + 2*1 + 1*5 + 4*5 + 5*4 + 6*3 + 7*2 + 5*1
*/
class Solution {
    public int uniqueLetterString(String s) {
        Map<Character, TreeSet<Integer>> charToIndexes = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            charToIndexes.computeIfAbsent(c, k -> new TreeSet<>()).add(i);
        }
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            TreeSet<Integer> indexes = charToIndexes.get(c);
            Integer prev = indexes.floor(i - 1);
            if (prev == null) {
                prev = -1;
            }
            Integer next = indexes.ceiling(i + 1);
            if (next == null) {
                next = s.length();
            }
            int left = i - prev;
            int right = next - i;
            result += left * right;
        }
        return result;
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    public int uniqueLetterString2(String s) {
        int result = 0;
        for (char c = 'A'; c <= 'Z'; ++c) {
            List<Integer> indexes = new ArrayList<>();
            for (int i = 0; i < s.length(); ++i) {
                char c2 = s.charAt(i);
                if (c2 == c) {
                    indexes.add(i);
                }
            }
            if (!indexes.isEmpty()) {
                if (indexes.size() == 1) {
                    int idx = indexes.get(0);
                    result += (idx + 1) * (s.length() - idx);
                } else {
                    int prev = 0;
                    for (int i = 0; i < indexes.size(); ++i) {
                        int idx = indexes.get(i);
                        int next = s.length() - 1;
                        if (i + 1 < indexes.size()) {
                            next = indexes.get(i + 1) - 1;
                        }
                        result += (idx - prev + 1) * (next - idx + 1);
                        prev = idx + 1;
                    }
                }
            }
        }
        return result;
    }
}
