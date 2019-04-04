insert into country values (1,"India",0),(2,"USA",0),(3,"Australia",0);
insert into state values (1,"Gujarat",0,1),(2,"Maharastra",0,1),(3,"California",0,2),(4,"Texas",0,2),(5,"Austae",0,3);
insert into city values (1,"Ahmedabad",0,1),(2,"Gandhinagar",0,1),(3,"Ankleshwar",0,1),(4,"Bharuch",0,1),(5,"East Bay",0,3),(6,"San Diego",0,3),(7,"Pune",0,2),(8,"Mumbai",0,2);

insert into category values (1,"Furniture",0),(2,"Travel",0),(3,"Appliances",0),(4,"Camera & Mobile",0);
insert into sub_category values (1,"Sofa",0,1),(2,"Bed",0,1),(3,"Kitchen",0,1),(4,"Camera",0,3),(5,"TV",0,3),(6,"Fridge",0,3);

insert into city_subcategory(city,subcategory) values (1,1),(1,5),(1,6),(2,1),(2,4),(2,5),(2,6);

insert into user(id,first_name,last_name,email,password,contact_number,role,status) values(1,"Rakesh","Doshi","rdhoshi8778@gmail.com","rakd123","9898123767",1,0),(2,"Krishna","Prajapati","krishna7902@gmail.com","krish123","8866152032",0,0),(3,"Dinesh","Thakkar","dthankkar8@gmail.com","dt1992","9998412850",1,0),(4,"Dinesh","Thakkar","dthankkar8@gmail.com","dt1992","9998412850",1,0),(5,"Dinesh","Thakkar","dthankkar8@gmail.com","dt1992","9998412850",1,0),(6,"Dinesh","Thakkar","dthankkar8@gmail.com","dt1992","9998412850",1,0);
insert into address(id,house_no,street,area,landmark,pincode,alt_number,city,status,user) values(1,"C-501","Raghav residency","Naroda-Deghgam Highway","Opp. GEB",382330,"8866152032",1,0,1),(2,"A-21","Pramukh Park","Gadkhol Patiya","Zymkhana",393001,"998011754",3,0,2),(3,"D-89","Iscon ELegance","Iscon","Iscon Mall",357330,"8686120523",1,0,3),(4,"Danish Bunglows","Satelite Cross Road","Satellite","Iscon Tower",337830,"8845456690",1,0,2);

insert into item(id,name,description,sub_cat,user,deposit,status) values(1,"Red Big Sofa","This is big red sofa, unique, new product",1,2,3000,0),(2,"Sony Bravia","All new sony 52 inch with 16M pixel",5,2,10000,0),(3,"LG FLex","This is Brand new LG, get Full movie experience with 85inch",5,2,12000,0);
insert into plan_master(id,days,name,status) values (1,1,"1 Day",0),(2,2,"2 Day",0),(3,3,"3 Day",0),(4,7,"1 Week",0),(5,14,"2 Week",0),(6,21,"3 Week",0),(7,30,"1 Month",0),(8,60,"2 Month",0),(9,90,"3 Month",0),(10,120,"4 Month",0),(11,150,"5 Month",0),(12,180,"6 Month",0);
insert into plan_item(id,item,plan,quantity,price,status) values(1,1,5,1,2500,0),(2,1,7,1,3500,0),(3,1,8,1,5500,0);

insert into user_cart(id,user,item,plan_item) values (1,2,3,1),(2,2,1,3);



insert into city_sub_category values (1,1),(1,5),(1,6),(2,1),(2,4),(2,5),(2,6);