class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int inc = numRows + Math.max(0, numRows-2);
        
        
        for(int i = 0; i < numRows; i++) {
            if(i == 0 || i == numRows - 1) {
                for(int index = i; index < s.length(); index += inc) {
                    sb.append(s.charAt(index));   
                }
            }
            else {
                for(int index = i; index < s.length(); index += inc) {
                    sb.append(s.charAt(index));
                    int x = index / inc;
                    int y = (x + 1)*inc - index % inc;
                    if(y < s.length()) {
                        sb.append(s.charAt(y));
                    }
                }
            }
        }
        return sb.toString();
    }
}
