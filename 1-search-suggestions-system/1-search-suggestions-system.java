class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TreeSet<String> productsSorted = new TreeSet<>();
        for (String product : products) {
            productsSorted.add(product);
        }
        List<List<String>> result = new ArrayList<>();
        StringBuilder partialSearchWord = new StringBuilder();
        for (int i = 0; i < searchWord.length(); ++i) {
            partialSearchWord.append(searchWord.charAt(i));
            var subSet = productsSorted.tailSet(partialSearchWord.toString(), true);
            List<String> subSearch = new ArrayList<>();
            for (String partialMatch : subSet) {
                if (subSearch.size() == 3 || !partialMatch.startsWith(partialSearchWord.toString())) {
                    break;
                }
                subSearch.add(partialMatch);
            }
            result.add(subSearch);
            
        }
        return result;
    }
    
}
