package fr.diginamic.integration;

public class Parseur {

	static String[] parseurCustom(String ligne, String custom) {

		String[] parsedCustom = ligne.split(custom);
		return parsedCustom;

	}

	static float parseurStringChiffre(String col) {

		float valeur;
		try {

			valeur = Float.parseFloat(col);

		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			valeur = -1;
		}
		return valeur;

	}

}
