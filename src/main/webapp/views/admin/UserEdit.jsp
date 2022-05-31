<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container p-0 mt-2" style="min-height: 460px;">
        <div class="" style="width: 30%; margin-left: 33%;">
            <form:form action="/kienhtph17743/admin/store_user" method="POST" modelAttribute="user">
                <form:input type="text" path="fullname" class="form-control mt-2 formstyle" placeholder="Họ và Tên" style="background-image: url(../image/icon/name.png);
                background-repeat: no-repeat;
                background-size: 40px;
                padding-left: 45px;  "/>
                <form:input type="text" path="email" class="form-control mt-2 formstyle" placeholder="Email" style="background-image: url(../image/icon/mail.png);
                background-repeat: no-repeat;
                background-size: 40px;
                padding-left: 45px;  "/>
                <form:password path="password"  class="form-control mt-2 formstyle" placeholder="Mật khẩu" style="background-image: url(../image/icon/password.png);
                background-repeat: no-repeat;
                background-size: 40px;
                padding-left: 45px;  "/>
                <label for="" class="mt-2">Ảnh đại diện</label>
                <form:input type="file" path="photo" class="form-control mt-2" placeholder="avatar"/>
                <div>
                    <label for="">Trạng thái hoạt động</label>
                    <div>
                        <label for="">Có</label>
                        <form:radiobutton path="activated" value="1" name="active" id="" class="m-3"/>
                        <label for="">Không</label>
                        <form:radiobutton  path="activated" value="0" name="active" id="" class="m-3"/>
                    </div>
                </div>
                <div style="width: 70%; margin-left: 15%;">
                    <form:button class="container btn btn-outline-primary">Tạo tài khoản</form:button>
                </div>
            </form:form>
        </div>
    </div>