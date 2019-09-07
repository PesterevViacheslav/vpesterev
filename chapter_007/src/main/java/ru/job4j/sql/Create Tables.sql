/*==============================================================*/
/* Table: ATTACHS                                               */
/*==============================================================*/
create table ATTACHS (
   ID                   NUMERIC              not null,
   FILE                 TEXT                 null,
   CREATE_DT            DATE                 null,
   DSC                  CHAR(2000)           null,
   constraint PK_ATTACHS primary key (ID)
);

comment on table ATTACHS is 'Файлы';

/*==============================================================*/
/* Table: DICT_ITEM_CATEGORY                                    */
/*==============================================================*/
create table DICT_ITEM_CATEGORY (
   ID                   NUMERIC              not null,
   TEXT                 CHAR(2000)           null,
   constraint PK_DICT_ITEM_CATEGORY primary key (ID)
);

comment on table DICT_ITEM_CATEGORY is 'Категория заявки';

/*==============================================================*/
/* Table: DICT_ITEM_STATE                                       */
/*==============================================================*/
create table DICT_ITEM_STATE (
   ID                   NUMERIC              not null,
   TEXT                 CHAR(2000)           null,
   constraint PK_DICT_ITEM_STATE primary key (ID)
);

comment on table DICT_ITEM_STATE is 'Статус заявки';

/*==============================================================*/
/* Table: ITEM                                                  */
/*==============================================================*/
create table ITEM (
   ID                   NUMERIC              not null,
   D_ITEM_STATE         NUMERIC              null,
   ATTACHE_ID           NUMERIC              null,
   USER_ID              NUMERIC              null,
   constraint PK_ITEM primary key (ID)
);

comment on table ITEM is 'Заявки';

/*==============================================================*/
/* Table: ITEM_COMMENTS                                         */
/*==============================================================*/
create table ITEM_COMMENTS (
   ITEM_ID              NUMERIC              null,
   COMMENT              TEXT                 null
);

/*==============================================================*/
/* Table: LINK_ROLE_PERMITS                                     */
/*==============================================================*/
create table LINK_ROLE_PERMITS (
   ROLE_ID              NUMERIC              null,
   PERMIT_ID            NUMERIC              null
);

comment on table LINK_ROLE_PERMITS is 'Связь Роль - Доступ';

/*==============================================================*/
/* Table: LINK_USER_ROLES                                       */
/*==============================================================*/
create table LINK_USER_ROLES (
   USER_ID              NUMERIC              null,
   ROLE_ID              NUMERIC              null,
   ID                   NUMERIC              null
);

comment on table LINK_USER_ROLES is 'Связь Пользователь - Роль';

/*==============================================================*/
/* Table: PERMITS                                               */
/*==============================================================*/
create table PERMITS (
   ID                   NUMERIC              not null,
   NAME                 CHAR(200)            null,
   constraint PK_PERMITS primary key (ID)
);

comment on table PERMITS is 'Доступы';

/*==============================================================*/
/* Table: ROLES                                                 */
/*==============================================================*/
create table ROLES (
   ID                   NUMERIC              not null,
   NAME                 CHAR(200)            null,
   constraint PK_ROLES primary key (ID)
);

comment on table ROLES is 'Роли';

/*==============================================================*/
/* Table: USERS                                                 */
/*==============================================================*/
create table USERS (
   ID                   NUMERIC              not null,
   SURNAME              CHAR(200)            null,
   NAME                 CHAR(200)            null,
   constraint PK_USERS primary key (ID)
);

comment on table USERS is 'Пользователи';

alter table ITEM
   add constraint FK_DICT_ITEM_CATEGORY_ITEM foreign key (D_ITEM_STATE)
      references DICT_ITEM_CATEGORY (ID);

alter table ITEM
   add constraint FK_DICT_ITEM_STATE_ITEM foreign key (ID)
      references DICT_ITEM_STATE (ID);

alter table ITEM
   add constraint FK_ITEM_ATTACHS foreign key (ATTACHE_ID)
      references ATTACHS (ID);

alter table ITEM
   add constraint FK_ITEM_USERS foreign key (USER_ID)
      references USERS (ID);

alter table ITEM_COMMENTS
   add constraint FK_ITEM_COMMENTS_ITEM foreign key (ITEM_ID)
      references ITEM (ID);

alter table LINK_ROLE_PERMITS
   add constraint FK_LINK_ROLE_PERMITS foreign key (PERMIT_ID)
      references PERMITS (ID);

alter table LINK_ROLE_PERMITS
   add constraint FK_LINK_ROLE_ROLES foreign key (ROLE_ID)
      references ROLES (ID);

alter table LINK_USER_ROLES
   add constraint FK_LINK_USER_ROLES foreign key (ID)
      references ROLES (ID);

alter table LINK_USER_ROLES
   add constraint FK_LINK_USER_LINK_USERS foreign key (ROLE_ID)
      references USERS (ID);