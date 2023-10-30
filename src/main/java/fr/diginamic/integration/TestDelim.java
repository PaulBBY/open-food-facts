package fr.diginamic.integration;

import antlr.StringUtils;

public class TestDelim {

	static String testDelim(String toTest) {
		
		int virgule=0;
		int tiret=0;
		int pointVirgule=0;

		
		for(int i = 0; i<toTest.length(); i++) {
			switch (toTest.charAt(i)) {
			case ',':
				virgule ++;
				break;
			case ';':
				pointVirgule ++;
				break;
			case '-':
				tiret ++;
				break;
			}	
					
		}
		
		if(virgule >= pointVirgule && virgule >= tiret) {
			return ",";
		} else if (pointVirgule >= virgule && pointVirgule>=tiret) {
			return ";";
		} else {
			return "-";
		}
		
	}
}
