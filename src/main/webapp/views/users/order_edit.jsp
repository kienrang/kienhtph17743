<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class=""
	style="min-height: 600px; background-image: url(../image/background/adminIndex.jpg); background-size: cover;">
	<div class="container p-0 mt-2 text-white" style="">
		<div class="row">
			<div class="col-7">
				<table class="table text-white">
					<thead class="table-dark">
						<tr>
							<th>Mã hóa đơn</th>
							<th>Địa chỉ</th>
							<th>Giá</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${o.id }</td>
							<td>${o.address}</td>
							<td>${o.price }</td>
						</tr>
					</tbody>
				</table>
								
				<div class="text-white">
				
					<form:form action="/kienhtph17743/orderupdate_user/${o.id}" modelAttribute="order">
						<div class="mt-2">
							<form:input path="address" type="text" class="form-control"
								placeholder="Địa chỉ" value="${o.address}" />
						</div>
						<div class="mt-2">
						<p>
							<a class="btn btn-warning" data-bs-toggle="collapse"
								href="#multiCollapseExample1" role="button"
								aria-expanded="false" aria-controls="multiCollapseExample1">Thêm
								sản phẩm</a>
						</p>
						<div class="row text-dark " style="width: 100%">
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
												<c:forEach items="${lspro}" var="p">
													<tr>
														<td><form:checkbox id="ck${p.id }" path="product_id"
																value="${p.id}" onclick="check('${p.id}')" /></td>
														<td>${p.image }</td>
														<td>${p.name }</td>
														<td>${p.price}</td>
														<td><form:input type="number" id="ip${p.id}"
																path="quantity" disabled="true" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="mt-2 mb-2">
						<button class="btn btn-info" style="width: 50%; margin-left: 25%;">Lưu thay đổi</button>
					</div>
					</form:form>
				</div>
			</div>
			<div class="col-5">
				<p>Danh sách sản phẩm</p>
				<table class="table text-white">
					<thead class="table-dark">
						<tr>
							<th>Tên sản phẩm</th>
							<th>Giá(VNĐ)</th>
							<th>Số lượng</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ lsoddl }" var="od">
							<tr>
								<td>${od.products.name}</td>
								<td>${od.products.price}</td>
								<form:form action="/kienhtph17743/updateorderdetails/${od.id}" method="post" modelAttribute="quantity">
									<td><form:input style="width: 70%" type="number" path="soluong" value="${od.quantity}"/>  </td>
								<!-- <td><a class="btn btn-danger">Xóa</a></td>  -->
								<td><button class="btn btn-warning">Cập nhật</button></td>
								</form:form>
							</tr >
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<script>
	function check(id) {
		a = document.getElementById('ck' + id);
		if (a.checked == true) {
			document.getElementById('ip' + id).removeAttribute('disabled');
		}
		if (a.checked == false) {
			document.getElementById('ip' + id).setAttribute('disabled', 'true');
		}
	}
</script>
