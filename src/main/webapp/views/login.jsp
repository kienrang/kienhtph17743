<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <style>
        .menu {
            background-color: #303030;
            height: 30px;
            line-height: 30px;
        }

        .menu>ul {}

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
    </style>
</head>

<body>
    <!-- Menu -->
    <div class="menu">
        <ul class="d-flex flex-row-reverse">
            <li><img src="image/icon/icons8-account-30.png" alt=""><a href="">Đăng Nhập</a></li>
            <li><img src="image/icon/icons8-favorite-cart-30.png" alt=""><a href="">Giỏ Hàng</a></li>
            <li><img src="image/icon/icons8-taxi-mobile-payment-24.png" alt=""><a href="">Đơn hàng</a></li>
        </ul>
    </div>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid layout">
            <div class="ms-5">
                <a class="navbar-brand" href="/kienhtph17743/home"><img
                        src="image/logo/chelsea-f-c-logo-C1CB09D36E-seeklogo.com.png" alt=""
                        style="width: 80px; height: 80px;"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
            <div>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="me-5">
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
    <!-- Carousel -->
    <div id="carouselExampleControls" class="carousel slide text-center bg-secondary text-white carou"
        data-bs-ride="carousel">
        <div class="carousel-inner ">
            <div class="carousel-item active">
                <p>Ché ràng</p>
            </div>
            <div class="carousel-item">
                <p>Ngu</p>
            </div>
            <div class="carousel-item">
                <p>Càng ngày càng ngu</p>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
            data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
            data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <!-- Content -->
    <div>
        <div class="pt-5" style="height: 500px; background-image: url(image/background/hinh-anh-ly-cafe-dep-2.jpg); background-size: cover;
        display: flex;
        justify-content: center;
        ">
            <div class="pt-4" style="
                width: 20%;
                height: 250px; 
                background-color: rgba(255, 255, 255, 0);
                border-radius: 20px;
                ">
                <form action="" class="text-center">
                    <input type="text" placeholder="Email" class="form-control mt-2">
                    <input type="password" name="" id="" placeholder="Mật khẩu" class="form-control mt-2">
                    <button class=" btn btn-outline-primary mt-2 ps-5 pe-5">Đăng nhập</button>
                    <hr>
                    <a href="">Tạo tài khoản</a>
                    <br>
                    <a href="" class="btn btn-warning mt-5">Quay lại trang chủ</a>
                </form>

            </div>
        </div>
    </div>

    <!-- footer -->
    <div>
        <section class=" text-center">
            <footer class="text-center text-white" style="background-color: #515151;">
                <!-- Grid container -->
                <div class="container pt-4">
                    <!-- Section: Social media -->
                    <section class="mb-4">
                        <!-- Facebook -->
                        <a class="btn btn-link btn-floating btn-lg text-dark m-1"
                            href="https://www.facebook.com/profile.php?id=100076937655293" role="button"
                            data-mdb-ripple-color="dark"><img src="image/icon/icons8-facebook-30.png" alt=""></i></a>

                        <!-- Twitter -->
                        <a class="btn btn-link btn-floating btn-lg text-dark m-1" href="#!" role="button"
                            data-mdb-ripple-color="dark"><img src="image/icon/icons8-twitter-30.png" alt=""></a>

                        <!-- Google -->
                        <a class="btn btn-link btn-floating btn-lg text-dark m-1" href="#!" role="button"
                            data-mdb-ripple-color="dark"><img src="image/icon/icons8-google-30.png" alt=""></i></a>

                        <!-- Instagram -->
                        <a class="btn btn-link btn-floating btn-lg text-dark m-1" href="#!" role="button"
                            data-mdb-ripple-color="dark"><img src="image/icon/icons8-instagram-30.png" alt=""></i></a>

                        <!-- Linkedin -->
                        <a class="btn btn-link btn-floating btn-lg text-dark m-1" href="#!" role="button"
                            data-mdb-ripple-color="dark"><img src="image/icon/icons8-linkedin-circled-30.png"
                                alt=""></a>
                        <!-- Github -->
                        <a class="btn btn-link btn-floating btn-lg text-dark m-1" href="#!" role="button"
                            data-mdb-ripple-color="dark"><img src="image/icon/icons8-zalo-50.png" alt=""></a>
                    </section>
                    <!-- Section: Social media -->
                </div>
                <!-- Grid container -->

                <!-- Copyright -->
                <div class="text-center text-white p-3" style="background-color: rgba(32, 32, 32, 0.2);">
                    © date
                </div>
                <!-- Copyright -->
            </footer>
        </section>
    </div>

    <script src="js/bootstrap.min.js"></script>
</body>

</html>