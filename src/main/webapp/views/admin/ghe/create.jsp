<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý ghế / Thêm mới</h5>
	<form class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3"
		method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Thêm ghế</h5>
		<!-- <div>
                  <button
                    class="btn bg-first btn-sm text-white"
                    data-bs-toggle="modal"
                    data-bs-target="#modalRapphim"
                  >
                    <i class="ri-file-add-line"></i> Thêm mới
                  </button>
                </div> -->
		<!-- </div> -->
		<div class="row g-3 mb-3">
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Loại
						ghế</label> <select class="form-select form-select-sm" name="maLoaiGhe"
						aria-label="Small select example">
						<c:forEach var="loaiGhe" items="${loaiGhes}">
							<option value="${loaiGhe.maLoaiGhe}">${loaiGhe.tenLoaiGhe}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Phòng
						phim</label> <select class="form-select form-select-sm" name="maPhongPhim"
						aria-label="Small select example">
						<c:forEach var="phongPhim" items="${phongPhims}">
							<option value="${phongPhim.maPhongPhim}">${phongPhim.rapPhim.tenRapPhim} - ${phongPhim.tenPhongPhim}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>

		<div class="d-block text-end">
			<a href="${url}admin/nhanviens"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="createghe"
				class="btn btn-sm bg-first text-white">Thêm mới</button>
		</div>
	</form>

	<div>
		<div></div>
	</div>
</div>