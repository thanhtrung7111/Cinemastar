
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="url" value="/"></c:url>
<div
	class="bg-white py-4 d-flex justify-content-center align-items-center">
	<div class="border-1 border-bottom d-flex" style="width: fit-content">
		<div
			class="px-3 pb-2 fs-5  border-bottom border-2 text-first border-first">
			Chọn rạp/phim/suất</div>
		<div
			class="px-3 pb-2 fs-5 ${sessionScope.suatChieu != null ? 'border-first text-first  border-bottom border-2':'text-dark'}">Chọn
			ghế</div>
		<div class="px-3 pb-2 fs-5 ${sessionScope.ves != null ? 'border-first text-first  border-bottom border-2':'text-dark'}">Chọn thức ăn</div>
		<div class="px-3 pb-2 fs-5 ${sessionScope.mapCombo != null ? 'border-first text-first  border-bottom border-2':'text-dark'}">Thanh toán</div>
		<div class="px-3 pb-2 fs-5 text-dark">Xác nhận</div>
	</div>
</div>