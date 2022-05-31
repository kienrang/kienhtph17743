<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container mt-2" style="min-height: 460px;">
       <h1>Danh sách người dùng</h1>
        <a href="/kienhtph17743/admin/create_user" class="btn btn-outline-primary">Thêm tài khoản</a>
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
          <tr>
            <th scope="row">id</th>
            <td>Tên</td>
            <td>mail@gmail.com</td>
            <td>anh.jpg</td>
            <td><a href="/kienhtph17743/admin/edit_user" class="btn btn-outline-primary">Sửa</a></td>
            <td><a href="/kienhtph17743/admin/delete_user" class="btn btn-outline-danger">Xóa</a></td>
          </tr>
        </tbody>
      </table>
</div>