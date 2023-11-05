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

		TypedQuery<Mineraux> query = em.createQuery("select m from Mineraux m where m.calcium100g= :p1 AND m.magnesium100g= :p2 AND m.fer100g= :p3", Mineraux.class);
		query.setParameter("p1", mineraux.getCalclium100g());
		query.setParameter("p2", mineraux.getMagnesium100g());
		query.setParameter("p3", mineraux.getFer100g());
		List<Mineraux> minerauxR = query.getResultList();
		if (minerauxR.size() == 0) {
			return null;
		}
		return minerauxR.get(0);

	}

	public Mineraux selectCustom(EntityManager em, float... values) {
		// TODO Auto-generated method stub

		TypedQuery<Mineraux> query = em.createQuery("select m from Mineraux m where m.calcium100g= :p1 AND m.magnesium100g= :p2 AND m.fer100g= :p3", Mineraux.class);
		query.setParameter("p1", values[0]);
		query.setParameter("p2", values[1]);
		query.setParameter("p3", values[2]);
		List<Mineraux> minerauxR = query.getResultList();
		if (minerauxR.size() == 0) {
			return null;
		}
		return minerauxR.get(0);
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
		}
		return minerauxE;

	}

	public Mineraux insertIfNotExistCustom(EntityManager em, float... values) {
		// TODO Auto-generated method stub
		Mineraux minerauxE = selectCustom(em, values);
		if (minerauxE == null) {
			Mineraux mineraux = new Mineraux(values);
			em.persist(mineraux);
			return mineraux;
		}
		return minerauxE;

	}

	@Override
	public int updateCustom(EntityManager em, Mineraux t1, Mineraux t2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteCustom(EntityManager em, Mineraux t) {
		// TODO Auto-generated method stub
		return false;
	}

}
