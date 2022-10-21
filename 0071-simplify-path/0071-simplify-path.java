class Solution {
    private static List<String> NO_OPS = List.of(
        "",
        "."
    );
    
    public String simplifyPath(String path) {
        String[] args = path.split("/");
        Deque<String> parts = new ArrayDeque<>();
        for (String arg : args) {
            if (!NO_OPS.contains(arg)) {
                if ("..".equals(arg)) {
                    if (!parts.isEmpty()) {
                        parts.pollLast();
                    }
                } else {
                    parts.add(arg);
                }
            }
        }
        StringBuilder result = new StringBuilder("/");
        for (String dir : parts) {
            result.append(dir);
            result.append("/");
        }
        if (result.length() > 1) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
}