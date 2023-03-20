/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/4/27 22:11:14                           */
/*==============================================================*/


drop table if exists Admin;

drop table if exists Apply;

drop table if exists Consume;

drop table if exists Staff;

/*==============================================================*/
/* Table: Admin                                                 */
/*==============================================================*/
create table Admin
(
   admin_id             int not null auto_increment,
   admin_account        varchar(30) not null,
   admin_passwd         char(50) not null,
   primary key (admin_id)
);

/*==============================================================*/
/* Table: Apply                                                 */
/*==============================================================*/
create table Apply
(
   apply_id             int not null auto_increment,
   sta_id               int not null,
   admin_id             int,
   con_id               int not null,
   apply_time           datetime not null,
   con_time             datetime not null,
   apply_num            int not null,
   apply_name           varchar(20) not null,
   apply_is_check       int not null,
   apply_result         int,
   apply_note           varchar(100),
   primary key (apply_id)
);

/*==============================================================*/
/* Table: Consume                                               */
/*==============================================================*/
create table Consume
(
   con_id               int not null auto_increment,
   con_name             varchar(20) not null,
   con_num              int not null,
   con_factory          varchar(50) not null,
   con_indate           datetime not null,
   con_is_replenish     int not null,
   primary key (con_id)
);

/*==============================================================*/
/* Table: Staff                                                 */
/*==============================================================*/
create table Staff
(
   sta_id               int not null auto_increment,
   sta_name             varchar(20) not null,
   sta_dept             varchar(20) not null,
   sta_tele             char(20) not null,
   primary key (sta_id)
);

alter table Apply add constraint FK_Apply foreign key (con_id)
      references Consume (con_id) on delete restrict on update restrict;

alter table Apply add constraint FK_Apply2 foreign key (sta_id)
      references Staff (sta_id) on delete restrict on update restrict;

alter table Apply add constraint FK_Apply3 foreign key (admin_id)
      references Admin (admin_id) on delete restrict on update restrict;

