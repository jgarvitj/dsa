class Solution {
    public int minimumLength(String s) {
        int p0 = 0;
        int p1 = s.length() - 1;

        while (p1 > p0 && s.charAt(p0) == s.charAt(p1)) {
            while (p1 > (p0 + 1) && s.charAt(p0 + 1) == s.charAt(p0)) {
                p0++;
            }
            while (p1 - 1 > p0 && s.charAt(p1 - 1) == s.charAt(p1)) {
                p1--;
            }
            p0++;
            p1--;
        }
        return p1-p0+1;
    }
}
