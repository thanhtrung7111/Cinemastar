<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý quốc gia /
		Cập nhật</h5>
	<form class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3" method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Cập nhật quốc gia</h5>
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
		<input type="text" hidden value="${quocGia.maQuocGia}" name="maQuocGia"> 
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Tên 
						loại hình</label> <input type="text" class="form-control form-control-sm" value="${quocGia.tenQuocGia}"
						name="tenQuocGia" placeholder="Nhập quốc gia" />
				</div>
			</div>
		</div>

		<div class="d-block text-end">
			<a href="${url}admin/quocgias"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="updateQuocGia" class="btn btn-sm bg-first text-white">Cập nhật</button>
		</div>
	</form>

	<div>
		<div></div>
	</div>
</div>