--
-- Table structure for `tbl_country`
--

CREATE TABLE IF NOT EXISTS `tbl_country` (
  `id`                  BIGINT NOT NULL AUTO_INCREMENT,
  `created_by`          VARCHAR(255) NOT NULL,
  `created_date`        DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_by`    VARCHAR(255) NOT NULL,
  `last_modified_date`  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name`                VARCHAR(255) NOT NULL,
  `alpha2`              VARCHAR(2) NOT NULL,
  `alpha3`              VARCHAR(3) NOT NULL,
  `visible`             TINYINT NOT NULL DEFAULT '1',
  `deleted`             TINYINT NOT NULL DEFAULT '0',
  CONSTRAINT `pk_country` PRIMARY KEY (`id`),
  CONSTRAINT `uk_country_alpha2` UNIQUE KEY (`alpha2`),
  CONSTRAINT `uk_country_alpha3` UNIQUE KEY (`alpha3`),
  CONSTRAINT `uk_country_name` UNIQUE KEY (`name`)
);