-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2018 at 06:52 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `igrdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `dailyreport`
--

CREATE TABLE `dailyreport` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `description` varchar(20) NOT NULL,
  `quantity` int(6) NOT NULL,
  `rate` int(4) NOT NULL,
  `amount` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dailyreport`
--

INSERT INTO `dailyreport` (`id`, `date`, `description`, `quantity`, `rate`, `amount`) VALUES
(1, '2018-11-01', 'null', 5, 5, 25),
(2, '2018-11-06', 'Photocopy', 6, 10, 60),
(3, '2018-11-07', 'Photocopy', 12, 10, 120),
(4, '2018-10-30', 'Printing', 45, 10, 450),
(5, '2018-11-05', 'Photocopy', 12, 10, 120),
(6, '2018-11-13', 'Printing', 50, 50, 2500),
(7, '2018-11-05', 'Photocopy', 43, 7, 301),
(8, '2018-11-20', 'Printing', 34, 10, 340),
(9, '2018-10-30', 'Photocopy', 23, 50, 1150),
(10, '2018-11-08', 'Type and Print', 56, 100, 5600),
(11, '2018-11-05', 'Photocopy', 24, 10, 240),
(12, '2018-11-05', 'Printing', 24, 50, 1200),
(13, '2018-11-05', 'Type and Print', 50, 10, 500),
(14, '2018-11-22', 'Type and Print', 12, 70, 840),
(15, '2018-11-22', 'Type and Print', 34, 100, 3400),
(16, '2018-11-25', 'Photocopy', 34, 7, 238),
(17, '2018-11-25', 'Printing', 60, 10, 600);

-- --------------------------------------------------------

--
-- Table structure for table `expenses`
--

CREATE TABLE `expenses` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `expenses` double NOT NULL,
  `bankdep` double NOT NULL,
  `handcash` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expenses`
--

INSERT INTO `expenses` (`id`, `date`, `expenses`, `bankdep`, `handcash`) VALUES
(1, '0000-00-00', 12, 32, 222);

-- --------------------------------------------------------

--
-- Table structure for table `userregtb`
--

CREATE TABLE `userregtb` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(95) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `qualification` varchar(40) NOT NULL,
  `phoneno` varchar(15) NOT NULL,
  `state` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `passport` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userregtb`
--

INSERT INTO `userregtb` (`id`, `name`, `address`, `gender`, `qualification`, `phoneno`, `state`, `username`, `password`, `passport`) VALUES
(1, 'aa', 'sa', 'Male', 'O Level Certificate', 'ss', 'Ondo', 'ss', '11', 0x6a61766166782e7363656e652e696d6167652e5772697461626c65496d616765403738326562316164),
(2, 'sd', 'dd', 'Female', 'BSc', '2322', 'Oyo', 'wwe', 'wwe', 0x6a61766166782e7363656e652e696d6167652e5772697461626c65496d616765403666323635613034),
(3, 'mayor mayowa', 'fedpoly', 'Male', 'Higher National Diploma', '2347037919786', 'Ondo', 'mayor', 'mayor', 0x6a61766166782e7363656e652e696d6167652e5772697461626c65496d616765403230643063323364),
(4, 'ayonitemi', 'fedpoly', 'Female', 'Higher National Diploma', '23333', 'Ondo', 'ayo', 'temi', 0x6a61766166782e7363656e652e696d6167652e5772697461626c65496d616765403738396237653365),
(5, 'ayonitemi', 'abba', 'Female', 'Higher National Diploma', '09095889t', 'Ondo', 'ayo', 'temi', 0x6a61766166782e7363656e652e696d6167652e5772697461626c65496d616765403662323232303366);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dailyreport`
--
ALTER TABLE `dailyreport`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `expenses`
--
ALTER TABLE `expenses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userregtb`
--
ALTER TABLE `userregtb`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dailyreport`
--
ALTER TABLE `dailyreport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `expenses`
--
ALTER TABLE `expenses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `userregtb`
--
ALTER TABLE `userregtb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
