-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 16, 2021 at 07:27 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `patient`
--

-- --------------------------------------------------------

--
-- Table structure for table `diabetes`
--

CREATE TABLE `diabetes` (
  `id` int(5) NOT NULL,
  `value` int(5) NOT NULL,
  `meal` varchar(10) NOT NULL,
  `period` varchar(10) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `diabetes`
--

INSERT INTO `diabetes` (`id`, `value`, `meal`, `period`, `date`) VALUES
(1, 100, 'breakfast', 'before', '2020-12-01'),
(2, 130, 'breaksfast', 'after', '2020-12-01'),
(20, 100, 'kkkk', 'kkkk', '2020-10-10'),
(23, 50, '5', '50', '2020-10-10'),
(24, 50, '5', '50', '2020-12-23'),
(25, 90, 'null', '50', '2020-12-04'),
(26, 100, '50', '50', '2020-12-17'),
(30, 80, 'Lunch', 'Before', '2020-12-14');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `medicine` varchar(20) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`medicine`) VALUES
('ouija'),
('ouija');

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `notes` varchar(20) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notes`
--

INSERT INTO `notes` (`notes`) VALUES
('nnnnn');

-- --------------------------------------------------------

--
-- Table structure for table `pressure`
--

CREATE TABLE `pressure` (
  `id` int(4) NOT NULL,
  `systolic` int(10) NOT NULL,
  `diastolic` int(10) NOT NULL,
  `heartrate` int(10) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pressure`
--

INSERT INTO `pressure` (`id`, `systolic`, `diastolic`, `heartrate`, `date`) VALUES
(50, 50, 50, 50, '2020-12-02'),
(70, 80, 80, 80, '2020-12-09'),
(80, 50, 50, 50, '2021-01-05');

-- --------------------------------------------------------

--
-- Table structure for table `weight`
--

CREATE TABLE `weight` (
  `id` int(5) NOT NULL,
  `height` int(5) NOT NULL DEFAULT 170,
  `weight` int(5) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `weight`
--

INSERT INTO `weight` (`id`, `height`, `weight`, `date`) VALUES
(11, 80, 80, '2020-10-10'),
(15, 80, 80, '2020-12-07'),
(20, 80, 80, '2020-10-10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diabetes`
--
ALTER TABLE `diabetes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pressure`
--
ALTER TABLE `pressure`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `weight`
--
ALTER TABLE `weight`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `diabetes`
--
ALTER TABLE `diabetes`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `pressure`
--
ALTER TABLE `pressure`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- AUTO_INCREMENT for table `weight`
--
ALTER TABLE `weight`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
