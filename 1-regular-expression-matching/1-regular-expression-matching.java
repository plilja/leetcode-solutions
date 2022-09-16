class Solution {
    public boolean isMatch(String s, String p) {
        List<String> subPatterns = tokenize(p);
        boolean[][] dp = new boolean[s.length()][subPatterns.size()];
        for (int i = subPatterns.size() - 1; i >= 0; --i) {
            String subPattern = subPatterns.get(i);
        }
    }
    
    private List<String> tokenize(String pattern) {
        List<String> result = new ArrayList<>();
        boolean lastSpecial = true;
        for (int i = 0; i < pattern.length(); ++i) {
            char c = pattern.charAt(i);
            if (c == '.') {
                result.add(".");
                lastSpecial = true;
            } else if (c == '*') {
                String last = result.get(result.size() - 1);
                if (last.length() == 1) {
                    result.set(result.size(), last + "*");
                } else {
                    result.set(result.size(), last.substring(0, last.length() - 1));
                    result.add(last.charAt(last.length() - 1) + "*");
                }
                lastSpecial = true;
            } else {
                if (lastSpecial) {
                    result.add("" + c);
                } else {
                    String last = result.get(result.size() - 1);
                    result.set(result.size() - 1, last + c);
                }
                lastSpecial = false;
            }
            
        }
        return result;
    }
    
    
    
    
    
    public boolean isMatch2(String s, String p) {
        return !tokenize2(p).getMatches(s).isEmpty();
    }
    
    private RegExp tokenize2(String pattern) {
        List<RegExp> result = new ArrayList<>();
        for (int i = 0; i < pattern.length(); ++i) {
            char c = pattern.charAt(i);
            if (c == '*') {
                var last = result.get(result.size() - 1);
                result.set(result.size() - 1, new StarMatcher(last));
            } else if (c == '.') {
                result.add(new DotMatcher());
            } else {
                result.add(new ExactPattern(c + ""));
            }
        }
        return new CompositeMatcher(result);
    }
    
    private interface RegExp {
        List<Sequence> getMatches(String s);
    }
    
    private static class CompositeMatcher implements RegExp {
        private final List<RegExp> regexps;
        
        CompositeMatcher(List<RegExp> regexps) {
            this.regexps = regexps;
        }
        
        @Override
        public List<Sequence> getMatches(String s) {
            boolean[][] dp = new boolean[s.length() + 1][regexps.size()];
            for (int i = regexps.size() - 1; i >= 0; --i) {
                var regExp = regexps.get(i);
                List<Sequence> matches = regExp.getMatches(s);
                for (var match : matches) {
                    if (i + 1 < regexps.size()) {
                        if (dp[match.to()][i + 1]) {
                            dp[match.from()][i] = true;
                        }
                    } else {
                        if (match.to() == s.length()) {
                            dp[match.from()][i] = true;
                        }
                    }
                }
            }
            if (dp[0][0]) {
                return List.of(new Sequence(0, s.length()));
            } else {
                return List.of();
            }
        }
    }
    
    private static class ExactPattern implements RegExp {
        private final String exact;
        
        ExactPattern(String exact) {
            this.exact = exact;
        }
        
        @Override
        public List<Sequence> getMatches(String s) {
            List<Sequence> result = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                int idx = s.indexOf(exact, i);
                if (idx == -1) {
                    break;
                }
                result.add(new Sequence(idx, idx + exact.length()));
                i = idx + exact.length();
            }
            return result;
        }
    }
    
    private static class DotMatcher implements RegExp {
        @Override
        public List<Sequence> getMatches(String s) {
            List<Sequence> result = new ArrayList<>();
            for (int i = 0; i < s.length(); ++i) {
                result.add(new Sequence(i, i + 1));
            }
            return result;
        }
    }
    
    private static class StarMatcher implements RegExp {
        private final RegExp other;
        
        StarMatcher(RegExp other) {
            this.other = other;
        }
        
        @Override
        public List<Sequence> getMatches(String s) {
            List<Sequence> result = new ArrayList<>();
            for (int i = 0; i <= s.length(); ++i) {
                result.add(new Sequence(i, i));
            }
            List<Sequence> otherMatches = other.getMatches(s);
            for (int i = 0; i < otherMatches.size(); ++i) {
                Set<Integer> idx = new HashSet<>();
                var match = otherMatches.get(i);
                reachable(match.to(), otherMatches, idx);
                for (int j : idx) {
                    result.add(new Sequence(match.from(), j));
                }
            }
            return result;
        }
        
        private void reachable(int to, List<Sequence> matches, Set<Integer> idx) {
            if (!idx.contains(to)) {
                idx.add(to);
                for (var match : matches) {
                    if (match.from() == to) {
                        reachable(match.to(), matches, idx);
                    }
                }
            }
        }
    }
    
    private record Sequence(int from, int to) {
    }
}
