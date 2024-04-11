
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="url" value="/"></c:url>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form method="post" class="row g-4">
	<div class="col-12 col-lg-7 col-xl-8">
		<div
			class="gap-3 align-items-center bg-white py-3 px-4 rounded-3 shadow-sm mb-4">

			<div class="text-center" style="min-height: 500px">
				<h5>${message}</h5>
				<a class="btn bg-first text-white" href="${url}trangchu">Về
					trang chủ</a>
			</div>

		</div>

	</div>

	<div class="col-12 col-xl-4">
		<div class="p-4 bg-white rounded-3 shadow-sm">
			<h4 class="text-center mb-3 text-first fw-bolder">Thông tin vé</h4>
			<img src="/cinemastar/images/${sessionScope.phim.hinhAnh}" alt=""
				style="height: 400px; object-fit: cover; object-position: center; width: 100%;"
				class="mb-2" />
			<div class="d-flex align-items-center column-gap-2">
				<h5 class="mb-0 fw-bolder">${sessionScope.phim.tenPhim}</h5>
				- <span>Phụ đề</span>
			</div>
			<c:if test="${sessionScope.suatChieu != null}">
				<div class="text-sm border-bottom pb-3 mb-3">
					<div class="text-light">
						Rạp: <span class="text-dark fw-semibold">${sessionScope.suatChieu.phongPhim.rapPhim.tenRapPhim}</span>
					</div>
					<div class="text-light">
						Phòng: <span class="text-dark fw-semibold">${sessionScope.suatChieu.phongPhim.tenPhongPhim}</span>
					</div>
					<div class="text-light">
						Suất: <span class="text-dark fw-semibold"><fmt:formatDate
								pattern="HH:mm" value="${sessionScope.suatChieu.thoiGianChieu}" />
							- <fmt:formatDate pattern="yyyy-MM-dd"
								value="${sessionScope.suatChieu.ngayChieu}" /> </span>
					</div>
				</div>
			</c:if>
			<div class="border-bottom pb-2 mb-2">
				<c:forEach var="ve" items="${sessionScope.ves}">
					<div
						class="text-dark text-sm d-flex align-items-center justify-content-between">
						<span>Ghế ${ve.ghe.tenGhe}:</span> <span>${ve.tongTien}VNĐ</span>
					</div>
				</c:forEach>

			</div>
			<c:if test="${sessionScope.mapCombo !=null}">
				<div class="border-bottom pb-2 mb-2">
					<c:forEach var="combo" items="${sessionScope.mapCombo}">
						<div
							class="text-dark text-sm d-flex align-items-center justify-content-between">
							<span>${combo.key.tenCombo}x${combo.value}</span> <span>${combo.key.giaCombo*combo.value}VND</span>
						</div>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${sessionScope.khuyenMai !=null}">
				<div class="border-bottom pb-2 mb-2">
					<div
						class="text-dark text-sm d-flex align-items-center justify-content-between">
						<span>${sessionScope.khuyenMai.maKhuyenMai}</span> <span>-${sessionScope.khuyenMai.phanTramGiam}%</span>
					</div>
				</div>
			</c:if>
			<div
				class="text-dark text-sm d-flex align-items-center justify-content-between">
				<span>Tổng cộng:</span> <span>${sessionScope.tongTien}VNĐ</span>
			</div>
		</div>
		<div class="d-flex column-gap-2 justify-content-end mt-3">
			<a class="btn bg-danger text-white text-sm text-decoration-none"
				href="./chonghe.html">Quay lại</a>
			<button class="btn bg-first text-white text-sm text-decoration-none"
				formaction="${url}user/thanhtoan">Thanh toán</button>
		</div>
	</div>
</form>