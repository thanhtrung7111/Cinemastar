<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý loại tài khoản
		/ Thêm mới</h5>
	<form class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3"
		method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Thêm loại tài khoản mới</h5>
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
					<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
						loại tài khoản</label> <input type="text" name="tenLoaiTaiKhoan"
						class="form-control form-control-sm" id="exampleFormControlInput1"
						placeholder="Nhập tên loại tài khoản" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Chi
						tiêu tối thiểu</label> <input type="number" name="chiTieuToiThieu"
						class="form-control form-control-sm"
						placeholder="Nhập chi tiêu tổi thiểu cho loại tài khoản!" min="0" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Mô tả</label>
					<input type="text" class="form-control form-control-sm" name="mota"
						placeholder="Nhập mô tả loại tài khoản!" />
				</div>
			</div>
		</div>

		<div class="d-block text-end">
			<a href="${url}admin/loaitaikhoans"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="createloaitaikhoan"
				class="btn btn-sm bg-first text-white">Thêm mới</button>
		</div>
	</form>

	<div>
		<div></div>
	</div>
</div>