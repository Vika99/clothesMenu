-- liquibase formatted sql

-- changeset vvoronchuk:complex_clothes-table-1

CREATE TABLE `complex_clothes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  `article` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `color` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` char(45) COLLATE utf8_unicode_ci NOT NULL,
  `jeans_t` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tshirt_t` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

