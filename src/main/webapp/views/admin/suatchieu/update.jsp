<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>
<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý suất chiếu /
		Cập nhật</h5>
	<form class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3"
		method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Cập nhật suất chiếu</h5>
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
				<input type="text" value="${suatChieu.maSuatChieu}"
					name="maSuatChieu" hidden>
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Thời
						gian chiếu</label> <input type="time" class="form-control form-control-sm"
						id="exampleFormControlInputs1" name="thoiGianChieu"
						value="${suatChieu.thoiGianChieu}" placeholder="Nhập tên rạp phim" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Ngày
						chiếu</label> <input type="date" class="form-control form-control-sm"
						id="exampleFormControlInput1" name="ngayChieu"
						value="${suatChieu.ngayChieu}" placeholder="Nhập địa chỉ" />
				</div>
			</div>
			<div class="col-6">

				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Phòng
						phim</label> <select class="form-select form-select-sm"
						aria-label="Small select example" name="maPhongPhim">
						<c:forEach var="phongPhim" items="${phongPhims}" varStatus="loop">
							<option
								${suatChieu.phongPhim.maPhongPhim == phongPhim.maPhongPhim ? 'selected="selected"' : ''}
								value="${phongPhim.maPhongPhim}">${phongPhim.rapPhim.tenRapPhim}
								- Phòng ${phongPhim.tenPhongPhim}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Phim</label>
					<select class="form-select form-select-sm"
						aria-label="Small select example" name="maPhim">
						<c:forEach var="phim" items="${phims}" varStatus="loop">
							<option
								${suatChieu.phim.maPhim == phim.maPhim ? 'selected="selected"' : ''}
								value="${phim.maPhim}">${phim.tenPhim}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>

		<div class="d-block text-end">
			<a href="${url}admin/suatchieus"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="updatesuatchieu"
				class="btn btn-sm bg-first text-white">Thêm mới</button>
		</div>
	</form>

	<div>
		<div></div>
	</div>
</div>