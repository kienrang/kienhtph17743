<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="container p-0 mt-2" style="min-height: 460px;">
	<div class="row">
		<c:forEach items="${ ls }" var="pro">
			<div class="col-xs-12 col-sm-4 col-md-2 ms-5">
			<a href="/kienhtph17743/product/${pro.id}" style="text-decoration: none; color: #303030;">
				<div class="card" style="width: 14rem;">
					<img src="image/products/${pro.image}" class="card-img-top"
						alt="...">
					<div class="card-body">
						<h5 class="card-title">${ pro.name }</h5>
						<p class="card-text">${pro.price }</p>
						<a href="/kienhtph17743/buynow/${pro.id}" class="btn btn-outline-secondary form-control mt-2">Mua Ngay</a>
					</div>
				</div>
			</a>
		</div>
		</c:forEach>
	</div>
</div>