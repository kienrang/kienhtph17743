<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="/kienhtph17743/src/main/webapp/css/bootstrap.min.css">

<style>
body {
	font-family: NunitoSanRegular;
}

.menu {
	background-color: #303030;
	height: 30px;
	line-height: 30px;
}

.menu>ul>li {
	display: flex;
	list-style: none;
	margin-right: 25px;
}

.menu>ul>li>img {
	margin-top: 7px;
	margin-right: 4px;
	width: 16px;
	height: 16px;
}

.menu>ul>li>a {
	display: block;
	color: white;
	text-decoration: none;
	font-family: NunitoSanRegular;
	font-size: 12px;
	font-weight: bold;
}

.menu>ul>li>a:hover {
	background-color: white;
	color: rgb(249, 33, 9);
}

.layout {
	display: flex !important;
	justify-content: space-around !important;
}

.carou {
	font-family: NunitoSanRegular;
	height: 30px;
	line-height: 30px;
}

.tx {
	width: 1px;
	height: 35px;
	background-color: rgb(78, 78, 78);
	margin: 10px;
}

.navtext {
	font-size: 28px;
	font-weight: 600;
}
.formstyle {    
            background-color: rgba(225, 225, 225, 0);
            border-top: none;
            border-left: none;
            border-right: none;
            margin-top: 10px !important;
            border-radius: 0;
        }
</style>
</head>

<body>
	<!-- Menu -->
	<div class="menu">
		<ul class="d-flex flex-row-reverse">
			<c:if test="${ user == null}">
				<li><img src="../image/icon/icons8-account-30.png" alt=""> <a
					href="/kienhtph17743/login">Đăng Nhập</a></li>

			</c:if>
			<c:if test="${ null != user }">
				<li class="nav-item dropdown"><img
					src="../image/icon/icons8-account-30.png" alt=""><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						${user.fullname } </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="/kienhtph17743/logout">Đăng
								Xuất</a></li>
					</ul></li>
			</c:if>
			<li><img src="../image/icon/icons8-favorite-cart-30.png" alt=""><a
				href="/kienhtph17743/cart">Giỏ Hàng</a></li>
			<li><img src="../image/icon/icons8-taxi-mobile-payment-24.png"
				alt=""><a href="/kienhtph17743/admin/hoadon">Hóa đơn</a></li>
		</ul>
	</div>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid layout">
			<div class="ms-5">
				<a class="navbar-brand" href="/kienhtph17743/admin/index_order"> <img
					src="../image/logo/coffe logo.png" alt=""
					style="width: 125px; height: 125px;">
				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
			<div>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active navtext"
							aria-current="page" href="/kienhtph17743/admin/index_user">Người dùng</a></li>
						<div class="tx"> </div>
						<li class="nav-item"><a class="nav-link active navtext"
							aria-current="page" href="/kienhtph17743/admin/index_product">Sản phẩm</a></li>
						<div class="tx"></div>
						<li class="nav-item"><a class="nav-link active navtext"
							aria-current="page" href="/kienhtph17743/admin/index_order">Đơn hàng</a></li>
						<div class="tx">
						</div>
						<li class="nav-item"><a class="nav-link active navtext"
							aria-current="page" href="index_category">Loại sản phẩm</a></li>
						</div>
					</ul>
				</div>
			</div>
			<div class="me-5">
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
	<!-- Carousel -->
	<div id="carouselExampleControls"
		class="carousel slide text-center bg-secondary text-white carou p-0 m-0"
		data-bs-ride="carousel">
		<div class="carousel-inner ">
			<div class="carousel-item active">
				<p>Hương vị đậm đà</p>
			</div>
			<div class="carousel-item">
				<p>Ngon hơn người yêu cũ</p>
			</div>
			<div class="carousel-item">
				<p>Miễn phí giao hàng dưới 5km</p>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<!-- Content -->
	<jsp:include page="${ view }"></jsp:include>
	<!-- footer -->
	<div>
		<section class=" text-center">
			<footer class="text-center text-white"
				style="background-color: #515151;">
				<!-- Grid container -->
				<div class="container pt-4">
					<!-- Section: Social media -->
					<section class="mb-4">
						<!-- Facebook -->
						<a class="btn btn-link btn-floating btn-lg text-dark m-1"
							href="https://www.facebook.com/profile.php?id=100076937655293"
							role="button" data-mdb-ripple-color="dark"><img
							src="../image/icon/icons8-facebook-30.png" alt=""></i></a>

						<!-- Twitter -->
						<a class="btn btn-link btn-floating btn-lg text-dark m-1"
							href="#!" role="button" data-mdb-ripple-color="dark"><img
							src="../image/icon/icons8-twitter-30.png" alt=""></a>

						<!-- Google -->
						<a class="btn btn-link btn-floating btn-lg text-dark m-1"
							href="#!" role="button" data-mdb-ripple-color="dark"><img
							src="../image/icon/icons8-google-30.png" alt=""></i></a>

						<!-- Instagram -->
						<a class="btn btn-link btn-floating btn-lg text-dark m-1"
							href="#!" role="button" data-mdb-ripple-color="dark"><img
							src="../image/icon/icons8-instagram-30.png" alt=""></i></a>

						<!-- Linkedin -->
						<a class="btn btn-link btn-floating btn-lg text-dark m-1"
							href="#!" role="button" data-mdb-ripple-color="dark"><img
							src="../image/icon/icons8-linkedin-circled-30.png" alt=""></a>
						<!-- Github -->
						<a class="btn btn-link btn-floating btn-lg text-dark m-1"
							href="#!" role="button" data-mdb-ripple-color="dark"><img
							src="../image/icon/icons8-zalo-50.png" alt=""></a>
					</section>
					<!-- Section: Social media -->
				</div>
				<!-- Grid container -->

				<!-- Copyright -->
				<div class="text-center text-white p-3"
					style="background-color: rgba(32, 32, 32, 0.2);">
					<p>© ${ date }</p>
				</div>
				<!-- Copyright -->
			</footer>
		</section>
	</div>
	<script src="../js/query.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>

</html>