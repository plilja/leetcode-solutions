class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactMatch = new HashSet<>();
        Map<String, String> caseMatch = new HashMap<>();
        Map<String, String> vowelMatch = new HashMap<>();
        for (int i = wordlist.length - 1; i >= 0; --i) {
            String w = wordlist[i];
            exactMatch.add(w);
            caseMatch.put(w.toLowerCase(), w);
            vowelMatch.put(wildcardVowels(w), w);
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            String query = queries[i];
            String queryLower = query.toLowerCase();
            String queryWildcarded = wildcardVowels(query);
            if (exactMatch.contains(query)) {
                result[i] = query;
            } else if (caseMatch.containsKey(queryLower)) {
                result[i] = caseMatch.get(queryLower);
            } else if (vowelMatch.containsKey(queryWildcarded)) {
                result[i] = vowelMatch.get(queryWildcarded);
            } else {
                result[i] = "";
            }
        }
        return result;
    }
    
    private String wildcardVowels(String s) {
        StringBuilder result = new StringBuilder();
        String lowered = s.toLowerCase();
        for (int i = 0; i < lowered.length(); ++i) {
            char c = lowered.charAt(i);
            if ("aeiou".indexOf(c) != -1) {
                result.append("*");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}