package com.demo.dictionary.model;

import java.util.HashSet;

import org.springframework.stereotype.Component;

@Component
public class TrieNode {

    public TrieNode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public char getVal() {
		return val;
	}
	public void setVal(char val) {
		this.val = val;
	}
	
	public boolean isWord() {
		return isWord;
	}
	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}
	public TrieNode[] getChildren() {
		return children;
	}
	public void setChildren(TrieNode[] children) {
		this.children = children;
	}
		
	private char val;
    private boolean isWord;
    TrieNode children[] = new TrieNode[26];
    HashSet<String> meanings;
    public HashSet<String> getMeanings() {
		return meanings;
	}
	public void setMeanings(HashSet<String> meanings) {
		this.meanings = meanings;
	}
	TrieNode( char val){
            this.val =val;
        }
	public boolean isEmpty() {
		for ( int i =0;i<children.length;i++)
			if(children[i] !=null)
				return false;
		return true;
	}
      
    }
	
