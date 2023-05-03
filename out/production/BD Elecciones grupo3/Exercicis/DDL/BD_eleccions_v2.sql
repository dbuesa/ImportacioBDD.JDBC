USE eleccions2016;

-- MODIFICACIONS A LA TAULA PERSONES PER BORRAR COLUMNES EN BLANC I MODIFICAR EL DNI

ALTER TABLE persones
    DROP INDEX uk_persones_dni,
    MODIFY COLUMN dni CHAR(8) NOT NULL,
    DROP COLUMN sexe,
    DROP COLUMN data_naixement,
    ADD CONSTRAINT uk_persones_dni UNIQUE(dni);


-- BORREM LA UK QUE VE PER DEFECTE I LA TORNEM A CREAR

ALTER TABLE municipis
    DROP INDEX uk_municipis_codi_ine,
    ADD CONSTRAINT uk_municipis_codi_ine_provincia_districte UNIQUE (codi_ine, provincia_id, districte);

-- CANVIEM ELS CAMPS DE VOTS VALIDS I VOTS EMESOS PERQUÈ SIGUIN GENERATS

ALTER TABLE eleccions_municipis
	DROP COLUMN vots_valids,
    DROP COLUMN vots_emesos,
    ADD COLUMN vots_emesos INT UNSIGNED GENERATED ALWAYS AS (vots_candidatures + vots_blanc + vots_nuls)
    AFTER cens,
    ADD COLUMN vots_valids INT UNSIGNED GENERATED ALWAYS AS (vots_candidatures + vots_blanc)
    AFTER vots_emesos;