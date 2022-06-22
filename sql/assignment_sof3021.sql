-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 22, 2022 lúc 08:08 AM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `assignment_sof3021`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `accounts`
--

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `photo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activated` int(11) NOT NULL DEFAULT 0,
  `admin` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `accounts`
--

INSERT INTO `accounts` (`id`, `password`, `fullname`, `email`, `photo`, `activated`, `admin`) VALUES
(1, '$2a$10$A.7cDuBh8hMKtAUhuvuaWOMu76LSQb1bZEnrwirhhIui57yOWhc.q', 'Hà Trung Kiên', 'kienrang2001@gmail.com', 'IMG_2605.jpg', 1, 1),
(4, '$2a$10$rbiNKO/te3le63ifcpah7u1kzfu2VFDGrgG1cmoCGZTzpolXV8muC', 'Hà Minh Hiếu', 'minhhieu@gmail.com', '', 1, 0),
(5, '$2a$10$KyZoBOudL7Ps8wteYx.1xe2JbJ1d7ZmM/KEkANJDpV0COT8aKd08W', 'Nguyễn Trung Đức', 'ducnt@gmail.com', '', 1, 0),
(6, '$2a$10$O1QAnsFrAi2nq8YbIkXDu.uXAKzSoyyNa8KQJqBn4kU9mO76.zK86', 'Trần Minh Sáng', 'sangtm@gmail.com', '', 0, 0),
(9, '$2a$10$GXVLYgREGY9PxGwbQDxWiuJzd3jtWafRhXP07mhpndz93zPdikbMK', 'Hà Thị Nu', 'phitruong@gmail.com', '', 1, 0),
(10, '$2a$10$XrlFtHNV2KWwecQt2dOFZekXH9mdwG8kgxT4tV5z7dYbYKbLj6o7W', 'Kiên Cô Đơn', 'havangau@gmail.com', '', 0, 0),
(11, '$2a$10$WL0A4ZtOUifnikOGlbgVVuwW2x64Y.cXlkwdykCjjYTe4wP5VefOy', 'Hà Hồng Dương', 'duongxeom@gmail.com', '', 0, 0),
(12, '$2a$10$wg24egN5T7o/kFwsJDgIaew8uLkowXThNt6EbjXUjtJl6nYU2OXRa', 'Kim Gấu', 'gaucherang@gmail.com', '', 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `quantity` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `cart`
--

INSERT INTO `cart` (`id`, `product_id`, `user_id`, `quantity`) VALUES
(26, 8, 6, NULL),
(27, 9, 6, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Trà Sữa'),
(4, 'Cà Phê'),
(5, 'Đồ ăn vặt'),
(6, 'Trà');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `active` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `create_date`, `address`, `active`, `price`) VALUES
(62, 5, '2022-06-08 02:50:48', 'Nam Từ Liêm', 2, 29000),
(63, 5, '2022-06-08 09:24:05', 'Cầu giấy', 2, 206000),
(64, 4, '2022-06-08 09:33:10', 'Nam Từ Liêm', 2, 39000),
(70, 1, '2022-06-20 22:24:19', 'Cầu Giấy', 0, 116000),
(71, 5, '2022-06-20 22:25:27', '', 0, 145000),
(72, 5, '2022-06-20 22:37:49', 'Nam Từ Liêm', 2, 116000),
(73, 4, '2022-06-21 04:09:40', 'Nam Từ Liêm', 1, 175000),
(74, 4, '2022-06-21 04:23:35', 'Cầu Giấy', 1, 195000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_details`
--

CREATE TABLE `order_details` (
  `id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `price` float NOT NULL DEFAULT 0,
  `quantity` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `order_details`
--

INSERT INTO `order_details` (`id`, `order_id`, `product_id`, `price`, `quantity`) VALUES
(51, 62, 9, 29000, 1),
(52, 63, 8, 90000, 3),
(53, 63, 9, 58000, 2),
(54, 64, 11, 39000, 1),
(64, 70, 10, 116000, 4),
(65, 71, 10, 145000, 5),
(66, 72, 9, 116000, 4),
(86, 63, 16, 0, 0),
(87, 63, 10, 58000, 2),
(88, 73, 9, 58000, 2),
(89, 73, 11, 117000, 3),
(90, 74, 11, 78000, 2),
(91, 74, 12, 117000, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int(11) NOT NULL DEFAULT 0,
  `created_date` date NOT NULL DEFAULT current_timestamp(),
  `available` int(11) NOT NULL DEFAULT 1,
  `category_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `note` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `name`, `image`, `price`, `created_date`, `available`, `category_id`, `quantity`, `note`) VALUES
(8, 'Bạc xỉu đá', '270_crop_Bac_Xiu_Da.png', 30000, '2022-06-08', 1, 4, 0, 'Nếu Phin Sữa Đá dành cho các bạn đam mê vị đậm đà, thì Bạc Xỉu Đá là một sự lựa chọn nhẹ “đô\" cà phê nhưng vẫn thơm ngon, chất lừ không kém!'),
(9, 'Phin Sữa Đá', 'PHIN-SUA-DA.png', 29000, '2022-06-08', 1, 4, 0, 'Hương vị cà phê Việt Nam đích thực! Từng hạt cà phê hảo hạng được chọn bằng tay, phối trộn độc đáo giữa hạt Robusta từ cao nguyên Việt Nam, thêm Arabica thơm lừng. Cà phê được pha từ Phin truyền thống, hoà cùng sữa đặc sánh và thêm vào chút đá tạo nên ly Phin Sữa Đá – Đậm Đà Chất Phin.'),
(10, 'Phin Đen Đá', '270_crop_CFD.png', 29000, '2022-06-08', 1, 4, 0, 'Dành cho những tín đồ cà phê đích thực! Hương vị cà phê truyền thống được phối trộn độc đáo tại Highlands. Cà phê đậm đà pha hoàn toàn từ Phin, cho thêm 1 thìa đường, một ít đá viên mát lạnh, tạo nên Phin Đen Đá mang vị cà phê đậm đà chất Phin. '),
(11, 'PHINDI CHOCO', '270_crop_phindi_choco_new.png', 39000, '2022-06-08', 1, 4, 0, 'PhinDi Choco - Cà phê Phin thế hệ mới với chất Phin êm hơn, kết hợp cùng Choco ngọt tan mang đến hương vị mới lạ, không thể hấp dẫn hơn!'),
(12, 'PHINDI HẠNH NHÂN', '270_crop_phindi_hanh_nhan_new.png', 39000, '2022-06-08', 1, 4, 0, 'PhinDi Hạnh Nhân - Cà phê Phin thế hệ mới với chất Phin êm hơn, kết hợp cùng Hạnh nhân thơm bùi mang đến hương vị mới lạ, không thể hấp dẫn hơn!'),
(13, 'PHINDI KEM SỮA', '270_crop_phindi_kem_sua_new.png', 39000, '2022-06-08', 1, 4, 0, 'PhinDi Kem Sữa - Cà phê Phin thế hệ mới với chất Phin êm hơn, kết hợp cùng Kem Sữa béo ngậy mang đến hương vị mới lạ, không thể hấp dẫn hơn!'),
(14, 'Trà Sen Vàng', 'TRASENVANG.png', 39000, '2022-06-08', 1, 6, 1, 'Thức uống chinh phục những thực khách khó tính! Sự kết hợp độc đáo giữa trà Ô long, hạt sen thơm bùi và củ năng giòn tan. Thêm vào chút sữa sẽ để vị thêm ngọt ngào.'),
(15, 'Trà Thạch Vải', '270_crop_TRATHACHVAI_1.png', 39000, '2022-06-08', 1, 6, 0, 'Một sự kết hợp thú vị giữa trà đen, những quả vải thơm ngon và thạch giòn khó cưỡng, mang đến thức uống tuyệt hảo!'),
(16, 'Trà Thạch Đào', '270_crop_TRATHACHDAO.png', 40000, '2022-06-08', 1, 6, 0, 'Vị trà đậm đà kết hợp cùng những miếng đào thơm ngon mọng nước cùng thạch đào giòn dai. Thêm vào ít sữa để gia tăng vị béo.'),
(17, 'CARAMEL PHIN FREEZE', 'png.png', 49000, '2022-06-08', 1, 4, 0, 'Thơm ngon khó cưỡng! Được kết hợp từ cà phê truyền thống chỉ có tại Highlands Coffee, cùng với caramel, thạch cà phê và đá xay mát lạnh. Trên cùng là lớp kem tươi thơm béo và caramel ngọt ngào. Món nước phù hợp trong những cuộc gặp gỡ bạn bè, bởi sự ngọt ngào thường mang mọi người xích lại gần nhau.'),
(18, 'Sữa Tươi Trân Châu Đường Bách Nghệ', 'Sữa Tươi Trân Châu Đường Bách Nghệ.png', 59000, '2022-06-08', 1, 1, 0, 'Kem sữa Macchiato, Không chọn Topping, Pudding trứng, Thạch nha đam, Trân châu đen, Trân châu trắng');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT cho bảng `order_details`
--
ALTER TABLE `order_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
