package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.VaiTro;
import model.Ve;
import ultis.JpaUltis;

public class VeDAO implements EntityDAO<Ve> {
	private EntityManager entityManager = JpaUltis.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public Ve create(Ve entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Ve update(Ve entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean delete(String id) {
		try {
			entityManager.getTransaction().begin();
			Ve entity = entityManager.find(Ve.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Ve> selectAll() {
		String jpql = "SELECT o from Ve o";
		TypedQuery<Ve> query = entityManager.createQuery(jpql, Ve.class);
		List<Ve> ves = query.getResultList();
		return ves;
	}
	
	public List<Ve> selectAllBySuatChieu(String maSuatChieu) {
		String jpql = "SELECT o from Ve o where o.suatChieu.maSuatChieu = :maSuatChieu order by o.ghe.tenGhe";
		TypedQuery<Ve> query = entityManager.createQuery(jpql, Ve.class);
		query.setParameter("maSuatChieu", maSuatChieu);
		List<Ve> ves = query.getResultList();
		return ves;
	}
	
	
	public String maxIDVe() {
		String jpql = "SELECT max(t.maVe) from Ve t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		return query.getSingleResult();
	}

	@Override
	public Ve findById(String id) {
		try {
			Ve entity = entityManager.find(Ve.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}
}
