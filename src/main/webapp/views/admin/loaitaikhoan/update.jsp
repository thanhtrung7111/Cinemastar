<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý khuyến mãi /
		Thêm mới</h5>
	<form
		class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3 needs-validation"
		novalidate method="post">
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
			<input type="text" value="${loaiTaiKhoan.maLoaiTaiKhoan}" hidden>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
						loại tài khoản</label> <input value="${loaiTaiKhoan.tenLoaiTaiKhoan}"
						type="text" name="tenLoaiTaiKhoan" required
						pattern="(.|\n)*\S(.|\n)*" class="form-control form-control-sm"
						id="exampleFormControlInput1"
						placeholder="Nhập tên loại tài khoản" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Tên
						loại tài khoản không để trống!</div>
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Chi
						tiêu tối thiểu</label> <input value="${loaiTaiKhoan.chiTieuToiThieu}"
						type="number" name="chiTieuToiThieu"
						class="form-control form-control-sm" required min="1000000"
						max="100000000"
						placeholder="Nhập chi tiêu tổi thiểu cho loại tài khoản!" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Chi
						tiêu từ 1.000.000 đến 100.000.000 VNĐ!</div>
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Mô tả</label>
					<input type="text" value="${loaiTaiKhoan.mota}" required
						pattern="(.|\n)*\S(.|\n)*" class="form-control form-control-sm"
						name="mota" placeholder="Nhập mô tả loại tài khoản!" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Mô
						tả không để trống!</div>
				</div>
			</div>
		</div>

		<div class="d-block text-end">
			<a href="${url}admin/loaitaikhoans"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="updateloaitaikhoan"
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