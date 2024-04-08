<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- main  -->
<main class="mt-4">
	<!-- PHIM CHIẾU TRONG TUẦN  -->
	<div class="container">
		<!-- Phim chiếu trong tuần  -->
		<h4 class="text-dark border-dark px-2 fw-medium fs-5 mb-4">Trang
			chủ / Phim /Kungfu Panda 4</h4>
		<div class="row gx-5">
			<div class="col-12 col-lg-8 col-xl-9">
				<!-- Main phim  -->
				<div class="d-flex flex-column row-gap-5">
					<div class="row g-3">
						<div class="col-12 col-md-4">
							<img src="/cinemastar/images/${phim.hinhAnh}" alt=""
								style="height: 400px; width: 100%; object-fit: cover; object-position: center;" />
						</div>
						<div class="col-12 col-md-8 d-flex flex-column row-gap-1">
							<h4 class="fw-bold fs-3 mb-0">${phim.tenPhim}</h4>
							<div class="d-flex align-items-center column-gap-3">
								<div class="d-flex align-items-center column-gap-1">
									<i class="ri-time-line text-second"></i> <span
										class="text-dark text-sm fw-bold">${phim.thoiLuong}
										phút</span>
								</div>
								<div class="d-flex align-items-center column-gap-1">
									<i class="ri-calendar-2-line text-second"></i> <span
										class="text-dark fw-bold text-sm">${phim.namSanXuat}</span>
								</div>
							</div>
							<div class="d-flex column-gap-3 mb-1 text-sm">
								<div class="d-flex align-items-center column-gap-1 text-first">
									<i class="ri-thumb-up-fill"></i> 25
								</div>
								<div class="d-flex align-items-center column-gap-1 text-first">
									<i class="ri-eye-fill"></i> ${phim.luotXem}
								</div>
							</div>
							<p class="text-light mb-1">${phim.moTa}</p>
							<div class="d-flex flex-column row-gap-2">
								<div class="text-dark fw-bold text-sm">
									<span class="text-light fw-light">Diễn viên: </span>
									<c:forEach var="dienVien" items="${dienViens}">
										<c:if test="${dienVien.vaiTro.tenVaiTro == 'Diễn Viên'}">${dienVien.tenDV_DD}</c:if>
									</c:forEach>
								</div>
								<div class="text-dark fw-bold text-sm">
									<span class="text-light fw-light">Nhà sản xuất: </span>
									<c:forEach var="dienVien" items="${dienViens}">
										<c:if test="${dienVien.vaiTro.tenVaiTro == 'Đạo Diễn'}">${dienVien.tenDV_DD}</c:if>
									</c:forEach>
								</div>
								<div class="text-dark fw-bold text-sm">
									<span class="text-light fw-light">Thể loại: </span> Hành động,
									phiêu lưu
								</div>
								<div class="text-dark fw-bold text-sm">
									<span class="text-light fw-light">Đạo diễn: </span>
									<c:forEach var="dienVien" items="${dienViens}">
										<c:if test="${dienVien.vaiTro.tenVaiTro == 'Diễn Viên'}">${dienVien.tenDV_DD}</c:if>
									</c:forEach>
								</div>
								<div class="text-dark fw-bold text-sm">
									<span class="text-light fw-light">Quốc gia: </span>${phim.quocGia.tenQuocGia}
								</div>
							</div>
						</div>
					</div>

					<!-- NỘi dung phim  -->
					<div>
						<h4
							class="text-dark border-4 fs-5 border-start border-dark px-2 fw-bold mb-3">
							Nội dung phim</h4>
						<p class="text-light mb-0">Điều khán giả quan tâm nhất hiện
							nay chính là ai sẽ còn sống và ai sẽ ra đi khi Avengers: Endgame
							kết thúc. Captain America là người có khả năng ra đi cao nhất khi
							Chris Evans đã tuyên bố từ bỏ chiếc áo Đại Úy Mỹ. Iron Man Tony
							Stark- người mở đầu của vũ trụ điện ảnh Marvel cũng có khả năng
							“bay màu” tương tự. Thor sau tội lỗi “không nhắm vào đầu” cũng
							thuộc danh sách nguy hiểm. Những người duy nhất chắc chắn còn
							sống sau Avengers: Hồi Kết là Nick Fury, Maria Hill và cậu bé
							Người Nhện Peter Parker. Ngoài ra, vai trò của chị Đại Captain
							Marvel với sức mạnh khủng khiếptrong câu chuyện này là gì? Câu
							trả lời sẽ có trong Avengers: Endgame. Là siêu phẩm được trông
							đợi nhất 2019, Avengers: Endgame đã khiến toàn cầu xôn xao khi
							tung trailer vào 07.12.2018. Chỉ trong vòng 24 giờ, trailer nhận
							được gần 300 triệu lượt xem và trở thành trailer có lượt xem cao
							nhất mọi thời đại. Trailer thứ hai cũng phá đảo Internet và chỉ
							chịu thua trailer trước. Poster Avengers: Endgame cũng được hưởng
							ứng mạnh mẽ, khiến cả thế giới phát cuồng. Gần như chắc chắn,
							Avengers 2019 sẽ là bộ phim doanh thu cao nhất năm nay. Avengers:
							Endgame công chiếu 26.04.2019</p>
					</div>
					<!-- Hình ảnh  -->
					<!-- Diễn viên  -->
					<div>
						<h4
							class="text-dark border-4 fs-5 border-start border-dark px-2 fw-bold mb-3">
							Diễn viên</h4>
						<div class="row g-3">
							<c:forEach var="dienVien" items="${dienViens}">
								<c:if test="${dienVien.vaiTro.tenVaiTro == 'Diễn Viên'}">
									<div class="col-6 d-flex align-items-start column-gap-2">
										<img src="/cinemastar/images/${dienVien.hinhAnh}" alt=""
											style="width: 90px; height: 100px; object-fit: cover; object-position: center;" />
										<span class="fs-6 fw-medium text-dark">${dienVien.tenDV_DD}</span>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
					<!-- Diễn viên  -->
					<div>
						<h4
							class="text-dark border-4 fs-5 border-start border-dark px-2 fw-bold mb-3">
							Đánh giá</h4>
						<div class="d-flex flex-column row-gap-2">
							<div class="d-flex column-gap-3">
								<img src="./assets/img/dienvien1.jpg" class="rounded-circle"
									alt=""
									style="height: 70px; width: 70px; object-fit: cover; object-position: center;" />
								<div>
									<h5 class="text-dark fs-6 fw-bold mb-1">John Trần</h5>
									<p class="text-light text-xs mb-2 fst-italic">15/03/2024
										8:00AM</p>
									<p class="text-dark fs-6">"Phim hay với tình tiết gay cuốn"
									</p>
								</div>
							</div>
							<div class="d-flex column-gap-3">
								<img src="./assets/img/dienvien2.jpg" class="rounded-circle"
									alt=""
									style="height: 70px; width: 70px; object-fit: cover; object-position: center;" />
								<div>
									<h5 class="text-dark fs-6 fw-bold mb-1">Hendry Nguyễn</h5>
									<p class="text-light text-xs mb-2 fst-italic">15/03/2024
										8:00AM</p>
									<p class="text-dark fs-6">"Phim hay với tình tiết gay cuốn"
									</p>
								</div>
							</div>
						</div>
					</div>

					<!-- Bài viết liên quan  -->
				</div>
				<div>
					<h4
						class="text-dark border-4 fs-5 border-start border-dark px-2 fw-bold mb-3">
						Bài viết liên quan</h4>
					<div id="carouselPost" class="carousel slide"
						data-bs-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active" data-bs-interval="10000">
								<div class="row">
									<c:forEach var="khuyenMai" items="${khuyenMais}">
										<div class="col-6 col-lg-3">
											<a class='text-decoration-none' href="#"> <img
												src="/cinemastar/images/${khuyenMai.hinhAnh}" alt=""
												class="rounded-3 mb-2"
												style="height: 250px; width: 100%; object-fit: cover; object-position: center;" />
												<h4 class="text-dark fw-bold fs-6">${khuyenMai.tenKhuyenMai}</h4>
											</a>
										</div>
									</c:forEach>
								</div>
							</div>
							<div class="carousel-item" data-bs-interval="2000">
								<div class="row">
									<div class="col-6 col-xl-3">
										<img src="./assets/img/km1.jpg" alt="" class="rounded-3 mb-2"
											style="height: 200px; width: 100%; object-fit: cover; object-position: center;" />
										<h4 class="text-dark fw-bold fs-5">Cinema Star ưu đải 50%
											bắp nước cho thành viên</h4>
									</div>
									<div class="col-6 col-xl-3">
										<img src="./assets/img/km1.jpg" alt="" class="rounded-3 mb-2"
											style="height: 200px; width: 100%; object-fit: cover; object-position: center;" />
										<h4 class="text-dark fw-bold fs-5">Cinema Star ưu đải 50%
											bắp nước cho thành viên</h4>
									</div>
									<div class="col-6 col-xl-3">
										<img src="./assets/img/km1.jpg" alt="" class="rounded-3 mb-2"
											style="height: 200px; width: 100%; object-fit: cover; object-position: center;" />
										<h4 class="text-dark fw-bold fs-5">Cinema Star ưu đải 50%
											bắp nước cho thành viên</h4>
									</div>
									<div class="col-6 col-xl-3">
										<img src="./assets/img/km1.jpg" alt="" class="rounded-3 mb-2"
											style="height: 200px; width: 100%; object-fit: cover; object-position: center;" />
										<h4 class="text-dark fw-bold fs-5">Cinema Star ưu đải 50%
											bắp nước cho thành viên</h4>
									</div>
								</div>
							</div>
						</div>
						<button class="carousel-control-prev bg-opacity-50 bg-black p-2"
							type="button" data-bs-target="#carouselPost" data-bs-slide="prev"
							style="height: fit-content; width: fit-content; top: 50%; transform: translateY(-50%); left: 10px;">
							<i class="ri-arrow-left-s-line fs-3"></i>
						</button>
						<button class="carousel-control-next bg-opacity-50 bg-black p-2"
							type="button" data-bs-target="#carouselPost" data-bs-slide="next"
							style="height: fit-content; width: fit-content; top: 50%; transform: translateY(-50%); right: 10px;">
							<i class="ri-arrow-right-s-line fs-3"></i>
						</button>
					</div>
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
</main>