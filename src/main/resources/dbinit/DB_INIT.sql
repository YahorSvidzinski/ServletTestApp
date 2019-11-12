USE `db`;

CREATE TABLE students (
                          id BIGINT(20) NOT NULL AUTO_INCREMENT,
                          firstName VARCHAR(255) NOT NULL,
                          lastName VARCHAR(255 )NOT NULL,
                          PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;
