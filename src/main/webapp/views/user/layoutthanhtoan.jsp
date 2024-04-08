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
<link rel="stylesheet"
	href="../bootstrap-5.3.3-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="../bootstrap-5.3.3-dist/css/style.css" />
</head>
<body>

	<jsp:include page="/views/user/component/header.jsp"></jsp:include>

	<main>
		<jsp:include page="/views/user/component/stepthanhtoan.jsp"></jsp:include>

		<div class="container mt-4">
			<div class="row g-4">
				<jsp:include page="${view}"></jsp:include>
				<jsp:include page="/views/user/component/thongtinve.jsp"></jsp:include>
			</div>
		</div>
	</main>

	<jsp:include page="/views/user/component/footer.jsp"></jsp:include>
	<script type="text/javascript"
		src=../bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="../bootstrap-5.3.3-dist/js/main.js"></script>
</body>
</html>