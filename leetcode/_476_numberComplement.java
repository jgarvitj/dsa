class Solution {
    public int findComplement(int num) {
        int complement = 0;
        int factorOf2 = 1;
        while(num > 0) {
            complement = (num)%2 == 0 ? complement  + factorOf2 : complement;
            factorOf2 = factorOf2 *2;
            num = num/2;
        }
        return complement;
    }
}
