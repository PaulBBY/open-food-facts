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
		List<Categorie> categorieR = query.getResultList();
		if (categorieR.size() == 0) {
			return null;
		}
		return categorieR.get(0);

	}

	public Categorie selectCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub

		TypedQuery<Categorie> query = em.createQuery("select c from Categorie c where c.nomCategorie= :categorie",
				Categorie.class);
		query.setParameter("categorie", valeur);
		List<Categorie> categorieR = query.getResultList();
		if (categorieR.size() == 0) {
			return null;
		}
		return categorieR.get(0);

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
		}
		return categorieE;

	}

	public Categorie insertIfNotExistCustom(EntityManager em, String valeur) {
		Categorie categorieE = selectCustom(em, valeur);
		if (categorieE == null) {
			Categorie categorie = new Categorie(valeur);
			em.persist(categorie);
			return categorie;
		}
		return categorieE;

	}

	@Override
	public int updateCustom(EntityManager em, Categorie t1, Categorie t2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteCustom(EntityManager em, Categorie t) {
		// TODO Auto-generated method stub
		return false;
	}

}
