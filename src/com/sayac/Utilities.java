package com.sayac;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Utilities {

	public void kelimeSay(String metin) {
		
		String[] arr = metin.split(" ");
		
		for(int k= 0; k < arr.length; k++) {
			
			arr[k] = arr[k].replaceAll("\\W","");
			
		}
		
		Map<String, Integer> sayac = new HashMap<>();
		
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			if(!sayac.containsKey(arr[i])) {
				count++;
				
				for(int j= i+1; j < arr.length; j++ ) {
					
					if(arr[i].equalsIgnoreCase(arr[j])) {
						count++;
					}
				}
				
				sayac.put(arr[i], count);
				
			}
			count = 0;
		}
		
		
		//System.out.println(sayac);
		
		LinkedHashMap<String, Integer> sirali = new LinkedHashMap<>();
		
		sayac.entrySet().stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.forEachOrdered(x -> sirali.put(x.getKey(), x.getValue()));
		
		for(Map.Entry<String, Integer> entry : sirali.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
}
