package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.element.MacroElements;

public class MacroElementDao implements Dao<MacroElements> {

	@Override
	public List<MacroElements> selectAll(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MacroElements selectCustom(EntityManager em, MacroElements macroElement) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<MacroElements> query = em.createQuery("select m from MacroElements m where "
					+ "m.quantiteGraisse= ? AND " + "m.quantiteSucre= ? AND " + "m.quantiteProteine= ?",
					MacroElements.class);
			query.setParameter(2, macroElement.getQuantiteGraisse());
			query.setParameter(1, macroElement.getQuantiteSucre());
			query.setParameter(3, macroElement.getQuantiteProteine());
			MacroElements macroElementsR = query.getSingleResult();

			return macroElementsR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public MacroElements selectCustom(EntityManager em, float... valeurs) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<MacroElements> query = em.createQuery("select m from MacroElements m where "
					+ "m.quantiteGraisse= ? AND " + "m.quantiteSucre= ? AND " + "m.quantiteProteine= ?",
					MacroElements.class);
			query.setParameter(1, valeurs[0]);
			query.setParameter(2, valeurs[1]);
			query.setParameter(3, valeurs[2]);
			MacroElements macroElementsR = query.getSingleResult();

			return macroElementsR;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public MacroElements selectCustom(EntityManager em, int id) {
		// TODO Auto-generated method stub
		return em.find(MacroElements.class, id);
	}

	@Override
	public MacroElements insertIfNotExistCustom(EntityManager em, MacroElements macroElements) {
		// TODO Auto-generated method stub
		MacroElements macroElementsE = selectCustom(em, macroElements);
		if (macroElementsE == null) {
			em.persist(macroElements);
			return macroElements;
		} else {
			return macroElementsE;
		}
	}

	public MacroElements insertIfNotExistCustom(EntityManager em, float... valeurs) {
		// TODO Auto-generated method stub
		MacroElements macroElementsE = selectCustom(em, valeurs);
		if (macroElementsE == null) {
			MacroElements macroElements = new MacroElements(valeurs);
			em.persist(macroElements);
			return macroElements;
		} else {
			return macroElementsE;
		}
	}

	@Override
	public boolean delete(MacroElements t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(String ancienNom, String nouveauNom, EntityManager em) {
		// TODO Auto-generated method stub
		return 0;
	}

}
