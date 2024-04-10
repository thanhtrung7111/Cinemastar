package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ThanhPho;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.ThanhPhoDAO;

/**
 * Servlet implementation class ThanhPhoServlet
 */
@WebServlet({ "/admin/thanhphos", "/admin/createthanhpho", "/admin/updatethanhpho", "/admin/deletethanhpho" })
public class ThanhPhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ThanhPhoDAO thanhPhoDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThanhPhoServlet() {
		super();
		thanhPhoDAO = new ThanhPhoDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("thanhphos")) {
			List<ThanhPho> thanhPhos = thanhPhoDAO.selectAll();
			req.setAttribute("thanhPhos", thanhPhos);
			req.setAttribute("view", "/views/admin/thanhpho/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createthanhpho")) {
			createThanhPho(req, resp);
		} else if (uri.contains("updatethanhpho")) {
			updateThanhPho(req, resp);
		} else if (uri.contains("deletethanhpho")) {
			deleteThanhPho(req, resp);
		}
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void createThanhPho(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				thanhPhoDAO = new ThanhPhoDAO();
				ThanhPho thanhPho = new ThanhPho();
				BeanUtils.populate(thanhPho, req.getParameterMap());
				thanhPhoDAO.create(thanhPho);
				resp.sendRedirect("/cinemastar/admin/thanhphos");

			} catch (Exception e) {
				req.setAttribute("view", "/views/admin/thanhpho/create.jsp");
				req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
			}

		} else {
			req.setAttribute("view", "/views/admin/thanhpho/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateThanhPho(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				ThanhPho thanhPho = new ThanhPho();
				BeanUtils.populate(thanhPho, req.getParameterMap());
				thanhPhoDAO.update(thanhPho);
				resp.sendRedirect("/cinemastar/admin/thanhphos");
			} catch (Exception e) {
				ThanhPho thanhPho = thanhPhoDAO.findById(req.getParameter("maThanhPho"));
				req.setAttribute("thanhpho", thanhPho);
				req.setAttribute("view", "/views/admin/thanhpho/update.jsp");
				req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
			}

		} else {
			ThanhPho thanhPho = thanhPhoDAO.findById(req.getParameter("maThanhPho"));
			req.setAttribute("thanhpho", thanhPho);
			req.setAttribute("view", "/views/admin/thanhpho/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteThanhPho(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			String id = req.getParameter("maThanhPho");
			thanhPhoDAO.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		resp.sendRedirect("/cinemastar/admin/thanhphos");
	}
}
