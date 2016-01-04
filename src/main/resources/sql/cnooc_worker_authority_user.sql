CREATE DATABASE IF NOT EXISTS cnooc_worker_authority /*!40100 DEFAULT CHARACTER SET utf8 */;
USE cnooc_worker_authority;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  uid INT(20) NOT NULL COMMENT '用户ID',
  name VARCHAR(40) NOT NULL COMMENT '用户姓名',
  password VARCHAR(32) NOT NULL COMMENT '密码',
  privilege VARCHAR(8) NOT NULL COMMENT '用户权限',
  PRIMARY KEY (uid)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


/*Data for the table `user` */

INSERT INTO user VALUES ('0001','xinux','901126', 'ADMIN'),('0002','hulda','123456', 'COMMON');
