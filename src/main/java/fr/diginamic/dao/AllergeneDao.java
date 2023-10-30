package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.Allergene;

public class AllergeneDao implements Dao<Allergene> {

	@Override
	public List<Allergene> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Allergene selectCustom(EntityManager em, Allergene allergene) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Allergene> query = em
					.createQuery("select a from Allergene a where " + "a.nomAllergene= :allergene", Allergene.class);
			query.setParameter("allergene", allergene.getNomAllergene());
			Allergene allergeneR = query.getSingleResult();

			return allergeneR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public Allergene selectCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Allergene> query = em.createQuery("select a from Allergene a where " + "a.nomAllergene= :allergene",
					Allergene.class);
			query.setParameter("allergene", valeur);
			Allergene allergeneR = query.getSingleResult();

			return allergeneR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	
	}

	public Allergene selectCustom(EntityManager em, int id) {
		// TODO Auto-generated method stub
		return em.find(Allergene.class, id);
	}

	@Override
	public Allergene insertIfNotExistCustom(EntityManager em, Allergene allergene) {
		// TODO Auto-generated method stub
		Allergene allergeneE = selectCustom(em, allergene);
		if (allergeneE == null) {
			em.persist(allergene);
			return allergene;
		} else {
			return allergeneE;
		}
	}

	public Allergene insertIfNotExistCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		Allergene allergeneE = selectCustom(em, valeur);
		if (allergeneE == null) {
			Allergene allergene = new Allergene(valeur);
			em.persist(allergene);
			return allergene;
		} else {
			return allergeneE;
		}
	}

	@Override
	public boolean delete(Allergene t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(String ancienNom, String nouveauNom, EntityManager em) {
		// TODO Auto-generated method stub
		return 0;
	}

}
