--�����ֵ����
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

--�����ֵ�
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

--api���
/*API_type:
api_type_id,���id
api_type_name,api������Q
api_type_memo,��͂��]
enter_user,������
enter_time,�����r�g
data_version,�����汾*/

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
private String api_id; //id,������
private String memo; //Ӧ�ó���
private String api_name; //�ӿ�����
private String api_address; //�����ַ
private String request_example; //����ʾ��
private String response_example; //��Ӧʾ��
private String fault_example; //�쳣ʾ��
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

/*API����:
private String para_id; //id,������
private String para_name; //��������
private String para_datatype; //��������,�P�����ֵ�
private String is_nullable; //�Ƿ����
private String memo; //��������
private String api_id; //�ĸ�api����?
private String para_type; //��������,����,��Ӧ,��������,������Ӧ(�����ֵ�)
private String parent_id; //���ڵ�id,��������(Ƕ�ׅ������)*/

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
private String error_id; //�������
private String item; //��������
private String deal_url; //����Բ� //?
private String definition; //������
private String belong_api; //�����ĸ�api
private String error_type; //�쳣����(���Ԕ����ֵ�)*/

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
private String know_id; //֪ʶid
private String know_detail; //�������취
private String provider; //�ṩ��
private Date provide_time; //�ṩʱ��
private String is_help; //��Ϊ����
private String is_unhelp; //��Ϊû�а���
private String error_id; //����������*/

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
comment on table twei_knowledge is '֪�R�씵����';
comment on column twei_knowledge.know_type is '֪�R�����,���Ԕ����ֵ�';
		