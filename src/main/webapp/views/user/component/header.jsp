
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Modal đăng nhập-->
<c:url var="url" value="/"></c:url>
<div class="modal fade" id="modalLogin" tabindex="-1" aria-hidden="true">
	<div class="modal-dialog">
		<form id="formLogin" class="modal-content pb-5 px-4" action="method">
			<div class="modal-header border-0">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<h3 class="text-first fw-bolder text-center mb-5">Đăng nhập</h3>

			<div class="px-3">
				<div class="mb-3">
					<label class="form-label fw-bold text-sm mb-1">Email hoặc
						số điện thoại</label> <input type="text" name="tenDangNhap"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập email hoặc số điện thoại  " />
				</div>
				<div class="mb-1">
					<label class="form-label fw-bold text-sm mb-1">Mật khẩu</label> <input
						type="password" name="matKhau"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập mật khẩu" />
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
					<img src="./assets/img/icon/facebook.png" alt=""
						style="height: 30px; width: 30px" /> <img
						src="./assets/img/icon/google.png" alt=""
						style="height: 30px; width: 30px" /> <img
						src="./assets/img/icon/twitter.png" alt=""
						style="height: 30px; width: 30px" />
				</div>
			</div>
		</form>
	</div>
</div>
<!-- Modal đăng kí-->
<div class="modal fade" id="modalRegister" tabindex="-1"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content pb-5 px-4">
			<div class="modal-header border-0">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<h3 class="text-first fw-bolder text-center mb-5">Đăng kí tài
				khoản</h3>

			<div class="px-3">
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Họ và tên <span
						class="text-danger fs-5">*</span>
					</label> <input type="email"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập họ và tên" />
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Email <span
						class="text-danger fs-5">*</span>
					</label> <input type="email"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập họ và tên" />
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Số điện
						thoại <span class="text-danger fs-5">*</span>
					</label> <input type="email"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập mật khẩu" />
				</div>
				<div class="mb-2 text-sm d-flex column-gap-3">
					<div>
						<input type="radio" /> Nam
					</div>
					<div>
						<input type="radio" /> Nữ
					</div>
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Ngày sinh <span
						class="text-danger fs-5">*</span>
					</label> <input type="date"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập mật khẩu" />
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Mật khẩu <span
						class="text-danger fs-5">*</span>
					</label> <input type="text"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập mật khẩu" />
				</div>
				<div class="mb-2">
					<label class="form-label fw-bold text-sm mb-1">Nhập lại mật
						khẩu <span class="text-danger fs-5">*</span>
					</label> <input type="text"
						class="form-control text-sm focus-ring focus-ring-info"
						placeholder="Nhập lại mật khẩu" />
				</div>
				<div
					class="d-flex column-gap-1 text-sm my-3 justify-content-between">
					<div>
						<input type="checkbox" class="" /> <span>Tôi đồng ý với
							các điều khoản</span>
					</div>
				</div>
				<button class="border-0 text-white bg-first text-sm w-100 py-2">
					Đăng kí</button>
				<div class="text-sm">
					Bạn đã có tài khoản? <span class="text-first"
						style="cursor: pointer" data-bs-toggle="modal"
						data-bs-target="#modalLogin">Đăng nhập</span>
				</div>
			</div>
		</div>
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
			<li class="menu-item position-relative">Phim <i
				class="ri-arrow-down-s-line"></i>

				<div
					class="d-none d-xl-block z-3 position-absolute menu-list top-100 start-0 bg-white list-unstyled text-dark rounded-1 border border-1 overflow-hidden p-3"
					style="width: 900px">
					<div id="carouselMenu" class="carousel slide"
						data-bs-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active" data-bs-interval="10000">
								<div class="row g-4">
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim7.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Quật mộ trùng ma</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim-2.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Kungfu Panda 4</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim3.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Dune: Hành tinh cát - Phần 2</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim4.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Quý cô thừa kế</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim5.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Bức hoạ bí ẩn</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim6.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Biệt đội săn rồng</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim7.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Vong nữ đoạt hồn</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim8.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Mai</h4>
									</div>
								</div>
							</div>
							<div class="carousel-item" data-bs-interval="2000">
								<div class="row g-4">
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim1.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Quật mộ trùng ma</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim-2.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Kungfu Panda 4</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim3.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Dune: Hành tinh cát - Phần 2</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim4.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Quý cô thừa kế</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim5.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Bức hoạ bí ẩn</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim6.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Biệt đội săn rồng</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim7.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Vong nữ đoạt hồn</h4>
									</div>
									<!-- PHIM ITEM  -->
									<div class="col-3 product-item" style="cursor: pointer">
										<div class="rounded-3 overflow-hidden mb-2 position-relative">
											<img src="./assets/img/imgphim8.jpg" alt=""
												style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />

											<div
												class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
												style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
												10 <i class="ri-star-fill"></i>
											</div>
											<div
												class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
												style="width: 100%; height: 100%">
												<a href="./muave.html" class="btn btn-warning text-sm">
													<i class="ri-coupon-3-line"></i> Mua vé
												</a> <a href="./chitietphimdangchieu.html"
													class="btn btn-outline-info text-sm"> <i
													class="ri-folder-video-line"></i> Trailer
												</a>
											</div>
										</div>
										<h4 class="fw-bold fs-6">Mai</h4>
									</div>
								</div>
							</div>
						</div>
						<button class="carousel-control-prev bg-opacity-50 bg-black p-2"
							type="button" data-bs-target="#carouselMenu" data-bs-slide="prev"
							style="height: fit-content; width: fit-content; top: 50%; transform: translateY(-50%);">
							<i class="ri-arrow-left-s-line fs-3"></i>
						</button>
						<button class="carousel-control-next bg-opacity-50 bg-black p-2"
							type="button" data-bs-target="#carouselMenu" data-bs-slide="next"
							style="height: fit-content; width: fit-content; top: 50%; transform: translateY(-50%);">
							<i class="ri-arrow-right-s-line fs-3"></i>
						</button>
					</div>
				</div>
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
				<button class="bg-transparent border-0 text-sm text-dark" id="buttonModalLogin"
					data-bs-toggle="modal" data-bs-target="#modalLogin">Đăng
					nhập</button>
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