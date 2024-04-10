<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý loại ghế /
		Thêm mới</h5>
	<div class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Thêm loại ghế mới</h5>
		<form action="" method="post"  class="needs-validation" novalidate>
			<div class="row g-3 mb-3">
				<div class="col-6">
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
							loại ghế</label> <input name="tenLoaiGhe" type="text"
							class="form-control form-control-sm" required
							pattern="(.|\n)*\S(.|\n)*" id="exampleFormControlInput1"
							placeholder="Nhập tên loại ghế" />
						<div class="invalid-feedback text-danger" style="font-size: 12px">Tên
							loại ghế không để trống!</div>
					</div>
				</div>
				<div class="col-6">
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Chi
							phí</label> <input name="chiPhi" class="form-control form-control-sm"
							required min="500000" max="1000000" id="exampleFormControlInput1"
							placeholder="Nhập chi phí" />
						<div class="invalid-feedback text-danger" style="font-size: 12px">Chi
							phí ghế từ 50000 - 100000VNĐ!</div>
					</div>
				</div>
			</div>
			<div class="d-block text-end">
				<a href="${url}admin/loaighes"
					class="btn btn-sm bg-danger text-white">Hủy</a> <input
					class="btn btn-dark btn-sm bg-first text-white" type="submit"
					name="createLoaiGheButton" formaction="createloaighe" value="Thêm">
			</div>
		</form>
	</div>
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