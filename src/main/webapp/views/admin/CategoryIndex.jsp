<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container mt-2" style="min-height: 460px; width: 40%">
	<h1>Loại sản phẩm</h1>
	<button class="btn btn-primary" type="button" data-bs-toggle="collapse"
		data-bs-target="#collapseExample" aria-expanded="false"
		aria-controls="collapseExample">Thêm</button>
	<div class="collapse mt-2" id="collapseExample">
		<div class="card card-body">
			<div class="" style="width: 30%; margin-left: 33%;">
				<form:form action="/kienhtph17743/admin/store_category" class="mt-3"
					method="POST" modelAttribute="cate">
					<form:input path="name" type="text"
						class="form-control mt-2 formstyle mb-4"
						placeholder="Nhập loại sản phẩm" />
					<div style="width: 70%; margin-left: 15%;">
						<button class="container btn btn-outline-primary">Lưu</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">--ID--</th>
				<th scope="col">Loại sản phẩm</th>
				<th>---------</th>
				<th colspan="2">Thao tác</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${ ls }" var="cate">
				<tr>
					<th scope="row">${cate.id}</th>
					<td>${cate.name}</td>
					<td></td>
					<td><a href="" class="btn btn-outline-primary"
						data-bs-toggle="modal" data-bs-target="#staticBackdrop${cate.id}">Sửa</a>

						<!-- Modal -->
						<div class="modal fade" id="staticBackdrop${cate.id}"
							data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
							aria-labelledby="staticBackdropLabel" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="staticBackdropLabel">Sửa
											${cate.name}</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<form:form
											action="/kienhtph17743/admin/update_category/${cate.id}"
											class="mt-3" modelAttribute="cate" method="POST">
											<form:input path="name" type="text"
												class="form-control mt-2 formstyle mb-4"
												placeholder="Nhập tên mới loại sản phẩm" />
											<div style="width: 70%; margin-left: 15%;">
												<form:button class="container btn btn-outline-primary">Lưu</form:button>
											</div>
										</form:form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div></td>
					<td><a class="btn btn-outline-danger" data-bs-toggle="modal"
		data-bs-target="#exampleModal${cate.id}">Xóa</a>

						<div class="modal fade" id="exampleModal${cate.id}" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel"> Xóa ${cate.name }</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<h3>Bạn có muốn xóa ${cate.name } không?</h3>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Không</button>
										<a href="/kienhtph17743/admin/delete_category/${cate.id}"
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