class Solution {
    public int minimumOneBitOperations(int n) {

        if(n == 0) {
            return 0;
        }
        int residue = 0;
        int powerOf2 = 1;
        while(n > 0) {
            if(n%2 != 0) {
                if(n/2 > 0) {
                    residue += powerOf2;
                }            
            }
            powerOf2 = powerOf2 * 2;
            n = n/2;
        }
        return powerOf2 - 1 - minimumOneBitOperations(residue);   
    }
}
