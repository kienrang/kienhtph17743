<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class=""
	style="min-height: 600px; background-image: url(image/background/adminIndex.jpg); background-size: cover;">
	<div class="container p-0 mt-2 text-white" style="">
		<div class="row">
			<div class="col-8">
				<p>Danh sách hóa đơn</p>
				<table class="table text-white">
					<thead class="table-dark">
						<tr>
							<th>Mã hóa đơn</th>
							<th>Giá</th>
							<th>Thời gian</th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<tbody>
						 <c:forEach items="${ ls }" var="o">
							<tr>
								<td>${o.id }</td>
								<td>${o.price }</td>
								<td>${ o.create_date }</td>
								<td><a href="/kienhtph17743/history_detail/${o.id}" class="btn btn-warning">Xem chi tiết</a></td>
							</tr>
						</c:forEach> 
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
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ lsoddl }" var="od">
							<tr>
								<td>${od.products.name}</td>
								<td>${od.price}</td>
								<td>${od.quantity}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>