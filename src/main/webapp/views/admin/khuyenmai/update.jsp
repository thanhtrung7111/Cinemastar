<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>
<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý khuyến mãi /
		Cập nhật</h5>
	<form
		class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3 needs-validation"
		novalidate enctype="multipart/form-data" method="post">
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

			<div class="col-6">
				<input type="file" name="image" id="image"
					onchange="document.getElementById('output').src = window.URL.createObjectURL(this.files[0])"
					hidden> <label style="width: 100%" for="image"> <img
					id="output" src="/cinemastar/images/${khuyenMai.hinhAnh}" alt=""
					style="height: 300px; width: 100%; object-fit: cover; object-position: top" />
				</label> <input type="text" value="${khuyenMai.hinhAnh}" name="hinhAnh"
					hidden>
			</div>

			<div class="col-6">
				<input type="text" class="form-control form-control-sm"
					id="exampleFormControlInput1" placeholder="Nhập mã khuyến mãi"
					name="maKhuyenMai" value="${khuyenMai.maKhuyenMai}" hidden />
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
						khuyến mãi</label> <input type="text" class="form-control form-control-sm"
						id="exampleFormControlInput1" name="tenKhuyenMai"
						value="${khuyenMai.tenKhuyenMai}" required
						pattern="(.|\n)*\S(.|\n)*"
						placeholder="Nhập tên
						khuyến mãi" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Tên
						khuyến mãi không để trống!</div>
				</div>
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Phần
						trăm giảm</label> <input type="number" name="phanTramGiam"
						value="${khuyenMai.phanTramGiam}"
						class=" form-control
						form-control-sm"
						id="exampleFormControlInput1" min="0" max='100' required />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Phần
						trăm giảm từ 0-100%!</div>
				</div>
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Giảm
						trực tiếp</label> <input type="number" name="soTienGiamTrucTiep"
						value="${khuyenMai.soTienGiamTrucTiep}"
						class="form-control form-control-sm" id="exampleFormControlInput1"
						required min="50000" max="1000000" required
						placeholder="Nhập số tiền giảm trực tiếp" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Số
						tiền giảm trực tiếp từ 50.000 - 1.000.000VNĐ!</div>
				</div>
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Ngày
						bắt đầu</label> <input type="date" name="ngayApDung"
						value="${khuyenMai.ngayApDung}" required
						class="form-control form-control-sm" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Ngày
						bắt đầu không để trống!</div>
				</div>
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Ngày
						kết thúc</label> <input type="date" name="ngayKetThuc"
						value="${khuyenMai.ngayKetThuc}" required
						class="form-control form-control-sm" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Ngày
						kết thúc khuyến mãi không được để trống!</div>
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
<script type="text/javascript">// Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
	  'use strict'

	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	  const forms = document.querySelectorAll('.needs-validation')

	  // Loop over them and prevent submission
	  Array.from(forms).forEach(form => {
	    form.addEventListener('submit', event => {
	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }

	      form.classList.add('was-validated')
	    }, false)
	  })
	})()</script>