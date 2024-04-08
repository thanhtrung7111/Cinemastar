
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="url" value="/"></c:url>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="col-12 col-lg-8 col-xl-8">
	<div class="accordion d-flex flex-column row-gap-3"
		id="accordionExample">
		<div class="accordion-item rounded-3">
			<h2 class="accordion-header">
				<div
					class="fw-bold fs-5 p-2 px-3 text-dark w-100 border-bottom d-flex justify-content-between align-items-center"
					type="button" data-bs-toggle="collapse"
					data-bs-target="#collapseThree" aria-expanded="true"
					aria-controls="collapseThree">
					<span>Chọn suất</span> <i class="ri-arrow-down-s-fill"></i>
				</div>
			</h2>
			<div id="collapseThree" class="accordion-collapse collapse show"
				data-bs-parent="#accordionExample">
				<div class="accordion-body d-flex flex-column row-gap-3">
					<c:forEach var="rapPhim" items="${rapPhims}">
						<div class="border rounded-3 p-3">
							<h4 class="text-dark fs-6 fw-bold">${rapPhim.tenRapPhim}</h4>
							<div class="d-flex gap-3 flex-wrap">
								<c:forEach var="phongPhim" items="${rapPhim.phongPhims}">
									<c:forEach var="suatChieu" items="${phongPhim.suatChieus}">
										<c:if
											test="${sessionScope.phim.maPhim == suatChieu.phim.maPhim}">
											<a href="${url}user/chonghe"
												class="border border-1 px-3 py-1 rounded-2 text-dark text-decoration-none">
												<fmt:formatDate type="time"
													value="${suatChieu.thoiGianChieu}" />

											</a>
										</c:if>
									</c:forEach>
								</c:forEach>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>
