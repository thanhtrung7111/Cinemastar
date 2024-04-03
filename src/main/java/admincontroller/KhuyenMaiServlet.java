package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.KhuyenMai;
import model.ThanhPho;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import dao.KhuyenMaiDAO;
import dao.ThanhPhoDAO;

/**
 * Servlet implementation class KhuyenMaiServlet
 */
@WebServlet({ "/admin/khuyenmais", "/admin/createkhuyenmai", "/admin/updatekhuyenmai", "/admin/deletekhuyenmai" })
public class KhuyenMaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhuyenMaiDAO khuyenMaiDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KhuyenMaiServlet() {
		super();
		khuyenMaiDAO = new KhuyenMaiDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("khuyenmais")) {
			List<KhuyenMai> khuyenMais = khuyenMaiDAO.selectAll();
			req.setAttribute("khuyenMais", khuyenMais);
			req.setAttribute("view", "/views/admin/khuyenmai/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createkhuyenmai")) {
			createKhuyenMai(req, resp);
		} else if (uri.contains("updatekhuyenmai")) {
			updateKhuyenMai(req, resp);
		} else if (uri.contains("deletekhuyenmai")) {
			deleteKhuyenMai(req, resp);
		}
	
	}

	private void createKhuyenMai(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				KhuyenMai thanhPho = new KhuyenMai();
				DateTimeConverter dtc = new DateConverter(new Date());
				dtc.setPattern("MM/dd/yyyy");
				ConvertUtils.register(dtc, Date.class);
				BeanUtils.populate(thanhPho, req.getParameterMap());
				khuyenMaiDAO.create(thanhPho);

				resp.sendRedirect("/cinemastar/admin/khuyenmais");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			req.setAttribute("view", "/views/admin/khuyenmai/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateKhuyenMai(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				KhuyenMai khuyenMai = new KhuyenMai();
				DateTimeConverter dtc = new DateConverter(new Date());
				dtc.setPattern("MM/dd/yyyy");
				ConvertUtils.register(dtc, Date.class);
				BeanUtils.populate(khuyenMai, req.getParameterMap());
				khuyenMaiDAO.update(khuyenMai);
				resp.sendRedirect("/cinemastar/admin/khuyenmais");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			KhuyenMai khuyenMai = khuyenMaiDAO.findById(req.getParameter("maKhuyenMai"));
			req.setAttribute("khuyenMai", khuyenMai);
			req.setAttribute("view", "/views/admin/khuyenmai/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteKhuyenMai(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("maKhuyenMai");
		khuyenMaiDAO.delete(id);
		resp.sendRedirect("/cinemastar/admin/khuyenmais");
	}
}
