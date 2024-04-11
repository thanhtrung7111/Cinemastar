<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý phim / Thêm
		mới phim</h5>
	<form
		class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3 needs-validation"
		novalidate enctype="multipart/form-data" method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Thêm phim mới</h5>
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
			<div class="col-4">
				<input type="file" name="image" id="image"
					pattern="(.|\n)*\S(.|\n)*" required accept="image/png, image/jpeg"
					onchange="document.getElementById('output').src = window.URL.createObjectURL(this.files[0])"
					hidden> <label style="width: 100%" for="image"> <img
					id="output" src="/cinemastar/images/${phim.hinhAnh}" alt=""
					style="height: 600px; width: 100%; object-fit: cover; object-position: top" />
				</label> <input type="text" value="${phim.hinhAnh}" name="hinhAnh" hidden>
				<div class="invalid-feedback text-danger" style="font-size: 12px">Hình
					ảnh không để trống!</div>
			</div>
			<div class="col-8">
				<div class="d-flex flex-column row-gap-2">
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
							phim</label> <input type="text" class="form-control form-control-sm"
							name="tenPhim" id="exampleFormControlInput1"
							pattern="(.|\n)*\S(.|\n)*" required placeholder="Nhập tên phim" />
						<div class="invalid-feedback text-danger" style="font-size: 12px">Tên
							phim không được để trống!</div>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Năm
							sản xuất</label> <input type="text" class="form-control form-control-sm"
							name="namSanXuat" id="exampleFormControlInput1"
							pattern="[0-4]{4}" required placeholder="Nhập năm sản xuất" />
						<div class="invalid-feedback text-danger" style="font-size: 12px">Năm
							không được để trống!</div>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Thời
							lượng</label> <input type="number" class="form-control form-control-sm"
							name="thoiLuong" id="exampleFormControlInput1" min="60" max="240"
							required required placeholder="Nhập thời lượng" />
						<div class="invalid-feedback text-danger" style="font-size: 12px">Thời
							lượng từ 60 - 240 phút!</div>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Mô
							tả</label> <input type="text" class="form-control form-control-sm"
							name="moTa" id="exampleFormControlInput1"
							pattern="(.|\n)*\S(.|\n)*" required placeholder="Nhập mô tả" />
						<div class="invalid-feedback text-danger" style="font-size: 12px">Mô
							tả không để trống!</div>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Nội
							dung</label>
						<textarea class="form-control form-control-sm" name="noiDung"
							id="exampleFormControlInput1" rows="5" placeholder="Nhập mô tả"></textarea>
						<div class="invalid-feedback text-danger" style="font-size: 12px">Nội
							dung không để trống!</div>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Trailer</label>
						<input type="text" class="form-control form-control-sm"
							name="trailer" id="exampleFormControlInput1"
							pattern="(.|\n)*\S(.|\n)*" required placeholder="Nhập địa chỉ" />
						<div class="invalid-feedback text-danger" style="font-size: 12px">Trailer
							không được để trống!</div>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Quốc
							gia</label> <select class="form-select form-select-sm" name="maQuocGia"
							aria-label="Small select example">
							<c:forEach var="quocGia" items="${quocGias}" varStatus="loop">
								<option value="${quocGia.maQuocGia}">${quocGia.tenQuocGia}</option>
							</c:forEach>
						</select>
					</div>
					<div class="row">
						<div class="col-6">
							<label class="form-label text-sm text-dark fw-bolder mb-1">Diễn
								viên</label> <select class="form-select form-select-sm"
								name="maDienVien" aria-label="Small select example"
								multiple="multiple">
								<c:forEach var="dienVien" items="${dienViens}" varStatus="loop">
									<option value="${dienVien.maDV_DD}">${dienVien.tenDV_DD}</option>
								</c:forEach>
							</select>
							<div class="invalid-feedback text-danger" style="font-size: 12px">Diễn
								viên không để trống!</div>
						</div>
						<div class="col-6">
							<label class="form-label text-sm text-dark fw-bolder mb-1">Đạo
								diễn</label> <select class="form-select form-select-sm" name="maDaoDien"
								aria-label="Small select example" multiple="multiple">
								<c:forEach var="daoDien" items="${daoDiens}" varStatus="loop">
									<option value="${daoDien.maDV_DD}">${daoDien.tenDV_DD}</option>
								</c:forEach>
							</select>
							<div class="invalid-feedback text-danger" style="font-size: 12px">Đạo
								diễn không để trống!</div>
						</div>
					</div>
				</div>
			</div>
		</div>



		<div class="d-block text-end">
			<a href="${url}admin/phims" class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="createphim"
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