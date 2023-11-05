package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.Allergene;
import fr.diginamic.entite.Categorie;
import fr.diginamic.entite.Ingredient;
import fr.diginamic.entite.Marque;
import fr.diginamic.entite.Produit;

public class ProduitDao implements Dao<Produit> {

	/** Méthode retournant 10 Produit (sous forme de List) d'une catégorie renseignée en paramètre ayant le meilleur score nutritionnel renseignée en paramètre.
	 * Cette méthode est surchargée à plusieurs reprises.
	 * @param em instance (depuis le main) de l'entity manager pour faire la requête JPQL
	 * @param cat instance de Categorie. La méthode utilise la propriété nomCategorie de l'objet dans une requête JPQL, pour récupérer les Produits possédant la catégorie portant ce nom.
	 * @return List de 10 produits de la catégorie rentrée en paramétre, avec le meilleur score nutritionnel
	 */
	public List<Produit> select10Custom(EntityManager em,  Categorie cat) {
		TypedQuery<Produit> query = em
				.createQuery("select p from Produit p join p.categorie c where c.nomCategorie= :categorie order by p.nutritionGradeFr asc",
						Produit.class)
				.setParameter("categorie", cat.getNomCategorie()).setMaxResults(10);
		List<Produit> produitsTop10 = query.getResultList();
		if (produitsTop10.size() == 0) {
			return null;
		}
		return produitsTop10;

	}
	
	/** Méthode retournant 10 Produit (sous forme de List) d'une marque renseignée en paramètre ayant le meilleur score nutritionnel renseignée en paramètre.
	 * Cette méthode est surchargée à plusieurs reprises.
	 * @param em instance (depuis le main) de l'entity manager pour faire la requête JPQL
	 * @param mar instance de Marque. La méthode utilise la propriété nomMarque de l'objet dans une requête JPQL, pour récupérer les Produits possédant la catégorie portant ce nom.
	 * @return List de 10 produits de la marque rentrée en paramétre, avec le meilleur score nutritionnel
	 */
	public List<Produit> select10Custom(EntityManager em, Marque mar) {
		TypedQuery<Produit> query = em
				.createQuery("select p from Produit p join p.marque m where m.nomMarque= :marque order by p.nutritionGradeFr asc",
						Produit.class)
				.setParameter("marque", mar.getNomMarque()).setMaxResults(10);
		List<Produit> produitsTop10 = query.getResultList();
		if (produitsTop10.size() == 0) {
			return null;
		}
		return produitsTop10;
	}
	
	/** Méthode retournant 10 Produit (sous forme de List) d'une catégorie renseignée en paramètre
	 * ayant le meilleur score nutritionnel renseignée en paramètre, en excluant un Ingredient.
	 * Cette méthode est surchargée à plusieurs reprises.
	 * @param em instance (depuis le main) de l'entity manager pour faire la requête JPQL
	 * @param cat instance de Categorie. La méthode utilise la propriété nomMarque de l'objet dans une requête JPQL, pour récupérer les Produit possédant la catégorie portant ce nom.
	 * @param ing instance de Ingredient. La méthode utilise la proprité nomIngredient de l'objet dans une requête JPQL, pour récupérer les Produit ne possédant pas cet ingrédient dans leur set d'Ingredient.
	 * @return List de 10 produits de la catégorie rentrée en paramétre, avec le meilleur score nutritionnel, en excluant un ingrédient.
	 */
	public List<Produit> select10CustomEx(EntityManager em, Categorie cat, Ingredient ing) {
		TypedQuery<Produit> query = em
				.createQuery("select p from Produit p join p.categorie c where c.nomCategorie= :categorie and :ingredient not member of p.ingredients order by p.nutritionGradeFr asc",
						Produit.class)
				.setParameter("categorie", cat.getNomCategorie()).setParameter("ingredient", ing)
				.setMaxResults(10);
		List<Produit> produitsTop10 = query.getResultList();
		if (produitsTop10.size() == 0) {
			return null;
		}
		return produitsTop10;
	}
	
	/** Méthode retournant 10 Produit (sous forme de List) d'une marque renseignée en paramètre
	 * ayant le meilleur score nutritionnel renseignée en paramètre, en excluant un Ingredient.
	 * Cette méthode est surchargée à plusieurs reprises.
	 * @param em instance (depuis le main) de l'entity manager pour faire la requête JPQL
	 * @param mar instance de Marque. La méthode utilise la propriété nomMarque de l'objet dans une requête JPQL, pour récupérer les Produit possédant la marque portant ce nom.
	 * @param ing instance de Ingredient. La méthode utilise la proprité nomIngredient de l'objet dans une requête JPQL, pour récupérer les Produit ne possédant pas cet ingrédient dans leur set d'Ingredient.
	 * @return List de 10 produits de la marque rentrée en paramétre, avec le meilleur score nutritionnel, en excluant un ingrédient.
	 */
	public List<Produit> select10CustomEx(EntityManager em, Marque mar, Ingredient ing) {
		TypedQuery<Produit> query = em
				.createQuery("select p from Produit p join p.marque m where m.nomMarque= :marque and :ingredient not member of p.ingredients order by p.nutritionGradeFr asc",
						Produit.class)
				.setParameter("marque", mar.getNomMarque()).setParameter("ingredient", ing)
				.setMaxResults(10);
		List<Produit> produitsTop10 = query.getResultList();
		if (produitsTop10.size() == 0) {
			return null;
		}
		return produitsTop10;
	}
	

