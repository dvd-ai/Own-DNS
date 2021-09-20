insert into category(name)
values
('Бытовая техника'),
('Смартфоны и гаджеты'),
('ТВ и мультимедиа'),
       ('Компьютеры'),
       ('Офис и сеть');
insert into seller(name)
values ('dns_shop');
insert into product(article, price, seller_id, category_id,description)
values
    (00149901, 7499, 1,1,'Холодильник компактный DEXP TF050D, серебристый'),
    (00299901, 7999, 1, 1, 'Холодильник компактный DEXP RF-SD050RMA, белый'),
    (00399901, 17999,1,1, 'Холодильник с морозильником Pozis RK-101 белый'),
    (00429901,18299,1,1,'Холодильник с морозильником Бирюса 122, белый'),
    (00529901,18299,1,1,'Холодильник компактный Hansa FM1337.3PAA, розовый'),
    (00629901,14299,1,1,'Стиральная машина Beko WRS 44P1 BWW, белая'),
    (00784901,14848,1,1,'Стиральная машина Indesit BWSB, белая'),
    (00809901,15099,1,1,'Стиральная машина Vestfrost VFWM, серая'),
    (00999901,16999,1,1,'Стиральная машина DEXP WM-F610DMA, серая'),
    (01099901,16999,1,1,'Стиральная машина indesit IWUD 4085, белая'),
    (01139901,17399,1,1,'Стиральная машина Winia WMD-S610, бежевая'),
    (01299901,8999,1,1,'Электрическая плита Мечта-15М, белая'),
    (01399901,9999,1,1,'Электрическая плита Мечта- 221Ч, белая'),
    (01449901,14499,1,1,'Электричесая плита Darina E 3404W, белая'),
    (01559901,14599,1,1,'Электрическая плита Artel Comarella 50 00E, белая'),
    (01669901,14699,1,1,'Электричекская плита Gefest 5140-01, коричневая'),
    (01759901,599,1,1,'Электрочайник GOODHELPER KS-181C, красный'),
    (01859901,599,1,1,'Электрочайник IRIT-1320, серебристый'),
    (01969901,699,1,1,'Электрочайник Aceline SS1800 черный'),
    (02069901,699,1,1,'Электрочайник Dexp Dl-13St красный'),
    (02199902,2999,1,2,'Смартфон DEXP A440, белый'),
    (02299902,2999,1,2,'Смартфон DEXP A440, синий'),
    (02389902,3899,1,2,'Смартфон BQ 5031G Fun, красный'),
    (02499902,3999,1,2,'Смартфон INOI 2, черный'),
    (02599902,3999,1,2,'Смартфон Itel A17, черный'),
    (02649902,4499,1,2,'Смартфон DEXP A355, черный'),
    (02799902,4999,1,2,'Смартфон DEXP A360,черый'),
    (02849902,13543,1,2,'Смартфон Xiaomi Redmi 9T, голубой'),
    (02949902,130999,1,2,'Смартфон Vivo Y31, черный'),
    (03099902,13999,1,2,'Смартфон Tecno Pova 2 64, черный'),
    (03199902,14999,1,2,'Смартфон Quikitel F150 Buson, черный'),
    (03204903,23049,1,3,'Ноутбук HP Laptop 14s - fq00084ur,черный'),
    (03389903,27899,1,4,'Ноутбук HP Laptop 15s, черный'),
(03499903,28999,1,4,'Ноутбук Asus Vivo Book FLip, черный'),
(03558883,39999,1,4,'Ноутбук MSI Modern 14 B10, серый'),
(03699903,44999,1,4,'Ноутбук Honor MagicBook X, серый'),
(03799903,45999,1,4,'Ноутбук Huawei MateBook D 14, серый'),
(03839903,47999,1,4,'Ноутбук Huawei MateBook D 15, серый'),
(03949903,48999,1,4,'Ноутбук HP Pavilion 14-dv00444,серебристый'),
(04099903,48999,1,4,'Ноутбук MSI Modern 15,черный'),
(04139903,49999,1,4,'Ноутбук Hiawei MateBook D14, серый'),
(04299903,54999,1,4,'Ультрабук HP Pavilion x360, черный'),
(04349903,55999,1,4,'Ультрабук HP Laptop 14s,черный'),
(04419904,8199,1,3,'Телевизор LED Starwind SW-LED22,черный'),
    (04599904,8999,1,3,'Телевизор LED Polarline 22PL12TC, черный'),
    (0469904,8999,1,3,'Телевизор LED Harper 22F470T, черный'),
    (0477904,9999,1,3,'Телевизор LED Dexp F22F7000K, черный'),
    (0489904,10999,1,3,'Телевизор LED DEXP F22F700K/w,белый'),
    (0499904,12999,1,3,'Телевизор LED Asano 32LF711T, белый'),
    (0509904,13299,1,3,'Телевизор LED Philips 24 PFS, белый'),
(0519904,13799,1,3,'Телевизор LED Asano 32LF1120T,белый'),
(0529904,11299,1,5,'МФУ лазерное HP Laser 135r, белый'),
(0534904,11499,1,5,'МФУ лазерное Pentium M6500, черный'),
(0545904,11499,1,5,'МФУ лазерное Pantium M6507, черный'),
(0556904,12199,1,5,'МФУ лазерне Pantum M6500W, черный'),
(0569904,13000,1,5,'МФУ лазерное Pantum 6502W черный'),
(0579904,12889,1,5,'МФУ лазерное Brother DCP-1510R,черный'),
(0589904,12999,1,5,'МФУ лазерное HP Laser 135a, черный'),
(0599904,13699,1,5,'МФУ лазерное Brother DCP-1623WR'),
(0609904,14099,1,5,'МФУ лазерное Brother DCP-1602R');