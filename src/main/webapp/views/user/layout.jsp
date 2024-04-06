<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Jura:wght@300..700&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/remixicon/4.2.0/remixicon.min.css" />
<title>Insert title here</title>
<link rel="stylesheet" href="../bootstrap-5.3.3-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../bootstrap-5.3.3-dist/css/style.css" />
</head>
<body style="height: 100vh" class="d-flex flex-column">

	<div>
		<div class="d-flex">
			<div style="width: 300px"
				class="bg-white vh-100 d-flex flex-column shadow-sm">
				<div
					class="d-flex py-4 align-items-center justify-content-center mb-5 fw-bolder border-bottom mx-5">
					<span class="fw-bolder fs-3 text-first">Cinema</span>
					<div class="d-flex align-items-start">
						<span class="fw-medium text-danger text-sm">Star</span> <i
							class="ri-star-fill text-xs text-third"></i>
					</div>
				</div>

				<jsp:include page="/views/admin/component/sidebar.jsp"></jsp:include>
				

				<div class="flex-fill d-flex flex-column justify-content-end">
					<a href=""
						class="d-block py-2 px-3 info-item text-dark text-sm text-decoration-none"><i
						class="ri-settings-2-line"></i> Cài đặt</a> <a href=""
						class="d-block py-2 px-3 info-item text-dark text-sm text-decoration-none"><i
						class="ri-logout-box-line"></i> Đăng xuất</a>
				</div>
			</div>

			<div class="flex-fill">
				<jsp:include page="/views/admin/component/navbar.jsp"></jsp:include>
				<jsp:include page="${view}"></jsp:include>
			</div>
		</div>
		<div></div>
	</div>
	<script type="text/javascript"
		src="../bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="../bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>