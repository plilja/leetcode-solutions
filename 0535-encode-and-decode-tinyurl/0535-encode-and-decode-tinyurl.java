public class Codec {
    
    private int nextShort = 0;
    private final Map<String, String> shortToLong = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        shortToLong.put(String.valueOf(nextShort), longUrl);
        return String.valueOf(nextShort++);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));