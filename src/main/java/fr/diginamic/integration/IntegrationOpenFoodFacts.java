package fr.diginamic.integration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.internal.build.AllowSysOut;

import fr.diginamic.dao.AdditifDao;
import fr.diginamic.dao.AllergeneDao;
import fr.diginamic.dao.CategorieDao;
import fr.diginamic.dao.IngredientDao;
import fr.diginamic.dao.MacroElementDao;
import fr.diginamic.dao.MarqueDao;
import fr.diginamic.dao.MinerauxDao;
import fr.diginamic.dao.ProduitDao;
import fr.diginamic.dao.VitaminesDao;
import fr.diginamic.entite.Additif;
import fr.diginamic.entite.Allergene;
import fr.diginamic.entite.Categorie;
import fr.diginamic.entite.Ingredient;
import fr.diginamic.entite.Marque;
import fr.diginamic.entite.Produit;
import fr.diginamic.entite.element.MacroElements;
import fr.diginamic.entite.element.Mineraux;
import fr.diginamic.entite.element.Vitamines;

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("open-food-facts");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tr = em.getTransaction();

		MarqueDao marqueDao = new MarqueDao();
		MacroElementDao macroElementDao = new MacroElementDao();
		ProduitDao produitDao = new ProduitDao();
		VitaminesDao vitaminesDao = new VitaminesDao();
		CategorieDao categorieDao = new CategorieDao();
		MinerauxDao minerauxDao = new MinerauxDao();
		IngredientDao ingredientsDao = new IngredientDao();
		AllergeneDao allergenesDao = new AllergeneDao();
		AdditifDao additifDao = new AdditifDao();

		/*
		List<String> lignes = null;

		Path path = Paths.get("C:\\Pro\\Java\\traitement-fichier-jpa-off\\src\\main\\resources\\open-food-facts.csv");
		try {
			lignes = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(lignes.size());
		lignes.remove(0);
		List<Integer> formatPb = new ArrayList<>();

		for (String ligne : lignes) {

			String[] parsedAll = Parseur.parseurCustom(ligne, "\\|");

			if (parsedAll.length != 30) {
				formatPb.add(lignes.indexOf(ligne));
				continue;
			}

			String nomCategorie = parsedAll[0];
			String nomMarque = parsedAll[1];
			String nomProduit = parsedAll[2];
			char nutrition = parsedAll[3].charAt(0);

			float energie = Parseur.parseurStringChiffre(parsedAll[5]);
			float fibre = Parseur.parseurStringChiffre(parsedAll[8]);
			float sel = Parseur.parseurStringChiffre(parsedAll[10]);
			float bool = Parseur.parseurStringChiffre(parsedAll[27]);

			Boolean huile = null;
			if (bool == 1) {
				huile = true;
			} else if (bool == 0) {
				huile = false;
			} else {
				huile = null;
			}

			float macro1 = Parseur.parseurStringChiffre(parsedAll[6]);
			float macro2 = Parseur.parseurStringChiffre(parsedAll[7]);
			float macro3 = Parseur.parseurStringChiffre(parsedAll[9]);

			float[] signatureMacro = { macro1, macro2, macro3 };

			float vit1 = Parseur.parseurStringChiffre(parsedAll[11]);
			float vit2 = Parseur.parseurStringChiffre(parsedAll[12]);
			float vit3 = Parseur.parseurStringChiffre(parsedAll[13]);
			float vit4 = Parseur.parseurStringChiffre(parsedAll[14]);
			float vit5 = Parseur.parseurStringChiffre(parsedAll[15]);
			float vit6 = Parseur.parseurStringChiffre(parsedAll[16]);
			float vit7 = Parseur.parseurStringChiffre(parsedAll[17]);
			float vit8 = Parseur.parseurStringChiffre(parsedAll[18]);
			float vit9 = Parseur.parseurStringChiffre(parsedAll[19]);
			float vit10 = Parseur.parseurStringChiffre(parsedAll[20]);
			float vit11 = Parseur.parseurStringChiffre(parsedAll[21]);
			float vit12 = Parseur.parseurStringChiffre(parsedAll[26]);

			float[] signatureVitamines = { vit1, vit2, vit3, vit4, vit5, vit6, vit7, vit8, vit9, vit10, vit11, vit12 };

			float calc = Parseur.parseurStringChiffre(parsedAll[22]);
			float magn = Parseur.parseurStringChiffre(parsedAll[23]);
			float fer = 0;

			if (parsedAll[24].equals(null)) {
				Parseur.parseurStringChiffre(parsedAll[25]);
			} else {
				fer = Parseur.parseurStringChiffre(parsedAll[24]);
			}

			float[] signatureMineraux = { calc, magn, fer };

			System.out.println("++++" + nomProduit);

			String[] parsedIngredients = Parseur.parseurCustom(
					Formateur.formateurCustom(parsedAll[4], "", "_").toLowerCase(), TestDelim.testDelim(parsedAll[4]));

			String[] parsedAllergenes = Parseur.parseurCustom(
					Formateur.formateurCustom(parsedAll[28], "", "_").toLowerCase(),
					TestDelim.testDelim(parsedAll[28]));
			String[] parsedAdditifs = Parseur.parseurCustom(
					Formateur.formateurCustom(parsedAll[29], "", "_").toLowerCase(),
					TestDelim.testDelim(parsedAll[29]));

			tr.begin();

			Categorie categorie = categorieDao.insertIfNotExistCustom(em, nomCategorie);
			Marque marque = marqueDao.insertIfNotExistCustom(em, nomMarque);
			MacroElements macroElements = macroElementDao.insertIfNotExistCustom(em, signatureMacro);
			Vitamines vitamines = vitaminesDao.insertIfNotExistCustom(em, signatureVitamines);
			Mineraux mineraux = minerauxDao.insertIfNotExistCustom(em, signatureMineraux);

			Set<Ingredient> ingredients = new HashSet<>();

			for (String i : parsedIngredients) {
				i = i.trim();
				if (i.length() > 25) {
					continue;
				}
				Ingredient ingredient = ingredientsDao.insertIfNotExistCustom(em, i);
				if (ingredient != null) {
					ingredients.add(ingredient);
				}

			}

			Set<Allergene> allergenes = new HashSet<>();
			for (String al : parsedAllergenes) {
				al = al.trim();
				if (al.length() > 25) {
					continue;
				}
				Allergene allergene = allergenesDao.insertIfNotExistCustom(em, al);
				if (allergene != null) {
					allergenes.add(allergene);
				}

			}

			Set<Additif> additifs = new HashSet<>();
			for (String ad : parsedAdditifs) {
				ad = ad.trim();
				if (ad.length() > 25) {
					continue;
				}
				Additif additif = additifDao.insertIfNotExistCustom(em, ad);
				if (additif != null) {
					additifs.add(additif);
				}

			}

			Produit produit = new Produit(nomProduit, nutrition, energie, fibre, sel, huile, allergenes, additifs,
					ingredients, vitamines, macroElements, mineraux, marque, categorie);

			System.out.println("°°°00" + "" + produit.toString() + "" + ""

			);

			Produit produitT = produitDao.insertIfNotExistCustom(em, produit);

		}
		tr.commit();

		System.out.println("Il y a " + formatPb.size() + " lignes en erreur !");
		*/
		Scanner scanner = new Scanner(System.in);
		System.out.println("test");
		int choix = 0;
		while (choix < 99) {
			System.out.println("Choix 1 (top10cat), 2(top10m) ?");
			String choixMenu = scanner.nextLine();

			

			choix = Integer.parseInt(choixMenu);

			switch (choix) {
			case 1:
				System.out.println("Veuillez renseigner un nom de catégorie :");
				String choixCat10 = scanner.nextLine();
				Categorie cat10 = categorieDao.selectCustom(em, choixCat10);
				if (cat10 == null) {
					System.out.println("Cette catégorie n'existe pas...");
					break;
				}
				List<Produit> produits1 = produitDao.select10Custom(em, cat10);
				System.out.println("Les 10 meilleurs produits de la catégore " + cat10.getNomCategorie() + " sont :");
				for (Produit p : produits1) {
					System.out.println(p.getNomProduit() + " : " + p.getNutritionGradeFr());
				}
				break;

			case 2:
				System.out.println("Veuillez renseigner un nom de marque :");
				String choixMar10 = scanner.nextLine();
				Marque mar10 = marqueDao.selectCustom(em, choixMar10);
				if (mar10 == null) {
					System.out.println("Cette marque n'existe pas...");
					break;
				}
				List<Produit> produits2 = produitDao.select10Custom(em, mar10);
				System.out.println("Les 10 meilleurs produits de la marque " + mar10.getNomMarque() + " sont :");
				for (Produit p : produits2) {
					System.out.println(p.getNomProduit()+ " : "+ p.getNutritionGradeFr());
				}
			case 3:
				System.out.println("Veuillez renseigner un nom de catégorie :");
				String choixCat10m = scanner.nextLine();
				Categorie cat10m = categorieDao.selectCustom(em, choixCat10m);
				if (cat10m == null) {
					System.out.println("Cette catégorie n'existe pas...");
					break;
				}
				System.out.println("Veuillez renseigner un ingrédient à exclure");
				String choixIngcat = scanner.nextLine();
				Ingredient ingExCat = ingredientsDao.selectCustom(em, choixIngcat);
				if(ingExCat == null) {
					System.out.println("Cet ingrédient n'existe pas ...");
					break;
				}
				
				List<Produit> produit3 = produitDao.select10CustomEx(em, cat10m, ingExCat);
				for(Produit p : produit3) {
					System.out.println(p.getNomProduit()+ " : "+p.getNutritionGradeFr());
				}
				break;
			case 4:
				System.out.println("Veuillez renseigner un nom de marque :");
				String choixMar10m = scanner.nextLine();
				Marque mar10m = marqueDao.selectCustom(em, choixMar10m);
				if (mar10m == null) {
					System.out.println("Cette marque n'existe pas...");
					break;
				}
				System.out.println("Veuillez renseigner un ingrédient à exclure");
				String choixIngmar = scanner.nextLine();
				Ingredient ingExMar = ingredientsDao.selectCustom(em, choixIngmar);
				if(ingExMar == null) {
					System.out.println("Cet ingrédient n'existe pas ...");
					break;
				}
				
				List<Produit> produit4 = produitDao.select10CustomEx(em, mar10m, ingExMar);
				for(Produit p : produit4) {
					System.out.println(p.getNomProduit()+ " : "+p.getNutritionGradeFr());
				}
				break;
			case 5:
				System.out.println("Veuillez renseigner un nom de catégorie :");
				String choixCat10mA = scanner.nextLine();
				Categorie cat10mA = categorieDao.selectCustom(em, choixCat10mA);
				if (cat10mA == null) {
					System.out.println("Cette catégorie n'existe pas...");
					break;
				}
				System.out.println("Veuillez renseigner un ingrédient à exclure");
				String choixAllcat = scanner.nextLine();
				Allergene allExCat = allergenesDao.selectCustom(em, choixAllcat);
				if(allExCat == null) {
					System.out.println("Cet allergène n'existe pas ...");
					break;
				}
				
				List<Produit> produit5 = produitDao.select10CustomEx(em, cat10mA, allExCat);
				for(Produit p : produit5) {
					System.out.println(p.getNomProduit()+ " : "+p.getNutritionGradeFr());
				}
				break;
			case 6:
				System.out.println("Veuillez renseigner un nom de marque :");
				String choixMar10mA = scanner.nextLine();
				Marque mar10mA = marqueDao.selectCustom(em, choixMar10mA);
				if (mar10mA == null) {
					System.out.println("Cette marque n'existe pas...");
					break;
				}
				System.out.println("Veuillez renseigner un ingrédient à exclure");
				String choixAllmar = scanner.nextLine();
				Ingredient allExMar = ingredientsDao.selectCustom(em, choixAllmar);
				if(allExMar == null) {
					System.out.println("Cet allergène n'existe pas ...");
					break;
				}
				
				List<Produit> produit6 = produitDao.select10CustomEx(em, mar10mA, allExMar);
				for(Produit p : produit6) {
					System.out.println(p.getNomProduit()+ " : "+p.getNutritionGradeFr());
				}
				break;

			}

		} 

	}

}
