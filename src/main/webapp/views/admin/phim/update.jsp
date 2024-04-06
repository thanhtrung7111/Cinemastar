<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý phim / Cập
		nhật</h5>
	<form class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3"
		enctype="multipart/form-data" method="post">
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
							name="tenPhim" value="${phim.tenPhim}"
							id="exampleFormControlInput1" placeholder="Nhập tên phim" />
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Năm
							sản xuất</label> <input type="text" class="form-control form-control-sm"
							value="${phim.namSanXuat}" name="namSanXuat"
							id="exampleFormControlInput1" placeholder="Nhập năm sản xuất" />
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Thời
							lượng</label> <input type="number" class="form-control form-control-sm"
							value="${phim.thoiLuong}" name="thoiLuong"
							id="exampleFormControlInput1" placeholder="Nhập thời lượng" />
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Mô
							tả</label> <input type="text" class="form-control form-control-sm"
							value="${phim.moTa}" name="moTa" id="exampleFormControlInput1"
							placeholder="Nhập mô tả" />
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Nội
							dung</label>
						<textarea class="form-control form-control-sm" name="noiDung"
							id="exampleFormControlInput1" rows="5" placeholder="Nhập mô tả">${phim.noiDung}</textarea>
					</div>
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Trailer</label>
						<input type="text" class="form-control form-control-sm"
							value="${phim.trailer}" name="trailer"
							id="exampleFormControlInput1" placeholder="Nhập địa chỉ" />
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