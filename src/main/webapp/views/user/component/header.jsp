
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Modal đăng nhập-->
<c:url var="url" value="/"></c:url>
<div class="modal fade" id="modalLogin" tabindex="-1" aria-hidden="true">
	<div class="modal-dialog">
		<form id="formLogin" class="modal-content pb-5 px-4 needs-validation"
			novalidate action="method">
			<div class="modal-header border-0">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<h3 class="text-first fw-bolder text-center mb-5">Đăng nhập</h3>

			<div class="px-3">
				<div class="mb-3">
					<label class="form-label fw-bold text-sm mb-1">Email hoặc
						số điện thoại</label> <input type="text" name="tenDangNhap" required
						pattern="(.|\n)*\S(.|\n)*"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập email hoặc số điện thoại  " />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Không
						để trống tên đăng nhập!</div>
				</div>
				<div class="mb-1">
					<label class="form-label fw-bold text-sm mb-1">Mật khẩu</label> <input
						type="password" name="matKhau"
						class="form-control text-sm focus-ring focus-ring-info" required
						pattern="(.|\n)*\S(.|\n)*" s placeholder="Nhập mật khẩu" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Không
						để trống mật khẩu!</div>
				</div>
				<div
					class="d-flex column-gap-1 text-sm my-3 justify-content-between">
					<div>
						<input type="checkbox" class="" /> <span>Ghi nhớ?</span>
					</div>
					<div>
						Bạn chưa có tài khoản? <span class="text-first"
							style="cursor: pointer" data-bs-toggle="modal"
							data-bs-target="#modalRegister">Đăng ký</span>
					</div>
				</div>
				<c:if test="${sessionScope.errorlogin != null}">
					<div>
						<span class="text-danger" style="font-size: 12px">${sessionScope.errorlogin}</span>
					</div>
				</c:if>
				<button formaction="${url}login"
					class="border-0 text-white bg-first text-sm w-100 py-2">
					Đăng nhập</button>
				<div
					class="d-flex align-items-center justify-content-center column-gap-1 my-2">
					<div class="bg-dark-subtle" style="height: 1px; width: 50px"></div>
					<span class="text-light mb-0 text-xs">hoặc</span>
					<div class="bg-dark-subtle" style="height: 1px; width: 50px"></div>
				</div>
				<div
					class="d-flex align-items-center column-gap-3 justify-content-center">
					<img src="https://mewxu.net/wp-content/uploads/2017/03/fb_icon.png"
						alt="" style="height: 30px; width: 30px" /> <img
						src="https://lh3.googleusercontent.com/proxy/07bys0rGvkMEqUNVpAQUyvcEnXdmJVPENT1t5eE329eZz7_bC7wvOoE3e-tHpKuNoEbiWJl08enF_W96jFu1_x97O6Ob799ITrSXyeQQDfpNF_V92g6sqo52J5KpP81ll9amdZUzKpTL9-sNVnb-ZOSqAv_pIkYKuko"
						alt="" style="height: 30px; width: 30px" /> <img
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCenE7gV0EIfAYslRej35mC4K5hpWpCAp_COlNErCyLQ&s"
						alt="" style="height: 30px; width: 30px" />
				</div>
			</div>
		</form>
	</div>
</div>
<!-- Modal đăng kí-->
<div class="modal fade" id="modalRegister" tabindex="-1"
	aria-hidden="true">
	<div class="modal-dialog">
		<form class="modal-content pb-5 px-4 needs-validation" novalidate>
			<div class="modal-header border-0">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<h3 class="text-first fw-bolder text-center mb-5">Đăng kí tài
				khoản</h3>

			<div class="px-3">
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Tên đăng
						nhập<span class="text-danger fs-5">*</span>
					</label> <input type="text" required pattern="(.|\n)*\S(.|\n)*"
						name="maTaiKhoan"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập họ và tên" />

					<div class="invalid-feedback text-danger" style="font-size: 12px">Không
						để trống tên đăng nhập!</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Họ và tên <span
						class="text-danger fs-5">*</span>
					</label> <input type="text" required pattern="(.|\n)*\S(.|\n)*"
						name="tenTaiKhoan"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập họ và tên" />

					<div class="invalid-feedback text-danger" style="font-size: 12px">Không
						để trống họ tên!</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Email <span
						class="text-danger fs-5">*</span>
					</label> <input type="email" name="email"
						class="form-control text-sm focus-ring focus-ring-info" required
						placeholder="Nhập họ và tên" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Email
						không đúng định dạng!</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Số điện
						thoại <span class="text-danger fs-5">*</span>
					</label> <input type="text" name="soDienThoai"
						class="form-control text-sm focus-ring focus-ring-info" required
						pattern="0[0-9]{9}" placeholder="Nhập mật khẩu" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Số
						điện thoại không đúng định dạng!</div>
				</div>
				<div class="mb-2 text-sm d-flex column-gap-3">
					<div>
						<input type="radio" name="gioiTinh" checked /> Nam
					</div>
					<div>
						<input type="radio" name="gioiTinh" /> Nữ
					</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Ngày sinh <span
						class="text-danger fs-5">*</span>
					</label> <input type="date" required name="ngaySinh"
						class="form-control text-sm focus-ring focus-ring-info" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Ngày
						sinh không để trống!</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Mật khẩu <span
						class="text-danger fs-5">*</span>
					</label> <input type="text" required
						pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" name="matKhau"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập mật khẩu" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Không
						để trống mật khẩu!</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Nhập lại mật
						khẩu <span class="text-danger fs-5">*</span>
					</label> <input type="text" required pattern="(.|\n)*\S(.|\n)*"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập lại mật khẩu" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Không
						để trống xác nhận mật khẩu!</div>
				</div>

				<button formaction="${url}register"
					class="border-0 text-white bg-first text-sm w-100 py-2 mt-3"
					id="buttonDangKy">Đăng kí</button>
				<div class="text-sm">
					Bạn đã có tài khoản? <span class="text-first"
						style="cursor: pointer" data-bs-toggle="modal"
						data-bs-target="#modalLogin">Đăng nhập</span>
				</div>
			</div>
		</form>
	</div>
