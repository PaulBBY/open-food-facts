package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.Additif;

public class AdditifDao implements Dao<Additif> {

	@Override
	public List<Additif> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		TypedQuery<Additif> query = em.createQuery("select a from Additifs a", Additif.class);
		List<Additif> additifsR = query.getResultList();

		return additifsR;
	}

	@Override
	public Additif selectCustom(EntityManager em, Additif additif) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Additif> query = em.createQuery("select a from Additifs a where " + "a.nomAdditif= :additif",
					Additif.class);
			query.setParameter("additif", additif.getNomAdditif());
			Additif additifR = query.getSingleResult();

			return additifR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public Additif selectCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Additif> query = em.createQuery("select a from Additifs a where " + "a.nomAdditif= :additif",
					Additif.class);
			query.setParameter("additif", valeur);
			Additif additifR = query.getSingleResult();

			return additifR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public Additif selectCustom(EntityManager em, int id) {
		// TODO Auto-generated method stub
		return em.find(Additif.class, id);
	}

	@Override
	public Additif insertIfNotExistCustom(EntityManager em, Additif additif) {
		// TODO Auto-generated method stub
		Additif additifE = selectCustom(em, additif);
		if (additifE == null) {
			em.persist(additif);
			return additif;
		} else {
			return additifE;
		}
	}

	public Additif insertIfNotExistCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		Additif additifE = selectCustom(em, valeur);
		if (additifE == null) {
			Additif additif = new Additif(valeur);
			em.persist(additif);
			return additif;
		} else {
			return additifE;
		}
	}

	@Override
	public boolean delete(Additif t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(String ancienNom, String nouveauNom, EntityManager em) {
		// TODO Auto-generated method stub
		return 0;
	}

}
