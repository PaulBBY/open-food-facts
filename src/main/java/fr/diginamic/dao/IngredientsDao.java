package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.Ingredient;

public class IngredientsDao implements Dao<Ingredient> {

	@Override
	public List<Ingredient> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		TypedQuery<Ingredient> query = em.createQuery("select i from Ingredients i", Ingredient.class);
		List<Ingredient> ingredientsR = query.getResultList();

		return ingredientsR;

	}

	@Override
	public Ingredient selectCustom(EntityManager em, Ingredient ingredient) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Ingredient> query = em.createQuery(
					"select i from Ingredients i where " + "i.nomIngredient= :ingredient", Ingredient.class);
			query.setParameter("ingredient", ingredient.getNomIngredient());
			Ingredient ingredientR = query.getSingleResult();

			return ingredientR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public Ingredient selectCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Ingredient> query = em.createQuery(
					"select i from Ingredients i where " + "i.nomIngredient= :ingredient", Ingredient.class);
			query.setParameter("ingredient", valeur);
			Ingredient ingredientR = query.getSingleResult();

			return ingredientR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public Ingredient selectCustom(int id, EntityManager em) {
		// TODO Auto-generated method stub
		return em.find(Ingredient.class, id);
	}

	@Override
	public Ingredient insertIfNotExistCustom(EntityManager em, Ingredient ingredient) {
		// TODO Auto-generated method stub
		Ingredient ingredientE = selectCustom(em, ingredient);
		if (ingredientE == null) {
			em.persist(ingredient);
			return ingredient;
		} else {
			return ingredientE;
		}
	}

	public Ingredient insertIfNotExistCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		Ingredient ingredientE = selectCustom(em, valeur);
		if (ingredientE == null) {
			Ingredient ingredient = new Ingredient(valeur);
			em.persist(ingredient);
			return ingredient;
		} else {
			return ingredientE;
		}

	}

	@Override
	public boolean delete(Ingredient t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(String ancienNom, String nouveauNom, EntityManager em) {
		// TODO Auto-generated method stub
		return 0;
	}

}