	/** Méthode retournant 10 Produit (sous forme de List) d'une catégorie renseignée en paramètre
	 * ayant le meilleur score nutritionnel renseignée en paramètre, en excluant un allergene.
	 * Cette méthode est surchargée à plusieurs reprises.
	 * @param em instance (depuis le main) de l'entity manager pour faire la requête JPQL
	 * @param cat instance de Categorie. La méthode utilise la propriété nomMarque de l'objet dans une requête JPQL, pour récupérer les Produit possédant la catégorie portant ce nom.
	 * @param all instance de Allergene. La méthode utilise la proprité nomAllergene de l'objet dans une requête JPQL, pour récupérer les Produit ne possédant pas cet allergene dans leur set d'Allergene.
	 * @return List de 10 produits de la catégorie rentrée en paramétre, avec le meilleur score nutritionnel, en excluant un allergene.
	 */
	public List<Produit> select10CustomEx(EntityManager em, Categorie cat, Allergene all) {
		TypedQuery<Produit> query = em
				.createQuery("select p from Produit p join p.categorie c where c.nomCategorie= :categorie and :allergene not in p.allergenes order by p.nutritionGradeFr asc",
						Produit.class)
				.setParameter("marque", cat.getNomCategorie()).setParameter("allergene", all.getNomAllergene())
				.setMaxResults(10);
		List<Produit> produitsTop10 = query.getResultList();
		if (produitsTop10.size() == 0) {
			return null;
		}
		return produitsTop10;
	}
	
	/** Méthode retournant 10 Produit (sous forme de List) d'une marque renseignée en paramètre
	 * ayant le meilleur score nutritionnel renseignée en paramètre, en excluant un Allergene.
	 * Cette méthode est surchargée à plusieurs reprises.
	 * @param em instance (depuis le main) de l'entity manager pour faire la requête JPQL
	 * @param mar instance de Marque. La méthode utilise la propriété nomMarque de l'objet dans une requête JPQL, pour récupérer les Produit possédant la marque portant ce nom.
	 * @param all instance de Allergene. La méthode utilise la proprité nomAllergene de l'objet dans une requête JPQL, pour récupérer les Produit ne possédant pas cet allergene dans leur set d'Allergene.
	 * @return List de 10 produits de la marque rentrée en paramétre, avec le meilleur score nutritionnel, en excluant un ingrédient.
	 */
	public List<Produit> select10CustomEx(EntityManager em, Marque mar, Allergene all) {
		TypedQuery<Produit> query = em
				.createQuery("select p from Produit p join p.marque m where m.nomMarque= :marque and :allergene not in p.allergenes order by p.nutritionGradeFr asc",
						Produit.class)
				.setParameter("marque", mar.getNomMarque()).setParameter("allergene", all.getNomAllergene())
				.setMaxResults(10);
		List<Produit> produitsTop10 = query.getResultList();
		if (produitsTop10.size() == 0) {
			return null;
		}
		return produitsTop10;
	}

	/** Méthode pas construite car pas utilisé*/
	@Override
	public List<Produit> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/** Méthode permettant de récupérer/vérifier un Produit existant déjà en base, à partir d'une instance de Produit
	 * @param em instance (depuis le main) de l'entity manager pour faire la requête JPQL
  	 * @param produit instance de Produit (pas depuis la base 
	 * 
	 */
	@Override
	public Produit selectCustom(EntityManager em, Produit produit) {

		TypedQuery<Produit> query = em.createQuery("select p from Produit p where p.nomProduit= :name", Produit.class);
		query.setParameter("name", produit.getNomProduit());
		List<Produit> produitR = query.getResultList();
		if (produitR.size() == 0) {
			return null;
		}
		return produitR.get(0);

	}

	public Produit selectCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub

		TypedQuery<Produit> query = em.createQuery("select p from Produit p where " + "p.nomProduit= :name",
				Produit.class);
		query.setParameter("name", valeur);
		List<Produit> produitR = query.getResultList();
		if (produitR.size() == 0) {
			return null;
		}
		return produitR.get(0);

	}

	public Produit selectCustom(EntityManager em, int id) {
		// TODO Auto-generated method stub
		return em.find(Produit.class, id);
	}

	@Override
	public Produit insertIfNotExistCustom(EntityManager em, Produit produit) {
		// TODO Auto-generated method stub
		Produit produitE = selectCustom(em, produit);
		if (produitE == null) {
			em.persist(produit);
			return produit;
		}
		return produitE;

	}

	@Override
	public int updateCustom(EntityManager em, Produit t1, Produit t2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteCustom(EntityManager em, Produit t) {
		// TODO Auto-generated method stub
		return false;
	}

}
