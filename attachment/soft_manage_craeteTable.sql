i??prompt PL/SQL Developer Export Tables for user STUDY@DG_MES_DV
prompt Created by LIZONG.WEI on 2019�~4��12��
set feedback off
set define off

prompt Creating TWEI_API...
create table TWEI_API
(
  api_type_id      VARCHAR2(15) not null,
  api_id           NUMBER not null,
  api_name         VARCHAR2(50) not null,
  api_desc         VARCHAR2(200) not null,
  api_url          VARCHAR2(100) not null,
  api_method       VARCHAR2(100),
  request_example  VARCHAR2(500),
  response_example VARCHAR2(500),
  fault_example    VARCHAR2(500),
  create_by        VARCHAR2(20),
  create_at        DATE,
  update_by        VARCHAR2(20),
  update_at        DATE,
  data_version     NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TWEI_API
  add constraint TWEI_API_ID primary key (API_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_API_CODE...
create table TWEI_API_CODE
(
  code_id      VARCHAR2(20) not null,
  code_name    VARCHAR2(20) not null,
  definition   VARCHAR2(200),
  api_id       VARCHAR2(15),
  code_type    VARCHAR2(10),
  create_by    VARCHAR2(20),
  create_at    DATE,
  update_by    VARCHAR2(20),
  update_at    DATE,
  data_version NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_API_PARA...
create table TWEI_API_PARA
(
  api_id         NUMBER not null,
  para_id        NUMBER not null,
  para_name      VARCHAR2(20) not null,
  para_type      VARCHAR2(10),
  para_data_type VARCHAR2(10),
  is_nullable    NUMBER(1) default 0,
  para_memo      VARCHAR2(200),
  parent_para_id NUMBER,
  create_by      VARCHAR2(20),
  create_at      DATE,
  update_by      VARCHAR2(20),
  update_at      DATE,
  data_version   NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_API_TYPE...
create table TWEI_API_TYPE
(
  api_type_id   NUMBER not null,
  api_type_name VARCHAR2(50) not null,
  api_type_memo VARCHAR2(200),
  create_by     VARCHAR2(20),
  create_at     DATE,
  update_by     VARCHAR2(20),
  update_at     DATE,
  data_version  NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_APP_LOG...
create table TWEI_APP_LOG
(
  log_id      NUMBER,
  log_type    VARCHAR2(10),
  log_content VARCHAR2(4000),
  log_at      DATE,
  log_by      VARCHAR2(20),
  log_result  VARCHAR2(4000)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_AUTH...
create table TWEI_AUTH
(
  auth_id        VARCHAR2(10) not null,
  auth_name      VARCHAR2(50) not null,
  auth_parent_id VARCHAR2(10),
  auth_desc      VARCHAR2(200),
  auth_type      NUMBER,
  create_at      DATE,
  create_by      VARCHAR2(20),
  data_version   NUMBER,
  auth_url       VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column TWEI_AUTH.auth_type
  is '1:menu,2:button';

prompt Creating TWEI_AUTOID...
create table TWEI_AUTOID
(
  table_name VARCHAR2(50) not null,
  id_prefix  VARCHAR2(5),
  id_length  NUMBER not null,
  current_id NUMBER default 0 not null,
  next_id    NUMBER default 1 not null,
  create_by  VARCHAR2(20),
  create_at  DATE default sysdate
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TWEI_AUTOID
  add constraint UNIQUE_TABLE_NAME unique (TABLE_NAME, ID_PREFIX)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_DICT...
create table TWEI_DICT
(
  type_id         VARCHAR2(5) not null,
  dict_id         VARCHAR2(15) not null,
  dict_name       VARCHAR2(50) not null,
  dict_short_name VARCHAR2(50),
  dict_full_name  VARCHAR2(50),
  create_by       VARCHAR2(20),
  create_at       DATE,
  update_by       VARCHAR2(20),
  update_at       DATE,
  flag            NUMBER(1) default 0,
  check_by        VARCHAR2(20),
  check_at        DATE,
  is_used         NUMBER(1),
  memo            VARCHAR2(100),
  pycode          VARCHAR2(20),
  data_version    NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_DICT_TYPE...
create table TWEI_DICT_TYPE
(
  type_id      VARCHAR2(10) not null,
  type_name    VARCHAR2(50) not null,
  memo         VARCHAR2(100),
  create_by    VARCHAR2(20),
  create_at    DATE,
  update_by    VARCHAR2(20),
  update_at    DATE,
  data_version NUMBER,
  flag         NUMBER(1),
  check_by     VARCHAR2(20),
  check_at     DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TWEI_DICT_TYPE
  add constraint PRIMARY_KEY_TYPE_ID primary key (TYPE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_KNOWLEDGE...
create table TWEI_KNOWLEDGE
(
  code_id      VARCHAR2(20),
  know_id      VARCHAR2(20) not null,
  know_type    VARCHAR2(20),
  is_help      NUMBER default 0,
  is_unhelp    NUMBER default 0,
  create_by    VARCHAR2(20),
  create_at    DATE,
  update_by    VARCHAR2(20),
  update_at    DATE,
  data_version NUMBER,
  know_title   VARCHAR2(100) not null,
  know_detail  VARCHAR2(4000)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_MENU...
create table TWEI_MENU
(
  menu_id        VARCHAR2(10) not null,
  menu_name      VARCHAR2(50) not null,
  menu_level     NUMBER,
  menu_icon      VARCHAR2(100),
  menu_order     NUMBER,
  menu_parent_id VARCHAR2(10),
  auth_id        VARCHAR2(10),
  data_version   NUMBER,
  create_by      VARCHAR2(20),
  create_at      DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_ORGANIZATION...
create table TWEI_ORGANIZATION
(
  organization_id        VARCHAR2(10),
  organization_name      VARCHAR2(50),
  organization_desc      VARCHAR2(200),
  organization_parent_id VARCHAR2(10),
  organization_level     NUMBER,
  create_at              DATE,
  create_by              VARCHAR2(20),
  data_version           NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;

prompt Creating TWEI_ORGANIZATION_ROLE...
create table TWEI_ORGANIZATION_ROLE
(
  or_id           NUMBER,
  organization_id VARCHAR2(10),
  role_id         VARCHAR2(10),
  create_by       VARCHAR2(20),
  create_at       DATE,
  data_version    NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;

prompt Creating TWEI_ROLE...
create table TWEI_ROLE
(
  role_id        VARCHAR2(10) not null,
  role_name      VARCHAR2(30) not null,
  create_at      DATE,
  create_by      VARCHAR2(20),
  role_parent_id VARCHAR2(10),
  role_level     NUMBER,
  role_desc      VARCHAR2(500),
  data_version   NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_ROLE_AUTH...
create table TWEI_ROLE_AUTH
(
  role_id      VARCHAR2(10),
  auth_id      VARCHAR2(10),
  create_by    VARCHAR2(20),
  create_at    DATE,
  data_version NUMBER,
  ra_id        NUMBER generated always as identity
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_USER...
create table TWEI_USER
(
  organization_id VARCHAR2(10),
  userid          VARCHAR2(20) not null,
  user_name       VARCHAR2(20) not null,
  password        VARCHAR2(50) not null,
  email           VARCHAR2(50),
  create_at       DATE,
  last_login_at   DATE,
  update_at       DATE,
  data_version    NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating TWEI_USER_ROLE...
create table TWEI_USER_ROLE
(
  userid       VARCHAR2(20) not null,
  role_id      VARCHAR2(10) not null,
  create_by    VARCHAR2(20),
  create_at    DATE,
  data_version NUMBER,
  ur_id        NUMBER generated always as identity
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Loading TWEI_API...
insert into TWEI_API (api_type_id, api_id, api_name, api_desc, api_url, api_method, request_example, response_example, fault_example, create_by, create_at, update_by, update_at, data_version)
values ('APIL0004', 13, '測試', '測試', 'http://www.baidu.com', 'getlist', '測試', '測試', '測試', 'weilizong', to_date('04-04-2019 09:43:34', 'dd-mm-yyyy hh24:mi:ss'), null, null, 0);
insert into TWEI_API (api_type_id, api_id, api_name, api_desc, api_url, api_method, request_example, response_example, fault_example, create_by, create_at, update_by, update_at, data_version)
values ('APIL0004', 17, '測試2', 'http://www.baidu.com', 'http://www.baidu.com', 'http://www.baidu.com', 'http://www.baidu.com', 'http://www.baidu.com', 'http://www.baidu.com', 'weilizong', to_date('04-04-2019 10:37:38', 'dd-mm-yyyy hh24:mi:ss'), null, null, 0);
commit;
prompt 2 records loaded
prompt Loading TWEI_API_CODE...
insert into TWEI_API_CODE (code_id, code_name, definition, api_id, code_type, create_by, create_at, update_by, update_at, data_version)
values ('10', 'need login', '需要登錄進行操作', '13', '提示', 'weilizong', to_date('04-04-2019 10:32:35', 'dd-mm-yyyy hh24:mi:ss'), null, null, 0);
commit;
prompt 1 records loaded
prompt Loading TWEI_API_PARA...
insert into TWEI_API_PARA (api_id, para_id, para_name, para_type, para_data_type, is_nullable, para_memo, parent_para_id, create_by, create_at, update_by, update_at, data_version)
values (17, 4, '測試', null, 'Object', 1, '測試修改', null, 'weilizong', to_date('04-04-2019 11:45:29', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', to_date('04-04-2019 11:58:03', 'dd-mm-yyyy hh24:mi:ss'), 1);
commit;
prompt 1 records loaded
prompt Loading TWEI_API_TYPE...
insert into TWEI_API_TYPE (api_type_id, api_type_name, api_type_memo, create_by, create_at, update_by, update_at, data_version)
values (6, '自動獲取ID', '自動獲取ID', 'weilizong', to_date('03-04-2019 15:22:14', 'dd-mm-yyyy hh24:mi:ss'), null, null, 0);
insert into TWEI_API_TYPE (api_type_id, api_type_name, api_type_memo, create_by, create_at, update_by, update_at, data_version)
values (7, '測試修改', '測試修改', 'weilizong', to_date('03-04-2019 15:42:02', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', to_date('03-04-2019 16:02:23', 'dd-mm-yyyy hh24:mi:ss'), 1);
commit;
prompt 2 records loaded
prompt Loading TWEI_APP_LOG...
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (393, 'INSERT', 'TweiRole(roleId=4, roleName=組長, createAt=Thu Apr 11 14:10:18 CST 2019, createBy=weilizong, roleLevel=2, roleParentId=4, roleDesc=組長, dataVersion=0, selected=false)com.delta.soft_manage_system.interceptor.XssRequestWrapper@54ded3fe', to_date('12-04-2019 13:54:15', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=TweiRole(roleId=8, roleName=組長, createAt=Fri Apr 12 13:54:15 CST 2019, createBy=weilizong, roleLevel=2, roleParentId=4, roleDesc=組長, dataVersion=0, selected=false)}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (394, 'INSERT', 'TweiRole(roleId=4, roleName=員工, createAt=Thu Apr 11 14:10:18 CST 2019, createBy=weilizong, roleLevel=2, roleParentId=4, roleDesc=員工, dataVersion=0, selected=false)com.delta.soft_manage_system.interceptor.XssRequestWrapper@4e4149bf', to_date('12-04-2019 13:54:41', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=TweiRole(roleId=9, roleName=員工, createAt=Fri Apr 12 13:54:41 CST 2019, createBy=weilizong, roleLevel=2, roleParentId=4, roleDesc=員工, dataVersion=0, selected=false)}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (395, 'SETAUTHS', '[{"roleId":"9","authId":"3000"},{"roleId":"9","authId":"3100"},{"roleId":"9","authId":"3101"},{"roleId":"9","authId":"3102"},{"roleId":"9","authId":"3103"},{"roleId":"9","authId":"3104"},{"roleId":"9","authId":"3200"},{"roleId":"9","authId":"3201"},{"roleId":"9","authId":"3202"},{"roleId":"9","authId":"3203"},{"roleId":"9","authId":"3204"},{"roleId":"9","authId":"3300"},{"roleId":"9","authId":"3301"},{"roleId":"9","authId":"3302"},{"roleId":"9","authId":"3303"},{"roleId":"9","authId":"3304"},{"roleId":"9","authId":"1"}]', to_date('12-04-2019 13:54:48', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'nested exception is org.apache.ibatis.reflection.ReflectionException: Could not set property ''raId'' of ''class com.delta.auth.dto.TweiRoleAuth'' with value ''1116580441364541441'' Cause: java.lang.IllegalArgumentException: argument type mismatch');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (416, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@6ade67f1', to_date('12-04-2019 15:03:25', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (417, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@2ed70da6com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@35ad9ac8', to_date('12-04-2019 15:03:28', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1MjYwOCwiZXhwIjoxNTU1MDU5ODA4fQ.0JQk_VTJ6mEmcRvo7-ylQ_YLTk1wqHLlsuDaZvGQ4EY}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (434, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@596cc69b', to_date('12-04-2019 15:36:14', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (435, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@140cbe29com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@598b9c91', to_date('12-04-2019 15:36:16', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1NDU3NiwiZXhwIjoxNTU1MDYxNzc2fQ.FYmPh-_vZFaCQSwo4bUm81OFXQqMyRu9wz_i9sY7byw}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (436, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@12a40f9a', to_date('12-04-2019 15:42:02', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (437, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@305a3bc8com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@71711ff5', to_date('12-04-2019 15:42:04', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1NDkyNCwiZXhwIjoxNTU1MDYyMTI0fQ.NvUU2FAzpmz5GmYsdIGKTsUWShQTdnqbpd88uxw592U}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (472, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@58620ec6', to_date('12-04-2019 20:04:29', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (473, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@23bfd084com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@547a2bda', to_date('12-04-2019 20:04:31', 'dd-mm-yyyy hh24:mi:ss'), null, null);
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (474, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@5900d995com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@57c72cc5', to_date('12-04-2019 20:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', null);
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (391, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@4a867da8', to_date('12-04-2019 13:53:26', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (392, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@657e4d95com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@1b925fdd', to_date('12-04-2019 13:53:29', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA0ODQxMCwiZXhwIjoxNTU1MDU1NjEwfQ.flWwvBFNKdx6h_hRZ2a6eaMkaBRR9ejq-8iF9eQJLi4}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (383, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@3a7e11ca', to_date('12-04-2019 13:35:34', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (384, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@78e7f552com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@8f62085', to_date('12-04-2019 13:35:38', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA0NzMzOCwiZXhwIjoxNTU1MDU0NTM4fQ.mXeF4gwlayjgixGduQrViIVS4Q0IV4LbSdLLI0qyjJ0}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (385, 'LOGIN', 'TweiUser{userid=''emp'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@2eea1709com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@7ddb7292', to_date('12-04-2019 13:36:24', 'dd-mm-yyyy hh24:mi:ss'), 'emp', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJlbXAiLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcImVtcFwifSIsImlhdCI6MTU1NTA0NzM4NCwiZXhwIjoxNTU1MDU0NTg0fQ.K8yXC0OG1gQqnggsHZ7LFKCK_b2xA8bjHyZYVeCKNWw}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (387, 'EXCEPTION', 'java.lang.NullPointerException', to_date('12-04-2019 13:36:28', 'dd-mm-yyyy hh24:mi:ss'), 'emp', 'redirect:/error/500');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (388, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@3761056d', to_date('12-04-2019 13:39:04', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (389, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@6772437ecom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@37bc1f88', to_date('12-04-2019 13:39:06', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA0NzU0NiwiZXhwIjoxNTU1MDU0NzQ2fQ.uZQetpVB3K_r3vEKISVVAW8dWzMRYsKsBvXeH93iwpI}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (409, 'LOGIN', 'TweiUser{userid=''emp'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@1d82c94dcom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@2a4df5c5', to_date('12-04-2019 14:12:33', 'dd-mm-yyyy hh24:mi:ss'), 'emp', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJlbXAiLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcImVtcFwifSIsImlhdCI6MTU1NTA0OTU1MywiZXhwIjoxNTU1MDU2NzUzfQ.FmUxxvyII0JSeOqR_EcSasqLBejfLzvwxstjTJLa5fw}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (428, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@3ee61b19', to_date('12-04-2019 15:22:38', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (429, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@71d700e7com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@47b77efa', to_date('12-04-2019 15:22:41', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1Mzc2MSwiZXhwIjoxNTU1MDYwOTYxfQ.p6Iu6IL3DRaFGeG1FdbeuybIwRk2_2O5yqvHiUHrMFU}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (468, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@54f770f9', to_date('12-04-2019 20:02:05', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (469, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@3cf465c0com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@51203f2c', to_date('12-04-2019 20:02:08', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA3MDUyOCwiZXhwIjoxNTU1MDc3NzI4fQ.WmuTjg1K_o8ICh9apwy7XA4VZG0OG1nGLkYb4jr9YV4}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (470, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@35827a01', to_date('12-04-2019 20:02:34', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (471, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@31117f40com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@3fd68712', to_date('12-04-2019 20:02:36', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA3MDU1NiwiZXhwIjoxNTU1MDc3NzU2fQ.4U2c0kKOKDGM99cMPeT5Yu-Ew0vxcismnJCgyNcMMII}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (449, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@60e1b7f0', to_date('12-04-2019 16:04:04', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (450, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@369d91b5com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@42fcfe8b', to_date('12-04-2019 16:04:07', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1NjI0NywiZXhwIjoxNTU1MDYzNDQ3fQ.qvvxdDfozmpJMAp9hMNTXIUqBVkdXOFz6OJHaWoEOQ0}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (451, 'UPDATE', 'TweiRole(roleId=4, roleName=管理員, createAt=Thu Apr 11 14:10:18 CST 2019, createBy=weilizong, roleLevel=1, roleParentId=2, roleDesc=權限比超級管理員小一點, dataVersion=0, selected=false)com.delta.soft_manage_system.interceptor.XssRequestWrapper@1c2e7eed', to_date('12-04-2019 16:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=TweiRole(roleId=4, roleName=管理員, createAt=Thu Apr 11 14:10:18 CST 2019, createBy=weilizong, roleLevel=1, roleParentId=2, roleDesc=權限比超級管理員小一點, dataVersion=1, selected=false)}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (464, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@2bdc9961com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@6c6ae141', to_date('12-04-2019 19:54:19', 'dd-mm-yyyy hh24:mi:ss'), null, null);
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (368, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@5a606b0', to_date('12-04-2019 12:03:17', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (369, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@62f1b900com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@9142874', to_date('12-04-2019 12:03:21', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA0MTgwMiwiZXhwIjoxNTU1MDQ5MDAyfQ.P1wK_T_9Jio9xbRxsIz0d9as5YH0mHM0BQvcLafReoM}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (404, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@2fe96ae1com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@459fdbab', to_date('12-04-2019 14:12:00', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA0OTUyMCwiZXhwIjoxNTU1MDU2NzIwfQ.ppruFlhPqZU4FSdufHMYbBbepPuY_w2XF7waLQPyUW0}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (405, 'SETROLES', '[{"userid":"emp","roleId":"9"}]', to_date('12-04-2019 14:12:14', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=null}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (406, 'SETROLES', '[{"userid":"grouper","roleId":"8"}]', to_date('12-04-2019 14:12:20', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=null}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (407, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@4c8b9462', to_date('12-04-2019 14:12:27', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (408, 'LOGIN', 'TweiUser{userid=''emp'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@7806fb4com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@f1a82d8', to_date('12-04-2019 14:12:33', 'dd-mm-yyyy hh24:mi:ss'), 'emp', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJlbXAiLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcImVtcFwifSIsImlhdCI6MTU1NTA0OTU1MywiZXhwIjoxNTU1MDU2NzUzfQ.FmUxxvyII0JSeOqR_EcSasqLBejfLzvwxstjTJLa5fw}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (390, 'SETAUTHS', '[{"roleId":"6","authId":"3000"},{"roleId":"6","authId":"3100"},{"roleId":"6","authId":"3101"},{"roleId":"6","authId":"3102"},{"roleId":"6","authId":"3103"},{"roleId":"6","authId":"3104"},{"roleId":"6","authId":"3200"},{"roleId":"6","authId":"3201"},{"roleId":"6","authId":"3202"},{"roleId":"6","authId":"3203"},{"roleId":"6","authId":"3204"},{"roleId":"6","authId":"3300"},{"roleId":"6","authId":"3301"},{"roleId":"6","authId":"3302"},{"roleId":"6","authId":"3303"},{"roleId":"6","authId":"3304"},{"roleId":"6","authId":"1"},{"roleId":"6","authId":"4000"},{"roleId":"6","authId":"4001"},{"roleId":"6","authId":"4002"},{"roleId":"6","authId":"4003"},{"roleId":"6","authId":"4004"}]', to_date('12-04-2019 13:50:44', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=null}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (403, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@48d3f0fb', to_date('12-04-2019 14:11:57', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (372, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@4a40539d', to_date('12-04-2019 12:06:43', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (373, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@4209cac1com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@2cbe9e09', to_date('12-04-2019 12:06:45', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA0MjAwNSwiZXhwIjoxNTU1MDQ5MjA1fQ.sYrwcRuMPfV-OgQzhb7lCpqOWIWrsxoSarbLujexpm8}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (374, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@2d77fbce', to_date('12-04-2019 12:08:01', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (375, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@7823a2b4com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@5fa338f0', to_date('12-04-2019 12:08:03', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA0MjA4MywiZXhwIjoxNTU1MDQ5MjgzfQ.LiFq3yyh7Zzh4yIk2ofdRXBOnV00QFOwD1hRmMkBkEM}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (376, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@4706713', to_date('12-04-2019 12:08:46', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (377, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@579eb2b5com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@63d72a2e', to_date('12-04-2019 12:08:48', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA0MjEyOCwiZXhwIjoxNTU1MDQ5MzI4fQ.2uv4iY7xPtosQAc_ynNLZdeUZqpAyGk9yF29TtIZS9Y}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (432, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@6ba18b01', to_date('12-04-2019 15:34:36', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (433, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@2ed70da6com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@35ad9ac8', to_date('12-04-2019 15:34:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1NDQ3OSwiZXhwIjoxNTU1MDYxNjc5fQ.d2Xwskfma1Ccl0jdpE4z3-AKDj8SCZkr20ObwF7c2Ko}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (370, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@225b883d', to_date('12-04-2019 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (371, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@dd044f9com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@7fa95d1', to_date('12-04-2019 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA0MTg4OCwiZXhwIjoxNTU1MDQ5MDg4fQ.L_3D2oiEbRZewAWfsHu32FvPE7syJ8J0ZYJTbNP3s44}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (380, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@8f0e722', to_date('12-04-2019 13:32:13', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (381, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@124de393com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@4670607a', to_date('12-04-2019 13:32:14', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA0NzEzNCwiZXhwIjoxNTU1MDU0MzM0fQ.ub_x9GsalsqA8X8cOCY6GiuqgBxqDsEykgAZhnIU1sc}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (382, 'EXCEPTION', 'org.springframework.jdbc.BadSqlGrammarException: ' || chr(13) || '' || chr(10) || '### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00933: SQL 命令的結束有問題' || chr(10) || '' || chr(13) || '' || chr(10) || '### The error may involve com.delta.auth.dao.RoleAuthMapper.insertBatch-Inline' || chr(13) || '' || chr(10) || '### The error occurred while setting parameters' || chr(13) || '' || chr(10) || '### SQL: insert into twei_role_auth (role_id, auth_id) values                        (?,             ?)          ,              (?,             ?)' || chr(13) || '' || chr(10) || '### Cause: java.sql.SQLSyntaxErrorException: ORA-00933: SQL 命令的結束有問題' || chr(10) || '' || chr(10) || '; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00933: SQL 命令的結束有問題' || chr(10) || '', to_date('12-04-2019 13:32:33', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', '{"msg":"服務器出錯","status":1}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (410, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@92d28fd', to_date('12-04-2019 14:48:19', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (411, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@7ae8b8cfcom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@16b87e47', to_date('12-04-2019 14:48:22', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1MTcwMiwiZXhwIjoxNTU1MDU4OTAyfQ.pLOjhZTFnvEqZ41ETJoej1bjwnCKS1ljPerzfBX8J0c}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (378, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@6b46e230', to_date('12-04-2019 13:29:53', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (379, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@df04966com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@7d63c390', to_date('12-04-2019 13:29:56', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA0Njk5NiwiZXhwIjoxNTU1MDU0MTk2fQ.FheBJ-dU9qMy2ofY0tKFvao-ATYsjGS47zhlYTULBdU}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (430, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@61314d9a', to_date('12-04-2019 15:30:08', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (431, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@3cd4074dcom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@b5e1ef1', to_date('12-04-2019 15:30:11', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1NDIxMSwiZXhwIjoxNTU1MDYxNDExfQ.ighHiO-blw8eq23AGj0RVaNdCpq_VXogaTBN-h3qiKY}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (401, 'LOGIN', 'TweiUser{userid=''emp'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@428c530ecom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@12a7e4b9', to_date('12-04-2019 14:00:09', 'dd-mm-yyyy hh24:mi:ss'), 'emp', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJlbXAiLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcImVtcFwifSIsImlhdCI6MTU1NTA0ODgwOSwiZXhwIjoxNTU1MDU2MDA5fQ.UZAw375DvCRN3_znTxbY8e2UwP6NCUNl12tZ2VcES5c}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (402, 'INSERT', 'TweiUser{userid=''grouper'', userName=''組長'', email=''safjklsdajf@163.com'', createAt=Mon Apr 08 00:04:10 CST 2019, lastLoginAt=Fri Apr 12 13:56:42 CST 2019, updateAt=null, organizationId='''', dataVersion=1}com.delta.soft_manage_system.interceptor.XssRequestWrapper@75c809a9', to_date('12-04-2019 14:01:16', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=TweiUser{userid=''grouper'', userName=''組長'', email=''safjklsdajf@163.com'', createAt=Fri Apr 12 14:01:16 CST 2019, lastLoginAt=Fri Apr 12 13:56:42 CST 2019, updateAt=null, organizationId='''', dataVersion=0}}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (412, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@3c904897', to_date('12-04-2019 14:56:08', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (413, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@62f1b900com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@9142874', to_date('12-04-2019 14:56:11', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1MjE3MSwiZXhwIjoxNTU1MDU5MzcxfQ.XqgpnlTSkceN6ZCk96UHcBCv18CfNt2A9_4vrvSmjJ8}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (444, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@4de9850e', to_date('12-04-2019 15:54:36', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (445, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@104c3a5acom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@71d39d28', to_date('12-04-2019 15:54:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1NTY4MCwiZXhwIjoxNTU1MDYyODgwfQ.xBl796o2cRUen93Fc67BKKjerUEnEslOAfk93ZFQmWY}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (467, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@5b7c65bacom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@52e72566', to_date('12-04-2019 19:57:32', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA3MDI1NiwiZXhwIjoxNTU1MDc3NDU2fQ.AhQPPnGsIHrmb0pe3C2FEW28rYcs_ychmOXLAxc7rDI}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (400, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@1d55d4fc', to_date('12-04-2019 14:00:01', 'dd-mm-yyyy hh24:mi:ss'), 'emp', 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (401, 'LOGIN', 'TweiUser{userid=''emp'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@46b96747com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@20777b6a', to_date('12-04-2019 14:00:09', 'dd-mm-yyyy hh24:mi:ss'), 'emp', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJlbXAiLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcImVtcFwifSIsImlhdCI6MTU1NTA0ODgwOSwiZXhwIjoxNTU1MDU2MDA5fQ.UZAw375DvCRN3_znTxbY8e2UwP6NCUNl12tZ2VcES5c}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (440, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@283e6dcd', to_date('12-04-2019 15:48:28', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (441, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@28ab03cbcom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@4c038d66', to_date('12-04-2019 15:48:31', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1NTMxMSwiZXhwIjoxNTU1MDYyNTExfQ.Ke1MotUf5fwhIK4f3pUeQPl3FJA73BivT9Lmt9R9OhY}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (452, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@6f0e5de2', to_date('12-04-2019 16:26:36', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (453, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@473b6bfecom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@2a920865', to_date('12-04-2019 16:26:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1NzU5OSwiZXhwIjoxNTU1MDY0Nzk5fQ.7gIqCpOUDygSYfbjVI0HqUUBkVDcmnTFHXUpFLYfkAc}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (454, 'INSERT', 'TweiMenu(menuId=4, menuName=測試菜單, menuIcon=, menuLevel=1, menuOrder=null, menuParentId=4, authId=2200, dataVersion=2, createBy=weilizong, createAt=Wed Apr 10 15:16:57 CST 2019)com.delta.soft_manage_system.interceptor.XssRequestWrapper@798d4137', to_date('12-04-2019 16:30:07', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=TweiMenu(menuId=17, menuName=測試菜單, menuIcon=, menuLevel=1, menuOrder=null, menuParentId=4, authId=2200, dataVersion=0, createBy=weilizong, createAt=Fri Apr 12 16:30:07 CST 2019)}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (461, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@7005a132', to_date('12-04-2019 19:50:13', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (462, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@58948471com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@204bbd2e', to_date('12-04-2019 19:50:16', 'dd-mm-yyyy hh24:mi:ss'), null, null);
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (463, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@6e477909com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@60809ab1', to_date('12-04-2019 19:51:24', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', null);
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (438, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@7398faba', to_date('12-04-2019 15:46:42', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (439, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@6419f65acom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@3aadaaf0', to_date('12-04-2019 15:46:44', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1NTIwNSwiZXhwIjoxNTU1MDYyNDA1fQ.YszUMh2G_zpbrycDSgTTwgGrnL9U9KJPdo5SN3FqG24}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (455, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@598ab161', to_date('12-04-2019 17:02:35', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (456, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@387161d3com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@4d789f4', to_date('12-04-2019 17:02:39', 'dd-mm-yyyy hh24:mi:ss'), null, '' || chr(13) || '' || chr(10) || '### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00921: SQL 命令意外結束' || chr(10) || '' || chr(13) || '' || chr(10) || '### The error may exist in com/delta/auth/dao/RoleMapper.xml' || chr(13) || '' || chr(10) || '### The error may involve defaultParameterMap' || chr(13) || '' || chr(10) || '### The error occurred while setting parameters' || chr(13) || '' || chr(10) || '### SQL: select tc.role_id as roleId,      tc.role_level as roleLevel,      tc.role_desc as roleDesc,      tc.role_parent_id as roleParentId,      tc.role_name as roleName,      tc.create_at as createAt,      tc.create_by as createBy,      tc.data_version as dataVersion      from twei_role tc      where tc.role_level =      (select min(td.role_level) from twei_role td where td.role_id in     (select ta.role_id from twei_user_role ta where ta.userid = ?)     and tc.role_id =     (select ta.role_id from twei_user_role ta where ta.userid = ?)' || chr(13) || '' || chr(10) || '### Cause: java.sql.SQLSyntaxErrorException: ORA-00921: SQL 命令意外結束' || chr(10) || '' || chr(10) || '; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00921: SQL 命令意外結束' || chr(10) || '');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (465, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@439d83b6com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@69a7b21f', to_date('12-04-2019 19:55:17', 'dd-mm-yyyy hh24:mi:ss'), null, null);
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (466, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@13a530a2com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@1d62dca6', to_date('12-04-2019 19:56:07', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', null);
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (414, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@54b9f0e9', to_date('12-04-2019 14:59:23', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (415, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@3e35c6b3com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@69187edb', to_date('12-04-2019 14:59:26', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1MjM2NiwiZXhwIjoxNTU1MDU5NTY2fQ.Oj8RQuRjWQb6v9_fbEXSQ6DiP1QCifQt4ruP3Av9eJ4}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (457, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@5d6878b2com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@cdce023', to_date('12-04-2019 17:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1OTkyNSwiZXhwIjoxNTU1MDY3MTI1fQ.qRCEzT9vsppqBuaadf9U4uDlBEiKmTi-ftB2ClPKGos}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (420, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@40c225c5', to_date('12-04-2019 15:07:36', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (421, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@49b71985com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@413a3519', to_date('12-04-2019 15:07:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1Mjg1OSwiZXhwIjoxNTU1MDYwMDU5fQ.fOgu4DyFfnp8NXeWPRXjhJK5i-r121wXqhLH8o8T-V4}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (422, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@120aeb60', to_date('12-04-2019 15:14:09', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (423, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@f834cc2com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@31688720', to_date('12-04-2019 15:14:11', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1MzI1MSwiZXhwIjoxNTU1MDYwNDUxfQ.Hg8GQAvPX7ml8tyTCOg2ov9yQlG6vOO37T2tnTuFyb8}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (424, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@19191b58', to_date('12-04-2019 15:14:41', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (425, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@3b95eb9ecom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@2c133830', to_date('12-04-2019 15:14:43', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1MzI4MywiZXhwIjoxNTU1MDYwNDgzfQ.pZbGtWpzp7_4hdOpM_lb5GrOSgMSMYbYcwKCJzaBG0Y}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (426, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@200667c6', to_date('12-04-2019 15:17:47', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (427, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@63af49b9com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@15f287b0', to_date('12-04-2019 15:17:49', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1MzQ2OSwiZXhwIjoxNTU1MDYwNjY5fQ.Gx0wRUuTdLNjNY25amTzMqREh40BlBZq4h4KCmaNRE4}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (458, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@6ade67f1', to_date('12-04-2019 17:08:12', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (459, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@73804188com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@7928b4c7', to_date('12-04-2019 17:08:15', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA2MDA5NSwiZXhwIjoxNTU1MDY3Mjk1fQ.JK_RFbbLz_Rf4HT3W_-NTx0UwfEnt0XK7dXqGQOeFrw}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (460, 'DELETE', 'TweiMenu(menuId=17, menuName=測試菜單, menuIcon=, menuLevel=1, menuOrder=null, menuParentId=4, authId=2200, dataVersion=0, createBy=weilizong, createAt=Fri Apr 12 16:30:07 CST 2019)com.delta.soft_manage_system.interceptor.XssRequestWrapper@1b772206', to_date('12-04-2019 17:10:29', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=TweiMenu(menuId=17, menuName=測試菜單, menuIcon=, menuLevel=1, menuOrder=null, menuParentId=4, authId=2200, dataVersion=0, createBy=weilizong, createAt=Fri Apr 12 16:30:07 CST 2019)}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (418, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@7e6d9348', to_date('12-04-2019 15:07:18', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (419, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@5f4ee7becom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@32cf2cce', to_date('12-04-2019 15:07:21', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1Mjg0MSwiZXhwIjoxNTU1MDYwMDQxfQ.qTEB5MhQyqobH70hXpYFROdiB5lUqSz6OcI1H3o_MAo}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (386, 'LOGIN', 'TweiUser{userid=''emp'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@741e466ecom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@52e03d57', to_date('12-04-2019 13:36:24', 'dd-mm-yyyy hh24:mi:ss'), 'emp', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJlbXAiLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcImVtcFwifSIsImlhdCI6MTU1NTA0NzM4NCwiZXhwIjoxNTU1MDU0NTg0fQ.K8yXC0OG1gQqnggsHZ7LFKCK_b2xA8bjHyZYVeCKNWw}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (396, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@3fe5356', to_date('12-04-2019 13:56:38', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'redirect:login');
commit;
prompt 100 records committed...
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (397, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@42291870com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@7408dbca', to_date('12-04-2019 13:56:42', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA0ODYwMiwiZXhwIjoxNTU1MDU1ODAyfQ.RI6ZcdUo3QuyiuIgNyIdgZTz6Ow5gqacynm63o4oQ9Y}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (398, 'SETAUTHS', '[{"roleId":"9","authId":"3000"},{"roleId":"9","authId":"3100"},{"roleId":"9","authId":"3101"},{"roleId":"9","authId":"3102"},{"roleId":"9","authId":"3103"},{"roleId":"9","authId":"3104"},{"roleId":"9","authId":"3200"},{"roleId":"9","authId":"3201"},{"roleId":"9","authId":"3202"},{"roleId":"9","authId":"3203"},{"roleId":"9","authId":"3204"},{"roleId":"9","authId":"3300"},{"roleId":"9","authId":"3301"},{"roleId":"9","authId":"3302"},{"roleId":"9","authId":"3303"},{"roleId":"9","authId":"3304"},{"roleId":"9","authId":"1"}]', to_date('12-04-2019 13:56:53', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=null}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (399, 'SETAUTHS', '[{"roleId":"8","authId":"1"},{"roleId":"8","authId":"1000"},{"roleId":"8","authId":"1100"},{"roleId":"8","authId":"1101"},{"roleId":"8","authId":"1102"},{"roleId":"8","authId":"1103"},{"roleId":"8","authId":"1104"},{"roleId":"8","authId":"1200"},{"roleId":"8","authId":"1201"},{"roleId":"8","authId":"1202"},{"roleId":"8","authId":"1203"},{"roleId":"8","authId":"1204"},{"roleId":"8","authId":"1205"},{"roleId":"8","authId":"1300"},{"roleId":"8","authId":"1301"},{"roleId":"8","authId":"1302"},{"roleId":"8","authId":"1303"},{"roleId":"8","authId":"1304"},{"roleId":"8","authId":"1305"},{"roleId":"8","authId":"2000"},{"roleId":"8","authId":"2100"},{"roleId":"8","authId":"2101"},{"roleId":"8","authId":"2102"},{"roleId":"8","authId":"2103"},{"roleId":"8","authId":"2104"},{"roleId":"8","authId":"2105"},{"roleId":"8","authId":"2200"},{"roleId":"8","authId":"2201"},{"roleId":"8","authId":"2202"},{"roleId":"8","authId":"2203"},{"roleId":"8","authId":"2204"},{"roleId":"8","authId":"2205"}]', to_date('12-04-2019 13:57:04', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=null}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (442, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@28ef888', to_date('12-04-2019 15:51:15', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (443, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@314169afcom.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@28e5fd94', to_date('12-04-2019 15:51:17', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1NTQ3NywiZXhwIjoxNTU1MDYyNjc3fQ.2fRpsePcm2jEwygv-zEILrll7zxe6VhB5GdQedphaHw}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (446, 'LOGOUT', 'com.delta.soft_manage_system.interceptor.XssRequestWrapper@75e0f6fb', to_date('12-04-2019 16:00:18', 'dd-mm-yyyy hh24:mi:ss'), null, 'redirect:login');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (447, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@72eeb44com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@38b7bab9', to_date('12-04-2019 16:00:21', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA1NjAyMSwiZXhwIjoxNTU1MDYzMjIxfQ.W7X4Voj59gcODOiTcsuOwhPoT2DGHEkhXjOeujPQ8TE}');
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (448, 'UPDATE', 'TweiRole(roleId=4, roleName=管理員, createAt=null, createBy=, roleLevel=1, roleParentId=2, roleDesc=權限比超級管理員小一點, dataVersion=null, selected=false)com.delta.soft_manage_system.interceptor.XssRequestWrapper@46379748', to_date('12-04-2019 16:00:52', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', null);
insert into TWEI_APP_LOG (log_id, log_type, log_content, log_at, log_by, log_result)
values (475, 'LOGIN', 'TweiUser{userid=''weilizong'', userName=''null'', email=''null'', createAt=null, lastLoginAt=null, updateAt=null, organizationId=''null'', dataVersion=null}com.delta.soft_manage_system.interceptor.XssRequestWrapper@19a88620com.alibaba.druid.support.http.WebStatFilter$StatHttpServletResponseWrapper@5598213a', to_date('12-04-2019 20:08:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 'ServerResponse{status=0, msg=''SUCCESS'', data=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ3ZWlsaXpvbmciLCJpc3MiOiJqd3QtZGVsdGEiLCJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiMTIzNDU2XCIsXCJ1c2VyaWRcIjpcIndlaWxpem9uZ1wifSIsImlhdCI6MTU1NTA3MDkxOSwiZXhwIjoxNTU1MDc4MTE5fQ.bFDTxeULA4VItvO2GPPlCPkov5wT9CR1pPN25ntEC88}');
commit;
prompt 109 records loaded
prompt Loading TWEI_AUTH...
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1100', '菜單管理', '1000', '菜單管理', 1, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/menu/manage');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1200', '角色管理', '1000', '角色管理', 1, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/role/manage');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1300', '用戶管理', '1000', '用戶管理', 1, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/user/manage');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('2100', '數據字典類型管理', '2000', '數據字典類型管理', 1, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/dicttype/manage');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('2200', '數據字典管理', '2000', '數據字典管理', 1, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/dict/manage');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3100', 'API及組件管理', '3000', 'API及組件管理', 1, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/api/manage');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3200', 'API異常碼管理', '3000', 'API異常碼管理', 1, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/apicode/manage');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3300', 'API參數管理', '3000', 'API參數管理', 1, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/apipara/manage');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1101', '新增', '1100', '新增菜單', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/menu/insert');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1102', '修改', '1100', '修改菜單', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/menu/update');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1103', '刪除', '1100', '刪除菜單', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/menu/delete');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1201', '新增', '1200', '新增角色', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/role/insert');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1202', '修改', '1200', '修改角色', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/role/update');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1203', '刪除', '1200', '刪除角色', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/role/delete');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1301', '新增', '1300', '新增用戶', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/user/insert');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1302', '修改', '1300', '修改用戶', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/user/update');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1303', '刪除', '1300', '刪除用戶', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/user/delete');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('2101', '新增', '2100', '新增數據字典類型', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/dicttype/insert');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('2102', '修改', '2100', '修改數據字典類型', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/dicttype/update');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('2103', '刪除', '2100', '刪除數據字典類型', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/dicttype/delete');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('2104', '審核', '2100', '審核數據字典類型', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/dicttype/check');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('2201', '新增', '2200', '新增數據字典', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/dict/insert');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('2202', '修改', '2200', '修改數據字典', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/dict/update');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('2203', '刪除', '2200', '刪除數據字典', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/dict/delete');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('2204', '審核', '2200', '審核數據字典', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/dict/check');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3101', '新增', '3100', '新增API', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/api/insert');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3102', '修改', '3100', '修改API', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/api/update');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3103', '刪除', '3100', '刪除API', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/api/delete');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3201', '新增', '3200', '新增API異常碼', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/apicode/insert');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3202', '修改', '3200', '修改API異常碼', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/apicode/update');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3203', '刪除', '3200', '刪除API異常碼', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/apicode/delete');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3301', '新增', '3300', '新增API參數', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/apipara/insert');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3302', '修改', '3300', '修改API參數', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/apipara/update');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3303', '刪除', '3300', '刪除API參數', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/apipara/delete');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('4001', '新增', '4000', '新增知識庫', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/knowledge/insert');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('4002', '修改', '4000', '修改知識庫', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/knowledge/update');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('4003', '刪除', '4000', '刪除知識庫', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/knowledge/delete');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1205', '設置權限', '1200', '設置權限', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/role/setauths');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1305', '設置角色', '1300', '設置角色', 2, to_date('11-04-2019 09:48:39', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/user/setroles');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('3000', 'API及組件管理', null, 'API及組件管理', 1, to_date('09-04-2019 19:45:07', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, null);
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1', '首頁', null, '首頁', 1, to_date('09-04-2019 19:45:27', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/index');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('1000', '系統管理', null, '系統管理', 1, to_date('09-04-2019 19:45:49', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, null);
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('2000', '基礎資料管理', null, '基礎資料管理', 1, to_date('09-04-2019 19:46:05', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, null);
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('4000', '知識庫管理', null, '知識庫管理', 1, to_date('09-04-2019 19:46:55', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/knowledge/manage');
insert into TWEI_AUTH (auth_id, auth_name, auth_parent_id, auth_desc, auth_type, create_at, create_by, data_version, auth_url)
values ('5000', '系統日誌', null, '系統日誌', 1, to_date('09-04-2019 19:47:28', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', 0, '/admin/log/manage');
commit;
prompt 45 records loaded
prompt Loading TWEI_AUTOID...
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_dict_type', 'D', 8, 3, 4, 'admin', to_date('27-03-2019 09:43:58', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_dict', 'SJLX', 8, 6, 7, 'admin', to_date('04-04-2019 08:10:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_knowledge', null, 8, 7, 8, 'admin', to_date('04-04-2019 14:33:09', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_dict', null, 8, 18, 19, null, to_date('27-03-2019 09:56:28', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_dict', 'APIL', 8, 5, 6, 'admin', to_date('03-04-2019 08:40:15', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_api_type', null, 8, 12, 13, 'admin', to_date('03-04-2019 10:14:41', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_app_log', null, 8, 475, 476, 'admin', to_date('09-04-2019 08:33:08', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_dict', 'XTL', 8, 56, 57, 'admin', to_date('27-03-2019 11:25:36', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_dict', 'ZSKL', 8, 42, 43, 'admin', to_date('01-04-2019 08:58:30', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_api_para', null, 8, 5, 6, 'admin', to_date('04-04-2019 11:44:37', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_role', null, 8, 9, 10, 'admin', to_date('09-04-2019 14:48:35', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_user', null, 8, 1, 2, 'admin', to_date('09-04-2019 17:19:26', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_menu', null, 8, 17, 18, 'admin', to_date('10-04-2019 13:44:30', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_api', null, 8, 17, 18, 'admin', to_date('03-04-2019 15:23:34', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_dict', 'A', 8, 5, 6, null, to_date('27-03-2019 10:00:35', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_AUTOID (table_name, id_prefix, id_length, current_id, next_id, create_by, create_at)
values ('twei_auth', null, 8, 6, 7, 'admin', to_date('09-04-2019 19:49:23', 'dd-mm-yyyy hh24:mi:ss'));
commit;
prompt 16 records loaded
prompt Loading TWEI_DICT...
insert into TWEI_DICT (type_id, dict_id, dict_name, dict_short_name, dict_full_name, create_by, create_at, update_by, update_at, flag, check_by, check_at, is_used, memo, pycode, data_version)
values ('APIL', 'APIL0003', 'MES類', 'MES類', 'MES類', 'weilizong', to_date('04-04-2019 08:29:22', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 'weilizong', to_date('04-04-2019 08:30:07', 'dd-mm-yyyy hh24:mi:ss'), null, 'MES類', 'MESl', 1);
insert into TWEI_DICT (type_id, dict_id, dict_name, dict_short_name, dict_full_name, create_by, create_at, update_by, update_at, flag, check_by, check_at, is_used, memo, pycode, data_version)
values ('SJLX', 'SJLX0003', 'Integer', '整型', '整型', 'weilizong', to_date('04-04-2019 08:07:21', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 'weilizong', to_date('04-04-2019 08:07:31', 'dd-mm-yyyy hh24:mi:ss'), null, '整型', 'Integer', 1);
insert into TWEI_DICT (type_id, dict_id, dict_name, dict_short_name, dict_full_name, create_by, create_at, update_by, update_at, flag, check_by, check_at, is_used, memo, pycode, data_version)
values ('APIL', 'APIL0004', 'ERP類', 'ERP類', 'ERP類', 'weilizong', to_date('04-04-2019 08:30:00', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 'weilizong', to_date('04-04-2019 08:30:04', 'dd-mm-yyyy hh24:mi:ss'), null, 'ERP類', 'ERPl', 1);
insert into TWEI_DICT (type_id, dict_id, dict_name, dict_short_name, dict_full_name, create_by, create_at, update_by, update_at, flag, check_by, check_at, is_used, memo, pycode, data_version)
values ('ZSKL', 'ZSKL0040', '開發類', '開發類', '開發類', 'weilizong', to_date('04-04-2019 08:30:31', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 'weilizong', to_date('04-04-2019 08:31:35', 'dd-mm-yyyy hh24:mi:ss'), null, '開發類', 'kfl', 1);
insert into TWEI_DICT (type_id, dict_id, dict_name, dict_short_name, dict_full_name, create_by, create_at, update_by, update_at, flag, check_by, check_at, is_used, memo, pycode, data_version)
values ('ZSKL', 'ZSKL0041', '運維類', '運維類', '運維類', 'weilizong', to_date('04-04-2019 08:30:45', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', to_date('04-04-2019 08:31:23', 'dd-mm-yyyy hh24:mi:ss'), 1, 'weilizong', to_date('04-04-2019 08:31:32', 'dd-mm-yyyy hh24:mi:ss'), null, '運維類', 'ywl', 2);
insert into TWEI_DICT (type_id, dict_id, dict_name, dict_short_name, dict_full_name, create_by, create_at, update_by, update_at, flag, check_by, check_at, is_used, memo, pycode, data_version)
values ('ZSKL', 'ZSKL0042', '系統操作類', '系統操作類', '系統操作類', 'weilizong', to_date('04-04-2019 08:31:09', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 'weilizong', to_date('04-04-2019 08:31:29', 'dd-mm-yyyy hh24:mi:ss'), null, '系統操作類', 'xtczl', 1);
insert into TWEI_DICT (type_id, dict_id, dict_name, dict_short_name, dict_full_name, create_by, create_at, update_by, update_at, flag, check_by, check_at, is_used, memo, pycode, data_version)
values ('APIL', 'APIL0005', '測試', null, null, 'weilizong', to_date('04-04-2019 08:55:25', 'dd-mm-yyyy hh24:mi:ss'), null, null, 0, null, null, null, null, 'cs', 0);
insert into TWEI_DICT (type_id, dict_id, dict_name, dict_short_name, dict_full_name, create_by, create_at, update_by, update_at, flag, check_by, check_at, is_used, memo, pycode, data_version)
values ('SJLX', 'SJLX0004', 'Boolean', '布爾型', '布爾型', 'weilizong', to_date('04-04-2019 08:07:58', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 'weilizong', to_date('04-04-2019 08:08:41', 'dd-mm-yyyy hh24:mi:ss'), null, '布爾型', 'Boolean', 1);
insert into TWEI_DICT (type_id, dict_id, dict_name, dict_short_name, dict_full_name, create_by, create_at, update_by, update_at, flag, check_by, check_at, is_used, memo, pycode, data_version)
values ('SJLX', 'SJLX0002', 'String', '字符型', '字符型', 'weilizong', to_date('04-04-2019 08:06:54', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 'weilizong', to_date('04-04-2019 08:07:34', 'dd-mm-yyyy hh24:mi:ss'), null, '字符型', 'String', 1);
insert into TWEI_DICT (type_id, dict_id, dict_name, dict_short_name, dict_full_name, create_by, create_at, update_by, update_at, flag, check_by, check_at, is_used, memo, pycode, data_version)
values ('SJLX', 'SJLX0005', 'Date', '日期類型', '日期類型', 'weilizong', to_date('04-04-2019 08:09:11', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 'weilizong', to_date('04-04-2019 08:09:38', 'dd-mm-yyyy hh24:mi:ss'), null, '日期類型', 'Date', 1);
insert into TWEI_DICT (type_id, dict_id, dict_name, dict_short_name, dict_full_name, create_by, create_at, update_by, update_at, flag, check_by, check_at, is_used, memo, pycode, data_version)
values ('SJLX', 'SJLX0006', 'Object', '實體對象', '實體對象', 'weilizong', to_date('04-04-2019 08:09:33', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 'weilizong', to_date('04-04-2019 08:09:41', 'dd-mm-yyyy hh24:mi:ss'), null, '實體對象', 'Object', 1);
insert into TWEI_DICT (type_id, dict_id, dict_name, dict_short_name, dict_full_name, create_by, create_at, update_by, update_at, flag, check_by, check_at, is_used, memo, pycode, data_version)
values ('APIL', 'APIL0002', 'OA類', 'OA類', 'OA類', 'weilizong', to_date('04-04-2019 08:29:06', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 'weilizong', to_date('04-04-2019 08:30:10', 'dd-mm-yyyy hh24:mi:ss'), null, 'OA類', 'OAl', 1);
commit;
prompt 12 records loaded
prompt Loading TWEI_DICT_TYPE...
insert into TWEI_DICT_TYPE (type_id, type_name, memo, create_by, create_at, update_by, update_at, data_version, flag, check_by, check_at)
values ('SJLX', '數據類型', 'API參數的數據類型', 'weilizong', to_date('04-04-2019 08:04:17', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 1, 'weilizong', to_date('04-04-2019 08:05:10', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_DICT_TYPE (type_id, type_name, memo, create_by, create_at, update_by, update_at, data_version, flag, check_by, check_at)
values ('ZSKL', '知識庫類', '關於知識庫的類別', 'weilizong', to_date('04-04-2019 08:21:29', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 1, 'weilizong', to_date('04-04-2019 08:21:37', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_DICT_TYPE (type_id, type_name, memo, create_by, create_at, update_by, update_at, data_version, flag, check_by, check_at)
values ('APIL', 'API類', '關於API的類型', 'weilizong', to_date('04-04-2019 08:27:56', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, 1, 'weilizong', to_date('04-04-2019 08:28:09', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_DICT_TYPE (type_id, type_name, memo, create_by, create_at, update_by, update_at, data_version, flag, check_by, check_at)
values ('CSRZ', '測試日誌', '測試日誌備註地方噶', 'weilizong', to_date('09-04-2019 10:39:16', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', to_date('11-04-2019 09:51:28', 'dd-mm-yyyy hh24:mi:ss'), 2, 1, 'weilizong', to_date('11-04-2019 09:51:32', 'dd-mm-yyyy hh24:mi:ss'));
commit;
prompt 4 records loaded
prompt Loading TWEI_KNOWLEDGE...
insert into TWEI_KNOWLEDGE (code_id, know_id, know_type, is_help, is_unhelp, create_by, create_at, update_by, update_at, data_version, know_title, know_detail)
values (null, '2', 'ZSKL0042', 0, 0, 'weilizong', to_date('04-04-2019 14:38:39', 'dd-mm-yyyy hh24:mi:ss'), null, null, 0, '測試', '測試');
insert into TWEI_KNOWLEDGE (code_id, know_id, know_type, is_help, is_unhelp, create_by, create_at, update_by, update_at, data_version, know_title, know_detail)
values (null, '3', 'ZSKL0042', 0, 0, 'weilizong', to_date('04-04-2019 14:39:25', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', to_date('04-04-2019 16:09:54', 'dd-mm-yyyy hh24:mi:ss'), 2, '測試庫', '測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 測試似的是否會 ');
insert into TWEI_KNOWLEDGE (code_id, know_id, know_type, is_help, is_unhelp, create_by, create_at, update_by, update_at, data_version, know_title, know_detail)
values (null, '6', 'ZSKL0042', 0, 0, 'weilizong', to_date('08-04-2019 17:30:32', 'dd-mm-yyyy hh24:mi:ss'), null, null, 0, '測試', '還是打開福利好了還是打發 ');
insert into TWEI_KNOWLEDGE (code_id, know_id, know_type, is_help, is_unhelp, create_by, create_at, update_by, update_at, data_version, know_title, know_detail)
values ('1005', '7', 'ZSKL0042', 0, 0, 'weilizong', to_date('09-04-2019 14:33:53', 'dd-mm-yyyy hh24:mi:ss'), null, null, 0, '異常嗎測試', '異常嗎測試數據');
commit;
prompt 4 records loaded
prompt Loading TWEI_MENU...
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('7', '菜單管理', 2, null, null, '4', '1100', 0, 'weilizong', to_date('10-04-2019 15:24:00', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('8', '用戶管理', 2, null, null, '4', '1300', 0, 'weilizong', to_date('10-04-2019 15:24:24', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('2', '首頁', 1, 'fa fa-th-large', 0, '0', '1', 1, 'weilizong', to_date('10-04-2019 13:44:48', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('9', '角色管理', 2, null, null, '4', '1200', 0, 'weilizong', to_date('10-04-2019 15:26:57', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('10', 'API及組件管理', 2, null, null, '6', '3100', 0, 'weilizong', to_date('10-04-2019 15:27:19', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('11', 'API異常碼管理', 2, null, null, '6', '3200', 0, 'weilizong', to_date('10-04-2019 15:27:38', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('12', 'API參數管理', 2, null, null, '6', '3300', 0, 'weilizong', to_date('10-04-2019 15:28:06', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('13', '數據字典類型管理', 2, null, null, '5', '2100', 0, 'weilizong', to_date('10-04-2019 15:28:30', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('14', '數據字典管理', 2, null, null, '5', '2200', 0, 'weilizong', to_date('10-04-2019 15:28:48', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('15', '知識庫管理', 1, 'fa fa-tag', null, '0', '4000', 1, 'weilizong', to_date('10-04-2019 15:29:49', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('16', '系統日誌', 1, 'fa fa-list-ol', null, '0', '5000', 1, 'weilizong', to_date('10-04-2019 15:30:02', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('4', '系統管理', 1, 'fa fa-cogs', null, '0', '1000', 2, 'weilizong', to_date('10-04-2019 15:16:57', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('5', '基礎資料管理', 1, 'fa fa-align-left', null, '0', '2000', 2, 'weilizong', to_date('10-04-2019 15:17:17', 'dd-mm-yyyy hh24:mi:ss'));
insert into TWEI_MENU (menu_id, menu_name, menu_level, menu_icon, menu_order, menu_parent_id, auth_id, data_version, create_by, create_at)
values ('6', 'API及組件管理', 1, 'fa fa-swatchbook', null, '0', '3000', 2, 'weilizong', to_date('10-04-2019 15:17:33', 'dd-mm-yyyy hh24:mi:ss'));
commit;
prompt 14 records loaded
prompt Loading TWEI_ORGANIZATION...
prompt Table is empty
prompt Loading TWEI_ORGANIZATION_ROLE...
prompt Table is empty
prompt Loading TWEI_ROLE...
insert into TWEI_ROLE (role_id, role_name, create_at, create_by, role_parent_id, role_level, role_desc, data_version)
values ('2', '超級管理員', to_date('09-04-2019 15:08:26', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', null, 0, '超級管理員,擁有系統所有權限', 1);
insert into TWEI_ROLE (role_id, role_name, create_at, create_by, role_parent_id, role_level, role_desc, data_version)
values ('4', '管理員', to_date('11-04-2019 14:10:18', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', '2', 1, '權限比超級管理員小一點', 1);
insert into TWEI_ROLE (role_id, role_name, create_at, create_by, role_parent_id, role_level, role_desc, data_version)
values ('8', '組長', to_date('12-04-2019 13:54:15', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', '4', 2, '組長', 0);
insert into TWEI_ROLE (role_id, role_name, create_at, create_by, role_parent_id, role_level, role_desc, data_version)
values ('9', '員工', to_date('12-04-2019 13:54:41', 'dd-mm-yyyy hh24:mi:ss'), 'weilizong', '4', 2, '員工', 0);
commit;
prompt 4 records loaded
prompt Loading TWEI_ROLE_AUTH...
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('7', '5001', null, null, null, 61);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1100', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 5);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1200', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 6);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1300', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 7);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '2100', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 8);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '2200', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 9);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3100', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 10);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3200', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 11);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3300', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 12);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1101', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 13);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1102', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 14);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1103', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 15);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1201', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 16);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1202', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 17);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1203', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 18);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1301', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 19);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1302', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 20);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1303', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 21);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '2101', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 22);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '2102', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 23);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '2103', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 24);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '2104', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 25);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '2201', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 26);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '2202', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 27);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '2203', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 28);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '2204', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 29);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3101', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 30);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3102', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 31);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3103', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 32);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3201', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 33);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3202', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 34);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3203', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 35);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3301', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 36);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3302', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 37);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3303', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 38);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '4001', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 39);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '4002', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 40);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '4003', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 41);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '5001', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 43);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1205', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 52);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1305', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 53);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '3000', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 54);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 55);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '1000', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 56);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '2000', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 57);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '4000', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 58);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('2', '5000', 'weilizong', to_date('10-04-2019 19:59:00', 'dd-mm-yyyy hh24:mi:ss'), 0, 59);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('7', '5000', null, null, null, 61);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3000', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3100', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3101', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3102', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3103', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3200', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3201', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3202', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3203', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3300', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3301', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3302', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '3303', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('9', '1', null, null, null, 63);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1000', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1100', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1101', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1102', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1103', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1200', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1201', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1202', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1203', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1205', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1300', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1301', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1302', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1303', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '1305', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '2000', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '2100', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '2101', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '2102', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '2103', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '2104', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '2200', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '2201', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '2202', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '2203', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('8', '2204', null, null, null, 64);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3000', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3100', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3101', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3102', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3103', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3200', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3201', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3202', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3203', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3300', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3301', null, null, null, 62);
commit;
prompt 100 records committed...
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3302', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '3303', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '1', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '4000', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '4001', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '4002', null, null, null, 62);
insert into TWEI_ROLE_AUTH (role_id, auth_id, create_by, create_at, data_version, ra_id)
values ('6', '4003', null, null, null, 62);
commit;
prompt 107 records loaded
prompt Loading TWEI_USER...
insert into TWEI_USER (organization_id, userid, user_name, password, email, create_at, last_login_at, update_at, data_version)
values ('1', 'weilizong', '韋利總', '4QrcOUm6Wau+VuBX8g+IPg==', 'weilizong2014@hotmail.com', to_date('08-04-2019 12:04:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-04-2019 20:08:39', 'dd-mm-yyyy hh24:mi:ss'), null, 1);
insert into TWEI_USER (organization_id, userid, user_name, password, email, create_at, last_login_at, update_at, data_version)
values (null, 'grouper', '組長', 'ICy5YqxZB1uWSwcVLSNLcA==', 'safjklsdajf@163.com', to_date('12-04-2019 14:01:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-04-2019 13:56:42', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
insert into TWEI_USER (organization_id, userid, user_name, password, email, create_at, last_login_at, update_at, data_version)
values (null, 'emp', '員工', '4QrcOUm6Wau+VuBX8g+IPg==', 'emp@delta.com', to_date('11-04-2019 14:54:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-04-2019 14:12:33', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
prompt 3 records loaded
prompt Loading TWEI_USER_ROLE...
insert into TWEI_USER_ROLE (userid, role_id, create_by, create_at, data_version, ur_id)
values ('emp', '9', null, null, null, 61);
insert into TWEI_USER_ROLE (userid, role_id, create_by, create_at, data_version, ur_id)
values ('grouper', '8', null, null, null, 62);
insert into TWEI_USER_ROLE (userid, role_id, create_by, create_at, data_version, ur_id)
values ('weilizong', '2', null, null, 0, 21);
commit;
prompt 3 records loaded

set feedback on
set define on
prompt Done
