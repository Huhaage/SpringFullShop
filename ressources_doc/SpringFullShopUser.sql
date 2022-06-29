-- ------------------------------------------------------------------------------
-- - Gestion droit d'accès                                   ---
-- ------------------------------------------------------------------------------

USE Springfullshop;

-- -----------------------------------------------------------------------------
-- - Construction de la table des users                              ---
-- -----------------------------------------------------------------------------

INSERT INTO users(mail, password, active) VALUES( 'Neo@free.fr',	'$2a$12$/YP2ojX0Wyau9vAf/SDKouiwXjgbtSGuPkmtUZwcPkqlfJZyMxuY.',1 );
INSERT INTO users(mail, password, active) VALUES('SarahLune@yahoo.fr',	'$2a$12$iqh83MITMAoCm2ClTNRWmO6RNyxh6pct0jiWEJfKEcgixlcTbz/R2',1 );
INSERT INTO users(mail, password, active) VALUES('Jcd@yahoo.fr',	'$2a$12$PH3aXWZVDeOv/2Um1uR.RO3WIbef8i0RFfatk2FZ5jp046P5Y52HC',1 );
INSERT INTO users(mail, password, active) VALUES('Christoof@yahoo.fr',	'$2a$12$PvZ8YzeD8yTllRW4ByiBDOG/3m/8VbyyHDFwh5Spii66jPHwej0KC',1 );
INSERT INTO users(mail, password, active) VALUES('Huhaage@yahoo.fr',	'$2a$12$OXiUDm/wn3sMEU66Kk/kUekqT/HTUPemtsDTPOEJkRXNAIkA02RHO',1 );

SELECT * FROM user;

-- -----------------------------------------------------------------------------
-- - Construction de la table avec 2 roles principaux                       ---
-- -----------------------------------------------------------------------------
	

INSERT INTO role ( role ) VALUES ( 'ADMIN' );
INSERT INTO role ( role ) VALUES ( 'USER' );


SELECT * FROM role;
-- -----------------------------------------------------------------------------
-- - Construction de la table des roles par user         -- -
-- -----------------------------------------------------------------------------


INSERT INTO user_role(users_id, role_id) VALUES('1', '1');
INSERT INTO user_role(users_id, role_id) VALUES('1', '2');
INSERT INTO user_role(users_id, role_id) VALUES('2', '2');
INSERT INTO user_role(users_id, role_id) VALUES('3', '2');
INSERT INTO user_role(users_id, role_id) VALUES('4', '2');
INSERT INTO user_role(users_id, role_id) VALUES('5', '2');

SELECT * FROM user_role;