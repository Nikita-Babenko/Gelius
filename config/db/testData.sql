INSERT INTO client (company_name, phone_number) VALUES
  ('ABK', '+38050-355-62-78'),
  ('Lasunka', '+38066-355-62-78'),
  ('Petruschenko', '+38067-355-62-78');


INSERT INTO product_type (product_type) VALUES
  ('Box (4 flaps)'),
  ('Ящик сложный'),
  ('Ящик (крышка)'),
  ('Box (bottom)'),
  ('Tray'),
  ('Трейс'),
  ('Лист'),
  ('barrier'),
  ('Прокладка'),
  ('Уголок'),
  ('Двухслойка рулон'),
  ('Комплектация'),
  ('Bush'),
  ('Комплект'),
  ('Шоубокс'),
  ('Гофрозаготовка'),
  ('Лист необрезной');


INSERT INTO format (format) VALUES
  ('1050'), ('1250'), ('1400'), ('1510');


INSERT INTO profile (profile) VALUES
  ('В'), ('Е'), ('С'), ('ВЕ'), ('ВС'), ('СЕ');


INSERT INTO cardboard_brand (cardboard_brand) VALUES
  ('Т-21'), ('Т-21КРАШ'), ('Т-24Бел'), ('Т-21Бел'), ('Т-21Целл'),
  ('Т-22ЦЕЛ+ЦЕЛ'), ('Т-22Бел'), ('Т-22ЦЕЛ+ЦЕЛ'), ('Т-22 КРАШ'),
  ('Т-22Целл'), ('Т-23'), ('Т-23Бел'), ('Т-23Бел+Целл'), ('Т-24Целл'),
  ('Т-24КРАШ'), ('Т-24 НМ'), ('Т-23Целл'), ('Т-23ДвеЦелл'), ('Т-24'),
  ('Т-22'), ('Т-24БелЦелл'), ('Т-24ДвеЦелл'), ('Т-25'), ('Т-25Бел'),
  ('Т-25Бел+Целл'), ('Т-25Целл'), ('Т-25ДвеЦелл'), ('КГ-1'), ('КГ-2'), ('КГ-4');


INSERT INTO cellulose_layer (cellulose_layer) VALUES
  ('нет'), ('внутренний'), ('наружный'), ('оба');


INSERT INTO face_layer (face_layer) VALUES
  ('Белый'), ('Бурый'), ('Крашеный'), ('НМ'), ('МО');


INSERT INTO inner_layer (inner_layer) VALUES
  ('Белый'), ('Бурый'), ('Крашеный'), ('НМ'), ('МО');


INSERT INTO connection_valve (connection_valve) VALUES
  ('склееный'), ('сшитый'), ('склееный+сшитый');


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
  ('Упаковка', 100, NULL)
;


INSERT INTO packing (packing) VALUES
  ('Без упаковки'),
  ('Паллета, лента, стрейч'),
  ('Паллета, лента, без стрейча'),
  ('Паллета, стрейч, без ленты'),
  ('2 пака на паллете');


INSERT INTO pallet (pallet) VALUES
  ('1200х800'), ('1200х1000');


INSERT INTO pallet_placement (pallet_placement) VALUES
  ('1 пачка в ряду'), ('2 пачки в ряду'), ('3 пачки в ряду'),
  ('4 пачки в ряду'), ('5 пачек в ряду'), ('6 пачек в ряду'), ('8 пачек в ряду');

INSERT INTO product (product_number, isNew, product_type_id, inner_height,
                     inner_length, inner_width, cardboard_brand_id, client_id,
                     face_layer_id, inner_layer_id, profile_id, cliche, blank_format)
VALUES
  (1, true, 4, 340, 220, 410, 11, 2, 1, 2, 6, 'Lasunka', 4),
  (2, true, 5, 350, 210, 450, 4, 3, 2, 1, 3, 'Petruschenko', 5),
  (1800, false, 1, 310, 350, 210, 2, 2, 4, 3, 3, 'Lasunka', 7),
  (1645, false, 1, 310, 360, 210, 7, 1, 5, 2, 4, 'ABK', 8),
  (3, true, 3, 310, 350, 210, 7, 2, 1, 5, 2, 'Lasunka', 9),
  (4, true, 15, 310, 350, 210, 3, 3, 1, 5, 2, 'ABK', 9);


COMMIT;