
CREATE TABLE IF NOT EXISTS `assignto` (
  `assignto_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `project_name` varchar(75) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `employee_name` varchar(75) NOT NULL,
  `assignedby` varchar(75) NOT NULL,
  `assignby_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bugs`
--

CREATE TABLE IF NOT EXISTS `bugs` (
  `bug_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `priority_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `bug_name` varchar(100) DEFAULT NULL,
  `bug_desc` varchar(200) DEFAULT NULL,
  `resolution` varchar(200) DEFAULT NULL,
  `assigned_by` varchar(75) NOT NULL,
  `assigned_to` int(11) NOT NULL,
  `date_assigned` datetime DEFAULT NULL,
  `date_resolved` datetime DEFAULT NULL,
  `testedby` varchar(75) DEFAULT NULL,
  `testedby_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `developer_master`
--

CREATE TABLE IF NOT EXISTS `developer_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `tech` varchar(45) DEFAULT NULL,
  `team` varchar(45) DEFAULT NULL,
  `pc` int(11) DEFAULT NULL,
  `exp` varchar(45) DEFAULT NULL,
  `rannk` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `developer_master`
--

INSERT INTO `developer_master` (`id`, `name`, `tech`, `team`, `pc`, `exp`, `rannk`, `status`, `email`) VALUES
(1, 'asdas', NULL, 'asdas', 0, '12', 0, 0, 'asdasd'),
(2, 'adasdasdas', NULL, 'asdas', 0, '122134', 0, 0, 'asdasd');

-- --------------------------------------------------------

--
-- Table structure for table `ds_assign_to`
--

CREATE TABLE IF NOT EXISTS `ds_assign_to` (
  `rid` bigint(20) DEFAULT NULL,
  `delevloperId` varchar(500) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ds_bug_disp`
--

CREATE TABLE IF NOT EXISTS `ds_bug_disp` (
  `rid` bigint(20) DEFAULT NULL,
  `bug_disp` varchar(500) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ds_bug_status`
--

CREATE TABLE IF NOT EXISTS `ds_bug_status` (
  `rid` bigint(20) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ds_cc`
--

CREATE TABLE IF NOT EXISTS `ds_cc` (
  `rid` bigint(20) DEFAULT NULL,
  `cc` varchar(45) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ds_componant`
--

CREATE TABLE IF NOT EXISTS `ds_componant` (
  `rid` bigint(20) DEFAULT NULL,
  `componant` varchar(500) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ds_os`
--

CREATE TABLE IF NOT EXISTS `ds_os` (
  `rid` bigint(20) DEFAULT NULL,
  `os` varchar(45) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ds_proarity`
--

CREATE TABLE IF NOT EXISTS `ds_proarity` (
  `rid` bigint(20) DEFAULT NULL,
  `proarity` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ds_product`
--

CREATE TABLE IF NOT EXISTS `ds_product` (
  `rid` bigint(20) DEFAULT NULL,
  `pname` varchar(45) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ds_resolution`
--

CREATE TABLE IF NOT EXISTS `ds_resolution` (
  `rid` bigint(20) DEFAULT NULL,
  `resulution` varchar(45) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ds_sevirity`
--

CREATE TABLE IF NOT EXISTS `ds_sevirity` (
  `rid` bigint(20) DEFAULT NULL,
  `sevirity` varchar(45) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ds_version`
--

CREATE TABLE IF NOT EXISTS `ds_version` (
  `rid` bigint(20) DEFAULT NULL,
  `version` varchar(45) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `priorities`
--

CREATE TABLE IF NOT EXISTS `priorities` (
  `priority_id` int(11) NOT NULL,
  `priority_desc` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE IF NOT EXISTS `projects` (
  `project_id` int(11) NOT NULL,
  `project_name` varchar(50) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `project_master`
--

CREATE TABLE IF NOT EXISTS `project_master` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `bc` int(11) NOT NULL,
  `dc` int(11) NOT NULL,
  `tc` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `project_master`
--

INSERT INTO `project_master` (`id`, `name`, `category`, `bc`, `dc`, `tc`, `status`) VALUES
(1, 'sfdasda', 'wefwefwfsz', 0, 0, 0, 0),
(2, 'qw', 'qwq', 0, 0, 0, 0),
(3, 'asdasd', 'asd', 0, 0, 0, 0),
(4, 'asdasddsf', 'asd', 0, 0, 0, 0),
(7, 'asdasddsfX', 'asd', 0, 0, 0, 0),
(8, 'asdasddsfXd', 'asd', 0, 0, 0, 0),
(9, 'asdasda', 'asdasd', 0, 0, 0, 0),
(10, 'asdasdwqeqweqw', 'asdasd', 0, 0, 0, 0),
(11, 'asdas', 'asdasdasd', 0, 0, 0, 0),
(12, 'asdasasdasdasdwqdw', 'asdasdasd', 0, 0, 0, 0),
(13, 'asdasasdasdasdwqdwasda', 'asdasdasd', 0, 0, 0, 0),
(14, 'asdasd212321', 'asdas', 0, 0, 0, 0),
(17, 'asdasd212321asd', 'asdasasda', 0, 0, 0, 0),
(18, 'asdasd212321asdasd', 'asdasasda', 0, 0, 0, 0),
(19, 'asdasd212321asdasdasd', 'asdasasda', 0, 0, 0, 0),
(20, 'asdasd212321asdasdasdsdf', 'asdasasdasd', 0, 0, 0, 0),
(21, 'asdasd212321asdasdasdsdfadas', 'asdasasdasd', 0, 0, 0, 0),
(22, 'afsh', 'hdxxgc', 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `projmger`
--

CREATE TABLE IF NOT EXISTS `projmger` (
  `projmger_id` varchar(5) DEFAULT NULL,
  `projmger_name` varchar(50) DEFAULT NULL,
  `phoneno` varchar(50) DEFAULT NULL,
  `doj` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `login` varchar(15) DEFAULT NULL,
  `pwd` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `statuses`
--

CREATE TABLE IF NOT EXISTS `statuses` (
  `status_id` int(11) NOT NULL,
  `status` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tester`
--

CREATE TABLE IF NOT EXISTS `tester` (
  `tester_id` varchar(5) DEFAULT NULL,
  `tester_name` varchar(50) DEFAULT NULL,
  `phoneno` varchar(50) DEFAULT NULL,
  `doj` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `login` varchar(15) DEFAULT NULL,
  `pwd` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
