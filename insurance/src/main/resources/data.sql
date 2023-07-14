DROP TABLE IF EXISTS insurance;
CREATE TABLE insurance(
insurance_id INT AUTO_INCREMENT PRIMARY KEY,
customer_id INT NOT NULL,
insurance_type VARCHAR(200) NOT NULL,
insured_amount BIGINT NOT NULL,
insured_end_date DATE DEFAULT NULL
);
insert into `insurance`(`customer_id`,`insurance_type`,`insured_amount`,`insured_end_date`) 
values(1,'VEHICLE INSURANCE',99000,curdate()+365);

insert into `insurance`(`customer_id`,`insurance_type`,`insured_amount`,`insured_end_date`)
values(2,'HOME INSURANCE',55700,curdate()+1000);

insert into `insurance`(`customer_id`,`insurance_type`,`insured_amount`,`insured_end_date`)
values(3,'HEALTH INSURANCE',45800,curdate()+100);

insert into `insurance`(`customer_id`,`insurance_type`,`insured_amount`,`insured_end_date`)
values(4,'TRAVEL INSURANCE',359000,curdate()+200);

