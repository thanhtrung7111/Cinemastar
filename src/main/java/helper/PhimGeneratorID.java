package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.NhanVienDAO;
import dao.PhimDAO;

public class PhimGeneratorID implements IdentifierGenerator {
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		PhimDAO phimDAO = new PhimDAO();
		String id = phimDAO.maxIDPhim();
		String result = "";
		if (id == null || id.equals("")) {
			result = "PP00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "PP", ++number);
		}
		return result;
	}
}
