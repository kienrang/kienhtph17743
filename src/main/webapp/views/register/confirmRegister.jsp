<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true" %>
<div class="">
        <div class="pt-5" style="height: 650px; background-image: url(image/background/background-resister.jpg); background-size: cover;
        display: flex;
        justify-content: center;
        ">
            <div class="pt-4" style="
                width: 20%; 
                background-color: rgba(255, 255, 255, 0);
                border-radius: 20px;
                ">
                <form action="index.html" class="text-center d-flex text-white">
                    <div class="input-group mb-3 mt-5">
                        <input type="text" class="form-control" placeholder="Nhập mã xác nhận">
                        <button class="btn next" style="background-color: orange;" href=""><img
                                src="image/icon/Next-button-30.png" alt="" srcset=""></button>
                    </div>
                </form>
                <p class="text-white">Mã xác nhận được gửi về email của bạn!</p>
                <div class="text-center">
                    <a href="/kienhtph17743/index" class="btn btn-warning mt-2">Quay lại trang chủ</a>
                </div>
            </div>
        </div>
</div>