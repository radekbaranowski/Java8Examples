package com.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsExample {

	public class Osoba {
		int wiek;
		String imie;
		
		public Osoba(String imie, int wiek){
			this.wiek = wiek;
			this.imie = imie;
		}
		
		
		@Override 
		public String toString(){
		return imie;
		    }
	}
	
	
	public final static String[] warzywa = {
			"Bak³a¿an"   ,
			"Bób"        ,
			"Broku³"     ,
			"Brukiew"    ,
			"Burak"      ,
			"Rzodkiewka" ,
			"Salsefia"   ,
			"Cebula"     ,
			"Cykoria"    ,
			"Czosnek"    ,
			"Dynia"      ,
			"Fasola"     ,
			"Groch"      ,
			"Pasternak"  ,
			"Pietruszka" ,
			"Por"        ,
			"Roszponka"  ,
			"Rzepa"      ,
			"Jarmu¿"     ,
			"Kalafior"   ,
			"Kalarepa"   ,
			"Kapusta"    ,
			"Karczoch"   ,
			"Koper"      ,
			"Kukurydza"  ,
			"Marchew"    ,
			"Ogórek"     ,
			"Papryka"    ,
			"Rze¿ucha"   ,
			"Rzodkiew"   ,
			"Sa³ata"     ,
			"Seler"      ,
			"Skorzonera" ,
			"Szalotka"   ,
			"Szczypiorek",
			"Szpinak"    ,
			"Pomidor"    
	};
	
	// usage of IntStream to process int[]; not Integer[] - hence the need for boxing
	public static int simpleArraySum(int n, int[] ar) {
               
        	List<Integer> arList = IntStream.of(ar).boxed().collect(Collectors.toList());
        	int total = arList.stream().reduce(0, Integer::sum);
        	return total;
    	};
	
	public static void main (String[] args){
		List<String> elementy =  Arrays.asList(warzywa);
		
		StreamsExample k = new StreamsExample();
		
		List<Osoba> ludzie = Arrays.asList(
				k.new Osoba("Marek", 23),
				k.new Osoba("Adam", 43),
				k.new Osoba("Monika", 33),
				k.new Osoba("Ania", 22),
				k.new Osoba("Ola", 27),
				k.new Osoba("Radek", 23)
				);
		
		
		elementy
			.stream()
			.filter(s -> s.startsWith("S"))
			.map(String::toLowerCase)
			.sorted()
			.forEach(System.out::println);
		
		Map<Integer, List<Osoba>> out = ludzie
				.stream()
				.collect(Collectors.groupingBy(o -> o.wiek));
		String out2 = ludzie
				.stream()
				.filter(o -> o.wiek > 30)
				.map(o -> o.imie)
				.collect(Collectors.joining(" i ", "Osoby ", " w wieku powyzej 30"));
		
		out.forEach((wiek,p) -> System.out.format("wiek %s %s\n", wiek,p));
		System.out.println(out);
		System.out.println(out2);
	}
}
