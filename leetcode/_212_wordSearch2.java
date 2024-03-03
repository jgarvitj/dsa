class Solution {

    /*
    Construct a graph with adjList as adjcent nodes and val as char
    This should be accompied by a set of all the vals to find different starting points for a word

    for each word
        check the start char, find the possible start nodes from the set
            for each possible start parse the graph and check if you have end of word

    We can also use a tree, with different directions as its children

    We can remove a leaf child to avoid revisiting that path
    */


    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word = null;
        public TrieNode() {}
    }

    List<String> result = new ArrayList<>();
    char[][] grid;
    int rSize;
    int cSize;


    public List<String> findWords(char[][] board, String[] words) {
        
        rSize = board.length;
        cSize = board[0].length;
        grid = board;

        TrieNode root = new TrieNode();
        for(String w : words) {
            TrieNode node = root;

            for(Character c : w.toCharArray()) {
                if(node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    TrieNode child = new TrieNode();
                    node.children.put(c, child);
                    node = child;
                }
            }
            node.word = w;
        }

        for(int i = 0; i < rSize; i++) {
            for(int j = 0; j < cSize; j++) {
                char c = board[i][j];
                if(root.children.containsKey(board[i][j])) {
                    backTrack(i, j, root);
                }
            }
        }
        return result;

    }

    private void backTrack(int row, int col, TrieNode root) {
        
        if(!checkIndexInbound(row, col) || root == null) {
            return;
        }

        Character sub = '#';
        Character c = grid[row][col];
        grid[row][col] = sub;

        int[] rOffset = {0, 1, 0, -1};
        int[] cOffset = {1, 0, -1, 0};

        TrieNode curr = root.children.get(c);
        if(curr.word != null) {
            result.add(curr.word);
            curr.word = null;
        }
        List<String> x = result;
        if(curr.children.isEmpty()) {
            root.children.remove(c);
        }

        for(int i =0; i < 4; i++) {
            int rNext = row + rOffset[i];
            int cNext = col + cOffset[i];
            
            if(checkIndexInbound(rNext, cNext)) {
                Character charNext = grid[rNext][cNext];
                if(curr.children.containsKey(charNext)) {
                    backTrack(rNext, cNext, curr);
                }
            }
        }
        grid[row][col] = c;
        return;

    }

    private boolean checkIndexInbound(int row, int col) {
        if(row < 0 || col < 0 || row == rSize || col == cSize) {
            return false;
        }
        return true;
    } 

}
