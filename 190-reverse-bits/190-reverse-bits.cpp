class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t result = 0;
        for (int i = 0; i < 32; ++i) {
            uint32_t bit1 = 1 << i;
            uint32_t bit2 = 1 << (31 - i);
            if ((n & bit1) != 0) {
                result |= bit2;
            }
        }
        return result;
    }
};