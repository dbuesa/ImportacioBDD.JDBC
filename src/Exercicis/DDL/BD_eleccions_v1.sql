DROP DATABASE IF EXISTS eleccions2016;
CREATE DATABASE IF NOT EXISTS eleccions2016;

USE eleccions2016;

CREATE TABLE IF NOT EXISTS eleccions (
	eleccio_id 			TINYINT UNSIGNED AUTO_INCREMENT,
	nom 				VARCHAR(45),
	data 				DATE NOT NULL,
	any 				YEAR GENERATED ALWAYS AS (YEAR(data)),
	mes 				TINYINT GENERATED ALWAYS AS (MONTH(data)),
  CONSTRAINT pk_eleccions PRIMARY KEY (eleccio_id),
  CONSTRAINT uk_eleccions_any_mes UNIQUE (any, mes),
  CONSTRAINT uk_eleccions_data UNIQUE (data)
  );

CREATE TABLE candidatures (
	candidatura_id 				INT UNSIGNED AUTO_INCREMENT,
	eleccio_id 					TINYINT UNSIGNED NOT NULL,
	codi_candidatura 			CHAR(6),
	nom_curt 					VARCHAR(50),
	nom_llarg 					VARCHAR(150),
	codi_acumulacio_provincia 	CHAR(6),
	codi_acumulacio_ca 			CHAR(6),
	codi_acumulacio_nacional 	CHAR(6),
    CONSTRAINT pk_candidatures PRIMARY KEY (candidatura_id),
	CONSTRAINT uk_candidatures_eleccio_candidatura UNIQUE (eleccio_id, codi_candidatura),
    CONSTRAINT fk_candidatures_partits_eleccions FOREIGN KEY (eleccio_id)
		REFERENCES eleccions(eleccio_id)
);


CREATE TABLE IF NOT EXISTS persones (
persona_id 			INT UNSIGNED AUTO_INCREMENT,
  nom 				VARCHAR(30),
  cog1 				VARCHAR(30),
  cog2 				VARCHAR(30),
  sexe 				ENUM('M', 'F') COMMENT 'M=Masculí, F=Femení',
  data_naixement 	DATE,
  dni 				CHAR(10) NOT NULL,
  CONSTRAINT pk_persones PRIMARY KEY (persona_id),
  CONSTRAINT uk_persones_dni  UNIQUE (dni)
);


CREATE TABLE IF NOT EXISTS comunitats_autonomes (
  comunitat_aut_id 		TINYINT UNSIGNED AUTO_INCREMENT,
  nom 					VARCHAR(45),
  codi_ine CHAR(2) 		NOT NULL,
  CONSTRAINT pk_comunitats_autonomes PRIMARY KEY (comunitat_aut_id),
  CONSTRAINT uk_comunitats_autonomes_codi_ine UNIQUE (codi_ine)
);


CREATE TABLE IF NOT EXISTS provincies (
  provincia_id 			TINYINT UNSIGNED AUTO_INCREMENT,
  comunitat_aut_id 		TINYINT UNSIGNED NOT NULL,
  nom 					VARCHAR(45),
  codi_ine 				CHAR(2) NOT NULL,
  num_escons 			TINYINT UNSIGNED,
  CONSTRAINT pk_provincies PRIMARY KEY (provincia_id),
  CONSTRAINT uk_provincies UNIQUE (codi_ine),
  CONSTRAINT fk_provincies_comunitat_aut_id FOREIGN KEY (comunitat_aut_id)
	REFERENCES comunitats_autonomes (comunitat_aut_id)
);


CREATE TABLE IF NOT EXISTS municipis (
  municipi_id 		SMALLINT UNSIGNED AUTO_INCREMENT,
  nom 				VARCHAR(100),
  codi_ine 			CHAR(3) NOT NULL,
  provincia_id 		TINYINT UNSIGNED NOT NULL,
  districte 		CHAR(2),
  CONSTRAINT pk_municipis PRIMARY KEY (municipi_id),
  CONSTRAINT uk_municipis_codi_ine UNIQUE (codi_ine),
  CONSTRAINT fk_municipis_provincia_id FOREIGN KEY (provincia_id)
      REFERENCES provincies (provincia_id)
);


