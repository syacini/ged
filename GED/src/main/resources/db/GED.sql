/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  18/02/2016 23:16:52                      */
/*==============================================================*/


drop table if exists T_ACTION;

drop table if exists T_AVOIR_HABILITATION;

drop table if exists T_AVOIR_ROLE;

drop table if exists T_BIBLIOTHEQUE;

drop table if exists T_CONTENEUR;

drop table if exists T_DOCUMENT;

drop table if exists T_EMPLACEMENT_PHYSIQUE;

drop table if exists T_HISTORIQUE_ACTIONS_DOCUMENTS;

drop table if exists T_ROLE;

drop table if exists T_STATUT;

drop table if exists T_TYPE_DOCUMENT;

drop table if exists T_UTILISATEUR;

/*==============================================================*/
/* Table : ACTION                                               */
/*==============================================================*/
create table T_ACTION
(
   ID_ACTION            tinyint unsigned not null auto_increment,
   LIBELLE_ACTION       varchar(32) not null,
   primary key (ID_ACTION)
);

/*==============================================================*/
/* Table : AVOIR_HABILITATION                                   */
/*==============================================================*/
create table T_AVOIR_HABILITATION
(
   ID_ROLE              tinyint unsigned not null,
   ID_ACTION            tinyint unsigned not null,
   primary key (ID_ROLE, ID_ACTION)
);

/*==============================================================*/
/* Table : AVOIR_ROLE                                           */
/*==============================================================*/
create table T_AVOIR_ROLE
(
   ID_UTILISATEUR       tinyint unsigned not null,
   ID_BIBLIOTHEQUE      tinyint unsigned not null,
   ID_ROLE              tinyint unsigned not null,
   primary key (ID_UTILISATEUR, ID_BIBLIOTHEQUE, ID_ROLE)
);

/*==============================================================*/
/* Table : BIBLIOTHEQUE                                         */
/*==============================================================*/
create table T_BIBLIOTHEQUE
(
   ID_BIBLIOTHEQUE      tinyint unsigned not null auto_increment,
   LIBELLE_BIBLIOTHEQUE varchar(32) not null,
   primary key (ID_BIBLIOTHEQUE)
);

/*==============================================================*/
/* Table : CONTENEUR                                            */
/*==============================================================*/
create table T_CONTENEUR
(
   ID_CONTENEUR         smallint unsigned not null auto_increment,
   ID_CONTENEUR_PARENT  smallint unsigned,
   ID_BIBLIOTHEQUE      tinyint unsigned,
   ID_EMPLACEMENT       smallint unsigned not null,
   LIBELLE_CONTENEUR    varchar(64) not null,
   DATE_HEURE_CLASSEMENT datetime not null,
   primary key (ID_CONTENEUR)
);

/*==============================================================*/
/* Table : DOCUMENT                                             */
/*==============================================================*/
create table T_DOCUMENT
(
   ID_DOCUMENT          int unsigned not null auto_increment,
   ID_STATUT            tinyint unsigned not null,
   ID_CONTENEUR         smallint unsigned not null,
   ID_TYPE_DOCUMENT     smallint unsigned not null,
   LIBELLE_DOCUMENT     varchar(255) not null,
   DESCRIPTION_DOCUMENT longtext,
   TAILLE_DOCUMENT      bigint unsigned not null,
   CONTENU_DOCUMENT     longblob not null,
   DATE_HEURE_STATUT_DOCUMENT datetime not null,
   primary key (ID_DOCUMENT)
);

/*==============================================================*/
/* Table : EMPLACEMENT_PHYSIQUE                                 */
/*==============================================================*/
create table T_EMPLACEMENT_PHYSIQUE
(
   ID_EMPLACEMENT       smallint unsigned not null auto_increment,
   LIBELLE_EMPLACEMENT  varchar(255) not null,
   primary key (ID_EMPLACEMENT)
);

/*==============================================================*/
/* Table : HISTORIQUE_ACTIONS_DOCUMENTS                         */
/*==============================================================*/
create table T_HISTORIQUE_ACTIONS_DOCUMENTS
(
   ID_ACTION            tinyint unsigned not null,
   ID_UTILISATEUR       tinyint unsigned not null,
   ID_DOCUMENT          int unsigned not null,
   DATE_HEURE_ACTION    datetime not null,
   primary key (ID_ACTION, ID_UTILISATEUR, ID_DOCUMENT, DATE_HEURE_ACTION)
);

/*==============================================================*/
/* Table : ROLE                                                 */
/*==============================================================*/
create table T_ROLE
(
   ID_ROLE              tinyint unsigned not null auto_increment,
   LIBELLE_ROLE         varchar(32) not null,
   primary key (ID_ROLE)
);

/*==============================================================*/
/* Table : STATUT                                               */
/*==============================================================*/
create table T_STATUT
(
   ID_STATUT            tinyint unsigned not null auto_increment,
   LIBELLE_STATUT       varchar(64) not null,
   CODE_STATUT          tinyint not null,
   primary key (ID_STATUT)
);

