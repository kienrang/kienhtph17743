<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class=""
	style="min-height: 600px; background-image: url(../image/background/adminIndex.jpg); background-size: cover;">
	<div class="container p-0 mt-2 text-white" style="width: 50%;">
		<div class="row">
			<div class="mt-2">
				<p>Tạo hóa đơn</p>
				<form:form action="/kienhtph17743/admin/store_order" method="Post"
					modelAttribute="order">
					<div class="mt-2">
						<form:input path="email" type="text" class="form-control"
							placeholder="Email" />
					</div>
					<div class="mt-2">
						<form:input path="address" type="text" class="form-control"
							placeholder="Nhập địa chỉ" />
					</div>
					<div class="mt-2">
						<p>
							<a class="btn btn-warning" data-bs-toggle="collapse"
								href="#multiCollapseExample1" role="button"
								aria-expanded="false" aria-controls="multiCollapseExample1">Chọn
								sản phẩm</a>
						</p>
						<div class="row text-dark">
							<div class="col">
								<div class="collapse multi-collapse" id="multiCollapseExample1">
									<div class="card card-body">
										<p>Danh sách sản phẩm</p>
										<table class="table text-dark">
											<thead class="table-dark">
												<tr>
													<th></th>
													<th>Hình ảnh</th>
													<th>Tên sản phẩm</th>
													<th>Giá(VNĐ)</th>
													<th>Số lượng</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${lspro }" var="p">
													<tr>
														<td><form:checkbox path="product_id" value="${p.id}" /></td>
														<td>${p.image }</td>
														<td>${p.name }</td>
														<td>${p.price}</td>
														<td><form:input type="number" path="quantity" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="mt-2">
						<button class="btn btn-info" style="width: 50%; margin-left: 25%;">Tạo</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>