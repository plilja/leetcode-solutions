class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long[] result = new long[regular.length];
        long minRegular = 0;
        long minExpress = expressCost;
        for (int i = 0; i < regular.length; ++i) {
            long r = regular[i];
            long e = express[i];
            long newMinRegular = Math.min(
                                    Math.min(
                                        minRegular + r,
                                        minExpress + r
                                    ),
                                    minExpress + e 
                                );
            long newMinExpress = Math.min(
                                    Math.min(
                                        minRegular + r + expressCost,
                                        minExpress + r + expressCost
                                    ),
                                    minExpress + e
                                );
            minRegular = newMinRegular;
            minExpress = newMinExpress;
            result[i] = Math.min(minRegular, minExpress);
        }
        return result;
    }
}