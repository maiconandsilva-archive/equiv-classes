DROP SEQUENCE hibernate_sequence IF EXISTS;
DROP TABLE academic_user_authorities IF EXISTS CASCADE;
DROP TABLE academic_user IF EXISTS CASCADE;
DROP TABLE equivalent_class IF EXISTS CASCADE;
DROP TABLE course IF EXISTS CASCADE;
DROP TABLE authority IF EXISTS CASCADE;
DROP TABLE academic_class IF EXISTS CASCADE;

create sequence hibernate_sequence start with 200 increment by 1;

    create table academic_class (
       id bigint not null,
        code varchar(255),
        name varchar(255) not null,
        semester integer check (semester>=1),
        workload integer check (workload>=1),
        course_id bigint not null,
        equivalent_class_id bigint,
        primary key (id)
    );

    create table authority (
       id bigint not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table course (
       id bigint not null,
        code varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table equivalent_class (
       id bigint not null,
        primary key (id)
    );

    create table academic_user (
       id binary(255) not null,
        username varchar(16) not null,
        password varchar(255) not null,
        active boolean not null,
        course_id bigint,
        primary key (id)
    );

    create table academic_user_authorities (
        academic_user_id binary(255) not null,
        authorities_id bigint not null,
        primary key (academic_user_id, authorities_id)
    );

    alter table authority
       add constraint UK_jdeu5vgpb8k5ptsqhrvamuad2 unique (name);

    alter table academic_user
       add constraint UK_tniqa4knwfiv5c7pa01sh0ma unique (course_id);

    alter table academic_user
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username);

    alter table academic_class
       add constraint FKab86osg7cdjy6fs427lous01f
       foreign key (course_id)
       references course;

    alter table academic_class
       add constraint FKk6lmvueyqeawgvb3x6a2mdstw
       foreign key (equivalent_class_id)
       references equivalent_class;

    alter table academic_user
       add constraint FKj8ce5cjkm11igsffixdxexrr9
       foreign key (course_id)
       references course;

    alter table academic_user_authorities
       add constraint FKdd8lhvujos470g40gikxj22mb
       foreign key (authorities_id)
       references authority;

    alter table academic_user_authorities
       add constraint FKmj13d0mnuj4cd8b6htotbf9mm
       foreign key (academic_user_id)
       references academic_user;
