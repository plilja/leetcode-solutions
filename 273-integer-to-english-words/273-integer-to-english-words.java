/*

10^9 = Billion
10^9 + 1 = One Billion One
10^8 = One Hundred Million
10^7 = Ten Million
10^6 = One Million
10^5 = One Hundred Thousand
10^4 = Ten Thousand
10^3 = One Thousand
10^2 = One Hundred
10^1 = Ten

*/
class Solution {
    private static final Map<Integer, String> DIGITS = Map.of(
        0, "Zero",
        1, "One",
        2, "Two",
        3, "Three",
        4, "Four",
        5, "Five",
        6, "Six",
        7, "Seven",
        8, "Eight",
        9, "Nine"
    );
    private static final Map<Integer, String> TENS = Map.of(
        20, "Twenty",
        30, "Thirty",
        40, "Forty",
        50, "Fifty",
        60, "Sixty",
        70, "Seventy",
        80, "Eighty",
        90, "Ninety"
    );
    private static final Map<Integer, String> TEN_TO_TWENTY = Map.of(
        10, "Ten",
        11, "Eleven",
        12, "Twelve",
        13, "Thirteen",
        14, "Fourteen",
        15, "Fifteen",
        16, "Sixteen",
        17, "Seventeen",
        18, "Eighteen",
        19, "Nineteen"
    );
    
    public String numberToWords(int num) {
        if (num >= 1000000000) {
            int count = num / 1000000000;
            int rem = num % 1000000000;
            return numberToWords(count) + " Billion" + numberToWordsIfNotZero(" ", rem);
        } else if (num >= 1000000) {
            int count = num / 1000000;
            int rem = num % 1000000;
            return numberToWords(count) + " Million" + numberToWordsIfNotZero(" ", rem);
        } else if (num >= 1000) {
            int count = num / 1000;
            int rem = num % 1000;
            return numberToWords(count) + " Thousand" + numberToWordsIfNotZero(" ", rem);
        } else if (num >= 100) {
            int count = num / 100;
            int rem = num % 100;
            return numberToWords(count) + " Hundred" + numberToWordsIfNotZero(" ", rem);
        } else if (num >= 20) {
            int count = 10 * (num / 10);
            int rem = num % 10;
            return TENS.get(count) + numberToWordsIfNotZero(" ", rem);
        }  else if (num >= 10) {
            return TEN_TO_TWENTY.get(num);
        } else {
            return DIGITS.get(num);
        }
    }
    
    private String numberToWordsIfNotZero(String prefix, int num) {
        if (num != 0) {
            return prefix + numberToWords(num);
        } else {
            return "";
        }
    }
}
