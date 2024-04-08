package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.KhuyenMai;
import model.ThanhPho;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
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
@MultipartConfig
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
				System.out.println(req.getParameter("ngayApDung"));
				KhuyenMai khuyenMai = new KhuyenMai();
				Part part = req.getPart("image");
				String realPath = req.getServletContext().getRealPath("/images");
				String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
				if (!Files.exists(Path.of(realPath))) {
					Files.createDirectory(Path.of(realPath));
				}
				part.write(realPath + "/" + filename);
				DateTimeConverter dtc = new DateConverter(null);
				dtc.setPattern("yyyy-MM-dd");
				ConvertUtils.register(dtc, Date.class);
				BeanUtils.populate(khuyenMai, req.getParameterMap());
				BeanUtils.setProperty(khuyenMai, "ngayApDung", req.getParameter("ngayApDung"));
				BeanUtils.setProperty(khuyenMai, "ngayKetThuc", req.getParameter("ngayKetThuc"));
				khuyenMai.setHinhAnh(filename);
				khuyenMaiDAO.create(khuyenMai);
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
				DateTimeConverter dtc = new DateConverter(null);
				dtc.setPattern("yyyy-MM-dd");
				ConvertUtils.register(dtc, Date.class);
				BeanUtils.populate(khuyenMai, req.getParameterMap());
				BeanUtils.setProperty(khuyenMai, "ngayApDung", req.getParameter("ngayApDung"));
				BeanUtils.setProperty(khuyenMai, "ngayKetThuc", req.getParameter("ngayKetThuc"));
				if (part.getSubmittedFileName().isBlank() == false) {
					khuyenMai.setHinhAnh(filename);
				}
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
