<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- main  -->
<main class="mt-4">
	<!-- PHIM CHIẾU TRONG TUẦN  -->
	<div class="container">
		<!-- Phim chiếu trong tuần  -->
		<h4
			class="text-dark border-4 border-start border-dark px-2 fw-bold mb-4">
			Thể loại phim</h4>
		<div class="row g-4">
			<div class="col-12 col-lg-8 col-xl-9">
				<div class="d-flex align-items-center column-gap-2 mb-3"
					style="width: 450px">
					<select class="form-select form-select-lg text-sm text-dark"
						aria-label="Large select example">
						<option selected>Năm sản xuất</option>
						<option value="1">One</option>
						<option value="2">Two</option>
						<option value="3">Three</option>
					</select> <select class="form-select form-select-lg text-sm text-dark"
						aria-label="Large select example">
						<option selected>Thể loại</option>
						<option value="1">One</option>
						<option value="2">Two</option>
						<option value="3">Three</option>
					</select> <select class="form-select form-select-lg text-sm text-dark"
						aria-label="Large select example">
						<option selected>Quốc gia</option>
						<option value="1">One</option>
						<option value="2">Two</option>
						<option value="3">Three</option>
					</select>
				</div>

				<div class="d-flex row-gap-3 flex-column">
					<c:forEach var="phim" items="${phims}">
						<a href="./theloaiphimchitiet.html"
							class="row gx-3 text-decoration-none">
							<div class="col-5 col-lg-4 col-xl-3">
								<img src="/cinemastar/images/${phim.hinhAnh}" alt=""
									style="width: 100%; height: 300px; object-fit: cover; object-position: center;"
									class="rounded-3" />
							</div>
							<div class="col-7 col-lg-8 col-xl-9">
								<h4 class="fw-bold text-dark">${phim.tenPhim}</h4>
								<div class="d-flex column-gap-3 mb-2">
									<div class="d-flex align-items-center column-gap-1 text-first">
										<i class="ri-thumb-up-fill"></i> 25
									</div>
									<div class="d-flex align-items-center column-gap-1 text-first">
										<i class="ri-eye-fill"></i> ${phim.luotXem}
									</div>
								</div>
								<p class="text-sm text-light">${phim.moTa}</p>
							</div>
						</a>
					</c:forEach>
				</div>
				<div
					class="mt-5 text-center d-flex align-items-center justify-content-center column-gap-2">
					<button
						class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
						style="height: 30px; width: 30px; outline: none">
						<i class="ri-arrow-left-s-line"></i>
					</button>
					<button
						class="border-1 bg-first border-first bg-transparent text-white d-flex align-items-center justify-content-center text-sm"
						style="height: 30px; width: 30px; outline: none">1</button>
					<button
						class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
						style="height: 30px; width: 30px; outline: none">2</button>
					<button
						class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
						style="height: 30px; width: 30px; outline: none">3</button>

					<span>...</span>
					<button
						class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
						style="height: 30px; width: 30px; outline: none">7</button>
					<button
						class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
						style="height: 30px; width: 30px; outline: none">8</button>
					<button
						class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
						style="height: 30px; width: 30px; outline: none">9</button>
					<button
						class="border-1 border-first bg-transparent text-first d-flex align-items-center justify-content-center text-sm"
						style="height: 30px; width: 30px; outline: none">
						<i class="ri-arrow-right-s-line"></i>
					</button>
				</div>
			</div>
			<div class="col-12 col-lg-4 col-xl-3">
				<div class="rounded-4 bg-white shadow-sm overflow-hidden mb-4">
					<div class="p-3 d-flex flex-column row-gap-3">
						<select
							class="form-select form-select-lg text-dark text-sm focus-ring focus-ring-info"
							aria-label="Default select example">
							<option selected>Chọn suất</option>
							<option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option>
						</select> <select
							class="form-select form-select-lg text-dark text-sm focus-ring focus-ring-info"
							aria-label="Default select example">
							<option selected>Chọn phim</option>
							<option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option>
						</select>
						<div>
							<h5 class="fs-6 text-dark">Chọn suất:</h5>
							<div class="d-flex flex-wrap gap-2">
								<div
									class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
									7:30</div>
								<div
									class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
									7:30</div>
								<div
									class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
									7:30</div>
								<div
									class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
									7:30</div>
								<div
									class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
									7:30</div>
								<div
									class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
									7:30</div>
								<div
									class="text-dark px-2 py-1 rounded-2 border bg-white fw-bold">
									7:30</div>
							</div>
						</div>
					</div>
					<button class="border-0 w-100 py-2 bg-first text-white">
						Mua vé</button>
				</div>
				<div>
					<h4
						class="text-first border-4 border-start border-first px-2 fw-bold mb-4">
						Đang chiếu</h4>
					<div class="row row-gap-2">
						<c:forEach var="phim" items="${phimDangChieus}">
							<div class="product-item col-sm-6 col-md-4 col-lg-12"
								style="cursor: pointer">
								<div class="rounded-3 overflow-hidden mb-2 position-relative">
									<img src="/cinemastar/images/${phim.hinhAnh}" alt=""
										style="height: 400px; width: 100%; object-fit: cover; object-position: center;" />

									<div
										class="text-third bg-second position-absolute fs-6 opacity-75 py-2 d-flex align-items-center justify-content-center"
										style="width: 60px; top: 0; right: 0; border-bottom-left-radius: 10px;">
										10 <i class="ri-star-fill"></i>
									</div>
									<div
										class="product-overlay position-absolute top-0 start-0 bg-black bg-opacity-50 d-flex align-items-center justify-content-center flex-column row-gap-2"
										style="width: 100%; height: 100%">
										<a href="./muave.html" class="btn btn-warning text-sm"> <i
											class="ri-coupon-3-line"></i> Mua vé
										</a> <a href="./chitietphimdangchieu.html"
											class="btn btn-outline-info text-sm"> <i
											class="ri-folder-video-line"></i> Trailer
										</a>
									</div>
								</div>
								<h4 class="fw-bold text-dark">${phim.tenPhim}</h4>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="w-100 bg-dark-subtle my-5" style="height: 10px"></div>

	<div class="container">
		<h4
			class="text-dark border-4 border-start border-dark px-2 fw-bold mb-4">
			Tin khuyến mãi</h4>

		<!-- Content khuyến mãi  -->
		<div>
			<div id="carouselPromotion" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active" data-bs-interval="10000">
						<div class="row">
							<c:forEach var="khuyenMai" items="${khuyenMais}">
								<div class="col-6 col-lg-3">
									<a class='text-decoration-none' href="#"> <img
										src="/cinemastar/images/${khuyenMai.hinhAnh}" alt=""
										class="rounded-3 mb-2"
										style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />
										<h4 class="text-dark fw-bold fs-5">${khuyenMai.tenKhuyenMai}</h4>
									</a>
								</div>
							</c:forEach>
						</div>
					</div>

				</div>
				<button class="carousel-control-prev bg-opacity-50 bg-black p-2"
					type="button" data-bs-target="#carouselPromotion"
					data-bs-slide="prev"
					style="height: fit-content; width: fit-content; top: 50%; transform: translateY(-50%); left: 10px;">
					<i class="ri-arrow-left-s-line fs-3"></i>
				</button>
				<button class="carousel-control-next bg-opacity-50 bg-black p-2"
					type="button" data-bs-target="#carouselPromotion"
					data-bs-slide="next"
					style="height: fit-content; width: fit-content; top: 50%; transform: translateY(-50%); right: 10px;">
					<i class="ri-arrow-right-s-line fs-3"></i>
				</button>
			</div>
		</div>
	</div>
</main>