</div>
<header class="bg-white py-4 shadow-sm sticky-top">
	<!-- logo  -->
	<div
		class="container d-flex justify-content-between align-items-center">
		<div>
			<a href="index.html" class="text-decoration-none d-flex"> <span
				class="fw-bolder fs-3 text-first">Cinema</span>
				<div class="d-flex align-items-start">
					<span class="fw-medium text-danger text-sm">Star</span> <i
						class="ri-star-fill text-xs text-third"></i>
				</div>
			</a>
		</div>
		<ul
			class="list-unstyled d-flex flex-xl-row column-gap-5 text-dark fw-bold align-items-center mb-0 flex-column bg-white menu">
			<li
				class="menu-item text-dark d-flex align-items-center column-gap-1">
				<a href="./muave.html"
				class="text-decoration-none text-dark menu-link"><i
					class="ri-coupon-3-line"></i> Mua vé</a>
			</li>
			<li class="menu-item position-relative">Góc điện ảnh <i
				class="ri-arrow-down-s-line"></i>
				<ul
					class="position-absolute menu-list top-100 start-0 bg-white list-unstyled text-dark rounded-1 border border-1 overflow-hidden"
					style="width: 250px">
					<li><a href="${url}phims"
						class="menu-list-item text-decoration-none text-dark">Thể loại
							phim</a></li>
					<li><a href="${url}dienviens"
						class="menu-list-item text-decoration-none text-dark">Diễn
							viên</a></li>
					<li><a href="${url}daodiens"
						class="menu-list-item text-decoration-none text-dark">Đạo diễn</a></li>
					<li><a href="./theloaiphim.html"
						class="menu-list-item text-decoration-none text-dark">Bình
							luận phim</a></li>
				</ul>
			</li>
			<li class="menu-item position-relative">Sự kiện <i
				class="ri-arrow-down-s-line"></i>
				<ul
					class="position-absolute menu-list top-100 start-0 bg-white list-unstyled text-dark rounded-1 border border-1 overflow-hidden"
					style="width: 250px">
					<li><a href="${url}uudais"
						class="menu-list-item text-decoration-none text-dark">Ưu đãi
							tháng</a></li>
					<li><a href="${url}uudais"
						class="menu-list-item text-decoration-none text-dark">Khuyến
							mãi tháng</a></li>
				</ul>
			</li>
		</ul>
		<div class="d-flex align-items-center column-gap-2">
			<div class="input-group border-1 border rounded-1">
				<input type="text" class="form-control border-0 text-sm"
					placeholder="Tìm kiếm" aria-label="Username"
					aria-describedby="basic-addon1" /> <span
					class="input-group-text border-0 bg-transparent" id="basic-addon1"
					style="cursor: pointer"><i class="ri-search-line"></i></span>
			</div>

			<c:if test="${sessionScope.user == null}">
				<button class="bg-transparent border-0 text-sm text-dark"
					id="buttonModalLogin" data-bs-toggle="modal"
					data-bs-target="#modalLogin">Đăng nhập</button>
			</c:if>

			<c:if test="${sessionScope.user != null}">
				<div class="position-relative menu-item">
					<button class="bg-transparent border-0 text-sm text-dark">
						${sessionScope.user.tenTaiKhoan}</button>
					<div
						class="position-absolute d-flex flex-column bg-white shadow-lg menu-list"
						style="width: 200px; z-index: 100; right: 0px; top: 100%">
						<a href=""
							class="text-decoration-none text-dark text-sm block px-3 py-2 info-item">Trang
							cá nhân</a> <a href="${url}logout"
							class="text-decoration-none text-dark text-sm text-sm block px-3 py-2 info-item">Đăng
							xuất</a>
					</div>
				</div>
			</c:if>

		</div>
	</div>
</header>

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
	})()
	
	</script>