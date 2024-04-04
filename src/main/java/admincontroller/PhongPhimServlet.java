package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.KhuyenMai;
import model.PhongPhim;
import model.RapPhim;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import dao.PhongPhimDAO;
import dao.RapPhimDAO;

/**
 * Servlet implementation class PhongPhimServlet
 */
@WebServlet({ "/admin/phongphims", "/admin/createphongphim", "/admin/updatephongphim", "/admin/deletephongphim" })
public class PhongPhimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhongPhimDAO phongPhimDAO;
	private RapPhimDAO rapPhimDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhongPhimServlet() {
		super();
		phongPhimDAO = new PhongPhimDAO();
		rapPhimDAO = new RapPhimDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("phongphims")) {
			List<PhongPhim> phongPhims = phongPhimDAO.selectAll();
			req.setAttribute("phongPhims", phongPhims);
			req.setAttribute("view", "/views/admin/phongphim/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createphongphim")) {
			createPhongPhim(req, resp);
		} else if (uri.contains("updatephongphim")) {
			updatePhongPhim(req, resp);
		} else if (uri.contains("deletephongphim")) {
			deletePhongPhim(req, resp);
		}
		
	}

	private void createPhongPhim(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				PhongPhim phongPhim = new PhongPhim();
				RapPhim rapPhim = rapPhimDAO.findById(req.getParameter("maRapPhim"));
				BeanUtils.populate(phongPhim, req.getParameterMap());
				phongPhim.setRapPhim(rapPhim);
				phongPhimDAO.create(phongPhim);
				resp.sendRedirect("/cinemastar/admin/phongphims");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			List<RapPhim> rapPhims = rapPhimDAO.selectAll();
			req.setAttribute("rapPhims", rapPhims);
			req.setAttribute("view", "/views/admin/phongphim/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updatePhongPhim(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				PhongPhim phongPhim = new PhongPhim();
				RapPhim rapPhim = rapPhimDAO.findById(req.getParameter("maRapPhim"));
				BeanUtils.populate(phongPhim, req.getParameterMap());
				phongPhim.setRapPhim(rapPhim);
				phongPhimDAO.update(phongPhim);
				resp.sendRedirect("/cinemastar/admin/phongphims");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			List<RapPhim> rapPhims = rapPhimDAO.selectAll();
			PhongPhim phongPhim = phongPhimDAO.findById(req.getParameter("maPhongPhim"));
			req.setAttribute("phongPhim", phongPhim);
			req.setAttribute("rapPhims", rapPhims);
			req.setAttribute("view", "/views/admin/phongphim/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deletePhongPhim(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("maPhongPhim");
		phongPhimDAO.delete(id);
		resp.sendRedirect("/cinemastar/admin/phongphims");
	}

}
