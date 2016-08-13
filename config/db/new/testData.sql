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


INSERT INTO cellulose_layer (cellulose_layer) VALUES ('нет');
INSERT INTO cellulose_layer (cellulose_layer) VALUES ('внутренний');
INSERT INTO cellulose_layer (cellulose_layer) VALUES ('наружный');
INSERT INTO cellulose_layer (cellulose_layer) VALUES ('оба');


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


INSERT INTO workability (service_center) VALUES ('Тайванец');
INSERT INTO workability (service_center) VALUES ('Упаковка');


INSERT INTO packing (packing) VALUES ('Без упаковки');
INSERT INTO packing (packing) VALUES ('Паллета, лента, стрейч');
INSERT INTO packing (packing) VALUES ('Паллета, лента, без стрейча');
INSERT INTO packing (packing) VALUES ('Паллета, стрейч, без ленты');
INSERT INTO packing (packing) VALUES ('2 пака на паллете');


INSERT INTO pallet (pallet) VALUES ('1200х800');
INSERT INTO pallet (pallet) VALUES ('1200х1000');


INSERT INTO pallet_placement (pallet_placement) VALUES ('1 пачка в ряду');
INSERT INTO pallet_placement (pallet_placement) VALUES ('2 пачки в ряду');
INSERT INTO pallet_placement (pallet_placement) VALUES ('3 пачки в ряду');
INSERT INTO pallet_placement (pallet_placement) VALUES ('4 пачки в ряду');
INSERT INTO pallet_placement (pallet_placement) VALUES ('5 пачек в ряду');
INSERT INTO pallet_placement (pallet_placement) VALUES ('6 пачек в ряду');
INSERT INTO pallet_placement (pallet_placement) VALUES ('8 пачек в ряду');


INSERT INTO product (product_number,
                     isNew,
                     product_create,
                     product_update,
                     person_prepared,
                     isUse,
                     client_id,
                     product_name,
                     product_type_id,
                     inner_length,
                     inner_width,
                     inner_height,
                     theoretical_square,
                     actual_square,
                     format_id,
                     profile_id,
                     cardboard_brand_id,
                     cellulose_layer_id,
                     face_layer_id,
                     inner_layer_id,
                     size_workpiece_length,
                     size_workpiece_width,
                     number_from_sheet,
                     blank_format,
                     connection_valve_id,
                     packing_id,
                     number_in_pack,
                     number_in_transport_package,
                     package_length,
                     package_width,
                     package_height,
                     pallet_id,
                     pallet_placement_id,
                     pallet_rows
)
VALUES (34,TRUE,SYSDATE(),SYSDATE(),'Person_1', TRUE, 1, '329*292*210',
           1, 392, 292, 210,0.724, 0.720,1,1,1,1,1,1,1415,512,1,512,1,1,20, 560, 1392,1032,1140,1,1,7);




COMMIT;