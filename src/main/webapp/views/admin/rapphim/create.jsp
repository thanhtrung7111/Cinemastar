<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>
<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý rạp phim /
		Thêm mới</h5>
	<form
		class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3 needs-validation"
		novalidate method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Thêm rạp phim mới</h5>
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
						rạp phim</label> <input type="text" class="form-control form-control-sm"
						id="exampleFormControlInputs1" name="tenRapPhim" required
						pattern="(.|\n)*\S(.|\n)*" placeholder="Nhập tên rạp phim" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Tên
						rạp phim không để trống!</div>
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Địa
						chỉ</label> <input type="text" class="form-control form-control-sm"
						required pattern="(.|\n)*\S(.|\n)*" id="exampleFormControlInput1"
						name="diaChi" placeholder="Nhập địa chỉ" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Địa
						chỉ không để trống!</div>
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Số
						điện thoại</label> <input type="text" class="form-control form-control-sm"
						name="soDienThoai" id="exampleFormControlInput1" required
						pattern="0[0-9]{9}" placeholder="Nhập số điện thoại" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Điện
						thoại không để trống!</div>
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Thành
						phố</label> <select class="form-select form-select-sm"
						aria-label="Small select example" name="maThanhPho">
						<c:forEach var="thanhPho" items="${thanhPhos}" varStatus="loop">
							<option ${loop.index == 0 ? 'selected="selected"' : ''}
								value="${thanhPho.maThanhPho}">${thanhPho.tenThanhPho}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>

		<div class="d-block text-end">
			<a href="${url}admin/rapphims"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="createrapphim" id="createRapPhim"
				class="btn btn-sm bg-first text-white">Thêm mới</button>
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