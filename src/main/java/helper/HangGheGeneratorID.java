package helper;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import dao.HangGheDAO;

public class HangGheGeneratorID implements IdentifierGenerator {

		@Override
		public Object generate(SharedSessionContractImplementor session, Object object) {
			HangGheDAO hangGheDao = new HangGheDAO();
			String id = hangGheDao.maxIDHangGhe();
			String result = "";
			if (id == null || id.equals("")) {
				result = "HG00000000";
			} else {
				int number = Integer.parseInt(id.substring(2));
				result = String.format("%s%08d", "HG", ++number);
			}
			return result;
		}
}
