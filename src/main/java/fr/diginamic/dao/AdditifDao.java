package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.Additif;

public class AdditifDao implements Dao<Additif> {

	@Override
	public List<Additif> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		TypedQuery<Additif> query = em.createQuery("select a from Additif a", Additif.class);
		List<Additif> additifsR = query.getResultList();

		return additifsR;
	}

	@Override
	public Additif selectCustom(EntityManager em, Additif additif) {
		// TODO Auto-generated method stub
		TypedQuery<Additif> query = em.createQuery("select a from Additif a where " + "a.nomAdditif= :additif",
				Additif.class);
		query.setParameter("additif", additif.getNomAdditif());
		List<Additif> additifR = query.getResultList();
		if (additifR.size() == 0) {
			return null;
		}
		return additifR.get(0);

	}

	public Additif selectCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		TypedQuery<Additif> query = em.createQuery("select a from Additif a where " + "a.nomAdditif= :additif",
				Additif.class);
		query.setParameter("additif", valeur);
		List<Additif> additifR = query.getResultList();
		if (additifR.size() == 0) {
			return null;
		}
		return additifR.get(0);

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
		}
		return additifE;

	}

	public Additif insertIfNotExistCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		Additif additifE = selectCustom(em, valeur);
		if (additifE == null) {
			Additif additif = new Additif(valeur);
			em.persist(additif);
			return additif;
		}
		return additifE;
	}

	@Override
	public int updateCustom(EntityManager em, Additif t1, Additif t2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteCustom(EntityManager em, Additif t) {
		// TODO Auto-generated method stub
		return false;
	}

}
