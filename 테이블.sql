--------------------------------------------------------
--  파일이 생성됨 - 수요일-3월-04-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table USER_INFO
--------------------------------------------------------

  CREATE TABLE "PRACTICE"."USER_INFO" 
   (	"USER_IDX" NUMBER(11,0), 
	"USER_REGISTER_DATE" DATE DEFAULT sysdate, 
	"USER_NAME" VARCHAR2(200 BYTE), 
	"USER_SOCIAL_SECUNUM" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"USER_SEX" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"USER_COMP" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"USER_COMP_ENTERDATE" DATE DEFAULT NULL, 
	"USER_DEPT" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"USER_SPOT" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"USER_ARMY_SERV" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"USER_MARITAL_STATUS" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"USER_ARMY_SERV_ENTER" DATE DEFAULT NULL, 
	"USER_ARMY_SERV_LEAVE" DATE DEFAULT NULL, 
	"USER_ARMY_SERV_PERIOD" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"USER_TELNUM_WIRED" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"USER_TELNUM_WIRELESS" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"USER_EMAIL" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"USER_ZIPCODE" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"USER_ADDRESS" VARCHAR2(200 BYTE) DEFAULT NULL
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USER_INFO_CAREER
--------------------------------------------------------

  CREATE TABLE "PRACTICE"."USER_INFO_CAREER" 
   (	"CAREER_IDX" NUMBER(11,0), 
	"USER_IDX" NUMBER(11,0), 
	"CAREER_COMP_NAME" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"CAREER_ENTERDATE" DATE DEFAULT NULL, 
	"CAREER_LEAVEDATE" DATE DEFAULT NULL, 
	"CAREER_SPOT" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"CAREER_RESPONSIB" VARCHAR2(200 BYTE) DEFAULT NULL
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USER_INFO_EDU
--------------------------------------------------------

  CREATE TABLE "PRACTICE"."USER_INFO_EDU" 
   (	"EDU_IDX" NUMBER(11,0), 
	"USER_IDX" NUMBER(11,0) DEFAULT NULL, 
	"EDU_SCHOOL_NAME" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"EDU_STATUS" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"EDU_YEAR" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"EDU_MONTH" VARCHAR2(200 BYTE) DEFAULT NULL
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USER_INFO_LICEN
--------------------------------------------------------

  CREATE TABLE "PRACTICE"."USER_INFO_LICEN" 
   (	"LICEN_IDX" NUMBER(11,0), 
	"USER_IDX" NUMBER(11,0) DEFAULT NULL, 
	"LICEN_NAME" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"LICEN_SKILL_LEVEL" VARCHAR2(200 BYTE) DEFAULT NULL
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USER_INFO_QUALIFI
--------------------------------------------------------

  CREATE TABLE "PRACTICE"."USER_INFO_QUALIFI" 
   (	"QUALIFI_IDX" NUMBER(11,0), 
	"USER_IDX" NUMBER(11,0) DEFAULT NULL, 
	"QUALIFI_NAME" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"QUALIFI_GETDATE" DATE DEFAULT NULL
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USER_INFO_SKILL
--------------------------------------------------------

  CREATE TABLE "PRACTICE"."USER_INFO_SKILL" 
   (	"SKILL_IDX" NUMBER(11,0), 
	"USER_IDX" NUMBER(11,0) DEFAULT NULL, 
	"SKILL_PROJECT_NAME" VARCHAR2(1000 BYTE) DEFAULT NULL, 
	"SKILL_STARTDATE" DATE DEFAULT NULL, 
	"SKILL_ENDDATE" DATE DEFAULT NULL, 
	"SKILL_CUSTOMER_COMP" VARCHAR2(1000 BYTE) DEFAULT NULL, 
	"SKILL_WORK_COMP" VARCHAR2(1000 BYTE) DEFAULT NULL, 
	"SKILL_APPLIED" VARCHAR2(1000 BYTE) DEFAULT NULL, 
	"SKILL_INDUSTRY" VARCHAR2(1000 BYTE) DEFAULT NULL, 
	"SKILL_ROLE" VARCHAR2(1000 BYTE) DEFAULT NULL, 
	"SKILL_MODEL" VARCHAR2(1000 BYTE) DEFAULT NULL, 
	"SKILL_OS" VARCHAR2(1000 BYTE) DEFAULT NULL, 
	"SKILL_LANG" VARCHAR2(1000 BYTE) DEFAULT NULL, 
	"SKILL_DBMS" VARCHAR2(1000 BYTE) DEFAULT NULL, 
	"SKILL_COMM" VARCHAR2(1000 BYTE) DEFAULT NULL, 
	"SKILL_TOOL" VARCHAR2(1000 BYTE) DEFAULT NULL, 
	"SKILL_ETC" VARCHAR2(1000 BYTE) DEFAULT NULL
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USER_INFO_TRAINING
--------------------------------------------------------

  CREATE TABLE "PRACTICE"."USER_INFO_TRAINING" 
   (	"TRAINING_IDX" NUMBER(11,0), 
	"USER_IDX" NUMBER(11,0) DEFAULT NULL, 
	"TRAINING_NAME" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"TRAINING_STARTDATE" DATE DEFAULT NULL, 
	"TRAINING_ENDDATE" DATE DEFAULT NULL, 
	"TRAINING_AGENCY" VARCHAR2(200 BYTE) DEFAULT NULL
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into PRACTICE.USER_INFO
SET DEFINE OFF;
Insert into PRACTICE.USER_INFO (USER_IDX,USER_REGISTER_DATE,USER_NAME,USER_SOCIAL_SECUNUM,USER_SEX,USER_COMP,USER_COMP_ENTERDATE,USER_DEPT,USER_SPOT,USER_ARMY_SERV,USER_MARITAL_STATUS,USER_ARMY_SERV_ENTER,USER_ARMY_SERV_LEAVE,USER_ARMY_SERV_PERIOD,USER_TELNUM_WIRED,USER_TELNUM_WIRELESS,USER_EMAIL,USER_ZIPCODE,USER_ADDRESS) values (1,to_date('20/01/28','RR/MM/DD'),'asd',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into PRACTICE.USER_INFO (USER_IDX,USER_REGISTER_DATE,USER_NAME,USER_SOCIAL_SECUNUM,USER_SEX,USER_COMP,USER_COMP_ENTERDATE,USER_DEPT,USER_SPOT,USER_ARMY_SERV,USER_MARITAL_STATUS,USER_ARMY_SERV_ENTER,USER_ARMY_SERV_LEAVE,USER_ARMY_SERV_PERIOD,USER_TELNUM_WIRED,USER_TELNUM_WIRELESS,USER_EMAIL,USER_ZIPCODE,USER_ADDRESS) values (21,to_date('20/02/06','RR/MM/DD'),'asd','3a275d6d8cfb267185f00bdaa6f0f660b257ef5ae570c7ae45f89d54a3f41f99',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into PRACTICE.USER_INFO (USER_IDX,USER_REGISTER_DATE,USER_NAME,USER_SOCIAL_SECUNUM,USER_SEX,USER_COMP,USER_COMP_ENTERDATE,USER_DEPT,USER_SPOT,USER_ARMY_SERV,USER_MARITAL_STATUS,USER_ARMY_SERV_ENTER,USER_ARMY_SERV_LEAVE,USER_ARMY_SERV_PERIOD,USER_TELNUM_WIRED,USER_TELNUM_WIRELESS,USER_EMAIL,USER_ZIPCODE,USER_ADDRESS) values (22,to_date('20/02/06','RR/MM/DD'),'테스트','3a275d6d8cfb267185f00bdaa6f0f660b257ef5ae570c7ae45f89d54a3f41f99',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into PRACTICE.USER_INFO (USER_IDX,USER_REGISTER_DATE,USER_NAME,USER_SOCIAL_SECUNUM,USER_SEX,USER_COMP,USER_COMP_ENTERDATE,USER_DEPT,USER_SPOT,USER_ARMY_SERV,USER_MARITAL_STATUS,USER_ARMY_SERV_ENTER,USER_ARMY_SERV_LEAVE,USER_ARMY_SERV_PERIOD,USER_TELNUM_WIRED,USER_TELNUM_WIRELESS,USER_EMAIL,USER_ZIPCODE,USER_ADDRESS) values (23,to_date('20/02/06','RR/MM/DD'),'테스트','f5cd75395cb685012bb7662a16ccd9deb7539bb04f349c4e13200b211865ca58',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into PRACTICE.USER_INFO (USER_IDX,USER_REGISTER_DATE,USER_NAME,USER_SOCIAL_SECUNUM,USER_SEX,USER_COMP,USER_COMP_ENTERDATE,USER_DEPT,USER_SPOT,USER_ARMY_SERV,USER_MARITAL_STATUS,USER_ARMY_SERV_ENTER,USER_ARMY_SERV_LEAVE,USER_ARMY_SERV_PERIOD,USER_TELNUM_WIRED,USER_TELNUM_WIRELESS,USER_EMAIL,USER_ZIPCODE,USER_ADDRESS) values (24,to_date('20/02/11','RR/MM/DD'),'김무명',null,'남성','토피아정보기술',to_date('19/11/01','RR/MM/DD'),null,null,null,null,to_date('11/02/07','RR/MM/DD'),to_date('13/02/06','RR/MM/DD'),null,'054-733-7575','010-2019-7575','xmrwjstk88@naver.com','08769','서울 관악구 신림동 1652-9');
REM INSERTING into PRACTICE.USER_INFO_CAREER
SET DEFINE OFF;
Insert into PRACTICE.USER_INFO_CAREER (CAREER_IDX,USER_IDX,CAREER_COMP_NAME,CAREER_ENTERDATE,CAREER_LEAVEDATE,CAREER_SPOT,CAREER_RESPONSIB) values (22,22,null,null,null,null,null);
Insert into PRACTICE.USER_INFO_CAREER (CAREER_IDX,USER_IDX,CAREER_COMP_NAME,CAREER_ENTERDATE,CAREER_LEAVEDATE,CAREER_SPOT,CAREER_RESPONSIB) values (2,1,null,null,null,null,null);
Insert into PRACTICE.USER_INFO_CAREER (CAREER_IDX,USER_IDX,CAREER_COMP_NAME,CAREER_ENTERDATE,CAREER_LEAVEDATE,CAREER_SPOT,CAREER_RESPONSIB) values (21,21,null,null,null,null,null);
Insert into PRACTICE.USER_INFO_CAREER (CAREER_IDX,USER_IDX,CAREER_COMP_NAME,CAREER_ENTERDATE,CAREER_LEAVEDATE,CAREER_SPOT,CAREER_RESPONSIB) values (23,23,null,null,null,null,null);
Insert into PRACTICE.USER_INFO_CAREER (CAREER_IDX,USER_IDX,CAREER_COMP_NAME,CAREER_ENTERDATE,CAREER_LEAVEDATE,CAREER_SPOT,CAREER_RESPONSIB) values (42,24,null,null,null,null,null);
REM INSERTING into PRACTICE.USER_INFO_EDU
SET DEFINE OFF;
Insert into PRACTICE.USER_INFO_EDU (EDU_IDX,USER_IDX,EDU_SCHOOL_NAME,EDU_STATUS,EDU_YEAR,EDU_MONTH) values (22,22,null,null,null,null);
Insert into PRACTICE.USER_INFO_EDU (EDU_IDX,USER_IDX,EDU_SCHOOL_NAME,EDU_STATUS,EDU_YEAR,EDU_MONTH) values (2,1,null,null,null,null);
Insert into PRACTICE.USER_INFO_EDU (EDU_IDX,USER_IDX,EDU_SCHOOL_NAME,EDU_STATUS,EDU_YEAR,EDU_MONTH) values (21,21,null,null,null,null);
Insert into PRACTICE.USER_INFO_EDU (EDU_IDX,USER_IDX,EDU_SCHOOL_NAME,EDU_STATUS,EDU_YEAR,EDU_MONTH) values (23,23,null,null,null,null);
Insert into PRACTICE.USER_INFO_EDU (EDU_IDX,USER_IDX,EDU_SCHOOL_NAME,EDU_STATUS,EDU_YEAR,EDU_MONTH) values (44,24,'부산대',null,'2016','2');
Insert into PRACTICE.USER_INFO_EDU (EDU_IDX,USER_IDX,EDU_SCHOOL_NAME,EDU_STATUS,EDU_YEAR,EDU_MONTH) values (45,24,'포철공고',null,'2010','2');
REM INSERTING into PRACTICE.USER_INFO_LICEN
SET DEFINE OFF;
Insert into PRACTICE.USER_INFO_LICEN (LICEN_IDX,USER_IDX,LICEN_NAME,LICEN_SKILL_LEVEL) values (22,22,null,null);
Insert into PRACTICE.USER_INFO_LICEN (LICEN_IDX,USER_IDX,LICEN_NAME,LICEN_SKILL_LEVEL) values (2,1,null,null);
Insert into PRACTICE.USER_INFO_LICEN (LICEN_IDX,USER_IDX,LICEN_NAME,LICEN_SKILL_LEVEL) values (21,21,null,null);
Insert into PRACTICE.USER_INFO_LICEN (LICEN_IDX,USER_IDX,LICEN_NAME,LICEN_SKILL_LEVEL) values (23,23,null,null);
Insert into PRACTICE.USER_INFO_LICEN (LICEN_IDX,USER_IDX,LICEN_NAME,LICEN_SKILL_LEVEL) values (42,24,null,null);
REM INSERTING into PRACTICE.USER_INFO_QUALIFI
SET DEFINE OFF;
Insert into PRACTICE.USER_INFO_QUALIFI (QUALIFI_IDX,USER_IDX,QUALIFI_NAME,QUALIFI_GETDATE) values (22,22,null,null);
Insert into PRACTICE.USER_INFO_QUALIFI (QUALIFI_IDX,USER_IDX,QUALIFI_NAME,QUALIFI_GETDATE) values (2,1,null,null);
Insert into PRACTICE.USER_INFO_QUALIFI (QUALIFI_IDX,USER_IDX,QUALIFI_NAME,QUALIFI_GETDATE) values (21,21,null,null);
Insert into PRACTICE.USER_INFO_QUALIFI (QUALIFI_IDX,USER_IDX,QUALIFI_NAME,QUALIFI_GETDATE) values (23,23,null,null);
Insert into PRACTICE.USER_INFO_QUALIFI (QUALIFI_IDX,USER_IDX,QUALIFI_NAME,QUALIFI_GETDATE) values (42,24,null,null);
REM INSERTING into PRACTICE.USER_INFO_SKILL
SET DEFINE OFF;
Insert into PRACTICE.USER_INFO_SKILL (SKILL_IDX,USER_IDX,SKILL_PROJECT_NAME,SKILL_STARTDATE,SKILL_ENDDATE,SKILL_CUSTOMER_COMP,SKILL_WORK_COMP,SKILL_APPLIED,SKILL_INDUSTRY,SKILL_ROLE,SKILL_MODEL,SKILL_OS,SKILL_LANG,SKILL_DBMS,SKILL_COMM,SKILL_TOOL,SKILL_ETC) values (22,22,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into PRACTICE.USER_INFO_SKILL (SKILL_IDX,USER_IDX,SKILL_PROJECT_NAME,SKILL_STARTDATE,SKILL_ENDDATE,SKILL_CUSTOMER_COMP,SKILL_WORK_COMP,SKILL_APPLIED,SKILL_INDUSTRY,SKILL_ROLE,SKILL_MODEL,SKILL_OS,SKILL_LANG,SKILL_DBMS,SKILL_COMM,SKILL_TOOL,SKILL_ETC) values (2,1,'ㅁㄴㅇ',to_date('17/01/01','RR/MM/DD'),to_date('20/01/01','RR/MM/DD'),null,null,null,null,null,null,null,null,null,null,null,null);
Insert into PRACTICE.USER_INFO_SKILL (SKILL_IDX,USER_IDX,SKILL_PROJECT_NAME,SKILL_STARTDATE,SKILL_ENDDATE,SKILL_CUSTOMER_COMP,SKILL_WORK_COMP,SKILL_APPLIED,SKILL_INDUSTRY,SKILL_ROLE,SKILL_MODEL,SKILL_OS,SKILL_LANG,SKILL_DBMS,SKILL_COMM,SKILL_TOOL,SKILL_ETC) values (21,21,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into PRACTICE.USER_INFO_SKILL (SKILL_IDX,USER_IDX,SKILL_PROJECT_NAME,SKILL_STARTDATE,SKILL_ENDDATE,SKILL_CUSTOMER_COMP,SKILL_WORK_COMP,SKILL_APPLIED,SKILL_INDUSTRY,SKILL_ROLE,SKILL_MODEL,SKILL_OS,SKILL_LANG,SKILL_DBMS,SKILL_COMM,SKILL_TOOL,SKILL_ETC) values (23,23,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into PRACTICE.USER_INFO_SKILL (SKILL_IDX,USER_IDX,SKILL_PROJECT_NAME,SKILL_STARTDATE,SKILL_ENDDATE,SKILL_CUSTOMER_COMP,SKILL_WORK_COMP,SKILL_APPLIED,SKILL_INDUSTRY,SKILL_ROLE,SKILL_MODEL,SKILL_OS,SKILL_LANG,SKILL_DBMS,SKILL_COMM,SKILL_TOOL,SKILL_ETC) values (46,24,'ROYAL',to_date('18/02/01','RR/MM/DD'),to_date('19/02/01','RR/MM/DD'),null,null,null,null,null,null,null,null,null,null,null,null);
Insert into PRACTICE.USER_INFO_SKILL (SKILL_IDX,USER_IDX,SKILL_PROJECT_NAME,SKILL_STARTDATE,SKILL_ENDDATE,SKILL_CUSTOMER_COMP,SKILL_WORK_COMP,SKILL_APPLIED,SKILL_INDUSTRY,SKILL_ROLE,SKILL_MODEL,SKILL_OS,SKILL_LANG,SKILL_DBMS,SKILL_COMM,SKILL_TOOL,SKILL_ETC) values (44,24,'JOKER',to_date('17/02/01','RR/MM/DD'),to_date('19/02/01','RR/MM/DD'),null,null,null,null,null,null,null,null,null,null,null,null);
Insert into PRACTICE.USER_INFO_SKILL (SKILL_IDX,USER_IDX,SKILL_PROJECT_NAME,SKILL_STARTDATE,SKILL_ENDDATE,SKILL_CUSTOMER_COMP,SKILL_WORK_COMP,SKILL_APPLIED,SKILL_INDUSTRY,SKILL_ROLE,SKILL_MODEL,SKILL_OS,SKILL_LANG,SKILL_DBMS,SKILL_COMM,SKILL_TOOL,SKILL_ETC) values (45,24,'CLOVER',to_date('15/02/02','RR/MM/DD'),to_date('16/12/01','RR/MM/DD'),null,null,null,null,null,null,null,null,null,null,null,null);
REM INSERTING into PRACTICE.USER_INFO_TRAINING
SET DEFINE OFF;
Insert into PRACTICE.USER_INFO_TRAINING (TRAINING_IDX,USER_IDX,TRAINING_NAME,TRAINING_STARTDATE,TRAINING_ENDDATE,TRAINING_AGENCY) values (22,22,null,null,null,null);
Insert into PRACTICE.USER_INFO_TRAINING (TRAINING_IDX,USER_IDX,TRAINING_NAME,TRAINING_STARTDATE,TRAINING_ENDDATE,TRAINING_AGENCY) values (2,1,null,null,null,null);
Insert into PRACTICE.USER_INFO_TRAINING (TRAINING_IDX,USER_IDX,TRAINING_NAME,TRAINING_STARTDATE,TRAINING_ENDDATE,TRAINING_AGENCY) values (21,21,null,null,null,null);
Insert into PRACTICE.USER_INFO_TRAINING (TRAINING_IDX,USER_IDX,TRAINING_NAME,TRAINING_STARTDATE,TRAINING_ENDDATE,TRAINING_AGENCY) values (23,23,null,null,null,null);
Insert into PRACTICE.USER_INFO_TRAINING (TRAINING_IDX,USER_IDX,TRAINING_NAME,TRAINING_STARTDATE,TRAINING_ENDDATE,TRAINING_AGENCY) values (42,24,null,null,null,null);
--------------------------------------------------------
--  DDL for Index SYS_C006999
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRACTICE"."SYS_C006999" ON "PRACTICE"."USER_INFO" ("USER_IDX") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007002
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRACTICE"."SYS_C007002" ON "PRACTICE"."USER_INFO_CAREER" ("CAREER_IDX") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007004
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRACTICE"."SYS_C007004" ON "PRACTICE"."USER_INFO_EDU" ("EDU_IDX") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007006
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRACTICE"."SYS_C007006" ON "PRACTICE"."USER_INFO_LICEN" ("LICEN_IDX") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007008
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRACTICE"."SYS_C007008" ON "PRACTICE"."USER_INFO_QUALIFI" ("QUALIFI_IDX") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007010
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRACTICE"."SYS_C007010" ON "PRACTICE"."USER_INFO_SKILL" ("SKILL_IDX") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007012
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRACTICE"."SYS_C007012" ON "PRACTICE"."USER_INFO_TRAINING" ("TRAINING_IDX") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table USER_INFO
--------------------------------------------------------

  ALTER TABLE "PRACTICE"."USER_INFO" ADD PRIMARY KEY ("USER_IDX")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRACTICE"."USER_INFO" MODIFY ("USER_NAME" NOT NULL ENABLE);
  ALTER TABLE "PRACTICE"."USER_INFO" MODIFY ("USER_IDX" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_INFO_CAREER
--------------------------------------------------------

  ALTER TABLE "PRACTICE"."USER_INFO_CAREER" ADD PRIMARY KEY ("CAREER_IDX")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRACTICE"."USER_INFO_CAREER" MODIFY ("USER_IDX" NOT NULL ENABLE);
  ALTER TABLE "PRACTICE"."USER_INFO_CAREER" MODIFY ("CAREER_IDX" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_INFO_EDU
--------------------------------------------------------

  ALTER TABLE "PRACTICE"."USER_INFO_EDU" ADD PRIMARY KEY ("EDU_IDX")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRACTICE"."USER_INFO_EDU" MODIFY ("EDU_IDX" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_INFO_LICEN
--------------------------------------------------------

  ALTER TABLE "PRACTICE"."USER_INFO_LICEN" ADD PRIMARY KEY ("LICEN_IDX")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRACTICE"."USER_INFO_LICEN" MODIFY ("LICEN_IDX" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_INFO_QUALIFI
--------------------------------------------------------

  ALTER TABLE "PRACTICE"."USER_INFO_QUALIFI" ADD PRIMARY KEY ("QUALIFI_IDX")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRACTICE"."USER_INFO_QUALIFI" MODIFY ("QUALIFI_IDX" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_INFO_SKILL
--------------------------------------------------------

  ALTER TABLE "PRACTICE"."USER_INFO_SKILL" ADD PRIMARY KEY ("SKILL_IDX")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRACTICE"."USER_INFO_SKILL" MODIFY ("SKILL_IDX" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_INFO_TRAINING
--------------------------------------------------------

  ALTER TABLE "PRACTICE"."USER_INFO_TRAINING" ADD PRIMARY KEY ("TRAINING_IDX")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRACTICE"."USER_INFO_TRAINING" MODIFY ("TRAINING_IDX" NOT NULL ENABLE);
