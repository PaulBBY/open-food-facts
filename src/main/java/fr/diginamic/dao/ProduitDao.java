package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.Produit;

public class ProduitDao implements Dao<Produit>{

	@Override
	public List<Produit> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Produit selectCustom(EntityManager em, Produit produit) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Produit> query = em.createQuery("select p from Produit p where "
					+ "p.nomProduit= :name", Produit.class);
			query.setParameter(1, produit.getNomProduit());
			Produit produitR = query.getSingleResult();

			return produitR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public Produit selectCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Produit> query = em.createQuery("select p from Produit p where "
					+ "p.nomProduit= :name", Produit.class);
			query.setParameter(1, valeur);
			Produit produitR = query.getSingleResult();

			return produitR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public Produit selectCustom(EntityManager em, int id) {
		// TODO Auto-generated method stub
		return em.find(Produit.class, id);
	}

	@Override
	public Produit insertIfNotExistCustom(EntityManager em, Produit produit) {
		// TODO Auto-generated method stub
		Produit produitE = selectCustom(em, produit);
		if(produitE == null) {
			em.persist(produit);
			return null;
		} else {
			return produitE;
		}
	}
	


	@Override
	public boolean delete(Produit t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(String ancienNom, String nouveauNom, EntityManager em) {
		// TODO Auto-generated method stub
		return 0;
	}


}
