<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý loại ghế /
		Cập nhật</h5>
	<div class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Cập nhật</h5>
		<form action="" method="post">
			<div class="row g-3 mb-3">
				<div class="col-6">
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Mã
							loại ghế</label> <input name="maLoaiGhe"
							class="form-control form-control-sm"
							id="exampleFormControlInput1" disabled="disabled"
							value="${lg.maLoaiGhe}" /> <input
							name="maLG" class="form-control form-control-sm"
							id="exampleFormControlInput1" hidden="true"
							value="${lg.maLoaiGhe}" />
					</div>
				</div>

				<div class="col-6">
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
							loại ghế</label> <input value="${lg.tenLoaiGhe}" name="tenLoaiGhe"
							type="text" class="form-control form-control-sm"
							id="exampleFormControlInput1" placeholder="Nhập tên loại ghế" />
					</div>
				</div>
				<div class="col-6">
					<div>
						<label class="form-label text-sm text-dark fw-bolder mb-1">Chi
							phí</label> <input name="chiPhi" value="${lg.chiPhi}"
							class="form-control form-control-sm"
							id="exampleFormControlInput1" placeholder="Nhập chi phí" />
					</div>
				</div>
			</div>
			<div class="d-block text-end">
				<a href="${url}admin/loaighes"
					class="btn btn-sm bg-danger text-white">Hủy</a> <input
					class="btn btn-dark btn-sm bg-first text-white" type="submit"
					name="updateLoaiGheButton" formaction="${url}admin/updateloaighe"
					value="Cập nhật">
			</div>
		</form>
	</div>
	<div>
		<div></div>
	</div>
</div>
