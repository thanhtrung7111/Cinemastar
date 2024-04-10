package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HangGhe;
import model.LoaiHinh;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.HangGheDAO;

/**
 * Servlet implementation class HangGheServlet
 */
@WebServlet({ "/admin/hangghes", "/admin/createhangghe", "/admin/updatehangghe", "/admin/deletehangghe" })
public class HangGheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HangGheDAO hangGheDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HangGheServlet() {
		super();
		hangGheDAO = new HangGheDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("hangghes")) {
			List<HangGhe> hangGhes = hangGheDAO.selectAll();
			req.setAttribute("hangGhes", hangGhes);
			req.setAttribute("view", "/views/admin/hangghe/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createhangghe")) {
			createHangGhe(req, resp);
		} else if (uri.contains("updatehangghe")) {
			updateHangGhe(req, resp);
		} else if (uri.contains("deletehangghe")) {
			deleteHangGhe(req, resp);
		}

	}

	private void createHangGhe(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				HangGhe hangGhe = new HangGhe();
				BeanUtils.populate(hangGhe, req.getParameterMap());
				hangGheDAO.create(hangGhe);
				resp.sendRedirect("/cinemastar/admin/hangghes");
			} catch (Exception e) {
				req.setAttribute("view", "/views/admin/hangghe/create.jsp");
				req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("view", "/views/admin/hangghe/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateHangGhe(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				HangGhe hangGhe = new HangGhe();
				BeanUtils.populate(hangGhe, req.getParameterMap());
				hangGheDAO.update(hangGhe);
				resp.sendRedirect("/cinemastar/admin/hangghes");
			} catch (Exception e) {
				HangGhe hangGhe = hangGheDAO.findById(req.getParameter("maHangGhe"));
				req.setAttribute("hangGhe", hangGhe);
				req.setAttribute("view", "/views/admin/hangghe/update.jsp");
				req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
			}
		} else {
			HangGhe hangGhe = hangGheDAO.findById(req.getParameter("maHangGhe"));
			req.setAttribute("hangGhe", hangGhe);
			req.setAttribute("view", "/views/admin/hangghe/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteHangGhe(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			String id = req.getParameter("maHangGhe");
			hangGheDAO.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		resp.sendRedirect("/cinemastar/admin/hangghes");
	}
}
