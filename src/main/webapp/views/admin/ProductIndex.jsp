<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="container mt-2" style="min-height: 460px;">
       <h1>Danh sách sản phẩm</h1>
        <a href="/kienhtph17743/admin/create_product" class="btn btn-outline-primary">Thêm Sản Phẩm</a>
       <table class="table">
        <thead>
          <tr>
            <th scope="col">Hình ảnh</th>
            <th scope="col">Tên Sản phẩm</th>
            <th scope="col">Giá(VNĐ)</th>
            <th scope="col">Số lượng</th>
            <th colspan="2">Thao tác</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${ds}" var="p">
          	<tr>
            <th scope="row">${p.image }</th>
            <td>${p.name }</td>
            <td>${p.price }</td>
            <td>${p.quantity }</td>
            <td><a href="/kienhtph17743/admin/edit_product/${p.id}" class="btn btn-outline-primary">Sửa</a></td>
            <td><a class="btn btn-outline-danger" data-bs-toggle="modal"
		data-bs-target="#exampleModal${p.id}">Xóa</a>

						<div class="modal fade" id="exampleModal${p.id}" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel"> Xóa ${p.name }</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<h3>Bạn có muốn xóa ${p.name } không?</h3>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Không</button>
										<a href="/kienhtph17743/admin/delete_product/${p.id}"
											class="btn btn-outline-danger">Có</a>
									</div>
								</div>
							</div>
						</div></td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
</div>