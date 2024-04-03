<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>
<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý khuyến mãi /
		Cập nhật</h5>
	<form class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3"
		method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Cập nhật khuyến mãi</h5>
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
			<input type="text" class="form-control form-control-sm"
				id="exampleFormControlInput1" placeholder="Nhập mã khuyến mãi"
				name="maKhuyenMai" value="${khuyenMai.maKhuyenMai}" hidden />


			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
						khuyến mãi</label> <input type="text" class="form-control form-control-sm"
						id="exampleFormControlInput1" name="tenKhuyenMai"
						value="${khuyenMai.tenKhuyenMai}"
						placeholder="Nhập tên
						khuyến mãi" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Phần
						trăm giảm</label> <input type="number" name="phanTramGiam"
						value="${khuyenMai.phanTramGiam}"
						class=" form-control
						form-control-sm" id="exampleFormControlInput1" min="0" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Giảm
						trực tiếp</label> <input type="number" name="soTienGiamTrucTiep"
						value="${khuyenMai.soTienGiamTrucTiep}"
						class="form-control form-control-sm" id="exampleFormControlInput1"
						placeholder="Nhập số tiền giảm trực tiếp" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Ngày
						bắt đầup</label> <input type="date" name="ngayApDung"
						value="${khuyenMai.ngayApDung}"
						class="form-control form-control-sm" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Ngày
						kết thúc</label> <input type="date" name="ngayKetThuc"
						value="${khuyenMai.ngayKetThuc}"
						class="form-control form-control-sm" />
				</div>
			</div>

		</div>

		<div class="d-block text-end">
			<a href="${url}admin/khuyenmais"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="updatekhuyenmai"
				class="btn btn-sm bg-first text-white">Cập nhật</button>
		</div>
	</form>

	<div>
		<div></div>
	</div>
</div>