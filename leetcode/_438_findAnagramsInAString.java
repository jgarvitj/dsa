class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        /*
            Sliding window over s, which should be of the length of p
            keep track count of characters in the window and keep comparing it with the count in p
        */
        //count in p
        Map<Character, Integer> hmP = new HashMap<>();
        Map<Character, Integer> hmS = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            hmP.put(p.charAt(i), hmP.getOrDefault(p.charAt(i), 0) + 1);
        }
        

        List<Integer> anaIndexes = new ArrayList<>();

        //window over s
        for(int i = 0; i < s.length(); i++) {
            
            char sEnd = s.charAt(i);
            hmS.put(sEnd, hmS.getOrDefault(sEnd, 0) + 1);

            if(i >= p.length()-1) {
                int start = i - p.length() + 1;
                
                if(hmP.equals(hmS)) {
                    anaIndexes.add(start);
                }

                char sStart = s.charAt(start);
                if(hmS.get(sStart) > 1) {
                    hmS.put(sStart, hmS.get(sStart) - 1);
                } else {
                    hmS.remove(sStart);
                }
            }
        }
        return anaIndexes;
    }
}
