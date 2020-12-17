-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2020 at 09:11 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blog`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `id` int(10) UNSIGNED NOT NULL,
  `jop_number` int(11) DEFAULT NULL,
  `carear` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `diagnosis_prise` varchar(90) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fellowship` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `qualifications` text COLLATE utf8mb4_unicode_ci,
  `user_id` int(10) UNSIGNED NOT NULL,
  `speshalty_id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`id`, `jop_number`, `carear`, `diagnosis_prise`, `address`, `image`, `fellowship`, `qualifications`, `user_id`, `speshalty_id`, `created_at`, `updated_at`) VALUES
(1, 4567896, 'hhhhhhh', '900SD', 'khartoum', 'index.jfif', 'gkjhfkh', NULL, 6, 1, '2020-11-11 22:32:55', '2020-12-01 19:43:34'),
(2, 4567856, 'ghjjjjjjjjjjjjjjjjjjj', '890SD', 'omdrman', 'index.jfif', NULL, NULL, 7, 4, NULL, NULL),
(3, 3456876, 'kkkkkkkkkkkk', '500SD', 'Bahri', 'indexu.jfif', NULL, NULL, 31, 1, NULL, NULL),
(4, 5679887, 'kkkkkkkk', '840SD', 'Omdarman', 'indexu.jfif', NULL, NULL, 3, 5, NULL, NULL),
(5, 55567800, 'DDDDDDDDDDDDDDDDDD', '1200SD', 'Bahri', 'index.jfif', NULL, NULL, 44, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `doctor_hospital`
--

CREATE TABLE `doctor_hospital` (
  `id` int(10) UNSIGNED NOT NULL,
  `doctor_id` int(10) UNSIGNED NOT NULL,
  `hospital_id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `doctor_hospital`
--

