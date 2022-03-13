
create table user_registrations(
   reg_id INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(100) NOT NULL,
   last_name VARCHAR(40) NOT NULL,
   gender VARCHAR(10) NOT NULL,
   created_date DATETIME,
   update_date DATETIME,
   PRIMARY KEY ( reg_id )
);
create table users(
   user_id INT NOT NULL AUTO_INCREMENT,
   user_name VARCHAR(100) NOT NULL,
   password VARCHAR(40) NOT NULL,
   reg_id_fk INT NOT NULL,
   PRIMARY KEY ( user_id ),
    CONSTRAINT UC_NAME UNIQUE (user_name),
       CONSTRAINT FK_USER_REG_ID FOREIGN KEY (reg_id_fk)
            REFERENCES user_registrations(reg_id)
);

create table roles(
   role_id INT NOT NULL AUTO_INCREMENT,
   role_name VARCHAR(100) NOT NULL,
   PRIMARY KEY ( role_id )
);



create table user_roles(
   user_role_id INT NOT NULL AUTO_INCREMENT,
   user_id_fk INT NOT NULL,
   role_id_fk INT NOT NULL,
   assign_date DATETIME,
   PRIMARY KEY ( user_role_id ),
       CONSTRAINT FK_USER FOREIGN KEY (user_id_fk)
        REFERENCES users(user_id),
             CONSTRAINT FK_ROLES FOREIGN KEY (role_id_fk)
                REFERENCES roles(role_id)

);


