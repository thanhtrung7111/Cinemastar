<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý nhân viên</h5>
	<div class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
		<div class="d-flex justify-content-between">
			<h5 class="mb-3">Danh sách nhân viên</h5>
			<div>
				<a href="./themmoicombo.html"
					class="btn btn-primary btn-sm text-white"> <i
					class="ri-file-copy-line"></i> Sao chép
				</a> <a href="./themmoicombo.html"
					class="btn btn-success btn-sm text-white"> <i
					class="ri-file-excel-line"></i> Xuất excel
				</a> <a href="${url}admin/createnhanvien"
					class="btn bg-first btn-sm text-white"> <i
					class="ri-file-add-line"></i> Thêm mới
				</a>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th><input type="checkbox" /></th>
					<th scope="col">#</th>
					<th scope="col">Mã nhân viên</th>
					<th scope="col">Tên nhân viên</th>
					<th scope="col">Email</th>
					<th scope="col">Số điện thoại</th>
					<th scope="col">Mật khẩu</th>
					<th scope="col">Loại nhân viên</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="nhanVien" items="${nhanViens}"
					varStatus="loop">
					<tr class="text-sm">
						<td><input type="checkbox" /></td>
						<td>${loop.index +1}</td>
						<td>${nhanVien.maNhanVien}</td>
						<td>${nhanVien.tenNhanVien}</td>
						<td>${nhanVien.email}</td>
						<td>${nhanVien.soDienThoai}</td>
						<td>******</td>
						<td>${nhanVien.loaiNhanVien.tenLoaiNhanVien}</td>
						<td>
							<div class="d-flex column-gap-2">
								<a
									href="${url}admin/deletenhanvien?maNhanVien=${nhanVien.maNhanVien}"
									class="ri-delete-bin-6-line text-dark text-decoration-none"
									style="cursor: pointer" title="Xóa"></a><a
									href="${url}admin/updatenhanvien?maNhanVien=${nhanVien.maNhanVien}"
									class="ri-error-warning-line text-dark text-decoration-none"
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