INSERT INTO `doctor_hospital` (`id`, `doctor_id`, `hospital_id`, `created_at`, `updated_at`) VALUES
(1, 1, 2, '2020-11-11 22:32:56', '2020-11-11 22:32:56'),
(2, 1, 1, NULL, NULL),
(3, 3, 2, NULL, NULL),
(4, 4, 2, NULL, NULL),
(5, 3, 1, NULL, NULL),
(6, 5, 1, NULL, NULL),
(7, 2, 3, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `examinations`
--

CREATE TABLE `examinations` (
  `id` int(10) UNSIGNED NOT NULL,
  `date` date DEFAULT NULL,
  `image` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `result` text COLLATE utf8mb4_unicode_ci,
  `interview_id` int(10) UNSIGNED NOT NULL,
  `hospital_id` int(10) UNSIGNED NOT NULL,
  `state` enum('finised','notfinised') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'notfinised',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `examinations`
--

INSERT INTO `examinations` (`id`, `date`, `image`, `name`, `result`, `interview_id`, `hospital_id`, `state`, `created_at`, `updated_at`) VALUES
(1, NULL, NULL, 'maca', NULL, 129, 3, 'notfinised', '2020-12-01 20:09:20', '2020-12-01 20:09:20');

-- --------------------------------------------------------

--
-- Table structure for table `failed_jobs`
--

CREATE TABLE `failed_jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `connection` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `queue` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `exception` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hospitals`
--

CREATE TABLE `hospitals` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `location` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `avatar` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone_number` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `hospitals`
--

INSERT INTO `hospitals` (`id`, `name`, `location`, `avatar`, `phone_number`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Maca Hospital', 'macastreat', 'indexa.jfif', '0992087157', '2020-11-11 21:51:49', '2020-11-11 21:51:49', NULL),
(2, 'Alya Hospital', 'kh', 'img_2020112911573334126.jfif', '0907863321', '2020-11-11 22:27:22', '2020-11-11 22:27:22', NULL),
(3, 'Jabra Hospital', 'Khartoum', 'indexho.jfif', '0987654567', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hospital_user`
--

CREATE TABLE `hospital_user` (
  `id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `hospital_id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `hospital_user`
--

INSERT INTO `hospital_user` (`id`, `user_id`, `hospital_id`, `created_at`, `updated_at`) VALUES
(1, 2, 1, NULL, NULL),
(2, 5, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `interviews`
--

CREATE TABLE `interviews` (
  `id` int(10) UNSIGNED NOT NULL,
  `symptoms` text COLLATE utf8mb4_unicode_ci,
  `date` date DEFAULT NULL,
  `pichant_id` int(10) UNSIGNED NOT NULL,
  `doctor_id` int(10) UNSIGNED NOT NULL,
  `the_diagnosis` text COLLATE utf8mb4_unicode_ci,
  `state` enum('finised','notstarted','pinding') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'notstarted',
  `notes` text COLLATE utf8mb4_unicode_ci,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `interviews`
--

INSERT INTO `interviews` (`id`, `symptoms`, `date`, `pichant_id`, `doctor_id`, `the_diagnosis`, `state`, `notes`, `created_at`, `updated_at`) VALUES
(32, 'hjkl;', '2020-11-03', 8, 4, 'kkkk', 'notstarted', 'kl', NULL, NULL),
(129, 'mmm', '2020-12-01', 146, 1, 'll', 'pinding', 'll', NULL, '2020-12-01 20:09:45'),
(131, NULL, '0000-00-00', 146, 1, NULL, 'notstarted', NULL, NULL, NULL),
(133, NULL, '0000-00-00', 148, 1, NULL, 'notstarted', NULL, NULL, NULL),
(134, NULL, '2020-12-05', 149, 1, NULL, 'notstarted', NULL, NULL, NULL),
(135, NULL, '2020-12-04', 150, 1, NULL, 'notstarted', NULL, NULL, NULL),
(142, NULL, '2020-12-05', 157, 1, NULL, 'notstarted', NULL, NULL, NULL),
(143, NULL, '2020-12-03', 158, 1, NULL, 'notstarted', NULL, NULL, NULL),
(144, NULL, '2020-12-01', 160, 1, NULL, 'notstarted', NULL, NULL, NULL),
(145, NULL, '2020-12-04', 160, 1, NULL, 'notstarted', NULL, NULL, NULL),
(146, NULL, '2020-12-04', 160, 1, NULL, 'notstarted', NULL, NULL, NULL),
(148, NULL, '2020-12-04', 161, 1, NULL, 'notstarted', NULL, NULL, NULL),
(149, NULL, '2020-12-05', 162, 1, NULL, 'notstarted', NULL, NULL, NULL),
(150, NULL, '2020-12-05', 162, 1, NULL, 'notstarted', NULL, NULL, NULL),
(151, NULL, '2020-12-05', 163, 1, NULL, 'notstarted', NULL, NULL, NULL),
(152, NULL, '2020-12-05', 164, 1, NULL, 'notstarted', NULL, NULL, NULL),
(153, NULL, '2020-12-03', 168, 1, NULL, 'notstarted', NULL, NULL, NULL),
(154, NULL, '2020-12-05', 168, 1, NULL, 'notstarted', NULL, NULL, NULL),
(155, NULL, '2020-12-05', 169, 1, NULL, 'notstarted', NULL, NULL, NULL),
(156, NULL, '2020-12-04', 169, 1, NULL, 'notstarted', NULL, NULL, NULL),
(158, NULL, '2020-12-03', 169, 1, NULL, 'notstarted', NULL, NULL, NULL),
(159, NULL, '2020-12-05', 170, 1, NULL, 'notstarted', NULL, NULL, NULL),
(160, NULL, '2020-12-01', 170, 1, NULL, 'notstarted', NULL, NULL, NULL),
(161, NULL, '2020-12-01', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(162, NULL, '2020-12-01', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(163, NULL, '2020-12-03', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(164, NULL, '2020-12-01', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(165, NULL, '2020-12-01', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(166, NULL, '2020-12-01', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(167, NULL, '2020-12-05', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(168, NULL, '2020-12-01', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(169, NULL, '2020-12-05', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(170, NULL, '2020-12-05', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(171, NULL, '2020-12-05', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(172, NULL, '2020-12-05', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(173, NULL, '2020-12-05', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(174, NULL, '2020-12-01', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(175, NULL, '2020-12-01', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(176, NULL, '2020-12-05', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(177, NULL, '2020-12-04', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(178, NULL, '2020-12-05', 172, 1, NULL, 'notstarted', NULL, NULL, NULL),
(179, NULL, '2020-12-02', 175, 1, NULL, 'notstarted', NULL, NULL, NULL),
(180, NULL, '2020-12-03', 176, 1, NULL, 'notstarted', NULL, NULL, NULL),
(181, NULL, '2020-12-03', 177, 1, NULL, 'notstarted', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `labdoctors`
--

CREATE TABLE `labdoctors` (
  `id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `hospital_id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `labdoctors`
--

INSERT INTO `labdoctors` (`id`, `user_id`, `hospital_id`, `created_at`, `updated_at`) VALUES
(1, 7, 2, '2020-11-11 22:34:53', '2020-11-11 22:34:53'),
(2, 125, 1, '2020-12-02 06:00:55', '2020-12-02 06:00:55');

-- --------------------------------------------------------

--
-- Table structure for table `medicines`
--

CREATE TABLE `medicines` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `duration_of_use` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `interview_id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(16, '2014_10_12_000000_create_users_table', 1),
(17, '2014_10_12_100000_create_password_resets_table', 1),
(18, '2019_08_19_000000_create_failed_jobs_table', 1),
(19, '2020_10_12_125856_create_speshalties_table', 1),
(20, '2020_10_12_142703_create_hospitals_table', 1),
(21, '2020_10_12_160003_create_hospital_user_table', 1),
(22, '2020_10_12_163532_create_doctors_table', 1),
(23, '2020_10_12_180655_create_doctor_hospital_table', 1),
(24, '2020_10_15_122433_create_worktimes_table', 1),
(25, '2020_10_15_190319_create_pichants_table', 1),
(26, '2020_10_16_080142_create_interviews_table', 1),
(27, '2020_10_16_113504_create_medicines_table', 1),
(28, '2020_10_16_115230_create_examinations_table', 1),
(29, '2020_10_30_231227_add_softdelete_column_to_hospitals_table', 1),
(30, '2020_11_02_160935_create_labdoctors_table', 1);

-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pichants`
--

CREATE TABLE `pichants` (
  `id` int(10) UNSIGNED NOT NULL,
  `patriot_number` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` enum('male','female') COLLATE utf8mb4_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `address` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `blood_type` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sensitivity` text COLLATE utf8mb4_unicode_ci,
  `genetic_diseases` text COLLATE utf8mb4_unicode_ci,
  `social_status` enum('married','single','divorced') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bad_habit` text COLLATE utf8mb4_unicode_ci,
  `user_id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pichants`
--

INSERT INTO `pichants` (`id`, `patriot_number`, `gender`, `birthday`, `address`, `image`, `blood_type`, `sensitivity`, `genetic_diseases`, `social_status`, `bad_habit`, `user_id`, `created_at`, `updated_at`) VALUES
(1, '12344', 'male', '2020-11-11', 'lvdl', 'sff', 'o+', 'fhfh', 'jdgdgf', 'married', 'nvndnbd', 8, NULL, NULL),
(2, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, NULL),
(3, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, NULL),
(4, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, NULL),
(5, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, NULL),
(6, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, NULL),
(7, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(8, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(9, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(10, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(11, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(12, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(13, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(14, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(15, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(16, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(17, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(18, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(19, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(20, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(21, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(22, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(23, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(24, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(25, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(26, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(27, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(28, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(29, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(30, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(31, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL),
(32, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 19, NULL, NULL),
(33, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 19, NULL, NULL),
(34, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL, NULL),
(35, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(36, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(37, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(38, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(39, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(40, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(41, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(42, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(43, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(44, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(45, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(46, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(47, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(48, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(49, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(50, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(51, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(52, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(53, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(54, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(55, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(56, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(57, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(58, '0', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 21, NULL, NULL),
(59, '348', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 22, NULL, NULL),
(60, '4568-096-765', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 23, NULL, NULL),
(61, '444', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 25, NULL, NULL),
(62, '090909', 'female', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 27, NULL, NULL),
(63, '111', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 28, NULL, NULL),
(64, '1115', 'female', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 28, NULL, NULL),
(65, '55-66', 'female', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 32, NULL, NULL),
(66, '12468', 'female', '2020-10-28', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 33, NULL, NULL),
(67, '12468', 'female', '1997-04-23', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 33, NULL, NULL),
(68, '222-666-000', 'female', '2012-11-12', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 35, NULL, NULL),
(69, '2357', 'female', '2016-10-28', 'Omdraman', NULL, 'O', NULL, NULL, NULL, NULL, 37, NULL, NULL),
(70, '3578-7997-78', 'male', '1997-04-23', 'Bahri', NULL, 'A+', 'Sen45', 'Trio', '', 'Skomm', 44, NULL, NULL),
(71, '', 'male', '0000-00-00', 'Select an item...', NULL, 'Select an item...', '', '', '', '', 45, NULL, NULL),
(72, '567-57', 'male', '0000-00-00', 'Select an item...', NULL, 'Select an item...', '', '', '', '', 45, NULL, NULL),
(73, '567-57', 'male', '0000-00-00', 'Select an item...', NULL, 'Select an item...', '', '', '', '', 45, NULL, NULL),
(74, '567-57', 'female', '0000-00-00', 'Select an item...', NULL, 'Select an item...', '', '', '', '', 45, NULL, NULL),
(75, '567-57', 'female', '2024-10-28', 'Select an item...', NULL, 'Select an item...', '', '', '', '', 45, NULL, NULL),
(76, '567-57', 'female', '2024-10-28', 'Select an item...', NULL, 'Select an item...', '', '', '', '', 45, NULL, NULL),
(77, '567-57', 'female', '2024-10-28', 'Khartoum', NULL, 'Select an item...', '', '', '', '', 45, NULL, NULL),
(82, '567-57', 'female', '2020-10-28', 'Khartoum', NULL, 'O', 'kkk', 'kkkk', '', 'kkk', 45, NULL, NULL),
(100, '4678', 'female', '2020-10-28', 'Select an item...', NULL, 'Select an item...', '', '', '', '', 48, NULL, NULL),
(101, '4678', 'female', '2020-10-28', 'Khartoum', NULL, 'Select an item...', '', '', '', '', 48, NULL, NULL),
(102, '', 'male', '0000-00-00', 'Select an item...', NULL, 'Select an item...', '', '', '', '', 49, NULL, NULL),
(103, '', 'male', '2020-10-28', 'Select an item...', NULL, 'Select an item...', '', '', '', '', 49, NULL, NULL),
(104, '235-789-789', 'male', '2008-10-28', 'Khartoum', NULL, 'O', 'sen', 'Gen', '', 'Bad', 50, NULL, NULL),
(105, '235-789-789', 'male', '2008-10-28', 'Khartoum', NULL, 'O', 'sen', 'Gen', '', 'Bad', 50, NULL, NULL),
(106, '456â€000-999', 'female', '2003-10-28', 'Omdraman', NULL, 'A', 'gg', 'gg', 'single', 'gg', 51, NULL, NULL),
(108, '35790-90866', 'male', '2014-10-28', 'Bahri', NULL, 'A+', 'o', 'p', 'married', 'p', 52, NULL, NULL),
(109, '677', 'female', '2020-10-28', 'Omdraman', NULL, 'A', 'h', 'h', 'married', 'h', 54, NULL, NULL),
(110, '66666', 'female', '2020-10-28', 'Omdraman', 'img_202011280431161487.jpg', 'O', 'hhu', 'bzjsj', 'single', 'nzmkjj', 55, NULL, NULL),
(111, '89', 'female', '2020-10-28', 'Omdraman', 'img_202011280433304021.jpg', 'O', 'ttt', 'ff', 'married', 'bh', 56, NULL, NULL),
(112, '67899', 'male', '2008-05-28', 'Khartoum', 'img_20201128043914460.jpg', 'O', 'yyy', 'iiii', 'married', 'ppp', 57, NULL, NULL),
(113, '5555-0099', 'female', '2020-10-28', 'Omdraman', NULL, 'O', 'v', 'v', 'married', 'v', 58, NULL, NULL),
(114, 'yyy', 'female', '2020-10-28', 'Omdraman', NULL, 'A+', 'yy', 'i', 'married', 'p', 60, NULL, NULL),
(115, 'yyy', 'female', '2020-10-28', 'Omdraman', NULL, 'A+', 'yy', 'i', 'married', 'p', 60, NULL, NULL),
(116, '457', 'female', '2013-10-28', 'Khartoum', 'img_202011280451474184.jpg', 'A', 'jj', 'jj', 'single', 'nznj', 61, NULL, NULL),
(117, '777', 'male', '2020-10-28', 'Omdraman', NULL, 'A+', 'yu', 'l', 'married', 'k', 62, NULL, NULL),
(118, 'yu', 'male', '2020-10-28', 'Omdraman', 'img_202011280455492388.jpg', 'O', 'hd', 'd', 'single', 'd', 63, NULL, NULL),
(119, '66778', 'female', '2020-10-28', 'Bahri', 'img_20201128045805142.jpg', 'O', 'op', 'op', 'single', 'op', 64, NULL, NULL),
(121, '567-9007-77', 'male', '2000-05-01', 'Khartoum', 'img_202011291106341367.jpg', 'A', 'Tas', 'Gender', 'single', 'Bad', 66, NULL, NULL),
(128, '5789-887-098', 'male', '1998-05-11', 'Khartoum', NULL, 'A', 'hajansh', 'hhhh', 'married', 'kkkl', 73, NULL, NULL),
(129, '766-5670-677', 'male', '2008-06-10', 'Omdraman', 'img_202011300458243682.jpg', 'A', 'ghhvg', 'njjj', 'married', 'jjk', 74, NULL, NULL),
(130, '71819-981-56', 'male', '2008-10-30', 'Omdraman', NULL, 'O', 'hejjs', 'hahjaow', 'married', 'kksks', 75, NULL, NULL),
(131, '866', 'male', '2020-10-30', 'Omdraman', NULL, 'A+', 'jeoem', 'eklele', 'married', 'skowl', 76, NULL, NULL),
(133, '68949', 'male', '2014-10-30', 'Omdraman', NULL, 'O', 'hdid', 'jdkdk', 'married', 'dndkld', 78, NULL, NULL),
(137, '9928', 'male', '2020-10-30', 'Omdraman', NULL, 'A', 'hsj', 'jskd', 'married', 'kfkf', 82, NULL, NULL),
(138, '92928', 'male', '2020-10-30', 'Omdraman', NULL, 'O', 'nakamajkak', 'kakwka', 'married', 'kakwk', 83, NULL, NULL),
(139, '92827', 'male', '2014-10-30', 'Omdraman', NULL, 'O', 'Mkaks', 'kksks', 'married', 'kkeks', 85, NULL, NULL),
(140, '617199', 'male', '2020-10-30', 'Bahri', NULL, 'O', 'hsksk', 'akkaksk', 'married', 'akakl', 86, NULL, NULL),
(141, 'hajak', 'male', '2020-10-30', 'Khartoum', NULL, 'O', 'nznzns', 'ndjdjd', 'married', 'nsksk', 87, NULL, NULL),
(142, '9294757', 'male', '2014-10-30', 'Khartoum', NULL, 'O', 'jsosk', 'mdkkd', 'married', 'ldlk', 89, NULL, NULL),
(143, '987-790-87', 'male', '2003-04-28', 'Bahri', NULL, 'A+', 'uuuu', 'iiii', 'divorced', 'ppp', 90, NULL, NULL),
(144, '76-98-7-9', 'female', '2001-05-06', 'Bahri', NULL, 'A', 'hsjja', 'kkkskz', 'married', 'kskks', 91, NULL, NULL),
(145, '', 'male', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL),
(146, '98272', 'male', '2020-11-01', 'Omdraman', NULL, 'O', 'jsidjd', 'jdjdkd', 'married', 'msmsm', 93, NULL, NULL),
(147, 'hjaj', 'male', '2020-11-01', 'Omdraman', NULL, 'O', 'bshzn', 'hhzjzn', 'single', 'hzjzj', 95, NULL, NULL),
(148, '7282828', 'male', '2020-11-01', 'Khartoum', NULL, 'A', 'jajak', 'kaksk', 'married', 'akkak', 96, NULL, NULL),
(149, 'i2728', 'female', '2020-11-01', 'Omdraman', NULL, 'A', 'yyy', 'yyy', 'married', 'yy', 97, NULL, NULL),
(150, '866-988-888', 'male', '1998-05-27', 'Omdraman', NULL, 'A+', 'Yaa', 'yas', 'divorced', 'ppp', 98, NULL, NULL),
(151, '766-877-888', 'male', '2011-07-01', 'Omdraman', NULL, 'A+', 'hJja', 'jajaj', 'married', 'jjaka', 100, NULL, NULL),
(152, '62828', 'male', '2020-11-01', 'Omdraman', NULL, 'A+', 'jxkd', 'kkdkd', 'married', 'kskks', 101, NULL, NULL),
(153, '8', 'male', '2020-11-01', 'Omdraman', NULL, 'O', 'ekensksk', 'msksk', 'married', 'msmsk', 102, NULL, NULL),
(154, '2883838', 'male', '2020-11-01', 'Omdraman', NULL, 'O', 'jsjek', 'jsksk', 'single', 'smksk', 103, NULL, NULL),
(155, '7172626', 'male', '2020-11-01', 'Bahri', NULL, 'O', 'ajjwj', 'jajaj', 'single', 'jajam', 104, NULL, NULL),
(156, '9872', 'male', '2015-11-01', 'Omdraman', NULL, 'O', 'hajaj', 'jzjsk', 'single', 'kzkzk', 105, NULL, NULL),
(157, '77266', 'male', '2020-11-01', 'Bahri', NULL, 'O', 'syheu', 'ajjsk', 'married', 'ksksk', 106, NULL, NULL),
(158, '6666', 'male', '2020-11-01', 'Omdraman', NULL, 'O', 'hjj', 'akkaka', 'single', 'akka', 107, NULL, NULL),
(159, '8282772', 'female', '2007-11-26', 'Bahri', NULL, 'O', 'jja', 'mamka', 'single', 'skksk', 108, NULL, NULL),
(160, 'hahaj', 'male', '2020-11-01', 'Bahri', NULL, 'O', 'jzjz', 'msms', 'married', 'sk', 109, NULL, NULL),
(161, '8737', 'male', '2015-11-01', 'Omdraman', NULL, 'O', 'hdjd', 'hxjxj', 'single', 'jjxm', 110, NULL, NULL),
(162, '83838', 'male', '2020-11-01', 'Omdraman', NULL, 'O', 'jdjdk', 'jdk', 'married', 'kk', 111, NULL, NULL),
(163, '01827', 'male', '2014-11-01', 'Omdraman', NULL, 'O', 'nznzm', 'sjjsks', 'married', 'jsksk', 112, NULL, NULL),
(164, '82828', 'male', '2012-11-01', 'Omdraman', NULL, 'A', 'nsjsjmk', 'mskks', 'married', 'kskks', 113, NULL, NULL),
(165, 'isik', 'male', '2020-11-01', 'Omdraman', NULL, 'O', 'jsjsj', 'jskks', 'single', 'msks', 114, NULL, NULL),
(166, '882872', 'male', '2007-11-01', 'Omdraman', NULL, 'O', 'jsj', 'mmd', 'single', 'kk', 115, NULL, NULL),
(167, '82882', 'male', '2020-11-01', 'Omdraman', NULL, 'O', 'ndj', 'jkd', 'married', 'j', 116, NULL, NULL),
(168, '888', 'male', '2020-11-01', 'Omdraman', NULL, 'O', 'jajsj', 'jsksk', 'single', 'mksk', 118, NULL, NULL),
(169, '788', 'male', '2020-11-01', 'Omdraman', NULL, 'A', 'jj', 'jj', 'married', 'jj', 119, NULL, NULL),
(170, '98828', 'male', '2013-11-01', 'Omdraman', NULL, 'O', 'nxjk', '8hxjx', 'married', 'jxjzj', 120, NULL, NULL),
(171, '98828', 'male', '2012-11-01', 'Omdraman', NULL, 'O', 'jsjjs', 'nndj', 'single', 'jsksk', 121, NULL, NULL),
(172, '2-4578-678', 'male', '2008-06-01', 'Omdraman', NULL, 'A+', 'hhh', 'uuu', 'married', 'iii', 122, NULL, NULL),
(173, 'yujj', 'male', '2020-11-01', 'Select an item...', NULL, 'A', 'Jja.', 'mkak', 'single', 'jajaj', 123, NULL, NULL),
(174, '82727-9828-8', 'male', '2015-11-02', 'Omdraman', NULL, 'O', 'nzkzk', 'ksksk', 'single', 'kksk', 124, NULL, NULL),
(175, '44-778-456', 'male', '1995-07-02', 'Omdraman', NULL, 'O', 'no', 'no', 'married', 'no', 126, NULL, NULL),
(176, '234-678-788', 'male', '2015-11-03', 'Khartoum', NULL, 'O', 'tyj', 'hjj', 'married', 'jjk', 127, NULL, NULL),
(177, '23-689-', 'male', '1994-11-03', 'Khartoum', NULL, 'A', 'nn', 'nn', 'single', 'haj', 128, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `speshalties`
--

CREATE TABLE `speshalties` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `speshalties`
--

INSERT INTO `speshalties` (`id`, `name`, `created_at`, `updated_at`) VALUES
(1, 'pons', '2020-11-11 22:29:32', '2020-11-11 22:29:32'),
(2, 'Theth', NULL, NULL),
(3, 'Haret', NULL, NULL),
(4, 'eyes', NULL, NULL),
(5, 'Noth', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `role` enum('superadmin','admin','hosptaladmin','doctor','pichant','lapdoctor') COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `email_verified_at`, `role`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'ahmed', 'ahmed@ahmed.com', NULL, 'superadmin', '$2y$10$nStjt2BKBEWtUDFRo9hf6O5DseGh/xsk.zXkxrPnT2Zsjose31Sni', NULL, '2020-11-11 21:51:19', '2020-11-11 21:51:19'),
(2, 'maca', 'maca@maca.com', NULL, 'hosptaladmin', '$2y$10$SaBR7HPyDax2kGLNaZe7/.ca2ZV/AMaAm6RQCQwK4plFCepFWozAq', NULL, '2020-11-11 21:51:50', '2020-11-11 21:51:50'),
(3, 'Ahmed Aile Kamal', 'g', NULL, 'pichant', 'g', NULL, NULL, NULL),
(4, 'a', 'a', NULL, 'pichant', 'a', NULL, NULL, NULL),
(5, 'ALYA', 'alya@alya.co', NULL, 'hosptaladmin', '$2y$10$olX6QqtO5NiD7mZdPn2DNOCs12BJBHXtWYqMpg7JAp7vJPDBlfroq', NULL, '2020-11-11 22:27:23', '2020-11-11 22:27:23'),
(6, 'Mohmed Abd Aluhaa', 'mohamed@mohmed.com', NULL, 'doctor', '$2y$10$D.snJIe2LLGAnNZIiM1uwOXd/UtKOpq12C3ZYpQ2X35tlKIzFpE9q', NULL, '2020-11-11 22:32:55', '2020-11-11 22:32:55'),
(7, 'Omar Motasim', 'omer@omer.com', NULL, 'lapdoctor', '$2y$10$NdthxSswqrF2fDddXWKfW.jwnGdnNFRayRTdp/jOK3yN4rBH4UyrO', NULL, '2020-11-11 22:34:53', '2020-11-11 22:34:53'),
(8, 'osman', 'os@os.com', NULL, 'superadmin', '$2y$10$7x3TNvIgLdXCaAjcQVSCOufGYkm6eVFfK.73VbIPAyAA.5PAIWbv2', NULL, '2020-11-11 22:39:21', '2020-11-11 22:39:21'),
(10, 'Ø§Ø§Øª', 'hh', NULL, 'pichant', '1', NULL, NULL, NULL),
(11, 'Ø§Ø­Ù…Ø¯', 'mog', NULL, 'pichant', 'm', NULL, NULL, NULL),
(12, 'Om', 't', NULL, 'pichant', 't', NULL, NULL, NULL),
(13, 'rt', 'fg', NULL, 'pichant', 'f', NULL, NULL, NULL),
(14, 'rt', 'fggg', NULL, 'pichant', 'g', NULL, NULL, NULL),
(15, 'Ahmed', 'uui', NULL, 'pichant', 'u', NULL, NULL, NULL),
(19, 'Ahmed', 'uuih', NULL, 'pichant', 'u', NULL, NULL, NULL),
(20, 'tyty', 'tyy', NULL, 'pichant', 'p', NULL, NULL, NULL),
(21, 'Yas', 'yas', NULL, 'pichant', 'yu', NULL, NULL, NULL),
(22, 'Talal', 'Tal@y', NULL, 'pichant', 't', NULL, NULL, NULL),
(23, 'Talal', 'Tal@yt', NULL, 'pichant', 't', NULL, NULL, NULL),
(24, 'omar', 'omppl', NULL, 'pichant', 'p', NULL, NULL, NULL),
(25, 'Yuu', 'yu', NULL, 'pichant', 'y', NULL, NULL, NULL),
(26, 'ty', 'uuuuuio', NULL, 'pichant', 'p', NULL, NULL, NULL),
(27, 'huhu', 'ioop', NULL, 'pichant', 'i', NULL, NULL, NULL),
(28, 'huhu', 'ioopyu', NULL, 'pichant', 'i', NULL, NULL, NULL),
(29, 'ghy', 'uu7', NULL, 'pichant', '7', NULL, NULL, NULL),
(30, 'yy', 'hhvb', NULL, 'pichant', 'l', NULL, NULL, NULL),
(31, 'Esam Ail Yassen', 'ney44', NULL, 'pichant', '5', NULL, NULL, NULL),
(32, 'gh', 'hhqw', NULL, 'pichant', 'hh', NULL, NULL, NULL),
(33, 'tyy', 'hhrtr', NULL, 'pichant', 'uu', NULL, NULL, NULL),
(34, 'hh', 'jjv', NULL, 'pichant', 'gg', NULL, NULL, NULL),
(35, 'Ahmed', 'hui', NULL, 'pichant', 'h', NULL, NULL, NULL),
(36, 'Mosa', 'mos@yuuu.com', NULL, 'pichant', 'm', NULL, NULL, NULL),
(37, 'Motasim', 'motas@yahoo.com', NULL, 'pichant', 'm', NULL, NULL, NULL),
(38, 'gg', 'hhhujjj', NULL, 'pichant', 'j', NULL, NULL, NULL),
(39, 'jj', 'jko', NULL, 'pichant', 'o', NULL, NULL, NULL),
(40, 'Ahmed Abd Aldaim', 'ahmedneymar238752@gmail.com', NULL, 'pichant', 'ah', NULL, NULL, NULL),
(41, 'mohamed', 'mohy@yahoo.com', NULL, 'pichant', 'm12345', NULL, NULL, NULL),
(42, 'bhhh', 'hiskfj', NULL, 'pichant', '8', NULL, NULL, NULL),
(43, 'bhjj', 'ii', NULL, 'pichant', 'ui', NULL, NULL, NULL),
(44, 'MÃ²tasim Emad', 'motasim@gmail.com', NULL, 'pichant', 'mot123', NULL, NULL, NULL),
(45, 'Ø§Ù†Ù†', 'nkk', NULL, 'pichant', 'u', NULL, NULL, NULL),
(46, 'yu', 'iuu', NULL, 'pichant', 'o', NULL, NULL, NULL),
(47, 'yy', 'iii', NULL, 'pichant', 'p', NULL, NULL, NULL),
(48, 'yu', 'jo', NULL, 'pichant', 'm', NULL, NULL, NULL),
(49, 'u', 'ijj', NULL, 'pichant', 'u', NULL, NULL, NULL),
(50, 'Ahmed Ail', 'ahmedneymar23875@gmail.com', NULL, 'pichant', 'a', NULL, NULL, NULL),
(51, 'Kamka', 'kamll@gmail.com', NULL, 'pichant', 'm', NULL, NULL, NULL),
(52, 'Aj', 'aj.com', NULL, 'pichant', 'j.', NULL, NULL, NULL),
(53, 'hj', 'jj', NULL, 'pichant', 'j', NULL, NULL, NULL),
(54, 'hj', 'jjjio', NULL, 'pichant', 'h', NULL, NULL, NULL),
(55, 'yih', 'kkkiiiu', NULL, 'pichant', 'l', NULL, NULL, NULL),
(56, 'Neymar', 'ney.com', NULL, 'pichant', 'k', NULL, NULL, NULL),
(57, 'ahmed', 'jkjk', NULL, 'pichant', 'j', NULL, NULL, NULL),
(58, 'Salam', 'sam.com', NULL, 'pichant', 'm', NULL, NULL, NULL),
(59, 'hh', 'hhtt', NULL, 'pichant', 'hh', NULL, NULL, NULL),
(60, 'hh', 'hhttf', NULL, 'pichant', 'uu', NULL, NULL, NULL),
(61, 'h', 'hlp', NULL, 'pichant', 'l', NULL, NULL, NULL),
(62, 'hh', 'hhc', NULL, 'pichant', 'q', NULL, NULL, NULL),
(63, 'j', 'k', NULL, 'pichant', 'l', NULL, NULL, NULL),
(64, 'hjaks', 'ln', NULL, 'pichant', 'l', NULL, NULL, NULL),
(65, 'hj', 'j2iwikw', NULL, 'pichant', 'i', NULL, NULL, NULL),
(66, 'Motasim Emad', 'motasim23@yahoo.com', NULL, 'pichant', 'mot', NULL, NULL, NULL),
(67, 'motasim', 'jjjllpl', NULL, 'pichant', 'm', NULL, NULL, NULL),
(68, 'Hsjksjjuu', 'jsksksUu', NULL, 'pichant', 'aa', NULL, NULL, NULL),
(69, 'hsjjs', 'hjj', NULL, 'pichant', 'j', NULL, NULL, NULL),
(70, 'mota', 'mop@gmail.com', NULL, 'pichant', 'p', NULL, NULL, NULL),
(71, 'Yassien', 'omar', NULL, 'pichant', 'o', NULL, NULL, NULL),
(72, 'u', 'yyoo', NULL, 'pichant', 'u', NULL, NULL, NULL),
(73, 'Faris Mohammed', 'faris@gmail.com', NULL, 'pichant', 'f', NULL, NULL, NULL),
(74, 'Yasieen omarr', 'yiiii', NULL, 'pichant', 'y', NULL, NULL, NULL),
(75, 'hejejjs', 'hhkaka', NULL, 'pichant', 'l', NULL, NULL, NULL),
(76, 'neieike', 'mwkwkekkskwow', NULL, 'pichant', 'l', NULL, NULL, NULL),
(77, 'Mohammed Ail', 'moh@yaujsm', NULL, 'pichant', 'm', NULL, NULL, NULL),
(78, 'nzkdkdl', 'hhhkllll', NULL, 'pichant', 'l', NULL, NULL, NULL),
(79, 'Motasim Emad Ahmed', 'motats@yahoo.com', NULL, 'pichant', 'm', NULL, NULL, NULL),
(80, 'Tas', 'tppp', NULL, 'pichant', 't', NULL, NULL, NULL),
(81, 'hqijw', 'jakwkwmk', NULL, 'pichant', 'k', NULL, NULL, NULL),
(82, 'jdk', 'kiii', NULL, 'pichant', 'l', NULL, NULL, NULL),
(83, 'hahajja', 'iipp', NULL, 'pichant', 'p', NULL, NULL, NULL),
(84, 'Ahms', 'loplp', NULL, 'pichant', 'p', NULL, NULL, NULL),
(85, 'hajak', 'hdjkd', NULL, 'pichant', 'k', NULL, NULL, NULL),
(86, 'jaksk', 'jkkalla', NULL, 'pichant', 'l', NULL, NULL, NULL),
(87, 'hajajja', 'jakakak', NULL, 'pichant', 'l', NULL, NULL, NULL),
(88, 'ÙˆØ¨Ù†ÙŠØ²', 'hndkdkdk', NULL, 'pichant', 'h', NULL, NULL, NULL),
(89, 'hsjskksHjz', 'hndkdkdkjsk', NULL, 'pichant', 'h', NULL, NULL, NULL),
(90, 'Jamal Araaf', 'nakak', NULL, 'pichant', 'k', NULL, NULL, NULL),
(91, 'Talal', 'tya@yahoo.com', NULL, 'pichant', 't', NULL, NULL, NULL),
(92, '1', '', NULL, 'superadmin', '', NULL, NULL, NULL),
(93, 'hsjjsk', 'jsksks', NULL, 'pichant', 'j', NULL, NULL, NULL),
(94, 'Maca', 'mac@gmail.com', '2020-12-17 08:00:00', 'hosptaladmin', '$2y$10$SaBR7HPyDax2kGLNaZe7/.ca2ZV/AMaAm6RQCQwK4plFCepFWozAq', NULL, NULL, NULL),
(95, 'yaser', 'ahmll', NULL, 'pichant', 'j', NULL, NULL, NULL),
(96, 'hahaj', 'uppp', NULL, 'pichant', 'u', NULL, NULL, NULL),
(97, 'Yaser', 'yyakkk', NULL, 'pichant', 'p', NULL, NULL, NULL),
(98, 'Hasham', 'hasham@yahoo.com', NULL, 'pichant', 'h', NULL, NULL, NULL),
(99, 'Ø²ÙŠÙ†', 'hhhau', NULL, 'pichant', 'u', NULL, NULL, NULL),
(100, 'Ahmed omar', 'ahuh@yahoo.com', NULL, 'pichant', 'a', NULL, NULL, NULL),
(101, 'hhsj', 'jskskkskd', NULL, 'pichant', 'o', NULL, NULL, NULL),
(102, 'hej', 'jkak', NULL, 'pichant', 'k', NULL, NULL, NULL),
(103, 'hje', 'ebjej', NULL, 'pichant', 'k', NULL, NULL, NULL),
(104, 'jajaj', 'iiaija', NULL, 'pichant', 'o', NULL, NULL, NULL),
(105, 'jjsks', 'ksksks', NULL, 'pichant', 'm', NULL, NULL, NULL),
(106, 'hajja', 'skksks', NULL, 'pichant', 'a', NULL, NULL, NULL),
(107, 'Yayah', 'yuaj', NULL, 'pichant', 'a', NULL, NULL, NULL),
(108, 'ayahja', 'ajjaj', NULL, 'pichant', 'h', NULL, NULL, NULL),
(109, 'bznzn', 'kkks', NULL, 'pichant', 'l', NULL, NULL, NULL),
(110, 'jxjx', 'jdj.comj', NULL, 'pichant', 'j', NULL, NULL, NULL),
(111, 'hjaj', 'mamma', NULL, 'pichant', 'm', NULL, NULL, NULL),
(112, 'Hjsjs', 'uash', NULL, 'pichant', 'u', NULL, NULL, NULL),
(113, 'Ahmed', 'uip', NULL, 'pichant', 'i', NULL, NULL, NULL),
(114, 'hjs', 'kksk', NULL, 'pichant', 'k', NULL, NULL, NULL),
(115, 'neymar', 'ney@hhja.com', NULL, 'pichant', 'm', NULL, NULL, NULL),
(116, 'hjsk', 'jskms', NULL, 'pichant', 'k', NULL, NULL, NULL),
(117, 'jjak', 'jkk', NULL, 'pichant', 'kk', NULL, NULL, NULL),
(118, 'jjak', 'jkkjzjzj', NULL, 'pichant', 'jk', NULL, NULL, NULL),
(119, 'yay', 'yooo', NULL, 'pichant', 'y', NULL, NULL, NULL),
(120, '65xkk', 'jkaka', NULL, 'pichant', 'l', NULL, NULL, NULL),
(121, 'jjak', 'kskks', NULL, 'pichant', 'i', NULL, NULL, NULL),
(122, 'Ahmed Abd Aldaaem', 'ahmed567@yahoo.com', NULL, 'pichant', 'o', NULL, NULL, NULL),
(123, 'hhuj', 'hhuih', NULL, 'pichant', 'i', NULL, NULL, NULL),
(124, 'Yaser', 'yas@yahoo.com', NULL, 'pichant', 'yy', NULL, NULL, NULL),
(125, 'Khaled', 'khalied@mohmed.com', NULL, 'lapdoctor', '$2y$10$OiqTfphiW/.rKHLixZTMJOx7B87vHRH31obhjSD1a5SPYufmoEfGy', NULL, '2020-12-02 06:00:55', '2020-12-02 06:00:55'),
(126, 'Yaser', 'yass@yahoo.com', NULL, 'pichant', 'y', NULL, NULL, NULL),
(127, 'Ahmed Salah', 'ahm@yahoo.com', NULL, 'pichant', 'a', NULL, NULL, NULL),
(128, 'Omar zain', 'omar@yahoo.com', NULL, 'pichant', 'm', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `worktimes`
--

CREATE TABLE `worktimes` (
  `id` int(10) UNSIGNED NOT NULL,
  `doctorhospital_id` int(10) UNSIGNED NOT NULL,
  `day` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `from` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `to` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `worktimes`
--

INSERT INTO `worktimes` (`id`, `doctorhospital_id`, `day`, `from`, `to`, `created_at`, `updated_at`) VALUES
(9, 2, 'Wednesday', '4:00AM', '17:00PM', NULL, NULL),
(12, 2, 'Saturday', '8', '19', NULL, NULL),
(13, 2, 'Tuesday', '15:00AM', '00:00PM', NULL, NULL),
(14, 2, 'Thursday', '6:00AM', '18:30PM', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`id`),
  ADD KEY `doctors_user_id_foreign` (`user_id`),
  ADD KEY `doctors_speshalty_id_foreign` (`speshalty_id`);

--
-- Indexes for table `doctor_hospital`
--
ALTER TABLE `doctor_hospital`
  ADD PRIMARY KEY (`id`),
  ADD KEY `doctor_hospital_doctor_id_foreign` (`doctor_id`),
  ADD KEY `doctor_hospital_hospital_id_foreign` (`hospital_id`);

--
-- Indexes for table `examinations`
--
ALTER TABLE `examinations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `examinations_interview_id_foreign` (`interview_id`),
  ADD KEY `examinations_hospital_id_foreign` (`hospital_id`);

--
-- Indexes for table `failed_jobs`
--
ALTER TABLE `failed_jobs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hospitals`
--
ALTER TABLE `hospitals`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hospital_user`
--
ALTER TABLE `hospital_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hospital_user_user_id_foreign` (`user_id`),
  ADD KEY `hospital_user_hospital_id_foreign` (`hospital_id`);

--
-- Indexes for table `interviews`
--
ALTER TABLE `interviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `interviews_pichant_id_foreign` (`pichant_id`),
  ADD KEY `interviews_doctor_id_foreign` (`doctor_id`);

--
-- Indexes for table `labdoctors`
--
ALTER TABLE `labdoctors`
  ADD PRIMARY KEY (`id`),
  ADD KEY `labdoctors_user_id_foreign` (`user_id`),
  ADD KEY `labdoctors_hospital_id_foreign` (`hospital_id`);

--
-- Indexes for table `medicines`
--
ALTER TABLE `medicines`
  ADD PRIMARY KEY (`id`),
  ADD KEY `medicines_interview_id_foreign` (`interview_id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`);

--
-- Indexes for table `pichants`
--
ALTER TABLE `pichants`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pichants_user_id_foreign` (`user_id`);

--
-- Indexes for table `speshalties`
--
ALTER TABLE `speshalties`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- Indexes for table `worktimes`
--
ALTER TABLE `worktimes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `worktimes_doctorhospital_id_foreign` (`doctorhospital_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctors`
--
ALTER TABLE `doctors`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `doctor_hospital`
--
ALTER TABLE `doctor_hospital`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `examinations`
--
ALTER TABLE `examinations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `failed_jobs`
--
ALTER TABLE `failed_jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hospitals`
--
ALTER TABLE `hospitals`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `hospital_user`
--
ALTER TABLE `hospital_user`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `interviews`
--
ALTER TABLE `interviews`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=182;

--
-- AUTO_INCREMENT for table `labdoctors`
--
ALTER TABLE `labdoctors`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `medicines`
--
ALTER TABLE `medicines`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `pichants`
--
ALTER TABLE `pichants`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=178;

--
-- AUTO_INCREMENT for table `speshalties`
--
ALTER TABLE `speshalties`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;

--
-- AUTO_INCREMENT for table `worktimes`
--
ALTER TABLE `worktimes`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `doctors`
--
ALTER TABLE `doctors`
  ADD CONSTRAINT `doctors_speshalty_id_foreign` FOREIGN KEY (`speshalty_id`) REFERENCES `speshalties` (`id`),
  ADD CONSTRAINT `doctors_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `doctor_hospital`
--
ALTER TABLE `doctor_hospital`
  ADD CONSTRAINT `doctor_hospital_doctor_id_foreign` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  ADD CONSTRAINT `doctor_hospital_hospital_id_foreign` FOREIGN KEY (`hospital_id`) REFERENCES `hospitals` (`id`);

--
-- Constraints for table `examinations`
--
ALTER TABLE `examinations`
  ADD CONSTRAINT `examinations_hospital_id_foreign` FOREIGN KEY (`hospital_id`) REFERENCES `hospitals` (`id`),
  ADD CONSTRAINT `examinations_interview_id_foreign` FOREIGN KEY (`interview_id`) REFERENCES `interviews` (`id`);

--
-- Constraints for table `hospital_user`
--
ALTER TABLE `hospital_user`
  ADD CONSTRAINT `hospital_user_hospital_id_foreign` FOREIGN KEY (`hospital_id`) REFERENCES `hospitals` (`id`),
  ADD CONSTRAINT `hospital_user_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `interviews`
--
ALTER TABLE `interviews`
  ADD CONSTRAINT `interviews_doctor_id_foreign` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  ADD CONSTRAINT `interviews_pichant_id_foreign` FOREIGN KEY (`pichant_id`) REFERENCES `pichants` (`id`);

--
-- Constraints for table `labdoctors`
--
ALTER TABLE `labdoctors`
  ADD CONSTRAINT `labdoctors_hospital_id_foreign` FOREIGN KEY (`hospital_id`) REFERENCES `hospitals` (`id`),
  ADD CONSTRAINT `labdoctors_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `medicines`
--
ALTER TABLE `medicines`
  ADD CONSTRAINT `medicines_interview_id_foreign` FOREIGN KEY (`interview_id`) REFERENCES `interviews` (`id`);

--
-- Constraints for table `pichants`
--
ALTER TABLE `pichants`
  ADD CONSTRAINT `pichants_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `worktimes`
--
ALTER TABLE `worktimes`
  ADD CONSTRAINT `worktimes_doctorhospital_id_foreign` FOREIGN KEY (`doctorhospital_id`) REFERENCES `doctor_hospital` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
