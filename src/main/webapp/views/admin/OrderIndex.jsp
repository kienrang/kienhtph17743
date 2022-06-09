<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="mt-0" style="min-height: 600px; background-image: url(../image/background/adminIndex.jpg); background-size: cover;">
	<div class="container p-0 mt-2 text-white" style="">
		<div class="">
			<a href="/kienhtph17743/admin/create_order"
				class="btn btn-light ms-5 mt-3 mb-2">Tạo hóa đơn</a>
		</div>
		<div class="row">
			<div class="col-8">
				<p>Danh sách các đơn hàng</p>
				<table class="table text-white">
					<thead class="table-dark">
						<tr>
							<th>Mã hóa đơn</th>
							<th>Tên Khách Hàng</th>
							<th>Địa chỉ</th>
							<th>Giá</th>
							<th colspan="3"></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${ empty ls }">
							<div class="alert alert-warning" role="alert">
								${sessionScope.trong}</div>
						</c:if>
						<c:if test="${!empty ls }">
							<c:forEach items="${ ls }" var="o">
								<tr>
									<td>${o.id }</td>
									<td>${o.acc.fullname }</td>
									<td>${o.address}</td>
									<td>${o.price}</td>
									<td><a href="/kienhtph17743/admin/hdct/${o.id}"
										class="btn btn-warning">Xem chi tiết</a></td>
									<td><a href="/kienhtph17743/admin/confirm_order/${o.id}"
										class="btn btn-secondary">Xác nhận</a></td>
									<td><a href="/kienhtph17743/admin/cancel_order/${o.id}" class="btn btn-danger">Hủy đơn</a></td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
			<div class="col-4">
				<p>Danh sách sản phẩm</p>
				<table class="table text-white">
					<thead class="table-dark">
						<tr>
							<th>Tên sản phẩm</th>
							<th>Giá(VNĐ)</th>
							<th>Số lượng</th>
							<td>Tổng</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ lsoddl }" var="od">
							<tr>
								<td>${od.products.name}</td>
								<td>${od.products.price}</td>
								<td>${od.quantity}</td>
								<td>${od.price}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>