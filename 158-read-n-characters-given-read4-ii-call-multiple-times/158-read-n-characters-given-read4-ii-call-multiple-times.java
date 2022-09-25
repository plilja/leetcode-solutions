/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */
public class Solution extends Reader4 {
    private Deque<Character> pendingReads = new ArrayDeque<>();
    
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int rem = n;
        int i = 0;
        while (!pendingReads.isEmpty() && rem > 0) {
            buf[i] = pendingReads.poll();
            i++;
            rem--;
        }
        char[] readBuffer = new char[4];
        while (rem > 0) {
            int numRead = read4(readBuffer);
            if (numRead == 0) {
                break;
            }
            int j = 0;
            for (; j < numRead && rem > 0; ++j) {
                buf[i] = readBuffer[j];
                rem--;
                i++;
            }
            for (; j < numRead; ++j) {
                pendingReads.add(readBuffer[j]);
            }
        }
        return n - rem;
    }
}