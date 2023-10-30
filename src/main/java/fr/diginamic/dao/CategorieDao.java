package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.Categorie;

public class CategorieDao implements Dao<Categorie> {

	@Override
	public List<Categorie> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie selectCustom(EntityManager em, Categorie categorie) {
		// TODO Auto-generated method stub
		TypedQuery<Categorie> query = em.createQuery("select c from Categorie c where " + "c.nomCategorie= :categorie",
				Categorie.class);
		query.setParameter("ingredient", categorie.getNomCategorie());
		Categorie categorieR = query.getSingleResult();

		return categorieR;
	}

	public Categorie selectCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Categorie> query = em
					.createQuery("select c from Categorie c where " + "c.nomCategorie= :categorie", Categorie.class);
			query.setParameter("categorie", valeur);
			Categorie categorieR = query.getSingleResult();
			return categorieR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public Categorie selectCustom(EntityManager em, int id) {
		// TODO Auto-generated method stub
		return em.find(Categorie.class, id);
	}

	@Override
	public Categorie insertIfNotExistCustom(EntityManager em, Categorie categorie) {
		Categorie categorieE = selectCustom(em, categorie);
		if (categorieE == null) {
			em.persist(categorie);
			return categorie;
		} else {
			return categorieE;
		}

	}

	public Categorie insertIfNotExist(EntityManager em, String valeur) {
		Categorie categorieE = selectCustom(em, valeur);
		if (categorieE == null) {
			Categorie categorie = new Categorie(valeur);
			em.persist(categorie);
			return categorie;
		} else {
			return categorieE;
		}

	}

	@Override
	public boolean delete(Categorie t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(String ancienNom, String nouveauNom, EntityManager em) {
		// TODO Auto-generated method stub
		return 0;
	}

}
