package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ApDungKhuyenMai;
import model.ChiTietCombo;
import model.ComboDoAn;
import model.HoaDon;
import model.KhuyenMai;
import model.Phim;
import model.RapPhim;
import model.SuatChieu;
import model.TaiKhoan;
import model.Ve;
import ultis.Config;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import dao.ApDungKhuyenMaiDAO;
import dao.ChiTietComBoDAO;
import dao.ComboDoAnDAO;
import dao.HoaDonDAO;
import dao.KhuyenMaiDAO;
import dao.PhimDAO;
import dao.RapPhimDAO;
import dao.SuatChieuDAO;
import dao.TaiKhoanDAO;
import dao.VeDAO;

/**
 * Servlet implementation class PageUserServlet
 */
@WebServlet({ "/user/chonsuat", "/user/chonghe", "/user/choncombo", "/user/incrementcombo", "/user/decrementcombo",
		"/user/thanhtoan", "/user/apdungkm", "/user/confirmhd" })
public class PageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhimDAO phimDAO;
	private RapPhimDAO rapPhimDAO;
	private SuatChieuDAO suatChieuDAO;
	private VeDAO veDAO;
	private ComboDoAnDAO comboDoAnDAO;
	private KhuyenMaiDAO khuyenMaiDAO;
	private HoaDonDAO hoaDonDAO;
	private TaiKhoanDAO taiKhoanDAO;
	private ApDungKhuyenMaiDAO apDungKhuyenMaiDAO;
	private ChiTietComBoDAO chiTietComBoDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageUserServlet() {
		super();
		phimDAO = new PhimDAO();
		rapPhimDAO = new RapPhimDAO();
		suatChieuDAO = new SuatChieuDAO();
		veDAO = new VeDAO();
		comboDoAnDAO = new ComboDoAnDAO();
		khuyenMaiDAO = new KhuyenMaiDAO();
		hoaDonDAO = new HoaDonDAO();
		taiKhoanDAO = new TaiKhoanDAO();
		apDungKhuyenMaiDAO = new ApDungKhuyenMaiDAO();
		chiTietComBoDAO = new ChiTietComBoDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("chonsuat")) {
			doChonSuat(req, resp);
		} else if (uri.contains("chonghe")) {
			doChonGhe(req, resp);
		} else if (uri.contains("choncombo")) {
			doChonThucAn(req, resp);
		} else if (uri.contains("incrementcombo")) {
			incrementcombo(req, resp);
		} else if (uri.contains("decrementcombo")) {
			decrementCombo(req, resp);
		} else if (uri.contains("thanhtoan")) {
			doThanhToan(req, resp);
		} else if (uri.contains("apdungkm")) {
			doApDungKhuyenMai(req, resp);
		} else if (uri.contains("confirmhd")) {
			doConfirm(req, resp);
		}
	}

	private void doChonSuat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maPhim = req.getParameter("maPhim");
		Phim phim = phimDAO.findById(maPhim);
		List<RapPhim> rapPhims = rapPhimDAO.selectAllByPhim(maPhim);
		req.getSession().setAttribute("phim", phim);
		req.setAttribute("rapPhims", rapPhims);
		req.setAttribute("view", "/views/user/main/chonsuat.jsp");
		req.getRequestDispatcher("/views/user/layoutthanhtoan.jsp").forward(req, resp);
	}

	private void doChonGhe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			String maSuatChieu = req.getParameter("maSuatChieu");
			SuatChieu suatChieu = suatChieuDAO.findById(maSuatChieu);
			List<Ve> ves = veDAO.selectAllBySuatChieu(maSuatChieu);
			req.getSession().setAttribute("suatChieu", suatChieu);
			req.setAttribute("ves", ves);
			req.setAttribute("view", "/views/user/main/chonghe.jsp");
			req.getRequestDispatcher("/views/user/layoutthanhtoan.jsp").forward(req, resp);
		}
	}

	private void doChonThucAn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			HashMap<ComboDoAn, Integer> mapCombo = new HashMap<ComboDoAn, Integer>();
			String[] maVes = req.getParameterValues("maVe");
			List<Ve> ves = new ArrayList<Ve>();
			double tongTien = 0;
			for (String maVe : maVes) {
				Ve v = veDAO.findById(maVe);
				tongTien += v.getTongTien();
				ves.add(v);
			}
			List<ComboDoAn> combos = comboDoAnDAO.selectAll();
			req.getSession().setAttribute("ves", ves);
			req.getSession().setAttribute("mapCombo", mapCombo);
			req.getSession().setAttribute("tongTien", tongTien);
			req.setAttribute("combos", combos);
			req.setAttribute("view", "/views/user/main/choncombo.jsp");
			req.getRequestDispatcher("/views/user/layoutthanhtoan.jsp").forward(req, resp);
		} else {
			List<ComboDoAn> combos = comboDoAnDAO.selectAll();
			req.setAttribute("combos", combos);
			req.setAttribute("view", "/views/user/main/choncombo.jsp");
			req.getRequestDispatcher("/views/user/layoutthanhtoan.jsp").forward(req, resp);
		}
	}

	private void incrementcombo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<ComboDoAn, Integer> mapCombo = (HashMap<ComboDoAn, Integer>) req.getSession().getAttribute("mapCombo");
		List<Ve> ves = (List<Ve>) req.getSession().getAttribute("ves");
		double tongTien = 0;
		String maCombo = req.getParameter("maCombo");
		System.out.println(mapCombo);
		if (mapCombo.isEmpty()) {
			mapCombo = new HashMap<ComboDoAn, Integer>();
		}
		ComboDoAn comboDoAn = comboDoAnDAO.findById(maCombo);
		if (mapCombo.containsKey(comboDoAn)) {
			mapCombo.compute(comboDoAn, (key, val) -> val + 1);
		} else {
			mapCombo.put(comboDoAn, 1);
		}
		for (Map.Entry<ComboDoAn, Integer> entry : mapCombo.entrySet()) {
			tongTien += entry.getValue() * entry.getKey().getGiaCombo();
		}
		for (Ve ve : ves) {
			tongTien += ve.getTongTien();
		}
		req.getSession().setAttribute("mapCombo", mapCombo);
		req.getSession().setAttribute("tongTien", tongTien);
		resp.sendRedirect("/cinemastar/user/choncombo");
	}

	private void decrementCombo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<ComboDoAn, Integer> mapCombo = (HashMap<ComboDoAn, Integer>) req.getSession().getAttribute("mapCombo");
		List<Ve> ves = (List<Ve>) req.getSession().getAttribute("ves");
		double tongTien = (double) req.getSession().getAttribute("tongTien");
		String maCombo = req.getParameter("maCombo");
		ComboDoAn comboDoAn = comboDoAnDAO.findById(maCombo);
		if (mapCombo.containsKey(comboDoAn)) {
			if (mapCombo.get(comboDoAn).intValue() == 1) {
				mapCombo.remove(comboDoAn);
			} else {
				mapCombo.compute(comboDoAn, (key, val) -> val - 1);
			}
		} else {
			mapCombo.put(comboDoAn, 1);
		}
		for (Map.Entry<ComboDoAn, Integer> entry : mapCombo.entrySet()) {
			tongTien += entry.getValue() * entry.getKey().getGiaCombo();
		}
		for (Ve ve : ves) {
			tongTien += ve.getTongTien();
		}
		req.getSession().setAttribute("tongTien", tongTien);
		req.getSession().setAttribute("mapCombo", mapCombo);
		resp.sendRedirect("/cinemastar/user/choncombo");
	}

	private void doThanhToan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			String tongTien = String.valueOf(req.getSession().getAttribute("tongTien"));
			String vnp_Version = "2.1.0";
			String vnp_Command = "pay";
			String orderType = "other";
			long amount = ((int) Double.parseDouble(tongTien)) * 100;
