<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- banner  -->
<div class="position-relative">
	<div id="carouselExampleInterval" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="10000">
				<img
					src="https://cdn.galaxycine.vn/media/2024/4/1/god-x-kong-2048_1711942313253.jpg"
					class="d-block w-100" alt="..." />
			</div>
			<div class="carousel-item" data-bs-interval="2000">
				<img
					src="https://cdn.galaxycine.vn/media/2024/4/2/mobile-suit-gundam-seed-freedom-3_1712027621954.jpg"
					class="d-block w-100" alt="..." />
			</div>
			<div class="carousel-item">
				<img
					src="https://cdn.galaxycine.vn/media/2024/4/2/omen-2048_1712041036757.jpg"
					class="d-block w-100" alt="..." />
			</div>
			<div class="carousel-item">
				<img
					src="https://cdn.galaxycine.vn/media/2024/2/8/2048x682_1707364876796.jpg"
					class="d-block w-100" alt="..." />
			</div>
			<div class="carousel-item">
				<img
					src="https://cdn.galaxycine.vn/media/2024/4/2/the-elite-of-devils-2_1712051609192.jpg"
					class="d-block w-100" alt="..." />
			</div>
		</div>
		<button class="carousel-control-prev bg-opacity-50 bg-black p-2"
			type="button" data-bs-target="#carouselExampleInterval"
			data-bs-slide="prev"
			style="height: fit-content; width: fit-content; top: 50%; transform: translateY(-50%); left: 70px;">
			<i class="ri-arrow-left-s-line fs-3"></i>
		</button>
		<button class="carousel-control-next bg-opacity-50 bg-black p-2"
			type="button" data-bs-target="#carouselExampleInterval"
			data-bs-slide="next"
			style="height: fit-content; width: fit-content; top: 50%; transform: translateY(-50%); right: 70px;">
			<i class="ri-arrow-right-s-line fs-3"></i>
		</button>
	</div>

	<div
		class="d-lg-flex d-none column-gap-2 px-5 py-4 position-absolute bg-white shadow-sm rounded-2"
		style="width: 800px; bottom: -5%; right: 50%; transform: translateX(50%);">
		<select
			class="form-select form-select-lg text-sm focus-ring focus-ring-info"
			aria-label="Default select example">
			<option selected>Chọn phim</option>
			<option value="1">One</option>
			<option value="2">Two</option>
			<option value="3">Three</option>
		</select> <select
			class="form-select form-select-lg text-sm focus-ring focus-ring-info"
			aria-label="Default select example">
			<option selected>Chọn ngày</option>
			<option value="1">One</option>
			<option value="2">Two</option>
			<option value="3">Three</option>
		</select> <select
			class="form-select form-select-lg text-sm focus-ring focus-ring-info"
			aria-label="Default select example">
			<option selected>Chọn suất</option>
			<option value="1">One</option>
			<option value="2">Two</option>
			<option value="3">Three</option>
		</select>
		<button class="bg-first w-100 text-white border-0 rounded-1">
			Mua vé</button>
	</div>
