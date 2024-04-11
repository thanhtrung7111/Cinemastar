<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý phim / Cập
		nhật</h5>
	<form
		class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3 needs-validation"
		novalidate enctype="multipart/form-data" method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Cập nhật phim</h5>
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
					onchange="document.getElementById('output').src = window.URL.createObjectURL(this.files[0])"
					hidden> <label style="width: 100%" for="image"> <img
					id="output" src="/cinemastar/images/${phim.hinhAnh}" alt=""
					style="height: 600px; width: 100%; object-fit: cover; object-position: top" />
				</label> <input type="text" value="${phim.hinhAnh}" name="hinhAnh" hidden>
			</div>
			<div class="col-8">
				<input type="text" value="${phim.maPhim}" name="maPhim" hidden>
				<div class="d-flex flex-column row-gap-2">
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
							phim</label> <input type="text" class="form-control form-control-sm"
							name="tenPhim" value="${phim.tenPhim}" pattern="(.|\n)*\S(.|\n)*"
							required id="exampleFormControlInput1"
							placeholder="Nhập tên phim" />
						<div class="invalid-feedback text-danger" style="font-size: 12px">Tên
							phim không được để trống!</div>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Năm
							sản xuất</label> <input type="text" class="form-control form-control-sm"
							value="${phim.namSanXuat}" name="namSanXuat" pattern="[0-4]{4}"
							required id="exampleFormControlInput1"
							placeholder="Nhập năm sản xuất" />
						<div class="invalid-feedback text-danger" style="font-size: 12px">Năm
							không được để trống!</div>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Thời
							lượng</label> <input type="number" class="form-control form-control-sm"
							value="${phim.thoiLuong}" name="thoiLuong" min="60" max="240"
							required id="exampleFormControlInput1"
							placeholder="Nhập thời lượng" />
						<div class="invalid-feedback text-danger" style="font-size: 12px">Thời
							lượng từ 60 - 240 phút!</div>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Mô
							tả</label> <input type="text" class="form-control form-control-sm"
							pattern="(.|\n)*\S(.|\n)*" required value="${phim.moTa}"
							name="moTa" id="exampleFormControlInput1"
							placeholder="Nhập mô tả" />
						<div class="invalid-feedback text-danger" style="font-size: 12px">Mô
							tả không để trống!</div>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Nội
							dung</label>
						<textarea class="form-control form-control-sm" name="noiDung"
							id="exampleFormControlInput1" rows="5" placeholder="Nhập mô tả">${phim.noiDung}</textarea>
						<div class="invalid-feedback text-danger" style="font-size: 12px">Nội
							dung không để trống!</div>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Trailer</label>
						<input type="text" class="form-control form-control-sm"
							value="${phim.trailer}" name="trailer" pattern="(.|\n)*\S(.|\n)*"
							required id="exampleFormControlInput1" placeholder="Nhập địa chỉ" />
						<div class="invalid-feedback text-danger" style="font-size: 12px">Trailer
							không được để trống!</div>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Quốc
							gia</label> <select class="form-select form-select-sm" name="maQuocGia"
							aria-label="Small select example">
							<c:forEach var="quocGia" items="${quocGias}" varStatus="loop">
								<option
									${quocGia.maQuocGia == phim.quocGia.maQuocGia ? 'selected="selected"' :''}
									value="${quocGia.maQuocGia}">${quocGia.tenQuocGia}</option>
							</c:forEach>
						</select>
					</div>
					<div class="row">
						<div class="col-6">
							<label class="form-label text-sm text-dark fw-bolder mb-1">Diễn
								viên</label> <select class="form-select form-select-sm"
								name="maDienVien" aria-label="Small select example"
								multiple="multiple">
								<c:forEach var="thamGia" items="${phim.thamGias}"
									varStatus="loop">
									<c:if
										test="${thamGia.dienVienDaoDien.vaiTro.tenVaiTro == 'Diễn Viên'}">
										<option value="${thamGia.dienVienDaoDien.maDV_DD}">${thamGia.dienVienDaoDien.tenDV_DD}</option>
									</c:if>

								</c:forEach>
							</select>
							<div class="invalid-feedback text-danger" style="font-size: 12px">Diễn
								viên không để trống!</div>
						</div>
						<div class="col-6">
							<label class="form-label text-sm text-dark fw-bolder mb-1">Đạo
								diễn</label> <select class="form-select form-select-sm" name="maDaoDien"
								aria-label="Small select example" multiple="multiple">
								<c:forEach var="thamGia" items="${phim.thamGias}"
									varStatus="loop">
									<c:if
										test="${thamGia.dienVienDaoDien.vaiTro.tenVaiTro == 'Đạo Diễn'}">
										<option value="${thamGia.dienVienDaoDien.maDV_DD}">${thamGia.dienVienDaoDien.tenDV_DD}</option>
									</c:if>
								</c:forEach>
							</select>
							<div class="invalid-feedback text-danger" style="font-size: 12px">Đạo
								diễn không để trống!</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="d-block text-end mt-4">
			<a href="${url}admin/phims" class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="updatephim"
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