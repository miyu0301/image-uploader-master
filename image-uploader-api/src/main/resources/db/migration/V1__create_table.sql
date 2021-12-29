DROP TABLE IF EXISTS image;
CREATE TABLE `image` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `image_name` VARCHAR(50) NOT NULL,
  `image_data` BLOB NOT NULL,
  `ins_datetime` DATETIME NOT NULL,
  `upd_datetime` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;