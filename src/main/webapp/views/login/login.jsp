<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div>
	<div class="pt-5"
		style="height: 500px; background-image: url(image/background/hinh-anh-ly-cafe-dep-2.jpg); background-size: cover; display: flex; justify-content: center;">
		<div class="pt-4"
			style="width: 20%; height: 250px; background-color: rgba(255, 255, 255, 0); border-radius: 20px;">
			<form:form action="/kienhtph17743/login" class="text-center" method="post" modelAttribute="acc">
				<form:input type="text" path="id" placeholder="Email" class="form-control mt-2" />
				<form:input path="name" type="password" name="" id="" placeholder="Mật khẩu"
					class="form-control mt-2"/>
				<button class=" btn btn-outline-primary mt-2 ps-5 pe-5">Đăng
					nhập</button>
				<hr>
				<a href="/kienhtph17743/register">Tạo tài khoản</a> <br> <a
					href="/kienhtph17743/index" class="btn btn-warning mt-5">Quay
					lại trang chủ</a>
			</form:form>
			
		</div>
	</div>
</div>
