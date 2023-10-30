package fr.diginamic.integration;


public class Parseur {
	
	static String[] parseurCustom(String ligne, String custom) {

		String[] parsedCustom = ligne.split(custom);
		return parsedCustom;
		
	}
}
