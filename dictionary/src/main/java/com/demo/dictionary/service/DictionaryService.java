package com.demo.dictionary.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.dictionary.model.Trie;

@Component
//@ComponentScan("com.demo.dictionary")
public class DictionaryService {

	
	@Autowired
	Trie root;
	
	public void insert(String word,String meaning) {
		root.insert(word, meaning);	
	}
	
	public void update(String word,String meaning,String oldMeaning) {
		root.update(word, meaning,oldMeaning);	
	}
	public HashMap<String,List<String>> startsWithAndGetWordsAndMeaning(String prefix) {
		return root.startsWithAndGetWordsAndMeaning(prefix);
	}
	
	public boolean checkWordPresent(String word) {
		return root.search(word);
	}
	
	public boolean checkWordAndMeaningPresent(String word, String meaning) {
		return root.search(word,meaning);
	}

	public void delete(String word) {
		root.delete(word);
	}
	
	public void delete(String word,String meaning) {
		root.delete(word,meaning);
	}
	
	
	
	
}
