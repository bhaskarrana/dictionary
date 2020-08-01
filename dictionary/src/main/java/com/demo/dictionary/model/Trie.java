package com.demo.dictionary.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Trie {

        @Autowired
	    TrieNode root;
	  
	    public Trie() {
	        root = new TrieNode(' ' );
	        
	    }
	    
	    boolean isValid(String str) {
	    	return (str != null && str.trim().length() !=0 && (str.matches("^[a-zA-Z]*$")));
	    }
	    /** Inserts a word and meaning into the trie. */
	    public void insert(String word,String meaning) {
	    	if(!isValid(word) || !isValid(meaning))
	    		return ;
	        TrieNode t=root;
	        for ( char c : word.toCharArray()){
	            if (t.children[c-'a']==null){
	                t.children[c-'a']=new TrieNode(c);
	            }
	            t=t.children[c-'a'];
	            
	        }
	        t.setWord(true);
	        if(t.getMeanings() == null )
	        	t.setMeanings(new HashSet<String>());
	        t.getMeanings().add(meaning);
	    }
	    
	    public void update(String word,String newMeaning,String oldMeaning) {
	        TrieNode t=root;
	        if(!isValid(word) || !isValid(newMeaning) || !isValid(oldMeaning) )
	    		return ;
	        for ( char c : word.toCharArray()){
	            if (t.children[c-'a']==null){
	                t.children[c-'a']=new TrieNode(c);
	            }
	            t=t.children[c-'a'];
	            
	        }
	        t.setWord(true);
	        if(t.getMeanings() == null )
	        	t.setMeanings(new HashSet<String>());
	        t.getMeanings().remove(oldMeaning);
	        t.getMeanings().add(newMeaning);
	        
	    }
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	    	if(!isValid(word))
	    		return false;
	    	TrieNode t =root;
	        for ( char c : word.toCharArray()){
	            if (t.children[c-'a']== null)
	                return false;
	            t=t.children[c-'a'];
	        }
	        return t.isWord();
	        
	    }
	    
	    public boolean search(String word,String meaning) {
	    	if(!isValid(word) || !isValid(meaning))
	    		return false;
	    	TrieNode t =root;
	        for ( char c : word.toCharArray()){
	            if (t.children[c-'a']== null)
	                return false;
	            t=t.children[c-'a'];
	        }
	        return t.isWord() && t.getMeanings().contains(meaning);
	        
	    }
	    /* Return words,which start with given prefix in Trie*/
	    public List<String> startsWithAndGetWords(String prefix) {
	    	List<String> ans = new ArrayList<>();
	    	if(!isValid(prefix))
	    		return ans;
	    	startsWithAndGetWords(prefix,ans);
	    	return ans;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWithAndGetWords(String prefix,List<String>ans) {
	        TrieNode t = root;
	        for ( char c : prefix.toCharArray()){
	            if (t.children[c-'a']== null)
	                return false;
	            t=t.children[c-'a'];
	        }
	        addWord(t,ans,prefix);
	        return true;
	        
	    }
	    
	    private void addWord(TrieNode root,List<String>ans,String str) {
	    	if(root == null)
	    		return ;
	    	if(root.isWord()) {
	    		ans.add(str);
	    	}
	    	int i=0;
	    	for (TrieNode t:root.getChildren()) {
	    		if(t !=null) {
	    			addWord(t,ans,str+(char)('a'+i));
	    		}
	    		i++;
	    	}
	    }
	    
	    public HashMap<String,List<String>> startsWithAndGetWordsAndMeaning(String prefix) {
	    	HashMap<String,List<String>> ans = new HashMap<>();
	    	System.out.println(prefix);
	    	if(!isValid(prefix))
	    		return ans;
	    	startsWithAndGetWordsAndMeanings(prefix,ans);
	    	for ( String s:ans.keySet()) {
	    		System.out.println(s);
	    	}
	    	return ans;
	    }
	    public boolean startsWithAndGetWordsAndMeanings(String prefix,HashMap<String,List<String>>ans) {
	        TrieNode t = root;
	        for ( char c : prefix.toCharArray()){
	            if (t.children[c-'a']== null)
	                return false;
	            t=t.children[c-'a'];
	        }
	        addWordAndMeaning(t,ans,prefix);
	        return true;
	        
	    }
	    
	    private void addWordAndMeaning(TrieNode root,HashMap<String,List<String>>ans,String str) {
	    	if(root == null)
	    		return ;
	    	if(root.isWord()) {
	    		ans.put(str,new ArrayList<>(root.meanings));
	    	}
	    	int i=0;
	    	for (TrieNode t:root.getChildren()) {
	    		if(t !=null) {
	    			addWordAndMeaning(t,ans,str+(char)('a'+i));
	    		}
	    		i++;
	    	}
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie ob = new Trie();
		ob.insert("www","aa");
		for ( String x: ob.startsWithAndGetWordsAndMeaning("ww").keySet()) {
			System.out.println(x);
		}

	}

	public void delete(String word) {
		// TODO Auto-generated method stub
		if(search(word))
		   delete(root,word,0);
	}

	
	public void delete(String word, String meaning) {
     	   deleteMeaning(root,word,0,meaning);
	}

	private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isWord()) {
                return false;
            }
            current.setWord(false);
            return current.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren()[ch-'a'];
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren()[ch-'a'] = null;
            return current.isEmpty();
        }
        return false;
    }
	
	private void deleteMeaning(TrieNode current, String word, int index,String meaning) {
        if (index == word.length()) {
          if (current.isWord()) {
            current.getMeanings().remove(meaning);
            if(current.getMeanings().size() == 0)
               current.setWord(false);
            }
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren()[ch-'a'];
     
        deleteMeaning(node, word, index + 1,meaning) ;
    
    }
}
