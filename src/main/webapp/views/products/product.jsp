<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<div class="container p-0 mt-2 mb-2"
	style="min-height: 460px; width: 100%; margin-left: 30%">
	<div>
		<h1>${ product.name }</h1>
	</div>
	<div class="d-flex">
		<div>
			<img src="../image/products/${product.image}" alt=""
				style="width: 30rem;">
		</div>
		<div class="ms-2">
			<p style="font-size: 25px;">${product.note }</p>
			<p style="font-size: 25px;">${product.price }</p>

			<div class="mt-5 d-flex">
				<form action="/kienhtph17743/index" method="post">
					<a href="" class="btn btn-outline-secondary">Mua Ngay</a>
				</form>
				<form action="/kienhtph17743/store_cart/${product.id}" method="post">
					<button class="btn btn-outline-warning">Thêm vào giỏ hàng</button>
				</form>
			</div>
		</div>
	</div>
</div>