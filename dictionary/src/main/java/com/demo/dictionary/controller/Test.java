package com.demo.dictionary.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	static void convert(String str,int start,String out,Set<String>ans,String res) {
		if(start==str.length() ) {//|| start+out.length()==str.length()) {
			ans.add(res+out);
			return ;
		}
		for ( int i=start;i<str.length();i++) {
			if(Integer.parseInt(out+(char)str.charAt(i))>256) {
				res=res+out+".";
				out="";
				
			}
			convert(str,i+1,out+(char)str.charAt(i),ans,res);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> ans = new HashSet<>();
		//convert("255255",0,"",ans,"");
		for (String a: ans) {
			System.out.println(a);
		}
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    	String dateString = "2017";
    	try{
               //formatting the dateString to convert it into a Date 
    	   Date date = sdf.parse(dateString);
    	   System.out.println("Given Time in milliseconds : "+date.getTime());

    	   Calendar calendar = Calendar.getInstance();
    	   //Setting the Calendar date and time to the given date and time
    	   calendar.setTime(date);
    	   calendar.add(Calendar.DATE,1);
    	   System.out.println("Given Time in milliseconds : "+calendar.getTimeInMillis());
    	}catch(ParseException e){
    	   e.printStackTrace();
    	 } 
	}

}
