class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void solve(String s, int i, List<Integer> current, List<String> result) {
        if (i == s.length()) {
            if (current.size() == 4) {
                StringBuilder ip = new StringBuilder();
                for (int num : current) {
                    if (ip.length() > 0) {
                        ip.append(".");
                    }
                    ip.append(num);
                }
                result.add(ip.toString());
            }
        } else if (current.size() < 4) {
            for (int j = i + 1; j <= s.length(); ++j) {
                String sub = s.substring(i, j);
                if (sub.length() > 1 && sub.charAt(0) == '0') {
                    break;
                }
                if (sub.length() > 3) {
                    break;
                }
                int num = Integer.parseInt(sub);
                if (num >= 0 && num <= 255) {
                    current.add(num);
                    solve(s, j, current, result);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}