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

    /*
     * Other more efficient solutions
     */

// class Solution {
//   public String intToRoman(int num) {
//     final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//     final String[] symbols = {"M",  "CM", "D",  "CD", "C",  "XC", "L",
//                               "XL", "X",  "IX", "V",  "IV", "I"};
//     StringBuilder sb = new StringBuilder();

//     for (int i = 0; i < values.length; ++i) {
//       if (num == 0)
//         break;
//       while (num >= values[i]) {
//         num -= values[i];
//         sb.append(symbols[i]);
//       }
//     }

//     return sb.toString();
//   }
// }

// class Solution {
//   public String intToRoman(int num) {
//     final String[] M = {"", "M", "MM", "MMM"};
//     final String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//     final String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//     final String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//     return M[num / 1000] + C[num % 1000 / 100] + X[num % 100 / 10] + I[num % 10];
//   }
// }

}

