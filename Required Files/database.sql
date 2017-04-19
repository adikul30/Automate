create table light (light int ,fan int, dummy int primary key)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
insert into light values (0,0,29);
ALTER TABLE light MODIFY dummy int unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
