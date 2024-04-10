
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="url" value="/"></c:url>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>




<div class="row g-4">
	<div class="col-12 col-xl-8">
		<div class="px-4 bg-white py-3 shadow-sm rounded-3">
			<h5 class="mb-3">Chọn combo</h5>

			<div class="d-flex flex-column row-gap-3">
				<c:forEach var="combo" items="${combos}">
					<div class="d-flex column-gap-2">
						<img
							src="./assets/img/thucan/menuboard-combo1-2-2024-coonline-combo1_1710302659236.jpg"
							alt=""
							style="height: 100px; width: 100px; object-fit: cover; object-position: center;"
							class="rounded-3" />

						<div class="flex-fill d-flex flex-column row-gap-1">
							<h5 class="mb-0 fw-bold">${combo.tenCombo}</h5>
							<p class="mb-1 text-sm">${combo.moTa}</p>
							<span class="fw-bold">Giá: ${combo.giaCombo}VNĐ</span>
						</div>
						<div class="d-flex column-gap-1">
							<a href="${url}user/incrementcombo?maCombo=${combo.maCombo}"
								class="border d-flex align-items-center justify-content-center rounded-1 text-sm text-dark text-decoration-none"
								style="height: 25px; width: 25px">+</a>
							<div
								class="border d-flex align-items-center justify-content-center rounded-1 text-sm"
								style="height: 25px; width: 25px">
								<c:forEach var="combochoose" items="${sessionScope.mapCombo}">
									<c:if test="${combochoose.key.maCombo == combo.maCombo}">${combochoose.value}</c:if>
								</c:forEach>
								<c:if test="${empty sessionScope.mapCombo}">0</c:if>
							</div>
							<a href="${url}user/decrementcombo?maCombo=${combo.maCombo}"
								class="border d-flex align-items-center justify-content-center rounded-1 text-sm text-dark text-decoration-none"
								style="height: 25px; width: 25px">-</a>
						</div>
					</div>
				</c:forEach>
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
			<div
				class="text-dark text-sm d-flex align-items-center justify-content-between">
				<span>Tổng cộng:</span> <span>${sessionScope.tongTien}VNĐ</span>
			</div>
		</div>
		<div class="d-flex column-gap-2 justify-content-end mt-3">
			<a class="btn bg-danger text-white text-sm text-decoration-none"
				href="./chonghe.html">Quay lại</a> <a
				class="btn bg-first text-white text-sm text-decoration-none"
				href="${url}user/thanhtoan">Tiếp tục</a>
		</div>
	</div>
</div>