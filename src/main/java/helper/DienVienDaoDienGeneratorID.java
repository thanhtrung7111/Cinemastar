package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.ComboDoAnDAO;
import dao.DienVienDaoDienDAO;

public class DienVienDaoDienGeneratorID implements IdentifierGenerator{
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		DienVienDaoDienDAO dienVienDaoDienDAO = new DienVienDaoDienDAO();
		String id = dienVienDaoDienDAO.maxIDDienVien();
		String result = "";
		if (id == null || id.equals("")) {
			result = "DV00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "DV", ++number);
		}
		return result;
	}
}
