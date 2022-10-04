class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < guess.length(); ++i) {
            counts.merge(secret.charAt(i), 1, (a, b) -> a + b);
        }
        int bulls = 0;
        for (int i = 0; i < guess.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                counts.merge(secret.charAt(i), -1, (a, b) -> a + b);
            }
        }
        int cows = 0;
        for (int i = 0; i < guess.length(); ++i) {
            char c = guess.charAt(i);
            if (secret.charAt(i) != c && counts.getOrDefault(c, 0) > 0) {
                cows++;
                counts.merge(c, -1, (a, b) -> a + b);
            }
        }
        return "%dA%dB".formatted(bulls, cows);
    }
}