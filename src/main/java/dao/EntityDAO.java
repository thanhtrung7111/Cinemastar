package dao;

import java.util.List;

import jakarta.persistence.Entity;

public interface EntityDAO<T> {
	public T create (T entity);
	public T update(T entity);
	public boolean delete(String id);
	public List<T> selectAll();
	public T findById(String id);
}
