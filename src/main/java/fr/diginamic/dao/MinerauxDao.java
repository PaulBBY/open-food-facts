package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.element.Mineraux;

public class MinerauxDao implements Dao<Mineraux> {

	@Override
	public List<Mineraux> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mineraux selectCustom(EntityManager em, Mineraux mineraux) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Mineraux> query = em.createQuery("select m from Mineruax m where " + "m.calcium100g= ? AND "
					+ "m.magnesium100g= ? AND " + "m.fer100g= ?", Mineraux.class);
			query.setParameter(1, mineraux.getCalclium100g());
			query.setParameter(2, mineraux.getMagnesium100g());
			query.setParameter(3, mineraux.getFer100g());
			Mineraux minerauxR = query.getSingleResult();

			return minerauxR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public Mineraux selectCustom(EntityManager em, float... values) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Mineraux> query = em.createQuery("select m from Mineruax m where " + "m.calcium100g= ? AND "
					+ "m.magnesium100g= ? AND " + "m.fer100g= ?", Mineraux.class);
			query.setParameter(1, values[0]);
			query.setParameter(2, values[1]);
			query.setParameter(3, values[2]);
			Mineraux minerauxR = query.getSingleResult();

			return minerauxR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public Mineraux selectCustom(EntityManager em, int id) {
		// TODO Auto-generated method stub
		return em.find(Mineraux.class, id);
	}

	@Override
	public Mineraux insertIfNotExistCustom(EntityManager em, Mineraux mineraux) {
		// TODO Auto-generated method stub
		Mineraux minerauxE = selectCustom(em, mineraux);
		if (minerauxE == null) {
			em.persist(mineraux);
			return mineraux;
		} else {
			return minerauxE;
		}
	}

	public Mineraux insertIfNotExistCustom(EntityManager em, float... values) {
		// TODO Auto-generated method stub
		Mineraux minerauxE = selectCustom(em, values);
		if (minerauxE == null) {
			Mineraux mineraux = new Mineraux(values);
			em.persist(mineraux);
			return mineraux;
		} else {
			return minerauxE;
		}
	}

	@Override
	public boolean delete(Mineraux t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(String ancienNom, String nouveauNom, EntityManager em) {
		// TODO Auto-generated method stub
		return 0;
	}

}
