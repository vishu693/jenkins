
create table inventory (inventory_id integer not null, inventory_name varchar(255), available integer, consumed integer, primary key (inventory_id));

insert into inventory(inventory_id,inventory_name,available,consumed) values(20001,'jeans',2,0);
insert into inventory(inventory_id,inventory_name,available,consumed) values(30001,'shirt',2,0);
