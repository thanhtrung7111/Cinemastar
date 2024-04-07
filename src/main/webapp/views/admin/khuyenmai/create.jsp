<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>
<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý khuyến mãi /
		Thêm mới</h5>
	<form class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3" enctype="multipart/form-data"
		method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Thêm khuyến mãi mới</h5>
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
				<input type="file" name="image" id="image"
					onchange="document.getElementById('output').src = window.URL.createObjectURL(this.files[0])"
					hidden> <label style="width: 100%" for="image"> <img
					id="output" src="/cinemastar/images/${dienVien.hinhAnh}" alt=""
					style="height: 600px; width: 100%; object-fit: cover; object-position: top" />
				</label> <input type="text" value="${dienVien.hinhAnh}" name="hinhAnh"
					hidden>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
						khuyến mãi</label> <input type="text" name="tenKhuyenMai"
						class="form-control form-control-sm" id="exampleFormControlInput1"
						placeholder="Nhập tên khuyến mãi" />
				</div>
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Phần
						trăm giảm</label> <input type="number" name="phanTramGiam"
						class="form-control form-control-sm" id="exampleFormControlInput1"
						min="0" />
				</div>
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Giảm
						trực tiếp</label> <input type="number" name="soTienGiamTrucTiep"
						class="form-control form-control-sm" id="exampleFormControlInput1"
						placeholder="Nhập số tiền giảm trực tiếp" />
				</div>
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Ngày
						bắt đầu</label> <input type="date" name="ngayApDung"
						class="form-control form-control-sm" />
				</div>
			</div>
		</div>

		<div class="d-block text-end">
			<a href="${url}admin/khuyenmais"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="createkhuyenmai"
				class="btn btn-sm bg-first text-white">Thêm mới</button>
		</div>
	</form>

	<div>
		<div></div>
	</div>
</div>