package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ghe;
import model.Phim;
import model.PhongPhim;
import model.RapPhim;
import model.SuatChieu;
import model.Ve;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import dao.PhimDAO;
import dao.PhongPhimDAO;
import dao.SuatChieuDAO;
import dao.VeDAO;

/**
 * Servlet implementation class SuatChieuServlet
 */
@WebServlet({ "/admin/suatchieus", "/admin/createsuatchieu", "/admin/updatesuatchieu", "/admin/deletesuatchieu" })
public class SuatChieuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SuatChieuDAO suatChieuDAO;
	private PhongPhimDAO phongPhimDAO;
	private PhimDAO phimDAO;
	private VeDAO veDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuatChieuServlet() {
		super();
		suatChieuDAO = new SuatChieuDAO();
		phongPhimDAO = new PhongPhimDAO();
		phimDAO = new PhimDAO();
		veDAO = new VeDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("suatchieus")) {
			List<SuatChieu> suatChieus = suatChieuDAO.selectAll();
			req.setAttribute("suatChieus", suatChieus);
			req.setAttribute("view", "/views/admin/suatchieu/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createsuatchieu")) {
			createSuatChieu(req, resp);
		} else if (uri.contains("updatesuatchieu")) {
			updateSuatChieu(req, resp);
		} else if (uri.contains("deletesuatchieu")) {
			deleteSuatChieu(req, resp);
		}

	}

	private void createSuatChieu(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				DateTimeConverter dtc = new DateConverter(new Date());
				dtc.setPattern("MM/dd/yyyy");
				ConvertUtils.register(dtc, Date.class);
				SuatChieu suatChieu = new SuatChieu();
				PhongPhim phongPhim = phongPhimDAO.findById(req.getParameter("maPhongPhim"));
				Phim phim = phimDAO.findById(req.getParameter("maPhim"));
				BeanUtils.populate(suatChieu, req.getParameterMap());
				suatChieu.setPhongPhim(phongPhim);
				suatChieu.setPhim(phim);
				suatChieuDAO.create(suatChieu);
				SuatChieu suatChieuFind = suatChieuDAO.findById(suatChieuDAO.maxIDSuatChieu());
				if (suatChieuFind != null) {
					for (Ghe ghe : phongPhim.getGhes()) {
						Ve ve = new Ve();
						ve.setGhe(ghe);
						ve.setSuatChieu(suatChieuFind);
						ve.setTongTien(ghe.getLoaiGhe().getChiPhi());
						veDAO.create(ve);
					}
				}
				resp.sendRedirect("/cinemastar/admin/suatchieus");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			List<PhongPhim> phongPhims = phongPhimDAO.selectAll();
			List<Phim> phims = phimDAO.selectAll();
			req.setAttribute("phongPhims", phongPhims);
			req.setAttribute("phims", phims);
			req.setAttribute("view", "/views/admin/suatchieu/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateSuatChieu(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				DateTimeConverter dtc = new DateConverter(new Date());
				dtc.setPattern("MM/dd/yyyy");
				ConvertUtils.register(dtc, Date.class);
				SuatChieu suatChieu = new SuatChieu();
				PhongPhim phongPhim = phongPhimDAO.findById(req.getParameter("maPhongPhim"));
				Phim phim = phimDAO.findById(req.getParameter("maPhim"));
				BeanUtils.populate(suatChieu, req.getParameterMap());
				suatChieu.setPhongPhim(phongPhim);
				suatChieu.setPhim(phim);
				suatChieuDAO.update(suatChieu);
				resp.sendRedirect("/cinemastar/admin/suatchieus");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			SuatChieu suatChieu = suatChieuDAO.findById(req.getParameter("maSuatChieu"));
			List<PhongPhim> phongPhims = phongPhimDAO.selectAll();
			List<Phim> phims = phimDAO.selectAll();
			req.setAttribute("phongPhims", phongPhims);
			req.setAttribute("phims", phims);
			req.setAttribute("suatChieu", suatChieu);
			req.setAttribute("view", "/views/admin/suatchieu/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteSuatChieu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("maSuatChieu");
		suatChieuDAO.delete(id);
		resp.sendRedirect("/cinemastar/admin/suatchieus");
	}
}
