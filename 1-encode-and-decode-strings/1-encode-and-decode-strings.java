public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append(len);
            sb.append("-");
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while (i < s.length()) {
            int idx = s.indexOf("-", i);
            String sub = s.substring(i, idx);
            int numChars = Integer.parseInt(sub);
            i = idx + 1 + numChars;
            result.add(s.substring(idx + 1, i));
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
