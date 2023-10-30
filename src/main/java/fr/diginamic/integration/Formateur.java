package fr.diginamic.integration;

public class Formateur {

	static String formateurCustom(String ligne, String remplace, String estRemplace) {

		ligne = ligne.replace(estRemplace, remplace);
		return ligne;

	}
	
}
