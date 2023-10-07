CREATE TABLE client(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE product_order(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  control_number BIGINT NOT NULL,
  date_register DATE NOT NULL,
  name VARCHAR(200) NOT NULL,
  product_value Decimal(10,2) NOT NULL,
  product_total Decimal (10,2) NOT NULL,
  product_amount BIGINT NOT NULL,
  id_client BIGINT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE product_order ADD CONSTRAINT product_order_client_FK FOREIGN KEY (id_client) REFERENCES client(id);