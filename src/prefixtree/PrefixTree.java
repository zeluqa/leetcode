package prefixtree;
//https://leetcode.com/problems/implement-trie-prefix-tree/

class TrieNode {
    private final int R = 26; //26 possible links/26 alphabet characters
    private TrieNode[] links; //Linked nodes
    private boolean isEnd; //True if does not have any more links
    
    public TrieNode () {
        links = new TrieNode[R];
    }
    
    //Returns true if current node contains link to char ch
    public boolean containsKey (char ch) {
    	return links[ch - 'a'] != null;
    }

    //Returns node that links to char ch
    public TrieNode get (char ch) {
    	return links[ch - 'a'];
    }
    
    //Puts link to char ch
    public void put (char ch) {
    	links[ch - 'a'] = new TrieNode();
    }
    
    //Sets current node as end node
    public void setEnd () {
    	isEnd = true;
    }
    
    //Returns true if current node is an end of a word
    public boolean isEnd () {
    	return isEnd;
    }
}

class Trie {
	private TrieNode root;
	
    /** Initialize your data structure here. */    
    public Trie() {
    	root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
        	char ch = word.charAt(i);
        	if (node.containsKey(ch)) {
        		node = node.get(ch);
        	} else {
        		node.put(ch);
        		node = node.get(ch);
        	}
        	if (i == word.length()-1)
        		node.setEnd();
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
        	char ch = word.charAt(i);
        	if (!node.containsKey(ch)) return false;
        	node = node.get(ch);
        }
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode node = root;
    	for (int i = 0; i < prefix.length(); i++) {
    		char ch = prefix.charAt(i);
    		if (!node.containsKey(ch)) return false;
    		node = node.get(ch);
    	}
    	return true;
    }
}

public class PrefixTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}

}
