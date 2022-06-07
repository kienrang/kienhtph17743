<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div>
	<div class="pt-5"
		style="height: 500px; background-image: url(image/backgrounds/hinh-anh-ly-cafe-dep-2.jpg); background-size: cover; display: flex; justify-content: center;">


		<div class="pt-4"
			style="width: 20%; height: 250px; background-color: rgba(255, 255, 255, 0); border-radius: 20px;">
			<c:if test="${!empty sessionScope.error }">
				<div class="alert alert-warning" role="alert">
					${sessionScope.error}
					<c:remove var="error" scope="session" />
				</div>
			</c:if>
			<form:form action="/kienhtph17743/login" class="text-center"
				method="post" modelAttribute="acc">
				<form:input type="text" path="email" placeholder="Email"
					class="form-control mt-2 formstyle" />
				<form:input path="password" type="password" id=""
					placeholder="Mật khẩu" class="form-control mt-2 formstyle" />
				<button class=" btn btn-outline-primary mt-2 ps-5 pe-5">Đăng
					nhập</button>
				<hr>
			</form:form>
				<div class="text-center">
				<a href="/kienhtph17743/register">Tạo tài khoản</a>
				<br>
				<a href="/kienhtph17743/index" class="btn btn-warning mt-5">Quay
					lại trang chủ</a>
				</div>
			
		</div>
	</div>
</div>
