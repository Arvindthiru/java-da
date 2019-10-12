class Trie {
    Trie[] children;
    String endWord;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        endWord = null;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int i,index;
        Trie Node = this;
        for(i=0;i<word.length();i++)
        {
            index = word.charAt(i) - 'a';
            if(Node.children[index] == null)
            {
                Node.children[index] = new Trie();
            }
            Node = Node.children[index];
        }
        Node.endWord = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int i,index;
        Trie Node = this;
        for(i=0;i<word.length();i++)
        {
            index = word.charAt(i) - 'a';
            if(Node.children[index]!=null)
            {
                Node = Node.children[index];
                if(i == word.length()-1 && Node.endWord!=null)
                {
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int i,index;
        Trie Node = this;
        for(i=0;i<prefix.length();i++)
        {
            index = prefix.charAt(i) - 'a';
            if(Node.children[index]!=null)
            {
                Node = Node.children[index];
            }
            else
            {
                return false;
            }
            
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
