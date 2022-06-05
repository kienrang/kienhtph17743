<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>	

<div
	style="width: 100%; background-image: url(image/background/cart.jpg); background-size: cover;">
	<div class="container p-3 text-white"
		style="width: 100%; min-height: 440px;">
		<div class="text-center">
			<h1 style="font-weight: bold;">Giỏ Hàng Của Bạn</h1>
		</div>
		<div class="row mt-4">
			<form:form action="" class="d-flex" modelAttribute="order">
				<div class="col-8">
					<table class="table table-borderless text-white">
						<thead>
							<tr>
								<th scope="col"><input type="checkbox" onclick="toggle(this)"></th>
								<th></th>
								<th scope="col">Tên Sản Phẩm</th>
								<th scope="col">Giá</th>
								<th scope="col">Số lượng</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:checkbox path="product_id" value="1"/></td>
								<td><img src="image/logo/coffe logo.png" alt=""
									style="width: 100px;"></td>
								<td>Sản phẩm 123</td>
								<td>20000</td>
								<td><form:input type="number" path="quantity" /></td>
							</tr>

						</tbody>
					</table>
				</div>
				<div class="col-4 mt-4">
					<label for="">Địa điểm</label> <form:input type="text"
						class="form-control" placeholder="Địa chỉ nhận hàng" path="address"/>
					<p style="font-size: 20px;" class="mt-2">Thông tin đơn hàng</p>
					<table class="table table-borderless text-white">
						<tr>
							<th scope="row">Tạm tính(1 sản phẩm)</th>
							<td>giá đ</td>
						</tr>
						<tr>
							<th scope="row">Phí giao hàng</th>
							<td>giá đ</td>
						</tr>
					</table>
					<button class="btn form-control" style="background-color: #E0D8B0;">Đặt
						Hàng</button>
				</div>
			</form:form>
		</div>
	</div>
</div>
 <script>
        function toggle(source) {
            checkboxes = document.getElementsByName('product_id');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                checkboxes[i].checked = source.checked;
            }
        }
</script>