CREATE TABLE IF NOT EXISTS eleccions_municipis (
  eleccio_id 		TINYINT UNSIGNED NOT NULL,
  municipi_id 		SMALLINT UNSIGNED NOT NULL,
  num_meses 		SMALLINT UNSIGNED,
  cens 				INT UNSIGNED,
  vots_emesos 		INT UNSIGNED,
  vots_valids 		INT UNSIGNED,
  vots_candidatures INT UNSIGNED,
  vots_blanc 		INT UNSIGNED NULL,
  vots_nuls 		INT UNSIGNED NULL,
  CONSTRAINT uk_eleccions_municipis_eleccio_municipi UNIQUE (eleccio_id, municipi_id),
  CONSTRAINT pk_eleccions_municipis PRIMARY KEY (eleccio_id,municipi_id),
  CONSTRAINT fk_eleccions_municipis_municipis FOREIGN KEY (municipi_id)
    REFERENCES municipis(municipi_id),
  CONSTRAINT fk_eleccions_municipis_eleccions FOREIGN KEY (eleccio_id)
    REFERENCES eleccions(eleccio_id)
    );
    

    
CREATE TABLE IF NOT EXISTS vots_candidatures_mun (
  eleccio_id 		TINYINT UNSIGNED NOT NULL,
  municipi_id 		SMALLINT UNSIGNED NOT NULL,
  candidatura_id 	INT UNSIGNED NOT NULL,
  vots 				INT UNSIGNED,
  CONSTRAINT pk_vots_candidatures_mun PRIMARY KEY(eleccio_id, municipi_id, candidatura_id),
  CONSTRAINT fk_candidatures_municipis_candidatures FOREIGN KEY (candidatura_id)
    REFERENCES candidatures(candidatura_id),
  CONSTRAINT fk_candidatures_municipis_eleccions_municipis FOREIGN KEY (eleccio_id, municipi_id)
    REFERENCES eleccions_municipis (eleccio_id , municipi_id)
);


CREATE TABLE IF NOT EXISTS vots_candidatures_prov (
  provincia_id 				TINYINT UNSIGNED NOT NULL,
  candidatura_id 			INT UNSIGNED NOT NULL,
  vots 						INT UNSIGNED,
  candidats_obtinguts 		SMALLINT UNSIGNED,
  CONSTRAINT pk_const_candidatures_prov PRIMARY KEY (provincia_id, candidatura_id),
  CONSTRAINT fk_vots_candidatures_prov_provincia_id FOREIGN KEY (provincia_id)
    REFERENCES provincies (provincia_id),
  CONSTRAINT fk_vots_candidatures_prov_candidatura_id FOREIGN KEY (candidatura_id)
    REFERENCES candidatures (candidatura_id)
);


CREATE TABLE IF NOT EXISTS vots_candidatures_ca (
  comunitat_autonoma_id 	TINYINT UNSIGNED NOT NULL,
  candidatura_id 			INT UNSIGNED NOT NULL,
  vots 						INT UNSIGNED,
  CONSTRAINT pk_vots_candidatures_com_aut PRIMARY KEY (comunitat_autonoma_id,candidatura_id),
  CONSTRAINT fk_vots_candidatures_com_aut_comunitat_autonoma FOREIGN KEY (comunitat_autonoma_id)
    REFERENCES comunitats_autonomes (comunitat_aut_id),
  CONSTRAINT fk_vote_candidatures_com_aut_candidatures FOREIGN KEY (candidatura_id)
    REFERENCES candidatures (candidatura_id)
);


CREATE TABLE IF NOT EXISTS candidats (
  candidat_id 			BIGINT UNSIGNED AUTO_INCREMENT,
  candidatura_id 		INT UNSIGNED NOT NULL,
  persona_id 			INT UNSIGNED NOT NULL,
  provincia_id 			TINYINT UNSIGNED NOT NULL,
  num_ordre 			TINYINT,
  tipus 				ENUM('T', 'S'),
  CONSTRAINT pk_candidats_candidat_id PRIMARY KEY (candidat_id),
  CONSTRAINT fk_candidats_candidatura_id FOREIGN KEY (candidatura_id)
	REFERENCES candidatures (candidatura_id),
  CONSTRAINT fk_candidats_persona_id FOREIGN KEY (persona_id) 
	REFERENCES persones (persona_id),
  CONSTRAINT fk_candidats_provincia_id FOREIGN KEY (provincia_id)
	REFERENCES provincies (provincia_id)
);