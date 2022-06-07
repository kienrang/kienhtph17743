<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container mt-2"
	style="width: 50%; margin-left: 25%; min-height: 460px;">
	<form:form action="/kienhtph17743/buy/${pro.id}" style="width: 100%;" modelAttribute="order" method="post">
		<form:input type="text" class="form-control" placeholder="Địa chỉ" path="address" />
		<div class="mt-2">
			<table class="table table-dark">
				<tbody>
					<tr>
						<th scope="row">${ pro.image }</th>
						<td>${ pro.name }</td>
						<td>${ pro.price } VNĐ</td>
						<td><form:input type="number" min="1" value="1" path="quantity"/></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div style="width: 100%;">
			<button class="btn btn-outline-primary"
				style="width: 50%; margin-left: 25%;">Đặt hàng</button>
		</div>
	</form:form>
</div>