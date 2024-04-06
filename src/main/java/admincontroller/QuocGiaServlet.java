package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HangGhe;
import model.QuocGia;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.QuocGiaDAO;

/**
 * Servlet implementation class QuocGiaServlet
 */
@WebServlet({"/admin/quocgias","/admin/createquocgia","/admin/updatequocgia","/admin/deletequocgia"})
public class QuocGiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuocGiaDAO quocGiaDAO;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuocGiaServlet() {
		super();
		quocGiaDAO = new QuocGiaDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("quocgias")) {
			List<QuocGia> quocGias = quocGiaDAO.selectAll();
			req.setAttribute("quocGias", quocGias);
			req.setAttribute("view", "/views/admin/quocgia/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createquocgia")) {
			createQuocGia(req, resp);
		} else if (uri.contains("updatequocgia")) {
			updateQuocGia(req, resp);
		} else if (uri.contains("deletequocgia")) {
			deleteQuocGia(req, resp);
		}

	}

	private void createQuocGia(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				QuocGia quocGia = new QuocGia();
				BeanUtils.populate(quocGia, req.getParameterMap());
				quocGiaDAO.create(quocGia);
				resp.sendRedirect("/cinemastar/admin/quocgias");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			req.setAttribute("view", "/views/admin/quocgia/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateQuocGia(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				QuocGia quocGia = new QuocGia();
				BeanUtils.populate(quocGia, req.getParameterMap());
				quocGiaDAO.update(quocGia);
				resp.sendRedirect("/cinemastar/admin/quocgias");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			QuocGia quocGia = quocGiaDAO.findById(req.getParameter("maQuocGia"));
			req.setAttribute("quocGia", quocGia);
			req.setAttribute("view", "/views/admin/quocgia/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteQuocGia(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("maQuocGia");
		quocGiaDAO.delete(id);
		resp.sendRedirect("/cinemastar/admin/quocgias");
	}

}
