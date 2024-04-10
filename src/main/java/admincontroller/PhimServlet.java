package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.DienVienDaoDien;
import model.Phim;
import model.QuocGia;
import model.ThamGia;
import model.ThanhPho;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.DienVienDaoDienDAO;
import dao.PhimDAO;
import dao.QuocGiaDAO;
import dao.ThamGiaDAO;
import dao.ThanhPhoDAO;

/**
 * Servlet implementation class PhimServlet
 */
@WebServlet({ "/admin/phims", "/admin/createphim", "/admin/updatephim", "/admin/deletephim" })
@MultipartConfig
public class PhimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhimDAO phimDAO;
	private QuocGiaDAO quocGiaDAO;
	private DienVienDaoDienDAO dienVienDaoDienDAO;
	private ThamGiaDAO thamGiaDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhimServlet() {
		super();
		phimDAO = new PhimDAO();
		quocGiaDAO = new QuocGiaDAO();
		dienVienDaoDienDAO = new DienVienDaoDienDAO();
		thamGiaDAO = new ThamGiaDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("phims")) {
			List<Phim> phims = phimDAO.selectAll();
			req.setAttribute("phims", phims);
			req.setAttribute("view", "/views/admin/phim/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createphim")) {
			createPhim(req, resp);
		} else if (uri.contains("updatephim")) {
			updatePhim(req, resp);
		} else if (uri.contains("deletephim")) {
			deletePhim(req, resp);
		}
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void createPhim(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				Phim phim = new Phim();
				Part part = req.getPart("image");
				String realPath = req.getServletContext().getRealPath("/images");
				String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
				if (!Files.exists(Path.of(realPath))) {
					Files.createDirectory(Path.of(realPath));
				}
				System.out.println(realPath);
				part.write(realPath + "/" + filename);
				QuocGia quocGia = quocGiaDAO.findById(req.getParameter("maQuocGia"));
				BeanUtils.populate(phim, req.getParameterMap());
				phim.setQuocGia(quocGia);
				phim.setHinhAnh(filename);
				phimDAO.create(phim);
				Phim phimFind = phimDAO.findById(phimDAO.maxIDPhim());
				String[] dienViens = req.getParameterValues("maDienVien");
				String[] daoDiens = req.getParameterValues("maDaoDien");
				for (String dienVien : dienViens) {
					DienVienDaoDien dienVienDaoDien = dienVienDaoDienDAO.findById(dienVien);
					ThamGia thamGia = new ThamGia();
					thamGia.setDienVienDaoDien(dienVienDaoDien);
					thamGia.setPhim(phimFind);
					thamGiaDAO.create(thamGia);
				}

				for (String dienVien : daoDiens) {
					DienVienDaoDien dienVienDaoDien = dienVienDaoDienDAO.findById(dienVien);
					ThamGia thamGia = new ThamGia();
					thamGia.setDienVienDaoDien(dienVienDaoDien);
					thamGia.setPhim(phimFind);
					thamGiaDAO.create(thamGia);
				}
				resp.sendRedirect("/cinemastar/admin/phims");
			} catch (Exception e) {
				List<DienVienDaoDien> dienViens = dienVienDaoDienDAO.selectAllByRole("Diễn Viên");
				List<DienVienDaoDien> daoDiens = dienVienDaoDienDAO.selectAllByRole("Đạo Diễn");
				List<QuocGia> quocGias = quocGiaDAO.selectAll();
				req.setAttribute("quocGias", quocGias);
				req.setAttribute("dienViens", dienViens);
				req.setAttribute("daoDiens", daoDiens);
				req.setAttribute("view", "/views/admin/phim/create.jsp");
				req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
			}

		} else {
			List<DienVienDaoDien> dienViens = dienVienDaoDienDAO.selectAllByRole("Diễn Viên");
			List<DienVienDaoDien> daoDiens = dienVienDaoDienDAO.selectAllByRole("Đạo Diễn");
			List<QuocGia> quocGias = quocGiaDAO.selectAll();
			req.setAttribute("quocGias", quocGias);
			req.setAttribute("dienViens", dienViens);
			req.setAttribute("daoDiens", daoDiens);
			req.setAttribute("view", "/views/admin/phim/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updatePhim(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				Phim phim = new Phim();
				Part part = req.getPart("image");
				String realPath = "";
				String filename = "";
				System.out.println(part.getSubmittedFileName().isBlank());
				if (!part.getSubmittedFileName().isBlank()) {
					realPath = req.getServletContext().getRealPath("/images");
					filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
					if (!Files.exists(Path.of(realPath))) {
						Files.createDirectory(Path.of(realPath));
					}
					System.out.println(realPath);
					part.write(realPath + "/" + filename);
				}

				QuocGia quocGia = quocGiaDAO.findById(req.getParameter("maQuocGia"));
				BeanUtils.populate(phim, req.getParameterMap());
				phim.setQuocGia(quocGia);
				if (part.getSubmittedFileName().isBlank() == false) {
					phim.setHinhAnh(filename);
				}
				phimDAO.update(phim);

				resp.sendRedirect("/cinemastar/admin/phims");
			} catch (Exception e) {
				List<DienVienDaoDien> dienViens = dienVienDaoDienDAO.selectAllByRole("Diễn Viên");
				List<DienVienDaoDien> daoDiens = dienVienDaoDienDAO.selectAllByRole("Đạo Diễn");
				Phim phim = phimDAO.findById(req.getParameter("maPhim"));
				List<QuocGia> quocGias = quocGiaDAO.selectAll();
				req.setAttribute("quocGias", quocGias);
				req.setAttribute("phim", phim);
				req.setAttribute("dienViens", dienViens);
				req.setAttribute("daoDiens", daoDiens);
				req.setAttribute("view", "/views/admin/phim/update.jsp");
				req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
			}

		} else {
			List<DienVienDaoDien> dienViens = dienVienDaoDienDAO.selectAllByRole("Diễn Viên");
			List<DienVienDaoDien> daoDiens = dienVienDaoDienDAO.selectAllByRole("Đạo Diễn");
			Phim phim = phimDAO.findById(req.getParameter("maPhim"));
			List<QuocGia> quocGias = quocGiaDAO.selectAll();
			req.setAttribute("quocGias", quocGias);
			req.setAttribute("phim", phim);
			req.setAttribute("dienViens", dienViens);
			req.setAttribute("daoDiens", daoDiens);
			req.setAttribute("view", "/views/admin/phim/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deletePhim(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			String id = req.getParameter("maPhim");
			phimDAO.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		resp.sendRedirect("/cinemastar/admin/phims");
	}
}
