package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.GheDAO;
import dao.HangGheDAO;

public class GheGeneratorID implements IdentifierGenerator{
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		GheDAO gheDAO = new GheDAO();
		String id = gheDAO.maxIDGhe();
		String result = "";
		if (id == null || id.equals("")) {
			result = "G000000000";
		} else {
			int number = Integer.parseInt(id.substring(1));
			result = String.format("%s%09d", "G", ++number);
		}
		return result;
	}
}
