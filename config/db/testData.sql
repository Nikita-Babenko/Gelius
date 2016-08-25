INSERT INTO client (client_id, company_name, phone_number) VALUES
  (1, 'АВК', '+38050-355-62-78'),
  (2, 'Ласунка', '+38066-355-62-78'),
  (3, 'Пертущенко', '+38067-355-62-78');


INSERT INTO product_type (product_type_id, product_type) VALUES
  (1, 'Ящик (4 flaps)'),
  (2, 'Ящик сложный'),
  (3, 'Ящик (крышка)'),
  (4, 'Box (bottom)'),
  (5, 'Tray'),
  (6, 'Трейс'),
  (7, 'Лист'),
  (8, 'barrier'),
  (9, 'Прокладка'),
  (10, 'Уголок'),
  (11, 'Двухслойка рулон'),
  (12, 'Комплектация'),
  (13, 'Bush'),
  (14, 'Комплект'),
  (15, 'Шоубокс'),
  (16, 'Гофрозаготовка'),
  (17, 'Лист необрезной');


INSERT INTO format (format_id, format) VALUES
  (1, '1050'), (2, '1250'), (3, '1400'), (4, '1510');


INSERT INTO profile (profile_id, profile) VALUES
  (1, 'В'), (2, 'Е'), (3, 'С'), (4, 'ВЕ'), (5, 'ВС'), (6, 'СЕ');


INSERT INTO cardboard_brand (cardboard_brand_id, cardboard_brand) VALUES
  (1, 'Т-21'), (2, 'Т-21КРАШ'), (3, 'Т-24Бел'), (4, 'Т-21Бел'), (5, 'Т-21Целл'),
  (6, 'Т-22ЦЕЛ+ЦЕЛ'), (7, 'Т-22Бел'), (8, 'Т-22ЦЕЛ+ЦЕЛ'), (9, 'Т-22 КРАШ'),
  (10, 'Т-22Целл'), (11, 'Т-23'), (12, 'Т-23Бел'), (13, 'Т-23Бел+Целл'), (14, 'Т-24Целл'),
  (15, 'Т-24КРАШ'), (16, 'Т-24 НМ'), (17, 'Т-23Целл'), (18, 'Т-23ДвеЦелл'), (19, 'Т-24'),
  (20, 'Т-22'), (21, 'Т-24БелЦелл'), (22, 'Т-24ДвеЦелл'), (23, 'Т-25'), (24, 'Т-25Бел'),
  (25, 'Т-25Бел+Целл'), (26, 'Т-25Целл'), (27, 'Т-25ДвеЦелл'), (28, 'КГ-1'), (29, 'КГ-2'), (30, 'КГ-4');


INSERT INTO cellulose_layer (cellulose_layer_id, cellulose_layer) VALUES
  (1, 'нет'), (2, 'внутренний'), (3, 'наружный'), (4, 'оба');


INSERT INTO face_layer (face_layer_id, face_layer) VALUES
  (1, 'Белый'), (2, 'Бурый'), (3, 'Крашеный'), (4, 'НМ'), (5, 'МО');


INSERT INTO inner_layer (inner_layer_id, inner_layer) VALUES
  (1, 'Белый'), (2, 'Бурый'), (3, 'Крашеный'), (4, 'НМ'), (5, 'МО');


INSERT INTO connection_valve (connection_valve_id, connection_valve) VALUES
  (1, 'склееный'), (2, 'сшитый'), (3, 'склееный+сшитый');


INSERT INTO workability (workability_id, service_center, group_priority, element_priority) VALUES
    (1, 'АГ', NULL, NULL),
    (2, 'Тайванец', 10, 10),
    (3, 'Болгарец', 10, 20),
    (4, 'Сшивка ручная', 20, 10),
    (5, 'Сшивка автомат', 20, 20),
    (6, 'Склейка ручная', 30, 10),
    (7, 'Склейка 3 точки', 30, 20),
    (8, 'БОБСТ', 40, NULL),
    (9, 'Ротация', 50, NULL),
    (10, 'Тигель большой', 60, 10),
    (11, 'Тигель малый', 60, 20),
    (12, 'Ролевый', 60, 30),
    (13, 'К. Р.', 70, NULL),
    (14, 'БОИКС', 80, NULL),
    (15, 'Перегородки', 90, NULL),
    (16, 'Упаковка', 100, NULL)
;


INSERT INTO packing (packing_id, packing) VALUES
  (1, 'Без упаковки'),
  (2, 'Паллета, лента, стрейч'),
  (3, 'Паллета, лента, без стрейча'),
  (4, 'Паллета, стрейч, без ленты'),
  (5, '2 пака на паллете');


INSERT INTO pallet (pallet_id, pallet) VALUES
  (1, '1200х800'), (2, '1200х1000');


INSERT INTO pallet_placement (pallet_placement_id, pallet_placement) VALUES
  (1, '1 пачка в ряду'), (2, '2 пачки в ряду'), (3, '3 пачки в ряду'),
  (4, '4 пачки в ряду'), (5, '5 пачек в ряду'), (6, '6 пачек в ряду'), (7, '8 пачек в ряду');

INSERT INTO product (product_id, product_number, isNew, product_type_id, inner_height,
                     inner_length, inner_width, cardboard_brand_id, client_id,
                     face_layer_id, inner_layer_id, profile_id, cliche, blank_format)
VALUES
  (1, 1, true, 4, 340, 220, 410, 11, 2, 1, 2, 6, 'Lasunka', 4),
  (2, 2, true, 5, 350, 210, 450, 4, 3, 2, 1, 3, 'Petruschenko', 5),
  (3, 1800, false, 1, 310, 350, 210, 2, 2, 4, 3, 3, 'Lasunka', 7),
  (4, 1645, false, 1, 310, 360, 210, 7, 1, 5, 2, 4, 'ABK', 8),
  (5, 3, true, 3, 310, 350, 210, 7, 2, 1, 5, 2, 'Lasunka', 9),
  (6, 4, true, 15, 310, 350, 210, 3, 3, 1, 5, 2, 'ABK', 9);


COMMIT;