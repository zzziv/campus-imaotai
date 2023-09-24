DROP TABLE IF EXISTS `applet_user`;
create table applet_user
(
    applet_user_id bigint AUTO_INCREMENT COMMENT '用户id' PRIMARY KEY,
    mobile  bigint default null COMMENT '用户手机号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='微信小程序用户表';

DROP TABLE IF EXISTS `applet_platform`;
create table applet_platform
(
    applet_platform_id varchar(256) default  null comment '小程序平台ID',
    applet_name varchar(256) default  null comment '小程序名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='微信小程序平台表';

DROP TABLE IF EXISTS `user_applet_platform`;
create table user_applet_platform
(
    applet_platform_id varchar(256) default  null comment '小程序平台ID',
    mobile  bigint default null COMMENT '用户手机号',
    token varchar(255) DEFAULT NULL COMMENT 'toekn',
    cookie varchar(255) DEFAULT NULL COMMENT 'cookie',
    expire_time datetime DEFAULT NULL COMMENT '到期时间',
    device_id varchar(50) DEFAULT NULL COMMENT '设备id'

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='微信用户小程序平台参数表';


DROP TABLE IF EXISTS `user_reserve_log`;
create table user_reserve_log
(
    applet_platform_id varchar(256) default  null comment '小程序平台ID',
    mobile  bigint default null COMMENT '用户手机号',
    reserve_result varchar(2046) DEFAULT NULL COMMENT '预约结果',
    reserve_time datetime DEFAULT NULL COMMENT '预约时间'

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='微信用户小程序平台预约记录表';

