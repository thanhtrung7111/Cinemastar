<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>
<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý loại ghế</h5>
	<div class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
		<div class="d-flex justify-content-between">
			<h5 class="mb-3">Danh sách loại</h5>
			<div>
				<a href="./themmoicombo.html"
					class="btn btn-primary btn-sm text-white"> <i
					class="ri-file-copy-line"></i> Sao chép
				</a> <a href="./themmoicombo.html"
					class="btn btn-success btn-sm text-white"> <i
					class="ri-file-excel-line"></i> Xuất excel
				</a> <a class="btn bg-first btn-sm text-white"
					href="${url}admin/createloaighe"> <i class="ri-file-add-line"></i>
					Thêm mới
				</a>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th><input type="checkbox" /></th>
					<th scope="col">STT</th>
					<th scope="col">Mã loại ghế</th>
					<th scope="col">Tên loại ghế</th>
					<th scope="col">Giá ghế</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="count" value="0" />
				<c:forEach var="loaiGhe" items="${lgList}">
					<tr class="text-sm">
						<td><input type="checkbox" /></td>
						<c:set var="count" value="${count+1}" />
						<td>${count }</td>
						<td>${loaiGhe.maLoaiGhe }</td>
						<td>${loaiGhe.tenLoaiGhe }</td>
						<td>${loaiGhe.chiPhi }</td>

						<td>
							<div class="d-flex column-gap-2">
								<a href="${url}admin/deleteloaighe?IdLG=${loaiGhe.maLoaiGhe}"
									class=" text-dark text-decoration-none"><i
									class="ri-delete-bin-6-line" style="cursor: pointer"
									title="Xóa"></i></a> <a
									href="${url}admin/updateloaighe?IdLG=${loaiGhe.maLoaiGhe}"
									class=" text-dark text-decoration-none"><i
									class="ri-error-warning-line text-dark text-decoration-none"
									style="cursor: pointer" title="Xem chi tiết"></i></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>