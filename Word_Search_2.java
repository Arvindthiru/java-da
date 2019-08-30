class Solution {
    
    class TrieNode{
        TrieNode[] children;
        String word;
        
        public TrieNode()
        {
            children = new TrieNode[26];
            word = null;
        }
    }
    TrieNode root;
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        root = new TrieNode();
        buildTrie(words,root);
        int i,j,index;
        for(i=0;i<board.length;i++)
        {
            for(j=0;j<board[0].length;j++)
            {
                index = board[i][j] - 'a';
                if(root.children[index]!=null)
                {
                    searchBoard(board,i,j,root,result);
                }
            }
        }
        return result;
    }
    
    public void buildTrie(String[] words, TrieNode node)
    {
        int i,index;
        for(i=0;i<words.length;i++)
        {
            for(char c : words[i].toCharArray())
            {
                index = c - 'a';
                if(node.children[index] == null)
                {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = words[i];
            node = root;
        }
    }
    
    public void searchBoard(char[][] board, int i, int j, TrieNode node, List<String> result)
    {
        if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1)
        {
            return;
        }
        if(board[i][j] == '*')
        {
            return;
        }
        if(node.children[board[i][j]-'a'] == null)
        {
            return;
        }
        char c;
        node = node.children[board[i][j]-'a'];
        if(node.word!=null)
        {
            result.add(node.word);
            node.word = null;
        }
        c = board[i][j];
        board[i][j] = '*';
        searchBoard(board,i+1,j,node,result);
        searchBoard(board,i-1,j,node,result);
        searchBoard(board,i,j+1,node,result);
        searchBoard(board,i,j-1,node,result);
        board[i][j] = c;
    }
}