/*==============================================================*/
/* Table : TYPE_DOCUMENT                                        */
/*==============================================================*/
create table T_TYPE_DOCUMENT
(
   ID_TYPE_DOCUMENT     smallint unsigned not null auto_increment,
   ID_SUPER_TYPE        smallint unsigned,
   LIBELLE_TYPE_DOCUMENT varchar(64) not null,
   CODE_TYPE_DOCUMENT   smallint not null,
   primary key (ID_TYPE_DOCUMENT)
);

/*==============================================================*/
/* Table : UTILISATEUR                                          */
/*==============================================================*/
create table T_UTILISATEUR
(
   ID_UTILISATEUR       tinyint unsigned not null auto_increment,
   NOM                  varchar(32) not null,
   PRENOM               varchar(32) not null,
   EMAIL                varchar(128) not null,
   USERNAME             varchar(8) not null,
   PASSWORD             text not null,
   primary key (ID_UTILISATEUR)
);

alter table T_AVOIR_HABILITATION add constraint FK_T_AVOIR_HABILITATION foreign key (ID_ROLE)
      references T_ROLE (ID_ROLE) on delete restrict on update restrict;

alter table T_AVOIR_HABILITATION add constraint FK_T_AVOIR_HABILITATION2 foreign key (ID_ACTION)
      references T_ACTION (ID_ACTION) on delete restrict on update restrict;

alter table T_AVOIR_ROLE add constraint FK_T_AVOIR_ROLE foreign key (ID_UTILISATEUR)
      references T_UTILISATEUR (ID_UTILISATEUR) on delete restrict on update restrict;

alter table T_AVOIR_ROLE add constraint FK_T_AVOIR_ROLE2 foreign key (ID_BIBLIOTHEQUE)
      references T_BIBLIOTHEQUE (ID_BIBLIOTHEQUE) on delete restrict on update restrict;

alter table T_AVOIR_ROLE add constraint FK_T_AVOIR_ROLE3 foreign key (ID_ROLE)
      references T_ROLE (ID_ROLE) on delete restrict on update restrict;

alter table T_CONTENEUR add constraint FK_T_CONTENIR_CONTENEUR foreign key (ID_BIBLIOTHEQUE)
      references T_BIBLIOTHEQUE (ID_BIBLIOTHEQUE) on delete restrict on update restrict;

alter table T_CONTENEUR add constraint FK_T_EST_CONTENU foreign key (ID_CONTENEUR_PARENT)
      references T_CONTENEUR (ID_CONTENEUR) on delete restrict on update restrict;

alter table T_CONTENEUR add constraint FK_T_ETRE_SITUE foreign key (ID_EMPLACEMENT)
      references T_EMPLACEMENT_PHYSIQUE (ID_EMPLACEMENT) on delete restrict on update restrict;

alter table T_DOCUMENT add constraint FK_T_AVOIR_LE_STATUT foreign key (ID_STATUT)
      references T_STATUT (ID_STATUT) on delete restrict on update restrict;

alter table T_DOCUMENT add constraint FK_T_CONTENIR_DOCUMENT foreign key (ID_CONTENEUR)
      references T_CONTENEUR (ID_CONTENEUR) on delete restrict on update restrict;

alter table T_DOCUMENT add constraint FK_T_ETRE_DE_TYPE foreign key (ID_TYPE_DOCUMENT)
      references T_TYPE_DOCUMENT (ID_TYPE_DOCUMENT) on delete restrict on update restrict;

alter table T_HISTORIQUE_ACTIONS_DOCUMENTS add constraint FK_T_HISTORIQUE_ACTIONS_DOCUMENTS foreign key (ID_ACTION)
      references T_ACTION (ID_ACTION) on delete restrict on update restrict;

alter table T_HISTORIQUE_ACTIONS_DOCUMENTS add constraint FK_T_HISTORIQUE_ACTIONS_DOCUMENTS2 foreign key (ID_UTILISATEUR)
      references T_UTILISATEUR (ID_UTILISATEUR) on delete restrict on update restrict;

alter table T_HISTORIQUE_ACTIONS_DOCUMENTS add constraint FK_T_HISTORIQUE_ACTIONS_DOCUMENTS3 foreign key (ID_DOCUMENT)
      references T_DOCUMENT (ID_DOCUMENT) on delete restrict on update restrict;

alter table T_TYPE_DOCUMENT add constraint FK_T_SUPER_TYPE foreign key (ID_SUPER_TYPE)
      references T_TYPE_DOCUMENT (ID_TYPE_DOCUMENT) on delete restrict on update restrict;

ALTER TABLE `db_geseld`.`t_utilisateur` ADD COLUMN `ACTIF` BOOLEAN NOT NULL DEFAULT 0 AFTER `PASSWORD`;