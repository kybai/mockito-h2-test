DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(64) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `description` char(255) DEFAULT NULL,
  `name` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(64) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `password` char(255) DEFAULT NULL,
  `sex` int(32) DEFAULT NULL,
  `user_name` char(255) DEFAULT NULL,
  `department_id` bigint(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;