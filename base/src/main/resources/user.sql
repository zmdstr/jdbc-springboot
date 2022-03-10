CREATE DATABASE /*!32312 IF NOT EXISTS*/`jdbc-springboot` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `jdbc-springboot`;


DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `userName` varchar(50) DEFAULT NULL,
                        `sex` int(11) DEFAULT NULL,
                        `userAddress` varchar(100) DEFAULT NULL,
                        `userAge` int(10) DEFAULT NULL,
                        PRIMARY KEY (`id`) USING BTREE,
                        KEY `age_name` (`sex`,`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert  into `user`(`id`,`userName`,`sex`,`userAddress`,`userAge`) values (1,'李四',1,'杭州',18),(2,'张三',2,'北京',19);
