class Solution {

/*
Recursion with mem
*/

    private boolean checkCase(String s, String p, int sIndex, int pIndex, Map<Pair<Integer, Integer>, Boolean> checkCaseMem) {

        if(checkCaseMem.containsKey(new Pair<>(sIndex, pIndex))) {
            return checkCaseMem.get(new Pair<>(sIndex, pIndex));
        }

        int sSize = s.length();
        int pSize = p.length();
        
        boolean isCaseValid;
        if(sIndex == sSize && pIndex == pSize) {
            checkCaseMem.put(new Pair<>(sIndex, pIndex), true);
            return true;
        } else if(pIndex >= pSize) {
            checkCaseMem.put(new Pair<>(sIndex, pIndex), false);
            return false;
        }

        boolean skipOrMultiEnabled = false;
        if(pIndex + 1 < pSize && p.charAt(pIndex + 1) == '*') {
            skipOrMultiEnabled = true;
        }
        if(!skipOrMultiEnabled && sIndex == sSize) {
            checkCaseMem.put(new Pair<>(sIndex, pIndex), false);
            return false;
        }

        if(skipOrMultiEnabled) {
            if(sIndex < sSize && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) {
                isCaseValid =  checkCase(s, p, sIndex+1, pIndex+2,checkCaseMem) || checkCase(s, p, sIndex+1, pIndex, checkCaseMem) || checkCase(s, p, sIndex, pIndex+2, checkCaseMem);
                checkCaseMem.put(new Pair<>(sIndex, pIndex), isCaseValid);
                return isCaseValid;
            }
            else {
                isCaseValid = checkCase(s, p, sIndex, pIndex+2, checkCaseMem);
                checkCaseMem.put(new Pair<>(sIndex, pIndex), isCaseValid);
                return isCaseValid;
            }
        } else {
            if(s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.') {
                isCaseValid = checkCase(s, p, sIndex+1, pIndex+1, checkCaseMem);
                checkCaseMem.put(new Pair<>(sIndex, pIndex), isCaseValid);
                return isCaseValid;
            } else {
                checkCaseMem.put(new Pair<>(sIndex, pIndex), false);
                return false;
            }
        }

    }


    public boolean isMatch(String s, String p) {

        Map<Pair<Integer, Integer>, Boolean> checkCaseMem = new HashMap<>();
        return checkCase(s, p, 0, 0, checkCaseMem);        
    }
}

