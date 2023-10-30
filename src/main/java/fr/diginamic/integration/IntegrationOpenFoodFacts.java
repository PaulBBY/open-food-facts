package fr.diginamic.integration;

import java.awt.desktop.OpenURIEvent;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.internal.build.AllowSysOut;

import fr.diginamic.dao.AdditifDao;
import fr.diginamic.dao.AllergeneDao;
import fr.diginamic.dao.CategorieDao;
import fr.diginamic.dao.Dao;
import fr.diginamic.dao.IngredientsDao;
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
		
		
		MarqueDao marqueDao = new MarqueDao();
		MacroElementDao macroElementDao = new MacroElementDao();
		ProduitDao produitDao = new ProduitDao();
		VitaminesDao vitaminesDao = new VitaminesDao();
		CategorieDao categorieDao = new CategorieDao();
		MinerauxDao minerauxDao = new MinerauxDao();
		IngredientsDao ingredientsDao = new IngredientsDao();
		AllergeneDao allergenesDao = new AllergeneDao();
		AdditifDao additifDao = new AdditifDao();
		
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
		for (String ligne : lignes) {

			String[] parsedAll = Parseur.parseurCustom(ligne, "\\|");
			if(parsedAll.length != 30) {
				continue;
			}
			
			String nomCategorie = parsedAll[0];
			System.out.println(nomCategorie);
			String nomMarque = parsedAll[1];
			String nomProduit = parsedAll[2];
			char nutrition = parsedAll[3].charAt(0);
			
			
			float energie = 0;
			try {
				energie = Float.parseFloat(parsedAll[5]);
			} catch (Exception e) {
				// TODO: handle exception
				
			}	
			float fibre = 0;
			try {
				 fibre = Float.parseFloat(parsedAll[8]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			float sel = 0;
			try {
				 sel = Float.parseFloat(parsedAll[10]);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			int bool = 0;
			try {
				bool = Integer.parseInt(parsedAll[27]);
			} catch (Exception e) {
				// TODO: handle exception
				bool = -1;
			}
	
			Boolean huile=null;
			if(bool == 1) {
				huile = true;
			} else if (bool == 0) {
				huile = false;
			} else {
				huile = null;
			}
			
			
			
			float macro1 = 0;
			try {
				macro1 = Float.parseFloat(parsedAll[6]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			float macro2=0;
			try {
					macro2 = Float.parseFloat(parsedAll[7]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			float macro3=0;
			try {
				macro3=Float.parseFloat(parsedAll[9]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			float[] signatureMacro = {	
					macro1,
					macro2,
					macro3};
			
			
			float vit1=0;
			float vit2=0;
			float vit3=0;
			float vit4=0;
			float vit5=0;
			float vit6=0;
			float vit7=0;
			float vit8=0;
			float vit9=0;
			float vit10=0;
			float vit11=0;
			float vit12=0;
			
			try {
				vit1=Float.parseFloat(parsedAll[11]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				vit2 =Float.parseFloat(parsedAll[12]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				vit3 = Float.parseFloat(parsedAll[13]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				vit4 = Float.parseFloat(parsedAll[14]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				vit5 =Float.parseFloat(parsedAll[15]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				vit6=Float.parseFloat(parsedAll[16]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				vit7 = Float.parseFloat(parsedAll[17]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				vit8 =	Float.parseFloat(parsedAll[18]);

			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				vit9=Float.parseFloat(parsedAll[19]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				vit10 = Float.parseFloat(parsedAll[20]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				vit11 =Float.parseFloat(parsedAll[21]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				vit12= Float.parseFloat(parsedAll[26]);
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			float[] signatureVitamines = {
				vit1,
				vit2,
				vit3,
				vit4,
				vit5,
				vit6,
				vit7,
				vit8,
				vit9,
				vit10,
				vit11,
				vit12
					};	
			
			float fer=0;
			float calc = 0;
			float magn = 0;
			try {
				if(parsedAll[24].equals(null)) {
					fer = Float.parseFloat(parsedAll[25]);
				} else {
					fer = Float.parseFloat(parsedAll[24]);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				calc = Float.parseFloat(parsedAll[22]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				magn = Float.parseFloat(parsedAll[23]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			float[] signatureMineraux = {
					calc,
					magn,
					fer
			};
			System.out.println("++++"+nomProduit);
		
		

			String[] parsedIngredients = Parseur.parseurCustom(Formateur.formateurCustom(parsedAll[4], "", "_").toLowerCase(),TestDelim.testDelim(parsedAll[4]));

			String[] parsedAllergenes = Parseur.parseurCustom(Formateur.formateurCustom(parsedAll[28], "", "_").toLowerCase(), TestDelim.testDelim(parsedAll[28]));
			String[] parsedAdditifs = Parseur.parseurCustom(Formateur.formateurCustom(parsedAll[29], "", "_").toLowerCase(), TestDelim.testDelim(parsedAll[29]));
			EntityTransaction tr = em.getTransaction();
			tr.begin();
			
			Categorie categorie = categorieDao.insertIfNotExist(em, nomCategorie);
			Marque marque = marqueDao.insertIfNotExistCustom(em, nomMarque);
			MacroElements macroElements = macroElementDao.insertIfNotExistCustom(em, signatureMacro);
			Vitamines vitamines = vitaminesDao.insertIfNotExistCustom(em, signatureVitamines);
			Mineraux mineraux = minerauxDao.insertIfNotExistCustom(em, signatureMineraux);
			
			Set<Ingredient> ingredients = new HashSet<>();
			
			
			for(String i : parsedIngredients) {
				i = i.trim();
				if(i.length()>25) {
					continue;
				}
				Ingredient ingredient = ingredientsDao.insertIfNotExistCustom(em, i);
				if(ingredient != null){
					ingredients.add(ingredient);
				}
				
			}
			
			Set<Allergene> allergenes =  new HashSet<>();
			for(String al : parsedAllergenes) {
				al = al.trim();
				if(al.length()>25) {
					continue;
				}
				Allergene allergene = allergenesDao.insertIfNotExistCustom(em, al);
				if(allergene != null) {
					allergenes.add(allergene);
				}
				
			}
			
			Set<Additif> additifs =  new HashSet<>();
			for(String ad : parsedAdditifs) {
				ad = ad.trim();
				if(ad.length()>25) {
					continue;
				}
				Additif additif = additifDao.insertIfNotExistCustom(em, ad);
				if(additif!= null) {
					additifs.add(additif);
				}
				
			}
			
			Produit produit = new Produit(nomProduit, nutrition, energie, fibre, sel, huile, allergenes, additifs, ingredients, vitamines, macroElements, mineraux, marque, categorie);
			
			System.out.println("°°°00"+""
					+ produit.toString()
					+ ""
					+ ""
			
					);
			
			Produit produitT = produitDao.insertIfNotExistCustom(em, produit);
			
			tr.commit();
			
		}
		
	}

}
