<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="url" value="/"></c:url>

<div class="col-8 col-md-6 col-lg-4 col-xl-4">
	<div class="p-4 bg-white rounded-3 shadow-sm">
		<h4 class="text-center mb-3 text-first fw-bolder">Thông tin vé</h4>
		<img src="./assets/img/imgphim-2.jpg" alt=""
			style="height: 400px; object-fit: cover; object-position: center; width: 100%;"
			class="mb-2" />
		<div class="d-flex align-items-center column-gap-2">
			<h5 class="mb-0 fw-bolder">Kungfu Panda 4</h5>
			- <span>Phụ đề</span>
		</div>
		<div class="text-sm border-bottom pb-3 mb-3">
			<div class="text-light">
				Rạp: <span class="text-dark fw-semibold">Cinestar Thủ Đức</span>
			</div>
			<div class="text-light">
				Phòng: <span class="text-dark fw-semibold">G05</span>
			</div>
			<div class="text-light">
				Suất: <span class="text-dark fw-semibold">13:00 Thứ 4 -
					25/04/2024</span>
			</div>
		</div>
		<div
			class="text-dark text-sm d-flex align-items-center justify-content-between">
			<span>Tổng cộng:</span> <span>0</span>
		</div>
	</div>
	<div class="d-flex column-gap-2 justify-content-end mt-3">
		<a class="btn bg-danger text-white text-sm text-decoration-none"
			href="./danhsachphim.html">Quay lại</a> <a
			class="btn bg-first text-white text-sm text-decoration-none"
			href="./chonghe.html">Tiếp tục</a>
	</div>
</div>