package dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import model.ChiTietCombo;
import ultis.JpaUltis;

public class ChiTietComBoDAO implements EntityDAO<ChiTietCombo>{

		private EntityManager entityManager = JpaUltis.getEntityManager();
		
		@Override
		protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
		}

		@Override
		public ChiTietCombo create(ChiTietCombo entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ChiTietCombo update(ChiTietCombo entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean delete(String id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public List<ChiTietCombo> selectAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ChiTietCombo findById(String id) {
			// TODO Auto-generated method stub
			return null;
		}
}
