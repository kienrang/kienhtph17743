<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container p-0 mt-2" style="min-height: 460px;">
        <div class="" style="width: 30%; margin-left: 33%;">
            <form:form action="/kienhtph17743/admin/update_user" method="POST" modelAttribute="user">
                <form:input path="fullname" class="form-control" placeholder="Họ và Tên"/>
                <form:input path="email" class="form-control" placeholder="Họ và Tên"/>
                <form:password path="password" class="form-control" placeholder="Họ và Tên"/>
                <form:input type="file" path="photo" class="form-control" placeholder="Họ và Tên"/>
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
                    <form:button class="container btn btn-outline-primary">Lưu</form:button>
                </div>
            </form:form>
        </div>
</div>