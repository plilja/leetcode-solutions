/*
[t,h,e, ,s,k,y, ,i,s, ,b,l,u,e]
[b,l,u,e,?,?,?,?,?,?,?, ,t,h,e]
[b,l,u,e, ,i,s,?,s,k,y, ,t,h,e]

[the white rabbit ran across the field]
[ield????????????????????????????? the]
[field the ????????????????? white the]

[the white rabbit ran across the field]
[field ?????????????????????????wh the]

[the white rabbit ran across the field]
[dlei????????????????????????????? eht]
[dleif eht ssorca nar tibbar etihw eht]
*/
class Solution {
    public void reverseWords(char[] s) {
        reverseBetween(s, 0, s.length - 1);
        int left = 0;
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == ' ') {
                reverseBetween(s, left, i - 1);
                left = i + 1;
            }
        }
        reverseBetween(s, left, s.length - 1);
    }
    
    private void reverseBetween(char[] s, int start, int end) {
        for (int j = 0; j + start <= end; ++j) {
            if (start + j < end - j) {
                swap(s, start + j, end - j);
            }
        }
    }
    
    private void swap(char[] s, int i, int j) {
        char iTmp = s[i];
        s[i] = s[j];
        s[j] = iTmp;
    }
}