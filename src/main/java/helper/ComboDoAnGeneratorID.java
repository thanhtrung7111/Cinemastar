package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.ComboDoAnDAO;
import dao.KhuyenMaiDAO;

public class ComboDoAnGeneratorID implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		ComboDoAnDAO comboDoAnDAO = new ComboDoAnDAO();
		String id = comboDoAnDAO.maxIDCombo();
		String result = "";
		if (id == null || id.equals("")) {
			result = "CB00000000";
		} else {
			int number = Integer.parseInt(id.substring(2));
			result = String.format("%s%08d", "CB", ++number);
		}
		return result;
	}
}
