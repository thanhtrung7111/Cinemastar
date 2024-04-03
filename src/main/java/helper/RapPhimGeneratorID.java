package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.KhuyenMaiDAO;
import dao.RapPhimDAO;

public class RapPhimGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		RapPhimDAO rapPhimDAO = new RapPhimDAO();
		String id = rapPhimDAO.maxIDRapPhim();
		String result = "";
		if (id == null || id.equals("")) {
			result = "RP00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "RP", ++number);
		}
		return result;
	}
}
