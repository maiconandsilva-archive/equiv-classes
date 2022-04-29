DROP SEQUENCE IF EXISTS hibernate_sequence;
DROP TABLE IF EXISTS academic_user_authorities CASCADE;
DROP TABLE IF EXISTS academic_user CASCADE;
DROP TABLE IF EXISTS equivalent_class CASCADE;
DROP TABLE IF EXISTS course CASCADE;
DROP TABLE IF EXISTS authority CASCADE;
DROP TABLE IF EXISTS academic_class CASCADE;

create sequence hibernate_sequence start 200 increment 1;

    create table academic_class (
       id int8 not null,
        code varchar(255),
        name varchar(255) not null,
        semester int4 check (semester>=1),
        workload int4 check (workload>=1),
        course_id int8 not null,
        equivalent_class_id int8,
        primary key (id)
    );

    create table academic_user (
       id uuid not null,
        active boolean not null,
        password varchar(255) not null,
        username varchar(16) not null,
        course_id int8,
        primary key (id)
    );

    create table academic_user_authorities (
       academic_user_id uuid not null,
        authorities_id int8 not null,
        primary key (academic_user_id, authorities_id)
    );

    create table authority (
       id int8 not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table course (
       id int8 not null,
        code varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table equivalent_class (
       id int8 not null,
        primary key (id)
    );

    alter table academic_user 
       add constraint UK_qtrmfd5eblg6ga5iqrx0drt2u unique (username);

    alter table authority 
       add constraint UK_jdeu5vgpb8k5ptsqhrvamuad2 unique (name);

    alter table academic_class 
       add constraint FKab86osg7cdjy6fs427lous01f 
       foreign key (course_id) 
       references course;

    alter table academic_class 
       add constraint FKk6lmvueyqeawgvb3x6a2mdstw 
       foreign key (equivalent_class_id) 
       references equivalent_class;

    alter table academic_user 
       add constraint FK4thhcvin58pt1fvru8ketlvfi 
       foreign key (course_id) 
       references course;

    alter table academic_user_authorities 
       add constraint FKqbkffaqfrsfc8g342yawj4gqw 
       foreign key (authorities_id) 
       references authority;

    alter table academic_user_authorities 
       add constraint FK4ose9r0jk7vrdn5n1ue9avuvk 
       foreign key (academic_user_id) 
       references academic_user;
