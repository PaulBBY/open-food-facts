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
		TypedQuery<MacroElements> query = em.createQuery(
				"select m from MacroElements m where m.quantiteGraisse= :p1 AND m.quantiteSucre= :p2 AND m.quantiteProteine= :p3",
				MacroElements.class);
		query.setParameter("p1", macroElement.getQuantiteGraisse());
		query.setParameter("p2", macroElement.getQuantiteSucre());
		query.setParameter("p3", macroElement.getQuantiteProteine());
		List<MacroElements> macroElementsR = query.getResultList();
		if (macroElementsR.size() == 0) {
			return null;
		}
		return macroElementsR.get(0);

	}

	public MacroElements selectCustom(EntityManager em, float... valeurs) {
		// TODO Auto-generated method stub
		TypedQuery<MacroElements> query = em.createQuery("select m from MacroElements m where m.quantiteGraisse= :p1 AND m.quantiteSucre= :p2 AND m.quantiteProteine= :p3",
				MacroElements.class);
		query.setParameter("p1", valeurs[0]);
		query.setParameter("p2", valeurs[1]);
		query.setParameter("p3", valeurs[2]);
		List<MacroElements> macroElementsR = query.getResultList();
		if (macroElementsR.size() == 0) {
			return null;
		}
		return macroElementsR.get(0);

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
		}
		return macroElementsE;

	}

	public MacroElements insertIfNotExistCustom(EntityManager em, float... valeurs) {
		// TODO Auto-generated method stub
		MacroElements macroElementsE = selectCustom(em, valeurs);
		if (macroElementsE == null) {
			MacroElements macroElements = new MacroElements(valeurs);
			em.persist(macroElements);
			return macroElements;
		}
		return macroElementsE;

	}

	@Override
	public int updateCustom(EntityManager em, MacroElements t1, MacroElements t2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteCustom(EntityManager em, MacroElements t) {
		// TODO Auto-generated method stub
		return false;
	}

}
