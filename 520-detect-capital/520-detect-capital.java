class Solution {
    public boolean detectCapitalUse(String word) {
        String lowered = word.toLowerCase();
        if (word.equals(lowered)) {
            return true;
        }
        String uppered = word.toUpperCase();
        if (word.equals(uppered)) {
            return true;
        }
        return word.charAt(0) == uppered.charAt(0)
            && word.substring(1).equals(lowered.substring(1));    
    }
}
