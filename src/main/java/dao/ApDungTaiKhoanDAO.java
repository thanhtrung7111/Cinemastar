package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.ApDungTaiKhoan;
import ultis.JpaUltis;

public class ApDungTaiKhoanDAO implements EntityDAO<ApDungTaiKhoan> {
	private EntityManager entityManager = JpaUltis.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	@Override
	public ApDungTaiKhoan create(ApDungTaiKhoan entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApDungTaiKhoan update(ApDungTaiKhoan entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ApDungTaiKhoan> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApDungTaiKhoan findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
