package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.element.Vitamines;

public class VitaminesDao implements Dao<Vitamines> {

	@Override
	public List<Vitamines> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vitamines selectCustom(EntityManager em, Vitamines vitamines) {
		// TODO Auto-generated method stub

		TypedQuery<Vitamines> query = em.createQuery(
				"select v from Vitamines v where " + "v.vitA100g= :p1 AND " + "v.vitD100g= :p2 AND "
						+ "v.vitE100g= :p3 AND " + "v.vitK100g= :p4 AND " + "v.vitC100g= :p5 AND "
						+ "v.vitB1100g= :p6 AND " + "v.vitB2100g= :p7 AND " + "v.vitPP100g= :p8 AND "
						+ "v.vitB6100g= :p9 AND " + "v.vitB12100g= :p10 AND " + "v.betaCarotene100g= :p11",
				Vitamines.class);
		query.setParameter("p1", vitamines.getVitA100g());
		query.setParameter("p2", vitamines.getVitD100g());
		query.setParameter("p3", vitamines.getVitE100g());
		query.setParameter("p4", vitamines.getVitK100g());
		query.setParameter("p5", vitamines.getVitD100g());
		query.setParameter("p6", vitamines.getVitB1100g());
		query.setParameter("p7", vitamines.getVitB2100g());
		query.setParameter("p8", vitamines.getVitPP100g());
		query.setParameter("p9", vitamines.getVitB6100g());
		query.setParameter("p10", vitamines.getVitB12100g());
		query.setParameter("p11", vitamines.getBetaCarotene100g());
		List<Vitamines> vitaminesR = query.getResultList();
		if (vitaminesR.size() == 0) {
			return null;
		}
		return vitaminesR.get(0);

	}

	public Vitamines selectCustom(EntityManager em, float... values) {
		// TODO Auto-generated method stub

		TypedQuery<Vitamines> query = em.createQuery(
				"select v from Vitamines v where " + "v.vitA100g= :p1 AND " + "v.vitD100g= :p2 AND "
						+ "v.vitE100g= :p3 AND " + "v.vitK100g= :p4 AND " + "v.vitC100g= :p5 AND "
						+ "v.vitB1100g= :p6 AND " + "v.vitB2100g= :p7 AND " + "v.vitPP100g= :p8 AND "
						+ "v.vitB6100g= :p9 AND " + "v.vitB12100g= :p10 AND " + "v.betaCarotene100g= :p11",
				Vitamines.class);
		query.setParameter("p1", values[0]);
		query.setParameter("p2", values[1]);
		query.setParameter("p3", values[2]);
		query.setParameter("p4", values[3]);
		query.setParameter("p5", values[4]);
		query.setParameter("p6", values[5]);
		query.setParameter("p7", values[6]);
		query.setParameter("p8", values[7]);
		query.setParameter("p9", values[8]);
		query.setParameter("p10", values[9]);
		query.setParameter("p11", values[10]);
		List<Vitamines> vitaminesR = query.getResultList();
		if (vitaminesR.size() == 0) {
			return null;
		}
		return vitaminesR.get(0);

	}

	public Vitamines selectCustom(EntityManager em, int id) {
		// TODO Auto-generated method stub
		return em.find(Vitamines.class, id);
	}

	@Override
	public Vitamines insertIfNotExistCustom(EntityManager em, Vitamines vitamines) {
		// TODO Auto-generated method stub
		Vitamines vitaminesE = selectCustom(em, vitamines);
		if (vitaminesE == null) {
			em.persist(vitamines);
			return vitamines;
		}
		return vitaminesE;

	}

	public Vitamines insertIfNotExistCustom(EntityManager em, float... valeurs) {
		// TODO Auto-generated method stub
		Vitamines vitaminesE = selectCustom(em, valeurs);
		if (vitaminesE == null) {
			Vitamines vitamines = new Vitamines(valeurs);
			em.persist(vitamines);
			return vitamines;
		}
		return vitaminesE;

	}

	@Override
	public int updateCustom(EntityManager em, Vitamines t1, Vitamines t2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteCustom(EntityManager em, Vitamines t) {
		// TODO Auto-generated method stub
		return false;
	}

}
