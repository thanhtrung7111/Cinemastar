package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.HoaDon;
import model.KhuyenMai;
import ultis.JpaUltis;

public class HoaDonDAO implements EntityDAO<HoaDon>{

	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public HoaDon create(HoaDon entity) {
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
	public HoaDon update(HoaDon entity) {
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
			HoaDon entity = entityManager.find(HoaDon.class, id);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<HoaDon> selectAll() {
		String jpql = "SELECT o from HoaDon o";
		TypedQuery<HoaDon> query = entityManager.createQuery(jpql, HoaDon.class);
		List<HoaDon> khuyenMais = query.getResultList();
		return khuyenMais;
	}
	
	public String maxIDHoaDon() {
		String jpql = "SELECT max(t.maHD) from HoaDon t";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		if(query == null || query.equals("")) {
			return "HD00000000";
		}
		return query.getSingleResult();
	}

	@Override
	public HoaDon findById(String id) {
		try {
			HoaDon entity = entityManager.find(HoaDon.class, id);
			return entity;
		} catch (Exception e) {

		}
		return null;
	}
	
	public HoaDon findByCode(String code) {
		try {
			String jpql = "select o from HoaDon o where o.code = :code";
			TypedQuery<HoaDon> query = entityManager.createQuery(jpql,HoaDon.class);
			query.setParameter("code", code);
			HoaDon hd = query.getSingleResult();
			return hd;
		} catch (Exception e) {

		}
		return null;
	}
}
