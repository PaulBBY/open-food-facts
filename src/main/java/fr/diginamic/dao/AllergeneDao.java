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
		TypedQuery<Allergene> query = em.createQuery("select a from Allergene a where " + "a.nomAllergene= :allergene",
				Allergene.class);
		query.setParameter("allergene", allergene.getNomAllergene());
		List<Allergene> allergeneR = query.getResultList();
		if (allergeneR.size() == 0) {
			return null;
		}
		return allergeneR.get(0);

	}

	public Allergene selectCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub

		TypedQuery<Allergene> query = em.createQuery("select a from Allergene a where " + "a.nomAllergene= :allergene",
				Allergene.class);
		query.setParameter("allergene", valeur);
		List<Allergene> allergeneR = query.getResultList();
		if (allergeneR.size() == 0) {
			return null;
		}
		return allergeneR.get(0);
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
		}
		return allergeneE;

	}

	public Allergene insertIfNotExistCustom(EntityManager em, String valeur) {
		// TODO Auto-generated method stub
		Allergene allergeneE = selectCustom(em, valeur);
		if (allergeneE == null) {
			Allergene allergene = new Allergene(valeur);
			em.persist(allergene);
			return allergene;
		}
		return allergeneE;

	}

	@Override
	public int updateCustom(EntityManager em, Allergene t1, Allergene t2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteCustom(EntityManager em, Allergene t) {
		// TODO Auto-generated method stub
		return false;
	}

}
