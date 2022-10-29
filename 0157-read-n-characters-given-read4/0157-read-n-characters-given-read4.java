/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    private Deque<Character> buffer = new ArrayDeque<>();
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int rem = n;
        int i = 0;
        while (!buffer.isEmpty() && rem > 0) {
            buf[i] = buffer.pollFirst();
            rem--;
            i++;
        }
        while (rem > 0) {
            int read = read4(buf4);
            if (read == 0) {
                break;
            }
            for (int j = 0; j < read; ++j) {
                buffer.add(buf4[j]);
            }
            while (!buffer.isEmpty() && rem > 0) {
                buf[i] = buffer.pollFirst();
                rem--;
                i++;
            }
        }
        return n - rem;
    }
}