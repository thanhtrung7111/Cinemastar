<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý loại nhân viên /
		Cập nhật</h5>
	<form class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3" method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Cập nhật loại nhân viên</h5>
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
		<input type="text" hidden value="${loaiNhanVien.maLoaiNhanVien}" name="maLoaiHinh"> 
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Tên 
						loại nhân viên</label> <input type="text" class="form-control form-control-sm" value="${loaiNhanVien.tenLoaiNhanVien}"
						name="tenLoaiHinh" placeholder="Nhập tên loại hình" />
				</div>
			</div>
		</div>

		<div class="d-block text-end">
			<a href="${url}admin/loainhanviens"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="updateloainhanvien" class="btn btn-sm bg-first text-white">Cập nhật</button>
		</div>
	</form>

	<div>
		<div></div>
	</div>
</div>