drop table if exists `test`;
create table `test`
(
    `id`   varchar(8) not null default '' comment 'id',
    `name` varchar(50) comment '名称',
    primary key (`id`)
) engine=InnoDB default charset=utf8mb4 comment='测试';

insert into `test` (id, name) values (1, '测试');
insert into `test` (id, name) values (2, '测试2');