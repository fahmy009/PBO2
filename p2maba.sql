-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 03, 2017 at 08:27 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `p2maba`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggotahimasif`
--

CREATE TABLE `anggotahimasif` (
  `id_anggota` int(11) NOT NULL,
  `nim` varchar(25) NOT NULL,
  `jabatan` enum('Ketua Umum','Sekretaris','Bendahara','Kadiv PSDM','Kadiv LITBANG','Kadiv MEDIATEK','Kadiv HUMAS','Kasubdiv KADERISASI','Kasubdiv IM','anggota LITBANG','anggota HUMAS','anggota MEDIATEK','anggota Kaderisasi','anggota IM') NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anggotahimasif`
--

INSERT INTO `anggotahimasif` (`id_anggota`, `nim`, `jabatan`, `id_user`) VALUES
(1, '152410101082', 'Sekretaris', 2),
(8, '152410101096', 'Ketua Umum', 2),
(9, '152410101061', 'Kadiv MEDIATEK', 2),
(10, '152410101070', 'Kadiv LITBANG', 2),
(12, '152410101088', 'Sekretaris', 2);

-- --------------------------------------------------------

--
-- Table structure for table `angkatan`
--

CREATE TABLE `angkatan` (
  `id_angkatan` int(11) NOT NULL,
  `tahun_angkatan` varchar(25) NOT NULL,
  `nama_angkatan` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `angkatan`
--

INSERT INTO `angkatan` (`id_angkatan`, `tahun_angkatan`, `nama_angkatan`) VALUES
(1, '2013', 'Intention'),
(2, '2014', 'Sensation'),
(3, '2015', 'Selection'),
(4, '2016', 'Infinity');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nim` varchar(25) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `alamat` text NOT NULL,
  `agama` enum('Islam','Kristen','Katolik','Hindu','Budha','Konghucu') NOT NULL,
  `nomorHP` varchar(12) DEFAULT NULL,
  `angkatan` enum('Intention','Sensation','Selection','Infinity') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim`, `nama`, `tanggal_lahir`, `alamat`, `agama`, `nomorHP`, `angkatan`) VALUES
('152410101051', 'Haris', '1996-01-22', 'Madura', 'Islam', '08255476693', 'Selection'),
('152410101061', 'Vian Elfada', '1996-11-19', 'Banyuwangi', 'Islam', '082123456789', 'Selection'),
('152410101070', 'Ranggi Rexa Vigor', '1997-06-06', 'Jember', 'Islam', '08255476693', 'Selection'),
('152410101076', 'Moh. Basiruddin', '1996-06-18', 'Banyuwangi', 'Islam', '082332581431', 'Selection'),
('152410101082', 'M. Fahmy Amirun Nizar', '1997-08-17', 'Sukowono', 'Islam', '082330750358', 'Selection'),
('152410101088', 'Gogi Estauri', '1998-06-06', 'Banyuwangi', 'Islam', '08214576691', 'Selection'),
('152410101095', 'M. Ilham Nur A.', '1997-08-15', 'Malang', 'Islam', '082254556878', 'Selection'),
('152410101096', 'Gavin Liffera Kusuma P', '1996-08-15', 'Jember', 'Islam', '082466966855', 'Selection');

-- --------------------------------------------------------

--
-- Table structure for table `pendaftar`
--

CREATE TABLE `pendaftar` (
  `id_pendaftar` int(11) NOT NULL,
  `nim` varchar(25) NOT NULL,
  `alamat_sekarang` text NOT NULL,
  `divisi` enum('Konsumsi','Humas','Pubdekdok','Perlengkapan','Acara') NOT NULL,
  `alasan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `pendaftar`
--

INSERT INTO `pendaftar` (`id_pendaftar`, `nim`, `alamat_sekarang`, `divisi`, `alasan`) VALUES
(1, '152410101096', 'Jl. Kudanil no 57', 'Konsumsi', 'Coba - Coba');

-- --------------------------------------------------------

--
-- Table structure for table `penilaian`
--

CREATE TABLE `penilaian` (
  `id_penilaian` int(11) NOT NULL,
  `id_pendaftar` int(11) NOT NULL,
  `nilai_pengalaman` double DEFAULT NULL,
  `nilai_etika` double DEFAULT NULL,
  `nilai_penampilan` double DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `id_level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `id_level`) VALUES
(1, 'admin', 'admin', 1),
(2, 'pengurus', 'pengurus', 2);

-- --------------------------------------------------------

--
-- Table structure for table `userlevel`
--

CREATE TABLE `userlevel` (
  `id_level` int(11) NOT NULL,
  `level` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userlevel`
--

INSERT INTO `userlevel` (`id_level`, `level`) VALUES
(1, 'admin'),
(2, 'pengurus');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggotahimasif`
--
ALTER TABLE `anggotahimasif`
  ADD PRIMARY KEY (`id_anggota`),
  ADD UNIQUE KEY `nim` (`nim`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `angkatan`
--
ALTER TABLE `angkatan`
  ADD PRIMARY KEY (`id_angkatan`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim`),
  ADD KEY `id_angkatan` (`angkatan`),
  ADD KEY `id_agama` (`agama`);

--
-- Indexes for table `pendaftar`
--
ALTER TABLE `pendaftar`
  ADD PRIMARY KEY (`id_pendaftar`),
  ADD UNIQUE KEY `nim` (`nim`);

--
-- Indexes for table `penilaian`
--
ALTER TABLE `penilaian`
  ADD PRIMARY KEY (`id_penilaian`),
  ADD KEY `id_pendaftar` (`id_pendaftar`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_level` (`id_level`);

--
-- Indexes for table `userlevel`
--
ALTER TABLE `userlevel`
  ADD PRIMARY KEY (`id_level`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anggotahimasif`
--
ALTER TABLE `anggotahimasif`
  MODIFY `id_anggota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `angkatan`
--
ALTER TABLE `angkatan`
  MODIFY `id_angkatan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `pendaftar`
--
ALTER TABLE `pendaftar`
  MODIFY `id_pendaftar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `penilaian`
--
ALTER TABLE `penilaian`
  MODIFY `id_penilaian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `userlevel`
--
ALTER TABLE `userlevel`
  MODIFY `id_level` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `anggotahimasif`
--
ALTER TABLE `anggotahimasif`
  ADD CONSTRAINT `anggotahimasif_ibfk_1` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `anggotahimasif_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pendaftar`
--
ALTER TABLE `pendaftar`
  ADD CONSTRAINT `pendaftar_ibfk_1` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penilaian`
--
ALTER TABLE `penilaian`
  ADD CONSTRAINT `penilaian_ibfk_1` FOREIGN KEY (`id_pendaftar`) REFERENCES `pendaftar` (`id_pendaftar`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_level`) REFERENCES `userlevel` (`id_level`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
