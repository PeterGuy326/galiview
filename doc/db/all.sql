-- 课程
drop table if exists course;
create table course
(
    id         char(8)     not null default '' comment 'id',
    name       varchar(50) not null comment '名称',
    summary    varchar(2000) comment '概述',
    time       int                  default 0 comment '时长|单位秒',
    price      decimal(8, 2)        default 0.00 comment '价格（元）',
    image      varchar(100) comment '封面',
    level      char(1) comment '级别|ONE("1", "初级"),TWO("2", "中级"),THREE("3", "高级")',
    charge     char(1) comment '收费|CHARGE("C", "收费"),FREE("F", "免费")',
    status     char(1) comment '状态|PUBLISH("P", "发布"),DRAFT("D", "草稿")',
    enroll     integer              default 0 comment '报名数',
    sort       int comment '顺序',
    created_at datetime(3) comment '创建时间',
    updated_at datetime(3) comment '修改时间',
    primary key (id)
) engine = innodb
  default charset = utf8mb4 comment ='课程';

INSERT INTO course (id, name, summary, time, price, image, level, charge, status, enroll, sort, created_at, updated_at)
VALUES ('00000001', '测试课程01', '这是一门测试课程', 7200, 19.9, '', 0, 'C', 'D', 100, 0, now(), now());

-- 大章
drop table if exists `chapter`;
create table `chapter`
(
    `id`        char(8) not null comment 'ID',
    `course_id` char(8) not null comment '课程ID',
    `name`      char(8) not null comment '名称',
    primary key (`id`)
) engine = InnoDB
  default charset = utf8mb4 comment ='大章';

insert into `chapter` (id, course_id, name)
values ('00000001', '00000000', '测试大章01');
insert into `chapter` (id, course_id, name)
values ('00000002', '00000000', '测试大章02');
insert into `chapter` (id, course_id, name)
values ('00000003', '00000000', '测试大章03');
insert into `chapter` (id, course_id, name)
values ('00000004', '00000000', '测试大章04');
insert into `chapter` (id, course_id, name)
values ('00000005', '00000000', '测试大章05');
insert into `chapter` (id, course_id, name)
values ('00000006', '00000000', '测试大章06');
insert into `chapter` (id, course_id, name)
values ('00000007', '00000000', '测试大章07');
insert into `chapter` (id, course_id, name)
values ('00000008', '00000000', '测试大章08');
insert into `chapter` (id, course_id, name)
values ('00000009', '00000000', '测试大章09');
insert into `chapter` (id, course_id, name)
values ('00000010', '00000000', '测试大章10');
insert into `chapter` (id, course_id, name)
values ('00000011', '00000000', '测试大章11');
insert into `chapter` (id, course_id, name)
values ('00000012', '00000000', '测试大章12');
insert into `chapter` (id, course_id, name)
values ('00000013', '00000000', '测试大章13');
insert into `chapter` (id, course_id, name)
values ('00000014', '00000000', '测试大章14');

-- 小节
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section`
(
    `id`         CHAR(8)     NOT NULL DEFAULT '' COMMENT 'ID',
    `title`      VARCHAR(50) NOT NULL COMMENT '标题',
    `course_id`  CHAR(8) COMMENT '课程|course.id',
    `chapter_id` CHAR(8) COMMENT '大章|chapter.id',
    `video`      VARCHAR(200) COMMENT '视频',
    `time`       INT COMMENT '时长|单位秒',
    `charge`     CHAR(1) COMMENT '收费|C 收费；F 免费',
    `sort`       INT COMMENT '顺序',
    `created_at` DATETIME(3) COMMENT '创建时间',
    `updated_at` DATETIME(3) COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='小节';

INSERT INTO `section` (id, title, course_id, chapter_id, video, time, charge, sort, created_at, updated_at)
VALUES ('00000001', '测试小节01', '00000001', '00000000', '', 500, 'F', 1, now(), now());


############################ 测试
drop table if exists `test`;
create table `test`
(
    `id`   varchar(8) not null default '' comment 'id',
    `name` varchar(50) comment '名称',
    primary key (`id`)
) engine = InnoDB
  default charset = utf8mb4 comment ='测试';

insert into `test` (id, name)
values (1, '测试');
insert into `test` (id, name)
values (2, '测试2');