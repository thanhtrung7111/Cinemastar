<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>
<div class="d-flex flex-column mt-3">
	<div class="scroll" style="cursor: pointer">
		<div
			class="px-3 py-2 info-item d-flex align-items-center justify-content-between">
			<div class="text-sm text-decoration-none">
				<i class="ri-tools-fill"></i> Quản lý chung
			</div>

			<i class="ri-arrow-down-s-line text-sm"></i>
		</div>
		<ul class="list-unstyled mb-0 item-scroll"
			style="height: 0; overflow: hidden; transition: height 0.3s ease;">
			<li><a href="rapphims"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Rạp
					phim</a></li>
			<li><a href="${url}admin/phongphims"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Phòng
					phim</a></li>
			<li><a href="${url}admin/loaighes"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Loại
					ghế</a></li>
			<li><a href="./quanlyghe.html"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Ghế</a>
			</li>
			<li><a href="./quanlyghe.html"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Hàng ghế</a>
			</li>
			<li><a href="${url}admin/thanhphos"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Thành
					Phố</a></li>
			<li><a href="${url}admin/thanhphos"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Quốc
					gia</a></li>
			<li><a href="${url}admin/loaitaikhoans"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Loại
					tài khoản</a></li>
			<li><a href="${url}admin/thanhphos"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Loại
					hình</a></li>
			<li><a href="${url}admin/thanhphos"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Loại
					nhân viên</a></li>
			<li><a href="${url}admin/thanhphos"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Vai trò diễn viên</a></li>
		</ul>
	</div>

	<!-- Rạp phim  -->
	<div class="scroll" style="cursor: pointer">
		<div
			class="px-3 py-2 info-item d-flex align-items-center justify-content-between">
			<div class="text-sm text-decoration-none">
				<i class="ri-home-3-line"></i> Quản lý rạp phim
			</div>

			<i class="ri-arrow-down-s-line text-sm"></i>
		</div>
		<ul class="list-unstyled mb-0 item-scroll"
			style="height: 0; overflow: hidden; transition: height 0.3s ease;">
			<li><a href="./quanlysuatchieu.html"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Suất
					chiếu</a></li>

			<li><a href="./quanlyhoadon.html"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Hóa
					đơn</a></li>
			<li><a href="${url}admin/khuyenmais"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Khuyến
					mãi</a></li>
			<li><a href="${url}admin/combos"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Thực
					phẩm / combo</a></li>
		</ul>
	</div>

	<!-- PHIM  -->
	<div class="scroll" style="cursor: pointer">
		<div
			class="px-3 py-2 info-item d-flex align-items-center justify-content-between">
			<div class="text-sm text-decoration-none">
				<i class="ri-film-line"></i> Quản lý phim
			</div>

			<i class="ri-arrow-down-s-line text-sm"></i>
		</div>
		<ul class="list-unstyled mb-0 item-scroll"
			style="height: 0; overflow: hidden; transition: height 0.3s ease;">
			<li><a href="./quanlyphim.html"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Phim</a>
			</li>
			<li><a href="./quanlydienvien.html"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Đạo
					diễn, diễn viên</a></li>
		</ul>
	</div>
	<!-- TÀI KHOẢN  -->
	<div class="scroll" style="cursor: pointer">
		<div
			class="px-3 py-2 info-item d-flex align-items-center justify-content-between">
			<div class="text-sm text-decoration-none">
				<i class="ri-user-line"></i> Quản lý tài khoản
			</div>

			<i class="ri-arrow-down-s-line text-sm"></i>
		</div>
		<ul class="list-unstyled mb-0 item-scroll"
			style="height: 0; overflow: hidden; transition: height 0.3s ease;">
			<li><a href="./quanlytaikhoan.html"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Tài
					khoản người dùng</a></li>
			<li><a href="./quanlynhanvien.html"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Tài
					khoản nhân viên</a></li>
		</ul>
	</div>
	<!-- THỐNG KÊ  -->
	<div class="scroll" style="cursor: pointer">
		<div
			class="px-3 py-2 info-item d-flex align-items-center justify-content-between">
			<div class="text-sm text-decoration-none">
				<i class="ri-bar-chart-box-line"></i> Thống kê chung
			</div>

			<i class="ri-arrow-down-s-line text-sm"></i>
		</div>
		<ul class="list-unstyled mb-0 item-scroll"
			style="height: 0; overflow: hidden; transition: height 0.3s ease;">
			<li><a href="./quanlytaikhoan.html"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Tài
					khoản người dùng</a></li>
			<li><a href="./quanlynhanvien.html"
				class="px-3 py-1 d-inline-block translate-r-hover text-sm text-decoration-none text-dark ps-5">Tài
					khoản nhân viên</a></li>
		</ul>
	</div>
</div>