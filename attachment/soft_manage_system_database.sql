--數據字典類型
drop table twei_dict_type;
create table twei_dict_type(
type_id number generated as identity primary key,
type_name varchar2(50) not null,
memo varchar2(100),
create_by varchar2(20),
create_at date,
update_by varchar2(20),
update_at date,
data_version number
);

--數據字典
drop table twei_dict;
create table twei_dict(
type_id varchar2(5) not null,
dict_id varchar2(10) not null,
dict_name varchar2(50) not null,
dict_short_name varchar2(50),
dict_full_name varchar2(50),
create_by varchar2(20),
create_at date,
update_by varchar2(20),
update_at date,
flag number(1) default 0,
check_by varchar2(20),
check_at date,
is_used number(1),
memo varchar2(100),
pycode varchar2(20),
data_version number
);

--api類型
/*API_type:
api_type_id,類型id
api_type_name,api類型名稱
api_type_memo,類型備註
enter_user,創建人
enter_time,創建時間
data_version,數據版本*/

drop table twei_api_type;
create table twei_api_type(
api_type_id number not null,
api_type_name varchar2(20) not null,
api_type_memo varchar2(100),
create_by varchar2(20),
create_at date,
update_by varchar2(20),
update_at date,
data_version number
);

/*API:
private String api_id; //id,无意义
private String memo; //应用场景
private String api_name; //接口名称
private String api_address; //请求地址
private String request_example; //请求示例
private String response_example; //响应示例
private String fault_example; //异常示例
private String api_type_id;*/

drop table twei_api;
create table twei_api(
api_type_id number not null,
api_id number not null,
api_name varchar2(50) not null,
api_desc varchar2(200) not null,
api_url varchar2(100) not null,
api_method varchar2(100),
request_example varchar2(500),
response_example varchar2(500),
fault_example varchar2(500),
create_by varchar2(20),
create_at date,
update_by varchar2(20),
update_at date,
data_version number
);

/*API参数:
private String para_id; //id,无意义
private String para_name; //参数名称
private String para_datatype; //参数类型,關聯數據字典
private String is_nullable; //是否必须
private String memo; //参数描述
private String api_id; //哪个api调用?
private String para_type; //参数类型,请求,响应,公共请求,公共响应(加入字典)
private String parent_id; //父节点id,关联自身(嵌套參數類型)*/

drop table twei_api_para;
create table twei_api_para(
api_id number not null,
para_id number not null,
para_name varchar2(20) not null,
para_type varchar2(10),
para_data_type varchar2(10),
is_nullable number(1) default 0,
para_memo varchar2(200),
parent_para_id number,
create_by varchar2(20),
create_at date,
update_by varchar2(20),
update_at date,
data_version number
);

/*error_code:
private String error_id; //错误代码
private String item; //错误名称
private String deal_url; //处理对策 //?
private String definition; //错误定义
private String belong_api; //属于哪个api
private String error_type; //异常类型(來自數據字典)*/

drop table twei_api_code;
create table twei_api_code(
code_id varchar2(20) not null,
code_name varchar2(20)not null,
definition varchar2(200),
api_id number,
code_type varchar2(10),
create_by varchar2(20),
create_at date,
update_by varchar2(20),
update_at date,
data_version number
);

/*knowledge:
private String know_id; //知识id
private String know_detail; //具体解决办法
private String provider; //提供者
private Date provide_time; //提供时间
private String is_help; //认为有用
private String is_unhelp; //认为没有帮助
private String error_id; //错误代码外键*/

drop table twei_knowledge;
create table twei_knowledge(
code_id varchar2(20),
know_id varchar2(20) not null,
know_detail blob not null,
know_type varchar2(10),
is_help number,
is_unhelp number,
create_by varchar2(20),
create_at date,
update_by varchar2(20),
update_at date,
data_version number
);
comment on table twei_knowledge is '知識庫數據表';
comment on column twei_knowledge.know_type is '知識庫類型,來自數據字典';
		