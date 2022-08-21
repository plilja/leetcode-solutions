class Solution {
    private record WebsiteVisit(int timestamp, String website) implements Comparable<WebsiteVisit> {
        @Override
        public int compareTo(WebsiteVisit other) {
            if (timestamp != other.timestamp) {
                return timestamp - other.timestamp;
            } else {
                return website.compareTo(other.website);
            }
        }
    }
    
    public List<String> mostVisitedPattern(String[] usernames, int[] timestamps, String[] websites) {
        Map<String, List<WebsiteVisit>> userToVisits = new HashMap<>();
        for (int i = 0; i < usernames.length; ++i) {
            String username = usernames[i];
            int timestamp = timestamps[i];
            String website = websites[i];
            userToVisits.computeIfAbsent(username, k -> new ArrayList<>()).add(new WebsiteVisit(timestamp, website));
        }
        
        for (List<WebsiteVisit> visits : userToVisits.values()) {
            Collections.sort(visits);
        }
        
        Map<String, Integer> patternCount = new HashMap<>();
        for (List<WebsiteVisit> userVisits : userToVisits.values()) {
            Set<String> userPatterns = new HashSet<>();
            for (int i = 0; i < userVisits.size(); ++i) {
                String site1 = userVisits.get(i).website();
                for (int j = i + 1; j < userVisits.size(); ++j) {
                    String site2 = userVisits.get(j).website();
                    for (int k = j + 1; k < userVisits.size(); ++k) {
                        String site3 = userVisits.get(k).website();
                        String key = "%s-%s-%s".formatted(site1, site2, site3);
                        userPatterns.add(key);
                    }
                }
            }
            for (String key : userPatterns) {
                patternCount.merge(key, 1, (a, b) -> a + b);
            }
        }
        String bestKey = "";
        int bestKeyCount = 0;
        for (var entry : patternCount.entrySet()) {
            if (entry.getValue() > bestKeyCount || (entry.getValue() == bestKeyCount && entry.getKey().compareTo(bestKey) < 0)) {
                bestKey = entry.getKey();
                bestKeyCount = entry.getValue();
            }
        }
        List<String> result = new ArrayList<>();
        for (String website : bestKey.split("-")) {
            result.add(website);
        }
        return result;
    }
}
