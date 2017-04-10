package com.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class StringStream {

	private static String[] strs = {"1.2.1","1.3.u","1.7.6","1.8.f","99.23.x","y.9.0"};
	
	public static void main (String[] args){
		
		List<String> lista = Arrays.asList(strs);

		 Pattern p = Pattern.compile(".*[a-zA-Z]+.*");
		 
		 List<String> temp = new ArrayList(); 
		
		 List<String> nowa = lista.stream()
			.sorted()
			.map(item -> {if (!p.matcher(item).matches()) temp.add(item); return item;})
			.filter(item -> p.matcher(item).matches())
			.collect(Collectors.toList());
		 
		 System.out.println(nowa);
		 System.out.println(temp);
		 List<String> wynik = new ArrayList();
		 wynik.addAll(temp);
		 wynik.addAll(nowa);
		System.out.println(wynik);
	}
	
}
