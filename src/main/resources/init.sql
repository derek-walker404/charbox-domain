-- -----------------------------------------------------
-- Table `connection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `connection` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `isp` VARCHAR(45) NULL DEFAULT NULL,
  `ip` VARCHAR(45) NULL DEFAULT NULL,
  `exp_speed` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_isp` (`isp` ASC),
  INDEX `idx_ip` (`ip` ASC),
  INDEX `idx_exp_sorta` (`exp_speed` ASC),
  INDEX `idx_exp_sortd` (`exp_speed` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `connection_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `connection_info` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `connection_id` INT(11) NOT NULL,
  `location_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_conn_loc` (`connection_id` ASC, `location_id` ASC),
  INDEX `fk_loc_idx` (`location_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `device_auth`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `device_auth` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `device_id` INT(11) NOT NULL,
  `key` VARCHAR(45) NOT NULL,
  `activated` TINYINT(4) NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `device_id_UNIQUE` (`device_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

INSERT INTO device_auth (`id`, `device_id`, `key`, `activated`) VALUES (1, 1, 'asdf1234', 1);
INSERT INTO device_auth (`id`, `device_id`, `key`, `activated`) VALUES (2, 2, 'asdf1234', 1);

-- -----------------------------------------------------
-- Table `device_configs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `device_configs` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `device_id` INT(11) NULL DEFAULT NULL,
  `version` INT(11) NULL DEFAULT NULL,
  `registered` TINYINT(4) NULL DEFAULT NULL,
  `schedules` BLOB NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_did` (`device_id` ASC),
  INDEX `fk_version_idx` (`version` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

INSERT INTO device_configs (`id`, `device_id`, `version`, `registered`, `schedules`) VALUES (1, 1, 1, 0, '{}');
INSERT INTO device_configs (`id`, `device_id`, `version`, `registered`, `schedules`) VALUES (2, 2, 1, 0, '{}');


-- -----------------------------------------------------
-- Table `devices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devices` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL DEFAULT 'New Device',
  PRIMARY KEY (`id`),
  INDEX `idx_name` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

INSERT INTO devices (`id`, `name`) values (1, 'test-dev-1');
INSERT INTO devices (`id`, `name`) values (2, 'test-dev-2');


-- -----------------------------------------------------
-- Table `heartbeat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heartbeat` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `device_id` INT(11) NOT NULL,
  `time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ci_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_did` (`device_id` ASC),
  INDEX `idx_time_sorta` (`time` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `location` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `continent` VARCHAR(45) NULL DEFAULT NULL,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `subdivision` VARCHAR(45) NULL DEFAULT NULL,
  `zip` VARCHAR(45) NULL DEFAULT NULL,
  `lat` FLOAT NULL DEFAULT NULL,
  `lon` FLOAT NULL DEFAULT NULL,
  `timezone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `outage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outage` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `device_id` INT(11) NULL DEFAULT NULL,
  `start_time` TIMESTAMP NULL DEFAULT NULL,
  `end_time` TIMESTAMP NULL DEFAULT NULL,
  `duration` INT(11) NULL DEFAULT NULL,
  `confirmed` TINYINT(4) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `connection_info_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_start_time_sortd` (`start_time` ASC),
  INDEX `idx_duration_sortd` (`duration` ASC),
  INDEX `idx_conn` (`connection_info_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ping` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `device_id` INT(11) NOT NULL,
  `connection_id` INT(11) NOT NULL,
  `server_location_id` INT(11) NOT NULL,
  `start_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `url` VARCHAR(255) NOT NULL,
  `packet_loss` FLOAT NULL DEFAULT NULL,
  `min_latency` FLOAT NULL DEFAULT NULL,
  `avg_latency` FLOAT NULL DEFAULT NULL,
  `max_latency` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_did` (`device_id` ASC),
  INDEX `idx_cid` (`connection_id` ASC),
  INDEX `idx_lid` (`server_location_id` ASC),
  INDEX `idx_start_time_sortd` (`start_time` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `server_auth`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `server_auth` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `server_id` VARCHAR(45) NOT NULL,
  `service_name` VARCHAR(45) NOT NULL,
  `key` VARCHAR(45) NOT NULL,
  `activated` TINYINT(4) NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `server_id_UNIQUE` (`server_id` ASC),
  INDEX `idx_sid_name_key` (`server_id` ASC, `service_name` ASC, `key` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

INSERT INTO server_auth (`id`, `server_id`, `service_name`, `key`, `activated`) VALUES (1, 'test-sst-00', 'sst', 'asdf123', 1);
INSERT INTO server_auth (`id`, `server_id`, `service_name`, `key`, `activated`) VALUES (2, 'client-installer-charbot', 'install', '4wt589jhergfh3', 1);


-- -----------------------------------------------------
-- Table `simple_location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple_location` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ip` VARCHAR(45) NULL DEFAULT NULL,
  `lat` FLOAT NULL DEFAULT NULL,
  `lon` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_ip` (`ip` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sst`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sst` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `device_id` INT(11) NULL DEFAULT NULL,
  `token` VARCHAR(45) NULL DEFAULT NULL,
  `start_time` TIMESTAMP NULL DEFAULT NULL,
  `down_size` BIGINT(20) NULL DEFAULT NULL,
  `down_duration` INT(11) NULL DEFAULT NULL,
  `down_speed` FLOAT NULL DEFAULT NULL,
  `up_size` BIGINT(20) NULL DEFAULT NULL,
  `up_duration` INT(11) NULL DEFAULT NULL,
  `up_speed` FLOAT NULL DEFAULT NULL,
  `ping_duration` INT(11) NULL DEFAULT NULL,
  `device_conn_id` INT(11) NULL DEFAULT NULL,
  `server_loc_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_did` (`device_id` ASC),
  INDEX `idx_start_time_sortd` (`start_time` ASC),
  INDEX `idx_down_sp_sortd` (`down_speed` ASC),
  INDEX `idx_up_sp_sortd` (`up_speed` ASC),
  INDEX `idx_dcid` (`device_conn_id` ASC),
  INDEX `idx_slid` (`server_loc_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `token_auth`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `token_auth` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `expiration` TIMESTAMP NULL DEFAULT NULL,
  `token` VARCHAR(45) NULL DEFAULT NULL,
  `asset_id` INT(11) NULL DEFAULT NULL,
  `service_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_expiration` (`expiration` ASC),
  INDEX `idx_token_asset_service` (`token` ASC, `asset_id` ASC, `service_name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `udev`
-- -----------------------------------------------------
CREATE TABLE `udev` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `device_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_uid_did` (`user_id` ASC, `device_id` ASC));
  

-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------  
CREATE TABLE `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `pass_hash` VARCHAR(100) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT 'New User',
  PRIMARY KEY (`id`),
  INDEX `idx_email_ph` (`email` ASC, `pass_hash` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));


-- -----------------------------------------------------
-- Table `versions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `versions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `version` VARCHAR(45) NOT NULL,
  `sort` BIGINT(20) NOT NULL,
  `install_script_url` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_sort` (`sort` ASC),
  INDEX `idx_version` (`version` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

INSERT INTO versions (`id`, `version`, `sort`, `install_script_url`) VALUES (1, '0.0.0', 4, '');
