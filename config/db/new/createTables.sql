/* Клиент */
CREATE TABLE client(
  client_id BIGINT AUTO_INCREMENT,
  address VARCHAR(200),
  company_name VARCHAR(50) NOT NULL,
  description VARCHAR(255),
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  phone_number VARCHAR(20) NOT NULL,

  PRIMARY KEY (client_id)
);

/* Тип изделия */
CREATE TABLE product_type(
  product_type_id BIGINT AUTO_INCREMENT,
  product_type VARCHAR(50),

  PRIMARY KEY(product_type_id)
);

/* Расчетный формат */
CREATE TABLE format(
  format_id BIGINT AUTO_INCREMENT,
  format VARCHAR(50),

  PRIMARY KEY(format_id)
);

/* Профиль */
CREATE TABLE profile(
  profile_id BIGINT AUTO_INCREMENT,
  profile VARCHAR(50),

  PRIMARY KEY(profile_id)
);

/* Марка картона */
CREATE TABLE cardboard_brand(
  cardboard_brand_id BIGINT AUTO_INCREMENT,
  cardboard_brand VARCHAR(50),

  PRIMARY KEY (cardboard_brand_id)
);

/* Целюлозный слой */
CREATE TABLE cellulose_layer(
  cellulose_layer_id BIGINT AUTO_INCREMENT,
  cellulose_layer VARCHAR(50),

  PRIMARY KEY (cellulose_layer_id)
);

/* Лицевой слой */
CREATE TABLE face_layer(
  face_layer_id BIGINT AUTO_INCREMENT,
  face_layer VARCHAR(50),

  PRIMARY KEY (face_layer_id)
);

/* Внутренний слой */
CREATE TABLE inner_layer(
  inner_layer_id BIGINT AUTO_INCREMENT,
  inner_layer VARCHAR(50),

  PRIMARY KEY (inner_layer_id)
);

/* Соединение клапана */
CREATE TABLE connection_valve(
  connection_valve_id BIGINT AUTO_INCREMENT,
  connection_valve VARCHAR(50),

  PRIMARY KEY (connection_valve_id)
);

/* Рабочие центры (технологичность) */
CREATE TABLE workability(
  workability_id BIGINT AUTO_INCREMENT,
  service_center VARCHAR(100),
  group_priority INT,
  element_priority INT,

  PRIMARY KEY (workability_id)
);

/* Способ упаковки */
CREATE TABLE packing(
  packing_id BIGINT AUTO_INCREMENT,
  packing VARCHAR(50),

  PRIMARY KEY (packing_id)
);

CREATE TABLE pallet(
  pallet_id BIGINT AUTO_INCREMENT,
  pallet VARCHAR(50),

  PRIMARY KEY (pallet_id)
);

/* Поддон */
CREATE TABLE pallet_placement(
  pallet_placement_id BIGINT AUTO_INCREMENT,
  pallet_placement VARCHAR(50),

  PRIMARY KEY (pallet_placement_id)
);

/* Продукт */
CREATE TABLE product(
  product_id BIGINT AUTO_INCREMENT,

  product_number BIGINT NOT NULL,
  isNew BOOLEAN NOT NULL,

  product_create DATE,
  product_update DATE,
  person_prepared VARCHAR(50),

  isUse BOOLEAN,
  client_id BIGINT,
  product_name VARCHAR(200),
  product_type_id BIGINT,

  inner_length INT,
  inner_width INT,
  inner_height INT,
  theoretical_square DECIMAL(5,3),
  actual_square DECIMAL(5,3),
  format_id BIGINT,
  profile_id BIGINT,
  cardboard_brand_id BIGINT,
  cellulose_layer_id BIGINT,
  face_layer_id BIGINT,
  inner_layer_id BIGINT,
  material VARCHAR(200),

  size_workpiece_length INT,
  size_workpiece_width INT,
  number_from_sheet INT,
  blank_format INT NOT NULL,
  connection_valve_id BIGINT,
  stamp VARCHAR(50),
  cliche VARCHAR(50),
  packing_id BIGINT,
  number_in_pack INT,
  number_in_transport_package INT,
  package_length INT,
  package_width INT,
  package_height INT,
  pallet_id BIGINT,
  pallet_placement_id BIGINT,
  pallet_rows INT,
  number_load_car INT,
  production_format INT,

  PRIMARY KEY (product_id),
  UNIQUE(product_number, isNew),
  FOREIGN KEY (client_id) REFERENCES client(client_id),
  FOREIGN KEY (product_type_id) REFERENCES product_type(product_type_id),
  FOREIGN KEY (format_id) REFERENCES format(format_id),
  FOREIGN KEY (profile_id) REFERENCES profile(profile_id),
  FOREIGN KEY (cardboard_brand_id) REFERENCES cardboard_brand(cardboard_brand_id),
  FOREIGN KEY (cellulose_layer_id) REFERENCES cellulose_layer(cellulose_layer_id),
  FOREIGN KEY (face_layer_id) REFERENCES face_layer(face_layer_id),
  FOREIGN KEY (inner_layer_id) REFERENCES inner_layer(inner_layer_id),
  FOREIGN KEY (connection_valve_id) REFERENCES connection_valve(connection_valve_id),
  FOREIGN KEY (packing_id) REFERENCES packing(packing_id),
  FOREIGN KEY (pallet_id) REFERENCES pallet(pallet_id),
  FOREIGN KEY (pallet_placement_id) REFERENCES pallet_placement(pallet_placement_id)
);

/* Печать */
CREATE TABLE print(
  print_id BIGINT AUTO_INCREMENT,
  product_id BIGINT NOT NULL,
  colour VARCHAR(50),
  name VARCHAR(50),
  square_seal INT,

  PRIMARY KEY (print_id),
  FOREIGN KEY (product_id) REFERENCES product(product_id)
);

/* Примечания */
CREATE  TABLE workability_notes(
  workability_notes_id BIGINT AUTO_INCREMENT,
  product_id BIGINT NOT NULL,
  service_center BIGINT,
  notes VARCHAR(100),

  PRIMARY KEY (workability_notes_id),
  FOREIGN KEY (product_id) REFERENCES product(product_id),
  FOREIGN KEY (service_center) REFERENCES workability(workability_id)
);

/* Просечки */
CREATE TABLE perforation(
  perforation_id BIGINT AUTO_INCREMENT,
  product_id BIGINT NOT NULL,
  value INT,

  PRIMARY KEY (perforation_id),
  FOREIGN KEY (product_id) REFERENCES product(product_id)
);

COMMIT;