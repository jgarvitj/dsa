class Solution {


    class RomanUnit {
        String roman;
        Integer nextNum;

        public RomanUnit(String roman, Integer nextNum) {
            this.roman = roman;
            this.nextNum = nextNum;
        }
    }

    public RomanUnit partConversionToRoman(String val, String prefix, int denomination, int prefixDenomination, int num) {

        StringBuilder sb = new StringBuilder();
        int nextNum = num%denomination;
        num = num/denomination;
        for(int i =0; i < num; i++) {
            sb.append(val);
        }
        if(nextNum / prefixDenomination > 0) {
            sb.append(prefix);
            sb.append(val);
            nextNum = nextNum - prefixDenomination;
        }
        
        return new RomanUnit(sb.toString(), nextNum);

    }

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        if(num >= 900) {
            RomanUnit romanInUnit = partConversionToRoman("M", "C", 1000, 900, num);
            sb.append(romanInUnit.roman);
            num = romanInUnit.nextNum;
        }
        if(num >= 400) {
            RomanUnit romanInUnit = partConversionToRoman("D", "C", 500, 400, num);
            sb.append(romanInUnit.roman);
            num = romanInUnit.nextNum;
        }
        if(num >= 90) {
            RomanUnit romanInUnit = partConversionToRoman("C", "X", 100, 90, num);
            sb.append(romanInUnit.roman);
            num = romanInUnit.nextNum;
        }
        if(num >= 40) {
            RomanUnit romanInUnit = partConversionToRoman("L", "X", 50, 40, num);
            sb.append(romanInUnit.roman);
            num = romanInUnit.nextNum;
        }
        if(num >= 9) {
            RomanUnit romanInUnit = partConversionToRoman("X", "I", 10, 9, num);
            sb.append(romanInUnit.roman);
            num = romanInUnit.nextNum;
        }
        if(num >= 4) {
            RomanUnit romanInUnit = partConversionToRoman("V", "I", 5, 4, num);
            sb.append(romanInUnit.roman);
            num = romanInUnit.nextNum;
        }
        if(num >= 1) {
            RomanUnit romanInUnit = partConversionToRoman("I", "error", 1, Integer.MAX_VALUE, num);
            sb.append(romanInUnit.roman);
            num = romanInUnit.nextNum;
        }
        return sb.toString();         
    }
}
