insert into users (login, password, nom, prenom) values ('machin.chose@gmail.com', 'password1', 'MACHIN', 'Chose');
insert into users (login, password, nom, prenom) values ('bidule.truc@gmail.com', 'password2', 'TRUC', 'Bidule');
insert into users (login, password, nom, prenom) values ('patati.patata@gmail.com', 'password3', 'PATATA', 'Patati');
insert into users (login, password, nom, prenom) values ('mea.culpa@gmail.com', 'password4', 'CULPA', 'Mea');

insert into item (id, titre, nombre_Exemplaires, date_Parution) values (1, 'Cantorix, le forgeron des dieux', 126, '2022-06-14');
insert into item (id, titre, nombre_Exemplaires, date_Parution) values (2, 'Tolkien, l’Europe et la tradition', 390, '2022-07-24');
insert into item (id, titre, nombre_Exemplaires, date_Parution) values (3, 'La Bête de Grésivaudan', 264, '2016-08-30');
insert into item (id, titre, nombre_Exemplaires, date_Parution) values (4, 'La Tribu de Dana', 100, '1998-06-07');
insert into item (id, titre, nombre_Exemplaires, date_Parution) values (5, 'Les lacs du connemara', 161, '1981-03-17');
insert into item (id, titre, nombre_Exemplaires, date_Parution) values (6, 'Etoile des neiges', 359, '1949-12-24');
insert into item (id, titre, nombre_Exemplaires, date_Parution) values (7, 'Les Douze Travaux de Astérix', 359, '1976-04-20');
insert into item (id, titre, nombre_Exemplaires, date_Parution) values (8, 'La Cité de la peur', 200, '1994-03-17');

insert into livre (id, ecrivain, numero_isbn) values (1, 'Anne-Laure Blanc, Emma La Maôve, Anna Lamblore', 13245);
insert into livre (id, ecrivain, numero_isbn) values (2, 'Armand Berger', 13645);
insert into livre (id, ecrivain, numero_isbn) values (3, 'Editions Boule de Neige', 15945);

insert into cd (id, artiste_groupe, duree, nombre_titre) values (4, 'Manau', 60, 12);
insert into cd (id, artiste_groupe, duree, nombre_titre) values (5, 'Michel Sardou', 36, 9);
insert into cd (id, artiste_groupe, duree, nombre_titre) values (6, 'Line Renaud', 12, 4);

insert into dvd (id, realisateur, duree, type) values (7, 'René Goscinny et Albert Uderzo', 82, 'NORMAL');
insert into dvd (id, realisateur, duree, type) values (8, 'Alain Berberian', 120, 'BLUE_RAY');

insert into emprunt (numero, date_emprunt, date_retour, user_id) values (1, '2022-10-13', '2022-10-21', 1);
insert into emprunt_items (emprunts_numero, items_id) values (1, 1); 
insert into emprunt_items (emprunts_numero, items_id) values (1, 3);
