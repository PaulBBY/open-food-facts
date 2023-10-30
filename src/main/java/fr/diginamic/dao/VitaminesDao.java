package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.element.Vitamines;

public class VitaminesDao implements Dao<Vitamines>{

	@Override
	public List<Vitamines> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vitamines selectCustom(EntityManager em, Vitamines vitamines) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Vitamines> query = em.createQuery("select v from Vitamines v where "
					+ "v.vitA100g= ? AND "
					+ "v.vitD100g= ? AND "
					+ "v.vitE100g= ? AND "
					+ "v.vitK100g= ? AND "
					+ "v.vitC100g= ? AND "
					+ "v.vitB1100g= ? AND "
					+ "v.vitB2100g= ? AND "
					+ "v.vitPP100g= ? AND "
					+ "v.vitB6100g= ? AND "
					+ "v.vitB12100g= ? AND "
					+ "v.betaCarotene100g= ?", Vitamines.class);
			query.setParameter(1, vitamines.getVitA100g());
			query.setParameter(2, vitamines.getVitD100g());
			query.setParameter(3, vitamines.getVitE100g());
			query.setParameter(4, vitamines.getVitK100g());
			query.setParameter(5, vitamines.getVitD100g());
			query.setParameter(6, vitamines.getVitB1100g());
			query.setParameter(7, vitamines.getVitB2100g());
			query.setParameter(8, vitamines.getVitPP100g());
			query.setParameter(9, vitamines.getVitB6100g());
			query.setParameter(10, vitamines.getVitB12100g());
			query.setParameter(11, vitamines.getBetaCarotene100g());
			Vitamines vitaminesR = query.getSingleResult();
			
			return vitaminesR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public Vitamines selectCustom(EntityManager em, float... values) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Vitamines> query = em.createQuery("select v from Vitamines v where "
					+ "v.vitA100g= ? AND "
					+ "v.vitD100g= ? AND "
					+ "v.vitE100g= ? AND "
					+ "v.vitK100g= ? AND "
					+ "v.vitC100g= ? AND "
					+ "v.vitB1100g= ? AND "
					+ "v.vitB2100g= ? AND "
					+ "v.vitPP100g= ? AND "
					+ "v.vitB6100g= ? AND "
					+ "v.vitB12100g= ? AND "
					+ "v.betaCarotene100g= ?", Vitamines.class);
			query.setParameter(1, values[0]);
			query.setParameter(2, values[1]);
			query.setParameter(3, values[2]);
			query.setParameter(4, values[3]);
			query.setParameter(5, values[4]);
			query.setParameter(6, values[5]);
			query.setParameter(7, values[6]);
			query.setParameter(8, values[7]);
			query.setParameter(9, values[8]);
			query.setParameter(10, values[9]);
			query.setParameter(11, values[10]);
			Vitamines vitaminesR = query.getSingleResult();
			
			return vitaminesR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	
	}
	
	public Vitamines selectCustom(EntityManager em, int id) {
		// TODO Auto-generated method stub
		return em.find(Vitamines.class, id);
	}

	@Override
	public Vitamines insertIfNotExistCustom(EntityManager em, Vitamines vitamines) {
		// TODO Auto-generated method stub
		Vitamines vitaminesE = selectCustom(em, vitamines);
		if(vitaminesE == null) {
			em.persist(vitamines);
			return vitamines;
		} else {
			return vitaminesE;
		}
	}
	
	public Vitamines insertIfNotExistCustom(EntityManager em, float... valeurs) {
		// TODO Auto-generated method stub
		Vitamines vitaminesE = selectCustom(em, valeurs);
		if(vitaminesE == null) {
			Vitamines vitamines = new Vitamines(valeurs);
			em.persist(vitamines);
			return vitamines;
		} else {
			return vitaminesE;
		}
	}

	@Override
	public boolean delete(Vitamines t) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public int update(String ancienNom, String nouveauNom, EntityManager em) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
