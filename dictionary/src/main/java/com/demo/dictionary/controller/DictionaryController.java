package com.demo.dictionary.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dictionary.model.Word;
import com.demo.dictionary.service.DictionaryService;
//@Component
@RequestMapping
@RestController
public class DictionaryController {

	@Autowired

	DictionaryService  dictionaryService;
	
	  // GET
	  @RequestMapping(value="/dictionary/ispresent/meaning/{word}/{meaning}", method =  RequestMethod.GET)
	  String checktMeaningPresent(@PathVariable("word") String word,@PathVariable("meaning") String meaning){
		   return "Word name "+word +" meaning is "+meaning+ "   "+dictionaryService.checkWordAndMeaningPresent(word, meaning);   
	   }
	   
	   @RequestMapping(value="/dictionary/ispresent/word/{word}", method =  RequestMethod.GET)
	  String checkWordPresent(@PathVariable("word") String word){
		   return "Word name "+word +" is "+dictionaryService.checkWordPresent(word);   
	   }
	   @RequestMapping(value="/dictionary/word/starts", method =  RequestMethod.GET)
	   List<String> getListStartWithWord(@PathVariable("word") String word){
		   return null;
	   }
	   @RequestMapping(value="/dictionary/word/startgetMeaning/{word}", method =  RequestMethod.GET)
	   HashMap<String,List<String>> getListStartWithWordAndMeaning(@PathVariable("word") String word){
		   return dictionaryService.startsWithAndGetWordsAndMeaning(word);
	   }
	   
	   
	   // Add record POST
	   @RequestMapping(value="/dictionary/add/", method =  RequestMethod.POST)
	   void addWord(@RequestBody Word word){
		   dictionaryService.insert(word.getWord(),word.getMeaning());
	   }
	   //Update Record PUT
	   @RequestMapping(value="/dictionary/update/", method =  RequestMethod.PUT)
	   void updateWord(@RequestBody Word word){
		   dictionaryService.update(word.getWord(),word.getMeaning(),word.getPrevWord());
	   }
	   //Remove Record DELETE
	   
	   @RequestMapping(value="/dictionary/delete/word/{word}", method =  RequestMethod.DELETE)
	   void removeWord(@PathVariable("word") String word){
		   dictionaryService.delete(word);
	   }
	   
	   @RequestMapping(value="/dictionary/delete/meaning", method =  RequestMethod.DELETE)
	   void deleteWordMeaning(@RequestBody Word word){
		   dictionaryService.delete(word.getWord(),word.getMeaning());
	   }
}
