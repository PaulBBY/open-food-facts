package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import fr.diginamic.entite.Marque;

public class MarqueDao implements Dao<Marque> {

	@Override
	public List<Marque> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		TypedQuery<Marque> query = em.createQuery("select m from Marque m", Marque.class);
		List<Marque> marquesR = query.getResultList();

		return marquesR;
	}

	@Override
	public Marque selectCustom(EntityManager em, Marque marque) {
		// TODO Auto-generated method stub

		TypedQuery<Marque> query = em.createQuery("select m from Marque m where m.nomMarque= :marque", Marque.class);
		query.setParameter("marque", marque.getNomMarque());
		List<Marque> marqueR = query.getResultList();
		if (marqueR.size() == 0) {
			return null;
		}
		return marqueR.get(0);

	}

	public Marque selectCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub

		TypedQuery<Marque> query = em.createQuery("select m from Marque m where m.nomMarque= :marque",
				Marque.class);
		query.setParameter("marque", valeur);
		List<Marque> marqueR = query.getResultList();
		if (marqueR.size() == 0) {
			return null;
		}
		return marqueR.get(0);

	}

	public Marque selectCustom(int id, EntityManager em) {
		// TODO Auto-generated method stub
		return em.find(Marque.class, id);
	}

	@Override
	public Marque insertIfNotExistCustom(EntityManager em, Marque marque) {
		// TODO Auto-generated method stub
		Marque marqueE = selectCustom(em, marque);
		if (marqueE == null) {
			em.persist(marque);
			return marque;
		}
		return marqueE;
	}

	public Marque insertIfNotExistCustom(EntityManager em, String valeur) {
		Marque marqueE = selectCustom(em, valeur);
		if (marqueE == null) {
			Marque marque = new Marque(valeur);
			em.persist(marque);
			return marque;
		}

		return marqueE;

	}

	@Override
	public int updateCustom(EntityManager em, Marque t1, Marque t2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteCustom(EntityManager em, Marque t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
