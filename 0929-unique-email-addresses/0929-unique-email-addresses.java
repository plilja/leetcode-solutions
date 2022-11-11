class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            uniqueEmails.add(normalize(email));
        }
        return uniqueEmails.size();
    }
    
    private String normalize(String email) {
        String[] args = email.split("@");
        String localName = args[0];
        int plusIdx = localName.indexOf("+");
        if (plusIdx != -1) {
            localName = localName.substring(0, plusIdx);
        }
        localName = localName.replaceAll("\\.", "");
        String domainName = args[1];
        return localName + "@" + domainName;
    }
}