package org.sodeja.hibernate;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
	public void create(T object);
	
	public T retrieve(ID id);
	
	public List<T> retrieveAll();
	
	public void update(T object);
	
	public void delete(T object);
}
