package org.sodeja.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {
	
	private Class<T> clazz;
	private SessionFactory sessionFactory;
	
	@Override
	public void create(T object) {
		getSession().save(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T retrieve(ID id) {
		return (T) getSession().load(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> retrieveAll() {
		return getSession().createCriteria(clazz).list();
	}

	@Override
	public void update(T object) {
		getSession().update(object);
	}

	@Override
	public void delete(T object) {
		getSession().delete(object);
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	protected void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
