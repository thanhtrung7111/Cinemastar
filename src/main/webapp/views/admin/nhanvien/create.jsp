<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý loại nhân viên
		/ Thêm mới</h5>
	<form class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3"
		method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Thêm loại nhân viên mới</h5>
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
						tên nhân viên</label> <input type="text" name="tenNhanVien"
						class="form-control form-control-sm"
						placeholder="Nhập tên nhân viên" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Email</label>
					<input type="email" class="form-control form-control-sm"
						name="email" id="exampleFormControlInput1"
						placeholder="Nhập email" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Số
						điện thoại</label> <input type="text"
						class="form-control form-control-sm" id="exampleFormControlInput1"
						name="soDienThoai" placeholder="Nhập số điện thoại" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Mật
						khẩu</label> <input type="text" class="form-control form-control-sm"
						name="matKhau" id="exampleFormControlInput1"
						placeholder="Nhập mật khẩu" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Ngày
						sinh</label> <input type="date" class="form-control form-control-sm"
						name="ngaySinh" id="exampleFormControlInput1"
						placeholder="Nhập ngày sinh" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Loại
						nhân viên</label> <select class="form-select form-select-sm"
						name="maLoaiNhanVien" aria-label="Small select example">
						<c:forEach var="loaiNhanVien" items="${loaiNhanViens}">
							<option value="${loaiNhanVien.maLoaiNhanVien}">${loaiNhanVien.tenLoaiNhanVien}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Nhân
						viên rạp</label> <select class="form-select form-select-sm" name="maRapPhim"
						aria-label="Small select example">
						<c:forEach var="rapPhim" items="${rapPhims}">
							<option value="${rapPhim.maRapPhim}">${rapPhim.tenRapPhim}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>

		<div class="d-block text-end">
			<a href="${url}admin/nhanviens"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="createnhanvien"
				class="btn btn-sm bg-first text-white">Thêm mới</button>
		</div>
	</form>

	<div>
		<div></div>
	</div>
</div>