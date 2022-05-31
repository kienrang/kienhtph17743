<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container p-0 mt-2" style="min-height: 460px;">
        <div class="" style="width: 30%; margin-left: 33%;">
            <form:form action="/kienhtph17743/admin/store_product" method="POST" modelAttribute="product">
                <div class="m-2">
                    <label for="">Tên Sản phẩm</label>
                    <form:input path="name" type="text" class="form-control"/>
                </div>
                <div class="m-2">
                    <label for="">Giá</label>
                    <form:input path="price" type="text" class="form-control"/>
                </div>
                <div class="m-2">
                    <label for="">Ngày tạo</label>
                    <form:input path="available" type="text" class="form-control"/>
                </div>
                <div class="m-2">
                    <label for="">Số lượng</label>
                    <form:input path="quantity" type="number" class="form-control"/>
                </div>
                <div class="m-2">
                    <label for="">Hình Ảnh</label>
                    <form:input path="image" type="file" class="form-control"/>
                </div>
                
                <div style="width: 70%; margin-left: 15%;">
                    <form:button class="container btn btn-outline-primary">Lưu sản phẩm</form:button>
                </div>
            </form:form>
        </div>
</div>