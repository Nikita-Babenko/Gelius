INSERT INTO client (company_name, phone_number) VALUES ('ABK', '+38050-355-62-78');
INSERT INTO client (company_name, phone_number) VALUES ('Lasunka', '+38066-355-62-78');
INSERT INTO client (company_name, phone_number) VALUES ('Petruschenko', '+38067-355-62-78');


INSERT INTO product_type (product_type) VALUES ('Box (4 flaps)');
INSERT INTO product_type (product_type) VALUES ('Ящик сложный');
INSERT INTO product_type (product_type) VALUES ('Ящик (крышка)');
INSERT INTO product_type (product_type) VALUES ('Box (bottom)');
INSERT INTO product_type (product_type) VALUES ('Tray');
INSERT INTO product_type (product_type) VALUES ('Трейс');
INSERT INTO product_type (product_type) VALUES ('Лист');
INSERT INTO product_type (product_type) VALUES ('barrier');
INSERT INTO product_type (product_type) VALUES ('Прокладка');
INSERT INTO product_type (product_type) VALUES ('Уголок');
INSERT INTO product_type (product_type) VALUES ('Двухслойка рулон');
INSERT INTO product_type (product_type) VALUES ('Комплектация');
INSERT INTO product_type (product_type) VALUES ('Bush');
INSERT INTO product_type (product_type) VALUES ('Комплект');
INSERT INTO product_type (product_type) VALUES ('Шоубокс');
INSERT INTO product_type (product_type) VALUES ('Гофрозаготовка');
INSERT INTO product_type (product_type) VALUES ('Лист необрезной');


INSERT INTO format (format) VALUES ('1050');
INSERT INTO format (format) VALUES ('1250');
INSERT INTO format (format) VALUES ('1400');
INSERT INTO format (format) VALUES ('1510');


INSERT INTO profile (profile) VALUES ('В');
INSERT INTO profile (profile) VALUES ('Е');
INSERT INTO profile (profile) VALUES ('С');
INSERT INTO profile (profile) VALUES ('ВЕ');
INSERT INTO profile (profile) VALUES ('ВС');
INSERT INTO profile (profile) VALUES ('СЕ');


INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-21');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-21КРАШ');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-24Бел');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-21Бел');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-21Целл');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-22ЦЕЛ+ЦЕЛ');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-22Бел');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-22ЦЕЛ+ЦЕЛ');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-22 КРАШ');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-22Целл');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-23');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-23Бел');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-23Бел+Целл');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-24Целл');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-24КРАШ');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-24 НМ');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-23Целл');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-23ДвеЦелл');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-24');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-22');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-24БелЦелл');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-24ДвеЦелл');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-25');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-25Бел');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-25Бел+Целл');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-25Целл');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('Т-25ДвеЦелл');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('КГ-1');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('КГ-2');
INSERT INTO cardboard_brand (cardboard_brand) VALUES ('КГ-4');


INSERT INTO cellulose_layer (cellulose_layer) VALUES
  ('нет'),
  ('внутренний'),
  ('наружный'),
  ('оба');


INSERT INTO face_layer (face_layer) VALUES ('Белый');
INSERT INTO face_layer (face_layer) VALUES ('Бурый');
INSERT INTO face_layer (face_layer) VALUES ('Крашеный');
INSERT INTO face_layer (face_layer) VALUES ('НМ');
INSERT INTO face_layer (face_layer) VALUES ('МО');


INSERT INTO inner_layer (inner_layer) VALUES ('Белый');
INSERT INTO inner_layer (inner_layer) VALUES ('Бурый');
INSERT INTO inner_layer (inner_layer) VALUES ('Крашеный');
INSERT INTO inner_layer (inner_layer) VALUES ('НМ');
INSERT INTO inner_layer (inner_layer) VALUES ('МО');


INSERT INTO connection_valve (connection_valve) VALUES ('склееный');
INSERT INTO connection_valve (connection_valve) VALUES ('сшитый');
INSERT INTO connection_valve (connection_valve) VALUES ('склееный+сшитый');


INSERT INTO workability (service_center, group_priority, element_priority) VALUES
    ('АГ', NULL, NULL),
    ('Тайванец', 10, 10),
    ('Болгарец', 10, 20),
    ('Сшивка ручная', 20, 10),
    ('Сшивка автомат', 20, 20),
    ('Склейка ручная', 30, 10),
    ('Склейка 3 точки', 30, 20),
    ('БОБСТ', 40, NULL),
    ('Ротация', 50, NULL),
    ('Тигель большой', 60, 10),
    ('Тигель малый', 60, 20),
    ('Ролевый', 60, 30),
    ('К. Р.', 70, NULL),
    ('БОИКС', 80, NULL),
    ('Перегородки', 90, NULL),
    ('Упаковка', 10, NULL)
;


INSERT INTO packing (packing) VALUES ('Без упаковки');
INSERT INTO packing (packing) VALUES ('Паллета, лента, стрейч');
INSERT INTO packing (packing) VALUES ('Паллета, лента, без стрейча');
INSERT INTO packing (packing) VALUES ('Паллета, стрейч, без ленты');
INSERT INTO packing (packing) VALUES ('2 пака на паллете');

SELECT * FROM packing;


INSERT INTO pallet (pallet) VALUES ('1200х800');
INSERT INTO pallet (pallet) VALUES ('1200х1000');


INSERT INTO pallet_placement (pallet_placement) VALUES ('1 пачка в ряду');
INSERT INTO pallet_placement (pallet_placement) VALUES ('2 пачки в ряду');
INSERT INTO pallet_placement (pallet_placement) VALUES ('3 пачки в ряду');
INSERT INTO pallet_placement (pallet_placement) VALUES ('4 пачки в ряду');
INSERT INTO pallet_placement (pallet_placement) VALUES ('5 пачек в ряду');
INSERT INTO pallet_placement (pallet_placement) VALUES ('6 пачек в ряду');
INSERT INTO pallet_placement (pallet_placement) VALUES ('8 пачек в ряду');

INSERT INTO product (product_number, isNew, product_type_id, inner_height,
                     inner_length, inner_width, cardboard_brand_id, client_id,
                     face_layer_id, inner_layer_id, profile_id, cliche, blank_format)
VALUES
  (1, true, 4, 340, 220, 410, 11, 2, 1, 2, 6, 'Lasunka', 4),
  (2, true, 5, 350, 210, 450, 4, 3, 2, 1, 3, 'Petruschenko', 5),
  (1800, false, 1, 310, 350, 210, 2, 2, 4, 3, 3, 'Lasunka', 7),
  (1645, false, 1, 310, 360, 210, 7, 1, 5, 2, 4, 'AVK', 8),
  (19, false, 1, 310, 360, 210, 7, 1, 5, 2, 4, 'АВК', 8),
  (3, true, 3, 310, 350, 210, 7, 2, 1, 5, 2, 'Ласунка', 9),
  (4, true, 15, 310, 350, 210, 3, 3, 1, 5, 2, 'ABK', 9);


COMMIT;