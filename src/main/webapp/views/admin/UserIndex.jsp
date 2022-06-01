<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container mt-2" style="min-height: 460px;">
	<h1>Danh sách người dùng</h1>
	<a href="/kienhtph17743/admin/create_user"
		class="btn btn-outline-primary">Thêm tài khoản</a>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Họ Tên</th>
				<th scope="col">Email</th>
				<th scope="col">Hình Ảnh</th>
				<th colspan="2">Thao tác</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lsUser}" var="acc">
				<tr>
					<th scope="row">${acc.id}</th>
					<td>${acc.fullname}</td>
					<td>${acc.email}</td>
					<td>${acc.photo}</td>
					<td><a href="/kienhtph17743/admin/edit_user/${acc.id}"
						class="btn btn-outline-primary">Sửa</a></td>
					<td><a class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#exampleModal${acc.id}">Xóa</a> 
						<!-- Modal -->
						
						<div class="modal fade" id="exampleModal${acc.id}" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Xóa người Dùng</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<h3>Bạn có muốn xóa ${acc.fullname} không ?</h3>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Không</button>
										<a href="/kienhtph17743/admin/delete_user/${acc.id}" type="button" class="btn btn-primary">Có</a>
									</div>
								</div>
							</div>
						</div></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>