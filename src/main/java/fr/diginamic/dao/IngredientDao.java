package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.Ingredient;

public class IngredientDao implements Dao<Ingredient> {

	@Override
	public List<Ingredient> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		TypedQuery<Ingredient> query = em.createQuery("select i from Ingredients i", Ingredient.class);
		List<Ingredient> ingredientsR = query.getResultList();
		if (ingredientsR.size() == 0) {
			return null;
		}
		return ingredientsR;

	}

	@Override
	public Ingredient selectCustom(EntityManager em, Ingredient ingredient) {
		// TODO Auto-generated method stub

		TypedQuery<Ingredient> query = em.createQuery("select i from Ingredient i where i.nomIngredient= :ingredient",
				Ingredient.class);
		query.setParameter("ingredient", ingredient.getNomIngredient());
		List<Ingredient> ingredientR = query.getResultList();
		if (ingredientR.size() == 0) {
			return null;
		}
		return ingredientR.get(0);
	}

	public Ingredient selectCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		TypedQuery<Ingredient> query = em
				.createQuery("select i from Ingredient i where " + "i.nomIngredient= :ingredient", Ingredient.class);
		query.setParameter("ingredient", valeur);
		List<Ingredient> ingredientR = query.getResultList();
		if (ingredientR.size() == 0) {
			return null;
		}
		return ingredientR.get(0);
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
		}
		return ingredientE;

	}

	public Ingredient insertIfNotExistCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		Ingredient ingredientE = selectCustom(em, valeur);
		if (ingredientE == null) {
			Ingredient ingredient = new Ingredient(valeur);
			em.persist(ingredient);
			return ingredient;
		}
		return ingredientE;

	}

	@Override
	public int updateCustom(EntityManager em, Ingredient t1, Ingredient t2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteCustom(EntityManager em, Ingredient t) {
		// TODO Auto-generated method stub
		return false;
	}

}
