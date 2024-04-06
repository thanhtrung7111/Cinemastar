<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>
<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý loại tài khoản</h5>
	<div class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
		<div class="d-flex justify-content-between">
			<h5 class="mb-3">Danh sách các loại tài khoản</h5>
			<div>
				<a href="./themmoicombo.html"
					class="btn btn-primary btn-sm text-white"> <i
					class="ri-file-copy-line"></i> Sao chép
				</a> <a href="./themmoicombo.html"
					class="btn btn-success btn-sm text-white"> <i
					class="ri-file-excel-line"></i> Xuất excel
				</a> <a class="btn bg-first btn-sm text-white"
					href="${url}admin/createdienvien"> <i
					class="ri-file-add-line"></i> Thêm mới
				</a>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th><input type="checkbox" /></th>
					<th scope="col">#</th>
					<th scope="col">Mã diễn viên</th>
					<th scope="col">Tên diễn viên</th>
					<th scope="col">Năm ngày sinh</th>
					<th scope="col">Mô tả</th>
					<th scope="col">Chiều cao</th>
					<th scope="col">Vai trò</th>
					<th scope="col">Quốc gia</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dienVienDaoDien" items="${dienVienDaoDiens}" varStatus="loop">
					<tr class="text-sm">
						<td><input type="checkbox" /></td>
						<td>${loop.index+1}</td>
						<td>${dienVienDaoDien.maDV_DD}</td>
						<td>${dienVienDaoDien.tenDV_DD}</td>
						<td>${dienVienDaoDien.ngaySinh}</td>
						<td>${dienVienDaoDien.mota }</td>
						<td>${dienVienDaoDien.chieuCao}</td>
						<td>${dienVienDaoDien.vaiTro.tenVaiTro}</td>
						<td>${dienVienDaoDien.quocGia.tenQuocGia}</td>
						<td>
							<div class="d-flex column-gap-2">
								<a
									href="${url}admin/deletedienvien?maDV_DD=${dienVienDaoDien.maDV_DD}"
									class="ri-delete-bin-6-line text-decoration-none text-dark"
									style="cursor: pointer" title="Xóa"></a><a
									href="${url}admin/updatedienvien?maDV_DD=${dienVienDaoDien.maDV_DD}"
									class="ri-error-warning-line text-decoration-none text-dark"
									style="cursor: pointer" title="Xem chi tiết"></a>
							</div>
						</td>
					</tr>


				</c:forEach>

			</tbody>
		</table>
	</div>

	<div>
		<div></div>
	</div>
</div>