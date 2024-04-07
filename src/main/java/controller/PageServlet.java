package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DienVienDaoDien;
import model.KhuyenMai;
import model.Phim;
import model.SuatChieu;

import java.io.IOException;
import java.util.List;

import dao.DienVienDaoDienDAO;
import dao.KhuyenMaiDAO;
import dao.PhimDAO;
import dao.SuatChieuDAO;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet({ "/trangchu", "/daodiens", "/dienviens", "/detaildienvien", "/phims", "/detailphim" })
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SuatChieuDAO suatChieuDAO;
	private PhimDAO phimDAO;
	private DienVienDaoDienDAO daoDienVienDaoDienDAO;
	private KhuyenMaiDAO khuyenMaiDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageServlet() {
		super();
		suatChieuDAO = new SuatChieuDAO();
		phimDAO = new PhimDAO();
		daoDienVienDaoDienDAO = new DienVienDaoDienDAO();
		khuyenMaiDAO = new KhuyenMaiDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("trangchu")) {
			pageTrangChu(req, resp);
		} else if (uri.contains("daodiens")) {
			pageDaoDien(req, resp);
		} else if (uri.contains("dienviens")) {
			pageDienVien(req, resp);
		} else if (uri.contains("detaildienvien")) {
			pageDetailDienVien(req, resp);
		} else if (uri.contains("phims")) {
			pagePhims(req, resp);
		}
		req.getRequestDispatcher("/views/user/layout.jsp").forward(req, resp);
	}

	private void pageTrangChu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Phim> phims = phimDAO.selectAllOnDay();
		req.setAttribute("phims", phims);
		req.setAttribute("view", "/views/user/page/trangchu.jsp");
	}

	private void pageDaoDien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DienVienDaoDien> dienViens = daoDienVienDaoDienDAO.selectAllByRole("Đạo diễn");
		List<Phim> phimDangChieus = phimDAO.selectAllOnDay(0, 4);
		List<KhuyenMai> khuyenMais = khuyenMaiDAO.selectAllByDate();
		req.setAttribute("khuyenMais", khuyenMais);
		req.setAttribute("phimDangChieus", phimDangChieus);
		req.setAttribute("dienViens", dienViens);
		req.setAttribute("title", "Đạo Diễn");
		req.setAttribute("view", "/views/user/page/dienviendaodien.jsp");
	}

	private void pageDienVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DienVienDaoDien> dienViens = daoDienVienDaoDienDAO.selectAllByRole("Diễn viên");
		List<Phim> phimDangChieus = phimDAO.selectAllOnDay(0, 4);
		List<KhuyenMai> khuyenMais = khuyenMaiDAO.selectAllByDate();
		req.setAttribute("khuyenMais", khuyenMais);
		req.setAttribute("phimDangChieus", phimDangChieus);
		req.setAttribute("dienViens", dienViens);
		req.setAttribute("title", "Diễn Viên");
		req.setAttribute("view", "/views/user/page/dienviendaodien.jsp");
	}

	private void pageDetailDienVien(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DienVienDaoDien dienVien = daoDienVienDaoDienDAO.findById(req.getParameter("maDienVien"));
		List<Phim> phimDangChieus = phimDAO.selectAllOnDay(0, 4);
		dienVien.setLuotXem(dienVien.getLuotXem() + 1);
		daoDienVienDaoDienDAO.update(dienVien);
		List<Phim> phims = phimDAO.selectAllByDienVien(dienVien.getMaDV_DD());
		req.setAttribute("phimDangChieus", phimDangChieus);
		req.setAttribute("dienVien", dienVien);
		req.setAttribute("phims", phims);
		req.setAttribute("view", "/views/user/page/detaildienvien.jsp");
	}

	private void pagePhims(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Phim> phims = phimDAO.selectAll();
		List<Phim> phimDangChieus = phimDAO.selectAllOnDay(0, 4);
		List<KhuyenMai> khuyenMais = khuyenMaiDAO.selectAll();
		req.setAttribute("phimDangChieus", phimDangChieus);
		req.setAttribute("phims", phims);
		req.setAttribute("khuyenMais", khuyenMais);
		req.setAttribute("view", "/views/user/page/danhsachphim.jsp");
	}

	private void pageDetailPhim(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DienVienDaoDien dienVien = daoDienVienDaoDienDAO.findById(req.getParameter("maDienVien"));
		List<Phim> phimDangChieus = phimDAO.selectAllOnDay(0, 4);
		dienVien.setLuotXem(dienVien.getLuotXem() + 1);
		daoDienVienDaoDienDAO.update(dienVien);
		List<Phim> phims = phimDAO.selectAllByDienVien(dienVien.getMaDV_DD());
		req.setAttribute("phimDangChieus", phimDangChieus);
		req.setAttribute("dienVien", dienVien);
		req.setAttribute("phims", phims);
		req.setAttribute("view", "/views/user/page/detaildienvien.jsp");
	}

}
