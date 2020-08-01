package com.demo.dictionary.model;

public class Word {
String word;
String meaning;
String prevWord;
public String getPrevWord() {
	return prevWord;
}
public void setPrevWord(String prevWord) {
	this.prevWord = prevWord;
}
public String getWord() {
	return word;
}
public void setWord(String word) {
	this.word = word;
}
public String getMeaning() {
	return meaning;
}
public void setMeaning(String meaning) {
	this.meaning = meaning;
}
public Word(String word, String meaning) {
	super();
	this.word = word;
	this.meaning = meaning;
}

public Word(String word, String meaning, String prevWord) {
	super();
	this.word = word;
	this.meaning = meaning;
	this.prevWord = prevWord;
}
public Word() {
	super();
	// TODO Auto-generated constructor stub
}

}