//			String bankCode = req.getParameter("NCB");

			String vnp_TxnRef = Config.getRandomNumber(8);
			String vnp_IpAddr = Config.getIpAddress(req);

			String vnp_TmnCode = Config.vnp_TmnCode;

			Map<String, String> vnp_Params = new HashMap<>();
			vnp_Params.put("vnp_Version", vnp_Version);
			vnp_Params.put("vnp_Command", vnp_Command);
			vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
			vnp_Params.put("vnp_Amount", String.valueOf(amount));
			vnp_Params.put("vnp_CurrCode", "VND");
			//
//			if (bankCode != null && !bankCode.isEmpty()) {
//				vnp_Params.put("vnp_BankCode", bankCode);
//			}
			vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
			vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
			vnp_Params.put("vnp_OrderType", orderType);

			vnp_Params.put("vnp_Locale", "vn");

			vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
			vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

			Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String vnp_CreateDate = formatter.format(cld.getTime());
			vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

			cld.add(Calendar.MINUTE, 15);
			String vnp_ExpireDate = formatter.format(cld.getTime());
			vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

			List fieldNames = new ArrayList(vnp_Params.keySet());
			Collections.sort(fieldNames);
			StringBuilder hashData = new StringBuilder();
			StringBuilder query = new StringBuilder();
			Iterator itr = fieldNames.iterator();
			while (itr.hasNext()) {
				String fieldName = (String) itr.next();
				String fieldValue = (String) vnp_Params.get(fieldName);
				if ((fieldValue != null) && (fieldValue.length() > 0)) {
					// Build hash data
					hashData.append(fieldName);
					hashData.append('=');
					hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
					// Build query
					query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
					query.append('=');
					query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
					if (itr.hasNext()) {
						query.append('&');
						hashData.append('&');
					}
				}
			}
			String queryUrl = query.toString();
			String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
			queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
			String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;

			KhuyenMai khuyenMai = (KhuyenMai) req.getSession().getAttribute("khuyenMai");
			HashMap<ComboDoAn, Integer> mapCombo = (HashMap<ComboDoAn, Integer>) req.getSession()
					.getAttribute("mapCombo");
			List<Ve> ves = (List<Ve>) req.getSession().getAttribute("ves");

			TaiKhoan taiKhoan = taiKhoanDAO.findById("thanhtrung");
			HoaDon hoaDon = new HoaDon();
			hoaDon.setNgayLapHD(new Date());
			hoaDon.setTaiKhoan(taiKhoan);
			hoaDon.setTongTien((double) req.getSession().getAttribute("tongTien"));
			SimpleDateFormat spl = new SimpleDateFormat("yyyyMMdd");

			hoaDon.setCode(vnp_TxnRef + spl.format(new Date()));
			hoaDon.setTaiKhoan(taiKhoan);
			if (hoaDonDAO.create(hoaDon) != null) {
				HoaDon hoaDonFind = hoaDonDAO.findById(hoaDonDAO.maxIDHoaDon());
				ApDungKhuyenMai apDungKhuyenMai = new ApDungKhuyenMai();
				apDungKhuyenMai.setHoaDon(hoaDonFind);
				apDungKhuyenMai.setKhuyenMai(khuyenMai);
				apDungKhuyenMai.setTrangThaiApdung(true);
				apDungKhuyenMaiDAO.create(apDungKhuyenMai);

				for (Map.Entry<ComboDoAn, Integer> entry : mapCombo.entrySet()) {
					ChiTietCombo chiTietCombo = new ChiTietCombo();
					chiTietCombo.setHoaDon(hoaDonFind);
					chiTietCombo.setSoLuong(entry.getValue());
					chiTietCombo.setTongTien(entry.getKey().getGiaCombo() * entry.getValue());
					chiTietComBoDAO.create(chiTietCombo);
				}

				for (Ve ve : ves) {
					ve.setHoaDon(hoaDonFind);
					veDAO.update(ve);
				}
			}

			resp.sendRedirect(paymentUrl);
		} else {
			List<KhuyenMai> khuyenMais = khuyenMaiDAO.selectAllByDate();
			req.setAttribute("view", "/views/user/main/thanhtoan.jsp");
			req.setAttribute("khuyenMais", khuyenMais);
			req.getRequestDispatcher("/views/user/layoutthanhtoan.jsp").forward(req, resp);
		}
	}

	private void doApDungKhuyenMai(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String maKhuyenMai = req.getParameter("maKhuyenMai");
		HashMap<ComboDoAn, Integer> mapCombo = (HashMap<ComboDoAn, Integer>) req.getSession().getAttribute("mapCombo");
		List<Ve> ves = (List<Ve>) req.getSession().getAttribute("ves");
		double tongTien = 0;
		KhuyenMai khuyenMai = khuyenMaiDAO.findById(maKhuyenMai);
		for (Map.Entry<ComboDoAn, Integer> entry : mapCombo.entrySet()) {
			tongTien += entry.getValue() * entry.getKey().getGiaCombo();
		}
		for (Ve ve : ves) {
			tongTien += ve.getTongTien();
		}
		tongTien = tongTien - tongTien * khuyenMai.getPhanTramGiam() / 100;
		req.getSession().setAttribute("khuyenMai", khuyenMai);
		req.getSession().setAttribute("tongTien", tongTien);
		resp.sendRedirect("/cinemastar/user/thanhtoan");
	}

	private void doConfirm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String response = req.getParameter("vnp_ResponseCode");
		if (response.equals("00")) {
			String vnp_TxnRef = req.getParameter("vnp_TxnRef");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String dateString = simpleDateFormat.format(new Date());
			String code = vnp_TxnRef + dateString;
			HoaDon hoaDon = hoaDonDAO.findByCode(code);
			hoaDon.setTrangThai(true);
			hoaDonDAO.update(hoaDon);
			req.setAttribute("message", "Thanh toán thành công");
			req.setAttribute("status", true);
		} else {
			req.setAttribute("message", "Thanh toán thất bại");
			req.setAttribute("status", false);
		}

		req.setAttribute("view", "/views/user/main/confim.jsp");
		req.getRequestDispatcher("/views/user/layoutthanhtoan.jsp").forward(req, resp);
	}
}
