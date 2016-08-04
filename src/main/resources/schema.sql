DROP TABLE IF EXISTS CLIENTS;
DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS ORDERS;
DROP TABLE IF EXISTS REQUESTS;

CREATE TABLE cardboard_brand
(
  CARDBOARD_BRAND_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  CARDBOARD_BRAND VARCHAR(50)
);
CREATE TABLE cardboard_type
(
  CARDBOARD_TYPE_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  CARDBOARD_TYPE VARCHAR(50)
);
CREATE TABLE cellulouse_layer
(
  CELLULOUSE_LAYER_ID BIGINT PRIMARY KEY NOT NULL,
  CELLULOSIC_LAYER VARCHAR(50)
);
CREATE TABLE clients
(
  CLIENTS_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  ADDRESS VARCHAR(200),
  COMPANY_NAME VARCHAR(50) NOT NULL,
  DESCRIPTION VARCHAR(255),
  FIRST_NAME VARCHAR(30),
  LAST_NAME VARCHAR(30),
  PHONE_NUMBER VARCHAR(20) NOT NULL
);
CREATE TABLE compound
(
  COMPOUND_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  COMPOUND VARCHAR(50)
);
CREATE TABLE face_layer
(
  FACE_LAYER_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  FACE_LAYER VARCHAR(50)
);
CREATE TABLE format
(
  FORMAT_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  FORMAT VARCHAR(50)
);
CREATE TABLE inner_layer
(
  INNER_LAYER_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  INNER_LAYER VARCHAR(50)
);
CREATE TABLE packing
(
  PACKING_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  PACKING VARCHAR(50)
);
CREATE TABLE pallet
(
  PALLET_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  PALLET VARCHAR(50)
);
CREATE TABLE paper_type
(
  PAPER_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  PAPER_TYPE VARCHAR(50)
);
CREATE TABLE placement
(
  PLACEMENT_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  PLACEMENT VARCHAR(50)
);
CREATE TABLE product_type
(
  PRODUCT_TYPE_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  PRODUCT_TYPE VARCHAR(50)
);
CREATE TABLE products
(
  PRODUCT_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  CLIENTS_ID BIGINT,
  PRODUCTS_NAME VARCHAR(200),
  PRODUCTS_TYPE_ID BIGINT,
  INNER_LENGTH INT,
  INNER_WIDTH INT,
  INNER_HEIGHT INT,
  CARDBOARD_BRAND_ID BIGINT,
  PROFILE_ID BIGINT,
  CELLULOUSE_LAYER_ID BIGINT,
  FACE_LAYER_ID BIGINT,
  PRINT VARCHAR(30),
  ACTIVITY CHAR(1)
);
CREATE TABLE profile
(
  PROFILE_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  PROFILE VARCHAR(50)
);
CREATE TABLE raw_manufacturer
(
  MANUFACTURER_ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  MANUFACTURER VARCHAR(50),
  RAW_MANUFACTURER_ID BIGINT NOT NULL
);
ALTER TABLE products ADD FOREIGN KEY (CLIENTS_ID) REFERENCES clients (CLIENTS_ID);
ALTER TABLE products ADD FOREIGN KEY (PRODUCTS_TYPE_ID) REFERENCES product_type (PRODUCT_TYPE_ID);
ALTER TABLE products ADD FOREIGN KEY (CARDBOARD_BRAND_ID) REFERENCES cardboard_brand (CARDBOARD_BRAND_ID);
ALTER TABLE products ADD FOREIGN KEY (PROFILE_ID) REFERENCES profile (PROFILE_ID);
ALTER TABLE products ADD FOREIGN KEY (CELLULOUSE_LAYER_ID) REFERENCES cellulouse_layer (CELLULOUSE_LAYER_ID);
ALTER TABLE products ADD FOREIGN KEY (FACE_LAYER_ID) REFERENCES face_layer (FACE_LAYER_ID);
CREATE INDEX idx_products_PRODUCTS_TYPE_ID ON products (PRODUCTS_TYPE_ID);


