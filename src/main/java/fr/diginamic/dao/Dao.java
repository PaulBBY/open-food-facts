package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface Dao<T> {
	
	List<T> selectAll(EntityManager em);
	T insertIfNotExistCustom(EntityManager em, T t);
	int update(String ancienNom, String nouveauNom, EntityManager em);
	boolean delete(T t);
	T selectCustom(EntityManager em, T t);

}
