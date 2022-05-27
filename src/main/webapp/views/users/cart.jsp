<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>

<div
	style="width: 100%; background-image: url(image/background/cart.jpg); background-size: cover;">
	<div class="container p-3 text-white"
		style="width: 100%; min-height: 440px;">
		<div class="text-center">
			<h1 style="font-weight: bold;">Giỏ Hàng Của Bạn</h1>
		</div>
		<div class="row mt-4">
			<div class="col-8">
				<table class="table table-borderless text-white">
					<thead>
						<tr>
							<th scope="col"><input type="checkbox"></th>
							<th></th>
							<th scope="col">Tên Sản Phẩm</th>
							<th scope="col">Giá</th>
							<th scope="col">Số lượng</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox"></td>
							<td><img src="image/logo/coffe logo.png" alt=""
								style="width: 100px;"></td>
							<td>Sản phẩm 123</td>
							<td>20000</td>
							<td><input type="number" value="1" min="1"></td>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td><img src="image/logo/coffe logo.png" alt=""
								style="width: 100px;"></td>
							<td>Sản phẩm 123</td>
							<td>20000</td>
							<td><input type="number" value="1" min="1"></td>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td><img src="image/logo/coffe logo.png" alt=""
								style="width: 100px;"></td>
							<td>Sản phẩm 123</td>
							<td>20000</td>
							<td><input type="number" value="1" min="1"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-4 mt-4">
				<form action="">
					<label for="">Địa điểm</label> <input type="text"
						class="form-control" placeholder="Địa chỉ nhận hàng">
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
				</form>

			</div>
		</div>
	</div>

</div>