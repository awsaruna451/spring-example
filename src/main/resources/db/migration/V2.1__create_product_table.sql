
create table products(
   id INT NOT NULL AUTO_INCREMENT,
   product_name VARCHAR(100) NOT NULL,
   quantity INT NOT NULL DEFAULT 0,
   price FLOAT NOT NULL DEFAULT 0,
   created_date DATETIME,
   update_date DATETIME,
   PRIMARY KEY ( id )
);

create table orders(
   id INT NOT NULL AUTO_INCREMENT,
   user_id VARCHAR(100) NOT NULL,
   product_id INT NOT NULL,
   order_quantity INT NOT NULL,
   order_amount FLOAT NOT NULL DEFAULT 0,
   created_date DATETIME,
   update_date DATETIME,
   PRIMARY KEY ( id )
);


