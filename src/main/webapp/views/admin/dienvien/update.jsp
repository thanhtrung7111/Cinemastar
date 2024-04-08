<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý diễn viên / Cập
		nhật</h5>
	<form class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3"
		enctype="multipart/form-data" method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Cập nhật diễn viên</h5>
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
					id="output" src="/cinemastar/images/${dienVienDaoDien.hinhAnh}"
					alt=""
					style="height: 600px; width: 100%; object-fit: cover; object-position: top" />
				</label> <input type="text" value="${dienVienDaoDien.hinhAnh}"
					name="hinhAnh" hidden>
			</div>
			<div class="col-8">
				<div class="d-flex flex-column row-gap-2">
					<input type="text" value="${dienVienDaoDien.maDV_DD}" name="maDV_DD" hidden>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
							diễn viên đạo diễn</label> <input type="text"
							value="${dienVienDaoDien.tenDV_DD}"
							class="form-control form-control-sm" name="tenDV_DD"
							id="exampleFormControlInput1" placeholder="Nhập tên phim" />
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">ngaySinh</label>
						<input type="date" class="form-control form-control-sm"
							value="${dienVienDaoDien.ngaySinh}" name="ngaySinh"
							id="exampleFormControlInput1" placeholder="Nhập năm sản xuất" />
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Chiều
							cao</label> <input type="number" class="form-control form-control-sm"
							value="${dienVienDaoDien.chieuCao}" name="chieuCao"
							id="exampleFormControlInput1" placeholder="Nhập thời lượng" />
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Mô
							tả</label> <input type="text" class="form-control form-control-sm"
							value="${dienVienDaoDien.mota}" name="mota"
							id="exampleFormControlInput1" placeholder="Nhập mô tả" />
					</div>

					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Vai
							trò</label> <select class="form-select form-select-sm" name="maVaiTro"
							aria-label="Small select example">
							<c:forEach var="vaiTro" items="${vaiTros}" varStatus="loop">
								<option
									${dienVienDaoDien.vaiTro.maVaiTro == vaiTro.maVaiTro ? 'selected = "selected"':''}
									value="${vaiTro.maVaiTro}">${vaiTro.tenVaiTro}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Quốc
							gia</label> <select class="form-select form-select-sm" name="maQuocGia"
							aria-label="Small select example">
							<c:forEach var="quocGia" items="${quocGias}" varStatus="loop">
								<option
									${dienVienDaoDien.quocGia.maQuocGia == quocGia.maQuocGia ? 'selected = "selected"':''}
									value="${quocGia.maQuocGia}">${quocGia.tenQuocGia}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>



		<div class="d-block text-end">
			<a href="${url}admin/dienviens"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="updatedienvien"
				class="btn btn-sm bg-first text-white">Thêm mới</button>
		</div>
	</form>

	<div>
		<div></div>
	</div>
</div>