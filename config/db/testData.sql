INSERT INTO client (client_id, company_name, phone_number) VALUES
  (1, 'АВК', '+38050-355-62-78'),
  (2, 'Ласунка', '+38066-355-62-78'),
  (3, 'Петрушенко', '+38067-355-62-78');


INSERT INTO product_type (product_type_id, product_type) VALUES
  (1, 'Ящик (4 клапана)'),
  (2, 'Ящик сложный'),
  (3, 'Ящик (крышка)'),
  (4, 'Ящик (дно)'),
  (5, 'Лоток'),
  (6, 'Трейс'),
  (7, 'Лист'),
  (8, 'Перегородка'),
  (9, 'Прокладка'),
  (10, 'Уголок'),
  (11, 'Двухслойка рулон'),
  (12, 'Комплектация'),
  (13, 'Вкладыш'),
  (14, 'Комплект'),
  (15, 'Шоубокс'),
  (16, 'Гофрозаготовка'),
  (17, 'Лист необрезной');


INSERT INTO format (format_id, format) VALUES
  (1, '1050'), (2, '1250'), (3, '1400'), (4, '1510');


INSERT INTO profile (profile_id, profile) VALUES
  (1, 'В'), (2, 'Е'), (3, 'С'), (4, 'ВЕ'), (5, 'ВС'), (6, 'СЕ');


INSERT INTO cardboard_brand (cardboard_brand_id, cardboard_brand) VALUES
  (1, 'КГ-4'), (2, 'КГ-2'), (3, 'КГ-1'), (4, 'Т-21'), (5, 'Т-22'),
  (6, 'Т-23'), (7, 'Т-24'), (8, 'Т-25'), (9, 'Т-26'), (10, 'Т-27'),
  (11, 'П-31'), (12, 'П-32'), (13, 'П-33'), (14, 'П-34'), (15, 'П-35'),
  (16, 'П-36'), (17, 'Д-21'), (18, 'Д-22');


INSERT INTO cellulose_layer (cellulose_layer_id, cellulose_layer) VALUES
  (1, 'нет'), (2, 'внутренний'), (3, 'наружный'), (4, 'оба');


INSERT INTO face_layer (face_layer_id, face_layer) VALUES
  (1, 'Белый'), (2, 'Бурый'), (3, 'Крашеный'), (4, 'НМ'), (5, 'МО');


INSERT INTO inner_layer (inner_layer_id, inner_layer) VALUES
  (1, 'Белый'), (2, 'Бурый'), (3, 'Крашеный'), (4, 'НМ'), (5, 'МО');


INSERT INTO connection_valve (connection_valve_id, connection_valve) VALUES
  (1, 'склееный'), (2, 'сшитый'), (3, 'склееный+сшитый');


INSERT INTO producibility (producibility_id, service_center, group_priority, element_priority) VALUES
    (1, 'АГ', 0, NULL),
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


INSERT INTO bigovki_deltas (bigovki_deltas_id, profile_id, delta_1, delta_2, delta_3) VALUES
    (1, 2, 1.5, 2, 1.5),
    (2, 1, 3, 4, 3),
    (3, 3, 3, 4, 3),
    (4, 4, 5, 6, 5),
    (5, 6, 5, 6, 5),
    (6, 5, 5, 8, 5)
;

INSERT INTO perforation_deltas (perforation_deltas_id, profile_id, delta_1, delta_2, delta_3, delta_4) VALUES
    (1, 1, 2, 4, 4, 2),
    (2, 3, 2, 4, 4, 2),
    (3, 2, 2, 4, 4, 2),
    (4, 5, 4, 8, 8, 4),
    (5, 4, 3, 6, 6, 3),
    (6, 6, 3, 6, 6, 3)
;


COMMIT;