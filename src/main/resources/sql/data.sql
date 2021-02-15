DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(100) NULL,
`description` VARCHAR(800) NULL,
PRIMARY KEY (`id`)
);

ALTER TABLE `product`
ADD COLUMN `category_id` BIGINT NULL;

INSERT INTO `category`
(`id`,`name`,`description`)
VALUES
(1,'Kategoria 1','Opis 1'),
(2,'Kategoria 2','Opis 2'),
(3,'Kategoria 3','Opis 3');

Update product set category_id=1 where id=3;
Update product set category_id=2 where id=4;
Update product set category_id=3 where id=5;