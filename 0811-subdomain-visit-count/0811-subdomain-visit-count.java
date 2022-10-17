class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainCount = new HashMap<>();
        for (String cpd : cpdomains) {
            String[] args = cpd.split(" ");
            int count = Integer.parseInt(args[0]);
            String subDomain = "";
            String[] subDomainParts = args[1].split("\\.");
            for (int i = subDomainParts.length - 1; i >= 0; --i) {
                if (subDomain.isEmpty()) {
                    subDomain = subDomainParts[i];
                } else {
                    subDomain = subDomainParts[i] + "." + subDomain;
                }
                domainCount.merge(subDomain, count, (a, b) -> a + b);
            }
        }
        List<String> result = new ArrayList<>();
        for (var entry : domainCount.entrySet()) {
            String domain = entry.getKey();
            int count = entry.getValue();
            result.add("%d %s".formatted(count, domain));
        }
        return result;
    }
}
