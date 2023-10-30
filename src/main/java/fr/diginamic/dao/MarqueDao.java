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
		try {
			TypedQuery<Marque> query = em.createQuery("select m from Marque m where " + "m.nomMarque= :marque",
					Marque.class);
			query.setParameter("marque", marque.getNomMarque());
			Marque marqueR = query.getSingleResult();

			return marqueR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public Marque selectCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub

		try {
			TypedQuery<Marque> query = em.createQuery("select m from Marque m where " + "m.nomMarque= :marque",
					Marque.class);
			query.setParameter("marque", valeur);
			Marque marqueR = query.getSingleResult();

			return marqueR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
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
	public int update(String ancienNom, String nouveauNom, EntityManager em) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Marque t) {
		// TODO Auto-generated method stub
		return false;
	}

}