</div>
<!-- main  -->
<main class="mt-5">
	<!-- PHIM CHIẾU TRONG TUẦN  -->
	<div class="container">
		<!-- Phim chiếu trong tuần  -->
		<h4
			class="text-dark border-4 border-start border-dark px-2 fw-bold mb-4">
			Phim chiếu trong tuần</h4>

		<div class="row g-4">
			<!-- PHIM ITEM  -->
			<c:forEach var="phim" items="${phims}">
				<div class="col-6 col-md-4 col-xl-3 product-item"
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
					<h4 class="fw-bold">${phim.tenPhim}</h4>
				</div>
			</c:forEach>

		</div>

		<a href="./danhsachphim.html"
			class="border-first border text-first bg-white text-sm px-4 py-2 d-block mx-auto mt-5 text-decoration-none"
			style="width: fit-content"> Xem thêm </a>
	</div>

	<div class="w-100 bg-dark-subtle my-5" style="height: 10px"></div>

	<!-- GÓC ĐIẸN ẢNH  -->
	<div class="container">
		<h4
			class="text-dark border-4 border-start border-dark px-2 fw-bold mb-4">
			Góc điện ảnh</h4>
		<div class="row g-4 justify-content-start">
			<div class="col-12 col-md-7 col-xl-8">
				<div class="mb-2 overflow-hidden rounded-3"
					style="width: 100%; height: 400px">
					<img src="./assets/img/dienanh1.jpeg" alt=""
						style="object-fit: cover; object-position: center; width: 100%; height: 100%;"
						class="scale-img" />
				</div>
				<div class="d-flex column-gap-3 mb-2">
					<div class="d-flex align-items-center column-gap-1 text-first">
						<i class="ri-thumb-up-fill"></i> 25
					</div>
					<div class="d-flex align-items-center column-gap-1 text-first">
						<i class="ri-eye-fill"></i> 200
					</div>
				</div>
				<h4 class="fs-5">[Review] Exhuma Quật Mộ Trùng Ma: Bom Tấn Hàn
					Quốc Đáng Xem Nhất 2024?</h4>
			</div>
			<div class="col-10 col-md-5 col-xl-4 d-flex flex-column row-gap-3">
				<div class="row">
					<div class="col-5 p-0 rounded-3 overflow-hidden">
						<img src="./assets/img/dieananh2.jpg" alt=""
							style="width: 100%; height: 100px; object-fit: cover; object-position: center;"
							class="scale-img" />
					</div>
					<div class="col-7">
						<h4 class="fs-6 text">[Review] Kungfu Panda 4</h4>
						<div class="d-flex column-gap-3 mb-2">
							<div class="d-flex align-items-center column-gap-1 text-first">
								<i class="ri-thumb-up-fill"></i> 25
							</div>
							<div class="d-flex align-items-center column-gap-1 text-first">
								<i class="ri-eye-fill"></i> 200
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-5 rounded-3 overflow-hidden p-0">
						<img src="./assets/img/dienanh3.jpg" alt=""
							style="width: 100%; height: 100px; object-fit: cover; object-position: center;"
							class="scale-img" />
					</div>
					<div class="col-7">
						<h4 class="fs-6 text">[Review] Hành tinh cát có hay như lời
							đồn?</h4>
						<div class="d-flex column-gap-3 mb-2">
							<div class="d-flex align-items-center column-gap-1 text-first">
								<i class="ri-thumb-up-fill"></i> 25
							</div>
							<div class="d-flex align-items-center column-gap-1 text-first">
								<i class="ri-eye-fill"></i> 200
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-5 rounded-3 p-0 overflow-hidden">
						<img src="./assets/img/dienanh4.jpg" alt=""
							style="width: 100%; height: 100px; object-fit: cover; object-position: center;"
							class="scale-img" />
					</div>
					<div class="col-7">
						<h4 class="fs-6 text">[Review] phim hoạt hình hot nhất hiện
							nay?</h4>
						<div class="d-flex column-gap-3 mb-2">
							<div class="d-flex align-items-center column-gap-1 text-first">
								<i class="ri-thumb-up-fill"></i> 25
							</div>
							<div class="d-flex align-items-center column-gap-1 text-first">
								<i class="ri-eye-fill"></i> 200
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-5 rounded-3 overflow-hidden p-0">
						<img src="./assets/img/imgphim4.jpg" alt=""
							style="width: 100%; height: 100px; object-fit: cover; object-position: center;"
							class="scale-img" />
					</div>
					<div class="col-7">
						<h4 class="fs-6 text">[Review] Quý cô thừa kế 2</h4>
						<div class="d-flex column-gap-3 mb-2">
							<div class="d-flex align-items-center column-gap-1 text-first">
								<i class="ri-thumb-up-fill"></i> 25
							</div>
							<div class="d-flex align-items-center column-gap-1 text-first">
								<i class="ri-eye-fill"></i> 200
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<button
			class="border-first border text-first bg-white text-sm px-4 py-2 d-block mx-auto mt-5">
			Xem thêm</button>
	</div>

	<div class="w-100 bg-dark-subtle my-5" style="height: 10px"></div>

	<!-- Tin khuyến mãi  -->
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
							<div class="col-6 col-lg-3">
								<img src="./assets/img/km2.jpg" alt="" class="rounded-3 mb-2"
									style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />
								<h4 class="text-dark fw-bold fs-5">Cinema Star ưu đải 50%
									bắp nước cho thành viên</h4>
							</div>
							<div class="col-6 col-lg-3">
								<img src="./assets/img/km2.jpg" alt="" class="rounded-3 mb-2"
									style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />
								<h4 class="text-dark fw-bold fs-5">Cinema Star ưu đải 50%
									bắp nước cho thành viên</h4>
							</div>
							<div class="col-6 col-lg-3">
								<img src="./assets/img/km2.jpg" alt="" class="rounded-3 mb-2"
									style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />
								<h4 class="text-dark fw-bold fs-5">Cinema Star ưu đải 50%
									bắp nước cho thành viên</h4>
							</div>
							<div class="col-6 col-lg-3">
								<img src="./assets/img/km2.jpg" alt="" class="rounded-3 mb-2"
									style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />
								<h4 class="text-dark fw-bold fs-5">Cinema Star ưu đải 50%
									bắp nước cho thành viên</h4>
							</div>
						</div>
					</div>
					<div class="carousel-item" data-bs-interval="2000">
						<div class="row">
							<div class="col-6 col-lg-3">
								<img src="./assets/img/km1.jpg" alt="" class="rounded-3 mb-2"
									style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />
								<h4 class="text-dark fw-bold fs-5">Cinema Star ưu đải 50%
									bắp nước cho thành viên</h4>
							</div>
							<div class="col-6 col-lg-3">
								<img src="./assets/img/km1.jpg" alt="" class="rounded-3 mb-2"
									style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />
								<h4 class="text-dark fw-bold fs-5">Cinema Star ưu đải 50%
									bắp nước cho thành viên</h4>
							</div>
							<div class="col-6 col-lg-3">
								<img src="./assets/img/km1.jpg" alt="" class="rounded-3 mb-2"
									style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />
								<h4 class="text-dark fw-bold fs-5">Cinema Star ưu đải 50%
									bắp nước cho thành viên</h4>
							</div>
							<div class="col-6 col-lg-3">
								<img src="./assets/img/km1.jpg" alt="" class="rounded-3 mb-2"
									style="height: 300px; width: 100%; object-fit: cover; object-position: center;" />
								<h4 class="text-dark fw-bold fs-5">Cinema Star ưu đải 50%
									bắp nước cho thành viên</h4>
							</div>
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