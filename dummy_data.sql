
INSERT INTO `invoice_system`.`item` (`id`, `barcode`, `name`, `price`) VALUES ('1', '4198718457', 'test_item1', '12');
INSERT INTO `invoice_system`.`item` (`id`, `barcode`, `name`, `price`) VALUES ('2', '949641657', 'test_item_2', '15');
INSERT INTO `invoice_system`.`item` (`id`, `barcode`, `name`, `price`) VALUES ('3', '64984615', 'test_item_3', '54');
INSERT INTO `invoice_system`.`item` (`id`, `barcode`, `name`, `price`) VALUES ('4', '8641614', 'test_item_4', '77');

INSERT INTO `invoice_system`.`employee` (`dtype`, `id`, `email`, `first_name`, `last_name`, `password`, `phone`, `ssn`, `contract_years`, `salary`) VALUES ('SalariedEmployee', '1', 'test@t.com', 'test1', 'test1', 'pass1', '78412', '8561646851', '2.5', '8000');
INSERT INTO `invoice_system`.`employee` (`dtype`, `id`, `email`, `first_name`, `last_name`, `password`, `phone`, `ssn`, `rate`, `shift`) VALUES ('HourlyEmployee', '2', 'tex@ve.com', 'test2', 'test2', 'oasd2', '846814', '2165184', '20', '0');

INSERT INTO `invoice_system`.`customer` (`id`, `address`, `email`, `name`) VALUES ('1', 'add1', 'adeg@wrbv.vo', 'test_cust1');
INSERT INTO `invoice_system`.`customer` (`id`, `address`, `email`, `name`) VALUES ('2', 'add2', 'afe@sv.com', 'test_cust2');






