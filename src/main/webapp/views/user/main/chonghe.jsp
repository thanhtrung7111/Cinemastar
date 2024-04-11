<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="url" value="/"></c:url>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<form method="post" class="row g-4">

	<div class="col-12 col-xl-8">
		<div
			class="d-flex gap-3 flex-wrap align-items-center bg-white py-3 px-5 rounded-3 shadow-sm mb-4">
			<span>Suất chiếu:</span>
			<div class="px-3 py-1 rounded-2 text-dark">
				${sessionScope.suatChieu.thoiGianChieu} -
				${sessionScope.suatChieu.ngayChieu}</div>
		</div>

		<div class="px-4 bg-white py-5 shadow-sm">
			<div class="bg-second" style="height: 5px; width: 100%"></div>
			<div class="d-block text-center mb-5 text-light">Màn hình</div>
			<div class="d-flex flex-column row-gap-2">
				<div class="d-flex">
					<div
						class="d-grid gap-3 mx-auto justify-content-center px-5 grid-col-10"
						style="width: 500px">
						<c:forEach var="ve" items="${ves}">
							<input type="checkbox" id="${ve.maVe}" name="maVe"
								${ve.hoaDon.trangThai == true ? 'disabled' : ''}
								value="${ve.maVe}" hidden>
							<label style="width: 30px; height: 30px" for="${ve.maVe}"
								class="border checkghe d-flex ${ve.hoaDon.trangThai == true ? 'text-white bg-second':''} align-items-center justify-content-center rounded-2 text-sm">
								${ve.ghe.tenGhe}</label>
						</c:forEach>
					</div>
				</div>
			</div>

			<div class="border-top mt-3 py-2">
				<div class="d-flex align-items-center column-gap-4">
					<div class="d-flex align-items-center column-gap-md-2">
						<div style="width: 30px; height: 30px"
							class="border d-flex bg-dark align-items-center justify-content-center rounded-2 text-sm"></div>
						<span>Ghế đã bán</span>
					</div>
					<div class="d-flex align-items-center column-gap-md-2">
						<div style="width: 30px; height: 30px"
							class="border d-flex bg-second align-items-center justify-content-center rounded-2 text-sm"></div>
						<span>Ghế đang chọn</span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="col-8 col-md-6 col-lg-4 col-xl-4">
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
			<div
				class="text-dark text-sm d-flex align-items-center justify-content-between">
				<span>Tổng cộng:</span> <span>0</span>
			</div>
		</div>
		<div class="d-flex column-gap-2 justify-content-end mt-3">
			<a class="btn bg-danger text-white text-sm text-decoration-none"
				href="./danhsachphim.html">Quay lại</a>
			<button formaction="${url}user/choncombo"
				class="btn bg-first text-white text-sm text-decoration-none"
				href="./chonghe.html">Tiếp tục</button>
		</div>
	</div>
</form>