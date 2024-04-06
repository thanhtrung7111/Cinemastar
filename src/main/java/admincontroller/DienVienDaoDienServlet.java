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
import model.VaiTro;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import dao.DienVienDaoDienDAO;
import dao.QuocGiaDAO;
import dao.VaiTroDAO;

/**
 * Servlet implementation class DienVienDaoDienServlet
 */
@WebServlet({ "/admin/dienviens", "/admin/createdienvien", "/admin/updatedienvien", "/admin/deletedienvien" })
@MultipartConfig
public class DienVienDaoDienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DienVienDaoDienDAO dienVienDaoDienDAO;
	private QuocGiaDAO quocGiaDAO;
	private VaiTroDAO vaiTroDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DienVienDaoDienServlet() {
		super();
		dienVienDaoDienDAO = new DienVienDaoDienDAO();
		quocGiaDAO = new QuocGiaDAO();
		vaiTroDAO = new VaiTroDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("dienviens")) {
			List<DienVienDaoDien> dienVienDaoDiens = dienVienDaoDienDAO.selectAll();
			List<VaiTro> vaiTros = vaiTroDAO.selectAll();
			req.setAttribute("vaiTros", vaiTros);
			req.setAttribute("dienVienDaoDiens", dienVienDaoDiens);
			req.setAttribute("view", "/views/admin/dienvien/list.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		} else if (uri.contains("createdienvien")) {
			createDienVien(req, resp);
		} else if (uri.contains("updatedienvien")) {
			updateDienVien(req, resp);
		} else if (uri.contains("deletedienvien")) {
			deleteDienVien(req, resp);
		}
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void createDienVien(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				DateTimeConverter dtc = new DateConverter(new Date());
				dtc.setPattern("MM/dd/yyyy");
				ConvertUtils.register(dtc, Date.class);
				DienVienDaoDien dienVienDaoDien = new DienVienDaoDien();
				Part part = req.getPart("image");
				String realPath = req.getServletContext().getRealPath("/images");
				String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
				if (!Files.exists(Path.of(realPath))) {
					Files.createDirectory(Path.of(realPath));
				}
				System.out.println(realPath);
				part.write(realPath + "/" + filename);
				QuocGia quocGia = quocGiaDAO.findById(req.getParameter("maQuocGia"));
				VaiTro vaiTro = vaiTroDAO.findById(req.getParameter("maVaiTro"));
				BeanUtils.populate(dienVienDaoDien, req.getParameterMap());
				dienVienDaoDien.setQuocGia(quocGia);
				dienVienDaoDien.setVaiTro(vaiTro);
				dienVienDaoDien.setHinhAnh(filename);
				dienVienDaoDienDAO.create(dienVienDaoDien);
				resp.sendRedirect("/cinemastar/admin/dienviens");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			List<QuocGia> quocGias = quocGiaDAO.selectAll();
			List<VaiTro> vaiTros = vaiTroDAO.selectAll();
			req.setAttribute("quocGias", quocGias);
			req.setAttribute("vaiTros", vaiTros);
			req.setAttribute("view", "/views/admin/dienvien/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateDienVien(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				DateTimeConverter dtc = new DateConverter(new Date());
				dtc.setPattern("MM/dd/yyyy");
				ConvertUtils.register(dtc, Date.class);
				DienVienDaoDien dienVienDaoDien = new DienVienDaoDien();
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
				VaiTro vaiTro = vaiTroDAO.findById(req.getParameter("maVaiTro"));
				BeanUtils.populate(dienVienDaoDien, req.getParameterMap());
				dienVienDaoDien.setQuocGia(quocGia);
				dienVienDaoDien.setVaiTro(vaiTro);
				if (part.getSubmittedFileName().isBlank() == false) {
					dienVienDaoDien.setHinhAnh(filename);
				}
				dienVienDaoDienDAO.update(dienVienDaoDien);
				resp.sendRedirect("/cinemastar/admin/dienviens");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			DienVienDaoDien dienVienDaoDien = dienVienDaoDienDAO.findById(req.getParameter("maDV_DD"));
			List<QuocGia> quocGias = quocGiaDAO.selectAll();
			List<VaiTro> vaiTros = vaiTroDAO.selectAll();
			req.setAttribute("quocGias", quocGias);
			req.setAttribute("vaiTros", vaiTros);
			req.setAttribute("dienVienDaoDien", dienVienDaoDien);
			req.setAttribute("view", "/views/admin/dienvien/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteDienVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("maDV_DD");
		dienVienDaoDienDAO.delete(id);
		resp.sendRedirect("/cinemastar/admin/dienviens");
	}
}
