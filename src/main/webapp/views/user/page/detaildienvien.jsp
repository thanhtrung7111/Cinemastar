<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- main  -->
<div class="mt-4">
	<!-- PHIM CHIẾU TRONG TUẦN  -->
	<div class="container">
		<!-- Phim chiếu trong tuần  -->
		<h4 class="text-dark border-dark px-2 fw-medium fs-5 mb-4">Trang
			chủ / ${dienVien.vaiTro.tenVaiTro} / ${dienVien.tenDV_DD}</h4>
		<div class="row gx-5">
			<div class="col-12 col-lg-8 col-xl-9">
				<div class="d-flex flex-column row-gap-3">
					<!-- Main phim  -->
					<div class="row">
						<div class="col-6 col-md-5 col-xl-4">
							<img src="/cinemastar/images/${dienVien.hinhAnh}" alt=""
								style="height: 400px; width: 100%; object-fit: cover; object-position: center;" />
						</div>
						<div class="col-6 col-md-7 col-xl-8 d-flex flex-column row-gap-1">
							<h4 class="fw-bold fs-3 mb-0">${dienVien.tenDV_DD}</h4>
							<div class="d-flex column-gap-3 mb-1 text-sm">
								<div class="d-flex align-items-center column-gap-1 text-first">
									<i class="ri-eye-fill"></i> ${dienVien.luotXem}
								</div>
							</div>
							<p class="text-light mb-1">${dienVien.mota}</p>
							<div class="d-flex flex-column row-gap-2">
								<div class="text-dark fw-bold text-sm">
									<span class="text-light fw-light">Ngày sinh: </span>
									${dienVien.ngaySinh}
								</div>
								<div class="text-dark fw-bold text-sm">
									<span class="text-light fw-light">Chiều cao: </span>
									${dienVien.chieuCao}cm
								</div>
								<div class="text-dark fw-bold text-sm">
									<span class="text-light fw-light">Quốc tịch: </span>
									${dienVien.quocGia.tenQuocGia}
								</div>
							</div>
						</div>
					</div>


					<!-- Diễn viên  -->
					<div>
						<h4
							class="text-dark border-4 fs-5 border-start border-dark px-2 fw-bold mb-3">
							Phim đã tham gia</h4>
						<div class="row g-3">
							<c:forEach var="phim" items="${phims}">
								<div class="col-6 d-flex align-items-start column-gap-2">
									<img src="/cinemastar/images/${phim.hinhAnh}" alt=""
										style="width: 90px; height: 100px; object-fit: cover; object-position: center;" />
									<div class="d-flex flex-column">
										<span class="fs-6 fw-medium text-dark">${phim.tenPhim}</span>
										<span class="fs-6 fw-medium text-dark">${phim.namSanXuat}</span>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<!-- Tiểu sử -->
					<div>
						<h4
							class="text-dark border-4 fs-5 border-start border-dark px-2 fw-bold mb-3">
							Tiểu sử</h4>
						<p class="text-light"> Không chỉ có sắc đẹp, Margot còn có một
							trí tuệ thông minh và một tâm hồn mạnh mẽ, nàng không vội dùng
							nhan sắc để lao vào đóng phim vô tội vạ và mong tìm kiếm sự nổi
							tiếng vốn khó khăn gấp bội với những người không phải công dân Mỹ
							tại Hollywood. Nàng dành ba năm thời gian tại Ramsay Street, xuất
							hiện trong 329 tập Neighbor mà chẳng mấy quan tâm đến việc đánh
							bóng sự nghiệp. Nàng chỉ học, tìm kiếm các mối quan hệ và tìm
							huấn luyện viên chuyên dụng để biến chất giọng Úc của mình thành
							giọng Mỹ. Sự đầu tư thông minh này đã giúp nàng có được vai diễn
							đắt giá – cô vợ nóng bỏng của tài tử Leonardo Dicaprio trong bộ
							phim hay dành cho Oscar – The Wolf Of Wall Street chỉ sau một
							thời gian ngắn đến Hollywood. Và thế là sau một đêm, từ một cô
							gái vô danh, chỉ xuất hiện một vai nhỏ trong About Time, nàng trở
							nên nổi tiếng và lọt vào mắt xanh hàng sa số đạo diễn và nhà sản
							xuất Hollywood đang tìm kiếm một cô đào nóng bỏng với mức giá
							“vừa phải”. Chưa hết, Naomi Lapaglia cũng mang về cho nàng giải
							Nữ diễn viên mới xuất sắc nhất tại giải Empire 2014. Năm 2014 gọi
							tên Margot Robbie, nàng tiếp tục lọt vào top 100 Phụ nữ hấp dẫn
							nhất hành tinh của tạp chí Maxim danh giá, xếp trên cả người đồng
							hương là siêu mẫu Úc Miranda Kerr và được vinh danh là Nữ diễn
							viên gợi cảm nhất trong danh sách What Is Sexy của Victoria ‘s
							Secret. Margot lại tiếp tục một loạt vai chính trong năm 2015,
							xuất hiện bên những ngôi sao lớn như Will Smith, Chris Pine. Tuy
							nhiên, sự đầu tư vào tâm lý nhân vật nhiều hơn ngoại hình của
							nàng đáng tiếc không gây được nhiều ấn tượng. May mắn thay, tên
							tuổi nàng lại bùng nổ lần nữa khi trở thành Harley Quinn trong
							bom tấn 2016 của DC Comic - Suicide Squad. Việc xuất hiện cùng
							một trong những ngôi sao da màu nổi tiếng nhất – Will Smith và
							siêu mẫu Cara Dalevinge không làm Margot bị che lấp. Ngược lại
							với màn hóa thân thành cô nàng Harley “tâm thần” như từ trong
							truyện bước ra, nàng khiến Internet bùng nổ với hàng loạt comment
							ngợi khen. Có lẽ catse của Margot chẳng là gì so với bậc đàn anh
							Will Smith nhưng xét về chiếm spotlight trên Internet, Harley
							Quinn thắng Deadshot: 1-0. Trước đó, trong lúc chờ đợi một Harley
							đầy cá tính, Margot cho những ai chờ đợi nàng thưởng thức “bữa ăn
							nhẹ” - một nàng Jane sexy nhất, chủ động nhất, xứng đáng là “bạn
							đồng hành” chứ không phải “gánh nặng” của chúa tể rừng xanh trong
							The Legend Of Tarzan.</p>
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
							<div class="product-item col-sm-6 col-md-4 col-lg-12 col-6"
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
</div>